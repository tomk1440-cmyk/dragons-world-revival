package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public class zzh implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaqj, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaqk, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaql, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzaoW);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzaoV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzaqm);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzaqn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzaqo);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, closeContentsAndUpdateMetadataRequest.zzapa);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbf, reason: merged with bridge method [inline-methods] */
    public CloseContentsAndUpdateMetadataRequest createFromParcel(Parcel parcel) {
        String strZzp = null;
        boolean zZzc = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        boolean zZzc2 = true;
        int iZzg = 0;
        int iZzg2 = 0;
        boolean zZzc3 = false;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Contents.CREATOR);
                    break;
                case 5:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 6:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 8:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 9:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 10:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new CloseContentsAndUpdateMetadataRequest(iZzg3, driveId, metadataBundle, contents, zZzc3, strZzp, iZzg2, iZzg, zZzc, zZzc2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcV, reason: merged with bridge method [inline-methods] */
    public CloseContentsAndUpdateMetadataRequest[] newArray(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
