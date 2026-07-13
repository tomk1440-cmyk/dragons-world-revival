package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;

/* JADX INFO: loaded from: classes.dex */
public class zzrk implements SearchAuthApi {

    static abstract class zza extends zzrh.zza {
        zza() {
        }

        @Override // com.google.android.gms.internal.zzrh
        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzrh
        public void zzbj(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<Status, zzrj> {
        private final String zzXI;
        private final String zzbgJ;
        private final boolean zzbgK;

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzUI, googleApiClient);
            this.zzbgK = Log.isLoggable("SearchAuth", 3);
            this.zzXI = str;
            this.zzbgJ = googleApiClient.getContext().getPackageName();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzrj zzrjVar) throws RemoteException {
            if (this.zzbgK) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            zzrjVar.zzqJ().zzb(new zza() { // from class: com.google.android.gms.internal.zzrk.zzb.1
                @Override // com.google.android.gms.internal.zzrk.zza, com.google.android.gms.internal.zzrh
                public void zzbj(Status status) {
                    if (zzb.this.zzbgK) {
                        Log.d("SearchAuth", "ClearTokenImpl success");
                    }
                    zzb.this.zza(status);
                }
            }, this.zzbgJ, this.zzXI);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            if (this.zzbgK) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }
    }

    static class zzc extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<SearchAuthApi.GoogleNowAuthResult, zzrj> {
        private final String zzbgJ;
        private final boolean zzbgK;
        private final String zzbgM;

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzUI, googleApiClient);
            this.zzbgK = Log.isLoggable("SearchAuth", 3);
            this.zzbgM = str;
            this.zzbgJ = googleApiClient.getContext().getPackageName();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzrj zzrjVar) throws RemoteException {
            if (this.zzbgK) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            zzrjVar.zzqJ().zza(new zza() { // from class: com.google.android.gms.internal.zzrk.zzc.1
                @Override // com.google.android.gms.internal.zzrk.zza, com.google.android.gms.internal.zzrh
                public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                    if (zzc.this.zzbgK) {
                        Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                    }
                    zzc.this.zza(new zzd(status, googleNowAuthState));
                }
            }, this.zzbgJ, this.zzbgM);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzbk, reason: merged with bridge method [inline-methods] */
        public SearchAuthApi.GoogleNowAuthResult zzc(Status status) {
            if (this.zzbgK) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, null);
        }
    }

    static class zzd implements SearchAuthApi.GoogleNowAuthResult {
        private final Status zzUX;
        private final GoogleNowAuthState zzbgO;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzUX = status;
            this.zzbgO = googleNowAuthState;
        }

        @Override // com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult
        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzbgO;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    @Override // com.google.android.gms.search.SearchAuthApi
    public PendingResult<Status> clearToken(GoogleApiClient client, String accessToken) {
        return client.zza(new zzb(client, accessToken));
    }

    @Override // com.google.android.gms.search.SearchAuthApi
    public PendingResult<SearchAuthApi.GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzc(client, webAppClientId));
    }
}
