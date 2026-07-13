package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

/* JADX INFO: loaded from: classes.dex */
public class zzpe implements RecordingApi {

    private static class zza extends zzor.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<ListSubscriptionsResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<ListSubscriptionsResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzor
        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzamC.zzs(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzod.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpe.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzod zzodVar) throws RemoteException {
                ((zzoo) zzodVar.zzqJ()).zza(new SubscribeRequest(subscription, false, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zzod.zza<ListSubscriptionsResult>(client) { // from class: com.google.android.gms.internal.zzpe.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzM, reason: merged with bridge method [inline-methods] */
            public ListSubscriptionsResult zzc(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzod zzodVar) throws RemoteException {
                ((zzoo) zzodVar.zzqJ()).zza(new ListSubscriptionsRequest(null, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zzod.zza<ListSubscriptionsResult>(client) { // from class: com.google.android.gms.internal.zzpe.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzM, reason: merged with bridge method [inline-methods] */
            public ListSubscriptionsResult zzc(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzod zzodVar) throws RemoteException {
                ((zzoo) zzodVar.zzqJ()).zza(new ListSubscriptionsRequest(dataType, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new Subscription.zza().zzb(dataSource).zzuz());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new Subscription.zza().zzb(dataType).zzuz());
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzod.zzc(client) { // from class: com.google.android.gms.internal.zzpe.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzod zzodVar) throws RemoteException {
                ((zzoo) zzodVar.zzqJ()).zza(new UnsubscribeRequest(null, dataSource, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzod.zzc(client) { // from class: com.google.android.gms.internal.zzpe.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzod zzodVar) throws RemoteException {
                ((zzoo) zzodVar.zzqJ()).zza(new UnsubscribeRequest(dataType, null, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.RecordingApi
    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
