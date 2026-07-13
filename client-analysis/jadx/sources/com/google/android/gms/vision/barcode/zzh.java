package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzh implements Parcelable.Creator<Barcode.GeoPoint> {
    static void zza(Barcode.GeoPoint geoPoint, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, geoPoint.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, geoPoint.lat);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, geoPoint.lng);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhd, reason: merged with bridge method [inline-methods] */
    public Barcode.GeoPoint createFromParcel(Parcel parcel) {
        double dZzn = 0.0d;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        double dZzn2 = 0.0d;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    dZzn2 = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    break;
                case 3:
                    dZzn = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Barcode.GeoPoint(iZzg, dZzn2, dZzn);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkA, reason: merged with bridge method [inline-methods] */
    public Barcode.GeoPoint[] newArray(int i) {
        return new Barcode.GeoPoint[i];
    }
}
