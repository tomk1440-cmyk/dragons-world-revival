package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public final class zzrl {
    public static final Api.zzc<com.google.android.gms.signin.internal.zzh> zzUI = new Api.zzc<>();
    public static final Api.zzc<com.google.android.gms.signin.internal.zzh> zzavN = new Api.zzc<>();
    public static final Api.zza<com.google.android.gms.signin.internal.zzh, zzro> zzUJ = new Api.zza<com.google.android.gms.signin.internal.zzh, zzro>() { // from class: com.google.android.gms.internal.zzrl.1
        @Override // com.google.android.gms.common.api.Api.zza
        public com.google.android.gms.signin.internal.zzh zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zzro zzroVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.signin.internal.zzh(context, looper, true, zzfVar, zzroVar == null ? zzro.zzbgV : zzroVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    static final Api.zza<com.google.android.gms.signin.internal.zzh, zza> zzbgS = new Api.zza<com.google.android.gms.signin.internal.zzh, zza>() { // from class: com.google.android.gms.internal.zzrl.2
        @Override // com.google.android.gms.common.api.Api.zza
        public com.google.android.gms.signin.internal.zzh zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new com.google.android.gms.signin.internal.zzh(context, looper, false, zzfVar, zzaVar.zzFF(), connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Scope zzWW = new Scope(Scopes.PROFILE);
    public static final Scope zzWX = new Scope("email");
    public static final Api<zzro> API = new Api<>("SignIn.API", zzUJ, zzUI);
    public static final Api<zza> zzaoG = new Api<>("SignIn.INTERNAL_API", zzbgS, zzavN);
    public static final zzrm zzbgT = new com.google.android.gms.signin.internal.zzg();

    public static class zza implements Api.ApiOptions.HasOptions {
        private final Bundle zzbgU;

        public Bundle zzFF() {
            return this.zzbgU;
        }
    }
}
