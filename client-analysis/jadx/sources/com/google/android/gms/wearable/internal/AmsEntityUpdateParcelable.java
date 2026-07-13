package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class AmsEntityUpdateParcelable implements SafeParcelable, com.google.android.gms.wearable.zzb {
    public static final Parcelable.Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
    private final String mValue;
    final int mVersionCode;
    private byte zzbrF;
    private final byte zzbrG;

    AmsEntityUpdateParcelable(int versionCode, byte entityId, byte attributeId, String value) {
        this.zzbrF = entityId;
        this.mVersionCode = versionCode;
        this.zzbrG = attributeId;
        this.mValue = value;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AmsEntityUpdateParcelable amsEntityUpdateParcelable = (AmsEntityUpdateParcelable) o;
        return this.zzbrF == amsEntityUpdateParcelable.zzbrF && this.mVersionCode == amsEntityUpdateParcelable.mVersionCode && this.zzbrG == amsEntityUpdateParcelable.zzbrG && this.mValue.equals(amsEntityUpdateParcelable.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return (((((this.mVersionCode * 31) + this.zzbrF) * 31) + this.zzbrG) * 31) + this.mValue.hashCode();
    }

    public String toString() {
        return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + ((int) this.zzbrF) + ", mAttributeId=" + ((int) this.zzbrG) + ", mValue='" + this.mValue + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public byte zzIA() {
        return this.zzbrG;
    }

    public byte zzIz() {
        return this.zzbrF;
    }
}
