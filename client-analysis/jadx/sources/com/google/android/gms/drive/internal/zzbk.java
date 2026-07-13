package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class zzbk implements Parcelable.Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, openContentsRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) openContentsRequest.zzaqj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, openContentsRequest.zzaoy);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, openContentsRequest.zzasx);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbN, reason: merged with bridge method [inline-methods] */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int iZzg;
        int iZzg2;
        DriveId driveId;
        int iZzg3;
        int i = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DriveId driveId2 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    int i4 = i;
                    iZzg2 = i2;
                    driveId = driveId2;
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg = i4;
                    break;
                case 2:
                    iZzg3 = i3;
                    int i5 = i2;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DriveId.CREATOR);
                    iZzg = i;
                    iZzg2 = i5;
                    break;
                case 3:
                    driveId = driveId2;
                    iZzg3 = i3;
                    int i6 = i;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg = i6;
                    break;
                case 4:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg2 = i2;
                    driveId = driveId2;
                    iZzg3 = i3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iZzg = i;
                    iZzg2 = i2;
                    driveId = driveId2;
                    iZzg3 = i3;
                    break;
            }
            i3 = iZzg3;
            driveId2 = driveId;
            i2 = iZzg2;
            i = iZzg;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OpenContentsRequest(i3, driveId2, i2, i);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdI, reason: merged with bridge method [inline-methods] */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
