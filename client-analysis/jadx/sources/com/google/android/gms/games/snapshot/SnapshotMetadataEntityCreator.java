package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

/* JADX INFO: loaded from: classes.dex */
public class SnapshotMetadataEntityCreator implements Parcelable.Creator<SnapshotMetadataEntity> {
    static void zza(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) snapshotMetadataEntity.getGame(), i, false);
        zzb.zzc(parcel, 1000, snapshotMetadataEntity.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) snapshotMetadataEntity.getOwner(), i, false);
        zzb.zza(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        zzb.zza(parcel, 5, (Parcelable) snapshotMetadataEntity.getCoverImageUri(), i, false);
        zzb.zza(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        zzb.zza(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        zzb.zza(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        zzb.zza(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        zzb.zza(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        zzb.zza(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        zzb.zza(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        zzb.zza(parcel, 13, snapshotMetadataEntity.hasChangePending());
        zzb.zza(parcel, 14, snapshotMetadataEntity.getProgressValue());
        zzb.zza(parcel, 15, snapshotMetadataEntity.getDeviceName(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeD, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String strZzp = null;
        Uri uri = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        long jZzi = 0;
        long jZzi2 = 0;
        float fZzl = 0.0f;
        String strZzp5 = null;
        boolean zZzc = false;
        long jZzi3 = 0;
        String strZzp6 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, iZzat, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) zza.zza(parcel, iZzat, PlayerEntity.CREATOR);
                    break;
                case 3:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 6:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 10:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 11:
                    fZzl = zza.zzl(parcel, iZzat);
                    break;
                case 12:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 13:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 14:
                    jZzi3 = zza.zzi(parcel, iZzat);
                    break;
                case 15:
                    strZzp6 = zza.zzp(parcel, iZzat);
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
        return new SnapshotMetadataEntity(iZzg, gameEntity, playerEntity, strZzp, uri, strZzp2, strZzp3, strZzp4, jZzi, jZzi2, fZzl, strZzp5, zZzc, jZzi3, strZzp6);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgU, reason: merged with bridge method [inline-methods] */
    public SnapshotMetadataEntity[] newArray(int i) {
        return new SnapshotMetadataEntity[i];
    }
}
