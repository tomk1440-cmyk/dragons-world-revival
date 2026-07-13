package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class MilestoneEntityCreator implements Parcelable.Creator<MilestoneEntity> {
    static void zza(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, milestoneEntity.getMilestoneId(), false);
        zzb.zzc(parcel, 1000, milestoneEntity.getVersionCode());
        zzb.zza(parcel, 2, milestoneEntity.getCurrentProgress());
        zzb.zza(parcel, 3, milestoneEntity.getTargetProgress());
        zzb.zza(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        zzb.zzc(parcel, 5, milestoneEntity.getState());
        zzb.zza(parcel, 6, milestoneEntity.getEventId(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzex, reason: merged with bridge method [inline-methods] */
    public MilestoneEntity createFromParcel(Parcel parcel) {
        long jZzi = 0;
        int iZzg = 0;
        String strZzp = null;
        int iZzau = zza.zzau(parcel);
        byte[] bArrZzs = null;
        long jZzi2 = 0;
        String strZzp2 = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    bArrZzs = zza.zzs(parcel, iZzat);
                    break;
                case 5:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 1000:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new MilestoneEntity(iZzg2, strZzp2, jZzi2, jZzi, bArrZzs, iZzg, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgN, reason: merged with bridge method [inline-methods] */
    public MilestoneEntity[] newArray(int i) {
        return new MilestoneEntity[i];
    }
}
