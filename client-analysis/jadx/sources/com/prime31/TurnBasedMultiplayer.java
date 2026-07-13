package com.prime31;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.prime31.GPS.utils.Base64;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TurnBasedMultiplayer implements ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult>, OnTurnBasedMatchUpdateReceivedListener {
    protected static final String TAG = "Prime31-TBMP";
    private static final int _inboxCode = 5672343;
    private static final int _selectPlayersCode = 54887;

    public TurnBasedMultiplayer() {
        Log.i(TAG, "wiring up OnTurnBasedMatchUpdateReceivedListener");
        Games.TurnBasedMultiplayer.registerMatchUpdateListener(instance().helper.getApiClient(), this);
    }

    public void onResume() {
        Log.i(TAG, "wiring up OnTurnBasedMatchUpdateReceivedListener after resume");
        Games.TurnBasedMultiplayer.registerMatchUpdateListener(instance().helper.getApiClient(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PlayGameServicesPlugin instance() {
        return PlayGameServicesPlugin.instance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UnitySendMessage(String m, String p) {
        instance().UnitySendTBMultiplayerMessage(m, p);
    }

    public void onActivityResult(int requestCode, int responseCode, Intent intent) {
        Bundle autoMatchCriteria;
        if (requestCode == _selectPlayersCode) {
            if (responseCode != -1) {
                Log.i(TAG, "player selector cancelled");
                UnitySendMessage("playerSelectorCanceled", "");
                return;
            }
            ArrayList<String> invitees = intent.getStringArrayListExtra(Games.EXTRA_PLAYER_IDS);
            int minAutoMatchPlayers = intent.getIntExtra(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, 0);
            int maxAutoMatchPlayers = intent.getIntExtra(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, 0);
            if (minAutoMatchPlayers > 0) {
                autoMatchCriteria = RoomConfig.createAutoMatchCriteria(minAutoMatchPlayers, maxAutoMatchPlayers, 0L);
            } else {
                autoMatchCriteria = null;
            }
            TurnBasedMatchConfig tbmc = TurnBasedMatchConfig.builder().addInvitedPlayers(invitees).setAutoMatchCriteria(autoMatchCriteria).build();
            Games.TurnBasedMultiplayer.createMatch(instance().helper.getApiClient(), tbmc).setResultCallback(this);
            return;
        }
        if (requestCode == _inboxCode) {
            if (responseCode != -1) {
                Log.i(TAG, "inbox cancelled");
                return;
            }
            Invitation invitation = (Invitation) intent.getExtras().getParcelable(Multiplayer.EXTRA_INVITATION);
            TurnBasedMatch match = (TurnBasedMatch) intent.getExtras().getParcelable(Multiplayer.EXTRA_TURN_BASED_MATCH);
            Log.i(TAG, "inbox complete. going to check for invitations and matches returned");
            Log.i(TAG, "has invitation: " + (invitation != null));
            Log.i(TAG, "has match: " + (match != null));
            if (match != null && invitation != null) {
                sendInvitationReceivedCallback(invitation, match);
            } else if (match != null) {
                sendMatchChangedCallback(match);
            }
        }
    }

    private void sendInvitationReceivedCallback(Invitation invitation, TurnBasedMatch match) {
        JSONObject rootJsonObject = new JSONObject();
        try {
            rootJsonObject.put("invitingParticipant", participantAsJson(invitation.getInviter()));
            rootJsonObject.put("match", matchAsJson(match));
        } catch (JSONException e) {
            Log.i("Prime31", "Error creating JSON" + e);
        }
        UnitySendMessage("invitationReceived", rootJsonObject.toString());
    }

    private void sendMatchChangedCallback(TurnBasedMatch match) {
        UnitySendMessage("matchChanged", matchAsJson(match).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResultCallback(Status status, String successMethod, String failMethod) {
        if (status.isSuccess()) {
            UnitySendMessage(successMethod, "");
        } else {
            UnitySendMessage(failMethod, PlayGameServicesPlugin.gamesStatusErrorCodeToString(status.getStatusCode()));
        }
    }

    private int matchStatusToReality(int status) {
        switch (status) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 3;
            default:
                return 5;
        }
    }

    private int userMatchStatusToReality(int status) {
        switch (status) {
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
            default:
                return 3;
        }
    }

    private int participantStatusToReality(int status) {
        switch (status) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                return -1;
        }
    }

    public JSONObject matchAsJson(TurnBasedMatch m) {
        JSONObject rootJsonObject = new JSONObject();
        if (m != null) {
            try {
                Player selfPlayer = Games.Players.getCurrentPlayer(instance().helper.getApiClient());
                if (m.getData() != null) {
                    rootJsonObject.put(ShareConstants.WEB_DIALOG_PARAM_DATA, Base64.encode(m.getData()));
                }
                rootJsonObject.put("matchDescription", m.getDescription());
                rootJsonObject.put("matchId", m.getMatchId());
                rootJsonObject.put("matchNumber", m.getMatchNumber());
                rootJsonObject.put("matchVersion", m.getMatchNumber());
                rootJsonObject.put("pendingParticipantId", m.getPendingParticipantId() != null ? m.getPendingParticipantId() : "");
                rootJsonObject.put("localParticipantId", m.getParticipantId(selfPlayer.getPlayerId()));
                rootJsonObject.put("statusInt", matchStatusToReality(m.getStatus()));
                rootJsonObject.put("userMatchStatusInt", userMatchStatusToReality(m.getTurnStatus()));
                rootJsonObject.put("availableAutoMatchSlots", m.getAvailableAutoMatchSlots());
                rootJsonObject.put("canRematch", m.canRematch());
                JSONArray arr = new JSONArray();
                for (Participant p : m.getParticipants()) {
                    arr.put(participantAsJson(p));
                }
                rootJsonObject.put(Games.EXTRA_PLAYER_IDS, arr);
            } catch (JSONException e) {
                Log.i("Prime31", "Error creating JSON" + e);
            }
        }
        return rootJsonObject;
    }

    public JSONObject participantAsJson(Participant p) {
        JSONObject rootJsonObject = new JSONObject();
        if (p == null) {
            Log.i(TAG, "bailing out on serializing participant since we were sent a null one");
        } else {
            try {
                Player player = p.getPlayer();
                if (player == null) {
                    Log.i(TAG, "bailing out on serializing participant's player object since we were sent a null one");
                } else {
                    JSONObject playerJsonObject = new JSONObject();
                    playerJsonObject.put("avatarUrl", player.getIconImageUri());
                    playerJsonObject.put("avatarUrlHiRes", player.getHiResImageUri());
                    playerJsonObject.put("name", player.getDisplayName());
                    playerJsonObject.put("playerId", player.getPlayerId());
                    rootJsonObject.put("participantId", p.getParticipantId());
                    rootJsonObject.put("statusInt", participantStatusToReality(p.getStatus()));
                    rootJsonObject.put("player", playerJsonObject);
                }
            } catch (JSONException e) {
                Log.i("Prime31", "Error creating JSON" + e);
            }
        }
        return rootJsonObject;
    }

    public void checkForInvitesAndMatches() {
        TurnBasedMatch match = null;
        Invitation invitation = null;
        if (instance().helper.hasInvitation()) {
            Log.i(TAG, "GameHelper has an invite");
            invitation = instance().helper.getInvitation();
        }
        if (instance().helper.hasTurnBasedMatch()) {
            Log.i(TAG, "GameHelper has a turn based match");
            match = instance().helper.getTurnBasedMatch();
        }
        if (match != null && invitation != null) {
            sendInvitationReceivedCallback(invitation, match);
        } else if (match != null) {
            sendMatchChangedCallback(match);
        }
        instance().helper.clearInvitation();
        instance().helper.clearTurnBasedMatch();
    }

    public void showInbox() {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = Games.TurnBasedMultiplayer.getInboxIntent(TurnBasedMultiplayer.this.instance().helper.getApiClient());
                TurnBasedMultiplayer.this.instance().getActivity().startActivityForResult(intent, TurnBasedMultiplayer._inboxCode);
            }
        });
    }

    public void loadAllMatches() {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.2
            @Override // java.lang.Runnable
            public void run() {
                int[] statuses = {0, 1, 2, 3};
                Games.TurnBasedMultiplayer.loadMatchesByStatus(TurnBasedMultiplayer.this.instance().helper.getApiClient(), statuses).setResultCallback(new ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult>() { // from class: com.prime31.TurnBasedMultiplayer.2.1
                    private void addBufferToJsonArray(TurnBasedMatchBuffer buffer, JSONArray jsonArr) {
                        for (int i = 0; i < buffer.getCount(); i++) {
                            TurnBasedMatch match = buffer.get(i);
                            jsonArr.put(TurnBasedMultiplayer.this.matchAsJson(match));
                        }
                    }

                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult result) {
                        if (!result.getStatus().isSuccess()) {
                            TurnBasedMultiplayer.this.UnitySendMessage("loadMatchesFailed", PlayGameServicesPlugin.gamesStatusErrorCodeToString(result.getStatus().getStatusCode()));
                            return;
                        }
                        JSONArray jsonArr = new JSONArray();
                        addBufferToJsonArray(result.getMatches().getCompletedMatches(), jsonArr);
                        addBufferToJsonArray(result.getMatches().getMyTurnMatches(), jsonArr);
                        addBufferToJsonArray(result.getMatches().getTheirTurnMatches(), jsonArr);
                        TurnBasedMultiplayer.this.UnitySendMessage("loadMatchesSucceeded", jsonArr.toString());
                    }
                });
            }
        });
    }

    public void showPlayerSelector(final int minPlayers, final int maxPlayers) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.3
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = Games.TurnBasedMultiplayer.getSelectOpponentsIntent(TurnBasedMultiplayer.this.instance().helper.getApiClient(), minPlayers, maxPlayers, true);
                TurnBasedMultiplayer.this.instance().getActivity().startActivityForResult(intent, TurnBasedMultiplayer._selectPlayersCode);
            }
        });
    }

    public void createMatchProgrammatically(final int minAutoMatchPlayers, final int maxAutoMatchPlayers, final long exclusiveBitmask, final int variant) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.4
            @Override // java.lang.Runnable
            public void run() {
                Bundle autoMatchCriteria = RoomConfig.createAutoMatchCriteria(minAutoMatchPlayers, maxAutoMatchPlayers, exclusiveBitmask);
                TurnBasedMatchConfig tbmc = TurnBasedMatchConfig.builder().setVariant(variant).setAutoMatchCriteria(autoMatchCriteria).build();
                Games.TurnBasedMultiplayer.createMatch(TurnBasedMultiplayer.this.instance().helper.getApiClient(), tbmc).setResultCallback(TurnBasedMultiplayer.this);
            }
        });
    }

    public void takeTurn(final String matchId, final byte[] matchData, final String pendingParticipantId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.5
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.takeTurn(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId, matchData, pendingParticipantId).setResultCallback(new ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult>() { // from class: com.prime31.TurnBasedMultiplayer.5.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult result) {
                        Log.i(TurnBasedMultiplayer.TAG, "takeTurn result: " + PlayGameServicesPlugin.gamesStatusErrorCodeToString(result.getStatus().getStatusCode()));
                        TurnBasedMultiplayer.this.sendResultCallback(result.getStatus(), "takeTurnSucceeded", "takeTurnFailed");
                    }
                });
            }
        });
    }

    public void leaveDuringTurn(final String matchId, final String pendingParticipantId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.6
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.leaveMatchDuringTurn(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId, pendingParticipantId).setResultCallback(new ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult>() { // from class: com.prime31.TurnBasedMultiplayer.6.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult result) {
                        Log.i(TurnBasedMultiplayer.TAG, "leaveDuringTurn result: " + result);
                        TurnBasedMultiplayer.this.sendResultCallback(result.getStatus(), "leaveDuringTurnSucceeded", "leaveDuringTurnFailed");
                    }
                });
            }
        });
    }

    public void leaveOutOfTurn(final String matchId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.7
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.leaveMatch(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId).setResultCallback(new ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult>() { // from class: com.prime31.TurnBasedMultiplayer.7.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult result) {
                        Log.i(TurnBasedMultiplayer.TAG, "leaveDuringTurn result: " + result);
                        TurnBasedMultiplayer.this.sendResultCallback(result.getStatus(), "leaveOutOfTurnSucceeded", "leaveOutOfTurnFailed");
                    }
                });
            }
        });
    }

    public void finishMatchWithData(final String matchId, final byte[] matchData, final String resultsJson) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.8
            private List<ParticipantResult> resultsFromJson(String json) {
                List<ParticipantResult> results = new ArrayList<>();
                try {
                    JSONArray jArray = new JSONArray(json);
                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject jObj = jArray.getJSONObject(i);
                        int result = jObj.getInt("result");
                        int placing = jObj.getInt("placing");
                        String participantId = jObj.getString("participantId");
                        results.add(new ParticipantResult(participantId, result, placing));
                    }
                } catch (JSONException e) {
                    Log.i("Prime31", "Error parsing JSON" + e);
                }
                return results;
            }

            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.finishMatch(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId, matchData, resultsFromJson(resultsJson)).setResultCallback(new ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult>() { // from class: com.prime31.TurnBasedMultiplayer.8.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult result) {
                        TurnBasedMultiplayer.this.sendResultCallback(result.getStatus(), "finishMatchSucceeded", "finishMatchFailed");
                    }
                });
            }
        });
    }

    public void finishMatchWithoutData(final String matchId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.9
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.finishMatch(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId).setResultCallback(new ResultCallback<com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult>() { // from class: com.prime31.TurnBasedMultiplayer.9.1
                    @Override // com.google.android.gms.common.api.ResultCallback
                    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult result) {
                        Log.i(TurnBasedMultiplayer.TAG, "finishMatch result: " + result);
                        TurnBasedMultiplayer.this.sendResultCallback(result.getStatus(), "finishMatchSucceeded", "finishMatchFailed");
                    }
                });
            }
        });
    }

    public void dismissMatch(final String matchId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.10
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.dismissMatch(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId);
                TurnBasedMultiplayer.this.UnitySendMessage("dismissMatchSucceeded", "");
            }
        });
    }

    public void rematch(final String matchId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.11
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.rematch(TurnBasedMultiplayer.this.instance().helper.getApiClient(), matchId).setResultCallback(TurnBasedMultiplayer.this);
            }
        });
    }

    public void joinMatchWithInvitation(final String invitationId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.12
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.acceptInvitation(TurnBasedMultiplayer.this.instance().helper.getApiClient(), invitationId).setResultCallback(TurnBasedMultiplayer.this);
            }
        });
    }

    public void declineMatchWithInvitation(final String invitationId) {
        instance().runSafelyOnUiThread(new Runnable() { // from class: com.prime31.TurnBasedMultiplayer.13
            @Override // java.lang.Runnable
            public void run() {
                Games.TurnBasedMultiplayer.declineInvitation(TurnBasedMultiplayer.this.instance().helper.getApiClient(), invitationId);
            }
        });
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult result) {
        if (result.getStatus().getStatusCode() != 0) {
            UnitySendMessage("matchFailed", PlayGameServicesPlugin.gamesStatusErrorCodeToString(result.getStatus().getStatusCode()));
        } else {
            TurnBasedMatch match = result.getMatch();
            sendMatchChangedCallback(match);
        }
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public void onTurnBasedMatchReceived(TurnBasedMatch match) {
        Log.i(TAG, "onTurnBasedMatchReceived. sending data back to Unity.");
        sendMatchChangedCallback(match);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener
    public void onTurnBasedMatchRemoved(String match) {
        Log.i(TAG, "turn based match removed: " + match);
    }
}
