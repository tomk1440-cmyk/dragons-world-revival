package com.google.android.gms.internal;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzlo {
    private final int zzabo;
    private final String zzacX;
    private final JSONObject zzadn;

    public zzlo(String str, int i, JSONObject jSONObject) {
        this.zzacX = str;
        this.zzabo = i;
        this.zzadn = jSONObject;
    }

    public zzlo(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof zzlo)) {
            return false;
        }
        zzlo zzloVar = (zzlo) otherObj;
        return this.zzabo == zzloVar.getPlayerState() && com.google.android.gms.cast.internal.zzf.zza(this.zzacX, zzloVar.getPlayerId()) && zznb.zze(this.zzadn, zzloVar.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzadn;
    }

    public String getPlayerId() {
        return this.zzacX;
    }

    public int getPlayerState() {
        return this.zzabo;
    }
}
