package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class DriveFileRange implements SafeParcelable {
    public static final Parcelable.Creator<DriveFileRange> CREATOR = new zzc();
    final int mVersionCode;
    final long zzaoJ;
    final long zzaoK;

    DriveFileRange(int versionCode, long fromByte, long toByte) {
        this.mVersionCode = versionCode;
        this.zzaoJ = fromByte;
        this.zzaoK = toByte;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
