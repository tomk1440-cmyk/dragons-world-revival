package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<AutocompletePredictionEntity> {
    static void zza(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, autocompletePredictionEntity.zzaQd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, autocompletePredictionEntity.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, autocompletePredictionEntity.zzaPH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, autocompletePredictionEntity.zzaPd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, autocompletePredictionEntity.zzaQe, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, autocompletePredictionEntity.zzaQf);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, autocompletePredictionEntity.zzaQg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, autocompletePredictionEntity.zzaQh, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, autocompletePredictionEntity.zzaQi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, autocompletePredictionEntity.zzaQj, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfk, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity createFromParcel(Parcel parcel) {
        int iZzg = 0;
        ArrayList arrayListZzc = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp = null;
        ArrayList arrayListZzc2 = null;
        String strZzp2 = null;
        ArrayList arrayListZzc3 = null;
        String strZzp3 = null;
        ArrayList<Integer> arrayListZzC = null;
        String strZzp4 = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    arrayListZzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzat);
                    break;
                case 4:
                    arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 5:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 8:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, AutocompletePredictionEntity.SubstringEntity.CREATOR);
                    break;
                case 1000:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new AutocompletePredictionEntity(iZzg2, strZzp4, arrayListZzC, iZzg, strZzp3, arrayListZzc3, strZzp2, arrayListZzc2, strZzp, arrayListZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhW, reason: merged with bridge method [inline-methods] */
    public AutocompletePredictionEntity[] newArray(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
