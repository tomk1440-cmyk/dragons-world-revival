package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzo extends com.google.android.gms.common.internal.zzj<zzm> {
    public zzo(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 93, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdo, reason: merged with bridge method [inline-methods] */
    public zzm zzW(IBinder iBinder) {
        return zzm.zza.zzdn(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.measurement.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }
}
