import re
import os
import glob

# BEGIN CLASS SEPolicy
class SEPolicy:
  def __init__(self,typename,strip):
    self.__typename = typename
    self.__strip = strip
    self.__search = f"(?<=[(: ])(?:[^(: ]+[-_])?{typename}(?:[-_][^): ]+)?(?=[): ])"     # Searching for the exact typename or with the underscore as the delimiter
    self.__attributes = []
    self.__properties = []
    self.__services = []
    self.__hwservices = []
    self.__genfs = []
    self.__files = []
    self.__types = {}
    self.__transitions = []
    self.__rules = []
    self.__foreigns = []
    self.__remainings = []
    self.__daemon = ""
    self.__binder = ""
    self.__hwbinder = ""
  
  def parseLine(self,line,context):
    if line.startswith("#"):
      return
    if re.search(self.__search,line) == None:
      return
    cleanLine = line.strip()
    if self.__strip: 
      cleanLine = re.sub("(?:_[0-9]{1,2})*(?=[)_ ])","",cleanLine)                       # Stripping the api version part if exists
    if context == "file":                                                                # Parse the information according to the context (filename)
      self.__fillFile(cleanLine)
    elif context == "hwservice":
      self.__fillHWService(cleanLine)
    elif context == "property":
      self.__fillProperty(cleanLine)
    elif context == "sepolicy":
      self.__fillSEPolicy(cleanLine)
    elif context == "service":
      self.__fillService(cleanLine)
    else:
      self.__remainings.append(cleanLine)
  
  def optimize(self):
    self.__attributes = sorted(list(dict.fromkeys(self.__attributes)))                   # Optimize all lists and remove duplicates
    self.__properties = sorted(list(dict.fromkeys(self.__properties)))
    self.__services = sorted(list(dict.fromkeys(self.__services)))
    self.__hwservices = sorted(list(dict.fromkeys(self.__hwservices)))
    self.__genfs = sorted(list(dict.fromkeys(self.__genfs)))
    self.__files = sorted(list(dict.fromkeys(self.__files)))
    self.__transitions = sorted(list(dict.fromkeys(self.__transitions)))
    self.__rules = sorted(list(dict.fromkeys(self.__rules)))
    self.__remainings = sorted(list(dict.fromkeys(self.__remainings)))
    self.__foreigns = sorted(list(dict.fromkeys(self.__foreigns)))
    for key in self.__types:                                                             # Same goes for the typeattributes
      self.__types[key] = sorted(list(dict.fromkeys(self.__types[key])))
    self.__optimize_domain();
    self.__optimize_binder();
    self.__optimize_hwbinder();
    
  def __optimize_domain(self):  
    index_foreigns = []
    try:                                                                                 # Try to find all parts of the "init_daemon" macro ...
      index_transition = self.__transitions.index(f"type_transition init {self.__typename}_exec:process {self.__typename};")
      index_foreigns.append(self.__foreigns.index(f"allow init {self.__typename}_exec:file {{read getattr map execute open}};"))
      index_foreigns.append(self.__foreigns.index(f"allow init {self.__typename}:process {{transition}};"))
      index_rules = self.__rules.index(f"allow {self.__typename} {self.__typename}_exec:file {{read getattr map execute entrypoint open}};")
      index_foreigns.append(self.__foreigns.index(f"dontaudit init {self.__typename}:process {{noatsecure}};"))
      index_foreigns.append(self.__foreigns.index(f"allow init {self.__typename}:process {{siginh rlimitinh}};"))
      self.__rules.pop(index_rules)                                                      # ... and combine them ...
      self.__transitions.pop(index_transition)
      index_foreigns = sorted(index_foreigns,reverse=True)
      for index in index_foreigns: 
        self.__foreigns.pop(index)                                                  
      self.__daemon = f"init_daemon_domain({self.__typename});"                          # ... into the macro itself
    except ValueError:
      self.__daemon = ""

  def __optimize_binder(self):  
    index_foreigns = []
    try:                                                                                 # Try to find all parts of the "binder_use" macro ...
      index_rules = self.__rules.index(f"allow {self.__typename} servicemanager:binder {{call transfer}};")
      try:
        index_foreigns.append(self.__foreigns.index(f"allow servicemanager {self.__typename}:binder {{call transfer}};"))
      except ValueError:
        pass
      index_foreigns.append(self.__foreigns.index(f"allow servicemanager {self.__typename}:dir {{search}};"))
      index_foreigns.append(self.__foreigns.index(f"allow servicemanager {self.__typename}:file {{read open}};"))
      index_foreigns.append(self.__foreigns.index(f"allow servicemanager {self.__typename}:process {{getattr}};"))
      self.__rules.pop(index_rules)                                                      # ... and combine them ...
      index_foreigns = sorted(index_foreigns,reverse=True)
      for index in index_foreigns: 
        self.__foreigns.pop(index)                                                  
      self.__binder = f"binder_use({self.__typename});"                                  # ... into the macro itself
    except ValueError:
      self.__binder = ""

  def __optimize_hwbinder(self):  
    index_foreigns = []
    try:                                                                                 # Try to find all parts of the "hwbinder_use" macro ...
      index_rules = self.__rules.index(f"allow {self.__typename} hwservicemanager:binder {{call transfer}};")
      try:
        index_foreigns.append(self.__foreigns.index(f"allow hwservicemanager {self.__typename}:binder {{call transfer}};"))
      except ValueError:
        pass
      index_foreigns.append(self.__foreigns.index(f"allow hwservicemanager {self.__typename}:dir {{search}};"))
      try:
        index_foreigns.append(self.__foreigns.index(f"allow hwservicemanager {self.__typename}:file {{read open map}};"))
      except ValueError:
        index_foreigns.append(self.__foreigns.index(f"allow hwservicemanager {self.__typename}:file {{read map open}};"))
      index_foreigns.append(self.__foreigns.index(f"allow hwservicemanager {self.__typename}:process {{getattr}};"))
      self.__rules.pop(index_rules)                                                      # ... and combine them ...
      index_foreigns = sorted(index_foreigns,reverse=True)
      for index in index_foreigns: 
        self.__foreigns.pop(index)                                                  
      self.__hwbinder = f"hwbinder_use({self.__typename});"                              # ... into the macro itself
    except ValueError:
      self.__hwbinder = ""
      
  def outputFile(self,path):
    file = open(path+self.__typename+".te","wt")                                         # Output everything into one big *.te file per type
    self.__outputArrayTitled(file,self.__attributes,"ATTRIBUTES")
    self.__outputArrayTitled(file,self.__files,"FILES")
    self.__outputArrayTitled(file,self.__properties,"PROPERTIES")
    self.__outputArrayTitled(file,self.__services,"SERIVCES")
    self.__outputArrayTitled(file,self.__hwservices,"HWSERIVCES")
    self.__outputArrayTitled(file,self.__genfs,"GENFS")
    self.__outputPolicies(file,"POLICIES")
    self.__outputArrayTitled(file,self.__remainings,"REMAININGS")
    self.__outputArrayTitled(file,self.__foreigns,"FOREIGNS")
    file.close()      
  
  def __fillFile(self,line):
    self.__files.append(self.__parseObject(line))
  
  def __fillHWService(self,line):
    self.__hwservices.append(self.__parseObject(line))

  def __fillProperty(self,line):
    self.__properties.append(self.__parseObject(line))

  def __fillSEPolicy(self,line):
    if line.startswith("(type "):                                                        # Decide the treatment according to the first command in the line 
      return
    elif line.startswith("(roletype "):
      return
    elif line.startswith("(typeattributeset "):
      self.__fillType(line)
    elif line.startswith("(typeattribute "):
      self.__attributes.append(self.__parseAttribute(line))
    elif line.startswith("(typetransition "):
      self.__transitions.append(self.__parseTransition(line))
    elif line.startswith("(genfscon "):
      self.__genfs.append(self.__parseGenFS(line))
    elif line.startswith("(allow "):
      self.__fillRule(line)
    elif line.startswith("(dontaudit "):
      self.__fillRule(line)
    elif line.startswith("(auditallow "):
      self.__fillRule(line)
    elif line.startswith("(neverallow "):
      self.__fillRule(line)
    elif line.startswith("(allowx "):
      self.__fillRuleX(line)
    else:
      self.__remainings.append(line)
    
  def __fillService(self,line):
    self.__services.append(self.__parseObject(line))
    
  def __parseObject(self,line):
    search = "u:object_r:"                                                               # Search for the secontext to split
    result = line.split(search)
    if len(result) != 2:
      print("Line is in wrong format: "+line)
      return line
    return f"{result[0].strip().ljust(99)} {search}{result[1]}"                          # Indent the secontext at index 100

  def __fillType(self,line):
    result = line.split(" ",2)                                                 
    if len(result) != 3:
      print("Line is in wrong format: "+line)
      return
    if result[1].startswith("base_typeattr_"):                                           # I don't know how to handle base_typeattr_ (for now) 
      return
    types = re.findall(self.__search,result[2])
    i = 0
    while i < len(types):                                                                # We need to find the actual type inside the parameter list of the attribute
      if types[i] in self.__types:
        self.__types[types[i]].append(result[1])                                         # If the type already exists we can append the attribute
      else:
        self.__types[types[i]] = [result[1]];                                            # If the type doesn't exists we need to start a new list
      i += 1

  def __parseGenFS(self,line):
    result = line.split()
    if len(result) != 8:
      print("Line is in wrong format: "+line)
      return line
    command = f"{result[0][1:]} {result[1].ljust(10)} {result[2]}"                       # Indent the output for proper readability
    context = f"{result[3][1:]}:{result[4]}:{result[5]}:{result[6][2:-1]}"               # Build the secontext
    return f"{command.ljust(99)} {context}"                                              # Indent the secontext at index 100

  def __parseAttribute(self,line):
    result = line.split()
    if len(result) != 2:
      print("Line is in wrong format: "+line)
      return line
    return f"{result[0][5:]} {result[1][:-1]};"                                          # Use the proper keyword and remove the brackets

  def __parseTransition(self,line):
    result = line.split()
    if len(result) != 5:
      print("Line is in wrong format: "+line)
      return line
    return f"{result[0][1:5]}_{result[0][5:]} {result[1]} {result[2]}:{result[3]} {result[4][:-1]};" # Format the type_transition

  def __fillRule(self,line):
    result = line.split()
    if len(result) < 5:
      print("Line is in wrong format: "+line)
      self.__rules.append(line)
      return
    command = f"{result[0][1:]} {result[1]} {result[2]}:{result[3][1:]} {{{result[4][1:]}" # Format the first part of the rule
    i = 5
    while i < len(result):                                                               # Add all the remaining parameters
      command = f"{command} {result[i]}"
      i += 1
    command = f"{command[:-3]}}};"                                                       # Close up everything
    if re.search(self.__search,f" {result[1]} ") == None:                                # Only add this ruls if it targets the current type enforcement
      self.__foreigns.append(command)
    else:
      self.__rules.append(command)

  def __fillRuleX(self,line):
    result = line.split()
    if len(result) < 6:
      print("Line is in wrong format: "+line)
      self.__rules.append(line)
      return
    command = f"{result[0][1:]}perm {result[1]} {result[2]}:{result[4]} {result[3][1:]} {{" # Extended rules add a "perm" to their name
    i = 5
    r = False
    while i < len(result):                                                               # Add all the remaining parameters 
      if "range" in result[i]:                                                           # Special treatment for ranges
        i += 1                                                                           # Move to the next parameter
        r = True
      if i == 5:
        command = f"{command}{result[i][1:]} "                                           # Remove the opening bracket at the first parameter
      else:
        command = f"{command}{result[i]} "
      if r:
        i += 1                                                                           # Immediately add the second part of the range
        command = f"{command[:-1]}-{result[i][:-2]} "                                    # Ranges are defined by a "-"-sign between the values
        r = False
      i += 1
    command = f"{command[:-4]}}};"                                                       # Close up everything
    if re.search(self.__search,f" {result[1]} ") == None:                                # Only add this ruls if it targets the current type enforcement
      self.__foreigns.append(command)
    else:
      self.__rules.append(command)
    
  def __outputArrayTitled(self,file,array,title):
    if len(array) > 0:
      file.write(f"##### {title} #####"+'\n')
      self.__outputArray(file,array)

  def __outputArray(self,file,array):
    if len(array) == 0:
      return
    for line in array:
      file.write(line+'\n')
    file.write('\n')

  def __outputDictionary(self,file,dictionary):
    if len(dictionary) == 0:
      return
    texts = []
    for key in sorted(dictionary):
      text = f"type {str(key)}"
      for line in dictionary[key]:
        text = f"{text}, {line}"
      texts.append(f"{text};")
    self.__outputArray(file,sorted(texts))

  def __outputPolicies(self,file,title):
    if len(self.__types) > 0 or len(self.__transitions) > 0 or len(self.__rules) > 0:    # Output only if there is something to write
      file.write(f"##### {title} #####"+'\n')
      self.__outputDictionary(file,self.__types)
      special = False
      if len(self.__daemon) > 0:
        file.write(self.__daemon+'\n')
        special = True
      if len(self.__binder) > 0:
        file.write(self.__binder+'\n')
        special = True
      if len(self.__hwbinder) > 0:
        file.write(self.__hwbinder+'\n')
        special = True
      if special:
        file.write('\n')
      self.__outputArray(file,self.__transitions)
      self.__outputArray(file,self.__rules)
    
# END CLASS SEPolicy

# BEGIN CLASS SEFileParser
class SEFileParser:
  def __init__(self,policy):
    self.__policy = policy

  def parseFile(self,name):                                                              # Parse one file
    if "versioned" in name:
      return
    context = self.__getContext(name)
    file = open(name,"rt")
    for line in file:
       self.__policy.parseLine(line,context)
    file.close();

  def parseFolder(self,name):                                                            # Parse all files in the folder
    files = glob.glob(name)
    for file in files:
      if os.path.isfile(file):
        self.parseFile(file)
        
  def __getContext(self,name):                                                           # Decide the context according to the file
    if "file" in name:
      return "file"
    elif "hwservice" in name:
      return "hwservice"
    elif "service" in name:
      return "service"
    elif "property" in name:
      return "property"
    else:
      return "sepolicy" 

# END CLASS SEFileParser
