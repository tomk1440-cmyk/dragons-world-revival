package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class VideoEntityCreator implements Parcelable.Creator<VideoEntity> {
    static void zza(VideoEntity videoEntity, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, videoEntity.getDuration());
        zzb.zzc(parcel, 1000, videoEntity.getVersionCode());
        zzb.zza(parcel, 2, videoEntity.zzxX(), false);
        zzb.zza(parcel, 3, videoEntity.getFileSize());
        zzb.zza(parcel, 4, videoEntity.getStartTime());
        zzb.zza(parcel, 5, videoEntity.getPackageName(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeH, reason: merged with bridge method [inline-methods] */
    public VideoEntity createFromParcel(Parcel parcel) {
        long jZzi = 0;
        String strZzp = null;
        int iZzg = 0;
        int iZzau = zza.zzau(parcel);
        long jZzi2 = 0;
        String strZzp2 = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 3:
                    jZzi2 = zza.zzi(parcel, iZzat);
                    break;
                case 4:
                    jZzi = zza.zzi(parcel, iZzat);
                    break;
                case 5:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 1000:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new VideoEntity(iZzg2, iZzg, strZzp2, jZzi2, jZzi, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhc, reason: merged with bridge method [inline-methods] */
    public VideoEntity[] newArray(int i) {
        return new VideoEntity[i];
    }
}
