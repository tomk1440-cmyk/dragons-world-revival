package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableEventList implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEventList> CREATOR = new zzd();
    final int mVersionCode;
    final DataHolder zzavf;
    final boolean zzavg;
    final List<String> zzavh;
    final ParcelableChangeInfo zzavi;
    final List<ParcelableEvent> zzpH;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds, ParcelableChangeInfo previousChangeInfo) {
        this.mVersionCode = versionCode;
        this.zzpH = events;
        this.zzavf = eventData;
        this.zzavg = undoRedoStateChanged;
        this.zzavh = affectedObjectIds;
        this.zzavi = previousChangeInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
