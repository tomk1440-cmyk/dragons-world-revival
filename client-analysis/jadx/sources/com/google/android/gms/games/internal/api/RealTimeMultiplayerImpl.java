package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class RealTimeMultiplayerImpl implements RealTimeMultiplayer {
    private static <L> zzq<L> zza(GoogleApiClient googleApiClient, L l) {
        if (l == null) {
            return null;
        }
        return googleApiClient.zzr(l);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public void create(GoogleApiClient apiClient, RoomConfig config) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb == null) {
            return;
        }
        gamesClientImplZzb.zza(apiClient.zzr(config.getRoomUpdateListener()), zza(apiClient, config.getRoomStatusUpdateListener()), zza(apiClient, config.getMessageReceivedListener()), config);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzr(invitationId, 0);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzq(invitationId, 0);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzh(apiClient).zzc(minPlayers, maxPlayers, true);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzh(apiClient).zzc(minPlayers, maxPlayers, allowAutomatch);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public Intent getWaitingRoomIntent(GoogleApiClient apiClient, Room room, int minParticipantsToStart) {
        return Games.zzh(apiClient).zza(room, minParticipantsToStart);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public void join(GoogleApiClient apiClient, RoomConfig config) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb == null) {
            return;
        }
        gamesClientImplZzb.zzb(apiClient.zzr(config.getRoomUpdateListener()), zza(apiClient, config.getRoomStatusUpdateListener()), zza(apiClient, config.getMessageReceivedListener()), config);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public void leave(GoogleApiClient apiClient, RoomUpdateListener listener, String roomId) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zza(apiClient.zzr(listener), roomId);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public int sendReliableMessage(GoogleApiClient apiClient, RealTimeMultiplayer.ReliableMessageSentCallback callback, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.zzh(apiClient).zza(zza(apiClient, callback), messageData, roomId, recipientParticipantId);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, String recipientParticipantId) {
        return Games.zzh(apiClient).zza(messageData, roomId, new String[]{recipientParticipantId});
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public int sendUnreliableMessage(GoogleApiClient apiClient, byte[] messageData, String roomId, List<String> recipientParticipantIds) {
        return Games.zzh(apiClient).zza(messageData, roomId, (String[]) recipientParticipantIds.toArray(new String[recipientParticipantIds.size()]));
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer
    public int sendUnreliableMessageToOthers(GoogleApiClient apiClient, byte[] messageData, String roomId) {
        return Games.zzh(apiClient).zzd(messageData, roomId);
    }
}
