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
public final class ChangesAvailableOptions implements SafeParcelable {
    public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzd();
    final int mVersionCode;
    final boolean zzapA;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final int zzapz;

    ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList) {
        this(versionCode, changesSizeLimit, repeats, spacesList, spacesList == null ? null : new HashSet(spacesList));
    }

    private ChangesAvailableOptions(int versionCode, int changesSizeLimit, boolean repeats, List<DriveSpace> spacesList, Set<DriveSpace> spaces) {
        this.mVersionCode = versionCode;
        this.zzapz = changesSizeLimit;
        this.zzapA = repeats;
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
        ChangesAvailableOptions changesAvailableOptions = (ChangesAvailableOptions) o;
        return zzw.equal(this.zzapC, changesAvailableOptions.zzapC) && this.zzapz == changesAvailableOptions.zzapz && this.zzapA == changesAvailableOptions.zzapA;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapC, Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA));
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", Integer.valueOf(this.zzapz), Boolean.valueOf(this.zzapA), this.zzapB);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
