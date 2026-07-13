package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchase;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgl implements InAppPurchase {
    private final zzgc zzFL;

    public zzgl(zzgc zzgcVar) {
        this.zzFL = zzgcVar;
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchase
    public String getProductId() {
        try {
            return this.zzFL.getProductId();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward getProductId to InAppPurchase", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchase
    public void recordPlayBillingResolution(int billingResponseCode) {
        try {
            this.zzFL.recordPlayBillingResolution(billingResponseCode);
        } catch (RemoteException e) {
            zzin.zzd("Could not forward recordPlayBillingResolution to InAppPurchase", e);
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchase
    public void recordResolution(int resolution) {
        try {
            this.zzFL.recordResolution(resolution);
        } catch (RemoteException e) {
            zzin.zzd("Could not forward recordResolution to InAppPurchase", e);
        }
    }
}
