package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class GameEntityCreator implements Parcelable.Creator<GameEntity> {
    static void zza(GameEntity gameEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, gameEntity.getApplicationId(), false);
        zzb.zza(parcel, 2, gameEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, gameEntity.getPrimaryCategory(), false);
        zzb.zza(parcel, 4, gameEntity.getSecondaryCategory(), false);
        zzb.zza(parcel, 5, gameEntity.getDescription(), false);
        zzb.zza(parcel, 6, gameEntity.getDeveloperName(), false);
        zzb.zza(parcel, 7, (Parcelable) gameEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 8, (Parcelable) gameEntity.getHiResImageUri(), i, false);
        zzb.zza(parcel, 9, (Parcelable) gameEntity.getFeaturedImageUri(), i, false);
        zzb.zza(parcel, 10, gameEntity.zzvx());
        zzb.zza(parcel, 11, gameEntity.zzvz());
        zzb.zza(parcel, 12, gameEntity.zzvA(), false);
        zzb.zzc(parcel, 13, gameEntity.zzvB());
        zzb.zzc(parcel, 14, gameEntity.getAchievementTotalCount());
        zzb.zzc(parcel, 15, gameEntity.getLeaderboardCount());
        zzb.zza(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        zzb.zza(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        zzb.zzc(parcel, 1000, gameEntity.getVersionCode());
        zzb.zza(parcel, 19, gameEntity.getHiResImageUrl(), false);
        zzb.zza(parcel, 18, gameEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 21, gameEntity.isMuted());
        zzb.zza(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        zzb.zza(parcel, 23, gameEntity.areSnapshotsEnabled());
        zzb.zza(parcel, 22, gameEntity.zzvy());
        zzb.zza(parcel, 25, gameEntity.hasGamepadSupport());
        zzb.zza(parcel, 24, gameEntity.getThemeColor(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzea, reason: merged with bridge method [inline-methods] */
    public GameEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        String strZzp6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean zZzc = false;
        boolean zZzc2 = false;
        String strZzp7 = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
        int iZzg4 = 0;
        boolean zZzc3 = false;
        boolean zZzc4 = false;
        String strZzp8 = null;
        String strZzp9 = null;
        String strZzp10 = null;
        boolean zZzc5 = false;
        boolean zZzc6 = false;
        boolean zZzc7 = false;
        String strZzp11 = null;
        boolean zZzc8 = false;
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
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp6 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 10:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 11:
                    zZzc2 = zza.zzc(parcel, iZzat);
                    break;
                case 12:
                    strZzp7 = zza.zzp(parcel, iZzat);
                    break;
                case 13:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 14:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 15:
                    iZzg4 = zza.zzg(parcel, iZzat);
                    break;
                case 16:
                    zZzc3 = zza.zzc(parcel, iZzat);
                    break;
                case 17:
                    zZzc4 = zza.zzc(parcel, iZzat);
                    break;
                case 18:
                    strZzp8 = zza.zzp(parcel, iZzat);
                    break;
                case 19:
                    strZzp9 = zza.zzp(parcel, iZzat);
                    break;
                case 20:
                    strZzp10 = zza.zzp(parcel, iZzat);
                    break;
                case 21:
                    zZzc5 = zza.zzc(parcel, iZzat);
                    break;
                case 22:
                    zZzc6 = zza.zzc(parcel, iZzat);
                    break;
                case 23:
                    zZzc7 = zza.zzc(parcel, iZzat);
                    break;
                case 24:
                    strZzp11 = zza.zzp(parcel, iZzat);
                    break;
                case 25:
                    zZzc8 = zza.zzc(parcel, iZzat);
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
        return new GameEntity(iZzg, strZzp, strZzp2, strZzp3, strZzp4, strZzp5, strZzp6, uri, uri2, uri3, zZzc, zZzc2, strZzp7, iZzg2, iZzg3, iZzg4, zZzc3, zZzc4, strZzp8, strZzp9, strZzp10, zZzc5, zZzc6, zZzc7, strZzp11, zZzc8);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgb, reason: merged with bridge method [inline-methods] */
    public GameEntity[] newArray(int i) {
        return new GameEntity[i];
    }
}
