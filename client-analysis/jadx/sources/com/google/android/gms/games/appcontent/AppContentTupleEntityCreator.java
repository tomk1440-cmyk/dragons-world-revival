package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class AppContentTupleEntityCreator implements Parcelable.Creator<AppContentTupleEntity> {
    static void zza(AppContentTupleEntity appContentTupleEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, appContentTupleEntity.getName(), false);
        zzb.zzc(parcel, 1000, appContentTupleEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentTupleEntity.getValue(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzek, reason: merged with bridge method [inline-methods] */
    public AppContentTupleEntity createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
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
        return new AppContentTupleEntity(iZzg, strZzp2, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgm, reason: merged with bridge method [inline-methods] */
    public AppContentTupleEntity[] newArray(int i) {
        return new AppContentTupleEntity[i];
    }
}
