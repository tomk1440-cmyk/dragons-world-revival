package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzv implements Parcelable.Creator<SensorRegistrationRequest> {
    static void zza(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) sensorRegistrationRequest.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sensorRegistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) sensorRegistrationRequest.getDataType(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sensorRegistrationRequest.zzvb(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, sensorRegistrationRequest.zzaBi);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, sensorRegistrationRequest.zzaBj);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, sensorRegistrationRequest.zzux());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, sensorRegistrationRequest.zzuY());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) sensorRegistrationRequest.getIntent(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, sensorRegistrationRequest.zzuX());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, sensorRegistrationRequest.getAccuracyMode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 11, sensorRegistrationRequest.zzuZ(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, sensorRegistrationRequest.zzva());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, sensorRegistrationRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdA, reason: merged with bridge method [inline-methods] */
    public SensorRegistrationRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinderZzq = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
        long jZzi = 0;
        long jZzi2 = 0;
        PendingIntent pendingIntent = null;
        long jZzi3 = 0;
        int iZzg4 = 0;
        ArrayList arrayListZzc = null;
        long jZzi4 = 0;
        IBinder iBinderZzq2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataType.CREATOR);
                    break;
                case 3:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 7:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PendingIntent.CREATOR);
                    break;
                case 9:
                    jZzi3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 10:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 11:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, LocationRequest.CREATOR);
                    break;
                case 12:
                    jZzi4 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 13:
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
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
        return new SensorRegistrationRequest(iZzg, dataSource, dataType, iBinderZzq, iZzg2, iZzg3, jZzi, jZzi2, pendingIntent, jZzi3, iZzg4, arrayListZzc, jZzi4, iBinderZzq2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfA, reason: merged with bridge method [inline-methods] */
    public SensorRegistrationRequest[] newArray(int i) {
        return new SensorRegistrationRequest[i];
    }
}
