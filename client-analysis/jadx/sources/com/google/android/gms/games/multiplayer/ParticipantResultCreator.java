package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class ParticipantResultCreator implements Parcelable.Creator<ParticipantResult> {
    static void zza(ParticipantResult participantResult, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, participantResult.getParticipantId(), false);
        zzb.zzc(parcel, 1000, participantResult.getVersionCode());
        zzb.zzc(parcel, 2, participantResult.getResult());
        zzb.zzc(parcel, 3, participantResult.getPlacing());
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzet, reason: merged with bridge method [inline-methods] */
    public ParticipantResult createFromParcel(Parcel parcel) {
        int iZzg = 0;
        int iZzau = zza.zzau(parcel);
        String strZzp = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
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
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                case 1000:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ParticipantResult(iZzg3, strZzp, iZzg2, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgJ, reason: merged with bridge method [inline-methods] */
    public ParticipantResult[] newArray(int i) {
        return new ParticipantResult[i];
    }
}
