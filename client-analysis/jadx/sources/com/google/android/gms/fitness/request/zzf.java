package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<DataReadRequest> {
    static void zza(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, dataReadRequest.getDataTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, dataReadRequest.getDataSources(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, dataReadRequest.zzlO());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataReadRequest.zzud());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, dataReadRequest.getBucketType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, dataReadRequest.zzuR());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) dataReadRequest.getActivityDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, dataReadRequest.getLimit());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, dataReadRequest.zzuQ());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, dataReadRequest.zzuP());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, dataReadRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 16, dataReadRequest.zzuS(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dataReadRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdl, reason: merged with bridge method [inline-methods] */
    public DataReadRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        long jZzi = 0;
        long jZzi2 = 0;
        ArrayList arrayListZzc3 = null;
        ArrayList arrayListZzc4 = null;
        int iZzg2 = 0;
        long jZzi3 = 0;
        DataSource dataSource = null;
        int iZzg3 = 0;
        boolean zZzc = false;
        boolean zZzc2 = false;
        IBinder iBinderZzq = null;
        ArrayList arrayListZzc5 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataType.CREATOR);
                    break;
                case 2:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 3:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 5:
                    arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataType.CREATOR);
                    break;
                case 6:
                    arrayListZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 7:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 8:
                    jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 9:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 10:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 12:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 13:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 14:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 16:
                    arrayListZzc5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, Device.CREATOR);
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
        return new DataReadRequest(iZzg, arrayListZzc, arrayListZzc2, jZzi, jZzi2, arrayListZzc3, arrayListZzc4, iZzg2, jZzi3, dataSource, iZzg3, zZzc, zZzc2, iBinderZzq, arrayListZzc5);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfl, reason: merged with bridge method [inline-methods] */
    public DataReadRequest[] newArray(int i) {
        return new DataReadRequest[i];
    }
}
