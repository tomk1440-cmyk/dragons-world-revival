package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class TextModuleData implements SafeParcelable {
    public static final Parcelable.Creator<TextModuleData> CREATOR = new zzf();
    String body;
    private final int mVersionCode;
    String zzbqO;

    TextModuleData() {
        this.mVersionCode = 1;
    }

    TextModuleData(int versionCode, String header, String body) {
        this.mVersionCode = versionCode;
        this.zzbqO = header;
        this.body = body;
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
        zzf.zza(this, dest, flags);
    }
}
