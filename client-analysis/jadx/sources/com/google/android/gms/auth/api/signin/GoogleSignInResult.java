package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class GoogleSignInResult implements Result {
    private Status zzUX;
    private GoogleSignInAccount zzXg;

    public GoogleSignInResult(@Nullable GoogleSignInAccount SignInAccount, @NonNull Status status) {
        this.zzXg = SignInAccount;
        this.zzUX = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.zzXg;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.zzUX;
    }

    public boolean isSuccess() {
        return this.zzUX.isSuccess();
    }
}
