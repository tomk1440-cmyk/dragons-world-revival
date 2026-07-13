package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.Contents;

/* JADX INFO: loaded from: classes.dex */
public class zzaw implements Parcelable.Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) onContentsResponse.zzara, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, onContentsResponse.zzasf);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbz, reason: merged with bridge method [inline-methods] */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        boolean zZzc;
        Contents contents;
        int iZzg;
        boolean z = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Contents contents2 = null;
        int i = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    boolean z2 = z;
                    contents = contents2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    zZzc = z2;
                    break;
                case 2:
                    Contents contents3 = (Contents) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Contents.CREATOR);
                    iZzg = i;
                    zZzc = z;
                    contents = contents3;
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    contents = contents2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    zZzc = z;
                    contents = contents2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            contents2 = contents;
            z = zZzc;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OnContentsResponse(i, contents2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdu, reason: merged with bridge method [inline-methods] */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
