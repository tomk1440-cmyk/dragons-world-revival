package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

/* JADX INFO: loaded from: classes.dex */
public class CloseContentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsRequest> CREATOR = new zzi();
    final int mVersionCode;
    final Contents zzaql;
    final int zzaqn;
    final Boolean zzaqp;

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults, int contentsRequestId) {
        this.mVersionCode = versionCode;
        this.zzaql = contentsReference;
        this.zzaqp = saveResults;
        this.zzaqn = contentsRequestId;
    }

    public CloseContentsRequest(int contentsRequestId, boolean saveResults) {
        this(1, null, Boolean.valueOf(saveResults), contentsRequestId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
