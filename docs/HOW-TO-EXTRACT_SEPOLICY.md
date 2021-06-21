How to extract sepolicies from the Unihertz Jelly2
=================================================

### Why would you even do that?

At first a little bit of warning:
I'm not sure if this is the right approach to get everything selinux-wise in order but at least at the time of me writing these lines it gave me a pretty good look into the depths of the system and how everything interconnects.

### Where do I get the stock files from?

First follow [the instructions to extract and mount the stock rom files](HOW-TO-EXTRACT_FILES.md).
The sepolicies are stored in two folders inside the extracted strock rom: `system/etc/sepolicy` and `system/vendor/etc/sepolicies`.

### These files look okay to me. Why can't I directly use them?

The files are in a combined and somewhat precompiled state.
Therefore one is forced to extract the parts needed and then convert it into a format that it can be reintegrated as a type enforcement (.te-file) into another build.

### But... But these files are HUGE! How do I make sure that I find everything that I need?

That's why I created a little python script to help with this tedious task.
You can find `extract_sepolicy.py`, `extract_sepolicy_plat.py` and `extract_sepolicy_vend.py` in my lineage repository in the folder `tools`.

### At first you had my curiosity. Now you have my attention. What else do I need?

First create a folder named `sepolicy` where you can find it easily.
Copy the files `extract_sepolicy.py`, `extract_sepolicy_plat.py` and `extract_sepolicy_vend.py` into this folder.
Next create another folder named `stock` inside this folder.
After that copy all files with the extension `cil` or without a file extension at all from the folders `system/etc/sepolicy` and `system/vendor/etc/sepolicies` of the extracted strock rom into the folder `stock`.
You should have the following files now:
- `plat_file_contexts`
- `plat_hwservice_contexts`
- `plat_property_contexts`
- `plat_pub_versioned.cil`
- `plat_sepolicy.cil`
- `plat_service_contexts`
- `vendor_file_contexts`
- `vendor_hwservice_contexts`
- `vendor_property_contexts`
- `vendor_sepolicy.cil`
- `vndservice_contexts`

Now you are good to go.

### But how ... ?

Glad you asked.
You need to find out what parts of the stock rom policies your device really needs.
This is best achieved by running `adb -d logcat > logcat.txt` while you use the phone or reproducing some errors that should not happen.
Next look out for lines containing `avc: denied` in the logcat file.
In those lines you will also find a `scontext` which is the thing we are looking for.
Inbetween `u:r:` and `:s0` you will find the name of the program (or better say context) that's denied access to a ressource.

Now run `python extract_sepolicy_plat.py <context_from_logcat>` an you get a file named `<context_from_logcat>.te` which includes everything there is in the stock rom regarding this context.
Normally the vendor sepolicy should not be tempered with but you can use `python extract_sepolicy_vend.py <context_from_logcat>` to get the type enforcing informations from the vendor partition.

### So I just need to include this file in my device tree and I'm goot to go?

Not so fast my dear friend.
You still need to split the file and put the individual parts into the right files of the sepolicy folder in your device tree:
- `##### ATTRIBUTES #####` goes into the file `attributes`.
- `##### FILES #####` goes into the file `file_contexts`.
- `##### PROPERTIES #####` goes into the file `property_contexts`.
- `##### SERIVCES #####` goes into the file `service_contexts`.
- `##### HWSERVICES #####` goes into the file `hwservice_contexts`.
- `##### GENFS #####` goes into the file `genfs_contexts`.
- `##### POLICIES #####` goes into a file with the extension `te` (It's on you to decide how you want to manage these files).
- `##### REMAINING #####` should not be there except somethin is found, that could not be extracted in one of the other sections.
- `##### FOREIGNS #####` only shows others contexts that point to the current context and can be ignored for now.

### Why so complicated? Why didn't you use one of the many apps to log avc:denied and then create the proper rules?

Honestly then I wouldn't have learned a thing from it.
Also these tools that you mentioned often need more than one go to find everything needed and also do a little bit too much.
Not every denial should be fixed.
