package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements Parcelable.Creator<ConnectionConfiguration> {
    static void zza(ConnectionConfiguration connectionConfiguration, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, connectionConfiguration.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, connectionConfiguration.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, connectionConfiguration.getAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, connectionConfiguration.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, connectionConfiguration.getRole());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, connectionConfiguration.isEnabled());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, connectionConfiguration.isConnected());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, connectionConfiguration.zzIt(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, connectionConfiguration.zzIu());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, connectionConfiguration.getNodeId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhY, reason: merged with bridge method [inline-methods] */
    public ConnectionConfiguration createFromParcel(Parcel parcel) {
        String strZzp = null;
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp2 = null;
        boolean zZzc2 = false;
        boolean zZzc3 = false;
        int iZzg = 0;
        int iZzg2 = 0;
        String strZzp3 = null;
        String strZzp4 = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 7:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 8:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 10:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ConnectionConfiguration(iZzg3, strZzp4, strZzp3, iZzg2, iZzg, zZzc3, zZzc2, strZzp2, zZzc, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlz, reason: merged with bridge method [inline-methods] */
    public ConnectionConfiguration[] newArray(int i) {
        return new ConnectionConfiguration[i];
    }
}
