package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator<SyncInfoResult> {
    static void zza(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) syncInfoResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, syncInfoResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, syncInfoResult.zzvq());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdY, reason: merged with bridge method [inline-methods] */
    public SyncInfoResult createFromParcel(Parcel parcel) {
        long jZzi;
        Status status;
        int iZzg;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Status status2 = null;
        long j = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    long j2 = j;
                    status = (Status) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Status.CREATOR);
                    iZzg = i;
                    jZzi = j2;
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    status = status2;
                    iZzg = i;
                    break;
                case 1000:
                    long j3 = j;
                    status = status2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    jZzi = j3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    jZzi = j;
                    status = status2;
                    iZzg = i;
                    break;
            }
            status2 = status;
            i = iZzg;
            j = jZzi;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SyncInfoResult(i, status2, j);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfZ, reason: merged with bridge method [inline-methods] */
    public SyncInfoResult[] newArray(int i) {
        return new SyncInfoResult[i];
    }
}
