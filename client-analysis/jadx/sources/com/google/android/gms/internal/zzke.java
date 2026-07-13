package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzke extends com.google.android.gms.measurement.zze<zzke> {
    private String zzPN;
    private String zzPO;
    private String zzPP;
    private boolean zzPQ;
    private String zzPR;
    private boolean zzPS;
    private double zzPT;
    private String zzrG;

    public String getClientId() {
        return this.zzPO;
    }

    public String getUserId() {
        return this.zzrG;
    }

    public void setClientId(String clientId) {
        this.zzPO = clientId;
    }

    public void setSampleRate(double percentage) {
        com.google.android.gms.common.internal.zzx.zzb(percentage >= 0.0d && percentage <= 100.0d, "Sample rate must be between 0% and 100%");
        this.zzPT = percentage;
    }

    public void setUserId(String userId) {
        this.zzrG = userId;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("hitType", this.zzPN);
        map.put("clientId", this.zzPO);
        map.put("userId", this.zzrG);
        map.put("androidAdId", this.zzPP);
        map.put("AdTargetingEnabled", Boolean.valueOf(this.zzPQ));
        map.put("sessionControl", this.zzPR);
        map.put("nonInteraction", Boolean.valueOf(this.zzPS));
        map.put("sampleRate", Double.valueOf(this.zzPT));
        return zzF(map);
    }

    public void zzH(boolean z) {
        this.zzPQ = z;
    }

    public void zzI(boolean z) {
        this.zzPS = z;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzke zzkeVar) {
        if (!TextUtils.isEmpty(this.zzPN)) {
            zzkeVar.zzaX(this.zzPN);
        }
        if (!TextUtils.isEmpty(this.zzPO)) {
            zzkeVar.setClientId(this.zzPO);
        }
        if (!TextUtils.isEmpty(this.zzrG)) {
            zzkeVar.setUserId(this.zzrG);
        }
        if (!TextUtils.isEmpty(this.zzPP)) {
            zzkeVar.zzaY(this.zzPP);
        }
        if (this.zzPQ) {
            zzkeVar.zzH(true);
        }
        if (!TextUtils.isEmpty(this.zzPR)) {
            zzkeVar.zzaZ(this.zzPR);
        }
        if (this.zzPS) {
            zzkeVar.zzI(this.zzPS);
        }
        if (this.zzPT != 0.0d) {
            zzkeVar.setSampleRate(this.zzPT);
        }
    }

    public void zzaX(String str) {
        this.zzPN = str;
    }

    public void zzaY(String str) {
        this.zzPP = str;
    }

    public void zzaZ(String str) {
        this.zzPR = str;
    }

    public String zziS() {
        return this.zzPN;
    }

    public String zziT() {
        return this.zzPP;
    }

    public boolean zziU() {
        return this.zzPQ;
    }

    public String zziV() {
        return this.zzPR;
    }

    public boolean zziW() {
        return this.zzPS;
    }

    public double zziX() {
        return this.zzPT;
    }
}
