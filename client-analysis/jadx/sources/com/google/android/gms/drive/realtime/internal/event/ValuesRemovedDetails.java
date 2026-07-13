package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ValuesRemovedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new zzj();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;
    final String zzavq;
    final int zzavr;

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzauP = valueIndex;
        this.zzauQ = valueCount;
        this.zzavq = movedToId;
        this.zzavr = movedToIndex;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
