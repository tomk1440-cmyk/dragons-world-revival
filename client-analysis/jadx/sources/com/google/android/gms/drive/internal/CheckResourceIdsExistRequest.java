package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Parcelable.Creator<CheckResourceIdsExistRequest> CREATOR = new zzg();
    private final int mVersionCode;
    private final List<String> zzaqi;

    CheckResourceIdsExistRequest(int versionCode, List<String> resourceIds) {
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
        zzg.zza(this, dest, flags);
    }

    public List<String> zztc() {
        return this.zzaqi;
    }
}
