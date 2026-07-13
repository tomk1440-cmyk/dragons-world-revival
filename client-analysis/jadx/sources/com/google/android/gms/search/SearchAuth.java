package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrj;
import com.google.android.gms.internal.zzrk;

/* JADX INFO: loaded from: classes.dex */
public class SearchAuth {
    private static final Api.zza<zzrj, Api.ApiOptions.NoOptions> zzbgI = new Api.zza<zzrj, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.search.SearchAuth.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public zzrj zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzrj(context, connectionCallbacks, onConnectionFailedListener, zzfVar);
        }
    };
    public static final Api.zzc<zzrj> zzUI = new Api.zzc<>();
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("SearchAuth.API", zzbgI, zzUI);
    public static final SearchAuthApi SearchAuthApi = new zzrk();

    public static class StatusCodes {
        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;
    }

    private SearchAuth() {
    }
}
