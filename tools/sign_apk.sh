#!/bin/bash

APK_NAME=$(basename -- "$1")
FILE_PATH=$(dirname -- "$1")
SCRIPT_PATH=$(dirname -- "$0")

java -Xmx2048m \
     -Djava.library.path="$SCRIPT_PATH/../../../../out/host/linux-x86/lib64" \
     -jar "$SCRIPT_PATH/../../../../out/host/linux-x86/framework/signapk.jar" \
     -w ~/.android-certs/platform.x509.pem ~/.android-certs/platform.pk8 \
     "$1" \
     "$FILE_PATH/signed_$APK_NAME"
     
rm -f $1
mv "$FILE_PATH/signed_$APK_NAME" "$1"
