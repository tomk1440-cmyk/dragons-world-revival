package com.google.android.gms.auth.api.credentials.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzc implements CredentialRequestResult {
    private final Status zzUX;
    private final Credential zzWu;

    public zzc(Status status, Credential credential) {
        this.zzUX = status;
        this.zzWu = credential;
    }

    public static zzc zzh(Status status) {
        return new zzc(status, null);
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialRequestResult
    public Credential getCredential() {
        return this.zzWu;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }
}
