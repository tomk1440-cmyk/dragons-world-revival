package com.google.android.gms.nearby.sharing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements com.google.android.gms.nearby.sharing.zzd {
    public static final Api.zzc<zze> zzUI = new Api.zzc<>();
    public static final Api.zza<zze, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zze, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.nearby.sharing.internal.zzh.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public zze zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zze(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
        }
    };
}
