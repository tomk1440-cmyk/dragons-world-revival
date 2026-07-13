package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ParentDriveIdSet implements SafeParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzl();
    final int mVersionCode;
    final List<PartialDriveId> zzasS;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int versionCode, List<PartialDriveId> partialDriveIds) {
        this.mVersionCode = versionCode;
        this.zzasS = partialDriveIds;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzl.zza(this, out, flags);
    }

    public Set<DriveId> zzD(long j) {
        HashSet hashSet = new HashSet();
        Iterator<PartialDriveId> it = this.zzasS.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().zzE(j));
        }
        return hashSet;
    }

    public void zza(PartialDriveId partialDriveId) {
        this.zzasS.add(partialDriveId);
    }
}
