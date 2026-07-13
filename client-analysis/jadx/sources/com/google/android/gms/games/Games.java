package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.api.VideosImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Games {
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    static final Api.zzc<GamesClientImpl> zzUI = new Api.zzc<>();
    private static final Api.zza<GamesClientImpl, GamesOptions> zzUJ = new GamesClientBuilder() { // from class: com.google.android.gms.games.Games.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public List<Scope> zzo(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }
    };
    private static final Api.zza<GamesClientImpl, GamesOptions> zzaCv = new GamesClientBuilder() { // from class: com.google.android.gms.games.Games.2
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public List<Scope> zzo(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzaCw);
        }
    };
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Api<GamesOptions> API = new Api<>("Games.API", zzUJ, zzUI);
    public static final Scope zzaCw = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzaCx = new Api<>("Games.API_1P", zzaCv, zzUI);
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Achievements Achievements = new AchievementsImpl();
    public static final AppContents zzaCy = new AppContentsImpl();
    public static final Events Events = new EventsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Multiplayer zzaCz = new MultiplayerImpl();
    public static final Players Players = new PlayersImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final Stats Stats = new StatsImpl();
    public static final Videos zzaCA = new VideosImpl();
    public static final Acls zzaCB = new AclsImpl();

    /* JADX INFO: renamed from: com.google.android.gms.games.Games$3, reason: invalid class name */
    static class AnonymousClass3 extends GetTokenImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.Games$6, reason: invalid class name */
    static class AnonymousClass6 extends BaseGamesApiMethodImpl<LoadExperimentsResult> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzW, reason: merged with bridge method [inline-methods] */
        public LoadExperimentsResult zzc(final Status status) {
            return new LoadExperimentsResult() { // from class: com.google.android.gms.games.Games.6.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zza.AbstractC0049zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzUI, googleApiClient);
        }
    }

    private static abstract class GamesClientBuilder extends Api.zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return 1;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public GamesClientImpl zza(Context context, Looper looper, zzf zzfVar, GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, zzfVar, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class GamesOptions implements Api.ApiOptions.Optional {
        public final boolean zzaCE;
        public final boolean zzaCF;
        public final int zzaCG;
        public final boolean zzaCH;
        public final int zzaCI;
        public final String zzaCJ;
        public final ArrayList<String> zzaCK;
        public final boolean zzaCL;

        public static final class Builder {
            boolean zzaCE;
            boolean zzaCF;
            int zzaCG;
            boolean zzaCH;
            int zzaCI;
            String zzaCJ;
            ArrayList<String> zzaCK;
            boolean zzaCL;

            private Builder() {
                this.zzaCE = false;
                this.zzaCF = true;
                this.zzaCG = 17;
                this.zzaCH = false;
                this.zzaCI = 4368;
                this.zzaCJ = null;
                this.zzaCK = new ArrayList<>();
                this.zzaCL = false;
            }

            public GamesOptions build() {
                return new GamesOptions(this);
            }

            public Builder setRequireGooglePlus(boolean requireGooglePlus) {
                this.zzaCL = requireGooglePlus;
                return this;
            }

            public Builder setSdkVariant(int variant) {
                this.zzaCI = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.zzaCF = showConnectingPopup;
                this.zzaCG = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.zzaCF = showConnectingPopup;
                this.zzaCG = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.zzaCE = false;
            this.zzaCF = true;
            this.zzaCG = 17;
            this.zzaCH = false;
            this.zzaCI = 4368;
            this.zzaCJ = null;
            this.zzaCK = new ArrayList<>();
            this.zzaCL = false;
        }

        private GamesOptions(Builder builder) {
            this.zzaCE = builder.zzaCE;
            this.zzaCF = builder.zzaCF;
            this.zzaCG = builder.zzaCG;
            this.zzaCH = builder.zzaCH;
            this.zzaCI = builder.zzaCI;
            this.zzaCJ = builder.zzaCJ;
            this.zzaCK = builder.zzaCK;
            this.zzaCL = builder.zzaCL;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzvD() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzaCE);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzaCF);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzaCG);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzaCH);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzaCI);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzaCJ);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzaCK);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzaCL);
            return bundle;
        }
    }

    private static abstract class GetServerAuthCodeImpl extends BaseGamesApiMethodImpl<GetServerAuthCodeResult> {
        private GetServerAuthCodeImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzX, reason: merged with bridge method [inline-methods] */
        public GetServerAuthCodeResult zzc(final Status status) {
            return new GetServerAuthCodeResult() { // from class: com.google.android.gms.games.Games.GetServerAuthCodeImpl.1
                @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
                public String getCode() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    private static abstract class GetTokenImpl extends BaseGamesApiMethodImpl<GetTokenResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzY, reason: merged with bridge method [inline-methods] */
        public GetTokenResult zzc(final Status status) {
            return new GetTokenResult() { // from class: com.google.android.gms.games.Games.GetTokenImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public interface GetTokenResult extends Result {
    }

    public interface LoadExperimentsResult extends Result {
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return zzh(apiClient).zzwK();
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return zzh(apiClient).zzww();
    }

    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient apiClient, final String serverClientId) {
        zzx.zzh(serverClientId, "Please provide a valid serverClientId");
        return apiClient.zzb(new GetServerAuthCodeImpl(apiClient) { // from class: com.google.android.gms.games.Games.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(serverClientId, this);
            }
        });
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return zzh(apiClient).zzwJ();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return zzh(apiClient).zzwI();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        GamesClientImpl gamesClientImplZzb = zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzgs(gravity);
        }
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        zzx.zzz(gamesContentView);
        GamesClientImpl gamesClientImplZzb = zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzo(gamesContentView);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.zzb(new SignOutImpl(apiClient) { // from class: com.google.android.gms.games.Games.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zHasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !zHasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
        if (zHasConnectedApi) {
            return (GamesClientImpl) googleApiClient.zza(zzUI);
        }
        return null;
    }

    public static GamesClientImpl zzh(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
