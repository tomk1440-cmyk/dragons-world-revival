package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzi implements Parcelable.Creator<Device> {
    static void zza(Device device, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, device.getManufacturer(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, device.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, device.getModel(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, device.getVersion(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, device.zzut(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, device.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, device.zzur());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcV, reason: merged with bridge method [inline-methods] */
    public Device createFromParcel(Parcel parcel) {
        int iZzg = 0;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg2 = 0;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 1000:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Device(iZzg3, strZzp4, strZzp3, strZzp2, strZzp, iZzg2, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeU, reason: merged with bridge method [inline-methods] */
    public Device[] newArray(int i) {
        return new Device[i];
    }
}
