package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<PersonEntity.CoverEntity> {
    static void zza(PersonEntity.CoverEntity coverEntity, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        Set<Integer> set = coverEntity.zzbeN;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, coverEntity.mVersionCode);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) coverEntity.zzbgg, i, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) coverEntity.zzbgh, i, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, coverEntity.zzbgi);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgG, reason: merged with bridge method [inline-methods] */
    public PersonEntity.CoverEntity createFromParcel(Parcel parcel) {
        PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity = null;
        int iZzg = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        PersonEntity.CoverEntity.CoverInfoEntity coverInfoEntity = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(1);
                    break;
                case 2:
                    PersonEntity.CoverEntity.CoverInfoEntity coverInfoEntity2 = (PersonEntity.CoverEntity.CoverInfoEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PersonEntity.CoverEntity.CoverInfoEntity.CREATOR);
                    hashSet.add(2);
                    coverInfoEntity = coverInfoEntity2;
                    break;
                case 3:
                    PersonEntity.CoverEntity.CoverPhotoEntity coverPhotoEntity2 = (PersonEntity.CoverEntity.CoverPhotoEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PersonEntity.CoverEntity.CoverPhotoEntity.CREATOR);
                    hashSet.add(3);
                    coverPhotoEntity = coverPhotoEntity2;
                    break;
                case 4:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(4);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PersonEntity.CoverEntity(hashSet, iZzg2, coverInfoEntity, coverPhotoEntity, iZzg);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjN, reason: merged with bridge method [inline-methods] */
    public PersonEntity.CoverEntity[] newArray(int i) {
        return new PersonEntity.CoverEntity[i];
    }
}
