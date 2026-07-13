package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppContentCardEntityCreator implements Parcelable.Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentCardEntity.getVersionCode());
        zzb.zzc(parcel, 2, appContentCardEntity.zzwa(), false);
        zzb.zzc(parcel, 3, appContentCardEntity.zzvP(), false);
        zzb.zza(parcel, 4, appContentCardEntity.zzvQ(), false);
        zzb.zzc(parcel, 5, appContentCardEntity.zzwb());
        zzb.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzb.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzb.zza(parcel, 10, appContentCardEntity.zzwc(), false);
        zzb.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzb.zzc(parcel, 12, appContentCardEntity.zzwd());
        zzb.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzb.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeh, reason: merged with bridge method [inline-methods] */
    public AppContentCardEntity createFromParcel(Parcel parcel) {
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        ArrayList arrayListZzc3 = null;
        String strZzp = null;
        int iZzg2 = 0;
        String strZzp2 = null;
        Bundle bundleZzr = null;
        String strZzp3 = null;
        String strZzp4 = null;
        int iZzg3 = 0;
        String strZzp5 = null;
        String strZzp6 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    arrayListZzc = zza.zzc(parcel, iZzat, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayListZzc2 = zza.zzc(parcel, iZzat, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayListZzc3 = zza.zzc(parcel, iZzat, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 6:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 10:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 11:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 12:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                case 13:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 14:
                    strZzp6 = zza.zzp(parcel, iZzat);
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
        return new AppContentCardEntity(iZzg, arrayListZzc, arrayListZzc2, arrayListZzc3, strZzp, iZzg2, strZzp2, bundleZzr, strZzp3, strZzp4, iZzg3, strZzp5, strZzp6);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgj, reason: merged with bridge method [inline-methods] */
    public AppContentCardEntity[] newArray(int i) {
        return new AppContentCardEntity[i];
    }
}
