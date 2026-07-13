package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzi implements Parcelable.Creator<ReadRawResult> {
    static void zza(ReadRawResult readRawResult, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) readRawResult.zzsX(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, readRawResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, readRawResult.zzvo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdV, reason: merged with bridge method [inline-methods] */
    public ReadRawResult createFromParcel(Parcel parcel) {
        ArrayList arrayListZzc;
        DataHolder dataHolder;
        int iZzg;
        ArrayList arrayList = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    DataHolder dataHolder3 = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataHolder.CREATOR);
                    iZzg = i;
                    arrayListZzc = arrayList;
                    dataHolder = dataHolder3;
                    break;
                case 2:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataHolder.CREATOR);
                    dataHolder = dataHolder2;
                    iZzg = i;
                    break;
                case 1000:
                    ArrayList arrayList2 = arrayList;
                    dataHolder = dataHolder2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    arrayListZzc = arrayList2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    arrayListZzc = arrayList;
                    dataHolder = dataHolder2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            dataHolder2 = dataHolder;
            arrayList = arrayListZzc;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ReadRawResult(i, dataHolder2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfW, reason: merged with bridge method [inline-methods] */
    public ReadRawResult[] newArray(int i) {
        return new ReadRawResult[i];
    }
}
