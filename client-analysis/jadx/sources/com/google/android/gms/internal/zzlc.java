package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
abstract class zzlc extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<ProxyApi.ProxyResult, zzkz> {
    public zzlc(GoogleApiClient googleApiClient) {
        super(Auth.zzVt, googleApiClient);
    }

    protected abstract void zza(Context context, zzlb zzlbVar) throws RemoteException;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
    public final void zza(zzkz zzkzVar) throws RemoteException {
        zza(zzkzVar.getContext(), zzkzVar.zzqJ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public ProxyApi.ProxyResult zzc(Status status) {
        return new zzle(status);
    }
}
