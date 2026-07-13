package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Parcelable.Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
    private final int mVersionCode;
    private final int zzBc;
    private final String zzEY;
    private final GameEntity zzaJE;
    private final long zzaJF;
    private final PlayerEntity zzaKG;
    private final ArrayList<PlayerEntity> zzaKH;
    private final long zzaKI;
    private final Bundle zzaKJ;
    private final byte[] zzaKm;
    private final int zzabB;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.mVersionCode = versionCode;
        this.zzaJE = game;
        this.zzaKG = sender;
        this.zzaKm = data;
        this.zzEY = requestId;
        this.zzaKH = recipients;
        this.zzabB = type;
        this.zzaJF = creationTimestamp;
        this.zzaKI = expirationTimestamp;
        this.zzaKJ = recipientStatuses;
        this.zzBc = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.mVersionCode = 2;
        this.zzaJE = new GameEntity(request.getGame());
        this.zzaKG = new PlayerEntity(request.getSender());
        this.zzEY = request.getRequestId();
        this.zzabB = request.getType();
        this.zzaJF = request.getCreationTimestamp();
        this.zzaKI = request.getExpirationTimestamp();
        this.zzBc = request.getStatus();
        byte[] data = request.getData();
        if (data == null) {
            this.zzaKm = null;
        } else {
            this.zzaKm = new byte[data.length];
            System.arraycopy(data, 0, this.zzaKm, 0, data.length);
        }
        List<Player> recipients = request.getRecipients();
        int size = recipients.size();
        this.zzaKH = new ArrayList<>(size);
        this.zzaKJ = new Bundle();
        for (int i = 0; i < size; i++) {
            Player playerFreeze = recipients.get(i).freeze();
            String playerId = playerFreeze.getPlayerId();
            this.zzaKH.add((PlayerEntity) playerFreeze);
            this.zzaKJ.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List<Player> recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(recipients.get(i).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzy(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public GameRequest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getCreationTimestamp() {
        return this.zzaJF;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public byte[] getData() {
        return this.zzaKm;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getExpirationTimestamp() {
        return this.zzaKI;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Game getGame() {
        return this.zzaJE;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getRecipientStatus(String playerId) {
        return this.zzaKJ.getInt(playerId, 0);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public List<Player> getRecipients() {
        return new ArrayList(this.zzaKH);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public String getRequestId() {
        return this.zzEY;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Player getSender() {
        return this.zzaKG;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getStatus() {
        return this.zzBc;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getType() {
        return this.zzabB;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.zza(this, dest, flags);
    }

    public Bundle zzxT() {
        return this.zzaKJ;
    }
}
