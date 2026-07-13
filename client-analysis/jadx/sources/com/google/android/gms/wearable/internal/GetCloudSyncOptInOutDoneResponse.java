package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class GetCloudSyncOptInOutDoneResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new zzal();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbsD;

    GetCloudSyncOptInOutDoneResponse(int versionCode, int statusCode, boolean optInOutDone) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsD = optInOutDone;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzal.zza(this, dest, flags);
    }
}
