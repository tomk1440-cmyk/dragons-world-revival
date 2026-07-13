package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

/* JADX INFO: loaded from: classes.dex */
public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzba();
    private final String mPath;
    final int mVersionCode;
    private final byte[] zzaKm;
    private final String zzaPI;
    private final int zzaox;

    MessageEventParcelable(int versionCode, int requestId, String path, byte[] data, String source) {
        this.mVersionCode = versionCode;
        this.zzaox = requestId;
        this.mPath = path;
        this.zzaKm = data;
        this.zzaPI = source;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public byte[] getData() {
        return this.zzaKm;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public String getPath() {
        return this.mPath;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public int getRequestId() {
        return this.zzaox;
    }

    @Override // com.google.android.gms.wearable.MessageEvent
    public String getSourceNodeId() {
        return this.zzaPI;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzaox + "," + this.mPath + ", size=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags);
    }
}
