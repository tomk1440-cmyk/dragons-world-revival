package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, queryResultEventParcelable.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) queryResultEventParcelable.zzahi, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, queryResultEventParcelable.zzapQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, queryResultEventParcelable.zzapR);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaT, reason: merged with bridge method [inline-methods] */
    public QueryResultEventParcelable createFromParcel(Parcel parcel) {
        int iZzg;
        boolean zZzc;
        DataHolder dataHolder;
        int iZzg2;
        int i = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DataHolder dataHolder2 = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    int i3 = i;
                    zZzc = z;
                    dataHolder = dataHolder2;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg = i3;
                    break;
                case 2:
                    iZzg2 = i2;
                    boolean z2 = z;
                    dataHolder = (DataHolder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataHolder.CREATOR);
                    iZzg = i;
                    zZzc = z2;
                    break;
                case 3:
                    dataHolder = dataHolder2;
                    iZzg2 = i2;
                    int i4 = i;
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    iZzg = i4;
                    break;
                case 4:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    zZzc = z;
                    dataHolder = dataHolder2;
                    iZzg2 = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iZzg = i;
                    zZzc = z;
                    dataHolder = dataHolder2;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            dataHolder2 = dataHolder;
            z = zZzc;
            i = iZzg;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new QueryResultEventParcelable(i2, dataHolder2, z, i);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcI, reason: merged with bridge method [inline-methods] */
    public QueryResultEventParcelable[] newArray(int i) {
        return new QueryResultEventParcelable[i];
    }
}
