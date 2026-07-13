package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableIndexReference implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new zzr();
    final int mIndex;
    final int mVersionCode;
    final String zzauL;
    final boolean zzauM;
    final int zzauN;

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean legacyCanBeDeleted, int deleteMode) {
        this.mVersionCode = versionCode;
        this.zzauL = objectId;
        this.mIndex = index;
        this.zzauM = legacyCanBeDeleted;
        this.zzauN = deleteMode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }
}
