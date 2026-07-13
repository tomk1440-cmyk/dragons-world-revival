package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ChangeResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ChangeResourceParentsRequest> CREATOR = new zzf();
    final int mVersionCode;
    final DriveId zzaqf;
    final List<DriveId> zzaqg;
    final List<DriveId> zzaqh;

    ChangeResourceParentsRequest(int versionCode, DriveId targetId, List<DriveId> parentIdsToAdd, List<DriveId> parentIdsToRemove) {
        this.mVersionCode = versionCode;
        this.zzaqf = targetId;
        this.zzaqg = parentIdsToAdd;
        this.zzaqh = parentIdsToRemove;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
