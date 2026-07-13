package com.prime31;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RealtimeMultiplayer implements OnInvitationReceivedListener, RoomUpdateListener, RealTimeMessageReceivedListener, RoomStatusUpdateListener {
    protected static final String TAG = "Prime31-RTMP";
    private static final int _invitationInboxCode = 78887;
    private static final int _invitePlayersCode = 89989;
    private static final int _waitingRoomCode = 35980;
    private int _invitePlayersVariant = 1;
    private IRealTimeMessageReceivedListener _realtimeMessageListener;
    private Room _room;

    /* JADX INFO: Access modifiers changed from: private */
    public PlayGameServicesPlugin instance() {
        return PlayGameServicesPlugin.instance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RoomConfig.Builder makeBasicRoomConfigBuilder() {
        return RoomConfig.builder(this).setMessageReceivedListener(this).setRoomStatusUpdateListener(this);
    }

    private void UnitySendMessage(String m, String p) {
        instance().UnitySendMultiplayerMessage(m, p);
    }

    private void updateRoom(Room room) {
        this._room = room;
    }

    private void logRoomUpdateStatusCode(int statusCode) {
        Log.i(TAG, "room update statusCode: " + statusCode);
        switch (statusCode) {
            case 0:
                Log.i(TAG, "STATUS_OK");
                break;
            case 1:
                Log.i(TAG, "STATUS_INTERNAL_ERROR");
                break;
            case 2:
                Log.i(TAG, "STATUS_CLIENT_RECONNECT_REQUIRED");
                break;
            case GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED /* 6003 */:
                Log.i(TAG, "STATUS_MULTIPLAYER_DISABLED");
                break;
            case GamesStatusCodes.STATUS_REAL_TIME_CONNECTION_FAILED /* 7000 */:
                Log.i(TAG, "STATUS_REAL_TIME_CONNECTION_FAILED");
                break;
            case GamesStatusCodes.STATUS_OPERATION_IN_FLIGHT /* 7007 */:
                Log.i(TAG, "STATUS_OPERATION_IN_FLIGHT");
                break;
        }
    }

    public void leaveRoom(boolean dontLogIfRoomIsNull) {
        if (this._room == null) {
            if (!dontLogIfRoomIsNull) {
                Log.e(TAG, "the current room is null so we cannot leave the room");
            }
        } else {
            Games.RealTimeMultiplayer.leave(instance().helper.getApiClient(), this, this._room.getRoomId());
            this._room = null;
        }
    }

    private String jsonFromRoomAndStatus(Room room, int statusCode) {
        JSONObject rootJsonObject = new JSONObject();
        try {
            rootJsonObject.put("statusCode", statusCode);
            rootJsonObject.put(Multiplayer.EXTRA_ROOM, jsonFromRoom(room));
        } catch (JSONException e) {
            Log.i("Prime31", "Error creating JSON" + e);
        }
        return rootJsonObject.toString();
    }

    private JSONObject jsonFromRoom(Room room) {
        JSONObject roomJsonObject = new JSONObject();
        if (room != null) {
            try {
                roomJsonObject.put("autoMatchWaitEstimateSeconds", room.getAutoMatchWaitEstimateSeconds());
                roomJsonObject.put("creationTimestamp", room.getCreationTimestamp());
                roomJsonObject.put("creatorId", room.getCreatorId());
                roomJsonObject.put("description", room.getDescription());
                roomJsonObject.put("roomId", room.getRoomId());
                roomJsonObject.put("status", room.getStatus());
                roomJsonObject.put("variant", room.getVariant());
            } catch (JSONException e) {
                Log.i("Prime31", "Error creating JSON" + e);
            }
        }
        return roomJsonObject;
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        boolean success;
        if (requestCode == _invitationInboxCode) {
            success = responseCode == -1;
            UnitySendMessage("onInvitationInboxCompleted", success ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (responseCode == -1) {
                Log.i(TAG, "invitation inbox result OK. Joining room with selected invitation");
                Invitation invitation = (Invitation) intent.getExtras().getParcelable(Multiplayer.EXTRA_INVITATION);
                Games.RealTimeMultiplayer.join(instance().helper.getApiClient(), makeBasicRoomConfigBuilder().setInvitationIdToAccept(invitation.getInvitationId()).build());
                return;
            }
            Log.i(TAG, "invitation responseCode NOT OK. User most likely cancelled.");
            return;
        }
        if (requestCode == _invitePlayersCode) {
            success = responseCode == -1;
            UnitySendMessage("onInvitePlayersCompleted", success ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (responseCode == -1) {
                Log.i(TAG, "invite players result OK. creating room");
                ArrayList<String> invitees = intent.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS);
                int minAutoMatchPlayers = intent.getIntExtra(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, 0);
                int maxAutoMatchPlayers = intent.getIntExtra(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, 0);
                Log.d(TAG, "Invitee count: " + invitees.size());
                RoomConfig.Builder roomConfig = makeBasicRoomConfigBuilder().setVariant(this._invitePlayersVariant).addPlayersToInvite(invitees);
                if (minAutoMatchPlayers > 0) {
                    Bundle autoMatchCriteria = RoomConfig.createAutoMatchCriteria(minAutoMatchPlayers, maxAutoMatchPlayers, 0L);
                    roomConfig.setAutoMatchCriteria(autoMatchCriteria);
                }
                Games.RealTimeMultiplayer.create(instance().helper.getApiClient(), roomConfig.build());
                return;
            }
            Log.i(TAG, "invitation responseCode NOT OK. User most likely cancelled.");
            return;
        }
        if (requestCode == _waitingRoomCode) {
            success = responseCode == -1;
            UnitySendMessage("onWaitingRoomCompleted", success ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            if (responseCode == -1) {
                Log.i(TAG, "waiting room result OK. Clear to start the multiplayer game.");
            } else {
                leaveRoom();
            }
        }
    }

    public void setRealtimeMessageListener(IRealTimeMessageReceivedListener listener) {
        Log.i(TAG, "adding the realtime message listener: " + listener);
        this._realtimeMessageListener = listener;
    }

    public void showInvitationInbox() {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.RealtimeMultiplayer.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = Games.Invitations.getInvitationInboxIntent(RealtimeMultiplayer.this.instance().helper.getApiClient());
                RealtimeMultiplayer.this.instance().getActivity().startActivityForResult(intent, RealtimeMultiplayer._invitationInboxCode);
            }
        });
    }

    public void createRoomProgrammatically(final int minAutoMatchPlayers, final int maxAutoMatchPlayers, final long exclusiveBitmask, final int variant) {
        leaveRoom(true);
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.RealtimeMultiplayer.2
            @Override // java.lang.Runnable
            public void run() {
                Bundle am = RoomConfig.createAutoMatchCriteria(minAutoMatchPlayers, maxAutoMatchPlayers, exclusiveBitmask);
                RoomConfig.Builder roomConfigBuilder = RealtimeMultiplayer.this.makeBasicRoomConfigBuilder().setVariant(variant);
                roomConfigBuilder.setAutoMatchCriteria(am);
                RoomConfig roomConfig = roomConfigBuilder.build();
                Games.RealTimeMultiplayer.create(RealtimeMultiplayer.this.instance().helper.getApiClient(), roomConfig);
            }
        });
    }

    public void showPlayerSelector(final int minPlayers, final int maxPlayers, int variant) {
        this._invitePlayersVariant = variant;
        leaveRoom(true);
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.RealtimeMultiplayer.3
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = Games.RealTimeMultiplayer.getSelectOpponentsIntent(RealtimeMultiplayer.this.instance().helper.getApiClient(), minPlayers, maxPlayers);
                RealtimeMultiplayer.this.instance().getActivity().startActivityForResult(intent, RealtimeMultiplayer._invitePlayersCode);
            }
        });
    }

    public void joinRoomWithInvitation(final String invitationId) {
        leaveRoom(true);
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.RealtimeMultiplayer.4
            @Override // java.lang.Runnable
            public void run() {
                RoomConfig.Builder roomConfig = RealtimeMultiplayer.this.makeBasicRoomConfigBuilder().setInvitationIdToAccept(invitationId);
                Games.RealTimeMultiplayer.join(RealtimeMultiplayer.this.instance().helper.getApiClient(), roomConfig.build());
            }
        });
    }

    public void showWaitingRoom(final int minParticipantsToStart) {
        if (this._room == null) {
            Log.e(TAG, "the current room is null so we cannot show a waiting room");
        } else {
            instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.RealtimeMultiplayer.5
                @Override // java.lang.Runnable
                public void run() {
                    Intent intent = Games.RealTimeMultiplayer.getWaitingRoomIntent(RealtimeMultiplayer.this.instance().helper.getApiClient(), RealtimeMultiplayer.this._room, minParticipantsToStart);
                    RealtimeMultiplayer.this.instance().getActivity().startActivityForResult(intent, RealtimeMultiplayer._waitingRoomCode);
                }
            });
        }
    }

    public void leaveRoom() {
        leaveRoom(false);
    }

    public String getRoom() {
        return this._room == null ? "{}" : jsonFromRoom(this._room).toString();
    }

    public String getParticipants(boolean ignoreCurrentPlayer) {
        if (this._room == null || this._room.getParticipants().size() == 0) {
            return "[]";
        }
        String currentPlayerParticipantId = getCurrentPlayerParticipantId();
        JSONArray jsonArr = new JSONArray();
        try {
            for (Participant p : this._room.getParticipants()) {
                if (p == null) {
                    Log.i(TAG, "found null participant in participant list. Ignoring");
                } else if (ignoreCurrentPlayer && p.getParticipantId().equalsIgnoreCase(currentPlayerParticipantId)) {
                    Log.i(TAG, "found current player participant. Ignoring");
                } else {
                    JSONObject json = new JSONObject();
                    if (p.getParticipantId() != null) {
                        json.put("participantId", p.getParticipantId());
                    }
                    if (p.getDisplayName() != null) {
                        json.put("displayName", p.getDisplayName());
                    }
                    if (p.getIconImageUri() != null) {
                        json.put("iconImageUrl", p.getIconImageUri().toString());
                    }
                    if (p.getHiResImageUri() != null) {
                        json.put("hiResImageUrl", p.getHiResImageUri().toString());
                    }
                    json.put("isConnectedToRoom", p.isConnectedToRoom());
                    switch (p.getStatus()) {
                        case 1:
                            json.put("status", "Invited");
                            break;
                        case 2:
                            json.put("status", "Joined");
                            break;
                        case 3:
                            json.put("status", "Declined");
                            break;
                        case 4:
                            json.put("status", "Left");
                            break;
                    }
                    jsonArr.put(json);
                }
            }
        } catch (Exception e) {
            Log.i("Prime31", "Error creating JSON for participants: " + e);
        }
        return jsonArr.toString();
    }

    public String getCurrentPlayerParticipantId() {
        if (this._room == null) {
            return null;
        }
        String currentPlayerId = Games.Players.getCurrentPlayerId(instance().helper.getApiClient());
        return this._room.getParticipantId(currentPlayerId);
    }

    public void sendReliableRealtimeMessage(String participantId, byte[] message) {
        if (this._room == null || this._room.getParticipants().size() == 0) {
            Log.e(TAG, "cannot send a message due to the player not being connected to a room");
            return;
        }
        if (this._room.getParticipantStatus(participantId) != 2) {
            Log.e(TAG, "cannot send a message to a participant that has not joined the room. Particpent " + participantId + " has status: " + this._room.getParticipantStatus(participantId));
            return;
        }
        int res = Games.RealTimeMultiplayer.sendReliableMessage(instance().helper.getApiClient(), null, message, this._room.getRoomId(), participantId);
        if (res == -1) {
            Log.i(TAG, "realtime message send failed");
        }
    }

    public void sendReliableRealtimeMessageToAll(byte[] message) {
        if (this._room == null || this._room.getParticipants().size() == 0) {
            Log.e(TAG, "cannot send a message due to the player not being connected to a room");
            return;
        }
        String currentPlayerParticipantId = getCurrentPlayerParticipantId();
        for (String participantId : this._room.getParticipantIds()) {
            if (this._room.getParticipantStatus(participantId) == 2 && !participantId.equalsIgnoreCase(currentPlayerParticipantId)) {
                int res = Games.RealTimeMultiplayer.sendReliableMessage(instance().helper.getApiClient(), null, message, this._room.getRoomId(), participantId);
                if (res == -1) {
                    Log.i(TAG, "realtime message send failed");
                }
            }
        }
    }

    public void sendUnreliableRealtimeMessage(String participantId, byte[] message) {
        if (this._room == null || this._room.getParticipants().size() == 0) {
            Log.e(TAG, "cannot send a message due to the player not being connected to a room");
            return;
        }
        if (this._room.getParticipantStatus(participantId) != 2) {
            Log.e(TAG, "cannot send a message to a participant that has not joined the room. Particpent " + participantId + " has status: " + this._room.getParticipantStatus(participantId));
            return;
        }
        int res = Games.RealTimeMultiplayer.sendUnreliableMessage(instance().helper.getApiClient(), message, this._room.getRoomId(), participantId);
        if (res == -1) {
            Log.i(TAG, "realtime message send failed");
        }
    }

    public void sendUnreliableRealtimeMessageToAll(byte[] message) {
        if (this._room == null || this._room.getParticipants().size() == 0) {
            Log.e(TAG, "cannot send a message due to the player not being connected to a room");
            return;
        }
        int res = Games.RealTimeMultiplayer.sendUnreliableMessageToOthers(instance().helper.getApiClient(), message, this._room.getRoomId());
        if (res == -1) {
            Log.i(TAG, "realtime message send failed");
        }
    }

    @Override // com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
    public void onInvitationReceived(Invitation invitation) {
        Log.i(TAG, "onInvitationReceived: " + invitation.getInvitationId());
        UnitySendMessage("onInvitationReceived", invitation.getInvitationId());
        instance().UnitySendTBMultiplayerMessage("onInvitationReceived", invitation.getInvitationId());
    }

    @Override // com.google.android.gms.games.multiplayer.OnInvitationReceivedListener
    public void onInvitationRemoved(String invitationId) {
        Log.i(TAG, "onInvitationRemoved: " + invitationId);
        UnitySendMessage("onInvitationRemoved", invitationId);
        instance().UnitySendTBMultiplayerMessage("onInvitationRemoved", invitationId);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onJoinedRoom(int statusCode, Room room) {
        Log.i(TAG, "onJoinedRoom " + room);
        logRoomUpdateStatusCode(statusCode);
        updateRoom(room);
        UnitySendMessage("onJoinedRoom", jsonFromRoomAndStatus(room, statusCode));
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onLeftRoom(int statusCode, String roomId) {
        Log.i(TAG, "onLeftRoom");
        logRoomUpdateStatusCode(statusCode);
        UnitySendMessage("onLeftRoom", roomId);
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onRoomConnected(int statusCode, Room room) {
        Log.i(TAG, "onRoomConnected " + room);
        logRoomUpdateStatusCode(statusCode);
        updateRoom(room);
        UnitySendMessage("onRoomConnected", jsonFromRoomAndStatus(room, statusCode));
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener
    public void onRoomCreated(int statusCode, Room room) {
        Log.i(TAG, "onRoomCreated " + room);
        logRoomUpdateStatusCode(statusCode);
        updateRoom(room);
        UnitySendMessage("onRoomCreated", jsonFromRoomAndStatus(room, statusCode));
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener
    public void onRealTimeMessageReceived(RealTimeMessage message) {
        byte[] messageData = message.getMessageData();
        String senderParticipantId = message.getSenderParticipantId();
        if (this._realtimeMessageListener != null) {
            this._realtimeMessageListener.onRawMessageReceived(senderParticipantId, messageData);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onConnectedToRoom(Room room) {
        updateRoom(room);
        UnitySendMessage("onConnectedToRoom", "");
        Log.i(TAG, "onConnectedToRoom");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onDisconnectedFromRoom(Room room) {
        Games.RealTimeMultiplayer.leave(instance().helper.getApiClient(), this, room.getRoomId());
        this._room = null;
        UnitySendMessage("onDisconnectedFromRoom", "");
        Log.i(TAG, "onDisconnectedFromRoom");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onP2PConnected(String participantId) {
        UnitySendMessage("onP2PConnected", participantId);
        Log.i(TAG, "onP2PConnected");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onP2PDisconnected(String participantId) {
        UnitySendMessage("onP2PDisconnected", participantId);
        Log.i(TAG, "onP2PDisconnected");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerDeclined(Room room, List<String> participantIds) {
        updateRoom(room);
        for (String id : participantIds) {
            UnitySendMessage("onPeerDeclined", id);
        }
        Log.i(TAG, "onPeerDeclined");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerInvitedToRoom(Room room, List<String> participantIds) {
        updateRoom(room);
        for (String id : participantIds) {
            UnitySendMessage("onPeerInvitedToRoom", id);
        }
        Log.i(TAG, "onPeerInvitedToRoom");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerJoined(Room room, List<String> participantIds) {
        updateRoom(room);
        for (String id : participantIds) {
            UnitySendMessage("onPeerJoined", id);
        }
        Log.i(TAG, "onPeerJoined");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeerLeft(Room room, List<String> participantIds) {
        updateRoom(room);
        for (String id : participantIds) {
            UnitySendMessage("onPeerLeft", id);
        }
        Log.i(TAG, "onPeerLeft");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeersConnected(Room room, List<String> participantIds) {
        updateRoom(room);
        for (String id : participantIds) {
            UnitySendMessage("onPeerConnected", id);
        }
        Log.i(TAG, "onPeersConnected");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onPeersDisconnected(Room room, List<String> participantIds) {
        updateRoom(room);
        for (String id : participantIds) {
            UnitySendMessage("onPeerDisconnected", id);
        }
        Log.i(TAG, "onPeersDisconnected");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onRoomAutoMatching(Room room) {
        updateRoom(room);
        UnitySendMessage("onRoomAutoMatching", jsonFromRoom(room).toString());
        Log.i(TAG, "onRoomAutoMatching");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener
    public void onRoomConnecting(Room room) {
        updateRoom(room);
        UnitySendMessage("onRoomConnecting", jsonFromRoom(room).toString());
        Log.i(TAG, "onRoomConnecting");
    }
}
