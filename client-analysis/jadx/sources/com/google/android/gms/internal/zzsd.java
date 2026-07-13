package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingRemoteException"})
public class zzsd implements Payments {
    @Override // com.google.android.gms.wallet.Payments
    public void changeMaskedWallet(GoogleApiClient googleApiClient, final String googleTransactionId, final String merchantTransactionId, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zzf(googleTransactionId, merchantTransactionId, requestCode);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zzln(requestCode);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zzlo(requestCode);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public PendingResult<BooleanResult> isReadyToPay(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new Wallet.zza<BooleanResult>(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzA, reason: merged with bridge method [inline-methods] */
            public BooleanResult zzc(Status status) {
                return new BooleanResult(status, false);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zza(IsReadyToPayRequest.zzIj().zzIk(), this);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zza(request, requestCode);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zza(request, requestCode);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.wallet.Payments
    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new Wallet.zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzsd.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzse zzseVar) {
                zzseVar.zza(request);
                zza(Status.zzagC);
            }
        });
    }
}
