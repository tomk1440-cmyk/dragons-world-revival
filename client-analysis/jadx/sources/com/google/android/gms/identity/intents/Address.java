package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;

/* JADX INFO: loaded from: classes.dex */
public final class Address {
    static final Api.zzc<zzpn> zzUI = new Api.zzc<>();
    private static final Api.zza<zzpn, AddressOptions> zzUJ = new Api.zza<zzpn, AddressOptions>() { // from class: com.google.android.gms.identity.intents.Address.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzpn zza(Context context, Looper looper, zzf zzfVar, AddressOptions addressOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zzpn((Activity) context, looper, zzfVar, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<AddressOptions> API = new Api<>("Address.API", zzUJ, zzUI);

    public static final class AddressOptions implements Api.ApiOptions.HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<Status, zzpn> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzUI, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.identity.intents.Address.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzpn zzpnVar) throws RemoteException {
                zzpnVar.zza(request, requestCode);
                zza(Status.zzagC);
            }
        });
    }
}
