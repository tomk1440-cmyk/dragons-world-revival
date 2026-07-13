package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TransferProgressOptions implements SafeParcelable {
    public static final Parcelable.Creator<TransferProgressOptions> CREATOR = new zzo();
    final int mVersionCode;
    final int zzapT;

    TransferProgressOptions(int versionCode, int transferType) {
        this.mVersionCode = versionCode;
        this.zzapT = transferType;
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
        return zzw.equal(Integer.valueOf(this.zzapT), Integer.valueOf(((TransferProgressOptions) o).zzapT));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzapT));
    }

    public String toString() {
        return String.format(Locale.US, "TransferProgressOptions[type=%d]", Integer.valueOf(this.zzapT));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }
}
