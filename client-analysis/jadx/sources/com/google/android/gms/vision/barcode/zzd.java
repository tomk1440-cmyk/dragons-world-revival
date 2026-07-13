package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<Barcode.CalendarEvent> {
    static void zza(Barcode.CalendarEvent calendarEvent, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, calendarEvent.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, calendarEvent.summary, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, calendarEvent.description, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, calendarEvent.location, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, calendarEvent.organizer, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, calendarEvent.status, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) calendarEvent.start, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) calendarEvent.end, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgZ, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarEvent createFromParcel(Parcel parcel) {
        Barcode.CalendarDateTime calendarDateTime = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        Barcode.CalendarDateTime calendarDateTime2 = null;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    calendarDateTime2 = (Barcode.CalendarDateTime) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Barcode.CalendarDateTime.CREATOR);
                    break;
                case 8:
                    calendarDateTime = (Barcode.CalendarDateTime) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Barcode.CalendarDateTime.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Barcode.CalendarEvent(iZzg, strZzp5, strZzp4, strZzp3, strZzp2, strZzp, calendarDateTime2, calendarDateTime);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkw, reason: merged with bridge method [inline-methods] */
    public Barcode.CalendarEvent[] newArray(int i) {
        return new Barcode.CalendarEvent[i];
    }
}
