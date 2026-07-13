package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzgi extends zzgd.zza {
    private final InAppPurchaseListener zzuO;

    public zzgi(InAppPurchaseListener inAppPurchaseListener) {
        this.zzuO = inAppPurchaseListener;
    }

    @Override // com.google.android.gms.internal.zzgd
    public void zza(zzgc zzgcVar) {
        this.zzuO.onInAppPurchaseRequested(new zzgl(zzgcVar));
    }
}
