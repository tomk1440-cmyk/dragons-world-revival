package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class UnsubscribeResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeResourceRequest> CREATOR = new zzby();
    final int mVersionCode;
    final DriveId zzaqj;

    UnsubscribeResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzby.zza(this, dest, flags);
    }
}
