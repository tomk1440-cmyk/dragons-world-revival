package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class TransferStateOptions implements SafeParcelable {
    public static final Parcelable.Creator<TransferStateOptions> CREATOR = new zzr();
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;

    TransferStateOptions(int versionCode, List<DriveSpace> spacesList) {
        this(versionCode, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private TransferStateOptions(int versionCode, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzapB = spacesList;
        this.zzapC = spaces;
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
        return zzw.equal(this.zzapC, ((TransferStateOptions) o).zzapC);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapC);
    }

    public String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", this.zzapB);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }
}
