package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CancelPendingActionsRequest> CREATOR = new zze();
    final int mVersionCode;
    final List<String> zzapG;

    CancelPendingActionsRequest(int versionCode, List<String> trackingTags) {
        this.mVersionCode = versionCode;
        this.zzapG = trackingTags;
    }

    public CancelPendingActionsRequest(List<String> trackingTags) {
        this(1, trackingTags);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
