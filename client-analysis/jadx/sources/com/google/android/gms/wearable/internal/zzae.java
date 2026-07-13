package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzae implements Parcelable.Creator<DataItemParcelable> {
    static void zza(DataItemParcelable dataItemParcelable, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, dataItemParcelable.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) dataItemParcelable.getUri(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, dataItemParcelable.zzIv(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, dataItemParcelable.getData(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzil, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable createFromParcel(Parcel parcel) {
        byte[] bArrZzs;
        Bundle bundleZzr;
        Uri uri;
        int iZzg;
        byte[] bArr = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    byte[] bArr2 = bArr;
                    bundleZzr = bundle;
                    uri = uri2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    bArrZzs = bArr2;
                    break;
                case 2:
                    iZzg = i;
                    Bundle bundle2 = bundle;
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Uri.CREATOR);
                    bArrZzs = bArr;
                    bundleZzr = bundle2;
                    break;
                case 3:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    bArrZzs = bArr;
                    bundleZzr = bundle;
                    uri = uri2;
                    iZzg = i;
                    break;
                case 4:
                    uri = uri2;
                    iZzg = i;
                    byte[] bArr3 = bArr;
                    bundleZzr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, iZzat);
                    bArrZzs = bArr3;
                    break;
                case 5:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    bundleZzr = bundle;
                    uri = uri2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            uri2 = uri;
            bundle = bundleZzr;
            bArr = bArrZzs;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new DataItemParcelable(i, uri2, bundle, bArr);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzlP, reason: merged with bridge method [inline-methods] */
    public DataItemParcelable[] newArray(int i) {
        return new DataItemParcelable[i];
    }
}
