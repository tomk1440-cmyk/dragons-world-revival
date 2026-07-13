package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class TimeInterval implements SafeParcelable {
    public static final Parcelable.Creator<TimeInterval> CREATOR = new zzg();
    private final int mVersionCode;
    long zzbqP;
    long zzbqQ;

    TimeInterval() {
        this.mVersionCode = 1;
    }

    TimeInterval(int versionCode, long startTimestamp, long endTimestamp) {
        this.mVersionCode = versionCode;
        this.zzbqP = startTimestamp;
        this.zzbqQ = endTimestamp;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
