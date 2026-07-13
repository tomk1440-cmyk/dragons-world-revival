package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class zzse extends com.google.android.gms.common.internal.zzj<zzrz> {
    private final Context mContext;
    private final int mTheme;
    private final String zzVa;
    private final int zzbpM;
    private final boolean zzbpN;

    private static class zza extends zzsc.zza {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(int i, boolean z, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(Status status, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(Status status, GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(Status status, GetInstrumentsResponse getInstrumentsResponse, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zza(Status status, boolean z, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zzb(int i, boolean z, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzsc
        public void zzj(int i, Bundle bundle) {
        }
    }

    private static class zzb extends zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<BooleanResult> zzamC;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<BooleanResult> zzbVar) {
            super();
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zza(Status status, boolean z, Bundle bundle) {
            this.zzamC.zzs(new BooleanResult(status, z));
        }
    }

    static final class zzc extends zza {
        private final int zzagz;
        private final WeakReference<Activity> zzbqC;

        public zzc(Context context, int i) {
            super();
            this.zzbqC = new WeakReference<>((Activity) context);
            this.zzagz = i;
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
            int i2;
            Activity activity = this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzagz);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (pendingIntentCreatePendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(i2);
            } catch (PendingIntent.CanceledException e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
            int i2;
            Activity activity = this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzagz);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Intent intent = new Intent();
            if (connectionResult.isSuccess()) {
                i2 = -1;
                intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
            }
            PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (pendingIntentCreatePendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(i2);
            } catch (PendingIntent.CanceledException e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zza(int i, boolean z, Bundle bundle) {
            Activity activity = this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (pendingIntentCreatePendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zza(Status status, boolean z, Bundle bundle) {
            Activity activity = this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsReadyToPayDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_READY_TO_PAY, z);
            PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (pendingIntentCreatePendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsReadyToPayDetermined");
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result in onIsReadyToPayDetermined", e);
            }
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zzb(int i, boolean z, Bundle bundle) {
            Activity activity = this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_NEW_USER, z);
            PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (pendingIntentCreatePendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        @Override // com.google.android.gms.internal.zzse.zza, com.google.android.gms.internal.zzsc
        public void zzj(int i, Bundle bundle) {
            com.google.android.gms.common.internal.zzx.zzb(bundle, "Bundle should not be null");
            Activity activity = this.zzbqC.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzagz);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
            PendingIntent pendingIntentCreatePendingResult = activity.createPendingResult(this.zzagz, intent, 1073741824);
            if (pendingIntentCreatePendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(1);
            } catch (PendingIntent.CanceledException e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public zzse(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i, int i2, boolean z) {
        super(context, looper, 4, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzbpM = i;
        this.zzVa = zzfVar.getAccountName();
        this.mTheme = i2;
        this.zzbpN = z;
    }

    private Bundle zzIp() {
        return zza(this.zzbpM, this.mContext.getPackageName(), this.zzVa, this.mTheme, this.zzbpN);
    }

    public static Bundle zza(int i, String str, String str2, int i2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putBoolean("com.google.android.gms.wallet.EXTRA_USING_ANDROID_PAY_BRAND", z);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    public void zza(FullWalletRequest fullWalletRequest, int i) {
        zzc zzcVar = new zzc(this.mContext, i);
        try {
            zzqJ().zza(fullWalletRequest, zzIp(), zzcVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            zzcVar.zza(8, (FullWallet) null, Bundle.EMPTY);
        }
    }

    public void zza(IsReadyToPayRequest isReadyToPayRequest, com.google.android.gms.common.api.internal.zza.zzb<BooleanResult> zzbVar) {
        zzb zzbVar2 = new zzb(zzbVar);
        try {
            zzqJ().zza(isReadyToPayRequest, zzIp(), zzbVar2);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during isReadyToPay", e);
            zzbVar2.zza(Status.zzagE, false, Bundle.EMPTY);
        }
    }

    public void zza(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle bundleZzIp = zzIp();
        zzc zzcVar = new zzc(this.mContext, i);
        try {
            zzqJ().zza(maskedWalletRequest, bundleZzIp, zzcVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            zzcVar.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            zzqJ().zza(notifyTransactionStatusRequest, zzIp());
        } catch (RemoteException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzep, reason: merged with bridge method [inline-methods] */
    public zzrz zzW(IBinder iBinder) {
        return zzrz.zza.zzel(iBinder);
    }

    public void zzf(String str, String str2, int i) {
        Bundle bundleZzIp = zzIp();
        zzc zzcVar = new zzc(this.mContext, i);
        try {
            zzqJ().zza(str, str2, bundleZzIp, zzcVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            zzcVar.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void zzln(int i) {
        Bundle bundleZzIp = zzIp();
        zzc zzcVar = new zzc(this.mContext, i);
        try {
            zzqJ().zza(bundleZzIp, zzcVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            zzcVar.zza(8, false, Bundle.EMPTY);
        }
    }

    public void zzlo(int i) {
        Bundle bundleZzIp = zzIp();
        zzc zzcVar = new zzc(this.mContext, i);
        try {
            zzqJ().zzb(bundleZzIp, zzcVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during isNewUser", e);
            zzcVar.zzb(8, false, Bundle.EMPTY);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzqK() {
        return true;
    }
}
