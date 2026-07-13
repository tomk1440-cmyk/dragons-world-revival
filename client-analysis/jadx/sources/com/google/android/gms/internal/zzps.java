package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzps extends com.google.android.gms.measurement.zze<zzps> {
    public int zzDC;
    public int zzDD;
    public int zzaUL;
    public int zzaUM;
    public int zzaUN;
    private String zzaaL;

    public String getLanguage() {
        return this.zzaaL;
    }

    public void setLanguage(String language) {
        this.zzaaL = language;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("language", this.zzaaL);
        map.put("screenColors", Integer.valueOf(this.zzaUL));
        map.put("screenWidth", Integer.valueOf(this.zzDC));
        map.put("screenHeight", Integer.valueOf(this.zzDD));
        map.put("viewportWidth", Integer.valueOf(this.zzaUM));
        map.put("viewportHeight", Integer.valueOf(this.zzaUN));
        return zzF(map);
    }

    public int zzAQ() {
        return this.zzaUL;
    }

    public int zzAR() {
        return this.zzDC;
    }

    public int zzAS() {
        return this.zzDD;
    }

    public int zzAT() {
        return this.zzaUM;
    }

    public int zzAU() {
        return this.zzaUN;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzps zzpsVar) {
        if (this.zzaUL != 0) {
            zzpsVar.zziA(this.zzaUL);
        }
        if (this.zzDC != 0) {
            zzpsVar.zziB(this.zzDC);
        }
        if (this.zzDD != 0) {
            zzpsVar.zziC(this.zzDD);
        }
        if (this.zzaUM != 0) {
            zzpsVar.zziD(this.zzaUM);
        }
        if (this.zzaUN != 0) {
            zzpsVar.zziE(this.zzaUN);
        }
        if (TextUtils.isEmpty(this.zzaaL)) {
            return;
        }
        zzpsVar.setLanguage(this.zzaaL);
    }

    public void zziA(int i) {
        this.zzaUL = i;
    }

    public void zziB(int i) {
        this.zzDC = i;
    }

    public void zziC(int i) {
        this.zzDD = i;
    }

    public void zziD(int i) {
        this.zzaUM = i;
    }

    public void zziE(int i) {
        this.zzaUN = i;
    }
}
