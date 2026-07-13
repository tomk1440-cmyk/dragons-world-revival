package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes.dex */
class zzbl extends zzd {
    private final com.google.android.gms.common.api.internal.zza.zzb<DriveApi.DriveContentsResult> zzamC;
    private final DriveFile.DownloadProgressListener zzasy;

    zzbl(com.google.android.gms.common.api.internal.zza.zzb<DriveApi.DriveContentsResult> zzbVar, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.zzamC = zzbVar;
        this.zzasy = downloadProgressListener;
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void onError(Status status) throws RemoteException {
        this.zzamC.zzs(new zzs.zzb(status, null));
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzamC.zzs(new zzs.zzb(onContentsResponse.zzto() ? new Status(-1) : Status.zzagC, new zzv(onContentsResponse.zztn())));
    }

    @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzasy != null) {
            this.zzasy.onProgress(onDownloadProgressResponse.zztq(), onDownloadProgressResponse.zztr());
        }
    }
}
