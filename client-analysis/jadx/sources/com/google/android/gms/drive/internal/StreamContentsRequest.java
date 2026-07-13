package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class StreamContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<StreamContentsRequest> CREATOR = new zzbv();
    final int mVersionCode;
    final DriveId zzaqj;

    StreamContentsRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbv.zza(this, dest, flags);
    }
}
