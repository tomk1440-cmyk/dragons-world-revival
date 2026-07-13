package com.google.android.gms.auth.api.signin;

import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements Api.ApiOptions.HasOptions {
    private final SignInConfiguration zzXo;

    public static class zza {
        private final SignInConfiguration zzXo;

        public zza(String str) {
            zzx.zzcM(str);
            this.zzXo = new SignInConfiguration(str);
        }

        public zza zzi(GoogleSignInOptions googleSignInOptions) {
            zzx.zzz(googleSignInOptions);
            this.zzXo.zzj(googleSignInOptions);
            return this;
        }

        public zzg zzmY() {
            zzx.zza((this.zzXo.zznl() == null && this.zzXo.zznm() == null) ? false : true, "Must support either Facebook, Google or Email sign-in.");
            return new zzg(this.zzXo);
        }
    }

    private zzg(SignInConfiguration signInConfiguration) {
        this.zzXo = signInConfiguration;
    }

    public SignInConfiguration zzmX() {
        return this.zzXo;
    }
}
