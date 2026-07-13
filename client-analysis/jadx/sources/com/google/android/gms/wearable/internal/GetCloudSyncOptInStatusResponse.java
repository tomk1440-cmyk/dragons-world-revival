package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Parcelable.Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzam();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbsE;
    public final boolean zzbsF;

    GetCloudSyncOptInStatusResponse(int versionCode, int statusCode, boolean isOptInOrOutDone, boolean isOptedIn) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbsE = isOptInOrOutDone;
        this.zzbsF = isOptedIn;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzam.zza(this, dest, flags);
    }
}
