package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class SyncInfoResult implements Result, SafeParcelable {
    public static final Parcelable.Creator<SyncInfoResult> CREATOR = new zzl();
    private final int mVersionCode;
    private final Status zzUX;
    private final long zzaez;

    SyncInfoResult(int versionCode, Status status, long timestamp) {
        this.mVersionCode = versionCode;
        this.zzUX = status;
        this.zzaez = timestamp;
    }

    private boolean zzb(SyncInfoResult syncInfoResult) {
        return this.zzUX.equals(syncInfoResult.zzUX) && zzw.equal(Long.valueOf(this.zzaez), Long.valueOf(syncInfoResult.zzaez));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SyncInfoResult) && zzb((SyncInfoResult) that));
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzUX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzUX, Long.valueOf(this.zzaez));
    }

    public String toString() {
        return zzw.zzy(this).zzg("status", this.zzUX).zzg("timestamp", Long.valueOf(this.zzaez)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    public long zzvq() {
        return this.zzaez;
    }
}
