package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public class PlusCommonExtras implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int mVersionCode;
    private String zzbeo;
    private String zzbep;

    public PlusCommonExtras() {
        this.mVersionCode = 1;
        this.zzbeo = "";
        this.zzbep = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.mVersionCode = versionCode;
        this.zzbeo = gpsrc;
        this.zzbep = clientCallingPackage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.mVersionCode == plusCommonExtras.mVersionCode && zzw.equal(this.zzbeo, plusCommonExtras.zzbeo) && zzw.equal(this.zzbep, plusCommonExtras.zzbep);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.zzbeo, this.zzbep);
    }

    public String toString() {
        return zzw.zzy(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("Gpsrc", this.zzbeo).zzg("ClientCallingPackage", this.zzbep).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public String zzFb() {
        return this.zzbeo;
    }

    public String zzFc() {
        return this.zzbep;
    }

    public void zzJ(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", com.google.android.gms.common.internal.safeparcel.zzc.zza(this));
    }
}
