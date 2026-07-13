package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzf;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.auth.api.signin.zzg;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzld;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Auth {
    public static final Api.zzc<zzkz> zzVt = new Api.zzc<>();
    public static final Api.zzc<zzf> zzVu = new Api.zzc<>();
    public static final Api.zzc<zzks> zzVv = new Api.zzc<>();
    public static final Api.zzc<zzo> zzVw = new Api.zzc<>();
    public static final Api.zzc<zzd> zzVx = new Api.zzc<>();
    public static final Api.zzc<zzkw> zzVy = new Api.zzc<>();
    private static final Api.zza<zzkz, zza> zzVz = new Api.zza<zzkz, zza>() { // from class: com.google.android.gms.auth.api.Auth.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zzkz zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zza zzaVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkz(context, looper, zzfVar, zzaVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzf, AuthCredentialsOptions> zzVA = new Api.zza<zzf, AuthCredentialsOptions>() { // from class: com.google.android.gms.auth.api.Auth.2
        @Override // com.google.android.gms.common.api.Api.zza
        public zzf zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzf(context, looper, zzfVar, authCredentialsOptions, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzks, Api.ApiOptions.NoOptions> zzVB = new Api.zza<zzks, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.auth.api.Auth.3
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public zzks zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzks(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzkw, Api.ApiOptions.NoOptions> zzVC = new Api.zza<zzkw, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.auth.api.Auth.4
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
        public zzkw zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkw(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzo, zzg> zzVD = new Api.zza<zzo, zzg>() { // from class: com.google.android.gms.auth.api.Auth.5
        @Override // com.google.android.gms.common.api.Api.zza
        public zzo zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzo(context, looper, zzfVar, zzgVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    private static final Api.zza<zzd, GoogleSignInOptions> zzVE = new Api.zza<zzd, GoogleSignInOptions>() { // from class: com.google.android.gms.auth.api.Auth.6
        @Override // com.google.android.gms.common.api.Api.zza
        public zzd zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, @Nullable GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, zzfVar, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
        }

        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public List<Scope> zzo(@Nullable GoogleSignInOptions googleSignInOptions) {
            return googleSignInOptions == null ? Collections.emptyList() : googleSignInOptions.zzmN();
        }
    };
    public static final Api<zza> PROXY_API = new Api<>("Auth.PROXY_API", zzVz, zzVt);
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", zzVA, zzVu);
    public static final Api<zzg> zzVF = new Api<>("Auth.SIGN_IN_API", zzVD, zzVw);
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", zzVE, zzVx);
    public static final Api<Api.ApiOptions.NoOptions> zzVG = new Api<>("Auth.ACCOUNT_STATUS_API", zzVB, zzVv);
    public static final Api<Api.ApiOptions.NoOptions> zzVH = new Api<>("Auth.CONSENT_API", zzVC, zzVy);
    public static final ProxyApi ProxyApi = new zzld();
    public static final CredentialsApi CredentialsApi = new com.google.android.gms.auth.api.credentials.internal.zzd();
    public static final zzkq zzVI = new zzkr();
    public static final com.google.android.gms.auth.api.signin.zzf zzVJ = new zzn();
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    public static final com.google.android.gms.auth.api.consent.zza zzVK = new zzkv();

    public static final class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        private final String zzVL;
        private final PasswordSpecification zzVM;

        public static class Builder {

            @NonNull
            private PasswordSpecification zzVM = PasswordSpecification.zzWl;
        }

        public Bundle zzml() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.zzVL);
            bundle.putParcelable("password_specification", this.zzVM);
            return bundle;
        }

        public PasswordSpecification zzmr() {
            return this.zzVM;
        }
    }

    public static final class zza implements Api.ApiOptions.Optional {
        private final Bundle zzVN;

        public Bundle zzms() {
            return new Bundle(this.zzVN);
        }
    }

    private Auth() {
    }
}
