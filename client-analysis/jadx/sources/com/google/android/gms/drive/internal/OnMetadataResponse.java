package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public class OnMetadataResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnMetadataResponse> CREATOR = new zzbe();
    final int mVersionCode;
    final MetadataBundle zzaqw;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.mVersionCode = versionCode;
        this.zzaqw = metadata;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbe.zza(this, dest, flags);
    }

    public MetadataBundle zztw() {
        return this.zzaqw;
    }
}
