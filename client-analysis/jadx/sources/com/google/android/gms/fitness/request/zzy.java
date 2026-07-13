package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzy implements Parcelable.Creator<SessionReadRequest> {
    static void zza(SessionReadRequest sessionReadRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, sessionReadRequest.getSessionName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sessionReadRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sessionReadRequest.getSessionId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sessionReadRequest.zzlO());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, sessionReadRequest.zzud());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, sessionReadRequest.getDataTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, sessionReadRequest.getDataSources(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, sessionReadRequest.zzve());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, sessionReadRequest.zzuP());
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 9, sessionReadRequest.getExcludedPackages(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, sessionReadRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdD, reason: merged with bridge method [inline-methods] */
    public SessionReadRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        long jZzi = 0;
        long jZzi2 = 0;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        boolean zZzc = false;
        boolean zZzc2 = false;
        ArrayList<String> arrayListZzD = null;
        IBinder iBinderZzq = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 5:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataType.CREATOR);
                    break;
                case 6:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DataSource.CREATOR);
                    break;
                case 7:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 8:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 9:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 10:
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
        return new SessionReadRequest(iZzg, strZzp, strZzp2, jZzi, jZzi2, arrayListZzc, arrayListZzc2, zZzc, zZzc2, arrayListZzD, iBinderZzq);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfE, reason: merged with bridge method [inline-methods] */
    public SessionReadRequest[] newArray(int i) {
        return new SessionReadRequest[i];
    }
}
