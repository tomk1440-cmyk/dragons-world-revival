package com.google.android.gms.games.internal.api;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;

/* JADX INFO: loaded from: classes.dex */
public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends Games.BaseGamesApiMethodImpl<Events.LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public Events.LoadEventsResult zzc(final Status status) {
            return new Events.LoadEventsResult() { // from class: com.google.android.gms.games.internal.api.EventsImpl.LoadImpl.1
                @Override // com.google.android.gms.games.event.Events.LoadEventsResult
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbI(14));
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

    private static abstract class UpdateImpl extends Games.BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        public Result zzc(final Status status) {
            return new Result() { // from class: com.google.android.gms.games.internal.api.EventsImpl.UpdateImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.event.Events
    @SuppressLint({"MissingRemoteException"})
    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl gamesClientImplZzc = Games.zzc(apiClient, false);
        if (gamesClientImplZzc == null) {
            return;
        }
        if (gamesClientImplZzc.isConnected()) {
            gamesClientImplZzc.zzp(eventId, incrementAmount);
        } else {
            apiClient.zzb(new UpdateImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.3
                @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                public void zza(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.zzp(eventId, incrementAmount);
                }
            });
        }
    }

    @Override // com.google.android.gms.games.event.Events
    public PendingResult<Events.LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.2
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd(this, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.event.Events
    public PendingResult<Events.LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.zza(new LoadImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.EventsImpl.1
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, forceReload, eventIds);
            }
        });
    }
}
