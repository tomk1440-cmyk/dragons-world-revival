package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TurnBasedMatchEntityCreator implements Parcelable.Creator<TurnBasedMatchEntity> {
    static void zza(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) turnBasedMatchEntity.getGame(), i, false);
        zzb.zza(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        zzb.zza(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        zzb.zza(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        zzb.zza(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        zzb.zza(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        zzb.zza(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        zzb.zzc(parcel, 8, turnBasedMatchEntity.getStatus());
        zzb.zzc(parcel, 10, turnBasedMatchEntity.getVariant());
        zzb.zzc(parcel, 11, turnBasedMatchEntity.getVersion());
        zzb.zza(parcel, 12, turnBasedMatchEntity.getData(), false);
        zzb.zzc(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        zzb.zza(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        zzb.zza(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        zzb.zza(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        zzb.zzc(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        zzb.zza(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        zzb.zzc(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        zzb.zza(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        zzb.zza(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzew, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        GameEntity gameEntity = null;
        String strZzp = null;
        String strZzp2 = null;
        long jZzi = 0;
        String strZzp3 = null;
        long jZzi2 = 0;
        String strZzp4 = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
        int iZzg4 = 0;
        byte[] bArrZzs = null;
        ArrayList arrayListZzc = null;
        String strZzp5 = null;
        byte[] bArrZzs2 = null;
        int iZzg5 = 0;
        Bundle bundleZzr = null;
        int iZzg6 = 0;
        boolean zZzc = false;
        String strZzp6 = null;
        String strZzp7 = null;
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
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 5:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 7:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 10:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 11:
                    iZzg4 = zza.zzg(parcel, iZzat);
                    break;
                case 12:
                    bArrZzs = zza.zzs(parcel, iZzat);
                    break;
                case 13:
                    arrayListZzc = zza.zzc(parcel, iZzat, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 15:
                    bArrZzs2 = zza.zzs(parcel, iZzat);
                    break;
                case 16:
                    iZzg5 = zza.zzg(parcel, iZzat);
                    break;
                case 17:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 18:
                    iZzg6 = zza.zzg(parcel, iZzat);
                    break;
                case 19:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 20:
                    strZzp6 = zza.zzp(parcel, iZzat);
                    break;
                case 21:
                    strZzp7 = zza.zzp(parcel, iZzat);
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
        return new TurnBasedMatchEntity(iZzg, gameEntity, strZzp, strZzp2, jZzi, strZzp3, jZzi2, strZzp4, iZzg2, iZzg3, iZzg4, bArrZzs, arrayListZzc, strZzp5, bArrZzs2, iZzg5, bundleZzr, iZzg6, zZzc, strZzp6, strZzp7);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgM, reason: merged with bridge method [inline-methods] */
    public TurnBasedMatchEntity[] newArray(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
