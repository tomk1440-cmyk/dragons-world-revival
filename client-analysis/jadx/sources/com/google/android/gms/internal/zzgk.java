package com.google.android.gms.internal;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.purchase.InAppPurchaseResult;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgk implements InAppPurchaseResult {
    private final zzgg zzGb;

    public zzgk(zzgg zzggVar) {
        this.zzGb = zzggVar;
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public void finishPurchase() {
        try {
            this.zzGb.finishPurchase();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward finishPurchase to InAppPurchaseResult", e);
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public String getProductId() {
        try {
            return this.zzGb.getProductId();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward getProductId to InAppPurchaseResult", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public Intent getPurchaseData() {
        try {
            return this.zzGb.getPurchaseData();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public int getResultCode() {
        try {
            return this.zzGb.getResultCode();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward getPurchaseData to InAppPurchaseResult", e);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.purchase.InAppPurchaseResult
    public boolean isVerified() {
        try {
            return this.zzGb.isVerified();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward isVerified to InAppPurchaseResult", e);
            return false;
        }
    }
}
