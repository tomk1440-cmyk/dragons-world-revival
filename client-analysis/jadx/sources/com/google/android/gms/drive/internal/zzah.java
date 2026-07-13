package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzah implements Parcelable.Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getChangesRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) getChangesRequest.zzarJ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, getChangesRequest.zzarK);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, getChangesRequest.zzapB, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, getChangesRequest.zzarL);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbr, reason: merged with bridge method [inline-methods] */
    public GetChangesRequest createFromParcel(Parcel parcel) {
        ArrayList arrayListZzc = null;
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        ChangeSequenceNumber changeSequenceNumber = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    changeSequenceNumber = (ChangeSequenceNumber) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ChangeSequenceNumber.CREATOR);
                    break;
                case 3:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DriveSpace.CREATOR);
                    break;
                case 5:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new GetChangesRequest(iZzg2, changeSequenceNumber, iZzg, arrayListZzc, zZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdm, reason: merged with bridge method [inline-methods] */
    public GetChangesRequest[] newArray(int i) {
        return new GetChangesRequest[i];
    }
}
