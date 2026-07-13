package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;

/* JADX INFO: loaded from: classes.dex */
public class zzbp implements Parcelable.Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) removeEventListenerRequest.zzaoz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, removeEventListenerRequest.zzanf);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) removeEventListenerRequest.zzapZ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbR, reason: merged with bridge method [inline-methods] */
    public RemoveEventListenerRequest createFromParcel(Parcel parcel) {
        TransferProgressOptions transferProgressOptions;
        int iZzg;
        DriveId driveId;
        int iZzg2;
        TransferProgressOptions transferProgressOptions2 = null;
        int i = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DriveId driveId2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    TransferProgressOptions transferProgressOptions3 = transferProgressOptions2;
                    iZzg = i;
                    driveId = driveId2;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    transferProgressOptions = transferProgressOptions3;
                    break;
                case 2:
                    iZzg2 = i2;
                    int i3 = i;
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DriveId.CREATOR);
                    transferProgressOptions = transferProgressOptions2;
                    iZzg = i3;
                    break;
                case 3:
                    driveId = driveId2;
                    iZzg2 = i2;
                    TransferProgressOptions transferProgressOptions4 = transferProgressOptions2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    transferProgressOptions = transferProgressOptions4;
                    break;
                case 4:
                    transferProgressOptions = (TransferProgressOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TransferProgressOptions.CREATOR);
                    iZzg = i;
                    driveId = driveId2;
                    iZzg2 = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    transferProgressOptions = transferProgressOptions2;
                    iZzg = i;
                    driveId = driveId2;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            driveId2 = driveId;
            i = iZzg;
            transferProgressOptions2 = transferProgressOptions;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new RemoveEventListenerRequest(i2, driveId2, i, transferProgressOptions2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdM, reason: merged with bridge method [inline-methods] */
    public RemoveEventListenerRequest[] newArray(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
