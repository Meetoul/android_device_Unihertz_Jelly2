How to build LineageOS 17.1 for the Unihertz Atom L and XL
=================================================

This guide is focused on building the ROM under a Linux host environment.

## Setting up the build environment

In general follow one of the many build instructions found at the LineageOS wiki.
For example the instructions for the [Google Nexus 5 aka hammerhead](https://wiki.lineageos.org/devices/hammerhead/build).
Here is a short summing up.

### Install the build packages

To successfully build LineageOS, you’ll need

```bash
sudo apt-get install bc bison build-essential ccache curl flex g++-multilib gcc-multilib git gnupg gperf imagemagick lib32ncurses5-dev lib32readline-dev lib32z1-dev liblz4-tool libncurses5 libncurses5-dev libsdl1.2-dev libssl-dev libxml2 libxml2-utils lzop pngcrush rsync schedtool squashfs-tools xsltproc zip zlib1g-dev
```

For Ubuntu versions older than 16.04 (xenial), you’ll need

```bash
sudo apt-get install libwxgtk2.8-dev	
```

For Ubuntu versions older than 20.04 (focal), you’ll also need

```bash
sudo apt-get install libwxgtk3.0-dev
```

### Install the platform-tools

Only if you haven’t previously installed adb and fastboot

```bash
wget https://dl.google.com/android/repository/platform-tools-latest-linux.zip
unzip platform-tools-latest-linux.zip -d ~
```

Update your PATH variable for your environment

```bash
gedit ~/.profile
```
	
Add the following
	
```bash
# add Android SDK platform tools to path
if [ -d "$HOME/platform-tools" ] ; then
  PATH="$HOME/platform-tools:$PATH"
fi	
```

Then update your environment

```bash
source ~/.profile
```
	
### Install the repo command

Download the binary and make it executable

```bash
mkdir -p ~/bin
curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
chmod a+x ~/bin/repo
```
	
Update your PATH variable for your environment

```bash
gedit ~/.profile
```
	
Add the following
	
```bash
# set PATH so it includes user's private bin if it exists
if [ -d "$HOME/bin" ] ; then
  PATH="$HOME/bin:$PATH"
fi	
```

Then update your environment

```bash
source ~/.profile
```
	
### (optional) Install git-lfs for GAPPS support during build

If you want to include GAPPS in the build you need [git-lfs](https://git-lfs.github.com/) otherwise the apk's can't be downloaded.

```bash
curl -s https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | sudo bash
sudo apt-get install git-lfs
```
	
### Configure git

repo requires you to identify yourself to sync Android

```bash
git config --global user.email "you@example.com"
git config --global user.name "Your Name"
```
	
### (optional) Turn on caching to speed up build

Update your build environment

```bash
gedit ~/.bashrc	
```

Add the following
	
```bash
export USE_CCACHE=1
export CCACHE_EXEC=/usr/bin/ccache
export CCACHE_COMPRESS=1
```
	
### Initialize the LineageOS source repository

Create the project folder and download the source code

```bash
mkdir -p ~/android/lineage
cd ~/android/lineage
repo init -u https://github.com/LineageOS/android.git -b lineage-17.1
```
	
Now let's add this very device repo to the local_manifest

```bash
gedit cd ~/android/lineage/.repo/local_manifests/roomservice.xml
```
	
Add the following

```xml
<?xml version="1.0" encoding="UTF-8"?>
<manifest>
  <remove-project name="LineageOS/android_packages_apps_FMRadio"/>
  <project name="ADeadTrousers/android_device_Unihertz_Atom_LXL" path="device/Unihertz/Atom_LXL" remote="github" revision="master" />
  <!-- For the Atom L add -->
  <project name="ADeadTrousers/android_device_Unihertz_Atom_L" path="device/Unihertz/Atom_L" remote="github" revision="master" />
  <!-- For the Atom XL add -->
  <project name="ADeadTrousers/android_device_Unihertz_Atom_XL" path="device/Unihertz/Atom_XL" remote="github" revision="master" />
</manifest>
```
	
If you want to build with GAPPS included add the following to the manifest-tag

```xml
  <remote name="opengapps" fetch="https://github.com/opengapps/" />
  <remote name="opengapps-gitlab" fetch="https://gitlab.opengapps.org/opengapps/" />
  <project path="vendor/opengapps/build" name="aosp_build" revision="master" remote="opengapps" />
  <project path="vendor/opengapps/sources/all" name="all" clone-depth="1" revision="master" remote="opengapps-gitlab" />
  <!-- arm64 depends on arm -->
  <project path="vendor/opengapps/sources/arm" name="arm" clone-depth="1" revision="master" remote="opengapps-gitlab" />
  <project path="vendor/opengapps/sources/arm64" name="arm64" clone-depth="1" revision="master" remote="opengapps-gitlab" />
  <project path="vendor/opengapps/sources/x86" name="x86" clone-depth="1" revision="master" remote="opengapps-gitlab" />
  <project path="vendor/opengapps/sources/x86_64" name="x86_64" clone-depth="1" revision="master" remote="opengapps-gitlab" />
```

If you want to build with Magisk included add the following to the manifest-tag

```xml
  <project name="ADeadTrousers/android_vendor_magisk" path="vendor/magisk" remote="github" revision="master" />
```
	
To finish everything up sync the repo

```bash
cd ~/android/lineage
repo sync --force-sync
```

If you included GAPPS you also need to sync git-lfs

```bash
cd vendor/opengapps/sources
for d in ./*/ ; do (cd "$d" && git lfs pull); done
```

## (optional) Configure GAPPS for the device

If you don't want to include GAPPS at all or want to change the apps to be installed

```bash
	gedit ~/android/lineage/device/Unihertz/Atom_LXL/gapps_prop.mk
```

[Documentation of the possible settings](https://github.com/opengapps/aosp_build/blob/master/README.md)

## Extracting the vendor blobs

### Use imjtool (formerly known as imgtool) to extract from stock rom files

First follow [the instructions to extract and mount the stock rom files](HOW-TO-EXTRACT_FILES.md) 

Then extract all the files we need

```bash
# For the Atom L use
~/android/lineage/device/Unihertz/Atom_L/extract-files.sh ~/unihertz/extracted
# For the Atom XL use
~/android/lineage/device/Unihertz/Atom_XL/extract-files.sh ~/unihertz/extracted
```

### Use an allready rooted device

If you were able to root your device this is just a small step. Plug in your device and do the follwing

```bash
# For the Atom L use
~/android/lineage/device/Unihertz/Atom_L/extract-files.sh	
# For the Atom XL use
~/android/lineage/device/Unihertz/Atom_XL/extract-files.sh	
```
	
## Building the rom

Prepare the build	

```bash
cd ~/android/lineage
source build/envsetup.sh
# For the Atom L use
breakfast Atom_L
# For the Atom XL use
breakfast Atom_XL
```
	
Do the actual build
	
```bash
cd ~/android/lineage
ccache -M 50G
croot
# For the Atom L use
brunch Atom_L	
# For the Atom XL use
brunch Atom_XL	
```

## Updating the sorces (at a later time)

Make sure everything is up-to-date

```bash
cd ~/android/lineage
repo sync --force-sync
```

If you changed the settings of TWRP and GAPPS sadly you need to redo them now.

Also don't forget to sync git-lfs if you included GAPPS

```bash
cd vendor/opengapps/sources
for d in ./*/ ; do (cd "$d" && git lfs pull); done
```
