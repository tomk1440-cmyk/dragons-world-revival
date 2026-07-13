package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* JADX INFO: loaded from: classes.dex */
public class CustomProperty implements SafeParcelable {
    public static final Parcelable.Creator<CustomProperty> CREATOR = new zzc();
    final String mValue;
    final int mVersionCode;
    final CustomPropertyKey zzasN;

    CustomProperty(int versionCode, CustomPropertyKey key, String value) {
        this.mVersionCode = versionCode;
        zzx.zzb(key, "key");
        this.zzasN = key;
        this.mValue = value;
    }

    public CustomProperty(CustomPropertyKey key, String value) {
        this(1, key, value);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        CustomProperty customProperty = (CustomProperty) o;
        return zzw.equal(this.zzasN, customProperty.zzasN) && zzw.equal(this.mValue, customProperty.mValue);
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzasN, this.mValue);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public CustomPropertyKey zztB() {
        return this.zzasN;
    }
}
