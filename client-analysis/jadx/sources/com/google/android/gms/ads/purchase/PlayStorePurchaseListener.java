package com.google.android.gms.ads.purchase;

/* JADX INFO: loaded from: classes.dex */
public interface PlayStorePurchaseListener {
    boolean isValidPurchase(String str);

    void onInAppPurchaseFinished(InAppPurchaseResult inAppPurchaseResult);
}
