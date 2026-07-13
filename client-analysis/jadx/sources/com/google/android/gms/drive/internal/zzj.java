package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements Parcelable.Creator<ControlProgressRequest> {
    static void zza(ControlProgressRequest controlProgressRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, controlProgressRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, controlProgressRequest.zzaqq);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, controlProgressRequest.zzaqr);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) controlProgressRequest.zzaoz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) controlProgressRequest.zzaqs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbh, reason: merged with bridge method [inline-methods] */
    public ControlProgressRequest createFromParcel(Parcel parcel) {
        ParcelableTransferPreferences parcelableTransferPreferences = null;
        int iZzg = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DriveId driveId = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DriveId.CREATOR);
                    break;
                case 5:
                    parcelableTransferPreferences = (ParcelableTransferPreferences) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ParcelableTransferPreferences.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ControlProgressRequest(iZzg3, iZzg2, iZzg, driveId, parcelableTransferPreferences);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcX, reason: merged with bridge method [inline-methods] */
    public ControlProgressRequest[] newArray(int i) {
        return new ControlProgressRequest[i];
    }
}
