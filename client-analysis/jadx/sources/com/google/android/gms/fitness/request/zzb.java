package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.BleDevice;

/* JADX INFO: loaded from: classes.dex */
public class zzb implements Parcelable.Creator<ClaimBleDeviceRequest> {
    static void zza(ClaimBleDeviceRequest claimBleDeviceRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, claimBleDeviceRequest.getDeviceAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, claimBleDeviceRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) claimBleDeviceRequest.zzuK(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, claimBleDeviceRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdh, reason: merged with bridge method [inline-methods] */
    public ClaimBleDeviceRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq;
        BleDevice bleDevice;
        String strZzp;
        int iZzg;
        IBinder iBinder = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        BleDevice bleDevice2 = null;
        String str = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = i;
                    BleDevice bleDevice3 = bleDevice2;
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    iBinderZzq = iBinder;
                    bleDevice = bleDevice3;
                    break;
                case 2:
                    strZzp = str;
                    iZzg = i;
                    IBinder iBinder2 = iBinder;
                    bleDevice = (BleDevice) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, BleDevice.CREATOR);
                    iBinderZzq = iBinder2;
                    break;
                case 3:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    bleDevice = bleDevice2;
                    strZzp = str;
                    iZzg = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    bleDevice = bleDevice2;
                    strZzp = str;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iBinderZzq = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iBinderZzq = iBinder;
                    bleDevice = bleDevice2;
                    strZzp = str;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            str = strZzp;
            bleDevice2 = bleDevice;
            iBinder = iBinderZzq;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ClaimBleDeviceRequest(i, str, bleDevice2, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfh, reason: merged with bridge method [inline-methods] */
    public ClaimBleDeviceRequest[] newArray(int i) {
        return new ClaimBleDeviceRequest[i];
    }
}
