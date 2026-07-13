package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class PlayerStatsEntityCreator implements Parcelable.Creator<PlayerStatsEntity> {
    static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, playerStatsEntity.getAverageSessionLength());
        zzb.zzc(parcel, 1000, playerStatsEntity.getVersionCode());
        zzb.zza(parcel, 2, playerStatsEntity.getChurnProbability());
        zzb.zzc(parcel, 3, playerStatsEntity.getDaysSinceLastPlayed());
        zzb.zzc(parcel, 4, playerStatsEntity.getNumberOfPurchases());
        zzb.zzc(parcel, 5, playerStatsEntity.getNumberOfSessions());
        zzb.zza(parcel, 6, playerStatsEntity.getSessionPercentile());
        zzb.zza(parcel, 7, playerStatsEntity.getSpendPercentile());
        zzb.zza(parcel, 8, playerStatsEntity.zzxV(), false);
        zzb.zza(parcel, 9, playerStatsEntity.getSpendProbability());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeE, reason: merged with bridge method [inline-methods] */
    public PlayerStatsEntity createFromParcel(Parcel parcel) {
        int iZzg = 0;
        float fZzl = 0.0f;
        int iZzau = zza.zzau(parcel);
        Bundle bundleZzr = null;
        float fZzl2 = 0.0f;
        float fZzl3 = 0.0f;
        int iZzg2 = 0;
        int iZzg3 = 0;
        float fZzl4 = 0.0f;
        float fZzl5 = 0.0f;
        int iZzg4 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    fZzl5 = zza.zzl(parcel, iZzat);
                    break;
                case 2:
                    fZzl4 = zza.zzl(parcel, iZzat);
                    break;
                case 3:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 4:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    fZzl3 = zza.zzl(parcel, iZzat);
                    break;
                case 7:
                    fZzl2 = zza.zzl(parcel, iZzat);
                    break;
                case 8:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 9:
                    fZzl = zza.zzl(parcel, iZzat);
                    break;
                case 1000:
                    iZzg4 = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlayerStatsEntity(iZzg4, fZzl5, fZzl4, iZzg3, iZzg2, iZzg, fZzl3, fZzl2, bundleZzr, fZzl);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgW, reason: merged with bridge method [inline-methods] */
    public PlayerStatsEntity[] newArray(int i) {
        return new PlayerStatsEntity[i];
    }
}
