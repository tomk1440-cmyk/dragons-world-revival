package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzlm implements GameManagerState {
    private final String zzada;
    private final int zzadb;
    private final int zzadg;
    private final int zzadh;
    private final JSONObject zzadj;
    private final String zzadk;
    private final Map<String, PlayerInfo> zzadm;

    public zzlm(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzadh = i;
        this.zzadg = i2;
        this.zzadk = str;
        this.zzadj = jSONObject;
        this.zzada = str2;
        this.zzadb = i3;
        this.zzadm = new HashMap(collection.size());
        for (PlayerInfo playerInfo : collection) {
            this.zzadm.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public boolean equals(Object otherObj) {
        boolean z;
        if (otherObj == null || !(otherObj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) otherObj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z2 = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                if (!com.google.android.gms.cast.internal.zzf.zza(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    z = z2;
                } else {
                    if (!com.google.android.gms.cast.internal.zzf.zza(playerInfo, playerInfo2)) {
                        return false;
                    }
                    z = true;
                }
                z2 = z;
            }
            if (!z2) {
                return false;
            }
        }
        return this.zzadh == gameManagerState.getLobbyState() && this.zzadg == gameManagerState.getGameplayState() && this.zzadb == gameManagerState.getMaxPlayers() && com.google.android.gms.cast.internal.zzf.zza(this.zzada, gameManagerState.getApplicationName()) && com.google.android.gms.cast.internal.zzf.zza(this.zzadk, gameManagerState.getGameStatusText()) && zznb.zze(this.zzadj, gameManagerState.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public CharSequence getApplicationName() {
        return this.zzada;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getConnectedControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getConnectedPlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getControllablePlayers() {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public JSONObject getGameData() {
        return this.zzadj;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public CharSequence getGameStatusText() {
        return this.zzadk;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getGameplayState() {
        return this.zzadg;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public Collection<String> getListOfChangedPlayers(GameManagerState other) {
        HashSet hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = other.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : other.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getLobbyState() {
        return this.zzadh;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public int getMaxPlayers() {
        return this.zzadb;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public PlayerInfo getPlayer(String playerId) {
        if (playerId == null) {
            return null;
        }
        return this.zzadm.get(playerId);
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzadm.values());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public List<PlayerInfo> getPlayersInState(int playerState) {
        ArrayList arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == playerState) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasGameDataChanged(GameManagerState other) {
        return !zznb.zze(this.zzadj, other.getGameData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasGameStatusTextChanged(GameManagerState other) {
        return !com.google.android.gms.cast.internal.zzf.zza(this.zzadk, other.getGameStatusText());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasGameplayStateChanged(GameManagerState other) {
        return this.zzadg != other.getGameplayState();
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasLobbyStateChanged(GameManagerState other) {
        return this.zzadh != other.getLobbyState();
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasPlayerChanged(String playerId, GameManagerState other) {
        return !com.google.android.gms.cast.internal.zzf.zza(getPlayer(playerId), other.getPlayer(playerId));
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasPlayerDataChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || !zznb.zze(player.getPlayerData(), player2.getPlayerData());
    }

    @Override // com.google.android.gms.cast.games.GameManagerState
    public boolean hasPlayerStateChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        if (player == null && player2 == null) {
            return false;
        }
        return player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.zzadh), Integer.valueOf(this.zzadg), this.zzadm, this.zzadk, this.zzadj, this.zzada, Integer.valueOf(this.zzadb));
    }
}
