package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class zzc implements Parcelable.Creator<ParcelableEvent> {
    static void zza(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, parcelableEvent.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, parcelableEvent.zzLq, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, parcelableEvent.zzrG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 4, parcelableEvent.zzauR, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, parcelableEvent.zzauS);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, parcelableEvent.zzauL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, parcelableEvent.zzauV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) parcelableEvent.zzauW, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) parcelableEvent.zzauX, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, (Parcelable) parcelableEvent.zzauY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, (Parcelable) parcelableEvent.zzauZ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, (Parcelable) parcelableEvent.zzava, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, (Parcelable) parcelableEvent.zzavb, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, (Parcelable) parcelableEvent.zzavc, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, (Parcelable) parcelableEvent.zzavd, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 17, parcelableEvent.zzauU);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 16, parcelableEvent.zzauT);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 18, (Parcelable) parcelableEvent.zzave, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzcE, reason: merged with bridge method [inline-methods] */
    public ParcelableEvent createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        String strZzp = null;
        String strZzp2 = null;
        ArrayList<String> arrayListZzD = null;
        boolean zZzc = false;
        boolean zZzc2 = false;
        boolean zZzc3 = false;
        String strZzp3 = null;
        String strZzp4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
        ObjectChangedDetails objectChangedDetails = null;
        FieldChangedDetails fieldChangedDetails = null;
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
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    arrayListZzD = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, iZzat);
                    break;
                case 5:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 6:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    strZzp4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 8:
                    textInsertedDetails = (TextInsertedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TextInsertedDetails.CREATOR);
                    break;
                case 9:
                    textDeletedDetails = (TextDeletedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TextDeletedDetails.CREATOR);
                    break;
                case 10:
                    valuesAddedDetails = (ValuesAddedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ValuesAddedDetails.CREATOR);
                    break;
                case 11:
                    valuesRemovedDetails = (ValuesRemovedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ValuesRemovedDetails.CREATOR);
                    break;
                case 12:
                    valuesSetDetails = (ValuesSetDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ValuesSetDetails.CREATOR);
                    break;
                case 13:
                    valueChangedDetails = (ValueChangedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ValueChangedDetails.CREATOR);
                    break;
                case 14:
                    referenceShiftedDetails = (ReferenceShiftedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ReferenceShiftedDetails.CREATOR);
                    break;
                case 15:
                    objectChangedDetails = (ObjectChangedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ObjectChangedDetails.CREATOR);
                    break;
                case 16:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 17:
                    zZzc3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 18:
                    fieldChangedDetails = (FieldChangedDetails) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, FieldChangedDetails.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new ParcelableEvent(iZzg, strZzp, strZzp2, arrayListZzD, zZzc, zZzc2, zZzc3, strZzp3, strZzp4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails, objectChangedDetails, fieldChangedDetails);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeA, reason: merged with bridge method [inline-methods] */
    public ParcelableEvent[] newArray(int i) {
        return new ParcelableEvent[i];
    }
}
