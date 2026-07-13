package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class TrashResourceRequest implements SafeParcelable {
    public static final Parcelable.Creator<TrashResourceRequest> CREATOR = new zzbx();
    final int mVersionCode;
    final DriveId zzaqj;

    TrashResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
    }

    public TrashResourceRequest(DriveId id) {
        this(1, id);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbx.zza(this, dest, flags);
    }
}
