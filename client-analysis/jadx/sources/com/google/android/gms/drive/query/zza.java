package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, query.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) query.zzatV, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, query.zzatW, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) query.zzatX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 5, query.zzatY, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, query.zzatZ);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, query.zzapB, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, query.zzarL);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcj, reason: merged with bridge method [inline-methods] */
    public Query createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        ArrayList arrayListZzc = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        boolean zZzc2 = false;
        ArrayList<String> arrayListZzD = null;
        SortOrder sortOrder = null;
        String strZzp = null;
        LogicalFilter logicalFilter = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LogicalFilter.CREATOR);
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, SortOrder.CREATOR);
                    break;
                case 5:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 6:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 7:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DriveSpace.CREATOR);
                    break;
                case 8:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Query(iZzg, logicalFilter, strZzp, sortOrder, arrayListZzD, zZzc2, arrayListZzc, zZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzee, reason: merged with bridge method [inline-methods] */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
