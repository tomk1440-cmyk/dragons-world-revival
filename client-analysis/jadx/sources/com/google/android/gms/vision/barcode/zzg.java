package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements Parcelable.Creator<Barcode.Email> {
    static void zza(Barcode.Email email, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, email.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, email.type);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, email.address, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, email.subject, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, email.body, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhc, reason: merged with bridge method [inline-methods] */
    public Barcode.Email createFromParcel(Parcel parcel) {
        int iZzg = 0;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp2 = null;
        String strZzp3 = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Barcode.Email(iZzg2, iZzg, strZzp3, strZzp2, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkz, reason: merged with bridge method [inline-methods] */
    public Barcode.Email[] newArray(int i) {
        return new Barcode.Email[i];
    }
}
