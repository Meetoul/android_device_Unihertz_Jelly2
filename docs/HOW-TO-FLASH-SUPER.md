How to modify super.img and then flash it onto the device.
=================================================

For some reason I don't know of yet the install script won't be able to change the partition size inside `super.img`. 
When this happens the recovery will only schon an error 7 mentioning an "assert failure" with `dynamic_partitions_op_list`.
To overcome this problem you need to change the partiton layout manually on your computer and then flash the whole `super.img` back onto the device.

## Installing needed utilities

### Install brotli

First of you need brotli to uncompress the image files

```bash
sudo apt install brotli
```

### Install lpmake

Make sure lpmake is build

```bash
cd ~/android/lineage
source build/envsetup.sh

# For the Atom L EEA use
breakfast Atom_L_EEA
# For the atom XL EEA use
breakfast Atom_XL_EEA
# For the Atom L TEE use
breakfast Atom_L_TEE
# For the atom XL TEE use
breakfast Atom_XL_TEE

make lpmake
```

### Install sdat2img.py

Download sdat2img.py

```bash
mkdir -p ~/bin
cd ~/bin
wget https://raw.githubusercontent.com/xpirt/sdat2img/master/sdat2img.py
chmod 755 sdat2img.py
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

## Extracting image files from stock rom files

Follow [the instructions to extract the stock rom files](HOW-TO-EXTRACT_FILES.md) to the point where you get `system.img`, `vendor.img` and `product.img`.
For this guide we only need `vendor.img` because the other two files are provided from the LineageOS rom. 
Create the folder `~/super` and copy `vendor.img` into it.

## Extracting image files from LineageOS rom files

- [Atom L Region EEA (european union)](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_L_EEA/releases)
- [Atom XL Region EEA (european union)](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_XL_EEA/releases)
- [Atom L Region TEE (non-european union)](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_L_TEE/releases)
- [Atom XL Region TEE (non-european union)](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_XL_TEE/releases)

Download `lineage-17.1-XXX-UNOFFICIAL-YYY-signed.zip` from the latest release page of your device.
Extract the files from the zip archive into `~/super`.

Then we need to extract the brotli compressed files

```bash
brotli --decompress system.new.dat.br -o system.new.dat
brotli --decompress product.new.dat.br -o product.new.dat
```

Finally we need to create real ext4 image files for further useage

```bash
sdat2img.py system.transfer.list system.new.dat system.img
sdat2img.py product.transfer.list product.new.dat product.img
```

## (optional) Modifying system.new.dat and product.new.dat

If you want to now is the time to add or remove things from the installation file.
You just need to mount the images and do your worst.

## Creating super.img

First we need to get the exact sizes of all the image files

```bash
stat -c '%n %s' vendor.img
stat -c '%n %s' system.img
stat -c '%n %s' product.img
```

Alternativly you could also use the filesizes from the zip archive in `dynamic_partitions_op_list`. 
Theses sizes are a bit bigger so you are able to add additional components like Gapps or Magisk later on.

With these number we are now able to create the `super.img`

```bash
~/android/lineage/out/host/linux-x86/bin/lpmake \
 --metadata-size 65536 \
 --super-name super \
 --metadata-slots 1 \
 --device super:4831838208 \
 --group main:4432629760 \
 --partition system:readonly:3384295424:main --image system=./system.img \
 --partition vendor:readonly:349093888:main --image vendor=./vendor.img \
 --partition product:readonly:699240448:main --image product=./product.img \
 --sparse \
 --output ./super.img
```

Beware that the numbers in this example are not universally valid. You need to adjust them to your needs.
- `-- metadata-size`: The maximum size that partition metadata may consume. A partition entry uses 64 bytes and an extent entry uses 16 bytes. I think 65536 should work in most cases.
- `-- metadata-slots`: The number of slots available for storing metadata. This should match the number of update slots on the device, 2 for A/B devices and 1 for non-A/B.
- `-- device super`: The size of the `super` partition on the device. It must match exactly, and it must be evenly divisible by the sector size (512 bytes). Best way to get this number is from the scatter file of the stock rom archive.
- `-- group main`: The sum of all partitions files sizes.
- `-- partition`: Every partition file size with permissions(readonly) and input img file.

## Flashing super.img with TWRP recovery

1. Connect your phone to your PC and open a terminal or a command line window.
2. Run `adb reboot recovery` on your PC or simply hold volume up while turning power on to boot your device into the recovery.
3. Wait for TWRP to boot.
4. Run `adb push super.img /external_sd`.
5. In TWRP select `Install`.
6. Use `Select Storage` to switch to your SD card.
7. Use `Install Image` to switch to image installation mode.
8. Select `super.img` from the list.
9. Select `Super` partition.
10. Swipe the slider on the bottom to the right to confirm.
