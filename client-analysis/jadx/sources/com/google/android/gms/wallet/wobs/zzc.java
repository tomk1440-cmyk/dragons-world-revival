package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<LabelValueRow> {
    static void zza(LabelValueRow labelValueRow, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, labelValueRow.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, labelValueRow.zzbqF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, labelValueRow.zzbqG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, labelValueRow.zzbqH, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhQ, reason: merged with bridge method [inline-methods] */
    public LabelValueRow createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        ArrayList arrayListZzsa = zzmn.zzsa();
        String strZzp2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    arrayListZzsa = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, LabelValue.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new LabelValueRow(iZzg, strZzp2, strZzp, arrayListZzsa);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlr, reason: merged with bridge method [inline-methods] */
    public LabelValueRow[] newArray(int i) {
        return new LabelValueRow[i];
    }
}
