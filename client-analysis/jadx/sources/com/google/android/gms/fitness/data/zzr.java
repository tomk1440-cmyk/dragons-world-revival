package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzr implements Parcelable.Creator<SessionDataSet> {
    static void zza(SessionDataSet sessionDataSet, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) sessionDataSet.getSession(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sessionDataSet.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) sessionDataSet.getDataSet(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdc, reason: merged with bridge method [inline-methods] */
    public SessionDataSet createFromParcel(Parcel parcel) {
        DataSet dataSet;
        Session session;
        int iZzg;
        DataSet dataSet2 = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Session session2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    Session session3 = (Session) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Session.CREATOR);
                    iZzg = i;
                    dataSet = dataSet2;
                    session = session3;
                    break;
                case 2:
                    dataSet = (DataSet) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DataSet.CREATOR);
                    session = session2;
                    iZzg = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet2;
                    session = session2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    dataSet = dataSet3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    dataSet = dataSet2;
                    session = session2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            session2 = session;
            dataSet2 = dataSet;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SessionDataSet(i, session2, dataSet2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfc, reason: merged with bridge method [inline-methods] */
    public SessionDataSet[] newArray(int i) {
        return new SessionDataSet[i];
    }
}
