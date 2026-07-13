package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzbu extends zzd {
    private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

    public zzbu(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
        this.zzamC = zzbVar;
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void onError(Status status) throws RemoteException {
        this.zzamC.zzs(status);
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void onSuccess() throws RemoteException {
        this.zzamC.zzs(Status.zzagC);
    }
}
