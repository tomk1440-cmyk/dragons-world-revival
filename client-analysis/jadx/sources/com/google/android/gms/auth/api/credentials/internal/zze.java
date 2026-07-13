package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes.dex */
abstract class zze<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzf> {
    zze(GoogleApiClient googleApiClient) {
        super(Auth.zzVu, googleApiClient);
    }

    protected abstract void zza(Context context, zzj zzjVar) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
    public final void zza(zzf zzfVar) throws RemoteException {
        zza(zzfVar.getContext(), zzfVar.zzqJ());
    }
}
