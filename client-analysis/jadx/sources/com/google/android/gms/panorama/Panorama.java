package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqr;

/* JADX INFO: loaded from: classes.dex */
public final class Panorama {
    public static final Api.zzc<zzqr> zzUI = new Api.zzc<>();
    static final Api.zza<zzqr, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzqr, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.panorama.Panorama.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public zzqr zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqr(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("Panorama.API", zzUJ, zzUI);
    public static final PanoramaApi PanoramaApi = new zzqq();

    private Panorama() {
    }
}
