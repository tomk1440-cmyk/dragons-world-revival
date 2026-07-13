package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<NearbyDevice> {
    static void zza(NearbyDevice nearbyDevice, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) nearbyDevice.zzEz(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, nearbyDevice.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, nearbyDevice.getUrl(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, nearbyDevice.zzEC(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable[]) nearbyDevice.zzEA(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, nearbyDevice.zzEB(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgd, reason: merged with bridge method [inline-methods] */
    public NearbyDevice createFromParcel(Parcel parcel) {
        String[] strArrZzB = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        NearbyDeviceId[] nearbyDeviceIdArr = null;
        String strZzp = null;
        String strZzp2 = null;
        NearbyDeviceId nearbyDeviceId = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    nearbyDeviceId = (NearbyDeviceId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, NearbyDeviceId.CREATOR);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    nearbyDeviceIdArr = (NearbyDeviceId[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, NearbyDeviceId.CREATOR);
                    break;
                case 5:
                    strArrZzB = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, iZzat);
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
        return new NearbyDevice(iZzg, nearbyDeviceId, strZzp2, strZzp, nearbyDeviceIdArr, strArrZzB);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzji, reason: merged with bridge method [inline-methods] */
    public NearbyDevice[] newArray(int i) {
        return new NearbyDevice[i];
    }
}
