package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class VideoConfigurationCreator implements Parcelable.Creator<VideoConfiguration> {
    static void zza(VideoConfiguration videoConfiguration, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, videoConfiguration.zzyd());
        zzb.zzc(parcel, 1000, videoConfiguration.getVersionCode());
        zzb.zzc(parcel, 2, videoConfiguration.zzye());
        zzb.zza(parcel, 3, videoConfiguration.getStreamUrl(), false);
        zzb.zza(parcel, 4, videoConfiguration.zzyf(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeG, reason: merged with bridge method [inline-methods] */
    public VideoConfiguration createFromParcel(Parcel parcel) {
        String strZzp = null;
        int iZzg = 0;
        int iZzau = zza.zzau(parcel);
        String strZzp2 = null;
        int iZzg2 = 0;
        int iZzg3 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg = zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    strZzp2 = zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp = zza.zzp(parcel, iZzat);
                    break;
                case 1000:
                    iZzg3 = zza.zzg(parcel, iZzat);
                    break;
                default:
                    zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new VideoConfiguration(iZzg3, iZzg2, iZzg, strZzp2, strZzp);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzhb, reason: merged with bridge method [inline-methods] */
    public VideoConfiguration[] newArray(int i) {
        return new VideoConfiguration[i];
    }
}
