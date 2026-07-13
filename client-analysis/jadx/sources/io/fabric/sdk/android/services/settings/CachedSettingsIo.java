package io.fabric.sdk.android.services.settings;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface CachedSettingsIo {
    JSONObject readCachedSettings();

    void writeCachedSettings(long j, JSONObject jSONObject);
}
