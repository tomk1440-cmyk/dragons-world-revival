package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzre implements SafetyNetApi {

    static class zza implements SafetyNetApi.AttestationResult {
        private final Status zzUX;
        private final AttestationData zzbgB;

        public zza(Status status, AttestationData attestationData) {
            this.zzUX = status;
            this.zzbgB = attestationData;
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.AttestationResult
        public String getJwsResult() {
            if (this.zzbgB == null) {
                return null;
            }
            return this.zzbgB.getJwsResult();
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    static abstract class zzb extends zzrb<SafetyNetApi.AttestationResult> {
        protected zzrc zzbgC;

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbgC = new zzra() { // from class: com.google.android.gms.internal.zzre.zzb.1
                @Override // com.google.android.gms.internal.zzra, com.google.android.gms.internal.zzrc
                public void zza(Status status, AttestationData attestationData) {
                    zzb.this.zza(new zza(status, attestationData));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzbh, reason: merged with bridge method [inline-methods] */
        public SafetyNetApi.AttestationResult zzc(Status status) {
            return new zza(status, null);
        }
    }

    static abstract class zzc extends zzrb<SafetyNetApi.SafeBrowsingResult> {
        protected zzrc zzbgC;

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzbgC = new zzra() { // from class: com.google.android.gms.internal.zzre.zzc.1
                @Override // com.google.android.gms.internal.zzra, com.google.android.gms.internal.zzrc
                public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                    zzc.this.zza(new zzd(status, safeBrowsingData));
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzbi, reason: merged with bridge method [inline-methods] */
        public SafetyNetApi.SafeBrowsingResult zzc(Status status) {
            return new zzd(status, null);
        }
    }

    static class zzd implements SafetyNetApi.SafeBrowsingResult {
        private Status zzUX;
        private final SafeBrowsingData zzbgF;
        private String zzbgv;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzUX = status;
            this.zzbgF = safeBrowsingData;
            this.zzbgv = null;
            if (this.zzbgF != null) {
                this.zzbgv = this.zzbgF.getMetadata();
            } else if (this.zzUX.isSuccess()) {
                this.zzUX = new Status(8);
            }
        }

        @Override // com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
        public String getMetadata() {
            return this.zzbgv;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzre.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzrf zzrfVar) throws RemoteException {
                zzrfVar.zza(this.zzbgC, nonce);
            }
        });
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi
    public PendingResult<SafetyNetApi.SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, final List<Integer> threatTypes, final String uri) {
        if (threatTypes == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        }
        if (TextUtils.isEmpty(uri)) {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
        return googleApiClient.zza(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzre.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzrf zzrfVar) throws RemoteException {
                zzrfVar.zza(this.zzbgC, threatTypes, 1, uri);
            }
        });
    }
}
