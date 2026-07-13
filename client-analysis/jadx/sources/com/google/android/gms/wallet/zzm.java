package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzm implements Parcelable.Creator<MaskedWalletRequest> {
    static void zza(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, maskedWalletRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, maskedWalletRequest.zzbop, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, maskedWalletRequest.zzbpl);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, maskedWalletRequest.zzbpm);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, maskedWalletRequest.zzbpn);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, maskedWalletRequest.zzbpo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, maskedWalletRequest.zzboi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, maskedWalletRequest.zzbpp, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) maskedWalletRequest.zzboz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, maskedWalletRequest.zzbpq);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, maskedWalletRequest.zzbpr);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, (Parcelable[]) maskedWalletRequest.zzbps, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, maskedWalletRequest.zzbpt);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, maskedWalletRequest.zzbpu);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 15, maskedWalletRequest.zzbpv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, (List<Integer>) maskedWalletRequest.zzbpx, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, (Parcelable) maskedWalletRequest.zzbpw, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhA, reason: merged with bridge method [inline-methods] */
    public MaskedWalletRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        boolean zZzc = false;
        boolean zZzc2 = false;
        boolean zZzc3 = false;
        String strZzp2 = null;
        String strZzp3 = null;
        String strZzp4 = null;
        Cart cart = null;
        boolean zZzc4 = false;
        boolean zZzc5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean zZzc6 = true;
        boolean zZzc7 = true;
        ArrayList arrayListZzc = null;
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = null;
        ArrayList<Integer> arrayListZzC = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 5:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 6:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    cart = (Cart) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Cart.CREATOR);
                    break;
                case 10:
                    zZzc4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 11:
                    zZzc5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat, CountrySpecification.CREATOR);
                    break;
                case 13:
                    zZzc6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 14:
                    zZzc7 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 15:
                    arrayListZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat, com.google.android.gms.identity.intents.model.CountrySpecification.CREATOR);
                    break;
                case 16:
                    paymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                case 17:
                    arrayListZzC = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new MaskedWalletRequest(iZzg, strZzp, zZzc, zZzc2, zZzc3, strZzp2, strZzp3, strZzp4, cart, zZzc4, zZzc5, countrySpecificationArr, zZzc6, zZzc7, arrayListZzc, paymentMethodTokenizationParameters, arrayListZzC);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzkY, reason: merged with bridge method [inline-methods] */
    public MaskedWalletRequest[] newArray(int i) {
        return new MaskedWalletRequest[i];
    }
}
