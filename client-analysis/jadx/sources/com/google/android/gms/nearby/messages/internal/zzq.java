package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes.dex */
public class zzq implements Parcelable.Creator<PublishRequest> {
    static void zza(PublishRequest publishRequest, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, publishRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) publishRequest.zzbcT, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) publishRequest.zzbcU, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, publishRequest.zzED(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, publishRequest.zzbbF, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, publishRequest.zzbco, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, publishRequest.zzbbG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, publishRequest.zzEF(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, publishRequest.zzbbH);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, (Parcelable) publishRequest.zzbcs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgl, reason: merged with bridge method [inline-methods] */
    public PublishRequest createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        ClientAppContext clientAppContext = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        IBinder iBinderZzq = null;
        boolean zZzc2 = false;
        String strZzp = null;
        String strZzp2 = null;
        IBinder iBinderZzq2 = null;
        Strategy strategy = null;
        MessageWrapper messageWrapper = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, MessageWrapper.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Strategy.CREATOR);
                    break;
                case 4:
                    iBinderZzq2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 5:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    zZzc2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 8:
                    iBinderZzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, iZzat);
                    break;
                case 9:
                    zZzc = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, iZzat);
                    break;
                case 10:
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
        return new PublishRequest(iZzg, messageWrapper, strategy, iBinderZzq2, strZzp2, strZzp, zZzc2, iBinderZzq, zZzc, clientAppContext);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjr, reason: merged with bridge method [inline-methods] */
    public PublishRequest[] newArray(int i) {
        return new PublishRequest[i];
    }
}
