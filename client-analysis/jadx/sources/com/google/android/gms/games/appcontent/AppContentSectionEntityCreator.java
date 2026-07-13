package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AppContentSectionEntityCreator implements Parcelable.Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzb.zzc(parcel, 1000, appContentSectionEntity.getVersionCode());
        zzb.zzc(parcel, 3, appContentSectionEntity.zzwk(), false);
        zzb.zza(parcel, 4, appContentSectionEntity.zzvQ(), false);
        zzb.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzb.zza(parcel, 6, appContentSectionEntity.zzwc(), false);
        zzb.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzb.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzb.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzb.zza(parcel, 10, appContentSectionEntity.zzwl(), false);
        zzb.zzc(parcel, 14, appContentSectionEntity.zzwa(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzej, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity createFromParcel(Parcel parcel) {
        ArrayList arrayListZzc = null;
        int iZzau = zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        Bundle bundleZzr = null;
        String strZzp6 = null;
        ArrayList arrayListZzc2 = null;
        ArrayList arrayListZzc3 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    arrayListZzc3 = zza.zzc(parcel, iZzat, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayListZzc2 = zza.zzc(parcel, iZzat, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    strZzp6 = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    bundleZzr = zza.zzr(parcel, iZzat);
                    break;
                case 6:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 10:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 14:
                    arrayListZzc = zza.zzc(parcel, iZzat, AppContentAnnotationEntity.CREATOR);
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
        return new AppContentSectionEntity(iZzg, arrayListZzc3, arrayListZzc2, strZzp6, bundleZzr, strZzp5, strZzp4, strZzp3, strZzp2, strZzp, arrayListZzc);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgl, reason: merged with bridge method [inline-methods] */
    public AppContentSectionEntity[] newArray(int i) {
        return new AppContentSectionEntity[i];
    }
}
