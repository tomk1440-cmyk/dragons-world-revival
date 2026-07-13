package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class LabelValue implements SafeParcelable {
    public static final Parcelable.Creator<LabelValue> CREATOR = new zzb();
    String label;
    private final int mVersionCode;
    String value;

    LabelValue() {
        this.mVersionCode = 1;
    }

    LabelValue(int versionCode, String label, String value) {
        this.mVersionCode = versionCode;
        this.label = label;
        this.value = value;
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
        zzb.zza(this, dest, flags);
    }
}
