package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzj extends com.google.android.gms.ads.internal.client.zzs.zza {
    private final Context mContext;
    private com.google.android.gms.ads.internal.client.zzq zzpK;
    private NativeAdOptionsParcel zzpP;
    private zzx zzpR;
    private final String zzpS;
    private final VersionInfoParcel zzpT;
    private zzcr zzpY;
    private zzcs zzpZ;
    private final zzd zzpm;
    private final zzex zzpn;
    private SimpleArrayMap<String, zzcu> zzqb = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzct> zzqa = new SimpleArrayMap<>();

    public zzj(Context context, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        this.mContext = context;
        this.zzpS = str;
        this.zzpn = zzexVar;
        this.zzpT = versionInfoParcel;
        this.zzpm = zzdVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.zzpP = nativeAdOptionsParcel;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzcr zzcrVar) {
        this.zzpY = zzcrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(zzcs zzcsVar) {
        this.zzpZ = zzcsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zza(String str, zzcu zzcuVar, zzct zzctVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzqb.put(str, zzcuVar);
        this.zzqa.put(str, zzctVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(com.google.android.gms.ads.internal.client.zzq zzqVar) {
        this.zzpK = zzqVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public void zzb(zzx zzxVar) {
        this.zzpR = zzxVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzs
    public com.google.android.gms.ads.internal.client.zzr zzbn() {
        return new zzi(this.mContext, this.zzpS, this.zzpn, this.zzpT, this.zzpK, this.zzpY, this.zzpZ, this.zzqb, this.zzqa, this.zzpP, this.zzpR, this.zzpm);
    }
}
