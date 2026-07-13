package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzn implements Parcelable.Creator<LocationRequestUpdateData> {
    static void zza(LocationRequestUpdateData locationRequestUpdateData, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, locationRequestUpdateData.zzaOU);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, locationRequestUpdateData.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) locationRequestUpdateData.zzaOV, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, locationRequestUpdateData.zzyQ(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) locationRequestUpdateData.mPendingIntent, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, locationRequestUpdateData.zzyR(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, locationRequestUpdateData.zzyS(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeY, reason: merged with bridge method [inline-methods] */
    public LocationRequestUpdateData createFromParcel(Parcel parcel) {
        IBinder iBinderZzq = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        int iZzg2 = 1;
        IBinder iBinderZzq2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinderZzq3 = null;
        LocationRequestInternal locationRequestInternal = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    locationRequestInternal = (LocationRequestInternal) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, LocationRequestInternal.CREATOR);
                    break;
                case 3:
                    iBinderZzq3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 6:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
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
        return new LocationRequestUpdateData(iZzg, iZzg2, locationRequestInternal, iBinderZzq3, pendingIntent, iBinderZzq2, iBinderZzq);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhE, reason: merged with bridge method [inline-methods] */
    public LocationRequestUpdateData[] newArray(int i) {
        return new LocationRequestUpdateData[i];
    }
}
