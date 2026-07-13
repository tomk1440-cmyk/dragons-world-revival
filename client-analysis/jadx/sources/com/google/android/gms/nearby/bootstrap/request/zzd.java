package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.bootstrap.Device;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements Parcelable.Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) disconnectRequest.zzEd(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, disconnectRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, disconnectRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfT, reason: merged with bridge method [inline-methods] */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq;
        Device device;
        int iZzg;
        IBinder iBinder = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Device device2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    Device device3 = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Device.CREATOR);
                    iZzg = i;
                    iBinderZzq = iBinder;
                    device = device3;
                    break;
                case 2:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    device = device2;
                    iZzg = i;
                    break;
                case 1000:
                    IBinder iBinder2 = iBinder;
                    device = device2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iBinderZzq = iBinder2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iBinderZzq = iBinder;
                    device = device2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            device2 = device;
            iBinder = iBinderZzq;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new DisconnectRequest(i, device2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zziP, reason: merged with bridge method [inline-methods] */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
