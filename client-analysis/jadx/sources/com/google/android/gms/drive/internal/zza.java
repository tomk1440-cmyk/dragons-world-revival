package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.TransferProgressOptions;
import com.google.android.gms.drive.events.TransferStateOptions;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<AddEventListenerRequest> {
    static void zza(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addEventListenerRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) addEventListenerRequest.zzaoz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, addEventListenerRequest.zzanf);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) addEventListenerRequest.zzapy, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) addEventListenerRequest.zzapY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) addEventListenerRequest.zzapZ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzaZ, reason: merged with bridge method [inline-methods] */
    public AddEventListenerRequest createFromParcel(Parcel parcel) {
        int iZzg = 0;
        TransferProgressOptions transferProgressOptions = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        TransferStateOptions transferStateOptions = null;
        ChangesAvailableOptions changesAvailableOptions = null;
        DriveId driveId = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DriveId.CREATOR);
                    break;
                case 3:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    changesAvailableOptions = (ChangesAvailableOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ChangesAvailableOptions.CREATOR);
                    break;
                case 5:
                    transferStateOptions = (TransferStateOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TransferStateOptions.CREATOR);
                    break;
                case 6:
                    transferProgressOptions = (TransferProgressOptions) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TransferProgressOptions.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new AddEventListenerRequest(iZzg2, driveId, iZzg, changesAvailableOptions, transferStateOptions, transferProgressOptions);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcP, reason: merged with bridge method [inline-methods] */
    public AddEventListenerRequest[] newArray(int i) {
        return new AddEventListenerRequest[i];
    }
}
