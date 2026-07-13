package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.events.internal.TransferProgressData;

/* JADX INFO: loaded from: classes.dex */
public class zzn implements Parcelable.Creator<TransferProgressEvent> {
    static void zza(TransferProgressEvent transferProgressEvent, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, transferProgressEvent.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) transferProgressEvent.zzapS, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaU, reason: merged with bridge method [inline-methods] */
    public TransferProgressEvent createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        TransferProgressData transferProgressData = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    transferProgressData = (TransferProgressData) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TransferProgressData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new TransferProgressEvent(iZzg, transferProgressData);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcK, reason: merged with bridge method [inline-methods] */
    public TransferProgressEvent[] newArray(int i) {
        return new TransferProgressEvent[i];
    }
}
