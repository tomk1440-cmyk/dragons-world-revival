package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppContentActionEntityCreator implements Parcelable.Creator<AppContentActionEntity> {
    static void zza(AppContentActionEntity appContentActionEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appContentActionEntity.zzvP(), false);
        zzb.zzc(parcel, 1000, appContentActionEntity.getVersionCode());
        zzb.zza(parcel, 2, appContentActionEntity.zzvQ(), false);
        zzb.zza(parcel, 3, appContentActionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentActionEntity.getType(), false);
        zzb.zza(parcel, 7, appContentActionEntity.getId(), false);
        zzb.zza(parcel, 8, (Parcelable) appContentActionEntity.zzvO(), i, false);
        zzb.zza(parcel, 9, appContentActionEntity.zzvR(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzef, reason: merged with bridge method [inline-methods] */
    public AppContentActionEntity createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        AppContentAnnotationEntity appContentAnnotationEntity = null;
        String strZzp2 = null;
        String strZzp3 = null;
        Bundle bundleZzr = null;
        String strZzp4 = null;
        ArrayList arrayListZzc = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    arrayListZzc = zza.zzc(parcel, iZzat, AppContentConditionEntity.CREATOR);
                    break;
                case 2:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 6:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    appContentAnnotationEntity = (AppContentAnnotationEntity) zza.zza(parcel, iZzat, AppContentAnnotationEntity.CREATOR);
                    break;
                case 9:
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
        return new AppContentActionEntity(iZzg, arrayListZzc, strZzp4, bundleZzr, strZzp3, strZzp2, appContentAnnotationEntity, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgh, reason: merged with bridge method [inline-methods] */
    public AppContentActionEntity[] newArray(int i) {
        return new AppContentActionEntity[i];
    }
}
