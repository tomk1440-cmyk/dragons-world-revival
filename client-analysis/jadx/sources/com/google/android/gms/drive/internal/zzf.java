package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzf implements Parcelable.Creator<ChangeResourceParentsRequest> {
    static void zza(ChangeResourceParentsRequest changeResourceParentsRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, changeResourceParentsRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) changeResourceParentsRequest.zzaqf, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, changeResourceParentsRequest.zzaqg, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, changeResourceParentsRequest.zzaqh, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbd, reason: merged with bridge method [inline-methods] */
    public ChangeResourceParentsRequest createFromParcel(Parcel parcel) {
        ArrayList arrayListZzc;
        ArrayList arrayListZzc2;
        DriveId driveId;
        int iZzg;
        ArrayList arrayList = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList2 = null;
        DriveId driveId2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    ArrayList arrayList3 = arrayList;
                    arrayListZzc2 = arrayList2;
                    driveId = driveId2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    arrayListZzc = arrayList3;
                    break;
                case 2:
                    iZzg = i;
                    ArrayList arrayList4 = arrayList2;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DriveId.CREATOR);
                    arrayListZzc = arrayList;
                    arrayListZzc2 = arrayList4;
                    break;
                case 3:
                    driveId = driveId2;
                    iZzg = i;
                    ArrayList arrayList5 = arrayList;
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DriveId.CREATOR);
                    arrayListZzc = arrayList5;
                    break;
                case 4:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, DriveId.CREATOR);
                    arrayListZzc2 = arrayList2;
                    driveId = driveId2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    arrayListZzc = arrayList;
                    arrayListZzc2 = arrayList2;
                    driveId = driveId2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            driveId2 = driveId;
            arrayList2 = arrayListZzc2;
            arrayList = arrayListZzc;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ChangeResourceParentsRequest(i, driveId2, arrayList2, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcT, reason: merged with bridge method [inline-methods] */
    public ChangeResourceParentsRequest[] newArray(int i) {
        return new ChangeResourceParentsRequest[i];
    }
}
