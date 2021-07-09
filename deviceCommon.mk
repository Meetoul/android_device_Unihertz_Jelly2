# Copyright (C) 2020 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

DEVICE_PATH := device/Unihertz/Jelly2

#Include GAPPS if applicable
-include $(DEVICE_PATH)/gapps_prop.mk

$(call inherit-product, $(SRC_TARGET_DIR)/product/gsi_keys.mk)

# Enable updating of APEXes
$(call inherit-product, $(SRC_TARGET_DIR)/product/updatable_apex.mk)

# Define Dynamic Partition support
PRODUCT_TARGET_VNDK_VERSION := 29
PRODUCT_SHIPPING_API_LEVEL := 29
PRODUCT_USE_DYNAMIC_PARTITIONS := true
PRODUCT_BUILD_SUPER_PARTITION := false
PRODUCT_BUILD_PRODUCT_IMAGE := true

# Properties
PRODUCT_COMPATIBLE_PROPERTY_OVERRIDE := true

# A/B
AB_OTA_UPDATER := false

# Camera
PRODUCT_PACKAGES += \
    Snap

# NFC stack (AOSP)
PRODUCT_PACKAGES += \
    NfcNci

# Overlays
DEVICE_PACKAGE_OVERLAYS += \
    $(DEVICE_PATH)/overlay \
    $(DEVICE_PATH)/overlay-lineage

# Keylayout
PRODUCT_COPY_FILES += \
    $(DEVICE_PATH)/keylayout/mtk-kpd.kl:$(TARGET_COPY_OUT_SYSTEM)/usr/keylayout/mtk-kpd.kl

# fstab
PRODUCT_COPY_FILES += \
    $(DEVICE_PATH)/fstab.mt6771:$(TARGET_COPY_OUT_RAMDISK)/fstab.mt6771

PRODUCT_EXTRA_VNDK_VERSIONS := 29

#Include GAPPS if applicable
$(call inherit-product-if-exists, vendor/opengapps/build/opengapps-packages.mk)
