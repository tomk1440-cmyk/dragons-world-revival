package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class ValuesSetDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new zzk();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzauP = valueIndex;
        this.zzauQ = valueCount;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
