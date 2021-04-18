How to extract informations from the Unihertz Atom L and XL
=================================================

## Installing needed utilities

### Install unpack_bootimg

#### Build unpack_bootimg yourself

Make sure unpack_bootimg is build

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

make unpack_bootimg
```

unpack_bootimg will be built in

	~/android/lineage/out/host/linux-x86/bin/unpack_bootimg

#### Use a precompiled OTA tools package

Head on over to [xda-developers.com](https://forum.xda-developers.com/t/guide-ota-tools-lpunpack.4041843/) to download a complete OTA tools package and extract it to a folder of your choice.

### Install imjtool (formerly known as imgtool)

Download and install imjtool (formerly known as imgtool)

```bash
mkdir -p ~/bin
wget http://newandroidbook.com/tools/imjtool.tgz
tar -xzf imjtool.tgz -C ~/bin
```
   
## How-To to extract boot.img and recovery.img

Use unpack_bootimg extract all required infos from boot.img and recovery.img of the stock rom

```bash
./unpack_bootimg --boot_img boot.img --out boot
./unpack_bootimg --boot_img recovery.img --out recovery
```

You will get all informations required for BoardConfig.mk and a kernel, a dtb and a dtbo file (only from recovery).

## How to extract files directly from the stock rom

Download the latest ROM from [Unihertz' Google Drive](https://drive.google.com/drive/folders/0By1nhWOmuw2KdDhTUlFOZHpXQjg?sort=13&direction=a). Because these archives are different from release to release I cannot tell you exactly where to find them and how the are structured. You just need to extract the file **super.img** and put it into a folder where you could easily find it. For this example I put it into **~/unihertz**.

Now we need to extract the different images from the super.img

```bash
cd ~/unihertz
rm -rf extracted/
imjtool super.img extract
imjtool extracted/image.img extract
```
	
Next we need to mount them into the filesystem

```bash
cd ~/unihertz/extracted
mkdir -p system/
sudo mount -o loop system.img system/
sudo mount -o loop vendor.img system/vendor/
sudo mount -o loop product.img system/product
```

Now you can browse your phones filesystem and extract everything you need

To cleanup just unmout the images
	
```bash
sudo umount ~/unihertz/extracted/system/product	
sudo umount ~/unihertz/extracted/system/vendor	
sudo umount ~/unihertz/extracted/system
```
