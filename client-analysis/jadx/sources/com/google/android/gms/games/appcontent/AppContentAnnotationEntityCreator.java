package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class AppContentAnnotationEntityCreator implements Parcelable.Creator<AppContentAnnotationEntity> {
    static void zza(AppContentAnnotationEntity appContentAnnotationEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, appContentAnnotationEntity.getDescription(), false);
        zzb.zzc(parcel, 1000, appContentAnnotationEntity.getVersionCode());
        zzb.zza(parcel, 2, (Parcelable) appContentAnnotationEntity.zzvV(), i, false);
        zzb.zza(parcel, 3, appContentAnnotationEntity.getTitle(), false);
        zzb.zza(parcel, 5, appContentAnnotationEntity.getId(), false);
        zzb.zza(parcel, 6, appContentAnnotationEntity.zzvY(), false);
        zzb.zza(parcel, 7, appContentAnnotationEntity.zzvT(), false);
        zzb.zzc(parcel, 8, appContentAnnotationEntity.zzvU());
        zzb.zzc(parcel, 9, appContentAnnotationEntity.zzvX());
        zzb.zza(parcel, 10, appContentAnnotationEntity.zzvW(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeg, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity createFromParcel(Parcel parcel) {
        int iZzg = 0;
        Bundle bundleZzr = null;
        int iZzau = zza.zzau(parcel);
        int iZzg2 = 0;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        Uri uri = null;
        String strZzp5 = null;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 3:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 9:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                case 10:
                    bundleZzr = zza.zzr(parcel, iZzat);
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
        return new AppContentAnnotationEntity(iZzg3, strZzp5, uri, strZzp4, strZzp3, strZzp2, strZzp, iZzg2, iZzg, bundleZzr);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgi, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotationEntity[] newArray(int i) {
        return new AppContentAnnotationEntity[i];
    }
}
