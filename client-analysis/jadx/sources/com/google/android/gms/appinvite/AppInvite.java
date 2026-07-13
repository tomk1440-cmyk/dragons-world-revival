package com.google.android.gms.appinvite;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;

/* JADX INFO: loaded from: classes.dex */
public final class AppInvite {
    public static final Api.zzc<zzkm> zzUI = new Api.zzc<>();
    private static final Api.zza<zzkm, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzkm, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.appinvite.AppInvite.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public zzkm zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkm(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("AppInvite.API", zzUJ, zzUI);
    public static final AppInviteApi AppInviteApi = new zzkl();

    private AppInvite() {
    }
}
