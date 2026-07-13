package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* JADX INFO: loaded from: classes.dex */
public class PlayerEntityCreator implements Parcelable.Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzb.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, (Parcelable) playerEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, (Parcelable) playerEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzb.zzc(parcel, 6, playerEntity.zzvG());
        zzb.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzb.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 14, playerEntity.getTitle(), false);
        zzb.zza(parcel, 15, (Parcelable) playerEntity.zzvI(), i, false);
        zzb.zza(parcel, 16, (Parcelable) playerEntity.getLevelInfo(), i, false);
        zzb.zzc(parcel, 1000, playerEntity.getVersionCode());
        zzb.zza(parcel, 19, playerEntity.zzvF());
        zzb.zza(parcel, 18, playerEntity.zzvH());
        zzb.zza(parcel, 21, playerEntity.getName(), false);
        zzb.zza(parcel, 20, playerEntity.zzvE(), false);
        zzb.zza(parcel, 23, playerEntity.getBannerImageLandscapeUrl(), false);
        zzb.zza(parcel, 22, (Parcelable) playerEntity.getBannerImageLandscapeUri(), i, false);
        zzb.zza(parcel, 25, playerEntity.getBannerImagePortraitUrl(), false);
        zzb.zza(parcel, 24, (Parcelable) playerEntity.getBannerImagePortraitUri(), i, false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeb */
    public PlayerEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long jZzi = 0;
        int iZzg2 = 0;
        long jZzi2 = 0;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean zZzc = false;
        boolean zZzc2 = false;
        String strZzp6 = null;
        String strZzp7 = null;
        Uri uri3 = null;
        String strZzp8 = null;
        Uri uri4 = null;
        String strZzp9 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 5:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 6:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 8:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 14:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zza.zza(parcel, iZzat, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) zza.zza(parcel, iZzat, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 19:
                    zZzc2 = zza.zzc(parcel, iZzat);
                    break;
                case 20:
                    strZzp6 = zza.zzp(parcel, iZzat);
                    break;
                case 21:
                    strZzp7 = zza.zzp(parcel, iZzat);
                    break;
                case 22:
                    uri3 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 23:
                    strZzp8 = zza.zzp(parcel, iZzat);
                    break;
                case 24:
                    uri4 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 25:
                    strZzp9 = zza.zzp(parcel, iZzat);
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
        return new PlayerEntity(iZzg, strZzp, strZzp2, uri, uri2, jZzi, iZzg2, jZzi2, strZzp3, strZzp4, strZzp5, mostRecentGameInfoEntity, playerLevelInfo, zZzc, zZzc2, strZzp6, strZzp7, uri3, strZzp8, uri4, strZzp9);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgd, reason: merged with bridge method [inline-methods] */
    public PlayerEntity[] newArray(int i) {
        return new PlayerEntity[i];
    }
}
