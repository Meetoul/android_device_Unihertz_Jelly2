How to update LineageOS 17.1 for the Unihertz Atom L and XL
=================================================

Every piece of software should allways kept up-to-date. Therefore even this ROM get updates from time to time and you should allways apply these to your device.

## (optional) Updating TWRP recovery

- [Atom L Releases](https://github.com/ADeadTrousers/twrp_device_Unihertz_Atom_L/releases)
- [Atom XL Releases](https://github.com/ADeadTrousers/twrp_device_Unihertz_Atom_XL/releases)

1. Download `recovery.img` from the latest release page of your device.
2. Connect your phone to your PC and open a terminal or a command line window.
3. Run `adb reboot recovery` on your PC or simply hold volume up while turning power on to boot your device into the recovery.
4. Wait for TWRP to boot.
5. Run `adb push recovery.img /external_sd`.
6. In TWRP select `Install`.
7. Use `Select Storage` to switch to your SD card.
8. Use `Install Image` to switch to image installation mode.
9. Select `recovery.img` from the list.
10. Select `Recovery` partition.
11. Swipe the slider on the bottom to the right to confirm.

## Updating LineageOS ROM

- [Atom L Releases](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_L/releases)
- [Atom XL Releases](https://github.com/ADeadTrousers/android_device_Unihertz_Atom_XL/releases)

1. Download `lineage-17.1-XXX-UNOFFICIAL-YYY-signed.zip` from the latest release page of your device.
2. Connect your phone to your PC and open a terminal or a command line window.
3. Run `adb reboot recovery` on your PC or simply hold volume up while turning power on to boot your device into the recovery.
4. (Optional) In TWRP select `Wipe > Advanced Wipe`.
5. (Optional) Tick `Dalvik / ART Cache`, `Cache`, `Data`, `Internal Storage`. 
6. (Optional) Swipe the slider on the bottom to the right to confirm. (**THIS WILL WIPE ALL DATA!**)
7. Go back to the home screen and select `Advanced > ADB Sideload`.
8. Swipe the slider on the bottom to the right to confirm.
9. Run `adb sideload lineage-17.1-XXX-UNOFFICIAL-YYY.zip` from your PC.
10. Wait for the process to finish. The recovery might prompt something about verification failure, just ignore it and continue anyway.
11. (Optional) You need to flash all the additional modules that you previously installed. 
12. Select `Reboot System` to reboot into LineageOS and enjoy. Note that Magisk might cause your device to boot loop once or two but it will eventually boot.

Steps 4 to 6 are optional but if you encounter any errors later on you are on your own.
