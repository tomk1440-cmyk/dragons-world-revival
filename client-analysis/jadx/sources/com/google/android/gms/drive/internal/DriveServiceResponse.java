package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class DriveServiceResponse implements SafeParcelable {
    public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzad();
    final int mVersionCode;
    final IBinder zzarB;

    DriveServiceResponse(int versionCode, IBinder cancelToken) {
        this.mVersionCode = versionCode;
        this.zzarB = cancelToken;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzad.zza(this, dest, flags);
    }

    public com.google.android.gms.common.internal.zzq zztj() {
        return com.google.android.gms.common.internal.zzq.zza.zzaQ(this.zzarB);
    }
}
