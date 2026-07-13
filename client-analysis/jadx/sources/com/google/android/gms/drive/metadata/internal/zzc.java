package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<CustomProperty> {
    static void zza(CustomProperty customProperty, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, customProperty.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) customProperty.zzasN, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, customProperty.mValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcf, reason: merged with bridge method [inline-methods] */
    public CustomProperty createFromParcel(Parcel parcel) {
        String strZzp;
        CustomPropertyKey customPropertyKey;
        int iZzg;
        String str = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        CustomPropertyKey customPropertyKey2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    String str2 = str;
                    customPropertyKey = customPropertyKey2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    strZzp = str2;
                    break;
                case 2:
                    CustomPropertyKey customPropertyKey3 = (CustomPropertyKey) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, CustomPropertyKey.CREATOR);
                    iZzg = i;
                    strZzp = str;
                    customPropertyKey = customPropertyKey3;
                    break;
                case 3:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    customPropertyKey = customPropertyKey2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    strZzp = str;
                    customPropertyKey = customPropertyKey2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            customPropertyKey2 = customPropertyKey;
            str = strZzp;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new CustomProperty(i, customPropertyKey2, str);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzea, reason: merged with bridge method [inline-methods] */
    public CustomProperty[] newArray(int i) {
        return new CustomProperty[i];
    }
}
