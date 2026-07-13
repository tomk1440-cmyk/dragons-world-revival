package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<Message> {
    static void zza(Message message, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, message.getContent(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, message.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, message.getType(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, message.getNamespace(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable[]) message.zzEn(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzga, reason: merged with bridge method [inline-methods] */
    public Message createFromParcel(Parcel parcel) {
        NearbyDevice[] nearbyDeviceArr = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        byte[] bArrZzs = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    nearbyDeviceArr = (NearbyDevice[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, NearbyDevice.CREATOR);
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
        return new Message(iZzg, bArrZzs, strZzp2, strZzp, nearbyDeviceArr);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjb, reason: merged with bridge method [inline-methods] */
    public Message[] newArray(int i) {
        return new Message[i];
    }
}
