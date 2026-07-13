package com.google.android.gms.appdatasearch;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkk;

/* JADX INFO: loaded from: classes.dex */
public final class zza {
    public static final Api.zzc<zzki> zzTy = new Api.zzc<>();
    private static final Api.zza<zzki, Api.ApiOptions.NoOptions> zzTz = new Api.zza<zzki, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.appdatasearch.zza.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzki zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzki(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> zzTA = new Api<>("AppDataSearch.LIGHTWEIGHT_API", zzTz, zzTy);
    public static final zzk zzTB = new zzkk();
}
