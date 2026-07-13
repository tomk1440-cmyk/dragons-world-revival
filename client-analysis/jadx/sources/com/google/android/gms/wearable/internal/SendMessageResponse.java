package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class SendMessageResponse implements SafeParcelable {
    public static final Parcelable.Creator<SendMessageResponse> CREATOR = new zzbi();
    public final int statusCode;
    public final int versionCode;
    public final int zzaNj;

    SendMessageResponse(int versionCode, int statusCode, int requestId) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzaNj = requestId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbi.zza(this, dest, flags);
    }
}
