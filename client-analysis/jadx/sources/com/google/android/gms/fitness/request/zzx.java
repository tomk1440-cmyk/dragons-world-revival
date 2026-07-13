package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzx implements Parcelable.Creator<SessionInsertRequest> {
    static void zza(SessionInsertRequest sessionInsertRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) sessionInsertRequest.getSession(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sessionInsertRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, sessionInsertRequest.getDataSets(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, sessionInsertRequest.getAggregateDataPoints(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, sessionInsertRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdC, reason: merged with bridge method [inline-methods] */
    public SessionInsertRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        Session session = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    session = (Session) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Session.CREATOR);
                    break;
                case 2:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataSet.CREATOR);
                    break;
                case 3:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataPoint.CREATOR);
                    break;
                case 4:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
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
        return new SessionInsertRequest(iZzg, session, arrayListZzc2, arrayListZzc, iBinderZzq);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfD, reason: merged with bridge method [inline-methods] */
    public SessionInsertRequest[] newArray(int i) {
        return new SessionInsertRequest[i];
    }
}
