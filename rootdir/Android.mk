# Copyright (C) 2020 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE       := init.mt6771.rc
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := etc/init.mt6771.rc
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)/init
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE       := fstab.mt6771
LOCAL_MODULE_TAGS  := optional
LOCAL_MODULE_CLASS := ETC
LOCAL_SRC_FILES    := etc/fstab.mt6771
LOCAL_MODULE_PATH  := $(TARGET_OUT_ETC)
include $(BUILD_PREBUILT)

include $(CLEAR_VARS)
LOCAL_MODULE         := libfmcust
LOCAL_MODULE_SUFFIX  := .so
LOCAL_MODULE_CLASS   := SHARED_LIBRARIES
LOCAL_MODULE_TAGS    := optional
LOCAL_PRELINK_MODULE := false
ifdef TARGET_2ND_ARCH
LOCAL_MULTILIB       := both
LOCAL_SRC_FILES_64   := lib64/libfmcust.so
LOCAL_SRC_FILES_32   := lib/libfmcust.so
else
LOCAL_SRC_FILES      := lib/libfmcust.so
endif
include $(BUILD_PREBUILT)
