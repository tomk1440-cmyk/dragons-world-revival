package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements Parcelable.Creator<Permission> {
    static void zza(Permission permission, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, permission.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, permission.zzsO(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, permission.zzsP());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, permission.zzsQ(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, permission.zzsR(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, permission.getRole());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, permission.zzsS());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaM, reason: merged with bridge method [inline-methods] */
    public Permission createFromParcel(Parcel parcel) {
        String strZzp = null;
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp2 = null;
        int iZzg2 = 0;
        String strZzp3 = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Permission(iZzg3, strZzp3, iZzg2, strZzp2, strZzp, iZzg, zZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcB, reason: merged with bridge method [inline-methods] */
    public Permission[] newArray(int i) {
        return new Permission[i];
    }
}
