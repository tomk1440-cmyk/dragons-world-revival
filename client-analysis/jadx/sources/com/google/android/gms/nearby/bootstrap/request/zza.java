package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.bootstrap.Device;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<ConnectRequest> {
    static void zza(ConnectRequest connectRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) connectRequest.zzEd(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, connectRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, connectRequest.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, connectRequest.getDescription(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, connectRequest.zzEg(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, connectRequest.zzEh(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, connectRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, connectRequest.zzEb());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, connectRequest.zzEe());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, connectRequest.getToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, connectRequest.zzEf());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfQ, reason: merged with bridge method [inline-methods] */
    public ConnectRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        Device device = null;
        String strZzp = null;
        String strZzp2 = null;
        byte bZze = 0;
        long jZzi = 0;
        String strZzp3 = null;
        byte bZze2 = 0;
        IBinder iBinderZzq = null;
        IBinder iBinderZzq2 = null;
        IBinder iBinderZzq3 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Device.CREATOR);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 5:
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 6:
                    iBinderZzq3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 7:
                    bZze = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 8:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 9:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 10:
                    bZze2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
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
        return new ConnectRequest(iZzg, device, strZzp, strZzp2, bZze, jZzi, strZzp3, bZze2, iBinderZzq, iBinderZzq2, iBinderZzq3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zziM, reason: merged with bridge method [inline-methods] */
    public ConnectRequest[] newArray(int i) {
        return new ConnectRequest[i];
    }
}
