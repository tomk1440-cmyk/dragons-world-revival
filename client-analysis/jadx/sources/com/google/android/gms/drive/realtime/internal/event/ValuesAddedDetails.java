package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ValuesAddedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new zzi();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;
    final String zzavo;
    final int zzavp;

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzauP = valueIndex;
        this.zzauQ = valueCount;
        this.zzavo = movedFromId;
        this.zzavp = movedFromIndex;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
