package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

/* JADX INFO: loaded from: classes.dex */
public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzl CREATOR = new zzl();
    final int mVersionCode;
    final DataHolder zzahi;
    final boolean zzapQ;
    final int zzapR;

    QueryResultEventParcelable(int versionCode, DataHolder dataHolder, boolean isStatusChanged, int queryStatus) {
        this.mVersionCode = versionCode;
        this.zzahi = dataHolder;
        this.zzapQ = isStatusChanged;
        this.zzapR = queryStatus;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.events.DriveEvent
    public int getType() {
        return 3;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    public void zzJ(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public DataHolder zzsX() {
        return this.zzahi;
    }

    public boolean zzsY() {
        return this.zzapQ;
    }

    public int zzsZ() {
        return this.zzapR;
    }
}
