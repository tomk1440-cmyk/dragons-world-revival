package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes.dex */
public class zzs implements Parcelable.Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, subscribeRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, subscribeRequest.zzEH(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) subscribeRequest.zzbcU, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, subscribeRequest.zzED(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) subscribeRequest.zzbcZ, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) subscribeRequest.zzbda, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, subscribeRequest.zzbdb);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, subscribeRequest.zzbbF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, subscribeRequest.zzbco, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, subscribeRequest.zzbdc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, subscribeRequest.zzbbG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, subscribeRequest.zzEI(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, subscribeRequest.zzbbH);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, (Parcelable) subscribeRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgn, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        IBinder iBinderZzq = null;
        Strategy strategy = null;
        IBinder iBinderZzq2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        int iZzg2 = 0;
        String strZzp = null;
        String strZzp2 = null;
        byte[] bArrZzs = null;
        boolean zZzc = false;
        IBinder iBinderZzq3 = null;
        boolean zZzc2 = false;
        ClientAppContext clientAppContext = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 3:
                    strategy = (Strategy) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 5:
                    messageFilter = (MessageFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, PendingIntent.CREATOR);
                    break;
                case 7:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 8:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 10:
                    bArrZzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, iZzat);
                    break;
                case 11:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 12:
                    iBinderZzq3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 13:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ClientAppContext.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new SubscribeRequest(iZzg, iBinderZzq, strategy, iBinderZzq2, messageFilter, pendingIntent, iZzg2, strZzp, strZzp2, bArrZzs, zZzc, iBinderZzq3, zZzc2, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjt, reason: merged with bridge method [inline-methods] */
    public SubscribeRequest[] newArray(int i) {
        return new SubscribeRequest[i];
    }
}
