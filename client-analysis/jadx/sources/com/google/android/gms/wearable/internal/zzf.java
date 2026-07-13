package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<AmsEntityUpdateParcelable> {
    static void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, amsEntityUpdateParcelable.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, amsEntityUpdateParcelable.zzIz());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, amsEntityUpdateParcelable.zzIA());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, amsEntityUpdateParcelable.getValue(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzic, reason: merged with bridge method [inline-methods] */
    public AmsEntityUpdateParcelable createFromParcel(Parcel parcel) {
        byte bZze = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String strZzp = null;
        byte bZze2 = 0;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    bZze2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 3:
                    bZze = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, iZzat);
                    break;
                case 4:
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
        return new AmsEntityUpdateParcelable(iZzg, bZze2, bZze, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlD, reason: merged with bridge method [inline-methods] */
    public AmsEntityUpdateParcelable[] newArray(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}
