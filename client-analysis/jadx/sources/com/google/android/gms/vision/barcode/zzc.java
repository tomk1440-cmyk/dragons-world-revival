package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<Barcode.CalendarDateTime> {
    static void zza(Barcode.CalendarDateTime calendarDateTime, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, calendarDateTime.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, calendarDateTime.year);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, calendarDateTime.month);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, calendarDateTime.day);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, calendarDateTime.hours);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, calendarDateTime.minutes);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, calendarDateTime.seconds);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, calendarDateTime.isUtc);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, calendarDateTime.rawValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgY, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarDateTime createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp = null;
        int iZzg = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        int iZzg4 = 0;
        int iZzg5 = 0;
        int iZzg6 = 0;
        int iZzg7 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg7 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    iZzg5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 8:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 9:
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
        return new Barcode.CalendarDateTime(iZzg7, iZzg6, iZzg5, iZzg4, iZzg3, iZzg2, iZzg, zZzc, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkv, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarDateTime[] newArray(int i) {
        return new Barcode.CalendarDateTime[i];
    }
}
