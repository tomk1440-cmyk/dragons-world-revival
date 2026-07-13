package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class UriData implements SafeParcelable {
    public static final Parcelable.Creator<UriData> CREATOR = new zzh();
    String description;
    private final int mVersionCode;
    String zzbdg;

    UriData() {
        this.mVersionCode = 1;
    }

    UriData(int versionCode, String uri, String description) {
        this.mVersionCode = versionCode;
        this.zzbdg = uri;
        this.description = description;
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
        zzh.zza(this, dest, flags);
    }
}
