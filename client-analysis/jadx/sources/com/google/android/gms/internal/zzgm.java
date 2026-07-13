package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzgm extends zzgh.zza {
    private final PlayStorePurchaseListener zzuP;

    public zzgm(PlayStorePurchaseListener playStorePurchaseListener) {
        this.zzuP = playStorePurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzgh
    public boolean isValidPurchase(String productId) {
        return this.zzuP.isValidPurchase(productId);
    }

    @Override // com.google.android.gms.internal.zzgh
    public void zza(zzgg zzggVar) {
        this.zzuP.onInAppPurchaseFinished(new zzgk(zzggVar));
    }
}
