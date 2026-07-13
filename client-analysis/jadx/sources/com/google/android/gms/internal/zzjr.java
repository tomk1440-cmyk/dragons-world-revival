package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzjr {
    public zzjp zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, zzanVar, versionInfoParcel, null, null);
    }

    public zzjp zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzanVar, VersionInfoParcel versionInfoParcel, zzcb zzcbVar, com.google.android.gms.ads.internal.zzd zzdVar) {
        zzjs zzjsVar = new zzjs(zzjt.zzb(context, adSizeParcel, z, z2, zzanVar, versionInfoParcel, zzcbVar, zzdVar));
        zzjsVar.setWebViewClient(com.google.android.gms.ads.internal.zzr.zzbE().zzb(zzjsVar, z2));
        zzjsVar.setWebChromeClient(com.google.android.gms.ads.internal.zzr.zzbE().zzk(zzjsVar));
        return zzjsVar;
    }
}
