package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<PersonEntity> {
    static void zza(PersonEntity personEntity, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        Set<Integer> set = personEntity.zzbeN;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, personEntity.mVersionCode);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, personEntity.zzbfL, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) personEntity.zzbfM, i, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, personEntity.zzbfN, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, personEntity.zzbfO, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, personEntity.zzbfP);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) personEntity.zzbfQ, i, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, personEntity.zzbfR, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, personEntity.zzWQ, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, personEntity.zztT);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, personEntity.zzyv, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) personEntity.zzbfS, i, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, personEntity.zzbfT);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 19, (Parcelable) personEntity.zzbfU, i, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, personEntity.zzaaL, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 21, personEntity.zzbfW);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, personEntity.zzbfV, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 23, personEntity.zzbfY, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 22, personEntity.zzbfX, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 25, personEntity.zzbga);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 24, personEntity.zzbfZ);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 27, personEntity.zzF, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, personEntity.zzbgb, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, personEntity.zzbgd);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 28, personEntity.zzbgc, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgE, reason: merged with bridge method [inline-methods] */
    public PersonEntity createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int iZzg = 0;
        String strZzp = null;
        PersonEntity.AgeRangeEntity ageRangeEntity = null;
        String strZzp2 = null;
        String strZzp3 = null;
        int iZzg2 = 0;
        PersonEntity.CoverEntity coverEntity = null;
        String strZzp4 = null;
        String strZzp5 = null;
        int iZzg3 = 0;
        String strZzp6 = null;
        PersonEntity.ImageEntity imageEntity = null;
        boolean zZzc = false;
        String strZzp7 = null;
        PersonEntity.NameEntity nameEntity = null;
        String strZzp8 = null;
        int iZzg4 = 0;
        ArrayList arrayListZzc = null;
        ArrayList arrayListZzc2 = null;
        int iZzg5 = 0;
        int iZzg6 = 0;
        String strZzp9 = null;
        String strZzp10 = null;
        ArrayList arrayListZzc3 = null;
        boolean zZzc2 = false;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(1);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(2);
                    break;
                case 3:
                    PersonEntity.AgeRangeEntity ageRangeEntity2 = (PersonEntity.AgeRangeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PersonEntity.AgeRangeEntity.CREATOR);
                    hashSet.add(3);
                    ageRangeEntity = ageRangeEntity2;
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(4);
                    break;
                case 5:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(5);
                    break;
                case 6:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(6);
                    break;
                case 7:
                    PersonEntity.CoverEntity coverEntity2 = (PersonEntity.CoverEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PersonEntity.CoverEntity.CREATOR);
                    hashSet.add(7);
                    coverEntity = coverEntity2;
                    break;
                case 8:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(8);
                    break;
                case 9:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(9);
                    break;
                case 10:
                case 11:
                case 13:
                case 17:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
                case 12:
                    iZzg3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(12);
                    break;
                case 14:
                    strZzp6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(14);
                    break;
                case 15:
                    PersonEntity.ImageEntity imageEntity2 = (PersonEntity.ImageEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PersonEntity.ImageEntity.CREATOR);
                    hashSet.add(15);
                    imageEntity = imageEntity2;
                    break;
                case 16:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    hashSet.add(16);
                    break;
                case 18:
                    strZzp7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(18);
                    break;
                case 19:
                    PersonEntity.NameEntity nameEntity2 = (PersonEntity.NameEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PersonEntity.NameEntity.CREATOR);
                    hashSet.add(19);
                    nameEntity = nameEntity2;
                    break;
                case 20:
                    strZzp8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(20);
                    break;
                case 21:
                    iZzg4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(21);
                    break;
                case 22:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, PersonEntity.OrganizationsEntity.CREATOR);
                    hashSet.add(22);
                    break;
                case 23:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, PersonEntity.PlacesLivedEntity.CREATOR);
                    hashSet.add(23);
                    break;
                case 24:
                    iZzg5 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(24);
                    break;
                case 25:
                    iZzg6 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(25);
                    break;
                case 26:
                    strZzp9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(26);
                    break;
                case 27:
                    strZzp10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(27);
                    break;
                case 28:
                    arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, PersonEntity.UrlsEntity.CREATOR);
                    hashSet.add(28);
                    break;
                case 29:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    hashSet.add(29);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PersonEntity(hashSet, iZzg, strZzp, ageRangeEntity, strZzp2, strZzp3, iZzg2, coverEntity, strZzp4, strZzp5, iZzg3, strZzp6, imageEntity, zZzc, strZzp7, nameEntity, strZzp8, iZzg4, arrayListZzc, arrayListZzc2, iZzg5, iZzg6, strZzp9, strZzp10, arrayListZzc3, zZzc2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjL, reason: merged with bridge method [inline-methods] */
    public PersonEntity[] newArray(int i) {
        return new PersonEntity[i];
    }
}
