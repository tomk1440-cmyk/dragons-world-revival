package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class zzbc implements Parcelable.Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onListEntriesResponse.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) onListEntriesResponse.zzass, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, onListEntriesResponse.zzaqJ);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbF, reason: merged with bridge method [inline-methods] */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        boolean zZzc;
        DataHolder dataHolder;
        int iZzg;
        boolean z = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DataHolder dataHolder2 = null;
        int i = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    boolean z2 = z;
                    dataHolder = dataHolder2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    zZzc = z2;
                    break;
                case 2:
                    DataHolder dataHolder3 = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataHolder.CREATOR);
                    iZzg = i;
                    zZzc = z;
                    dataHolder = dataHolder3;
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    dataHolder = dataHolder2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    zZzc = z;
                    dataHolder = dataHolder2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            dataHolder2 = dataHolder;
            z = zZzc;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OnListEntriesResponse(i, dataHolder2, z);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdA, reason: merged with bridge method [inline-methods] */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
