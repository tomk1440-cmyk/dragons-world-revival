package io.fabric.sdk.android.services.settings;

/* JADX INFO: loaded from: classes.dex */
public interface SettingsController {
    SettingsData loadSettingsData();

    SettingsData loadSettingsData(SettingsCacheBehavior settingsCacheBehavior);
}
