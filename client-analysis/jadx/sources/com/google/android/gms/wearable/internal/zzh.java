package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzh implements Parcelable.Creator<AncsNotificationParcelable> {
    static void zza(AncsNotificationParcelable ancsNotificationParcelable, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, ancsNotificationParcelable.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, ancsNotificationParcelable.getId());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, ancsNotificationParcelable.zzwK(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, ancsNotificationParcelable.zzIB(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, ancsNotificationParcelable.zzIC(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, ancsNotificationParcelable.getTitle(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, ancsNotificationParcelable.zzwc(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, ancsNotificationParcelable.getDisplayName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, ancsNotificationParcelable.zzID());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, ancsNotificationParcelable.zzIE());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, ancsNotificationParcelable.zzIF());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, ancsNotificationParcelable.zzIG());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, ancsNotificationParcelable.getPackageName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzid, reason: merged with bridge method [inline-methods] */
    public AncsNotificationParcelable createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        int iZzg2 = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        String strZzp6 = null;
        byte bZze = 0;
        byte bZze2 = 0;
        byte bZze3 = 0;
        byte bZze4 = 0;
        String strZzp7 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    strZzp6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    bZze = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 10:
                    bZze2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 11:
                    bZze3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 12:
                    bZze4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 13:
                    strZzp7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new AncsNotificationParcelable(iZzg, iZzg2, strZzp, strZzp2, strZzp3, strZzp4, strZzp5, strZzp6, bZze, bZze2, bZze3, bZze4, strZzp7);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlE, reason: merged with bridge method [inline-methods] */
    public AncsNotificationParcelable[] newArray(int i) {
        return new AncsNotificationParcelable[i];
    }
}
