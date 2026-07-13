package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.internal.TransferProgressData;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class TransferStateEvent implements DriveEvent {
    public static final Parcelable.Creator<TransferStateEvent> CREATOR = new zzp();
    final int mVersionCode;
    final String zzVa;
    final List<TransferProgressData> zzapU;

    TransferStateEvent(int versionCode, String accountName, List<TransferProgressData> transferProgressData) {
        this.mVersionCode = versionCode;
        this.zzVa = accountName;
        this.zzapU = transferProgressData;
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
        TransferStateEvent transferStateEvent = (TransferStateEvent) o;
        return zzw.equal(this.zzVa, transferStateEvent.zzVa) && zzw.equal(this.zzapU, transferStateEvent.zzapU);
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 7;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzVa, this.zzapU);
    }

    public String toString() {
        return String.format("TransferStateEvent[%s]", TextUtils.join("','", this.zzapU));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }
}
