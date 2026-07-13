package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<Bucket> {
    static void zza(Bucket bucket, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, bucket.zzlO());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, bucket.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, bucket.zzud());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) bucket.getSession(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, bucket.zzub());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, bucket.getDataSets(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, bucket.getBucketType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, bucket.zzuc());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcP, reason: merged with bridge method [inline-methods] */
    public Bucket createFromParcel(Parcel parcel) {
        long jZzi = 0;
        ArrayList arrayListZzc = null;
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        int iZzg2 = 0;
        Session session = null;
        long jZzi2 = 0;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    session = (Session) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Session.CREATOR);
                    break;
                case 4:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataSet.CREATOR);
                    break;
                case 6:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 1000:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Bucket(iZzg3, jZzi2, jZzi, session, iZzg2, arrayListZzc, iZzg, zZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeN, reason: merged with bridge method [inline-methods] */
    public Bucket[] newArray(int i) {
        return new Bucket[i];
    }
}
