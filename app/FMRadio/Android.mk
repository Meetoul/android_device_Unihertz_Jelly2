LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

FMRADIO_LIBS := libfmjni.so
FMRADIO_SYMLINKS := $(addprefix $(PRODUCT_OUT)/product/priv-app/FMRadio/lib/arm64/,$(notdir $(FMRADIO_LIBS)))
$(FMRADIO_SYMLINKS): $(LOCAL_INSTALLED_MODULE)
	@echo "FMradio lib link: $@"
	@mkdir -p $(dir $@)
	@rm -rf $@
	$(hide) ln -sf /product/lib64/$(notdir $@) $@

ALL_DEFAULT_INSTALLED_MODULES += $(FMRADIO_SYMLINKS)
