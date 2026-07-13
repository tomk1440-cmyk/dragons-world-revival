package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.AddressConstants;
import com.google.android.gms.identity.intents.UserAddressRequest;

/* JADX INFO: loaded from: classes.dex */
public class zzpn extends com.google.android.gms.common.internal.zzj<zzpp> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzVa;
    private zza zzaMC;

    public static final class zza extends zzpo.zza {
        private Activity mActivity;
        private final int zzagz;

        public zza(int i, Activity activity) {
            this.zzagz = i;
            this.mActivity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        @Override // com.google.android.gms.internal.zzpo
        public void zzh(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent pendingIntentCreatePendingResult = this.mActivity.createPendingResult(this.zzagz, intent, 1073741824);
                if (pendingIntentCreatePendingResult == null) {
                    return;
                }
                try {
                    pendingIntentCreatePendingResult.send(1);
                    return;
                } catch (PendingIntent.CanceledException e) {
                    Log.w("AddressClientImpl", "Exception settng pending result", e);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this.mActivity, this.zzagz);
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                PendingIntent pendingIntentCreatePendingResult2 = this.mActivity.createPendingResult(this.zzagz, new Intent(), 1073741824);
                if (pendingIntentCreatePendingResult2 != null) {
                    pendingIntentCreatePendingResult2.send(1);
                }
            } catch (PendingIntent.CanceledException e3) {
                Log.w("AddressClientImpl", "Exception setting pending result", e3);
            }
        }
    }

    public zzpn(Activity activity, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzVa = zzfVar.getAccountName();
        this.mActivity = activity;
        this.mTheme = i;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        super.disconnect();
        if (this.zzaMC != null) {
            this.zzaMC.setActivity(null);
            this.zzaMC = null;
        }
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzyx();
        this.zzaMC = new zza(i, this.mActivity);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzVa)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzVa, "com.google"));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzyw().zza(this.zzaMC, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(AddressConstants.Extras.EXTRA_ERROR_CODE, AddressConstants.ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzaMC.zzh(1, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzca, reason: merged with bridge method [inline-methods] */
    public zzpp zzW(IBinder iBinder) {
        return zzpp.zza.zzcc(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.identity.service.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzqK() {
        return true;
    }

    protected zzpp zzyw() throws DeadObjectException {
        return (zzpp) super.zzqJ();
    }

    protected void zzyx() {
        super.zzqI();
    }
}
