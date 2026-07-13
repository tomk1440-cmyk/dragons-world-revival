package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzad<T extends IInterface> extends zzj<T> {
    private final Api.zzd<T> zzamx;

    public zzad(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzf zzfVar, Api.zzd zzdVar) {
        super(context, looper, i, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzamx = zzdVar;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected T zzW(IBinder iBinder) {
        return (T) this.zzamx.zzW(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zzc(int i, T t) {
        this.zzamx.zza(i, t);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return this.zzamx.zzgu();
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return this.zzamx.zzgv();
    }
}
