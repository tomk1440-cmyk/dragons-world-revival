package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzd {
    public final zzdt zzpw;
    public final com.google.android.gms.ads.internal.overlay.zzj zzpx;
    public final com.google.android.gms.ads.internal.overlay.zzm zzpy;

    public zzd(zzdt zzdtVar, com.google.android.gms.ads.internal.overlay.zzj zzjVar, com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzpw = zzdtVar;
        this.zzpx = zzjVar;
        this.zzpy = zzmVar;
    }

    public static zzd zzbg() {
        return new zzd(new zzdc(), new com.google.android.gms.ads.internal.overlay.zzn(), new com.google.android.gms.ads.internal.overlay.zzr());
    }
}
