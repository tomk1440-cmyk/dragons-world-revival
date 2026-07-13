package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.location.places.Place;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zza implements Parcelable.Creator<ItemScopeEntity> {
    static void zza(ItemScopeEntity itemScopeEntity, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        Set<Integer> set = itemScopeEntity.zzbeN;
        if (set.contains(1)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, itemScopeEntity.mVersionCode);
        }
        if (set.contains(2)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) itemScopeEntity.zzbeO, i, true);
        }
        if (set.contains(3)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, itemScopeEntity.zzbeP, true);
        }
        if (set.contains(4)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) itemScopeEntity.zzbeQ, i, true);
        }
        if (set.contains(5)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, itemScopeEntity.zzbeR, true);
        }
        if (set.contains(6)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, itemScopeEntity.zzbeS, true);
        }
        if (set.contains(7)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, itemScopeEntity.zzbeT, true);
        }
        if (set.contains(8)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 8, itemScopeEntity.zzbeU, true);
        }
        if (set.contains(9)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 9, itemScopeEntity.zzbeV);
        }
        if (set.contains(10)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, itemScopeEntity.zzbeW, true);
        }
        if (set.contains(11)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, (Parcelable) itemScopeEntity.zzbeX, i, true);
        }
        if (set.contains(12)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 12, itemScopeEntity.zzbeY, true);
        }
        if (set.contains(13)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, itemScopeEntity.zzbeZ, true);
        }
        if (set.contains(14)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, itemScopeEntity.zzbfa, true);
        }
        if (set.contains(15)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) itemScopeEntity.zzbfb, i, true);
        }
        if (set.contains(17)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, itemScopeEntity.zzbfd, true);
        }
        if (set.contains(16)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, itemScopeEntity.zzbfc, true);
        }
        if (set.contains(19)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 19, itemScopeEntity.zzbfe, true);
        }
        if (set.contains(18)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, itemScopeEntity.zztZ, true);
        }
        if (set.contains(21)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 21, itemScopeEntity.zzbfg, true);
        }
        if (set.contains(20)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, itemScopeEntity.zzbff, true);
        }
        if (set.contains(23)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 23, itemScopeEntity.zzaxl, true);
        }
        if (set.contains(22)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 22, itemScopeEntity.zzbfh, true);
        }
        if (set.contains(25)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 25, itemScopeEntity.zzbfj, true);
        }
        if (set.contains(24)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 24, itemScopeEntity.zzbfi, true);
        }
        if (set.contains(27)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 27, itemScopeEntity.zzbfl, true);
        }
        if (set.contains(26)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 26, itemScopeEntity.zzbfk, true);
        }
        if (set.contains(29)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 29, (Parcelable) itemScopeEntity.zzbfn, i, true);
        }
        if (set.contains(28)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 28, itemScopeEntity.zzbfm, true);
        }
        if (set.contains(31)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 31, itemScopeEntity.zzbfp, true);
        }
        if (set.contains(30)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 30, itemScopeEntity.zzbfo, true);
        }
        if (set.contains(34)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 34, (Parcelable) itemScopeEntity.zzbfr, i, true);
        }
        if (set.contains(32)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 32, itemScopeEntity.zzyv, true);
        }
        if (set.contains(33)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 33, itemScopeEntity.zzbfq, true);
        }
        if (set.contains(38)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 38, itemScopeEntity.zzaNG);
        }
        if (set.contains(39)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 39, itemScopeEntity.mName, true);
        }
        if (set.contains(36)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 36, itemScopeEntity.zzaNF);
        }
        if (set.contains(37)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 37, (Parcelable) itemScopeEntity.zzbfs, i, true);
        }
        if (set.contains(42)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 42, itemScopeEntity.zzbfv, true);
        }
        if (set.contains(43)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 43, itemScopeEntity.zzbfw, true);
        }
        if (set.contains(40)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 40, (Parcelable) itemScopeEntity.zzbft, i, true);
        }
        if (set.contains(41)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 41, itemScopeEntity.zzbfu, true);
        }
        if (set.contains(46)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 46, (Parcelable) itemScopeEntity.zzbfz, i, true);
        }
        if (set.contains(47)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 47, itemScopeEntity.zzbfA, true);
        }
        if (set.contains(44)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 44, itemScopeEntity.zzbfx, true);
        }
        if (set.contains(45)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 45, itemScopeEntity.zzbfy, true);
        }
        if (set.contains(51)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 51, itemScopeEntity.zzbfE, true);
        }
        if (set.contains(50)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 50, (Parcelable) itemScopeEntity.zzbfD, i, true);
        }
        if (set.contains(49)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 49, itemScopeEntity.zzbfC, true);
        }
        if (set.contains(48)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 48, itemScopeEntity.zzbfB, true);
        }
        if (set.contains(55)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 55, itemScopeEntity.zzbfG, true);
        }
        if (set.contains(54)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 54, itemScopeEntity.zzF, true);
        }
        if (set.contains(53)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 53, itemScopeEntity.zzJN, true);
        }
        if (set.contains(52)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 52, itemScopeEntity.zzbfF, true);
        }
        if (set.contains(56)) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 56, itemScopeEntity.zzbfH, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgC, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        HashSet hashSet = new HashSet();
        int iZzg = 0;
        ItemScopeEntity itemScopeEntity = null;
        ArrayList<String> arrayListZzD = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        ArrayList arrayListZzc = null;
        int iZzg2 = 0;
        ArrayList arrayListZzc2 = null;
        ItemScopeEntity itemScopeEntity3 = null;
        ArrayList arrayListZzc3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        ItemScopeEntity itemScopeEntity4 = null;
        String strZzp6 = null;
        String strZzp7 = null;
        String strZzp8 = null;
        ArrayList arrayListZzc4 = null;
        String strZzp9 = null;
        String strZzp10 = null;
        String strZzp11 = null;
        String strZzp12 = null;
        String strZzp13 = null;
        String strZzp14 = null;
        String strZzp15 = null;
        String strZzp16 = null;
        String strZzp17 = null;
        ItemScopeEntity itemScopeEntity5 = null;
        String strZzp18 = null;
        String strZzp19 = null;
        String strZzp20 = null;
        String strZzp21 = null;
        ItemScopeEntity itemScopeEntity6 = null;
        double dZzn = 0.0d;
        ItemScopeEntity itemScopeEntity7 = null;
        double dZzn2 = 0.0d;
        String strZzp22 = null;
        ItemScopeEntity itemScopeEntity8 = null;
        ArrayList arrayListZzc5 = null;
        String strZzp23 = null;
        String strZzp24 = null;
        String strZzp25 = null;
        String strZzp26 = null;
        ItemScopeEntity itemScopeEntity9 = null;
        String strZzp27 = null;
        String strZzp28 = null;
        String strZzp29 = null;
        ItemScopeEntity itemScopeEntity10 = null;
        String strZzp30 = null;
        String strZzp31 = null;
        String strZzp32 = null;
        String strZzp33 = null;
        String strZzp34 = null;
        String strZzp35 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(1);
                    break;
                case 2:
                    ItemScopeEntity itemScopeEntity11 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(2);
                    itemScopeEntity = itemScopeEntity11;
                    break;
                case 3:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    hashSet.add(3);
                    break;
                case 4:
                    ItemScopeEntity itemScopeEntity12 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(4);
                    itemScopeEntity2 = itemScopeEntity12;
                    break;
                case 5:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(5);
                    break;
                case 6:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(6);
                    break;
                case 7:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(7);
                    break;
                case 8:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(8);
                    break;
                case 9:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    hashSet.add(9);
                    break;
                case 10:
                    arrayListZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(10);
                    break;
                case 11:
                    ItemScopeEntity itemScopeEntity13 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(11);
                    itemScopeEntity3 = itemScopeEntity13;
                    break;
                case 12:
                    arrayListZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(12);
                    break;
                case 13:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(13);
                    break;
                case 14:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(14);
                    break;
                case 15:
                    ItemScopeEntity itemScopeEntity14 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(15);
                    itemScopeEntity4 = itemScopeEntity14;
                    break;
                case 16:
                    strZzp6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(16);
                    break;
                case 17:
                    strZzp7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(17);
                    break;
                case 18:
                    strZzp8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(18);
                    break;
                case 19:
                    arrayListZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(19);
                    break;
                case 20:
                    strZzp9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(20);
                    break;
                case 21:
                    strZzp10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(21);
                    break;
                case 22:
                    strZzp11 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(22);
                    break;
                case 23:
                    strZzp12 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(23);
                    break;
                case 24:
                    strZzp13 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(24);
                    break;
                case 25:
                    strZzp14 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(25);
                    break;
                case 26:
                    strZzp15 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(26);
                    break;
                case 27:
                    strZzp16 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(27);
                    break;
                case 28:
                    strZzp17 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(28);
                    break;
                case 29:
                    ItemScopeEntity itemScopeEntity15 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(29);
                    itemScopeEntity5 = itemScopeEntity15;
                    break;
                case 30:
                    strZzp18 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(30);
                    break;
                case 31:
                    strZzp19 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(31);
                    break;
                case 32:
                    strZzp20 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(32);
                    break;
                case 33:
                    strZzp21 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(33);
                    break;
                case 34:
                    ItemScopeEntity itemScopeEntity16 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(34);
                    itemScopeEntity6 = itemScopeEntity16;
                    break;
                case 35:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
                case 36:
                    dZzn = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    hashSet.add(36);
                    break;
                case 37:
                    ItemScopeEntity itemScopeEntity17 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(37);
                    itemScopeEntity7 = itemScopeEntity17;
                    break;
                case 38:
                    dZzn2 = com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, iZzat);
                    hashSet.add(38);
                    break;
                case 39:
                    strZzp22 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(39);
                    break;
                case 40:
                    ItemScopeEntity itemScopeEntity18 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(40);
                    itemScopeEntity8 = itemScopeEntity18;
                    break;
                case 41:
                    arrayListZzc5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(41);
                    break;
                case 42:
                    strZzp23 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(42);
                    break;
                case 43:
                    strZzp24 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(43);
                    break;
                case 44:
                    strZzp25 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(44);
                    break;
                case 45:
                    strZzp26 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(45);
                    break;
                case 46:
                    ItemScopeEntity itemScopeEntity19 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(46);
                    itemScopeEntity9 = itemScopeEntity19;
                    break;
                case 47:
                    strZzp27 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(47);
                    break;
                case Place.TYPE_HINDU_TEMPLE /* 48 */:
                    strZzp28 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(48);
                    break;
                case Place.TYPE_HOME_GOODS_STORE /* 49 */:
                    strZzp29 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(49);
                    break;
                case 50:
                    ItemScopeEntity itemScopeEntity20 = (ItemScopeEntity) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ItemScopeEntity.CREATOR);
                    hashSet.add(50);
                    itemScopeEntity10 = itemScopeEntity20;
                    break;
                case Place.TYPE_INSURANCE_AGENCY /* 51 */:
                    strZzp30 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(51);
                    break;
                case Place.TYPE_JEWELRY_STORE /* 52 */:
                    strZzp31 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(52);
                    break;
                case Place.TYPE_LAUNDRY /* 53 */:
                    strZzp32 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(53);
                    break;
                case Place.TYPE_LAWYER /* 54 */:
                    strZzp33 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(54);
                    break;
                case Place.TYPE_LIBRARY /* 55 */:
                    strZzp34 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(55);
                    break;
                case Place.TYPE_LIQUOR_STORE /* 56 */:
                    strZzp35 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    hashSet.add(56);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ItemScopeEntity(hashSet, iZzg, itemScopeEntity, arrayListZzD, itemScopeEntity2, strZzp, strZzp2, strZzp3, arrayListZzc, iZzg2, arrayListZzc2, itemScopeEntity3, arrayListZzc3, strZzp4, strZzp5, itemScopeEntity4, strZzp6, strZzp7, strZzp8, arrayListZzc4, strZzp9, strZzp10, strZzp11, strZzp12, strZzp13, strZzp14, strZzp15, strZzp16, strZzp17, itemScopeEntity5, strZzp18, strZzp19, strZzp20, strZzp21, itemScopeEntity6, dZzn, itemScopeEntity7, dZzn2, strZzp22, itemScopeEntity8, arrayListZzc5, strZzp23, strZzp24, strZzp25, strZzp26, itemScopeEntity9, strZzp27, strZzp28, strZzp29, itemScopeEntity10, strZzp30, strZzp31, strZzp32, strZzp33, strZzp34, strZzp35);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjJ, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity[] newArray(int i) {
        return new ItemScopeEntity[i];
    }
}
