How to install LineageOS 17.1 for the Unihertz Atom L and XL
=================================================

## Getting adb and fastboot

### Linux or MacOS

If you are using a Linux or a similar operating system on your PC or Mac chances are very high that you already have these two applications installed.
Open a terminal and exectute the following commands.

```bash
adb version
fastboot --version
```

If one or both of these output an error you need to (re-)install adb and fastboot.

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

### Windows

Download [the latest version of adb and fastboot](https://dl.google.com/android/repository/platform-tools-latest-windows.zip) to a directory of your choice and extract the archive. 

## Unlocking

To be able to install anything on the Unihertz Atom L or XL we first need to unlock the bootloader.

1. Boot your device into the official OS.
2. Go to `Settings > About phone`, tap the "build number" several times to enable developer settings.
3. Go to `Settings > System > Developer Settings`, enable OEM unlocking and ADB debugging.
4. Connect your phone to your PC and open a terminal or a command line window.
5. Run `adb reboot bootloader` on your PC (there is no way to enter bootloader directly, only possible through adb).
6. Once your device has finished booting run `fastboot flashing unlock` and comfirm unlock on device (**THIS WILL WIPE ALL DATA!**).
6. Run `fastboot reboot` to reboot your device and now you should see an unlocked warning during boot screen.

## Disabling AVB (Android Verified Boot)

To get LineageOS to boot proberly we also need to disable AV. Otherwise the bootloader will check the ROM with the wrong authorization keys and prevent the loading.

- [Atom L Releases](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_L/releases)
- [Atom XL Releases](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_XL/releases)

1. Download `vbmeta.img` from the latest release page of your device.
2. Connect your phone to your PC and open a terminal or a command line window.
3. Run `adb reboot bootloader` on your PC to put your device in bootloader mode.
4. Once your device has finished booting run `fastboot flash --disable-verification --disable-verity vbmeta vbmeta.img`.
5. Then run `fastboot flash --disable-verification --disable-verity vbmeta_system vbmeta.img`.
6. Also run `fastboot flash --disable-verification --disable-verity vbmeta_vendor vbmeta.img`.

## Installing TWRP recovery

- [Atom L Releases](https://github.com/ADeadTrousers/twrp_device_Unihertz_Atom_L/releases)
- [Atom XL Releases](https://github.com/ADeadTrousers/twrp_device_Unihertz_Atom_XL/releases)

1. Download `recovery.img` from the latest release page of your device.
2. Connect your phone to your PC and open a terminal or a command line window.
3. Run `adb reboot bootloader` on your PC to put your device in bootloader mode.
4. Once your device has finished booting run `fastboot flash recovery recovery.img`.
5. Run `fastboot reboot` and after the screen goes dark press volume up until you see the TWRP logo.
6. Now you need to install a new ROM because booting into stock ROM will replace TWRP with the stock recovery.

## Installing LineageOS ROM

- [Atom L Releases](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_L/releases)
- [Atom XL Releases](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_XL/releases)

1. Download `lineage-17.1-XXX-UNOFFICIAL-YYY-signed.zip` from the latest release page of your device.
2. Connect your phone to your PC and open a terminal or a command line window.
3. Run `adb reboot recovery` on your PC or simply hold volume up while turning power on to boot your device into the recovery.
4. In TWRP select `Wipe > Advanced Wipe`.
5. Tick `Dalvik / ART Cache`, `Cache`, `Data`, `Internal Storage`. 
6. Swipe the slider on the bottom to the right to confirm. (**THIS WILL WIPE ALL DATA!**)
7. Go back to the home screen and select `Advanced > ADB Sideload`.
8. Swipe the slider on the bottom to the right to confirm.
9. Run `adb sideload lineage-17.1-XXX-UNOFFICIAL-YYY.zip` from your PC.
10. Wait for the process to finish. The recovery might prompt something about verification failure, just ignore it and continue anyway.
11. (Optional) At this point, you can then sideload the latest Magisk and/or OpenGAPPS Nano at your will. Note that the size of the system partition might only be enough for the "nano" variant of OpenGAPPS. If installing Magisk / OpenGAPPS fails, you can try rebooting into recovery again in advanced menus, then try installing them again.
12. Select `Reboot System` to reboot into LineageOS and enjoy. Note that Magisk might cause your device to boot loop once or twice but it will eventually boot.
