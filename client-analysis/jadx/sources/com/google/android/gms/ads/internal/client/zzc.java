package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzc extends zzq.zza {
    private final AdListener zztA;

    public zzc(AdListener adListener) {
        this.zztA = adListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdClosed() {
        this.zztA.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdFailedToLoad(int errorCode) {
        this.zztA.onAdFailedToLoad(errorCode);
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdLeftApplication() {
        this.zztA.onAdLeftApplication();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdLoaded() {
        this.zztA.onAdLoaded();
    }

    @Override // com.google.android.gms.ads.internal.client.zzq
    public void onAdOpened() {
        this.zztA.onAdOpened();
    }
}
