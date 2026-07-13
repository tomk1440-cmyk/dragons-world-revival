package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzpx extends com.google.android.gms.measurement.zze<zzpx> {
    public String zzSU;
    public String zzaUY;
    public String zzaUZ;

    public String getAction() {
        return this.zzSU;
    }

    public String getTarget() {
        return this.zzaUZ;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("network", this.zzaUY);
        map.put(NativeProtocol.WEB_DIALOG_ACTION, this.zzSU);
        map.put("target", this.zzaUZ);
        return zzF(map);
    }

    public String zzBg() {
        return this.zzaUY;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpx zzpxVar) {
        if (!TextUtils.isEmpty(this.zzaUY)) {
            zzpxVar.zzeJ(this.zzaUY);
        }
        if (!TextUtils.isEmpty(this.zzSU)) {
            zzpxVar.zzeF(this.zzSU);
        }
        if (TextUtils.isEmpty(this.zzaUZ)) {
            return;
        }
        zzpxVar.zzeK(this.zzaUZ);
    }

    public void zzeF(String str) {
        this.zzSU = str;
    }

    public void zzeJ(String str) {
        this.zzaUY = str;
    }

    public void zzeK(String str) {
        this.zzaUZ = str;
    }
}
