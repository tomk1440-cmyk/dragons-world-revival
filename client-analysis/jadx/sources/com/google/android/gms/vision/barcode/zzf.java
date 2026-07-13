package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<Barcode.DriverLicense> {
    static void zza(Barcode.DriverLicense driverLicense, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, driverLicense.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, driverLicense.documentType, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, driverLicense.firstName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, driverLicense.middleName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, driverLicense.lastName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, driverLicense.gender, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, driverLicense.addressStreet, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, driverLicense.addressCity, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, driverLicense.addressState, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, driverLicense.addressZip, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, driverLicense.licenseNumber, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, driverLicense.issueDate, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, driverLicense.expiryDate, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, driverLicense.birthDate, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, driverLicense.issuingCountry, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhb, reason: merged with bridge method [inline-methods] */
    public Barcode.DriverLicense createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        String strZzp6 = null;
        String strZzp7 = null;
        String strZzp8 = null;
        String strZzp9 = null;
        String strZzp10 = null;
        String strZzp11 = null;
        String strZzp12 = null;
        String strZzp13 = null;
        String strZzp14 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    strZzp7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    strZzp8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 10:
                    strZzp9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 11:
                    strZzp10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 12:
                    strZzp11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 13:
                    strZzp12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 14:
                    strZzp13 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 15:
                    strZzp14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Barcode.DriverLicense(iZzg, strZzp, strZzp2, strZzp3, strZzp4, strZzp5, strZzp6, strZzp7, strZzp8, strZzp9, strZzp10, strZzp11, strZzp12, strZzp13, strZzp14);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzky, reason: merged with bridge method [inline-methods] */
    public Barcode.DriverLicense[] newArray(int i) {
        return new Barcode.DriverLicense[i];
    }
}
