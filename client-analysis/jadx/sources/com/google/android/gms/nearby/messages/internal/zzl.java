package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.messages.Message;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements Parcelable.Creator<MessageWrapper> {
    static void zza(MessageWrapper messageWrapper, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) messageWrapper.zzbcu, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, messageWrapper.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgk, reason: merged with bridge method [inline-methods] */
    public MessageWrapper createFromParcel(Parcel parcel) {
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int iZzg = 0;
        Message message = null;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    message = (Message) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Message.CREATOR);
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
        return new MessageWrapper(iZzg, message);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzjp, reason: merged with bridge method [inline-methods] */
    public MessageWrapper[] newArray(int i) {
        return new MessageWrapper[i];
    }
}
