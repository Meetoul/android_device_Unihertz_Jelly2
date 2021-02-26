import sys
import os
from extract_sepolicy import SEPolicy
from extract_sepolicy import SEFileParser

# BEGIN CLASS SEPlatParser
class SEPlatParser:
  def __init__(self,typename):
    self.__typename = typename

  def parseFolder(self,folder):                                                          # Parse the whole folder
    sepolicy = SEPolicy(self.__typename,False)
    sefileparser = SEFileParser(sepolicy)
    sefileparser.parseFolder(folder+"plat_*")
    sepolicy.optimize()
    if not os.path.exists(folder[:-1]+"_plat/"):
      os.makedirs(folder[:-1]+"_plat/")
    sepolicy.outputFile(folder[:-1]+"_plat/")

# END CLASS SEPlatParser

def main():
  if len(sys.argv) != 2:
    print("Wrong parameter count")
    return
  setypeparser = SEPlatParser(sys.argv[1])
  setypeparser.parseFolder("./stock/")
  setypeparser.parseFolder("./lineage/")

if __name__ == '__main__':
    main()
