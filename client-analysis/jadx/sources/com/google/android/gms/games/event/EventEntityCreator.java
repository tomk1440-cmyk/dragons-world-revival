package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.games.PlayerEntity;

/* JADX INFO: loaded from: classes.dex */
public class EventEntityCreator implements Parcelable.Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(EventEntity eventEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, eventEntity.getEventId(), false);
        zzb.zzc(parcel, 1000, eventEntity.getVersionCode());
        zzb.zza(parcel, 2, eventEntity.getName(), false);
        zzb.zza(parcel, 3, eventEntity.getDescription(), false);
        zzb.zza(parcel, 4, (Parcelable) eventEntity.getIconImageUri(), i, false);
        zzb.zza(parcel, 5, eventEntity.getIconImageUrl(), false);
        zzb.zza(parcel, 6, (Parcelable) eventEntity.getPlayer(), i, false);
        zzb.zza(parcel, 7, eventEntity.getValue());
        zzb.zza(parcel, 8, eventEntity.getFormattedValue(), false);
        zzb.zza(parcel, 9, eventEntity.isVisible());
        zzb.zzI(parcel, iZzav);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public EventEntity createFromParcel(Parcel parcel) {
        boolean zZzc = false;
        String strZzp = null;
        int iZzau = zza.zzau(parcel);
        long jZzi = 0;
        PlayerEntity playerEntity = null;
        String strZzp2 = null;
        Uri uri = null;
        String strZzp3 = null;
        String strZzp4 = null;
        String strZzp5 = null;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    strZzp5 = zza.zzp(parcel, iZzat);
                    break;
                case 2:
                    strZzp4 = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    strZzp3 = zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, iZzat, Uri.CREATOR);
                    break;
                case 5:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 6:
                    playerEntity = (PlayerEntity) zza.zza(parcel, iZzat, PlayerEntity.CREATOR);
                    break;
                case 7:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 8:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 9:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 1000:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new EventEntity(iZzg, strZzp5, strZzp4, strZzp3, uri, strZzp2, playerEntity, jZzi, strZzp, zZzc);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
