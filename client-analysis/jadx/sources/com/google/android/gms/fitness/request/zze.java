package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSet;

/* JADX INFO: loaded from: classes.dex */
public class zze implements Parcelable.Creator<DataInsertRequest> {
    static void zza(DataInsertRequest dataInsertRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) dataInsertRequest.getDataSet(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataInsertRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dataInsertRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataInsertRequest.zzuO());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdk, reason: merged with bridge method [inline-methods] */
    public DataInsertRequest createFromParcel(Parcel parcel) {
        boolean zZzc;
        IBinder iBinderZzq;
        DataSet dataSet;
        int iZzg;
        IBinder iBinder = null;
        boolean z = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DataSet dataSet2 = null;
        int i = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = i;
                    IBinder iBinder2 = iBinder;
                    dataSet = (DataSet) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSet.CREATOR);
                    zZzc = z;
                    iBinderZzq = iBinder2;
                    break;
                case 2:
                    dataSet = dataSet2;
                    iZzg = i;
                    boolean z2 = z;
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    zZzc = z2;
                    break;
                case 4:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    iBinderZzq = iBinder;
                    dataSet = dataSet2;
                    iZzg = i;
                    break;
                case 1000:
                    boolean z3 = z;
                    iBinderZzq = iBinder;
                    dataSet = dataSet2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    zZzc = z3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    zZzc = z;
                    iBinderZzq = iBinder;
                    dataSet = dataSet2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            dataSet2 = dataSet;
            iBinder = iBinderZzq;
            z = zZzc;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new DataInsertRequest(i, dataSet2, iBinder, z);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfk, reason: merged with bridge method [inline-methods] */
    public DataInsertRequest[] newArray(int i) {
        return new DataInsertRequest[i];
    }
}
