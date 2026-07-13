package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.WriteAwareParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OnChangesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnChangesResponse> CREATOR = new zzav();
    final int mVersionCode;
    final DataHolder zzasb;
    final List<DriveId> zzasc;
    final ChangeSequenceNumber zzasd;
    final boolean zzase;

    OnChangesResponse(int versionCode, DataHolder newOrModifiedResourcesData, List<DriveId> deleted, ChangeSequenceNumber lastChangeSequenceNumber, boolean moreChangesExist) {
        this.mVersionCode = versionCode;
        this.zzasb = newOrModifiedResourcesData;
        this.zzasc = deleted;
        this.zzasd = lastChangeSequenceNumber;
        this.zzase = moreChangesExist;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzJ(Parcel parcel, int i) {
        zzav.zza(this, parcel, i | 1);
    }
}
