package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzlj {
    private final String zzada;
    private final int zzadb;
    private final String zzadc;

    public zzlj(String str, int i, String str2) {
        this.zzada = str;
        this.zzadb = i;
        this.zzadc = str2;
    }

    public zzlj(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("applicationName"), jSONObject.optInt("maxPlayers"), jSONObject.optString("version"));
    }

    public final int getMaxPlayers() {
        return this.zzadb;
    }

    public final String getVersion() {
        return this.zzadc;
    }

    public final String zznX() {
        return this.zzada;
    }
}
