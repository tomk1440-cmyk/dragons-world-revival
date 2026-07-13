package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements Parcelable.Creator<GetRecentContextCall.Response> {
    static void zza(GetRecentContextCall.Response response, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, response.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) response.zzTY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, response.zzTZ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, response.zzUa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzan, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Response[] newArray(int i) {
        return new GetRecentContextCall.Response[i];
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzw, reason: merged with bridge method [inline-methods] */
    public GetRecentContextCall.Response createFromParcel(Parcel parcel) {
        String[] strArrZzB;
        ArrayList arrayListZzc;
        Status status;
        int iZzg;
        String[] strArr = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList = null;
        Status status2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = i;
                    ArrayList arrayList2 = arrayList;
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Status.CREATOR);
                    strArrZzB = strArr;
                    arrayListZzc = arrayList2;
                    break;
                case 2:
                    status = status2;
                    iZzg = i;
                    String[] strArr2 = strArr;
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, UsageInfo.CREATOR);
                    strArrZzB = strArr2;
                    break;
                case 3:
                    strArrZzB = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, iZzat);
                    arrayListZzc = arrayList;
                    status = status2;
                    iZzg = i;
                    break;
                case 1000:
                    String[] strArr3 = strArr;
                    arrayListZzc = arrayList;
                    status = status2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    strArrZzB = strArr3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    strArrZzB = strArr;
                    arrayListZzc = arrayList;
                    status = status2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            status2 = status;
            arrayList = arrayListZzc;
            strArr = strArrZzB;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new GetRecentContextCall.Response(i, status2, arrayList, strArr);
    }
}
