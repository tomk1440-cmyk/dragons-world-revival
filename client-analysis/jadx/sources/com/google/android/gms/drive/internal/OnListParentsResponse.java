package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

/* JADX INFO: loaded from: classes.dex */
public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Parcelable.Creator<OnListParentsResponse> CREATOR = new zzbd();
    final int mVersionCode;
    final DataHolder zzast;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.mVersionCode = versionCode;
        this.zzast = parents;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.drive.WriteAwareParcelable
    protected void zzJ(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }

    public DataHolder zztv() {
        return this.zzast;
    }
}
