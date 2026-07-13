package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StringListResponse implements SafeParcelable {
    public static final Parcelable.Creator<StringListResponse> CREATOR = new zzbw();
    private final int mVersionCode;
    private final List<String> zzasD;

    StringListResponse(int versionCode, List<String> strings) {
        this.mVersionCode = versionCode;
        this.zzasD = strings;
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
        zzbw.zza(this, dest, flags);
    }

    public List<String> zztx() {
        return this.zzasD;
    }
}
