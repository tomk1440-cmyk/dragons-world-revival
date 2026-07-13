package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class zzw extends zzab implements DriveFile {

    private static class zza implements DriveFile.DownloadProgressListener {
        private final com.google.android.gms.common.api.internal.zzq<DriveFile.DownloadProgressListener> zzari;

        public zza(com.google.android.gms.common.api.internal.zzq<DriveFile.DownloadProgressListener> zzqVar) {
            this.zzari = zzqVar;
        }

        @Override // com.google.android.gms.drive.DriveFile.DownloadProgressListener
        public void onProgress(final long bytesDownloaded, final long bytesExpected) {
            this.zzari.zza(new com.google.android.gms.common.api.internal.zzq.zzb<DriveFile.DownloadProgressListener>() { // from class: com.google.android.gms.drive.internal.zzw.zza.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(DriveFile.DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(bytesDownloaded, bytesExpected);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }
    }

    public zzw(DriveId driveId) {
        super(driveId);
    }

    private static DriveFile.DownloadProgressListener zza(GoogleApiClient googleApiClient, DriveFile.DownloadProgressListener downloadProgressListener) {
        if (downloadProgressListener == null) {
            return null;
        }
        return new zza(googleApiClient.zzr(downloadProgressListener));
    }

    @Override // com.google.android.gms.drive.DriveFile
    public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DriveFile.DownloadProgressListener listener) {
        if (mode != 268435456 && mode != 536870912 && mode != 805306368) {
            throw new IllegalArgumentException("Invalid mode provided.");
        }
        final DriveFile.DownloadProgressListener downloadProgressListenerZza = zza(apiClient, listener);
        return apiClient.zza(new zzs.zzc(apiClient) { // from class: com.google.android.gms.drive.internal.zzw.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zza(zzuVar.zzte().zza(new OpenContentsRequest(zzw.this.getDriveId(), mode, 0), new zzbl(this, downloadProgressListenerZza)).zztj());
            }
        });
    }
}
