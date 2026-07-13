package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzbi implements Parcelable.Creator<OnStartStreamSession> {
    static void zza(OnStartStreamSession onStartStreamSession, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onStartStreamSession.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) onStartStreamSession.zzasv, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, onStartStreamSession.zzasw, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, onStartStreamSession.zzsU, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbL, reason: merged with bridge method [inline-methods] */
    public OnStartStreamSession createFromParcel(Parcel parcel) {
        String strZzp;
        IBinder iBinderZzq;
        ParcelFileDescriptor parcelFileDescriptor;
        int iZzg;
        String str = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    String str2 = str;
                    iBinderZzq = iBinder;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    strZzp = str2;
                    break;
                case 2:
                    iZzg = i;
                    IBinder iBinder2 = iBinder;
                    parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ParcelFileDescriptor.CREATOR);
                    strZzp = str;
                    iBinderZzq = iBinder2;
                    break;
                case 3:
                    parcelFileDescriptor = parcelFileDescriptor2;
                    iZzg = i;
                    String str3 = str;
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    strZzp = str3;
                    break;
                case 4:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    iBinderZzq = iBinder;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    iZzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    strZzp = str;
                    iBinderZzq = iBinder;
                    parcelFileDescriptor = parcelFileDescriptor2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            parcelFileDescriptor2 = parcelFileDescriptor;
            iBinder = iBinderZzq;
            str = strZzp;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OnStartStreamSession(i, parcelFileDescriptor2, iBinder, str);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdG, reason: merged with bridge method [inline-methods] */
    public OnStartStreamSession[] newArray(int i) {
        return new OnStartStreamSession[i];
    }
}
