package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GameRequestEntityCreator implements Parcelable.Creator<GameRequestEntity> {
    static void zza(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) gameRequestEntity.getGame(), i, false);
        zzb.zzc(parcel, 1000, gameRequestEntity.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) gameRequestEntity.getSender(), i, false);
        zzb.zza(parcel, 3, gameRequestEntity.getData(), false);
        zzb.zza(parcel, 4, gameRequestEntity.getRequestId(), false);
        zzb.zzc(parcel, 5, gameRequestEntity.getRecipients(), false);
        zzb.zzc(parcel, 7, gameRequestEntity.getType());
        zzb.zza(parcel, 9, gameRequestEntity.getCreationTimestamp());
        zzb.zza(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        zzb.zza(parcel, 11, gameRequestEntity.zzxT(), false);
        zzb.zzc(parcel, 12, gameRequestEntity.getStatus());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzez, reason: merged with bridge method [inline-methods] */
    public GameRequestEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArrZzs = null;
        String strZzp = null;
        ArrayList arrayListZzc = null;
        int iZzg2 = 0;
        long jZzi = 0;
        long jZzi2 = 0;
        Bundle bundleZzr = null;
        int iZzg3 = 0;
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
                    bArrZzs = zza.zzs(parcel, iZzat);
                    break;
                case 4:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    arrayListZzc = zza.zzc(parcel, iZzat, PlayerEntity.CREATOR);
                    break;
                case 7:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 9:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 10:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 11:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 12:
                    iZzg3 = zza.zzg(parcel, iZzat);
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
        return new GameRequestEntity(iZzg, gameEntity, playerEntity, bArrZzs, strZzp, arrayListZzc, iZzg2, jZzi, jZzi2, bundleZzr, iZzg3);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgP, reason: merged with bridge method [inline-methods] */
    public GameRequestEntity[] newArray(int i) {
        return new GameRequestEntity[i];
    }
}
