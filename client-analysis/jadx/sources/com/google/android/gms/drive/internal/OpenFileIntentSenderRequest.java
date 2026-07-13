package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

/* JADX INFO: loaded from: classes.dex */
public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Parcelable.Creator<OpenFileIntentSenderRequest> CREATOR = new zzbm();
    final int mVersionCode;
    final String zzapg;
    final String[] zzaph;
    final DriveId zzapj;
    final FilterHolder zzasz;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this.mVersionCode = versionCode;
        this.zzapg = title;
        this.zzaph = mimeTypes;
        this.zzapj = startFolder;
        this.zzasz = filterHolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this(1, title, mimeTypes, startFolder, filterHolder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbm.zza(this, dest, flags);
    }
}
