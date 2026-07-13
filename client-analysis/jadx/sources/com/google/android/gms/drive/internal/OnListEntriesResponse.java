package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListEntriesResponse> CREATOR = new zzbc();
    final int mVersionCode;
    final boolean zzaqJ;
    final DataHolder zzass;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.mVersionCode = versionCode;
        this.zzass = entries;
        this.zzaqJ = moreEntriesMayExist;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzJ(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }

    public DataHolder zztt() {
        return this.zzass;
    }

    public boolean zztu() {
        return this.zzaqJ;
    }
}
