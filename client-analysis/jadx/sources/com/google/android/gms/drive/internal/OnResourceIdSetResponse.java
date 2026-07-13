package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnResourceIdSetResponse> CREATOR = new zzbh();
    private final int mVersionCode;
    private final List<String> zzaqi;

    OnResourceIdSetResponse(int versionCode, List<String> resourceIds) {
        this.mVersionCode = versionCode;
        this.zzaqi = resourceIds;
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
        zzbh.zza(this, dest, flags);
    }

    public List<String> zztc() {
        return this.zzaqi;
    }
}
