package com.google.android.gms.cast.games;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzli;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class GameManagerClient {
    public static final int GAMEPLAY_STATE_LOADING = 1;
    public static final int GAMEPLAY_STATE_PAUSED = 3;
    public static final int GAMEPLAY_STATE_RUNNING = 2;
    public static final int GAMEPLAY_STATE_SHOWING_INFO_SCREEN = 4;
    public static final int GAMEPLAY_STATE_UNKNOWN = 0;
    public static final int LOBBY_STATE_CLOSED = 2;
    public static final int LOBBY_STATE_OPEN = 1;
    public static final int LOBBY_STATE_UNKNOWN = 0;
    public static final int PLAYER_STATE_AVAILABLE = 3;
    public static final int PLAYER_STATE_DROPPED = 1;
    public static final int PLAYER_STATE_IDLE = 5;
    public static final int PLAYER_STATE_PLAYING = 6;
    public static final int PLAYER_STATE_QUIT = 2;
    public static final int PLAYER_STATE_READY = 4;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int STATUS_INCORRECT_VERSION = 2150;
    public static final int STATUS_TOO_MANY_PLAYERS = 2151;
    private final zzli zzacy;

    public interface GameManagerInstanceResult extends Result {
        GameManagerClient getGameManagerClient();
    }

    public interface GameManagerResult extends Result {
        JSONObject getExtraMessageData();

        String getPlayerId();

        long getRequestId();
    }

    public interface Listener {
        void onGameMessageReceived(String str, JSONObject jSONObject);

        void onStateChanged(GameManagerState gameManagerState, GameManagerState gameManagerState2);
    }

    public GameManagerClient(zzli channel) {
        this.zzacy = channel;
    }

    public static PendingResult<GameManagerInstanceResult> getInstanceFor(GoogleApiClient googleApiClient, String castSessionId) throws IllegalArgumentException {
        return zza(new zzli(googleApiClient, castSessionId, Cast.CastApi));
    }

    static PendingResult<GameManagerInstanceResult> zza(zzli zzliVar) throws IllegalArgumentException {
        return zzliVar.zza(new GameManagerClient(zzliVar));
    }

    private PendingResult<GameManagerResult> zza(String str, int i, JSONObject jSONObject) throws IllegalStateException {
        return this.zzacy.zza(str, i, jSONObject);
    }

    public void dispose() {
        this.zzacy.dispose();
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        return this.zzacy.getCurrentState();
    }

    public String getLastUsedPlayerId() throws IllegalStateException {
        return this.zzacy.getLastUsedPlayerId();
    }

    public boolean isDisposed() {
        return this.zzacy.isDisposed();
    }

    public void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        this.zzacy.sendGameMessage(playerId, extraMessageData);
    }

    public void sendGameMessage(JSONObject extraMessageData) throws IllegalStateException {
        sendGameMessage(getLastUsedPlayerId(), extraMessageData);
    }

    public PendingResult<GameManagerResult> sendGameRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return this.zzacy.sendGameRequest(playerId, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendGameRequest(JSONObject extraMessageData) throws IllegalStateException {
        return sendGameRequest(getLastUsedPlayerId(), extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerAvailableRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, 3, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerAvailableRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), 3, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerIdleRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, 5, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerIdleRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), 5, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerPlayingRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, 6, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerPlayingRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), 6, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerQuitRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, 2, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerQuitRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), 2, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerReadyRequest(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        return zza(playerId, 4, extraMessageData);
    }

    public PendingResult<GameManagerResult> sendPlayerReadyRequest(JSONObject extraMessageData) throws IllegalStateException {
        return zza(getLastUsedPlayerId(), 4, extraMessageData);
    }

    public void setListener(Listener listener) {
        this.zzacy.setListener(listener);
    }

    public void setSessionLabel(String sessionLabel) {
        this.zzacy.setSessionLabel(sessionLabel);
    }
}
