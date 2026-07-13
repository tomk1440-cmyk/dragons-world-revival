package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends com.google.android.gms.common.internal.zzj<zzj> {

    @Nullable
    private final Auth.AuthCredentialsOptions zzWA;

    public zzf(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Auth.AuthCredentialsOptions authCredentialsOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzWA = authCredentialsOptions;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzav, reason: merged with bridge method [inline-methods] */
    public zzj zzW(IBinder iBinder) {
        return zzj.zza.zzax(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    Auth.AuthCredentialsOptions zzmD() {
        return this.zzWA;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        return this.zzWA == null ? new Bundle() : this.zzWA.zzml();
    }
}
