package com.google.android.gms.internal;

import android.content.Context;
import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzdv {
    private MutableContextWrapper zzAb;
    private final VersionInfoParcel zzpT;
    private final com.google.android.gms.ads.internal.zzd zzpm;
    private final zzex zzpn;

    zzdv(Context context, zzex zzexVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzd zzdVar) {
        this.zzAb = new MutableContextWrapper(context.getApplicationContext());
        this.zzpn = zzexVar;
        this.zzpT = versionInfoParcel;
        this.zzpm = zzdVar;
    }

    public com.google.android.gms.ads.internal.zzk zzX(String str) {
        return new com.google.android.gms.ads.internal.zzk(this.zzAb, new AdSizeParcel(), str, this.zzpn, this.zzpT, this.zzpm);
    }

    public zzdv zzec() {
        return new zzdv(this.zzAb.getBaseContext(), this.zzpn, this.zzpT, this.zzpm);
    }

    public MutableContextWrapper zzed() {
        return this.zzAb;
    }
}
