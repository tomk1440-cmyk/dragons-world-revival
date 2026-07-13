package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzcw extends zzcr.zza {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzyS;

    public zzcw(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzyS = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcr
    public void zza(zzcl zzclVar) {
        this.zzyS.onAppInstallAdLoaded(zzb(zzclVar));
    }

    zzcm zzb(zzcl zzclVar) {
        return new zzcm(zzclVar);
    }
}
