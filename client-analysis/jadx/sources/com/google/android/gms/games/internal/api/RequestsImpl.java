package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class RequestsImpl implements Requests {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4, reason: invalid class name */
    class AnonymousClass4 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends SendRequestImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaHi;
        final /* synthetic */ int zzaHj;
        final /* synthetic */ byte[] zzaHk;
        final /* synthetic */ int zzaHl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHi, this.zzaHj, this.zzaHk, this.zzaHl);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends UpdateRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ String[] zzaHe;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaHe);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7, reason: invalid class name */
    class AnonymousClass7 extends LoadRequestsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGl;
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHg;
        final /* synthetic */ int zzaHh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaHg, this.zzaHh, this.zzaGl);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8, reason: invalid class name */
    class AnonymousClass8 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzaHa;
        final /* synthetic */ int zzaHh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzaHa, this.zzaHh);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestSummariesResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaz, reason: merged with bridge method [inline-methods] */
        public Requests.LoadRequestSummariesResult zzc(final Status status) {
            return new Requests.LoadRequestSummariesResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestSummariesImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class LoadRequestsImpl extends Games.BaseGamesApiMethodImpl<Requests.LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaA, reason: merged with bridge method [inline-methods] */
        public Requests.LoadRequestsResult zzc(final Status status) {
            return new Requests.LoadRequestsResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.LoadRequestsImpl.1
                @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.zzbI(status.getStatusCode()));
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class SendRequestImpl extends Games.BaseGamesApiMethodImpl<Requests.SendRequestResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
        public Requests.SendRequestResult zzc(final Status status) {
            return new Requests.SendRequestResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.SendRequestImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateRequestsImpl extends Games.BaseGamesApiMethodImpl<Requests.UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaC, reason: merged with bridge method [inline-methods] */
        public Requests.UpdateRequestsResult zzc(final Status status) {
            return new Requests.UpdateRequestsResult() { // from class: com.google.android.gms.games.internal.api.RequestsImpl.UpdateRequestsImpl.1
                @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
                public Set<String> getRequestIds() {
                    return null;
                }

                @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    @Override // com.google.android.gms.games.request.Requests
    public PendingResult<Requests.UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    @Override // com.google.android.gms.games.request.Requests
    public PendingResult<Requests.UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.RequestsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, strArr);
            }
        });
    }

    @Override // com.google.android.gms.games.request.Requests
    public PendingResult<Requests.UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    @Override // com.google.android.gms.games.request.Requests
    public PendingResult<Requests.UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.RequestsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc(this, strArr);
            }
        });
    }

    @Override // com.google.android.gms.games.request.Requests
    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList<>();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    @Override // com.google.android.gms.games.request.Requests
    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList<>() : getGameRequestsFromBundle(response.getExtras());
    }

    @Override // com.google.android.gms.games.request.Requests
    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwM();
    }

    @Override // com.google.android.gms.games.request.Requests
    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwO();
    }

    @Override // com.google.android.gms.games.request.Requests
    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwN();
    }

    @Override // com.google.android.gms.games.request.Requests
    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzh(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    @Override // com.google.android.gms.games.request.Requests
    public PendingResult<Requests.LoadRequestsResult> loadRequests(GoogleApiClient apiClient, final int requestDirection, final int types, final int sortOrder) {
        return apiClient.zza(new LoadRequestsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.RequestsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, requestDirection, types, sortOrder);
            }
        });
    }

    @Override // com.google.android.gms.games.request.Requests
    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzd(apiClient.zzr(listener));
        }
    }

    @Override // com.google.android.gms.games.request.Requests
    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwG();
        }
    }
}
