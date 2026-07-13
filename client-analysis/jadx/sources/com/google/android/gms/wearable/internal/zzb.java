package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzb<T> extends zzi<Status> {
    private T mListener;
    private com.google.android.gms.common.api.internal.zzq<T> zzbbi;
    private zza<T> zzbrA;

    interface zza<T> {
        void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, T t, com.google.android.gms.common.api.internal.zzq<T> zzqVar) throws RemoteException;
    }

    private zzb(GoogleApiClient googleApiClient, T t, com.google.android.gms.common.api.internal.zzq<T> zzqVar, zza<T> zzaVar) {
        super(googleApiClient);
        this.mListener = (T) com.google.android.gms.common.internal.zzx.zzz(t);
        this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        this.zzbrA = (zza) com.google.android.gms.common.internal.zzx.zzz(zzaVar);
    }

    static <T> PendingResult<Status> zza(GoogleApiClient googleApiClient, zza<T> zzaVar, T t) {
        return googleApiClient.zza(new zzb(googleApiClient, t, googleApiClient.zzr(t), zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
    public void zza(zzbp zzbpVar) throws RemoteException {
        this.zzbrA.zza(zzbpVar, this, this.mListener, this.zzbbi);
        this.mListener = null;
        this.zzbbi = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public Status zzc(Status status) {
        this.mListener = null;
        this.zzbbi = null;
        return status;
    }
}
