package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();
    final int versionCode;
    public long zzbdn;
    public zzc zzbdo;

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int versionCode, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzbdn = activityId;
        this.zzbdo = zzc.zza.zzdH(callbackAsBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbdo.asBinder();
    }
}
