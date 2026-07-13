package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzq implements Parcelable.Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, parcelableCollaborator.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, parcelableCollaborator.zzauI);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, parcelableCollaborator.zzaeW);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, parcelableCollaborator.zzLq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, parcelableCollaborator.zzrG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, parcelableCollaborator.zzWQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, parcelableCollaborator.zzauJ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, parcelableCollaborator.zzauK, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcA, reason: merged with bridge method [inline-methods] */
    public ParcelableCollaborator createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        boolean zZzc2 = false;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
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
        return new ParcelableCollaborator(iZzg, zZzc2, zZzc, strZzp5, strZzp4, strZzp3, strZzp2, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzew, reason: merged with bridge method [inline-methods] */
    public ParcelableCollaborator[] newArray(int i) {
        return new ParcelableCollaborator[i];
    }
}
