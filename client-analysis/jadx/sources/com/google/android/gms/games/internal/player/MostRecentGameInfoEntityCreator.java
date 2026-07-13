package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class MostRecentGameInfoEntityCreator implements Parcelable.Creator<MostRecentGameInfoEntity> {
    static void zza(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, mostRecentGameInfoEntity.zzxy(), false);
        zzb.zzc(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        zzb.zza(parcel, 2, mostRecentGameInfoEntity.zzxz(), false);
        zzb.zza(parcel, 3, mostRecentGameInfoEntity.zzxA());
        zzb.zza(parcel, 4, (Parcelable) mostRecentGameInfoEntity.zzxB(), i, false);
        zzb.zza(parcel, 5, (Parcelable) mostRecentGameInfoEntity.zzxC(), i, false);
        zzb.zza(parcel, 6, (Parcelable) mostRecentGameInfoEntity.zzxD(), i, false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzep, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfoEntity createFromParcel(Parcel parcel) {
        Uri uri = null;
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        long jZzi = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String strZzp = null;
        String strZzp2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    uri3 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
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
        return new MostRecentGameInfoEntity(iZzg, strZzp2, strZzp, jZzi, uri3, uri2, uri);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgE, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfoEntity[] newArray(int i) {
        return new MostRecentGameInfoEntity[i];
    }
}
