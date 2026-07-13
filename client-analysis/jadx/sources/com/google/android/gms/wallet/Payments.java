package com.google.android.gms.wallet;

import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

/* JADX INFO: loaded from: classes.dex */
public interface Payments {
    void changeMaskedWallet(GoogleApiClient googleApiClient, String str, String str2, int i);

    @Deprecated
    void checkForPreAuthorization(GoogleApiClient googleApiClient, int i);

    @Deprecated
    void isNewUser(GoogleApiClient googleApiClient, int i);

    PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient);

    void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest fullWalletRequest, int i);

    void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest maskedWalletRequest, int i);

    @Deprecated
    void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest notifyTransactionStatusRequest);
}
