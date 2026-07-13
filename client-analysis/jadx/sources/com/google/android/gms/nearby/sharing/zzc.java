package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<SharedContent> {
    static void zza(SharedContent sharedContent, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sharedContent.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, sharedContent.getUri(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable[]) sharedContent.zzEL(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable[]) sharedContent.zzEM(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgs, reason: merged with bridge method [inline-methods] */
    public SharedContent createFromParcel(Parcel parcel) {
        LocalContent[] localContentArr;
        ViewableItem[] viewableItemArr;
        String strZzp;
        int iZzg;
        LocalContent[] localContentArr2 = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        ViewableItem[] viewableItemArr2 = null;
        String str = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    LocalContent[] localContentArr3 = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    strZzp = str;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    localContentArr = localContentArr3;
                    break;
                case 2:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr2;
                    strZzp = str;
                    iZzg = i;
                    break;
                case 3:
                    iZzg = i;
                    ViewableItem[] viewableItemArr3 = viewableItemArr2;
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    localContentArr = localContentArr2;
                    viewableItemArr = viewableItemArr3;
                    break;
                case 8:
                    strZzp = str;
                    iZzg = i;
                    LocalContent[] localContentArr4 = localContentArr2;
                    viewableItemArr = (ViewableItem[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, ViewableItem.CREATOR);
                    localContentArr = localContentArr4;
                    break;
                case 9:
                    localContentArr = (LocalContent[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, LocalContent.CREATOR);
                    viewableItemArr = viewableItemArr2;
                    strZzp = str;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            str = strZzp;
            viewableItemArr2 = viewableItemArr;
            localContentArr2 = localContentArr;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SharedContent(i, str, viewableItemArr2, localContentArr2);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjy, reason: merged with bridge method [inline-methods] */
    public SharedContent[] newArray(int i) {
        return new SharedContent[i];
    }
}
