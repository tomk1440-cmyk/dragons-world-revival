package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class CloseChannelResponse implements SafeParcelable {
    public static final Parcelable.Creator<CloseChannelResponse> CREATOR = new zzv();
    public final int statusCode;
    public final int versionCode;

    CloseChannelResponse(int versionCode, int statusCode) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzv.zza(this, dest, flags);
    }
}
