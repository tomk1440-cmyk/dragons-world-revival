package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSet;

/* JADX INFO: loaded from: classes.dex */
public class zzm implements Parcelable.Creator<DataUpdateRequest> {
    static void zza(DataUpdateRequest dataUpdateRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, dataUpdateRequest.zzlO());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataUpdateRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataUpdateRequest.zzud());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) dataUpdateRequest.getDataSet(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataUpdateRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzds, reason: merged with bridge method [inline-methods] */
    public DataUpdateRequest createFromParcel(Parcel parcel) {
        long jZzi = 0;
        IBinder iBinderZzq = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        DataSet dataSet = null;
        long jZzi2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    dataSet = (DataSet) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSet.CREATOR);
                    break;
                case 4:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new DataUpdateRequest(iZzg, jZzi2, jZzi, dataSet, iBinderZzq);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfs, reason: merged with bridge method [inline-methods] */
    public DataUpdateRequest[] newArray(int i) {
        return new DataUpdateRequest[i];
    }
}
