package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnSyncMoreResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnSyncMoreResponse> CREATOR = new zzbj();
    final int mVersionCode;
    final boolean zzaqJ;

    OnSyncMoreResponse(int versionCode, boolean moreEntriesMayExist) {
        this.mVersionCode = versionCode;
        this.zzaqJ = moreEntriesMayExist;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbj.zza(this, dest, flags);
    }
}
