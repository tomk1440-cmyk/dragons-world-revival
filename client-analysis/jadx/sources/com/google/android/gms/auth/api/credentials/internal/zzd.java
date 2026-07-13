package com.google.android.gms.auth.api.credentials.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes.dex */
public final class zzd implements CredentialsApi {

    private static class zza extends com.google.android.gms.auth.api.credentials.internal.zza {
        private com.google.android.gms.common.api.internal.zza.zzb<Status> zzWz;

        zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzWz = zzbVar;
        }

        @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.zzi
        public void zzg(Status status) {
            this.zzWz.zzs(status);
        }
    }

    private PasswordSpecification zza(GoogleApiClient googleApiClient) {
        Auth.AuthCredentialsOptions authCredentialsOptionsZzmD = ((zzf) googleApiClient.zza(Auth.zzVu)).zzmD();
        return (authCredentialsOptionsZzmD == null || authCredentialsOptionsZzmD.zzmr() == null) ? PasswordSpecification.zzWl : authCredentialsOptionsZzmD.zzmr();
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> delete(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zze<Status>(client) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.3
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzj zzjVar) throws RemoteException {
                zzjVar.zza(new zza(this), new DeleteRequest(credential));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> disableAutoSignIn(GoogleApiClient client) {
        return client.zzb(new zze<Status>(client) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.4
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzj zzjVar) throws RemoteException {
                zzjVar.zza(new zza(this));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingIntent getHintPickerIntent(GoogleApiClient client, HintRequest request) {
        zzx.zzb(client, "client must not be null");
        zzx.zzb(request, "request must not be null");
        zzx.zzb(client.zza(Auth.CREDENTIALS_API), "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return PendingIntent.getActivity(client.getContext(), 2000, zzb.zza(client.getContext(), request, zza(client)), DriveFile.MODE_READ_ONLY);
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<CredentialRequestResult> request(GoogleApiClient client, final CredentialRequest request) {
        return client.zza(new zze<CredentialRequestResult>(client) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.1
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzj zzjVar) throws RemoteException {
                zzjVar.zza(new com.google.android.gms.auth.api.credentials.internal.zza() { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.1.1
                    @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.zzi
                    public void zza(Status status, Credential credential) {
                        zza(new zzc(status, credential));
                    }

                    @Override // com.google.android.gms.auth.api.credentials.internal.zza, com.google.android.gms.auth.api.credentials.internal.zzi
                    public void zzg(Status status) {
                        zza(zzc.zzh(status));
                    }
                }, request);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
            public CredentialRequestResult zzc(Status status) {
                return zzc.zzh(status);
            }
        });
    }

    @Override // com.google.android.gms.auth.api.credentials.CredentialsApi
    public PendingResult<Status> save(GoogleApiClient client, final Credential credential) {
        return client.zzb(new zze<Status>(client) { // from class: com.google.android.gms.auth.api.credentials.internal.zzd.2
            @Override // com.google.android.gms.auth.api.credentials.internal.zze
            protected void zza(Context context, zzj zzjVar) throws RemoteException {
                zzjVar.zza(new zza(this), new SaveRequest(credential));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
