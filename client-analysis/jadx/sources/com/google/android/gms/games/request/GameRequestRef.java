package com.google.android.gms.games.request;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GameRequestRef extends zzc implements GameRequest {
    private final int zzaDQ;

    public GameRequestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzaDQ = numChildren;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return GameRequestEntity.zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public byte[] getData() {
        return getByteArray(ShareConstants.WEB_DIALOG_PARAM_DATA);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Game getGame() {
        return new GameRef(this.zzahi, this.zzaje);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getRecipientStatus(String playerId) {
        for (int i = this.zzaje; i < this.zzaje + this.zzaDQ; i++) {
            int iZzbH = this.zzahi.zzbH(i);
            if (this.zzahi.zzd("recipient_external_player_id", i, iZzbH).equals(playerId)) {
                return this.zzahi.zzc("recipient_status", i, iZzbH);
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public List<Player> getRecipients() {
        ArrayList arrayList = new ArrayList(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new PlayerRef(this.zzahi, this.zzaje + i, "recipient_"));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public String getRequestId() {
        return getString("external_request_id");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public Player getSender() {
        return new PlayerRef(this.zzahi, zzqc(), "sender_");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getStatus() {
        return getInteger("status");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public int getType() {
        return getInteger(ShareConstants.MEDIA_TYPE);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return GameRequestEntity.zza(this);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public String toString() {
        return GameRequestEntity.zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
