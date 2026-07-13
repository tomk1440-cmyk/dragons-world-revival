package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzi implements Parcelable.Creator<RegisterSectionInfo> {
    static void zza(RegisterSectionInfo registerSectionInfo, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, registerSectionInfo.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, registerSectionInfo.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, registerSectionInfo.zzUd, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, registerSectionInfo.zzUe);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, registerSectionInfo.weight);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, registerSectionInfo.zzUf);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, registerSectionInfo.zzUg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable[]) registerSectionInfo.zzUh, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, registerSectionInfo.zzUi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, registerSectionInfo.zzUj, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaq, reason: merged with bridge method [inline-methods] */
    public RegisterSectionInfo[] newArray(int i) {
        return new RegisterSectionInfo[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
    public RegisterSectionInfo createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 1;
        int[] iArrZzv = null;
        Feature[] featureArr = null;
        String strZzp2 = null;
        boolean zZzc2 = false;
        String strZzp3 = null;
        String strZzp4 = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 6:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    featureArr = (Feature[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, Feature.CREATOR);
                    break;
                case 8:
                    iArrZzv = com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, iZzat);
                    break;
                case 11:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
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
        return new RegisterSectionInfo(iZzg2, strZzp4, strZzp3, zZzc2, iZzg, zZzc, strZzp2, featureArr, iArrZzv, strZzp);
    }
}
