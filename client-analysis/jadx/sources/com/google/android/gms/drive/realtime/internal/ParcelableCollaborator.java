package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableCollaborator implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzq();
    final int mVersionCode;
    final String zzLq;
    final String zzWQ;
    final boolean zzaeW;
    final boolean zzauI;
    final String zzauJ;
    final String zzauK;
    final String zzrG;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.mVersionCode = versionCode;
        this.zzauI = isMe;
        this.zzaeW = isAnonymous;
        this.zzLq = sessionId;
        this.zzrG = userId;
        this.zzWQ = displayName;
        this.zzauJ = color;
        this.zzauK = photoUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParcelableCollaborator) {
            return this.zzLq.equals(((ParcelableCollaborator) obj).zzLq);
        }
        return false;
    }

    public int hashCode() {
        return this.zzLq.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzauI + ", isAnonymous=" + this.zzaeW + ", sessionId=" + this.zzLq + ", userId=" + this.zzrG + ", displayName=" + this.zzWQ + ", color=" + this.zzauJ + ", photoUrl=" + this.zzauK + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
