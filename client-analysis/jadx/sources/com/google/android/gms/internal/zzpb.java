package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

/* JADX INFO: loaded from: classes.dex */
public class zzpb implements ConfigApi {

    private static class zza extends zzoj.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<DataTypeResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<DataTypeResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzoj
        public void zza(DataTypeResult dataTypeResult) {
            this.zzamC.zzs(dataTypeResult);
        }
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zzoa.zza<DataTypeResult>(client) { // from class: com.google.android.gms.internal.zzpb.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzJ, reason: merged with bridge method [inline-methods] */
            public DataTypeResult zzc(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzoa zzoaVar) throws RemoteException {
                ((zzol) zzoaVar.zzqJ()).zza(new DataTypeCreateRequest(request, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzoa.zzc(client) { // from class: com.google.android.gms.internal.zzpb.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzoa zzoaVar) throws RemoteException {
                ((zzol) zzoaVar.zzqJ()).zza(new DisableFitRequest(new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.ConfigApi
    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zzoa.zza<DataTypeResult>(client) { // from class: com.google.android.gms.internal.zzpb.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzJ, reason: merged with bridge method [inline-methods] */
            public DataTypeResult zzc(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzoa zzoaVar) throws RemoteException {
                ((zzol) zzoaVar.zzqJ()).zza(new DataTypeReadRequest(dataTypeName, new zza(this)));
            }
        });
    }
}
