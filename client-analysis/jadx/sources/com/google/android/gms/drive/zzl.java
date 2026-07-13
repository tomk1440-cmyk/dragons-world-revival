package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, userMetadata.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, userMetadata.zzaps, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, userMetadata.zzWQ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, userMetadata.zzapt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, userMetadata.zzapu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, userMetadata.zzapv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaO, reason: merged with bridge method [inline-methods] */
    public UserMetadata createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 6:
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
        return new UserMetadata(iZzg, strZzp4, strZzp3, strZzp2, zZzc, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcD, reason: merged with bridge method [inline-methods] */
    public UserMetadata[] newArray(int i) {
        return new UserMetadata[i];
    }
}
