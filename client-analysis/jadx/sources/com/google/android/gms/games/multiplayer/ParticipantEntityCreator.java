package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;

/* JADX INFO: loaded from: classes.dex */
public class ParticipantEntityCreator implements Parcelable.Creator<ParticipantEntity> {
    static void zza(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, participantEntity.getParticipantId(), false);
        zzb.zzc(parcel, 1000, participantEntity.getVersionCode());
        zzb.zza(parcel, 2, participantEntity.getDisplayName(), false);
        zzb.zza(parcel, 3, (Parcelable) participantEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 4, (Parcelable) participantEntity.getHiResImageUri(), i, false);
        zzb.zzc(parcel, 5, participantEntity.getStatus());
        zzb.zza(parcel, 6, participantEntity.zzwt(), false);
        zzb.zza(parcel, 7, participantEntity.isConnectedToRoom());
        zzb.zza(parcel, 8, (Parcelable) participantEntity.getPlayer(), i, false);
        zzb.zzc(parcel, 9, participantEntity.getCapabilities());
        zzb.zza(parcel, 10, (Parcelable) participantEntity.getResult(), i, false);
        zzb.zza(parcel, 11, participantEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 12, participantEntity.getHiResImageUrl(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzes */
    public ParticipantEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int iZzg2 = 0;
        String strZzp3 = null;
        boolean zZzc = false;
        PlayerEntity playerEntity = null;
        int iZzg3 = 0;
        ParticipantResult participantResult = null;
        String strZzp4 = null;
        String strZzp5 = null;
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
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) zza.zza(parcel, iZzat, PlayerEntity.CREATOR);
                    break;
                case 9:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 10:
                    participantResult = (ParticipantResult) zza.zza(parcel, iZzat, ParticipantResult.CREATOR);
                    break;
                case 11:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 12:
                    strZzp5 = zza.zzp(parcel, iZzat);
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
        return new ParticipantEntity(iZzg, strZzp, strZzp2, uri, uri2, iZzg2, strZzp3, zZzc, playerEntity, iZzg3, participantResult, strZzp4, strZzp5);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgI, reason: merged with bridge method [inline-methods] */
    public ParticipantEntity[] newArray(int i) {
        return new ParticipantEntity[i];
    }
}
