package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class StringParcel implements SafeParcelable {
    public static final Parcelable.Creator<StringParcel> CREATOR = new zzn();
    final int mVersionCode;
    String zzxG;

    StringParcel(int versionCode, String content) {
        this.mVersionCode = versionCode;
        this.zzxG = content;
    }

    public StringParcel(String content) {
        this.mVersionCode = 1;
        this.zzxG = content;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }

    public String zzgz() {
        return this.zzxG;
    }
}
