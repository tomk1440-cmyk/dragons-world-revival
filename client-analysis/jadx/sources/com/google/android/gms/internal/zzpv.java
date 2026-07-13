package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzpv extends com.google.android.gms.measurement.zze<zzpv> {
    public boolean zzaUP;
    public String zzaxl;

    public String getDescription() {
        return this.zzaxl;
    }

    public void setDescription(String description) {
        this.zzaxl = description;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("description", this.zzaxl);
        map.put("fatal", Boolean.valueOf(this.zzaUP));
        return zzF(map);
    }

    public boolean zzBa() {
        return this.zzaUP;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpv zzpvVar) {
        if (!TextUtils.isEmpty(this.zzaxl)) {
            zzpvVar.setDescription(this.zzaxl);
        }
        if (this.zzaUP) {
            zzpvVar.zzao(this.zzaUP);
        }
    }

    public void zzao(boolean z) {
        this.zzaUP = z;
    }
}
