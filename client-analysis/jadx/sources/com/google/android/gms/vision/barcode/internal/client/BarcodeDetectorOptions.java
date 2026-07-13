package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class BarcodeDetectorOptions implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int versionCode;
    public int zzbnw;

    public BarcodeDetectorOptions() {
        this.versionCode = 1;
    }

    public BarcodeDetectorOptions(int versionCode, int barcodeFormats) {
        this.versionCode = versionCode;
        this.zzbnw = barcodeFormats;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zza zzaVar = CREATOR;
        zza.zza(this, parcel, flags);
    }
}
