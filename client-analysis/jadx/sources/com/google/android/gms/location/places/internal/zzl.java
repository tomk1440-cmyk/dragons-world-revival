package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator<PlaceImpl> {
    static void zza(PlaceImpl placeImpl, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, placeImpl.getId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, placeImpl.zzzt(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) placeImpl.zzzv(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) placeImpl.getLatLng(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, placeImpl.zzzo());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) placeImpl.getViewport(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, placeImpl.zzzu(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) placeImpl.getWebsiteUri(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, placeImpl.zzzr());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, placeImpl.getRating());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 11, placeImpl.getPriceLevel());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, placeImpl.zzzs());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, placeImpl.zzzn(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, placeImpl.getAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, placeImpl.getPhoneNumber(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 17, placeImpl.zzzq(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, placeImpl.zzzp(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeImpl.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 19, placeImpl.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 20, placeImpl.getPlaceTypes(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfl, reason: merged with bridge method [inline-methods] */
    public PlaceImpl createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        ArrayList<Integer> arrayListZzC = null;
        ArrayList<Integer> arrayListZzC2 = null;
        Bundle bundleZzr = null;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        ArrayList<String> arrayListZzD = null;
        LatLng latLng = null;
        float fZzl = 0.0f;
        LatLngBounds latLngBounds = null;
        String strZzp6 = null;
        Uri uri = null;
        boolean zZzc = false;
        float fZzl2 = 0.0f;
        int iZzg2 = 0;
        long jZzi = 0;
        PlaceLocalization placeLocalization = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    bundleZzr = com.google.android.gms.common.internal.safeparcel.zza.zzr(parcel, iZzat);
                    break;
                case 3:
                    placeLocalization = (PlaceLocalization) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PlaceLocalization.CREATOR);
                    break;
                case 4:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LatLng.CREATOR);
                    break;
                case 5:
                    fZzl = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LatLngBounds.CREATOR);
                    break;
                case 7:
                    strZzp6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 9:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 10:
                    fZzl2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, iZzat);
                    break;
                case 11:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 12:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 13:
                    arrayListZzC2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzat);
                    break;
                case 14:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 15:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 16:
                    strZzp5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 17:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 19:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 20:
                    arrayListZzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new PlaceImpl(iZzg, strZzp, arrayListZzC, arrayListZzC2, bundleZzr, strZzp2, strZzp3, strZzp4, strZzp5, arrayListZzD, latLng, fZzl, latLngBounds, strZzp6, uri, zZzc, fZzl2, iZzg2, jZzi, placeLocalization);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhY, reason: merged with bridge method [inline-methods] */
    public PlaceImpl[] newArray(int i) {
        return new PlaceImpl[i];
    }
}
