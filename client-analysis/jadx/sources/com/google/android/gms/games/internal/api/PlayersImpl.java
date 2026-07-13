package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

/* JADX INFO: loaded from: classes.dex */
public final class PlayersImpl implements Players {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10, reason: invalid class name */
    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "nearby", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11, reason: invalid class name */
    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", this.zzaFQ, this.zzaGL, false, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12, reason: invalid class name */
    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", this.zzaFQ, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13, reason: invalid class name */
    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14, reason: invalid class name */
    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15, reason: invalid class name */
    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zza.zzb<Players.LoadPlayersResult>) this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16, reason: invalid class name */
    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zza.zzb<Players.LoadPlayersResult>) this, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17, reason: invalid class name */
    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGL, false, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18, reason: invalid class name */
    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19, reason: invalid class name */
    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, false, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20, reason: invalid class name */
    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGh;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaGh, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21, reason: invalid class name */
    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzaGM, this.zzaGC, this.zzaGL, false, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22, reason: invalid class name */
    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzaGC;
        final /* synthetic */ int zzaGL;
        final /* synthetic */ String zzaGM;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzaGM, this.zzaGC, this.zzaGL, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23, reason: invalid class name */
    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzaGN;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzaGN);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24, reason: invalid class name */
    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzaGN, this.zzaGO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25, reason: invalid class name */
    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaGN;
        final /* synthetic */ int zzaGO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaGN, this.zzaGO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26, reason: invalid class name */
    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaFO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$27, reason: invalid class name */
    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaGP;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this, this.zzaGP);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$3, reason: invalid class name */
    class AnonymousClass3 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzaGQ;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaGQ);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$9, reason: invalid class name */
    class AnonymousClass9 extends LoadPlayersImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGL;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "nearby", this.zzaFQ, this.zzaGL, false, false);
        }
    }

    private static abstract class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzas, reason: merged with bridge method [inline-methods] */
        public Players.LoadPlayersResult zzc(final Status status) {
            return new Players.LoadPlayersResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1
                @Override // com.google.android.gms.games.Players.LoadPlayersResult
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbI(14));
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

    private static abstract class LoadProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadProfileSettingsResult> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzat, reason: merged with bridge method [inline-methods] */
        public Players.LoadProfileSettingsResult zzc(final Status status) {
            return new Players.LoadProfileSettingsResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadProfileSettingsResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzau, reason: merged with bridge method [inline-methods] */
        public Players.LoadXpForGameCategoriesResult zzc(final Status status) {
            return new Players.LoadXpForGameCategoriesResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzav, reason: merged with bridge method [inline-methods] */
        public Players.LoadXpStreamResult zzc(final Status status) {
            return new Players.LoadXpStreamResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Status> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.games.Players
    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzh(apiClient).zza(new PlayerEntity(player));
    }

    @Override // com.google.android.gms.games.Players
    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwx();
    }

    @Override // com.google.android.gms.games.Players
    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzah(true);
    }

    @Override // com.google.android.gms.games.Players
    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwH();
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, pageSize, false, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, pageSize, true, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", pageSize, true, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, playerId, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, playerId, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
