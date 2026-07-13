package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzp extends zze.zza {
    private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzbcS;

    private zzp(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
        this.zzbcS = zzbVar;
    }

    static zzp zzn(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
        return new zzp(zzbVar);
    }

    @Override // com.google.android.gms.nearby.messages.internal.zze
    public void zzbb(Status status) throws RemoteException {
        this.zzbcS.zzs(status);
    }
}
