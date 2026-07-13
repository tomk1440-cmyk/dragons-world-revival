package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardsImpl implements Leaderboards {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$10, reason: invalid class name */
    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaGq;
        final /* synthetic */ int zzaGr;
        final /* synthetic */ int zzaGs;
        final /* synthetic */ int zzaGt;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaGq, this.zzaGr, this.zzaGs, this.zzaGt, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$11, reason: invalid class name */
    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaGq;
        final /* synthetic */ int zzaGr;
        final /* synthetic */ int zzaGs;
        final /* synthetic */ int zzaGt;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaFQ, this.zzaGq, this.zzaGr, this.zzaGs, this.zzaGt, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$8, reason: invalid class name */
    class AnonymousClass8 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzaFQ, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$9, reason: invalid class name */
    class AnonymousClass9 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaGq;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaGq, this.zzaFO);
        }
    }

    private static abstract class LoadMetadataImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzak, reason: merged with bridge method [inline-methods] */
        public Leaderboards.LeaderboardMetadataResult zzc(final Status status) {
            return new Leaderboards.LeaderboardMetadataResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadMetadataImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.zzbI(14));
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

    private static abstract class LoadPlayerScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzal, reason: merged with bridge method [inline-methods] */
        public Leaderboards.LoadPlayerScoreResult zzc(final Status status) {
            return new Leaderboards.LoadPlayerScoreResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadPlayerScoreImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
                public LeaderboardScore getScore() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadScoresImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzam, reason: merged with bridge method [inline-methods] */
        public Leaderboards.LoadScoresResult zzc(final Status status) {
            return new Leaderboards.LoadScoresResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.LoadScoresImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
                public Leaderboard getLeaderboard() {
                    return null;
                }

                @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.zzbI(14));
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

    protected static abstract class SubmitScoreImpl extends Games.BaseGamesApiMethodImpl<Leaderboards.SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzan, reason: merged with bridge method [inline-methods] */
        public Leaderboards.SubmitScoreResult zzc(final Status status) {
            return new Leaderboards.SubmitScoreResult() { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.SubmitScoreImpl.1
                @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.zzbI(14));
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

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwz();
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return getLeaderboardIntent(apiClient, leaderboardId, -1);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan) {
        return getLeaderboardIntent(apiClient, leaderboardId, timeSpan, -1);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan, int collection) {
        return Games.zzh(apiClient).zzl(leaderboardId, timeSpan, collection);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, final String leaderboardId, final int span, final int leaderboardCollection) {
        return apiClient.zza(new LoadPlayerScoreImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, (String) null, leaderboardId, span, leaderboardCollection);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, leaderboardId, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, final LeaderboardScoreBuffer buffer, final int maxResults, final int pageDirection) {
        return apiClient.zza(new LoadScoresImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, buffer, maxResults, pageDirection);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, final String leaderboardId, final int span, final int leaderboardCollection, final int maxResults, final boolean forceReload) {
        return apiClient.zza(new LoadScoresImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.LoadScoresResult> loadTopScores(GoogleApiClient apiClient, final String leaderboardId, final int span, final int leaderboardCollection, final int maxResults, final boolean forceReload) {
        return apiClient.zza(new LoadScoresImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, leaderboardId, span, leaderboardCollection, maxResults, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            try {
                gamesClientImplZzb.zza((zza.zzb<Leaderboards.SubmitScoreResult>) null, leaderboardId, score, scoreTag);
            } catch (RemoteException e) {
                GamesLog.zzz("LeaderboardsImpl", "service died");
            }
        }
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboards
    public PendingResult<Leaderboards.SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, final String leaderboardId, final long score, final String scoreTag) {
        return apiClient.zzb(new SubmitScoreImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.LeaderboardsImpl.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, leaderboardId, score, scoreTag);
            }
        });
    }
}
