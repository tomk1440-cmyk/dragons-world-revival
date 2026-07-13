package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.internal.TransferProgressData;

/* JADX INFO: loaded from: classes.dex */
public final class TransferProgressEvent implements DriveEvent {
    public static final Parcelable.Creator<TransferProgressEvent> CREATOR = new zzn();
    final int mVersionCode;
    final TransferProgressData zzapS;

    TransferProgressEvent(int versionCode, TransferProgressData transferProgressData) {
        this.mVersionCode = versionCode;
        this.zzapS = transferProgressData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        return zzw.equal(this.zzapS, ((TransferProgressEvent) o).zzapS);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 8;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapS);
    }

    public String toString() {
        return String.format("TransferProgressEvent[%s]", this.zzapS.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }

    public TransferProgressData zzta() {
        return this.zzapS;
    }
}
