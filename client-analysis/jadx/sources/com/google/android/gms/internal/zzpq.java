package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzpq extends com.google.android.gms.measurement.zze<zzpq> {
    private String zzSE;
    private String zzSF;
    private String zzaUE;
    private String zzaUa;

    public void setAppId(String value) {
        this.zzaUa = value;
    }

    public void setAppInstallerId(String value) {
        this.zzaUE = value;
    }

    public void setAppName(String value) {
        this.zzSE = value;
    }

    public void setAppVersion(String value) {
        this.zzSF = value;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("appName", this.zzSE);
        map.put("appVersion", this.zzSF);
        map.put("appId", this.zzaUa);
        map.put("appInstallerId", this.zzaUE);
        return zzF(map);
    }

    public String zzAJ() {
        return this.zzaUE;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpq zzpqVar) {
        if (!TextUtils.isEmpty(this.zzSE)) {
            zzpqVar.setAppName(this.zzSE);
        }
        if (!TextUtils.isEmpty(this.zzSF)) {
            zzpqVar.setAppVersion(this.zzSF);
        }
        if (!TextUtils.isEmpty(this.zzaUa)) {
            zzpqVar.setAppId(this.zzaUa);
        }
        if (TextUtils.isEmpty(this.zzaUE)) {
            return;
        }
        zzpqVar.setAppInstallerId(this.zzaUE);
    }

    public String zzlg() {
        return this.zzSE;
    }

    public String zzli() {
        return this.zzSF;
    }

    public String zzwK() {
        return this.zzaUa;
    }
}
