package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzmf {
    public static final Api.zzc<zzmj> zzUI = new Api.zzc<>();
    private static final Api.zza<zzmj, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzmj, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.internal.zzmf.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
        public zzmj zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzmj(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Common.API", zzUJ, zzUI);
    public static final zzmg zzamA = new zzmh();
}
