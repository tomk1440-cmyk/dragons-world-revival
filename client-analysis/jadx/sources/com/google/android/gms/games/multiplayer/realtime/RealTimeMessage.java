package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator<RealTimeMessage>() { // from class: com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzeu, reason: merged with bridge method [inline-methods] */
        public RealTimeMessage createFromParcel(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzgK, reason: merged with bridge method [inline-methods] */
        public RealTimeMessage[] newArray(int i) {
            return new RealTimeMessage[i];
        }
    };
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzaJR;
    private final byte[] zzaJS;
    private final int zzaJT;

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzaJR = (String) zzx.zzz(senderParticipantId);
        this.zzaJS = (byte[]) ((byte[]) zzx.zzz(messageData)).clone();
        this.zzaJT = isReliable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaJS;
    }

    public String getSenderParticipantId() {
        return this.zzaJR;
    }

    public boolean isReliable() {
        return this.zzaJT == 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzaJR);
        parcel.writeByteArray(this.zzaJS);
        parcel.writeInt(this.zzaJT);
    }
}
