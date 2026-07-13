package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, parcelableEventList.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, parcelableEventList.zzpH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) parcelableEventList.zzavf, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, parcelableEventList.zzavg);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 5, parcelableEventList.zzavh, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) parcelableEventList.zzavi, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcF, reason: merged with bridge method [inline-methods] */
    public ParcelableEventList createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        ArrayList<String> arrayListZzD = null;
        DataHolder dataHolder = null;
        ArrayList arrayListZzc = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataHolder.CREATOR);
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 5:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 6:
                    parcelableChangeInfo = (ParcelableChangeInfo) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ParcelableEventList(iZzg, arrayListZzc, dataHolder, zZzc, arrayListZzD, parcelableChangeInfo);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeB, reason: merged with bridge method [inline-methods] */
    public ParcelableEventList[] newArray(int i) {
        return new ParcelableEventList[i];
    }
}
