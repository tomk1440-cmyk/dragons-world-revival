package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;

/* JADX INFO: loaded from: classes.dex */
public final class StatsImpl implements Stats {

    private static abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl<Stats.LoadPlayerStatsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaH, reason: merged with bridge method [inline-methods] */
        public Stats.LoadPlayerStatsResult zzc(final Status status) {
            return new Stats.LoadPlayerStatsResult() { // from class: com.google.android.gms.games.internal.api.StatsImpl.LoadsImpl.1
                @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
                public PlayerStats getPlayerStats() {
                    return null;
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

    @Override // com.google.android.gms.games.stats.Stats
    public PendingResult<Stats.LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.StatsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze(this, forceReload);
            }
        });
    }
}
