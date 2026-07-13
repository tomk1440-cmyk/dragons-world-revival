package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int mVersionCode;
    private final ArrayList<GameRequestEntity> zzaIW;

    GameRequestCluster(int versionCode, ArrayList<GameRequestEntity> requestList) {
        this.mVersionCode = versionCode;
        this.zzaIW = requestList;
        zzxr();
    }

    private void zzxr() {
        zzb.zzab(!this.zzaIW.isEmpty());
        GameRequestEntity gameRequestEntity = this.zzaIW.get(0);
        int size = this.zzaIW.size();
        for (int i = 1; i < size; i++) {
            GameRequestEntity gameRequestEntity2 = this.zzaIW.get(i);
            zzb.zza(gameRequestEntity.getType() == gameRequestEntity2.getType(), "All the requests must be of the same type");
            zzb.zza(gameRequestEntity.getSender().equals(gameRequestEntity2.getSender()), "All the requests must be from the same sender");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.zzaIW.size() != this.zzaIW.size()) {
            return false;
        }
        int size = this.zzaIW.size();
        for (int i = 0; i < size; i++) {
            if (!this.zzaIW.get(i).equals(gameRequestCluster.zzaIW.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public GameRequest freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public String getRequestId() {
        return this.zzaIW.get(0).getRequestId();
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Player getSender() {
        return this.zzaIW.get(0).getSender();
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getType() {
        return this.zzaIW.get(0).getType();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaIW.toArray());
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public boolean isConsumed(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        GameRequestClusterCreator.zza(this, dest, flags);
    }

    public ArrayList<GameRequest> zzxF() {
        return new ArrayList<>(this.zzaIW);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    /* JADX INFO: renamed from: zzxG, reason: merged with bridge method [inline-methods] */
    public ArrayList<Player> getRecipients() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
}
