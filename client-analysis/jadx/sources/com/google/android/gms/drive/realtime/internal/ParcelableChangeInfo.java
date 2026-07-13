package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableChangeInfo implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableChangeInfo> CREATOR = new zzp();
    final int mVersionCode;
    final long zzaez;
    final List<ParcelableEvent> zzpH;

    ParcelableChangeInfo(int versionCode, long timestamp, List<ParcelableEvent> events) {
        this.mVersionCode = versionCode;
        this.zzaez = timestamp;
        this.zzpH = events;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }
}
