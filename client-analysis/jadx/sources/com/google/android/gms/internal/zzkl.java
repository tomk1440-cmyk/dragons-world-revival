package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzkl implements AppInviteApi {

    static class zza extends zzko.zza {
        zza() {
        }

        @Override // com.google.android.gms.internal.zzko
        public void zza(Status status, Intent intent) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzko
        public void zzd(Status status) throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    static abstract class zzb<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzkm> {
        public zzb(GoogleApiClient googleApiClient) {
            super(AppInvite.zzUI, googleApiClient);
        }
    }

    final class zzc extends zzb<Status> {
        private final String zzUO;

        public zzc(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzUO = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzkm zzkmVar) throws RemoteException {
            zzkmVar.zzb(new zza() { // from class: com.google.android.gms.internal.zzkl.zzc.1
                @Override // com.google.android.gms.internal.zzkl.zza, com.google.android.gms.internal.zzko
                public void zzd(Status status) throws RemoteException {
                    zzc.this.zza(status);
                }
            }, this.zzUO);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    final class zzd extends zzb<Status> {
        private final String zzUO;

        public zzd(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzUO = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzkm zzkmVar) throws RemoteException {
            zzkmVar.zza(new zza() { // from class: com.google.android.gms.internal.zzkl.zzd.1
                @Override // com.google.android.gms.internal.zzkl.zza, com.google.android.gms.internal.zzko
                public void zzd(Status status) throws RemoteException {
                    zzd.this.zza(status);
                }
            }, this.zzUO);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    final class zze extends zzb<AppInviteInvitationResult> {
        private final Activity zzUS;
        private final boolean zzUT;
        private final Intent zzUU;

        public zze(GoogleApiClient googleApiClient, Activity activity, boolean z) {
            super(googleApiClient);
            this.zzUS = activity;
            this.zzUT = z;
            this.zzUU = this.zzUS != null ? this.zzUS.getIntent() : null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzkm zzkmVar) throws RemoteException {
            if (AppInviteReferral.hasReferral(this.zzUU)) {
                zza(new zzkn(Status.zzagC, this.zzUU));
            } else {
                zzkmVar.zza((zzko) new zza() { // from class: com.google.android.gms.internal.zzkl.zze.1
                    @Override // com.google.android.gms.internal.zzkl.zza, com.google.android.gms.internal.zzko
                    public void zza(Status status, Intent intent) {
                        zze.this.zza(new zzkn(status, intent));
                        if (AppInviteReferral.hasReferral(intent) && zze.this.zzUT && zze.this.zzUS != null) {
                            zze.this.zzUS.startActivity(intent);
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public AppInviteInvitationResult zzc(Status status) {
            return new zzkn(status, new Intent());
        }
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzd(client, invitationId));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult<AppInviteInvitationResult> getInvitation(GoogleApiClient client, Activity currentActivity, boolean launchDeepLink) {
        return client.zza(new zze(client, currentActivity, launchDeepLink));
    }

    @Override // com.google.android.gms.appinvite.AppInviteApi
    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(client, invitationId));
    }
}
