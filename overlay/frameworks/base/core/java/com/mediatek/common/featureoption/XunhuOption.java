package com.mediatek.common.featureoption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class XunhuOption {
    private static final String defSettingPath = "/txd/xunhu.prop";
    public static String hxy_cam_xapi_algorithm_support = getString("hxy_cam_xapi_algorithm_support", "unknow");
    public static String hxy_camear_fake_main2_support = getString("hxy_camear_fake_main2_support", "unknow");
    public static String hxy_camear_four_cam_support = getString("hxy_camear_four_cam_support", "unknow");
    public static String hxy_suggestion_setting = getString("hxy_suggestion_setting", "unknow");
    private static Properties properties = null;
    public static String xunhu_add_brand_show = getString("xunhu_add_brand_show", "unknow");
    public static String xunhu_add_camera_volumekey_config = getString("xunhu_add_camera_volumekey_config", "unknow");
    public static String xunhu_add_ram_rom_show = getString("xunhu_add_ram_rom_show", "unknow");
    public static String xunhu_add_shutdown_confirm_dialog = getString("xunhu_add_shutdown_confirm_dialog", "unknow");
    public static String xunhu_adjust_code_for_default_value_set = getString("xunhu_adjust_code_for_default_value_set", "unknow");
    public static String xunhu_agingtest_support = getString("xunhu_agingtest_support", "unknow");
    public static String xunhu_ate_nsft_watermark = getString("xunhu_ate_nsft_watermark", "unknow");
    public static String xunhu_beauty_support = getString("xunhu_beauty_support", "unknow");
    public static String xunhu_bokeh_front = getString("xunhu_bokeh_front", "unknow");
    public static String xunhu_bokeh_support = getString("xunhu_bokeh_support", "unknow");
    public static String xunhu_call_default_vibrate_ringing = getString("xunhu_call_default_vibrate_ringing", "unknow");
    public static String xunhu_camera_brightness_max = getString("xunhu_camera_brightness_max", "unknow");
    public static String xunhu_camera_false_focus = getString("xunhu_camera_false_focus", "unknow");
    public static String xunhu_camera_hal_watermark = getString("xunhu_camera_hal_watermark", "unknow");
    public static String xunhu_camera_not_filter_picture_size = getString("xunhu_camera_not_filter_picture_size", "unknow");
    public static String xunhu_camera_picture_path_sdcard = getString("xunhu_camera_picture_path_sdcard", "unknow");
    public static String xunhu_camera_shutter_sound = getString("xunhu_camera_shutter_sound", "unknow");
    public static String xunhu_camera_time_watermark = getString("xunhu_camera_time_watermark", "unknow");
    public static String xunhu_camera_water_mark = getString("xunhu_camera_water_mark", "unknow");
    public static String xunhu_change_scrim_to_transparent = getString("xunhu_change_scrim_to_transparent", "unknow");
    public static String xunhu_charging_animation_support = getString("xunhu_charging_animation_support", "unknow");
    public static String xunhu_clear_recent_task = getString("xunhu_clear_recent_task", "unknow");
    public static String xunhu_common_cts_fastpass_plus_config = getString("xunhu_common_cts_fastpass_plus_config", "unknow");
    public static String xunhu_common_cts_russia_config = getString("xunhu_common_cts_russia_config", "unknow");
    public static String xunhu_custom_navigationbar = getString("xunhu_custom_navigationbar", "unknow");
    public static String xunhu_cwq_recovery_battery_tips = getString("xunhu_cwq_recovery_battery_tips", "unknow");
    public static String xunhu_default_camera_preview_size = getString("xunhu_default_camera_preview_size", "unknow");
    public static String xunhu_default_close_mobiledata = getString("xunhu_default_close_mobiledata", "unknow");
    public static String xunhu_default_lock_wallpaper = getString("xunhu_default_lock_wallpaper", "unknow");
    public static String xunhu_dexpreopt_prebuilts = getString("xunhu_dexpreopt_prebuilts", "unknow");
    public static String xunhu_distinguish_sim_ring = getString("xunhu_distinguish_sim_ring", "unknow");
    public static String xunhu_facebeauty_save_only_photo = getString("xunhu_facebeauty_save_only_photo", "unknow");
    public static String xunhu_factory_finger_test = getString("xunhu_factory_finger_test", "unknow");
    public static String xunhu_factorytest_add_compass_test = getString("xunhu_factorytest_add_compass_test", "unknow");
    public static String xunhu_factorytest_add_dual_mic_test = getString("xunhu_factorytest_add_dual_mic_test", "unknow");
    public static String xunhu_factorytest_add_googlekey_test = getString("xunhu_factorytest_add_googlekey_test", "unknow");
    public static String xunhu_factorytest_add_gyroscope_sensor_test = getString("xunhu_factorytest_add_gyroscope_sensor_test", "unknow");
    public static String xunhu_factorytest_add_hardware_test = getString("xunhu_factorytest_add_hardware_test", "unknow");
    public static String xunhu_factorytest_add_led_test = getString("xunhu_factorytest_add_led_test", "unknow");
    public static String xunhu_factorytest_add_memory_test = getString("xunhu_factorytest_add_memory_test", "unknow");
    public static String xunhu_factorytest_add_otg_test = getString("xunhu_factorytest_add_otg_test", "unknow");
    public static String xunhu_factorytest_add_take_photo = getString("xunhu_factorytest_add_take_photo", "unknow");
    public static String xunhu_factorytest_auxiliary_camera_test = getString("xunhu_factorytest_auxiliary_camera_test", "unknow");
    public static String xunhu_factorytest_colortest_7 = getString("xunhu_factorytest_colortest_7", "unknow");
    public static String xunhu_factorytest_invisible_pass_button = getString("xunhu_factorytest_invisible_pass_button", "unknow");
    public static String xunhu_factorytest_switch_language = getString("xunhu_factorytest_switch_language", "unknow");
    public static String xunhu_factorytest_use_five_point = getString("xunhu_factorytest_use_five_point", "unknow");
    public static String xunhu_fingerprint_fuction = getString("xunhu_fingerprint_fuction", "unknow");
    public static String xunhu_fixed_wallpaper = getString("xunhu_fixed_wallpaper", "unknow");
    public static String xunhu_flip_mute = getString("xunhu_flip_mute", "unknow");
    public static String xunhu_glove_mode_support = getString("xunhu_glove_mode_support", "unknow");
    public static String xunhu_hfj_wlsd_star_saletracker = getString("xunhu_hfj_wlsd_star_saletracker", "unknow");
    public static String xunhu_hide_notch = getString("xunhu_hide_notch", "unknow");
    public static String xunhu_imei_settings = getString("xunhu_imei_settings", "unknow");
    public static String xunhu_ingore_default_message_sim = getString("xunhu_ingore_default_message_sim", "unknow");
    public static String xunhu_intelligent_sense = getString("xunhu_intelligent_sense", "unknow");
    public static String xunhu_intex_s5023_bangladesh = getString("xunhu_intex_s5023_bangladesh", "unknow");
    public static String xunhu_intex_s5023_india = getString("xunhu_intex_s5023_india", "unknow");
    public static String xunhu_intex_s5023_nepal = getString("xunhu_intex_s5023_nepal", "unknow");
    public static String xunhu_intex_s5023_srilanka = getString("xunhu_intex_s5023_srilanka", "unknow");
    public static String xunhu_jp_sms_default_sim = getString("xunhu_jp_sms_default_sim", "unknow");
    public static String xunhu_launcher_style = getString("xunhu_launcher_style", "unknow");
    public static String xunhu_launcher_title_display_two_lines = getString("xunhu_launcher_title_display_two_lines", "unknow");
    public static String xunhu_lights_settings = getString("xunhu_lights_settings", "unknow");
    public static String xunhu_liut_incoming_flashled = getString("xunhu_liut_incoming_flashled", "unknow");
    public static String xunhu_liut_volumeup_power_screenrecorder = getString("xunhu_liut_volumeup_power_screenrecorder", "unknow");
    public static String xunhu_llq_power_off_charging_show_logo = getString("xunhu_llq_power_off_charging_show_logo", "unknow");
    public static String xunhu_lps_auxiliarycamera_support = getString("xunhu_lps_auxiliarycamera_support", "unknow");
    public static String xunhu_lps_tekhw_support = getString("xunhu_lps_tekhw_support", "unknow");
    public static String xunhu_lyh_signal_enhancement = getString("xunhu_lyh_signal_enhancement", "unknow");
    public static String xunhu_min_shutdown_animation_play_time = getString("xunhu_min_shutdown_animation_play_time", "unknow");
    public static String xunhu_new_camera2_ui_style = getString("xunhu_new_camera2_ui_style", "unknow");
    public static String xunhu_new_date_format = getString("xunhu_new_date_format", "unknow");
    public static String xunhu_notification_use_dot = getString("xunhu_notification_use_dot", "unknow");
    public static String xunhu_one_way_sensor = getString("xunhu_one_way_sensor", "unknow");
    public static String xunhu_qty_af_sound_menu = getString("xunhu_qty_af_sound_menu", "unknow");
    public static String xunhu_qty_false_auto_focus = getString("xunhu_qty_false_auto_focus", "unknow");
    public static String xunhu_qty_front_cam_false_auto_focus = getString("xunhu_qty_front_cam_false_auto_focus", "unknow");
    public static String xunhu_qty_gesture_somatosensory = getString("xunhu_qty_gesture_somatosensory", "unknow");
    public static String xunhu_qty_smart_wake_up = getString("xunhu_qty_smart_wake_up", "unknow");
    public static String xunhu_raise_hand_wake_up = getString("xunhu_raise_hand_wake_up", "unknow");
    public static String xunhu_ramtest_support = getString("xunhu_ramtest_support", "unknow");
    public static String xunhu_remove_custom_build_version = getString("xunhu_remove_custom_build_version", "unknow");
    public static String xunhu_remove_geocoding = getString("xunhu_remove_geocoding", "unknow");
    public static String xunhu_restore_camera_default_config = getString("xunhu_restore_camera_default_config", "unknow");
    public static String xunhu_sale_tracker = getString("xunhu_sale_tracker", "unknow");
    public static String xunhu_sbyh_salestracker = getString("xunhu_sbyh_salestracker", "unknow");
    public static String xunhu_schedule_power_onoff = getString("xunhu_schedule_power_onoff", "unknow");
    public static String xunhu_setting_ram_value = getString("xunhu_setting_ram_value", "unknow");
    public static String xunhu_setting_rom_value = getString("xunhu_setting_rom_value", "unknow");
    public static String xunhu_show_battery_level = getString("xunhu_show_battery_level", "unknow");
    public static String xunhu_shutdown_animation = getString("xunhu_shutdown_animation", "unknow");
    public static String xunhu_shutdown_style_use_android_n = getString("xunhu_shutdown_style_use_android_n", "unknow");
    public static String xunhu_stream_alarm = getString("xunhu_stream_alarm", "unknow");
    public static String xunhu_stream_music = getString("xunhu_stream_music", "unknow");
    public static String xunhu_stream_notification = getString("xunhu_stream_notification", "unknow");
    public static String xunhu_stream_ring = getString("xunhu_stream_ring", "unknow");
    public static String xunhu_stream_system = getString("xunhu_stream_system", "unknow");
    public static String xunhu_stream_voice_call = getString("xunhu_stream_voice_call", "unknow");
    public static String xunhu_support_usb_midi_mode = getString("xunhu_support_usb_midi_mode", "unknow");
    public static String xunhu_supprort_emergency_rescue = getString("xunhu_supprort_emergency_rescue", "unknow");
    public static String xunhu_system_time_default_24 = getString("xunhu_system_time_default_24", "unknow");
    public static String xunhu_ttc_flash_adaptive = getString("xunhu_ttc_flash_adaptive", "unknow");
    public static String xunhu_two_way_sensor = getString("xunhu_two_way_sensor", "unknow");
    public static String xunhu_use_google_dialer = getString("xunhu_use_google_dialer", "unknow");
    public static String xunhu_virtual_first_bug = getString("xunhu_virtual_first_bug", "unknow");
    public static String xunhu_wifi_mac_settings = getString("xunhu_wifi_mac_settings", "unknow");
    public static String xunhu_ys_h910_alf_saletracker = getString("xunhu_ys_h910_alf_saletracker", "unknow");
    public static String xunhu_ys_yfnd_stylus_saletracker = getString("xunhu_ys_yfnd_stylus_saletracker", "unknow");
    public static String xunhu_yx_s55lite_saletracker = getString("xunhu_yx_s55lite_saletracker", "unknow");
    public static String xunhu_zdp_dynamic_calendar_icon = getString("xunhu_zdp_dynamic_calendar_icon", "unknow");
    public static String xunhu_zdp_dynamic_deskclock_icon_analogclock = getString("xunhu_zdp_dynamic_deskclock_icon_analogclock", "unknow");
    public static String xunhu_zdp_dynamic_deskclock_icon_digitclock = getString("xunhu_zdp_dynamic_deskclock_icon_digitclock", "unknow");
    public static String xunhu_zjd_h921w_ydw_x5aw_saletracker = getString("xunhu_zjd_h921w_ydw_x5aw_saletracker", "unknow");
    public static String xunhu_zjj_preloadmedia = getString("xunhu_zjj_preloadmedia", "unknow");
public static final boolean HXY_CAMEAR_FAKE_MAIN2_SUPPORT = (hxy_camear_fake_main2_support.equals("unknow") ? false : Boolean.parseBoolean(hxy_camear_fake_main2_support));
    public static final boolean HXY_CAMEAR_FOUR_CAM_SUPPORT = (hxy_camear_four_cam_support.equals("unknow") ? true : Boolean.parseBoolean(hxy_camear_four_cam_support));
    public static final boolean HXY_CAM_XAPI_ALGORITHM_SUPPORT = (hxy_cam_xapi_algorithm_support.equals("unknow") ? false : Boolean.parseBoolean(hxy_cam_xapi_algorithm_support));
    public static final boolean HXY_SUGGESTION_SETTING;
    public static final boolean XUNHU_ADD_BRAND_SHOW = (xunhu_add_brand_show.equals("unknow") ? true : Boolean.parseBoolean(xunhu_add_brand_show));
    public static final boolean XUNHU_ADD_CAMERA_VOLUMEKEY_CONFIG = (xunhu_add_camera_volumekey_config.equals("unknow") ? false : Boolean.parseBoolean(xunhu_add_camera_volumekey_config));
    public static final boolean XUNHU_ADD_RAM_ROM_SHOW = (xunhu_add_ram_rom_show.equals("unknow") ? true : Boolean.parseBoolean(xunhu_add_ram_rom_show));
    public static final boolean XUNHU_ADD_SHUTDOWN_CONFIRM_DIALOG = (xunhu_add_shutdown_confirm_dialog.equals("unknow") ? false : Boolean.parseBoolean(xunhu_add_shutdown_confirm_dialog));
    public static final boolean XUNHU_ADJUST_CODE_FOR_DEFAULT_VALUE_SET = (xunhu_adjust_code_for_default_value_set.equals("unknow") ? true : Boolean.parseBoolean(xunhu_adjust_code_for_default_value_set));
    public static final boolean XUNHU_AGINGTEST_SUPPORT = (xunhu_agingtest_support.equals("unknow") ? true : Boolean.parseBoolean(xunhu_agingtest_support));
    public static final boolean XUNHU_ATE_NSFT_WATERMARK = (xunhu_ate_nsft_watermark.equals("unknow") ? false : Boolean.parseBoolean(xunhu_ate_nsft_watermark));
    public static final boolean XUNHU_BEAUTY_SUPPORT = (xunhu_beauty_support.equals("unknow") ? false : Boolean.parseBoolean(xunhu_beauty_support));
    public static final boolean XUNHU_BOKEH_FRONT = (xunhu_bokeh_front.equals("unknow") ? false : Boolean.parseBoolean(xunhu_bokeh_front));
    public static final boolean XUNHU_BOKEH_SUPPORT = (xunhu_bokeh_support.equals("unknow") ? false : Boolean.parseBoolean(xunhu_bokeh_support));
    public static final boolean XUNHU_CALL_DEFAULT_VIBRATE_RINGING = (xunhu_call_default_vibrate_ringing.equals("unknow") ? true : Boolean.parseBoolean(xunhu_call_default_vibrate_ringing));
    public static final boolean XUNHU_CAMERA_BRIGHTNESS_MAX = (xunhu_camera_brightness_max.equals("unknow") ? true : Boolean.parseBoolean(xunhu_camera_brightness_max));
    public static final String XUNHU_CAMERA_CUSTOM_INTERPOLATION = "0_0_5_0_5";
    public static final int XUNHU_CAMERA_FALSE_FOCUS = (xunhu_camera_false_focus.equals("unknow") ? 0 : Integer.parseInt(xunhu_camera_false_focus));
    public static final boolean XUNHU_CAMERA_HAL_WATERMARK = (xunhu_camera_hal_watermark.equals("unknow") ? false : Boolean.parseBoolean(xunhu_camera_hal_watermark));
    public static final boolean XUNHU_CAMERA_NOT_FILTER_PICTURE_SIZE = (xunhu_camera_not_filter_picture_size.equals("unknow") ? false : Boolean.parseBoolean(xunhu_camera_not_filter_picture_size));
    public static final boolean XUNHU_CAMERA_PICTURE_PATH_SDCARD = (xunhu_camera_picture_path_sdcard.equals("unknow") ? true : Boolean.parseBoolean(xunhu_camera_picture_path_sdcard));
    public static final boolean XUNHU_CAMERA_SHUTTER_SOUND = (xunhu_camera_shutter_sound.equals("unknow") ? true : Boolean.parseBoolean(xunhu_camera_shutter_sound));
    public static final boolean XUNHU_CAMERA_TIME_WATERMARK = (xunhu_camera_time_watermark.equals("unknow") ? false : Boolean.parseBoolean(xunhu_camera_time_watermark));
    public static final boolean XUNHU_CAMERA_WATER_MARK = (xunhu_camera_water_mark.equals("unknow") ? true : Boolean.parseBoolean(xunhu_camera_water_mark));
    public static final boolean XUNHU_CHANGE_SCRIM_TO_TRANSPARENT = (xunhu_change_scrim_to_transparent.equals("unknow") ? false : Boolean.parseBoolean(xunhu_change_scrim_to_transparent));
    public static final boolean XUNHU_CHARGING_ANIMATION_SUPPORT = (xunhu_charging_animation_support.equals("unknow") ? true : Boolean.parseBoolean(xunhu_charging_animation_support));
    public static final boolean XUNHU_CLEAR_RECENT_TASK = (xunhu_clear_recent_task.equals("unknow") ? false : Boolean.parseBoolean(xunhu_clear_recent_task));
    public static final boolean XUNHU_COMMON_CTS_FASTPASS_PLUS_CONFIG = (xunhu_common_cts_fastpass_plus_config.equals("unknow") ? true : Boolean.parseBoolean(xunhu_common_cts_fastpass_plus_config));
    public static final boolean XUNHU_COMMON_CTS_RUSSIA_CONFIG = (xunhu_common_cts_russia_config.equals("unknow") ? false : Boolean.parseBoolean(xunhu_common_cts_russia_config));
    public static final String XUNHU_CUSTOM_CLIENT_ID = "android";
    public static final boolean XUNHU_CUSTOM_NAVIGATIONBAR = (xunhu_custom_navigationbar.equals("unknow") ? true : Boolean.parseBoolean(xunhu_custom_navigationbar));
    public static final boolean XUNHU_CWQ_RECOVERY_BATTERY_TIPS = (xunhu_cwq_recovery_battery_tips.equals("unknow") ? true : Boolean.parseBoolean(xunhu_cwq_recovery_battery_tips));
    public static final int XUNHU_DEFAULT_CAMERA_PREVIEW_SIZE = (xunhu_default_camera_preview_size.equals("unknow") ? 3 : Integer.parseInt(xunhu_default_camera_preview_size));
    public static final boolean XUNHU_DEFAULT_CLOSE_MOBILEDATA = (xunhu_default_close_mobiledata.equals("unknow") ? false : Boolean.parseBoolean(xunhu_default_close_mobiledata));
    public static final boolean XUNHU_DEFAULT_LOCK_WALLPAPER = (xunhu_default_lock_wallpaper.equals("unknow") ? false : Boolean.parseBoolean(xunhu_default_lock_wallpaper));
    public static final boolean XUNHU_DEXPREOPT_PREBUILTS = (xunhu_dexpreopt_prebuilts.equals("unknow") ? true : Boolean.parseBoolean(xunhu_dexpreopt_prebuilts));
    public static final boolean XUNHU_DISTINGUISH_SIM_RING = (xunhu_distinguish_sim_ring.equals("unknow") ? false : Boolean.parseBoolean(xunhu_distinguish_sim_ring));
    public static final boolean XUNHU_FACEBEAUTY_SAVE_ONLY_PHOTO = (xunhu_facebeauty_save_only_photo.equals("unknow") ? true : Boolean.parseBoolean(xunhu_facebeauty_save_only_photo));
    public static final boolean XUNHU_FACTORYTEST_ADD_COMPASS_TEST = (xunhu_factorytest_add_compass_test.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_add_compass_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_DUAL_MIC_TEST;
    public static final boolean XUNHU_FACTORYTEST_ADD_GOOGLEKEY_TEST = (xunhu_factorytest_add_googlekey_test.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_add_googlekey_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_GYROSCOPE_SENSOR_TEST = (xunhu_factorytest_add_gyroscope_sensor_test.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_add_gyroscope_sensor_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_HARDWARE_TEST = (xunhu_factorytest_add_hardware_test.equals("unknow") ? false : Boolean.parseBoolean(xunhu_factorytest_add_hardware_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_LED_TEST = (xunhu_factorytest_add_led_test.equals("unknow") ? false : Boolean.parseBoolean(xunhu_factorytest_add_led_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_MEMORY_TEST = (xunhu_factorytest_add_memory_test.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_add_memory_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_OTG_TEST = (xunhu_factorytest_add_otg_test.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_add_otg_test));
    public static final boolean XUNHU_FACTORYTEST_ADD_TAKE_PHOTO = (xunhu_factorytest_add_take_photo.equals("unknow") ? false : Boolean.parseBoolean(xunhu_factorytest_add_take_photo));
    public static final boolean XUNHU_FACTORYTEST_AUXILIARY_CAMERA_TEST = (xunhu_factorytest_auxiliary_camera_test.equals("unknow") ? false : Boolean.parseBoolean(xunhu_factorytest_auxiliary_camera_test));
    public static final boolean XUNHU_FACTORYTEST_COLORTEST_7 = (xunhu_factorytest_colortest_7.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_colortest_7));
    public static final boolean XUNHU_FACTORYTEST_INVISIBLE_PASS_BUTTON = (xunhu_factorytest_invisible_pass_button.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factorytest_invisible_pass_button));
    public static final boolean XUNHU_FACTORYTEST_SWITCH_LANGUAGE = (xunhu_factorytest_switch_language.equals("unknow") ? false : Boolean.parseBoolean(xunhu_factorytest_switch_language));
    public static final boolean XUNHU_FACTORYTEST_USE_FIVE_POINT = (xunhu_factorytest_use_five_point.equals("unknow") ? false : Boolean.parseBoolean(xunhu_factorytest_use_five_point));
    public static final boolean XUNHU_FACTORY_FINGER_TEST = (xunhu_factory_finger_test.equals("unknow") ? true : Boolean.parseBoolean(xunhu_factory_finger_test));
    public static final boolean XUNHU_FINGERPRINT_FUCTION = (xunhu_fingerprint_fuction.equals("unknow") ? false : Boolean.parseBoolean(xunhu_fingerprint_fuction));
    public static final boolean XUNHU_FIXED_WALLPAPER = (xunhu_fixed_wallpaper.equals("unknow") ? true : Boolean.parseBoolean(xunhu_fixed_wallpaper));
    public static final boolean XUNHU_FLIP_MUTE = (xunhu_flip_mute.equals("unknow") ? false : Boolean.parseBoolean(xunhu_flip_mute));
    public static final boolean XUNHU_GLOVE_MODE_SUPPORT = (xunhu_glove_mode_support.equals("unknow") ? false : Boolean.parseBoolean(xunhu_glove_mode_support));
    public static final String XUNHU_HAVE_NOTCH_MADA = "sanmu";
    public static final boolean XUNHU_HFJ_WLSD_STAR_SALETRACKER = (xunhu_hfj_wlsd_star_saletracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_hfj_wlsd_star_saletracker));
    public static final boolean XUNHU_HIDE_NOTCH = (xunhu_hide_notch.equals("unknow") ? false : Boolean.parseBoolean(xunhu_hide_notch));
    public static final boolean XUNHU_IMEI_SETTINGS = (xunhu_imei_settings.equals("unknow") ? true : Boolean.parseBoolean(xunhu_imei_settings));
    public static final boolean XUNHU_INGORE_DEFAULT_MESSAGE_SIM = (xunhu_ingore_default_message_sim.equals("unknow") ? true : Boolean.parseBoolean(xunhu_ingore_default_message_sim));
    public static final boolean XUNHU_INTELLIGENT_SENSE = (xunhu_intelligent_sense.equals("unknow") ? false : Boolean.parseBoolean(xunhu_intelligent_sense));
    public static final boolean XUNHU_INTEX_S5023_BANGLADESH = (xunhu_intex_s5023_bangladesh.equals("unknow") ? false : Boolean.parseBoolean(xunhu_intex_s5023_bangladesh));
    public static final boolean XUNHU_INTEX_S5023_INDIA = (xunhu_intex_s5023_india.equals("unknow") ? false : Boolean.parseBoolean(xunhu_intex_s5023_india));
    public static final boolean XUNHU_INTEX_S5023_NEPAL = (xunhu_intex_s5023_nepal.equals("unknow") ? false : Boolean.parseBoolean(xunhu_intex_s5023_nepal));
    public static final boolean XUNHU_INTEX_S5023_SRILANKA = (xunhu_intex_s5023_srilanka.equals("unknow") ? false : Boolean.parseBoolean(xunhu_intex_s5023_srilanka));
    public static final boolean XUNHU_JP_SMS_DEFAULT_SIM = (xunhu_jp_sms_default_sim.equals("unknow") ? false : Boolean.parseBoolean(xunhu_jp_sms_default_sim));
    public static final boolean XUNHU_LAUNCHER_STYLE = (xunhu_launcher_style.equals("unknow") ? true : Boolean.parseBoolean(xunhu_launcher_style));
    public static final boolean XUNHU_LAUNCHER_TITLE_DISPLAY_TWO_LINES = (xunhu_launcher_title_display_two_lines.equals("unknow") ? false : Boolean.parseBoolean(xunhu_launcher_title_display_two_lines));
    public static final boolean XUNHU_LIGHTS_SETTINGS = (xunhu_lights_settings.equals("unknow") ? false : Boolean.parseBoolean(xunhu_lights_settings));
    public static final boolean XUNHU_LIUT_INCOMING_FLASHLED = (xunhu_liut_incoming_flashled.equals("unknow") ? false : Boolean.parseBoolean(xunhu_liut_incoming_flashled));
    public static final boolean XUNHU_LIUT_VOLUMEUP_POWER_SCREENRECORDER = (xunhu_liut_volumeup_power_screenrecorder.equals("unknow") ? true : Boolean.parseBoolean(xunhu_liut_volumeup_power_screenrecorder));
    public static final boolean XUNHU_LLQ_POWER_OFF_CHARGING_SHOW_LOGO = (xunhu_llq_power_off_charging_show_logo.equals("unknow") ? false : Boolean.parseBoolean(xunhu_llq_power_off_charging_show_logo));
    public static final boolean XUNHU_LPS_AUXILIARYCAMERA_SUPPORT = (xunhu_lps_auxiliarycamera_support.equals("unknow") ? false : Boolean.parseBoolean(xunhu_lps_auxiliarycamera_support));
    public static final boolean XUNHU_LPS_TEKHW_SUPPORT = (xunhu_lps_tekhw_support.equals("unknow") ? true : Boolean.parseBoolean(xunhu_lps_tekhw_support));
    public static final boolean XUNHU_LYH_SIGNAL_ENHANCEMENT = (xunhu_lyh_signal_enhancement.equals("unknow") ? true : Boolean.parseBoolean(xunhu_lyh_signal_enhancement));
    public static final int XUNHU_MIN_SHUTDOWN_ANIMATION_PLAY_TIME = (xunhu_min_shutdown_animation_play_time.equals("unknow") ? 0 : Integer.parseInt(xunhu_min_shutdown_animation_play_time));
    public static final boolean XUNHU_NEW_CAMERA2_UI_STYLE = (xunhu_new_camera2_ui_style.equals("unknow") ? false : Boolean.parseBoolean(xunhu_new_camera2_ui_style));
    public static final boolean XUNHU_NEW_DATE_FORMAT = (xunhu_new_date_format.equals("unknow") ? true : Boolean.parseBoolean(xunhu_new_date_format));
    public static final boolean XUNHU_NOTIFICATION_USE_DOT = (xunhu_notification_use_dot.equals("unknow") ? true : Boolean.parseBoolean(xunhu_notification_use_dot));
    public static final boolean XUNHU_ONE_WAY_SENSOR = (xunhu_one_way_sensor.equals("unknow") ? true : Boolean.parseBoolean(xunhu_one_way_sensor));
    public static final boolean XUNHU_QTY_AF_SOUND_MENU = (xunhu_qty_af_sound_menu.equals("unknow") ? false : Boolean.parseBoolean(xunhu_qty_af_sound_menu));
    public static final boolean XUNHU_QTY_FALSE_AUTO_FOCUS = (xunhu_qty_false_auto_focus.equals("unknow") ? false : Boolean.parseBoolean(xunhu_qty_false_auto_focus));
    public static final boolean XUNHU_QTY_FRONT_CAM_FALSE_AUTO_FOCUS = (xunhu_qty_front_cam_false_auto_focus.equals("unknow") ? false : Boolean.parseBoolean(xunhu_qty_front_cam_false_auto_focus));
    public static final boolean XUNHU_QTY_GESTURE_SOMATOSENSORY = (xunhu_qty_gesture_somatosensory.equals("unknow") ? true : Boolean.parseBoolean(xunhu_qty_gesture_somatosensory));
    public static final boolean XUNHU_QTY_SMART_WAKE_UP = (xunhu_qty_smart_wake_up.equals("unknow") ? false : Boolean.parseBoolean(xunhu_qty_smart_wake_up));
    public static final boolean XUNHU_RAISE_HAND_WAKE_UP = (xunhu_raise_hand_wake_up.equals("unknow") ? false : Boolean.parseBoolean(xunhu_raise_hand_wake_up));
    public static final boolean XUNHU_RAMTEST_SUPPORT = (xunhu_ramtest_support.equals("unknow") ? true : Boolean.parseBoolean(xunhu_ramtest_support));
    public static final boolean XUNHU_REMOVE_CUSTOM_BUILD_VERSION = (xunhu_remove_custom_build_version.equals("unknow") ? true : Boolean.parseBoolean(xunhu_remove_custom_build_version));
    public static final boolean XUNHU_REMOVE_GEOCODING = (xunhu_remove_geocoding.equals("unknow") ? true : Boolean.parseBoolean(xunhu_remove_geocoding));
    public static final boolean XUNHU_RESTORE_CAMERA_DEFAULT_CONFIG = (xunhu_restore_camera_default_config.equals("unknow") ? false : Boolean.parseBoolean(xunhu_restore_camera_default_config));
    public static final boolean XUNHU_SALE_TRACKER = (xunhu_sale_tracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_sale_tracker));
    public static final boolean XUNHU_SBYH_SALESTRACKER = (xunhu_sbyh_salestracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_sbyh_salestracker));
    public static final boolean XUNHU_SCHEDULE_POWER_ONOFF = (xunhu_schedule_power_onoff.equals("unknow") ? false : Boolean.parseBoolean(xunhu_schedule_power_onoff));
    public static final int XUNHU_SETTING_RAM_VALUE = (xunhu_setting_ram_value.equals("unknow") ? 6 : Integer.parseInt(xunhu_setting_ram_value));
    public static final int XUNHU_SETTING_ROM_VALUE = (xunhu_setting_rom_value.equals("unknow") ? 128 : Integer.parseInt(xunhu_setting_rom_value));
    public static final boolean XUNHU_SHOW_BATTERY_LEVEL = (xunhu_show_battery_level.equals("unknow") ? true : Boolean.parseBoolean(xunhu_show_battery_level));
    public static final boolean XUNHU_SHUTDOWN_ANIMATION = (xunhu_shutdown_animation.equals("unknow") ? false : Boolean.parseBoolean(xunhu_shutdown_animation));
    public static final boolean XUNHU_SHUTDOWN_STYLE_USE_ANDROID_N = (xunhu_shutdown_style_use_android_n.equals("unknow") ? false : Boolean.parseBoolean(xunhu_shutdown_style_use_android_n));
    public static final int XUNHU_STREAM_ALARM = (xunhu_stream_alarm.equals("unknow") ? 15 : Integer.parseInt(xunhu_stream_alarm));
    public static final int XUNHU_STREAM_MUSIC = (xunhu_stream_music.equals("unknow") ? 15 : Integer.parseInt(xunhu_stream_music));
    public static final int XUNHU_STREAM_NOTIFICATION;
    public static final int XUNHU_STREAM_RING = (xunhu_stream_ring.equals("unknow") ? 15 : Integer.parseInt(xunhu_stream_ring));
    public static final int XUNHU_STREAM_SYSTEM = (xunhu_stream_system.equals("unknow") ? 15 : Integer.parseInt(xunhu_stream_system));
    public static final int XUNHU_STREAM_VOICE_CALL = (xunhu_stream_voice_call.equals("unknow") ? 7 : Integer.parseInt(xunhu_stream_voice_call));
    public static final boolean XUNHU_SUPPORT_USB_MIDI_MODE = (xunhu_support_usb_midi_mode.equals("unknow") ? false : Boolean.parseBoolean(xunhu_support_usb_midi_mode));
    public static final boolean XUNHU_SUPPRORT_EMERGENCY_RESCUE = (xunhu_supprort_emergency_rescue.equals("unknow") ? true : Boolean.parseBoolean(xunhu_supprort_emergency_rescue));
    public static final boolean XUNHU_SYSTEM_TIME_DEFAULT_24 = (xunhu_system_time_default_24.equals("unknow") ? true : Boolean.parseBoolean(xunhu_system_time_default_24));
    public static final boolean XUNHU_TTC_FLASH_ADAPTIVE = (xunhu_ttc_flash_adaptive.equals("unknow") ? false : Boolean.parseBoolean(xunhu_ttc_flash_adaptive));
    public static final boolean XUNHU_TWO_WAY_SENSOR = (xunhu_two_way_sensor.equals("unknow") ? false : Boolean.parseBoolean(xunhu_two_way_sensor));
    public static final boolean XUNHU_USE_GOOGLE_DIALER = (xunhu_use_google_dialer.equals("unknow") ? false : Boolean.parseBoolean(xunhu_use_google_dialer));
    public static final boolean XUNHU_VIRTUAL_fIRST_BUG = (xunhu_virtual_first_bug.equals("unknow") ? true : Boolean.parseBoolean(xunhu_virtual_first_bug));
    public static final boolean XUNHU_WIFI_MAC_SETTINGS = (xunhu_wifi_mac_settings.equals("unknow") ? true : Boolean.parseBoolean(xunhu_wifi_mac_settings));
    public static final boolean XUNHU_YS_H910_ALF_SALETRACKER = (xunhu_ys_h910_alf_saletracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_ys_h910_alf_saletracker));
    public static final boolean XUNHU_YS_YFND_STYLUS_SALETRACKER = (xunhu_ys_yfnd_stylus_saletracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_ys_yfnd_stylus_saletracker));
    public static final boolean XUNHU_YX_S55LITE_SALETRACKER = (xunhu_yx_s55lite_saletracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_yx_s55lite_saletracker));
    public static final boolean XUNHU_ZDP_DYNAMIC_CALENDAR_ICON = (xunhu_zdp_dynamic_calendar_icon.equals("unknow") ? false : Boolean.parseBoolean(xunhu_zdp_dynamic_calendar_icon));
    public static final boolean XUNHU_ZDP_DYNAMIC_DESKCLOCK_ICON_ANALOGCLOCK = (xunhu_zdp_dynamic_deskclock_icon_analogclock.equals("unknow") ? false : Boolean.parseBoolean(xunhu_zdp_dynamic_deskclock_icon_analogclock));
    public static final boolean XUNHU_ZDP_DYNAMIC_DESKCLOCK_ICON_DIGITCLOCK = (xunhu_zdp_dynamic_deskclock_icon_digitclock.equals("unknow") ? false : Boolean.parseBoolean(xunhu_zdp_dynamic_deskclock_icon_digitclock));
    public static final boolean XUNHU_ZJD_H921W_YDW_X5AW_SALETRACKER = (xunhu_zjd_h921w_ydw_x5aw_saletracker.equals("unknow") ? false : Boolean.parseBoolean(xunhu_zjd_h921w_ydw_x5aw_saletracker));
    public static final boolean XUNHU_ZJJ_PRELOADMEDIA = (xunhu_zjj_preloadmedia.equals("unknow") ? false : Boolean.parseBoolean(xunhu_zjj_preloadmedia));
    static {
        boolean z = true;
        boolean z2 = false;
        int i = 15;
        if (!xunhu_stream_notification.equals("unknow")) {
            i = Integer.parseInt(xunhu_stream_notification);
        }
        XUNHU_STREAM_NOTIFICATION = i;
        if (!hxy_suggestion_setting.equals("unknow")) {
            z = Boolean.parseBoolean(hxy_suggestion_setting);
        }
        HXY_SUGGESTION_SETTING = z;
        if (!xunhu_factorytest_add_dual_mic_test.equals("unknow")) {
            z2 = Boolean.parseBoolean(xunhu_factorytest_add_dual_mic_test);
        }
        XUNHU_FACTORYTEST_ADD_DUAL_MIC_TEST = z2;
    }

    public static String getString(String key, String defvalue) {
        String p;
        if (properties == null) {
            FileInputStream stream = null;
            try {
                stream = new FileInputStream(new File(defSettingPath));
                properties = new Properties();
                properties.load(stream);
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                properties = null;
                if (stream != null) {
                }
            } catch (Throwable th) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        }
        Properties properties2 = properties;
        if (properties2 == null || (p = properties2.getProperty(key)) == null) {
            return defvalue;
        }
        return p.trim();
    }
}
