package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class PackageStorageInfo implements SafeParcelable {
    public static final Parcelable.Creator<PackageStorageInfo> CREATOR = new zzbe();
    public final String label;
    public final String packageName;
    public final int versionCode;
    public final long zzbta;

    PackageStorageInfo(int versionCode, String packageName, String label, long totalSizeBytes) {
        this.versionCode = versionCode;
        this.packageName = packageName;
        this.label = label;
        this.zzbta = totalSizeBytes;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzbe.zza(this, out, flags);
    }
}
