package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.fitness.data.Subscription;

/* JADX INFO: loaded from: classes.dex */
public class zzaf implements Parcelable.Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) subscribeRequest.zzvh(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, subscribeRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, subscribeRequest.zzvi());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, subscribeRequest.getCallbackBinder(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdK, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        IBinder iBinderZzq;
        boolean zZzc;
        Subscription subscription;
        int iZzg;
        IBinder iBinder = null;
        boolean z = false;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Subscription subscription2 = null;
        int i = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = i;
                    boolean z2 = z;
                    subscription = (Subscription) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Subscription.CREATOR);
                    iBinderZzq = iBinder;
                    zZzc = z2;
                    break;
                case 2:
                    subscription = subscription2;
                    iZzg = i;
                    IBinder iBinder2 = iBinder;
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    iBinderZzq = iBinder2;
                    break;
                case 3:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    zZzc = z;
                    subscription = subscription2;
                    iZzg = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    zZzc = z;
                    subscription = subscription2;
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    iBinderZzq = iBinder3;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    iBinderZzq = iBinder;
                    zZzc = z;
                    subscription = subscription2;
                    iZzg = i;
                    break;
            }
            i = iZzg;
            subscription2 = subscription;
            z = zZzc;
            iBinder = iBinderZzq;
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SubscribeRequest(i, subscription2, z, iBinder);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfL, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
