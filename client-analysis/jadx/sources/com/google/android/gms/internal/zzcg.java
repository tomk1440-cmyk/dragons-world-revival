package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzcg extends zzcf.zza {
    private final OnCustomRenderedAdLoadedListener zzuQ;

    public zzcg(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzuQ = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcf
    public void zza(zzce zzceVar) {
        this.zzuQ.onCustomRenderedAdLoaded(new zzcd(zzceVar));
    }
}
