package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzo extends com.google.android.gms.common.internal.zzj<zzh> {
    private final com.google.android.gms.auth.api.signin.zzg zzXK;

    public zzo(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.auth.api.signin.zzg zzgVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzXK = (com.google.android.gms.auth.api.signin.zzg) zzx.zzz(zzgVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public zzh zzW(IBinder iBinder) {
        return zzh.zza.zzaD(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
