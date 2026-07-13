package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.Contents;

/* JADX INFO: loaded from: classes.dex */
public class zzi implements Parcelable.Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, closeContentsRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) closeContentsRequest.zzaql, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, closeContentsRequest.zzaqp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, closeContentsRequest.zzaqn);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbg, reason: merged with bridge method [inline-methods] */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        int iZzg;
        Boolean boolZzd;
        Contents contents;
        int iZzg2;
        Boolean bool = null;
        int i = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Contents contents2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    int i3 = i;
                    boolZzd = bool;
                    contents = contents2;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg = i3;
                    break;
                case 2:
                    iZzg2 = i2;
                    Boolean bool2 = bool;
                    contents = (Contents) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Contents.CREATOR);
                    iZzg = i;
                    boolZzd = bool2;
                    break;
                case 3:
                    contents = contents2;
                    iZzg2 = i2;
                    int i4 = i;
                    boolZzd = com.google.android.gms.common.internal.safeparcel.zza.zzd(parcel, iZzat);
                    iZzg = i4;
                    break;
                case 4:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    boolZzd = bool;
                    contents = contents2;
                    iZzg2 = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iZzg = i;
                    boolZzd = bool;
                    contents = contents2;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            contents2 = contents;
            bool = boolZzd;
            i = iZzg;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new CloseContentsRequest(i2, contents2, bool, i);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcW, reason: merged with bridge method [inline-methods] */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
