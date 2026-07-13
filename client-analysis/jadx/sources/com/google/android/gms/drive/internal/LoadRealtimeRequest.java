package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoadRealtimeRequest implements SafeParcelable {
    public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzar();
    final int mVersionCode;
    final DriveId zzaoz;
    final boolean zzarQ;
    final List<String> zzarR;
    final boolean zzarS;
    final DataHolder zzarT;
    final String zzarU;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode, List<String> customTypeWhitelist, boolean isInMemory, DataHolder json, String localId) {
        this.mVersionCode = versionCode;
        this.zzaoz = driveId;
        this.zzarQ = useTestMode;
        this.zzarR = customTypeWhitelist;
        this.zzarS = isInMemory;
        this.zzarT = json;
        this.zzarU = localId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags);
    }
}
