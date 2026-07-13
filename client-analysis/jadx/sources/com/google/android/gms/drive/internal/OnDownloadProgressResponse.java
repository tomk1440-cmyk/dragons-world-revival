package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OnDownloadProgressResponse implements SafeParcelable {
    final int mVersionCode;
    final int zzBc;
    final long zzasi;
    final long zzasj;
    final List<DriveFileRange> zzask;
    private static final List<DriveFileRange> zzash = Collections.emptyList();
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzay();

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected, int status, List<DriveFileRange> rangesAvailable) {
        this.mVersionCode = versionCode;
        this.zzasi = bytesLoaded;
        this.zzasj = bytesExpected;
        this.zzBc = status;
        this.zzask = rangesAvailable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }

    public long zztq() {
        return this.zzasi;
    }

    public long zztr() {
        return this.zzasj;
    }
}
