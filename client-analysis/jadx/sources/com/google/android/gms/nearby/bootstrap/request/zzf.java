package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.bootstrap.Device;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<SendDataRequest> {
    static void zza(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) sendDataRequest.zzEd(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sendDataRequest.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sendDataRequest.getData(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sendDataRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfV, reason: merged with bridge method [inline-methods] */
    public SendDataRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq;
        byte[] bArrZzs;
        Device device;
        int iZzg;
        IBinder iBinder = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
        Device device2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = i;
                    byte[] bArr2 = bArr;
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Device.CREATOR);
                    iBinderZzq = iBinder;
                    bArrZzs = bArr2;
                    break;
                case 2:
                    device = device2;
                    iZzg = i;
                    IBinder iBinder2 = iBinder;
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    iBinderZzq = iBinder2;
                    break;
                case 3:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    bArrZzs = bArr;
                    device = device2;
                    iZzg = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    bArrZzs = bArr;
                    device = device2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iBinderZzq = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iBinderZzq = iBinder;
                    bArrZzs = bArr;
                    device = device2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            device2 = device;
            bArr = bArrZzs;
            iBinder = iBinderZzq;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SendDataRequest(i, device2, bArr, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zziR, reason: merged with bridge method [inline-methods] */
    public SendDataRequest[] newArray(int i) {
        return new SendDataRequest[i];
    }
}
