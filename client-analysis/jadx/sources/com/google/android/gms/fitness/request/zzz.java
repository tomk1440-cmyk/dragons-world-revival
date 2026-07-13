package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzz implements Parcelable.Creator<SessionRegistrationRequest> {
    static void zza(SessionRegistrationRequest sessionRegistrationRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) sessionRegistrationRequest.getIntent(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sessionRegistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sessionRegistrationRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, sessionRegistrationRequest.zzvf());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdE, reason: merged with bridge method [inline-methods] */
    public SessionRegistrationRequest createFromParcel(Parcel parcel) {
        int iZzg;
        IBinder iBinderZzq;
        PendingIntent pendingIntent;
        int iZzg2;
        IBinder iBinder = null;
        int i = 0;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        PendingIntent pendingIntent2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = i2;
                    IBinder iBinder2 = iBinder;
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PendingIntent.CREATOR);
                    iZzg = i;
                    iBinderZzq = iBinder2;
                    break;
                case 2:
                    pendingIntent = pendingIntent2;
                    iZzg2 = i2;
                    int i3 = i;
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    iZzg = i3;
                    break;
                case 4:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iBinderZzq = iBinder;
                    pendingIntent = pendingIntent2;
                    iZzg2 = i2;
                    break;
                case 1000:
                    int i4 = i;
                    iBinderZzq = iBinder;
                    pendingIntent = pendingIntent2;
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iZzg = i4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iZzg = i;
                    iBinderZzq = iBinder;
                    pendingIntent = pendingIntent2;
                    iZzg2 = i2;
                    break;
            }
            i2 = iZzg2;
            pendingIntent2 = pendingIntent;
            iBinder = iBinderZzq;
            i = iZzg;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SessionRegistrationRequest(i2, pendingIntent2, iBinder, i);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfF, reason: merged with bridge method [inline-methods] */
    public SessionRegistrationRequest[] newArray(int i) {
        return new SessionRegistrationRequest[i];
    }
}
