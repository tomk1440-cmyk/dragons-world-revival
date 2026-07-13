package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zze implements Parcelable.Creator<Barcode.ContactInfo> {
    static void zza(Barcode.ContactInfo contactInfo, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, contactInfo.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) contactInfo.name, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, contactInfo.organization, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, contactInfo.title, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable[]) contactInfo.phones, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable[]) contactInfo.emails, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, contactInfo.urls, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable[]) contactInfo.addresses, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzha, reason: merged with bridge method [inline-methods] */
    public Barcode.ContactInfo createFromParcel(Parcel parcel) {
        Barcode.Address[] addressArr = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String[] strArrZzB = null;
        Barcode.Email[] emailArr = null;
        Barcode.Phone[] phoneArr = null;
        String strZzp = null;
        String strZzp2 = null;
        Barcode.PersonName personName = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    personName = (Barcode.PersonName) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Barcode.PersonName.CREATOR);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    phoneArr = (Barcode.Phone[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, Barcode.Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Barcode.Email[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, Barcode.Email.CREATOR);
                    break;
                case 7:
                    strArrZzB = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, iZzat);
                    break;
                case 8:
                    addressArr = (Barcode.Address[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, Barcode.Address.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Barcode.ContactInfo(iZzg, personName, strZzp2, strZzp, phoneArr, emailArr, strArrZzB, addressArr);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkx, reason: merged with bridge method [inline-methods] */
    public Barcode.ContactInfo[] newArray(int i) {
        return new Barcode.ContactInfo[i];
    }
}
