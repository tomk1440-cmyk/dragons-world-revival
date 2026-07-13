package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

/* JADX INFO: loaded from: classes.dex */
public class zzaa implements DrivePreferencesApi {

    private class zza extends zzd {
        private final com.google.android.gms.common.api.internal.zza.zzb<DrivePreferencesApi.FileUploadPreferencesResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<DrivePreferencesApi.FileUploadPreferencesResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void onError(Status status) throws RemoteException {
            this.zzamC.zzs(new zzb(status, null));
        }

        @Override // com.google.android.gms.drive.internal.zzd, com.google.android.gms.drive.internal.zzan
        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzamC.zzs(new zzb(Status.zzagC, onDeviceUsagePreferenceResponse.zztp()));
        }
    }

    private class zzb implements DrivePreferencesApi.FileUploadPreferencesResult {
        private final Status zzUX;
        private final FileUploadPreferences zzarw;

        private zzb(Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzUX = status;
            this.zzarw = fileUploadPreferences;
        }

        @Override // com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzarw;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private abstract class zzc extends zzt<DrivePreferencesApi.FileUploadPreferencesResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzG, reason: merged with bridge method [inline-methods] */
        public DrivePreferencesApi.FileUploadPreferencesResult zzc(Status status) {
            return new zzb(status, null);
        }
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public PendingResult<DrivePreferencesApi.FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(apiClient) { // from class: com.google.android.gms.drive.internal.zzaa.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zzd(new zza(this));
            }
        });
    }

    @Override // com.google.android.gms.drive.DrivePreferencesApi
    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (!(fileUploadPreferences instanceof FileUploadPreferencesImpl)) {
            throw new IllegalArgumentException("Invalid preference value");
        }
        final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
        return apiClient.zzb(new zzt.zza(apiClient) { // from class: com.google.android.gms.drive.internal.zzaa.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzu zzuVar) throws RemoteException {
                zzuVar.zzte().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbu(this));
            }
        });
    }
}
