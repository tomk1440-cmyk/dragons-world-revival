package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InvitationEntityCreator implements Parcelable.Creator<InvitationEntity> {
    static void zza(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, (Parcelable) invitationEntity.getGame(), i, false);
        zzb.zzc(parcel, 1000, invitationEntity.getVersionCode());
        zzb.zza(parcel, 2, invitationEntity.getInvitationId(), false);
        zzb.zza(parcel, 3, invitationEntity.getCreationTimestamp());
        zzb.zzc(parcel, 4, invitationEntity.getInvitationType());
        zzb.zza(parcel, 5, (Parcelable) invitationEntity.getInviter(), i, false);
        zzb.zzc(parcel, 6, invitationEntity.getParticipants(), false);
        zzb.zzc(parcel, 7, invitationEntity.getVariant());
        zzb.zzc(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzer */
    public InvitationEntity createFromParcel(Parcel parcel) {
        ArrayList arrayListZzc = null;
        int iZzg = 0;
        int iZzau = zza.zzau(parcel);
        long jZzi = 0;
        int iZzg2 = 0;
        ParticipantEntity participantEntity = null;
        int iZzg3 = 0;
        String strZzp = null;
        GameEntity gameEntity = null;
        int iZzg4 = 0;
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
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) zza.zza(parcel, iZzat, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayListZzc = zza.zzc(parcel, iZzat, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 8:
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
        return new InvitationEntity(iZzg4, gameEntity, strZzp, jZzi, iZzg3, participantEntity, arrayListZzc, iZzg2, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgH, reason: merged with bridge method [inline-methods] */
    public InvitationEntity[] newArray(int i) {
        return new InvitationEntity[i];
    }
}
