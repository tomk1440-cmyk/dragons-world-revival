package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzn implements Parcelable.Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, partialDriveId.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, partialDriveId.zzaoL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, partialDriveId.zzaoM);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, partialDriveId.zzaoN);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzci, reason: merged with bridge method [inline-methods] */
    public PartialDriveId createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        long jZzi = 0;
        int iZzg2 = -1;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PartialDriveId(iZzg, strZzp, jZzi, iZzg2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzed, reason: merged with bridge method [inline-methods] */
    public PartialDriveId[] newArray(int i) {
        return new PartialDriveId[i];
    }
}
