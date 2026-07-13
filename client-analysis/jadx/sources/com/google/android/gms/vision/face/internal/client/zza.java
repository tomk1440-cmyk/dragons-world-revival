package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<FaceParcel> {
    static void zza(FaceParcel faceParcel, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, faceParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, faceParcel.id);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, faceParcel.centerX);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, faceParcel.centerY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, faceParcel.width);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, faceParcel.height);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, faceParcel.zzbnP);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, faceParcel.zzbnQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable[]) faceParcel.zzbnR, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, faceParcel.zzbnS);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, faceParcel.zzbnT);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, faceParcel.zzbnU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhk, reason: merged with bridge method [inline-methods] */
    public FaceParcel createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        int iZzg2 = 0;
        float fZzl = 0.0f;
        float fZzl2 = 0.0f;
        float fZzl3 = 0.0f;
        float fZzl4 = 0.0f;
        float fZzl5 = 0.0f;
        float fZzl6 = 0.0f;
        LandmarkParcel[] landmarkParcelArr = null;
        float fZzl7 = 0.0f;
        float fZzl8 = 0.0f;
        float fZzl9 = 0.0f;
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
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 4:
                    fZzl2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 5:
                    fZzl3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 6:
                    fZzl4 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 7:
                    fZzl5 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 8:
                    fZzl6 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 9:
                    landmarkParcelArr = (LandmarkParcel[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, LandmarkParcel.CREATOR);
                    break;
                case 10:
                    fZzl7 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 11:
                    fZzl8 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 12:
                    fZzl9 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new FaceParcel(iZzg, iZzg2, fZzl, fZzl2, fZzl3, fZzl4, fZzl5, fZzl6, landmarkParcelArr, fZzl7, fZzl8, fZzl9);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkH, reason: merged with bridge method [inline-methods] */
    public FaceParcel[] newArray(int i) {
        return new FaceParcel[i];
    }
}
