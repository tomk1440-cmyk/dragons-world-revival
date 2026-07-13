package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzcx extends zzcs.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzyT;

    public zzcx(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzyT = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcs
    public void zza(zzcn zzcnVar) {
        this.zzyT.onContentAdLoaded(zzb(zzcnVar));
    }

    zzco zzb(zzcn zzcnVar) {
        return new zzco(zzcnVar);
    }
}
