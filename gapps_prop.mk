#
# Copyright (C) 2020 The LineageOS Project
#
# SPDX-License-Identifier: Apache-2.0
#

# GAPPS settings
# For examples see https://github.com/opengapps/aosp_build
# Here I only used the lowest set of apps including all overwrites according to "super" to save space
GAPPS_VARIANT := pico

GAPPS_FORCE_PACKAGE_OVERRIDES := true
GAPPS_FORCE_PIXEL_LAUNCHER := true
# Workaround for now to get Velvet (Google QuickSearch) to work
DONT_UNCOMPRESS_PRIV_APPS_DEXS := true

GAPPS_PRODUCT_PACKAGES += \
    CalculatorGoogle \
    CalendarGooglePrebuilt \
    GoogleCamera \
    CarrierServices \
    Chrome \
    PrebuiltDeskClockGoogle \
    GoogleContacts \
    GoogleDialer \
    PrebuiltExchange3Google \
    PrebuiltGmail \
    LatinImeGoogle \
    Maps \
    PrebuiltBugle \
    PixelLauncher \
    Photos \
    GooglePrintRecommendationService \
    Velvet \
    StorageManagerGoogle \
    TagGoogle \
    Wallpapers \
    WebViewGoogle
