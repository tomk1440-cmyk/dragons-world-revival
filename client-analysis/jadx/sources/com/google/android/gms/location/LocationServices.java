package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.zzl;
import com.google.android.gms.location.internal.zzq;

/* JADX INFO: loaded from: classes.dex */
public class LocationServices {
    private static final Api.zzc<zzl> zzUI = new Api.zzc<>();
    private static final Api.zza<zzl, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzl, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.location.LocationServices.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
        public zzl zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzl(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zzfVar);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("LocationServices.API", zzUJ, zzUI);
    public static final FusedLocationProviderApi FusedLocationApi = new com.google.android.gms.location.internal.zzd();
    public static final GeofencingApi GeofencingApi = new com.google.android.gms.location.internal.zzf();
    public static final SettingsApi SettingsApi = new zzq();

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzl> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzUI, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzl zzi(GoogleApiClient googleApiClient) {
        zzx.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzl zzlVar = (zzl) googleApiClient.zza(zzUI);
        zzx.zza(zzlVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzlVar;
    }
}
