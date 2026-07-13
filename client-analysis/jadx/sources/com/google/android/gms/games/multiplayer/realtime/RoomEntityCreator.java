package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class RoomEntityCreator implements Parcelable.Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzb.zzc(parcel, 1000, roomEntity.getVersionCode());
        zzb.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzb.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, roomEntity.getStatus());
        zzb.zza(parcel, 5, roomEntity.getDescription(), false);
        zzb.zzc(parcel, 6, roomEntity.getVariant());
        zzb.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzb.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzb.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzev */
    public RoomEntity createFromParcel(Parcel parcel) {
        int iZzg = 0;
        ArrayList arrayListZzc = null;
        int iZzau = zza.zzau(parcel);
        long jZzi = 0;
        Bundle bundleZzr = null;
        int iZzg2 = 0;
        String strZzp = null;
        int iZzg3 = 0;
        String strZzp2 = null;
        String strZzp3 = null;
        int iZzg4 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 7:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 8:
                    arrayListZzc = zza.zzc(parcel, iZzat, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    iZzg = zza.zzg(parcel, iZzat);
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
        return new RoomEntity(iZzg4, strZzp3, strZzp2, jZzi, iZzg3, strZzp, iZzg2, bundleZzr, arrayListZzc, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgL, reason: merged with bridge method [inline-methods] */
    public RoomEntity[] newArray(int i) {
        return new RoomEntity[i];
    }
}
