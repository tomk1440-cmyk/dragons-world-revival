package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel originalAdSize) {
        super(originalAdSize.versionCode, originalAdSize.zzuh, originalAdSize.height, originalAdSize.heightPixels, originalAdSize.zzui, originalAdSize.width, originalAdSize.widthPixels, originalAdSize.zzuj, originalAdSize.zzuk, originalAdSize.zzul, originalAdSize.zzum);
    }

    @Override // com.google.android.gms.ads.internal.client.AdSizeParcel, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, this.zzuh, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, this.height);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, this.width);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }
}
