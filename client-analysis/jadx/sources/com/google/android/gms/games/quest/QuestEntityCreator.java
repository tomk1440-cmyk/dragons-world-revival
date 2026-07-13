package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class QuestEntityCreator implements Parcelable.Creator<QuestEntity> {
    static void zza(QuestEntity questEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) questEntity.getGame(), i, false);
        zzb.zza(parcel, 2, questEntity.getQuestId(), false);
        zzb.zza(parcel, 3, questEntity.getAcceptedTimestamp());
        zzb.zza(parcel, 4, (Parcelable) questEntity.getBannerImageUri(), i, false);
        zzb.zza(parcel, 5, questEntity.getBannerImageUrl(), false);
        zzb.zza(parcel, 6, questEntity.getDescription(), false);
        zzb.zza(parcel, 7, questEntity.getEndTimestamp());
        zzb.zza(parcel, 8, questEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 9, (Parcelable) questEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 10, questEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, questEntity.getName(), false);
        zzb.zza(parcel, 13, questEntity.zzxS());
        zzb.zza(parcel, 14, questEntity.getStartTimestamp());
        zzb.zzc(parcel, 15, questEntity.getState());
        zzb.zzc(parcel, 17, questEntity.zzxR(), false);
        zzb.zzc(parcel, 16, questEntity.getType());
        zzb.zzc(parcel, 1000, questEntity.getVersionCode());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzey, reason: merged with bridge method [inline-methods] */
    public QuestEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        GameEntity gameEntity = null;
        String strZzp = null;
        long jZzi = 0;
        Uri uri = null;
        String strZzp2 = null;
        String strZzp3 = null;
        long jZzi2 = 0;
        long jZzi3 = 0;
        Uri uri2 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        long jZzi4 = 0;
        long jZzi5 = 0;
        int iZzg2 = 0;
        int iZzg3 = 0;
        ArrayList arrayListZzc = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    gameEntity = (GameEntity) zza.zza(parcel, iZzat, GameEntity.CREATOR);
                    break;
                case 2:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 5:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 8:
                    jZzi3 = zza.zzi(parcel, iZzat);
                    break;
                case 9:
                    uri2 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 10:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 12:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 13:
                    jZzi4 = zza.zzi(parcel, iZzat);
                    break;
                case 14:
                    jZzi5 = zza.zzi(parcel, iZzat);
                    break;
                case 15:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 16:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 17:
                    arrayListZzc = zza.zzc(parcel, iZzat, MilestoneEntity.CREATOR);
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
        return new QuestEntity(iZzg, gameEntity, strZzp, jZzi, uri, strZzp2, strZzp3, jZzi2, jZzi3, uri2, strZzp4, strZzp5, jZzi4, jZzi5, iZzg2, iZzg3, arrayListZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgO, reason: merged with bridge method [inline-methods] */
    public QuestEntity[] newArray(int i) {
        return new QuestEntity[i];
    }
}
