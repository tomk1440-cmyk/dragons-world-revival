package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<Address> {
    static void zza(Address address, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, address.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, address.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, address.zzaMD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, address.zzaME, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, address.zzaMF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, address.zzJU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, address.zzbof, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, address.zzbog, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, address.zzaMK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, address.phoneNumber, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, address.zzaMM);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, address.zzaMN, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzho, reason: merged with bridge method [inline-methods] */
    public Address createFromParcel(Parcel parcel) {
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
        boolean zZzc = false;
        String strZzp10 = null;
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
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 12:
                    strZzp10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Address(iZzg, strZzp, strZzp2, strZzp3, strZzp4, strZzp5, strZzp6, strZzp7, strZzp8, strZzp9, zZzc, strZzp10);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkM, reason: merged with bridge method [inline-methods] */
    public Address[] newArray(int i) {
        return new Address[i];
    }
}
