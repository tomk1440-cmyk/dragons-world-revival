package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.common.api.internal.zze;
import com.google.android.gms.common.api.internal.zzf;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.signin.internal.zzh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class GamesClientImpl extends zzj<IGamesService> {
    EventIncrementManager zzaDZ;
    private final String zzaEa;
    private PlayerEntity zzaEb;
    private GameEntity zzaEc;
    private final PopupManager zzaEd;
    private boolean zzaEe;
    private final Binder zzaEf;
    private final long zzaEg;
    private final Games.GamesOptions zzaEh;

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzaEj;

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            this.zzaEj = new ArrayList<>();
            for (String str : participantIds) {
                this.zzaEj.add(str);
            }
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzaEj);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static abstract class AbstractRoomNotifier extends zze<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zze
        public void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzY(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends zze<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zze
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzY(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements Quests.AcceptQuestResult {
        private final Quest zzaEk;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity(questBuffer.get(0));
                } else {
                    this.zzaEk = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
        public Quest getQuest() {
            return this.zzaEk;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Achievements.UpdateAchievementResult> zzamC;

        AchievementUpdatedBinderCallback(zza.zzb<Achievements.UpdateAchievementResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzh(int i, String str) {
            this.zzamC.zzs(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Achievements.LoadAchievementsResult> zzamC;

        AchievementsLoadedBinderCallback(zza.zzb<Achievements.LoadAchievementsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzh(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<AppContents.LoadAppContentResult> zzaEl;

        public AppContentLoadedBinderCallbacks(zza.zzb<AppContents.LoadAppContentResult> resultHolder) {
            this.zzaEl = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder[] dataHolderArr) {
            this.zzaEl.zzs(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class CancelMatchResultImpl implements TurnBasedMultiplayer.CancelMatchResult {
        private final Status zzUX;
        private final String zzaEm;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzUX = status;
            this.zzaEm = externalMatchId;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
        public String getMatchId() {
            return this.zzaEm;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements Quests.ClaimMilestoneResult {
        private final Quest zzaEk;
        private final Milestone zzaEn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaEk = new QuestEntity(questBuffer.get(0));
                    List<Milestone> listZzxR = this.zzaEk.zzxR();
                    int size = listZzxR.size();
                    for (int i = 0; i < size; i++) {
                        if (listZzxR.get(i).getMilestoneId().equals(milestoneId)) {
                            this.zzaEn = listZzxR.get(i);
                            questBuffer.release();
                            return;
                        }
                    }
                    this.zzaEn = null;
                } else {
                    this.zzaEn = null;
                    this.zzaEk = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public Milestone getMilestone() {
            return this.zzaEn;
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public Quest getQuest() {
            return this.zzaEk;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata zzaEo;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaEo = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaEo = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaEo;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements Notifications.ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.ContactSettingLoadResult> zzamC;

        ContactSettingsLoadedBinderCallback(zza.zzb<Notifications.ContactSettingLoadResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzI(DataHolder dataHolder) {
            this.zzamC.zzs(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        ContactSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzgo(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class DeleteSnapshotResultImpl implements Snapshots.DeleteSnapshotResult {
        private final Status zzUX;
        private final String zzaEp;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzUX = GamesStatusCodes.zzgc(statusCode);
            this.zzaEp = snapshotId;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
        public String getSnapshotId() {
            return this.zzaEp;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Events.LoadEventsResult> zzamC;

        EventsLoadedBinderCallback(zza.zzb<Events.LoadEventsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzi(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class ExperimentsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Games.LoadExperimentsResult> zzamC;

        ExperimentsLoadedBinderCallback(zza.zzb<Games.LoadExperimentsResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(int i, long[] jArr) {
            this.zzamC.zzs(new LoadExperimentsResultImpl(i, jArr));
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        public GameClientEventIncrementCache() {
            super(GamesClientImpl.this.getContext().getMainLooper(), 1000);
        }

        @Override // com.google.android.gms.games.internal.events.EventIncrementCache
        protected void zzs(String str, int i) {
            try {
                if (GamesClientImpl.this.isConnected()) {
                    GamesClientImpl.this.zzqJ().zzp(str, i);
                } else {
                    GamesLog.zzA("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                GamesClientImpl.this.zzb(e);
            }
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGameInstancesResult> zzamC;

        GameInstancesLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGameInstancesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzp(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements Notifications.GameMuteStatusChangeResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzUX = GamesStatusCodes.zzgc(statusCode);
            this.zzaEq = externalGameId;
            this.zzaEr = isMuted;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.GameMuteStatusChangeResult> zzamC;

        GameMuteStatusChangedBinderCallback(zza.zzb<Notifications.GameMuteStatusChangeResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(int i, String str, boolean z) {
            this.zzamC.zzs(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements Notifications.GameMuteStatusLoadResult {
        private final Status zzUX;
        private final String zzaEq;
        private final boolean zzaEr;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzUX = GamesStatusCodes.zzgc(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaEq = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzaEr = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaEq = null;
                    this.zzaEr = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.GameMuteStatusLoadResult> zzamC;

        GameMuteStatusLoadedBinderCallback(zza.zzb<Notifications.GameMuteStatusLoadResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzG(DataHolder dataHolder) {
            this.zzamC.zzs(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzamC;

        GameSearchSuggestionsLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzq(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static abstract class GamesDataHolderResult extends zzf {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzgc(dataHolder.getStatusCode()));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<GamesMetadata.LoadGamesResult> zzamC;

        GamesLoadedBinderCallback(zza.zzb<GamesMetadata.LoadGamesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzn(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class GetAuthTokenBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Games.GetTokenResult> zzamC;

        public GetAuthTokenBinderCallbacks(zza.zzb<Games.GetTokenResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzg(int i, String str) {
            this.zzamC.zzs(new GetTokenResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class GetServerAuthCodeBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Games.GetServerAuthCodeResult> zzamC;

        public GetServerAuthCodeBinderCallbacks(zza.zzb<Games.GetServerAuthCodeResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzg(int i, String str) {
            this.zzamC.zzs(new GetServerAuthCodeResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class GetServerAuthCodeResultImpl implements Games.GetServerAuthCodeResult {
        private final Status zzUX;
        private final String zzaEs;

        GetServerAuthCodeResultImpl(Status status, String code) {
            this.zzUX = status;
            this.zzaEs = code;
        }

        @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
        public String getCode() {
            return this.zzaEs;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class GetTokenResultImpl implements Games.GetTokenResult {
        private final Status zzUX;
        private final String zzVo;

        GetTokenResultImpl(Status status, String token) {
            this.zzUX = status;
            this.zzVo = token;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class InboxCountResultImpl implements Notifications.InboxCountResult {
        private final Status zzUX;
        private final Bundle zzaEt;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzUX = status;
            this.zzaEt = inboxCounts;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Notifications.InboxCountResult> zzamC;

        InboxCountsLoadedBinderCallback(zza.zzb<Notifications.InboxCountResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new InboxCountResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnInvitationReceivedListener> zzari;

        InvitationReceivedBinderCallback(zzq<OnInvitationReceivedListener> listener) {
            this.zzari = listener;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onInvitationRemoved(String invitationId) {
            this.zzari.zza(new InvitationRemovedNotifier(invitationId));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                Invitation invitationFreeze = invitationBuffer.getCount() > 0 ? invitationBuffer.get(0).freeze() : null;
                invitationBuffer.release();
                if (invitationFreeze != null) {
                    this.zzari.zza(new InvitationReceivedNotifier(invitationFreeze));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
                throw th;
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzq.zzb<OnInvitationReceivedListener> {
        private final Invitation zzaEu;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaEu = invitation;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaEu);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class InvitationRemovedNotifier implements zzq.zzb<OnInvitationReceivedListener> {
        private final String zzUO;

        InvitationRemovedNotifier(String invitationId) {
            this.zzUO = invitationId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzUO);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Invitations.LoadInvitationsResult> zzamC;

        InvitationsLoadedBinderCallback(zza.zzb<Invitations.LoadInvitationsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzr(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer zzaEv;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEv = new LeaderboardBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
        public LeaderboardBuffer getLeaderboards() {
            return this.zzaEv;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LoadScoresResult> zzamC;

        LeaderboardScoresLoadedBinderCallback(zza.zzb<Leaderboards.LoadScoresResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzamC.zzs(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LeaderboardMetadataResult> zzamC;

        LeaderboardsLoadedBinderCallback(zza.zzb<Leaderboards.LeaderboardMetadataResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzj(DataHolder dataHolder) {
            this.zzamC.zzs(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeftRoomNotifier implements zzq.zzb<RoomUpdateListener> {
        private final String zzaEw;
        private final int zzade;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzade = statusCode;
            this.zzaEw = roomId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzade, this.zzaEw);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class ListVideosBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Videos.ListVideosResult> zzamC;

        ListVideosBinderCallback(zza.zzb<Videos.ListVideosResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzX(DataHolder dataHolder) {
            this.zzamC.zzs(new ListVideosResultImpl(dataHolder));
        }
    }

    public static final class ListVideosResultImpl extends GamesDataHolderResult implements Videos.ListVideosResult {
        private final VideoBuffer zzaEx;

        public ListVideosResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEx = new VideoBuffer(dataHolder);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer zzaEy;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEy = new AchievementBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
        public AchievementBuffer getAchievements() {
            return this.zzaEy;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements Acls.LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements AppContents.LoadAppContentResult {
        private final ArrayList<DataHolder> zzaEz;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzaEz = new ArrayList<>(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements Events.LoadEventsResult {
        private final EventBuffer zzaEA;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEA = new EventBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.event.Events.LoadEventsResult
        public EventBuffer getEvents() {
            return this.zzaEA;
        }
    }

    private static final class LoadExperimentsResultImpl implements Games.LoadExperimentsResult {
        private final Status zzUX;
        private final Set<Long> zzaEB = new HashSet();

        LoadExperimentsResultImpl(int statusCode, long[] experimentIds) {
            this.zzUX = new Status(statusCode);
            for (long j : experimentIds) {
                this.zzaEB.add(Long.valueOf(j));
            }
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameInstancesResult {
        private final GameInstanceBuffer zzaEC;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEC = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaED;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzaED = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements GamesMetadata.LoadGamesResult {
        private final GameBuffer zzaEE;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEE = new GameBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
        public GameBuffer getGames() {
            return this.zzaEE;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer zzaEF;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEF = new InvitationBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
        public InvitationBuffer getInvitations() {
            return this.zzaEF;
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchesResultImpl implements TurnBasedMultiplayer.LoadMatchesResult {
        private final Status zzUX;
        private final LoadMatchesResponse zzaEG;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzUX = status;
            this.zzaEG = new LoadMatchesResponse(matchData);
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
        public LoadMatchesResponse getMatches() {
            return this.zzaEG;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            this.zzaEG.release();
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaEH;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaEH = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaEH = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
        public LeaderboardScore getScore() {
            return this.zzaEH;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements Stats.LoadPlayerStatsResult {
        private final PlayerStats zzaEI;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzaEI = new PlayerStatsEntity(playerStatsBuffer.get(0));
                } else {
                    this.zzaEI = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
        public PlayerStats getPlayerStats() {
            return this.zzaEI;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements Players.LoadPlayersResult {
        private final PlayerBuffer zzaEJ;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEJ = new PlayerBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.Players.LoadPlayersResult
        public PlayerBuffer getPlayers() {
            return this.zzaEJ;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements Players.LoadProfileSettingsResult {
        private final boolean zzaEK;
        private final boolean zzsj;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int iZzbH = dataHolder.zzbH(0);
                    this.zzsj = dataHolder.zze("profile_visible", 0, iZzbH);
                    this.zzaEK = dataHolder.zze("profile_visibility_explicitly_set", 0, iZzbH);
                } else {
                    this.zzsj = true;
                    this.zzaEK = false;
                }
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.common.api.internal.zzf, com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements Quests.LoadQuestsResult {
        private final DataHolder zzahi;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzahi = dataHolder;
        }

        @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzahi);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements Requests.LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadRequestsResultImpl implements Requests.LoadRequestsResult {
        private final Status zzUX;
        private final Bundle zzaEL;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzUX = status;
            this.zzaEL = requestData;
        }

        @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
        public GameRequestBuffer getRequests(int requestType) {
            String strZzgw = RequestType.zzgw(requestType);
            if (this.zzaEL.containsKey(strZzgw)) {
                return new GameRequestBuffer((DataHolder) this.zzaEL.get(strZzgw));
            }
            return null;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public void release() {
            Iterator<String> it = this.zzaEL.keySet().iterator();
            while (it.hasNext()) {
                DataHolder dataHolder = (DataHolder) this.zzaEL.getParcelable(it.next());
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity zzaEM;
        private final LeaderboardScoreBuffer zzaEN;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaEM = (LeaderboardEntity) leaderboardBuffer.get(0).freeze();
                } else {
                    this.zzaEM = null;
                }
                leaderboardBuffer.release();
                this.zzaEN = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public Leaderboard getLeaderboard() {
            return this.zzaEM;
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public LeaderboardScoreBuffer getScores() {
            return this.zzaEN;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements Snapshots.LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzahi);
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements Players.LoadXpForGameCategoriesResult {
        private final Status zzUX;
        private final List<String> zzaEO;
        private final Bundle zzaEP;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzUX = status;
            this.zzaEO = xpData.getStringArrayList("game_category_list");
            this.zzaEP = xpData;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements Players.LoadXpStreamResult {
        private final ExperienceEventBuffer zzaEQ;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaEQ = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchRemovedNotifier implements zzq.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaER;

        MatchRemovedNotifier(String matchId) {
            this.zzaER = matchId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaER);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnTurnBasedMatchUpdateReceivedListener> zzari;

        MatchUpdateReceivedBinderCallback(zzq<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzari = listener;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzari.zza(new MatchRemovedNotifier(matchId));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                TurnBasedMatch turnBasedMatchFreeze = turnBasedMatchBuffer.getCount() > 0 ? turnBasedMatchBuffer.get(0).freeze() : null;
                turnBasedMatchBuffer.release();
                if (turnBasedMatchFreeze != null) {
                    this.zzari.zza(new MatchUpdateReceivedNotifier(turnBasedMatchFreeze));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
                throw th;
            }
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzq.zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaES;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzaES = match;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaES);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class MessageReceivedNotifier implements zzq.zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaET;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzaET = message;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaET);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzq.zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzaEU;

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaEU);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Acls.LoadAclResult> zzamC;

        NotifyAclLoadedBinderCallback(zza.zzb<Acls.LoadAclResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzH(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        NotifyAclUpdatedBinderCallback(zza.zzb<Status> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzgn(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements Snapshots.OpenSnapshotResult {
        private final Snapshot zzaEV;
        private final String zzaEW;
        private final Snapshot zzaEX;
        private final Contents zzaEY;
        private final SnapshotContents zzaEZ;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaEV = null;
                    this.zzaEX = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    zzb.zzab(metadataHolder.getStatusCode() != 4004);
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaEX = null;
                } else {
                    this.zzaEV = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaEX = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzaEW = conflictId;
                this.zzaEY = resolutionContents;
                this.zzaEZ = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public String getConflictId() {
            return this.zzaEW;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public Snapshot getConflictingSnapshot() {
            return this.zzaEX;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaEZ;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public Snapshot getSnapshot() {
            return this.zzaEV;
        }
    }

    private static final class P2PConnectedNotifier implements zzq.zzb<RoomStatusUpdateListener> {
        private final String zzaFa;

        P2PConnectedNotifier(String participantId) {
            this.zzaFa = participantId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaFa);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class P2PDisconnectedNotifier implements zzq.zzb<RoomStatusUpdateListener> {
        private final String zzaFa;

        P2PDisconnectedNotifier(String participantId) {
            this.zzaFa = participantId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaFa);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractPeerStatusNotifier
        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.LoadPlayerScoreResult> zzamC;

        PlayerLeaderboardScoreLoadedBinderCallback(zza.zzb<Leaderboards.LoadPlayerScoreResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzJ(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Stats.LoadPlayerStatsResult> zzamC;

        public PlayerStatsLoadedBinderCallbacks(zza.zzb<Stats.LoadPlayerStatsResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzW(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadXpForGameCategoriesResult> zzamC;

        PlayerXpForGameCategoriesLoadedBinderCallback(zza.zzb<Players.LoadXpForGameCategoriesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzamC.zzs(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadXpStreamResult> zzamC;

        PlayerXpStreamLoadedBinderCallback(zza.zzb<Players.LoadXpStreamResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzU(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadPlayersResult> zzamC;

        PlayersLoadedBinderCallback(zza.zzb<Players.LoadPlayersResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzl(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzm(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaEd;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaEd = popupManager;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesClient, com.google.android.gms.games.internal.IGamesClient
        public PopupLocationInfoParcelable zzws() {
            return new PopupLocationInfoParcelable(this.zzaEd.zzxk());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Players.LoadProfileSettingsResult> zzamC;

        ProfileSettingsLoadedBinderCallback(zza.zzb<Players.LoadProfileSettingsResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzV(DataHolder dataHolder) {
            this.zzamC.zzs(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        ProfileSettingsUpdatedBinderCallback(zza.zzb<Status> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzgp(int i) {
            this.zzamC.zzs(GamesStatusCodes.zzgc(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.AcceptQuestResult> zzaFb;

        public QuestAcceptedBinderCallbacks(zza.zzb<Quests.AcceptQuestResult> resultHolder) {
            this.zzaFb = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzQ(DataHolder dataHolder) {
            this.zzaFb.zzs(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestCompletedNotifier implements zzq.zzb<QuestUpdateListener> {
        private final Quest zzaEk;

        QuestCompletedNotifier(Quest quest) {
            this.zzaEk = quest;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaEk);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.ClaimMilestoneResult> zzaFc;
        private final String zzaFd;

        public QuestMilestoneClaimBinderCallbacks(zza.zzb<Quests.ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzaFc = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
            this.zzaFd = (String) zzx.zzb(milestoneId, "MilestoneId must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzP(DataHolder dataHolder) {
            this.zzaFc.zzs(new ClaimMilestoneResultImpl(dataHolder, this.zzaFd));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzq<QuestUpdateListener> zzari;

        QuestUpdateBinderCallback(zzq<QuestUpdateListener> listener) {
            this.zzari = listener;
        }

        private Quest zzaa(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                return questBuffer.getCount() > 0 ? questBuffer.get(0).freeze() : null;
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzR(DataHolder dataHolder) {
            Quest questZzaa = zzaa(dataHolder);
            if (questZzaa != null) {
                this.zzari.zza(new QuestCompletedNotifier(questZzaa));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Quests.LoadQuestsResult> zzaFe;

        public QuestsLoadedBinderCallbacks(zza.zzb<Quests.LoadQuestsResult> resultHolder) {
            this.zzaFe = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzT(DataHolder dataHolder) {
            this.zzaFe.zzs(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzq.zzb<RealTimeMultiplayer.ReliableMessageSentCallback> {
        private final String zzaFf;
        private final int zzaFg;
        private final int zzade;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzade = statusCode;
            this.zzaFg = token;
            this.zzaFf = recipientParticipantId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(RealTimeMultiplayer.ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzade, this.zzaFg, this.zzaFf);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzq<RealTimeMultiplayer.ReliableMessageSentCallback> zzaFh;

        public RealTimeReliableMessageBinderCallbacks(zzq<RealTimeMultiplayer.ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzaFh = messageSentCallbacks;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzb(int i, int i2, String str) {
            if (this.zzaFh != null) {
                this.zzaFh.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzq<OnRequestReceivedListener> zzari;

        RequestReceivedBinderCallback(zzq<OnRequestReceivedListener> listener) {
            this.zzari = listener;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onRequestRemoved(String requestId) {
            this.zzari.zza(new RequestRemovedNotifier(requestId));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                GameRequest gameRequestFreeze = gameRequestBuffer.getCount() > 0 ? gameRequestBuffer.get(0).freeze() : null;
                gameRequestBuffer.release();
                if (gameRequestFreeze != null) {
                    this.zzari.zza(new RequestReceivedNotifier(gameRequestFreeze));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
                throw th;
            }
        }
    }

    private static final class RequestReceivedNotifier implements zzq.zzb<OnRequestReceivedListener> {
        private final GameRequest zzaFi;

        RequestReceivedNotifier(GameRequest request) {
            this.zzaFi = request;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaFi);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class RequestRemovedNotifier implements zzq.zzb<OnRequestReceivedListener> {
        private final String zzEY;

        RequestRemovedNotifier(String requestId) {
            this.zzEY = requestId;
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzt(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzEY);
        }

        @Override // com.google.android.gms.common.api.internal.zzq.zzb
        public void zzpr() {
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.SendRequestResult> zzaFj;

        public RequestSentBinderCallbacks(zza.zzb<Requests.SendRequestResult> resultHolder) {
            this.zzaFj = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzL(DataHolder dataHolder) {
            this.zzaFj.zzs(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.LoadRequestSummariesResult> zzaFk;

        public RequestSummariesLoadedBinderCallbacks(zza.zzb<Requests.LoadRequestSummariesResult> resultHolder) {
            this.zzaFk = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzM(DataHolder dataHolder) {
            this.zzaFk.zzs(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.LoadRequestsResult> zzaFl;

        public RequestsLoadedBinderCallbacks(zza.zzb<Requests.LoadRequestsResult> resultHolder) {
            this.zzaFl = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFl.zzs(new LoadRequestsResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Requests.UpdateRequestsResult> zzaFm;

        public RequestsUpdatedBinderCallbacks(zza.zzb<Requests.UpdateRequestsResult> resultHolder) {
            this.zzaFm = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzK(DataHolder dataHolder) {
            this.zzaFm.zzs(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzq<? extends RoomUpdateListener> zzaFn;
        private final zzq<? extends RoomStatusUpdateListener> zzaFo;
        private final zzq<RealTimeMessageReceivedListener> zzaFp;

        public RoomBinderCallbacks(zzq<RoomUpdateListener> roomCallbacks) {
            this.zzaFn = (zzq) zzx.zzb(roomCallbacks, "Callbacks must not be null");
            this.zzaFo = null;
            this.zzaFp = null;
        }

        public RoomBinderCallbacks(zzq<? extends RoomUpdateListener> roomCallbacks, zzq<? extends RoomStatusUpdateListener> roomStatusCallbacks, zzq<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzaFn = (zzq) zzx.zzb(roomCallbacks, "Callbacks must not be null");
            this.zzaFo = roomStatusCallbacks;
            this.zzaFp = realTimeMessageReceivedCallbacks;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzaFn.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onP2PConnected(String participantId) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PConnectedNotifier(participantId));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onP2PDisconnected(String participantId) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzaFp != null) {
                this.zzaFp.zza(new MessageReceivedNotifier(message));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzA(DataHolder dataHolder) {
            this.zzaFn.zza(new JoinedRoomNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzB(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzC(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzD(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomConnectedNotifier(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzE(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzF(DataHolder dataHolder) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaFo != null) {
                this.zzaFo.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzz(DataHolder dataHolder) {
            this.zzaFn.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomStatusNotifier
        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.internal.GamesClientImpl.AbstractRoomNotifier
        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements Requests.SendRequestResult {
        private final GameRequest zzaFi;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaFi = gameRequestBuffer.get(0).freeze();
                } else {
                    this.zzaFi = null;
                }
            } finally {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Status> zzamC;

        public SignOutCompleteBinderCallbacks(zza.zzb<Status> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzwr() {
            this.zzamC.zzs(GamesStatusCodes.zzgc(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.CommitSnapshotResult> zzaFq;

        public SnapshotCommittedBinderCallbacks(zza.zzb<Snapshots.CommitSnapshotResult> resultHolder) {
            this.zzaFq = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzO(DataHolder dataHolder) {
            this.zzaFq.zzs(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.DeleteSnapshotResult> zzamC;

        public SnapshotDeletedBinderCallbacks(zza.zzb<Snapshots.DeleteSnapshotResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzj(int i, String str) {
            this.zzamC.zzs(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.OpenSnapshotResult> zzaFr;

        public SnapshotOpenedBinderCallbacks(zza.zzb<Snapshots.OpenSnapshotResult> resultHolder) {
            this.zzaFr = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaFr.zzs(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Snapshots.LoadSnapshotsResult> zzaFs;

        public SnapshotsLoadedBinderCallbacks(zza.zzb<Snapshots.LoadSnapshotsResult> resultHolder) {
            this.zzaFs = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzN(DataHolder dataHolder) {
            this.zzaFs.zzs(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class StartRecordingBinderCallback extends AbstractGamesCallbacks {
        private final Games.BaseGamesApiMethodImpl<Status> zzaFt;

        StartRecordingBinderCallback(Games.BaseGamesApiMethodImpl<Status> holder) {
            this.zzaFt = (Games.BaseGamesApiMethodImpl) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzgq(int i) {
            this.zzaFt.zza(new Status(i));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<Leaderboards.SubmitScoreResult> zzamC;

        public SubmitScoreBinderCallbacks(zza.zzb<Leaderboards.SubmitScoreResult> resultHolder) {
            this.zzamC = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzk(DataHolder dataHolder) {
            this.zzamC.zzs(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData zzaFu;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaFu = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
        public ScoreSubmissionData getScoreData() {
            return this.zzaFu;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzaFv;

        public TurnBasedMatchCanceledBinderCallbacks(zza.zzb<TurnBasedMultiplayer.CancelMatchResult> resultHolder) {
            this.zzaFv = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzi(int i, String str) {
            this.zzaFv.zzs(new CancelMatchResultImpl(GamesStatusCodes.zzgc(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzaFw;

        public TurnBasedMatchInitiatedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> resultHolder) {
            this.zzaFw = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzv(DataHolder dataHolder) {
            this.zzaFw.zzs(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzaFx;

        public TurnBasedMatchLeftBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> resultHolder) {
            this.zzaFx = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzx(DataHolder dataHolder) {
            this.zzaFx.zzs(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzaFy;

        public TurnBasedMatchLoadedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LoadMatchResult> resultHolder) {
            this.zzaFy = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzu(DataHolder dataHolder) {
            this.zzaFy.zzs(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaES;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaES = turnBasedMatchBuffer.get(0).freeze();
                } else {
                    this.zzaES = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaES;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzaFz;

        public TurnBasedMatchUpdatedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> resultHolder) {
            this.zzaFz = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzw(DataHolder dataHolder) {
            this.zzaFz.zzs(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzaFA;

        public TurnBasedMatchesLoadedBinderCallbacks(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> resultHolder) {
            this.zzaFA = (zza.zzb) zzx.zzb(resultHolder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaFA.zzs(new LoadMatchesResultImpl(GamesStatusCodes.zzgc(i), bundle));
        }
    }

    private static final class UpdateAchievementResultImpl implements Achievements.UpdateAchievementResult {
        private final Status zzUX;
        private final String zzaDj;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzUX = GamesStatusCodes.zzgc(statusCode);
            this.zzaDj = achievementId;
        }

        @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
        public String getAchievementId() {
            return this.zzaDj;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements TurnBasedMultiplayer.UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements Requests.UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaFB;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaFB = RequestUpdateOutcomes.zzab(dataHolder);
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public Set<String> getRequestIds() {
            return this.zzaFB.getRequestIds();
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public int getRequestOutcome(String requestId) {
            return this.zzaFB.getRequestOutcome(requestId);
        }
    }

    public static final class VideoAvailableResultImpl implements Videos.VideoAvailableResult {
        private final Status zzUX;
        private final boolean zzaFC;

        VideoAvailableResultImpl(Status status, boolean isAvailable) {
            this.zzUX = status;
            this.zzaFC = isAvailable;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static final class VideoCapabilitiesResultImpl implements Videos.VideoCapabilitiesResult {
        private final Status zzUX;
        private final VideoCapabilities zzaFD;

        VideoCapabilitiesResultImpl(Status status, VideoCapabilities capabilities) {
            this.zzUX = status;
            this.zzaFD = capabilities;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class VideoRecordingAvailableBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Videos.VideoAvailableResult> zzamC;

        VideoRecordingAvailableBinderCallback(zza.zzb<Videos.VideoAvailableResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zzd(int i, boolean z) {
            this.zzamC.zzs(new VideoAvailableResultImpl(new Status(i), z));
        }
    }

    private static final class VideoRecordingCapabilitiesBinderCallback extends AbstractGamesCallbacks {
        private final zza.zzb<Videos.VideoCapabilitiesResult> zzamC;

        VideoRecordingCapabilitiesBinderCallback(zza.zzb<Videos.VideoCapabilitiesResult> holder) {
            this.zzamC = (zza.zzb) zzx.zzb(holder, "Holder must not be null");
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesCallbacks, com.google.android.gms.games.internal.IGamesCallbacks
        public void zza(int i, VideoCapabilities videoCapabilities) {
            this.zzamC.zzs(new VideoCapabilitiesResultImpl(new Status(i), videoCapabilities));
        }
    }

    public GamesClientImpl(Context context, Looper looper, com.google.android.gms.common.internal.zzf clientSettings, Games.GamesOptions options, GoogleApiClient.ConnectionCallbacks connectedListener, GoogleApiClient.OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, clientSettings, connectedListener, connectionFailedListener);
        this.zzaDZ = new EventIncrementManager() { // from class: com.google.android.gms.games.internal.GamesClientImpl.1
            @Override // com.google.android.gms.games.internal.events.EventIncrementManager
            public EventIncrementCache zzwS() {
                return GamesClientImpl.this.new GameClientEventIncrementCache();
            }
        };
        this.zzaEe = false;
        this.zzaEa = clientSettings.zzqv();
        this.zzaEf = new Binder();
        this.zzaEd = PopupManager.zza(this, clientSettings.zzqr());
        zzo(clientSettings.zzqx());
        this.zzaEg = hashCode();
        this.zzaEh = options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Room zzY(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        try {
            return roomBuffer.getCount() > 0 ? roomBuffer.get(0).freeze() : null;
        } finally {
            roomBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzwv() {
        this.zzaEb = null;
        this.zzaEc = null;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        this.zzaEe = false;
        if (isConnected()) {
            try {
                IGamesService iGamesServiceZzqJ = zzqJ();
                iGamesServiceZzqJ.zzwR();
                this.zzaDZ.flush();
                iGamesServiceZzqJ.zzF(this.zzaEg);
            } catch (RemoteException e) {
                GamesLog.zzz("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        this.zzaEe = false;
    }

    public int zza(zzq<RealTimeMultiplayer.ReliableMessageSentCallback> zzqVar, byte[] bArr, String str, String str2) {
        try {
            return zzqJ().zza(new RealTimeReliableMessageBinderCallbacks(zzqVar), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb(strArr, "Participant IDs must not be null");
        try {
            return zzqJ().zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent intentZza = zzqJ().zza(i, bArr, i2, str);
            zzx.zzb(bitmap, "Must provide a non null icon");
            intentZza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return intentZza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return zzqJ().zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return zzqJ().zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return zzqJ().zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaEe = bundle.getBoolean("show_welcome_popup");
            this.zzaEb = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaEc = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                zzqJ().zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void zza(GoogleApiClient.zza zzaVar) {
        zzwv();
        super.zza(zzaVar);
    }

    public void zza(zza.zzb<Invitations.LoadInvitationsResult> zzbVar, int i) throws RemoteException {
        zzqJ().zza((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzbVar), i);
    }

    public void zza(zza.zzb<Requests.LoadRequestsResult> zzbVar, int i, int i2, int i3) throws RemoteException {
        zzqJ().zza(new RequestsLoadedBinderCallbacks(zzbVar), i, i2, i3);
    }

    public void zza(zza.zzb<AppContents.LoadAppContentResult> zzbVar, int i, String str, String[] strArr, boolean z) throws RemoteException {
        zzqJ().zza(new AppContentLoadedBinderCallbacks(zzbVar), i, str, strArr, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zzqJ().zza(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzbVar, int i, int[] iArr) throws RemoteException {
        zzqJ().zza(new TurnBasedMatchesLoadedBinderCallbacks(zzbVar), i, iArr);
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        zzqJ().zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), leaderboardScoreBuffer.zzxJ().asBundle(), i, i2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        zzqJ().zza(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzxP(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zza.zzb<Snapshots.CommitSnapshotResult> zzbVar, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporterZzxU = snapshotMetadataChange.zzxU();
        if (bitmapTeleporterZzxU != null) {
            bitmapTeleporterZzxU.zzc(getContext().getCacheDir());
        }
        Contents contentsZzsx = snapshotContents.zzsx();
        snapshotContents.close();
        zzqJ().zza(new SnapshotCommittedBinderCallbacks(zzbVar), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZzsx);
    }

    public void zza(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str) throws RemoteException {
        zzqJ().zza(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zza(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zza(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        zzqJ().zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, i, i2, i3, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        switch (str) {
            case "played_with":
                zzqJ().zzd(new PlayersLoadedBinderCallback(zzbVar), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LoadMatchesResult> zzbVar, String str, int i, int[] iArr) throws RemoteException {
        zzqJ().zza(new TurnBasedMatchesLoadedBinderCallbacks(zzbVar), str, i, iArr);
    }

    public void zza(zza.zzb<Leaderboards.SubmitScoreResult> zzbVar, String str, long j, String str2) throws RemoteException {
        zzqJ().zza(zzbVar == null ? null : new SubmitScoreBinderCallbacks(zzbVar), str, j, str2);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzbVar, String str, String str2) throws RemoteException {
        zzqJ().zzc(new TurnBasedMatchLeftBinderCallbacks(zzbVar), str, str2);
    }

    public void zza(zza.zzb<Leaderboards.LoadPlayerScoreResult> zzbVar, String str, String str2, int i, int i2) throws RemoteException {
        zzqJ().zza(new PlayerLeaderboardScoreLoadedBinderCallback(zzbVar), str, str2, i, i2);
    }

    public void zza(zza.zzb<Requests.LoadRequestsResult> zzbVar, String str, String str2, int i, int i2, int i3) throws RemoteException {
        zzqJ().zza(new RequestsLoadedBinderCallbacks(zzbVar), str, str2, i, i2, i3);
    }

    public void zza(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        zzqJ().zza(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, str2, i, i2, i3, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        switch (str) {
            case "circled":
            case "played_with":
            case "nearby":
                zzqJ().zza(new PlayersLoadedBinderCallback(zzbVar), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zza.zzb<Snapshots.OpenSnapshotResult> zzbVar, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporterZzxU = snapshotMetadataChange.zzxU();
        if (bitmapTeleporterZzxU != null) {
            bitmapTeleporterZzxU.zzc(getContext().getCacheDir());
        }
        Contents contentsZzsx = snapshotContents.zzsx();
        snapshotContents.close();
        zzqJ().zza(new SnapshotOpenedBinderCallbacks(zzbVar), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZzsx);
    }

    public void zza(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, String str, String str2, boolean z) throws RemoteException {
        zzqJ().zzb(new LeaderboardsLoadedBinderCallback(zzbVar), str, str2, z);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzbVar, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zza(new QuestsLoadedBinderCallbacks(zzbVar), str, str2, strArr, z);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzbVar, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zza(new QuestsLoadedBinderCallbacks(zzbVar), str, str2, iArr, i, z);
    }

    public void zza(zza.zzb<Requests.UpdateRequestsResult> zzbVar, String str, String str2, String[] strArr) throws RemoteException {
        zzqJ().zza(new RequestsUpdatedBinderCallbacks(zzbVar), str, str2, strArr);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, boolean z) throws RemoteException {
        zzqJ().zzf(new PlayersLoadedBinderCallback(zzbVar), str, z);
    }

    public void zza(zza.zzb<Snapshots.OpenSnapshotResult> zzbVar, String str, boolean z, int i) throws RemoteException {
        zzqJ().zza(new SnapshotOpenedBinderCallbacks(zzbVar), str, z, i);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzbVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        zzqJ().zza(new TurnBasedMatchUpdatedBinderCallbacks(zzbVar), str, bArr, str2, participantResultArr);
    }

    public void zza(zza.zzb<TurnBasedMultiplayer.UpdateMatchResult> zzbVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        zzqJ().zza(new TurnBasedMatchUpdatedBinderCallbacks(zzbVar), str, bArr, participantResultArr);
    }

    public void zza(zza.zzb<Requests.SendRequestResult> zzbVar, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        zzqJ().zza(new RequestSentBinderCallbacks(zzbVar), str, strArr, i, bArr, i2);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zzc(new PlayersLoadedBinderCallback(zzbVar), z);
    }

    public void zza(zza.zzb<Status> zzbVar, boolean z, Bundle bundle) throws RemoteException {
        zzqJ().zza(new ContactSettingsUpdatedBinderCallback(zzbVar), z, bundle);
    }

    public void zza(zza.zzb<Events.LoadEventsResult> zzbVar, boolean z, String... strArr) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zza(new EventsLoadedBinderCallback(zzbVar), z, strArr);
    }

    public void zza(zza.zzb<Quests.LoadQuestsResult> zzbVar, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zza(new QuestsLoadedBinderCallbacks(zzbVar), iArr, i, z);
    }

    public void zza(zza.zzb<Players.LoadPlayersResult> zzbVar, String[] strArr) throws RemoteException {
        zzqJ().zzc(new PlayersLoadedBinderCallback(zzbVar), strArr);
    }

    public void zza(zzq<OnInvitationReceivedListener> zzqVar) {
        try {
            zzqJ().zza(new InvitationReceivedBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzq<RoomUpdateListener> zzqVar, zzq<RoomStatusUpdateListener> zzqVar2, zzq<RealTimeMessageReceivedListener> zzqVar3, RoomConfig roomConfig) {
        try {
            zzqJ().zza((IGamesCallbacks) new RoomBinderCallbacks(zzqVar, zzqVar2, zzqVar3), (IBinder) this.zzaEf, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzq<RoomUpdateListener> zzqVar, String str) {
        try {
            zzqJ().zzc(new RoomBinderCallbacks(zzqVar), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(Games.BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl, String str, String str2, VideoConfiguration videoConfiguration) throws RemoteException {
        zzqJ().zza(new StartRecordingBinderCallback(baseGamesApiMethodImpl), str, str2, videoConfiguration);
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void zza(@NonNull IGamesService iGamesService) {
        super.zza(iGamesService);
        if (this.zzaEe) {
            this.zzaEd.zzxh();
            this.zzaEe = false;
        }
        if (this.zzaEh.zzaCE) {
            return;
        }
        zzb(iGamesService);
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents contentsZzsx = snapshotContents.zzsx();
        snapshotContents.close();
        try {
            zzqJ().zza(contentsZzsx);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzah(boolean z) {
        if (z && this.zzaEb != null) {
            return this.zzaEb.getPlayerId();
        }
        try {
            return zzqJ().zzwT();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return zzqJ().zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return zzqJ().zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Set<Scope> zzb(Set<Scope> set) {
        boolean z;
        boolean z2;
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        boolean z3 = false;
        boolean z4 = false;
        for (Scope scope3 : set) {
            if (scope3.equals(scope)) {
                z = z3;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                z = true;
                z2 = z4;
            } else {
                z = z3;
                z2 = z4;
            }
            z4 = z2;
            z3 = z;
        }
        if (z3) {
            zzx.zza(!z4, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z4, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zzqJ().zzb(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zzb(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzb(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zzb(zza.zzb<Achievements.UpdateAchievementResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zzb(zzbVar == null ? null : new AchievementUpdatedBinderCallback(zzbVar), str, i, this.zzaEd.zzxj(), this.zzaEd.zzxi());
    }

    public void zzb(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        zzqJ().zzb(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, i, i2, i3, z);
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        zzqJ().zzb(new PlayersLoadedBinderCallback(zzbVar), str, i, z, z2);
    }

    public void zzb(zza.zzb<Quests.ClaimMilestoneResult> zzbVar, String str, String str2) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zzf(new QuestMilestoneClaimBinderCallbacks(zzbVar, str2), str, str2);
    }

    public void zzb(zza.zzb<Leaderboards.LoadScoresResult> zzbVar, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        zzqJ().zzb(new LeaderboardScoresLoadedBinderCallback(zzbVar), str, str2, i, i2, i3, z);
    }

    public void zzb(zza.zzb<Players.LoadPlayersResult> zzbVar, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        zzqJ().zzb(new PlayersLoadedBinderCallback(zzbVar), str, str2, i, z, z2);
    }

    public void zzb(zza.zzb<Achievements.LoadAchievementsResult> zzbVar, String str, String str2, boolean z) throws RemoteException {
        zzqJ().zza(new AchievementsLoadedBinderCallback(zzbVar), str, str2, z);
    }

    public void zzb(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, String str, boolean z) throws RemoteException {
        zzqJ().zzc(new LeaderboardsLoadedBinderCallback(zzbVar), str, z);
    }

    public void zzb(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zzb(new LeaderboardsLoadedBinderCallback(zzbVar), z);
    }

    public void zzb(zza.zzb<Quests.LoadQuestsResult> zzbVar, boolean z, String[] strArr) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zza(new QuestsLoadedBinderCallbacks(zzbVar), strArr, z);
    }

    public void zzb(zza.zzb<Requests.UpdateRequestsResult> zzbVar, String[] strArr) throws RemoteException {
        zzqJ().zza(new RequestsUpdatedBinderCallbacks(zzbVar), strArr);
    }

    public void zzb(zzq<OnTurnBasedMatchUpdateReceivedListener> zzqVar) {
        try {
            zzqJ().zzb(new MatchUpdateReceivedBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(zzq<RoomUpdateListener> zzqVar, zzq<RoomStatusUpdateListener> zzqVar2, zzq<RealTimeMessageReceivedListener> zzqVar3, RoomConfig roomConfig) {
        try {
            zzqJ().zza((IGamesCallbacks) new RoomBinderCallbacks(zzqVar, zzqVar2, zzqVar3), (IBinder) this.zzaEf, roomConfig.getInvitationId(), false, this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(IGamesService iGamesService) {
        try {
            iGamesService.zza(new PopupLocationInfoBinderCallbacks(this.zzaEd), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(String str, zza.zzb<Games.GetServerAuthCodeResult> zzbVar) throws RemoteException {
        zzx.zzh(str, "Please provide a valid serverClientId");
        zzqJ().zza(str, new GetServerAuthCodeBinderCallbacks(zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzbV, reason: merged with bridge method [inline-methods] */
    public IGamesService zzW(IBinder iBinder) {
        return IGamesService.Stub.zzbY(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return zzqJ().zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zzqJ().zzc(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zzc(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzl(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str);
    }

    public void zzc(zza.zzb<Players.LoadXpStreamResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zzb(new PlayerXpStreamLoadedBinderCallback(zzbVar), str, i);
    }

    public void zzc(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str, String str2) throws RemoteException {
        zzqJ().zzd(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str, str2);
    }

    public void zzc(zza.zzb<Snapshots.LoadSnapshotsResult> zzbVar, String str, String str2, boolean z) throws RemoteException {
        zzqJ().zzc(new SnapshotsLoadedBinderCallbacks(zzbVar), str, str2, z);
    }

    public void zzc(zza.zzb<Leaderboards.LeaderboardMetadataResult> zzbVar, String str, boolean z) throws RemoteException {
        zzqJ().zzd(new LeaderboardsLoadedBinderCallback(zzbVar), str, z);
    }

    public void zzc(zza.zzb<Achievements.LoadAchievementsResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zza(new AchievementsLoadedBinderCallback(zzbVar), z);
    }

    public void zzc(zza.zzb<Requests.UpdateRequestsResult> zzbVar, String[] strArr) throws RemoteException {
        zzqJ().zzb(new RequestsUpdatedBinderCallbacks(zzbVar), strArr);
    }

    public void zzc(zzq<QuestUpdateListener> zzqVar) {
        try {
            zzqJ().zzd(new QuestUpdateBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return zzqJ().zzb(bArr, str, (String[]) null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zza.zzb<Games.GetTokenResult> zzbVar) throws RemoteException {
        zzqJ().zzk(new GetAuthTokenBinderCallbacks(zzbVar));
    }

    public void zzd(zza.zzb<Players.LoadPlayersResult> zzbVar, int i, boolean z, boolean z2) throws RemoteException {
        zzqJ().zze(new PlayersLoadedBinderCallback(zzbVar), i, z, z2);
    }

    public void zzd(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzm(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str);
    }

    public void zzd(zza.zzb<Players.LoadXpStreamResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zzc(new PlayerXpStreamLoadedBinderCallback(zzbVar), str, i);
    }

    public void zzd(zza.zzb<TurnBasedMultiplayer.InitiateMatchResult> zzbVar, String str, String str2) throws RemoteException {
        zzqJ().zze(new TurnBasedMatchInitiatedBinderCallbacks(zzbVar), str, str2);
    }

    public void zzd(zza.zzb<Notifications.GameMuteStatusChangeResult> zzbVar, String str, boolean z) throws RemoteException {
        zzqJ().zza(new GameMuteStatusChangedBinderCallback(zzbVar), str, z);
    }

    public void zzd(zza.zzb<Events.LoadEventsResult> zzbVar, boolean z) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zzf(new EventsLoadedBinderCallback(zzbVar), z);
    }

    public void zzd(zzq<OnRequestReceivedListener> zzqVar) {
        try {
            zzqJ().zzc(new RequestReceivedBinderCallback(zzqVar), this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzdH(String str) {
        try {
            zzqJ().zzdP(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzdI(String str) {
        try {
            return zzqJ().zzdI(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzdJ(String str) {
        try {
            zzqJ().zza(str, this.zzaEd.zzxj(), this.zzaEd.zzxi());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zza.zzb<GamesMetadata.LoadGamesResult> zzbVar) throws RemoteException {
        zzqJ().zzd(new GamesLoadedBinderCallback(zzbVar));
    }

    public void zze(zza.zzb<TurnBasedMultiplayer.LeaveMatchResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzo(new TurnBasedMatchLeftBinderCallbacks(zzbVar), str);
    }

    public void zze(zza.zzb<Invitations.LoadInvitationsResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zzb((IGamesCallbacks) new InvitationsLoadedBinderCallback(zzbVar), str, i, false);
    }

    public void zze(zza.zzb<Stats.LoadPlayerStatsResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zzi(new PlayerStatsLoadedBinderCallbacks(zzbVar), z);
    }

    public void zzf(zza.zzb<Status> zzbVar) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zza(new SignOutCompleteBinderCallbacks(zzbVar));
    }

    public void zzf(zza.zzb<TurnBasedMultiplayer.CancelMatchResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzn(new TurnBasedMatchCanceledBinderCallbacks(zzbVar), str);
    }

    public void zzf(zza.zzb<Requests.LoadRequestSummariesResult> zzbVar, String str, int i) throws RemoteException {
        zzqJ().zza((IGamesCallbacks) new RequestSummariesLoadedBinderCallbacks(zzbVar), str, i);
    }

    public void zzf(zza.zzb<Snapshots.LoadSnapshotsResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zzd(new SnapshotsLoadedBinderCallbacks(zzbVar), z);
    }

    public void zzg(zza.zzb<Videos.VideoCapabilitiesResult> zzbVar) throws RemoteException {
        zzqJ().zzm(new VideoRecordingCapabilitiesBinderCallback(zzbVar));
    }

    public void zzg(zza.zzb<TurnBasedMultiplayer.LoadMatchResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzp(new TurnBasedMatchLoadedBinderCallbacks(zzbVar), str);
    }

    public void zzg(zza.zzb<Players.LoadProfileSettingsResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zzg(new ProfileSettingsLoadedBinderCallback(zzbVar), z);
    }

    public void zzgs(int i) {
        this.zzaEd.setGravity(i);
    }

    public void zzgt(int i) {
        try {
            zzqJ().zzgt(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzh(zza.zzb<Videos.VideoAvailableResult> zzbVar) throws RemoteException {
        zzqJ().zzn(new VideoRecordingAvailableBinderCallback(zzbVar));
    }

    public void zzh(zza.zzb<Quests.AcceptQuestResult> zzbVar, String str) throws RemoteException {
        this.zzaDZ.flush();
        zzqJ().zzu(new QuestAcceptedBinderCallbacks(zzbVar), str);
    }

    public void zzh(zza.zzb<Status> zzbVar, boolean z) throws RemoteException {
        zzqJ().zzh(new ProfileSettingsUpdatedBinderCallback(zzbVar), z);
    }

    public void zzi(zza.zzb<Videos.ListVideosResult> zzbVar) throws RemoteException {
        zzqJ().zzl(new ListVideosBinderCallback(zzbVar));
    }

    public void zzi(zza.zzb<Snapshots.DeleteSnapshotResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzr(new SnapshotDeletedBinderCallbacks(zzbVar), str);
    }

    public void zzi(zza.zzb<Notifications.ContactSettingLoadResult> zzbVar, boolean z) throws RemoteException {
        zzqJ().zze(new ContactSettingsLoadedBinderCallback(zzbVar), z);
    }

    public void zzj(zza.zzb<Acls.LoadAclResult> zzbVar) throws RemoteException {
        zzqJ().zzh(new NotifyAclLoadedBinderCallback(zzbVar));
    }

    public void zzj(zza.zzb<GamesMetadata.LoadGameInstancesResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzf(new GameInstancesLoadedBinderCallback(zzbVar), str);
    }

    public void zzk(zza.zzb<Notifications.InboxCountResult> zzbVar) throws RemoteException {
        zzqJ().zzt(new InboxCountsLoadedBinderCallback(zzbVar), (String) null);
    }

    public void zzk(zza.zzb<GamesMetadata.LoadGameSearchSuggestionsResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzq(new GameSearchSuggestionsLoadedBinderCallback(zzbVar), str);
    }

    public Intent zzl(String str, int i, int i2) {
        try {
            return zzqJ().zzm(str, i, i2);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzl(zza.zzb<Games.LoadExperimentsResult> zzbVar) throws RemoteException {
        zzqJ().zzo(new ExperimentsLoadedBinderCallback(zzbVar));
    }

    public void zzl(zza.zzb<Players.LoadXpForGameCategoriesResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(zzbVar), str);
    }

    public void zzm(zza.zzb<Invitations.LoadInvitationsResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzk(new InvitationsLoadedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        String string = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundleZzvD = this.zzaEh.zzvD();
        bundleZzvD.putString("com.google.android.gms.games.key.gamePackageName", this.zzaEa);
        bundleZzvD.putString("com.google.android.gms.games.key.desiredLocale", string);
        bundleZzvD.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaEd.zzxj()));
        bundleZzvD.putInt("com.google.android.gms.games.key.API_VERSION", 3);
        bundleZzvD.putBundle("com.google.android.gms.games.key.signInOptions", zzh.zza(zzqH()));
        return bundleZzvD;
    }

    public void zzn(zza.zzb<Status> zzbVar, String str) throws RemoteException {
        zzqJ().zzj(new NotifyAclUpdatedBinderCallback(zzbVar), str);
    }

    public void zzo(View view) {
        this.zzaEd.zzp(view);
    }

    public void zzo(zza.zzb<Notifications.GameMuteStatusLoadResult> zzbVar, String str) throws RemoteException {
        zzqJ().zzi(new GameMuteStatusLoadedBinderCallback(zzbVar), str);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.internal.zzk.zza
    public Bundle zzoi() {
        try {
            Bundle bundleZzoi = zzqJ().zzoi();
            if (bundleZzoi == null) {
                return bundleZzoi;
            }
            bundleZzoi.setClassLoader(GamesClientImpl.class.getClassLoader());
            return bundleZzoi;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzp(String str, int i) {
        this.zzaDZ.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            zzqJ().zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzr(String str, int i) {
        try {
            zzqJ().zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwA() {
        try {
            return zzqJ().zzwA();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwB() {
        try {
            return zzqJ().zzwB();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwC() {
        try {
            return zzqJ().zzwC();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzwD() {
        try {
            zzqJ().zzG(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwE() {
        try {
            zzqJ().zzH(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwF() {
        try {
            zzqJ().zzJ(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwG() {
        try {
            zzqJ().zzI(this.zzaEg);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwH() {
        try {
            return zzqJ().zzwH();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwI() {
        try {
            return zzqJ().zzwI();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwJ() {
        try {
            return zzqJ().zzwJ();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzwK() {
        try {
            return zzqJ().zzwK();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwL() {
        try {
            return zzqJ().zzwL();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzwM() {
        try {
            return zzqJ().zzwM();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwN() {
        try {
            return zzqJ().zzwN();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwO() {
        try {
            return zzqJ().zzwO();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwP() {
        try {
            return zzqJ().zzwP();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwQ() {
        try {
            return zzqJ().zzwQ();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzwR() {
        if (isConnected()) {
            try {
                zzqJ().zzwR();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public String zzww() {
        try {
            return zzqJ().zzww();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzwx() {
        zzqI();
        synchronized (this) {
            if (this.zzaEb == null) {
                try {
                    PlayerBuffer playerBuffer = new PlayerBuffer(zzqJ().zzwU());
                    try {
                        if (playerBuffer.getCount() > 0) {
                            this.zzaEb = (PlayerEntity) playerBuffer.get(0).freeze();
                        }
                        playerBuffer.release();
                    } catch (Throwable th) {
                        playerBuffer.release();
                        throw th;
                    }
                } catch (RemoteException e) {
                    zzb(e);
                }
            }
        }
        return this.zzaEb;
    }

    public Game zzwy() {
        zzqI();
        synchronized (this) {
            if (this.zzaEc == null) {
                try {
                    GameBuffer gameBuffer = new GameBuffer(zzqJ().zzwW());
                    try {
                        if (gameBuffer.getCount() > 0) {
                            this.zzaEc = (GameEntity) gameBuffer.get(0).freeze();
                        }
                        gameBuffer.release();
                    } catch (Throwable th) {
                        gameBuffer.release();
                        throw th;
                    }
                } catch (RemoteException e) {
                    zzb(e);
                }
            }
        }
        return this.zzaEc;
    }

    public Intent zzwz() {
        try {
            return zzqJ().zzwz();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }
}
