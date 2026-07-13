package com.google.android.gms.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzik {
    private int zzLJ;
    private int zzLK;
    private final String zzLh;
    private final Object zzpV;
    private final zzih zzqV;

    zzik(zzih zzihVar, String str) {
        this.zzpV = new Object();
        this.zzqV = zzihVar;
        this.zzLh = str;
    }

    public zzik(String str) {
        this(com.google.android.gms.ads.internal.zzr.zzbF(), str);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzpV) {
            bundle = new Bundle();
            bundle.putInt("pmnli", this.zzLJ);
            bundle.putInt("pmnll", this.zzLK);
        }
        return bundle;
    }

    public void zzg(int i, int i2) {
        synchronized (this.zzpV) {
            this.zzLJ = i;
            this.zzLK = i2;
            this.zzqV.zza(this.zzLh, this);
        }
    }
}
