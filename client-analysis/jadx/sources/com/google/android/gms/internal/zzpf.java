package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

/* JADX INFO: loaded from: classes.dex */
public class zzpf implements SensorsApi {

    private interface zza {
        void zzuI();
    }

    private static class zzb extends zzoi.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<DataSourcesResult> zzamC;

        private zzb(com.google.android.gms.common.api.internal.zza.zzb<DataSourcesResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzoi
        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzamC.zzs(dataSourcesResult);
        }
    }

    private static class zzc extends zzow.zza {
        private final zza zzaAq;
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        private zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, zza zzaVar) {
            this.zzamC = zzbVar;
            this.zzaAq = zzaVar;
        }

        @Override // com.google.android.gms.internal.zzow
        public void zzp(Status status) {
            if (this.zzaAq != null && status.isSuccess()) {
                this.zzaAq.zzuI();
            }
            this.zzamC.zzs(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final com.google.android.gms.fitness.data.zzk zzkVar, final PendingIntent pendingIntent, final zza zzaVar) {
        return googleApiClient.zzb(new zzoe.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpf.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzoe zzoeVar) throws RemoteException {
                ((zzop) zzoeVar.zzqJ()).zza(new SensorUnregistrationRequest(zzkVar, pendingIntent, new zzc(this, zzaVar)));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzoe.zzc, com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final SensorRequest sensorRequest, final com.google.android.gms.fitness.data.zzk zzkVar, final PendingIntent pendingIntent) {
        return googleApiClient.zza(new zzoe.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpf.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzoe zzoeVar) throws RemoteException {
                ((zzop) zzoeVar.zzqJ()).zza(new SensorRegistrationRequest(sensorRequest, zzkVar, pendingIntent, new zzph(this)));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzoe.zzc, com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb */
            public Status zzc(Status status) {
                return status;
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, (com.google.android.gms.fitness.data.zzk) null, intent);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzl.zza.zzuu().zza(listener), (PendingIntent) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zzoe.zza<DataSourcesResult>(client) { // from class: com.google.android.gms.internal.zzpf.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzN, reason: merged with bridge method [inline-methods] */
            public DataSourcesResult zzc(Status status) {
                return DataSourcesResult.zzR(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzoe zzoeVar) throws RemoteException {
                ((zzop) zzoeVar.zzqJ()).zza(new DataSourcesRequest(request, new zzb(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, (com.google.android.gms.fitness.data.zzk) null, pendingIntent, (zza) null);
    }

    @Override // com.google.android.gms.fitness.SensorsApi
    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        com.google.android.gms.fitness.data.zzl zzlVarZzb = com.google.android.gms.fitness.data.zzl.zza.zzuu().zzb(listener);
        return zzlVarZzb == null ? PendingResults.zza(Status.zzagC, client) : zza(client, zzlVarZzb, (PendingIntent) null, new zza() { // from class: com.google.android.gms.internal.zzpf.3
            @Override // com.google.android.gms.internal.zzpf.zza
            public void zzuI() {
                com.google.android.gms.fitness.data.zzl.zza.zzuu().zzc(listener);
            }
        });
    }
}
