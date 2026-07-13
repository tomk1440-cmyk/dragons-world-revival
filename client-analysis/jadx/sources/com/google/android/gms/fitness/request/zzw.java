package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzw implements Parcelable.Creator<SensorUnregistrationRequest> {
    static void zza(SensorUnregistrationRequest sensorUnregistrationRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, sensorUnregistrationRequest.zzvb(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sensorUnregistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) sensorUnregistrationRequest.getIntent(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sensorUnregistrationRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdB, reason: merged with bridge method [inline-methods] */
    public SensorUnregistrationRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq;
        PendingIntent pendingIntent;
        IBinder iBinderZzq2;
        int iZzg;
        IBinder iBinder = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        PendingIntent pendingIntent2 = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = i;
                    PendingIntent pendingIntent3 = pendingIntent2;
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    iBinderZzq = iBinder;
                    pendingIntent = pendingIntent3;
                    break;
                case 2:
                    iBinderZzq2 = iBinder2;
                    iZzg = i;
                    IBinder iBinder3 = iBinder;
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PendingIntent.CREATOR);
                    iBinderZzq = iBinder3;
                    break;
                case 3:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    pendingIntent = pendingIntent2;
                    iBinderZzq2 = iBinder2;
                    iZzg = i;
                    break;
                case 1000:
                    IBinder iBinder4 = iBinder;
                    pendingIntent = pendingIntent2;
                    iBinderZzq2 = iBinder2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iBinderZzq = iBinder4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iBinderZzq = iBinder;
                    pendingIntent = pendingIntent2;
                    iBinderZzq2 = iBinder2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            iBinder2 = iBinderZzq2;
            pendingIntent2 = pendingIntent;
            iBinder = iBinderZzq;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SensorUnregistrationRequest(i, iBinder2, pendingIntent2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfC, reason: merged with bridge method [inline-methods] */
    public SensorUnregistrationRequest[] newArray(int i) {
        return new SensorUnregistrationRequest[i];
    }
}
