package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzlw extends com.google.android.gms.common.internal.zzj<zzly> {
    public zzlw(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzlx zzlxVar, LogEventParcelable logEventParcelable) throws RemoteException {
        zzqJ().zza(zzlxVar, logEventParcelable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaK, reason: merged with bridge method [inline-methods] */
    public zzly zzW(IBinder iBinder) {
        return zzly.zza.zzaM(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.clearcut.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
