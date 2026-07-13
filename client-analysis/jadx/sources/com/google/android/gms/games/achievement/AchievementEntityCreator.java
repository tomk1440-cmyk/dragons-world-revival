package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;

/* JADX INFO: loaded from: classes.dex */
public class AchievementEntityCreator implements Parcelable.Creator<AchievementEntity> {
    static void zza(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, achievementEntity.getAchievementId(), false);
        zzb.zzc(parcel, 2, achievementEntity.getType());
        zzb.zza(parcel, 3, achievementEntity.getName(), false);
        zzb.zza(parcel, 4, achievementEntity.getDescription(), false);
        zzb.zza(parcel, 5, (Parcelable) achievementEntity.getUnlockedImageUri(), i, false);
        zzb.zza(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        zzb.zza(parcel, 7, (Parcelable) achievementEntity.getRevealedImageUri(), i, false);
        zzb.zza(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        zzb.zzc(parcel, 9, achievementEntity.zzvK());
        zzb.zza(parcel, 10, achievementEntity.zzvL(), false);
        zzb.zza(parcel, 11, (Parcelable) achievementEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 12, achievementEntity.getState());
        zzb.zzc(parcel, 13, achievementEntity.zzvM());
        zzb.zza(parcel, 14, achievementEntity.zzvN(), false);
        zzb.zza(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 16, achievementEntity.getXpValue());
        zzb.zzc(parcel, 1000, achievementEntity.getVersionCode());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzee, reason: merged with bridge method [inline-methods] */
    public AchievementEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        int iZzg2 = 0;
        String strZzp2 = null;
        String strZzp3 = null;
        Uri uri = null;
        String strZzp4 = null;
        Uri uri2 = null;
        String strZzp5 = null;
        int iZzg3 = 0;
        String strZzp6 = null;
        PlayerEntity playerEntity = null;
        int iZzg4 = 0;
        int iZzg5 = 0;
        String strZzp7 = null;
        long jZzi = 0;
        long jZzi2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 6:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    uri2 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 8:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 10:
                    strZzp6 = zza.zzp(parcel, iZzat);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) zza.zza(parcel, iZzat, PlayerEntity.CREATOR);
                    break;
                case 12:
                    iZzg4 = zza.zzg(parcel, iZzat);
                    break;
                case 13:
                    iZzg5 = zza.zzg(parcel, iZzat);
                    break;
                case 14:
                    strZzp7 = zza.zzp(parcel, iZzat);
                    break;
                case 15:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 16:
                    jZzi2 = zza.zzi(parcel, iZzat);
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
        return new AchievementEntity(iZzg, strZzp, iZzg2, strZzp2, strZzp3, uri, strZzp4, uri2, strZzp5, iZzg3, strZzp6, playerEntity, iZzg4, iZzg5, strZzp7, jZzi, jZzi2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgg, reason: merged with bridge method [inline-methods] */
    public AchievementEntity[] newArray(int i) {
        return new AchievementEntity[i];
    }
}
