package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<CommonWalletObject> {
    static void zza(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, commonWalletObject.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, commonWalletObject.zzio, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, commonWalletObject.zzboW, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, commonWalletObject.name, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, commonWalletObject.zzboQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, commonWalletObject.zzboS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, commonWalletObject.zzboT, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, commonWalletObject.zzboU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, commonWalletObject.zzboV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, commonWalletObject.state);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 11, commonWalletObject.zzboX, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, (Parcelable) commonWalletObject.zzboY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 13, commonWalletObject.zzboZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, commonWalletObject.zzbpa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, commonWalletObject.zzbpb, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, commonWalletObject.zzbpd);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 16, commonWalletObject.zzbpc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 19, commonWalletObject.zzbpf, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 18, commonWalletObject.zzbpe, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 20, commonWalletObject.zzbpg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhO, reason: merged with bridge method [inline-methods] */
    public CommonWalletObject createFromParcel(Parcel parcel) {
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
        int iZzg2 = 0;
        ArrayList arrayListZzsa = zzmn.zzsa();
        TimeInterval timeInterval = null;
        ArrayList arrayListZzsa2 = zzmn.zzsa();
        String strZzp9 = null;
        String strZzp10 = null;
        ArrayList arrayListZzsa3 = zzmn.zzsa();
        boolean zZzc = false;
        ArrayList arrayListZzsa4 = zzmn.zzsa();
        ArrayList arrayListZzsa5 = zzmn.zzsa();
        ArrayList arrayListZzsa6 = zzmn.zzsa();
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
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 11:
                    arrayListZzsa = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TimeInterval.CREATOR);
                    break;
                case 13:
                    arrayListZzsa2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, LatLng.CREATOR);
                    break;
                case 14:
                    strZzp9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 15:
                    strZzp10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 16:
                    arrayListZzsa3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, LabelValueRow.CREATOR);
                    break;
                case 17:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 18:
                    arrayListZzsa4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, UriData.CREATOR);
                    break;
                case 19:
                    arrayListZzsa5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, TextModuleData.CREATOR);
                    break;
                case 20:
                    arrayListZzsa6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new CommonWalletObject(iZzg, strZzp, strZzp2, strZzp3, strZzp4, strZzp5, strZzp6, strZzp7, strZzp8, iZzg2, arrayListZzsa, timeInterval, arrayListZzsa2, strZzp9, strZzp10, arrayListZzsa3, zZzc, arrayListZzsa4, arrayListZzsa5, arrayListZzsa6);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlp, reason: merged with bridge method [inline-methods] */
    public CommonWalletObject[] newArray(int i) {
        return new CommonWalletObject[i];
    }
}
