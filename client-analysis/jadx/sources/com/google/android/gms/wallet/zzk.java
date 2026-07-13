package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzk implements Parcelable.Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, loyaltyWalletObject.zzio, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, loyaltyWalletObject.zzboP, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, loyaltyWalletObject.zzboQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, loyaltyWalletObject.zzboR, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, loyaltyWalletObject.zzaQZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, loyaltyWalletObject.zzboS, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, loyaltyWalletObject.zzboT, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, loyaltyWalletObject.zzboU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, loyaltyWalletObject.zzboV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, loyaltyWalletObject.zzboW, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 13, loyaltyWalletObject.zzboX, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, (Parcelable) loyaltyWalletObject.zzboY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 15, loyaltyWalletObject.zzboZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, loyaltyWalletObject.zzbpb, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, loyaltyWalletObject.zzbpa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 19, loyaltyWalletObject.zzbpd);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 18, loyaltyWalletObject.zzbpc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 21, loyaltyWalletObject.zzbpf, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 20, loyaltyWalletObject.zzbpe, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 23, (Parcelable) loyaltyWalletObject.zzbph, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 22, loyaltyWalletObject.zzbpg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhy, reason: merged with bridge method [inline-methods] */
    public LoyaltyWalletObject createFromParcel(Parcel parcel) {
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
        String strZzp9 = null;
        String strZzp10 = null;
        int iZzg2 = 0;
        ArrayList arrayListZzsa = zzmn.zzsa();
        TimeInterval timeInterval = null;
        ArrayList arrayListZzsa2 = zzmn.zzsa();
        String strZzp11 = null;
        String strZzp12 = null;
        ArrayList arrayListZzsa3 = zzmn.zzsa();
        boolean zZzc = false;
        ArrayList arrayListZzsa4 = zzmn.zzsa();
        ArrayList arrayListZzsa5 = zzmn.zzsa();
        ArrayList arrayListZzsa6 = zzmn.zzsa();
        LoyaltyPoints loyaltyPoints = null;
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
                    strZzp9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 11:
                    strZzp10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 12:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 13:
                    arrayListZzsa = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, WalletObjectMessage.CREATOR);
                    break;
                case 14:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TimeInterval.CREATOR);
                    break;
                case 15:
                    arrayListZzsa2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, LatLng.CREATOR);
                    break;
                case 16:
                    strZzp11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 17:
                    strZzp12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 18:
                    arrayListZzsa3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, LabelValueRow.CREATOR);
                    break;
                case 19:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 20:
                    arrayListZzsa4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, UriData.CREATOR);
                    break;
                case 21:
                    arrayListZzsa5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, TextModuleData.CREATOR);
                    break;
                case 22:
                    arrayListZzsa6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, UriData.CREATOR);
                    break;
                case 23:
                    loyaltyPoints = (LoyaltyPoints) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LoyaltyPoints.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new LoyaltyWalletObject(iZzg, strZzp, strZzp2, strZzp3, strZzp4, strZzp5, strZzp6, strZzp7, strZzp8, strZzp9, strZzp10, iZzg2, arrayListZzsa, timeInterval, arrayListZzsa2, strZzp11, strZzp12, arrayListZzsa3, zZzc, arrayListZzsa4, arrayListZzsa5, arrayListZzsa6, loyaltyPoints);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkW, reason: merged with bridge method [inline-methods] */
    public LoyaltyWalletObject[] newArray(int i) {
        return new LoyaltyWalletObject[i];
    }
}
