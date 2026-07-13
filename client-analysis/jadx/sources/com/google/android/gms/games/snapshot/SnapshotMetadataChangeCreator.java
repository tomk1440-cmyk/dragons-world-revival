package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class SnapshotMetadataChangeCreator implements Parcelable.Creator<SnapshotMetadataChangeEntity> {
    static void zza(SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, snapshotMetadataChangeEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, snapshotMetadataChangeEntity.getVersionCode());
        zzb.zza(parcel, 2, snapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
        zzb.zza(parcel, 4, (Parcelable) snapshotMetadataChangeEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 5, (Parcelable) snapshotMetadataChangeEntity.zzxU(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataChangeEntity.getProgressValue(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeC, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataChangeEntity createFromParcel(Parcel parcel) {
        Long lZzj = null;
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        Uri uri = null;
        BitmapTeleporter bitmapTeleporter = null;
        Long lZzj2 = null;
        String strZzp = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    lZzj2 = zza.zzj(parcel, iZzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 5:
                    bitmapTeleporter = (BitmapTeleporter) zza.zza(parcel, iZzat, BitmapTeleporter.CREATOR);
                    break;
                case 6:
                    lZzj = zza.zzj(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SnapshotMetadataChangeEntity(iZzg, strZzp, lZzj2, bitmapTeleporter, uri, lZzj);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgT, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataChangeEntity[] newArray(int i) {
        return new SnapshotMetadataChangeEntity[i];
    }
}
