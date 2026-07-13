package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnFetchThumbnailResponse> CREATOR = new zzbb();
    final int mVersionCode;
    final ParcelFileDescriptor zzasr;

    OnFetchThumbnailResponse(int versionCode, ParcelFileDescriptor thumbnailPfd) {
        this.mVersionCode = versionCode;
        this.zzasr = thumbnailPfd;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbb.zza(this, dest, flags | 1);
    }
}
