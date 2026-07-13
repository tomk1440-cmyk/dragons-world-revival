package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

/* JADX INFO: loaded from: classes.dex */
public class VideoCapabilitiesCreator implements Parcelable.Creator<VideoCapabilities> {
    static void zza(VideoCapabilities videoCapabilities, Parcel parcel, int i) {
        int iZzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, videoCapabilities.zzxZ());
        zzb.zzc(parcel, 1000, videoCapabilities.getVersionCode());
        zzb.zza(parcel, 2, videoCapabilities.zzxY());
        zzb.zza(parcel, 3, videoCapabilities.zzya());
        zzb.zza(parcel, 4, videoCapabilities.zzyb(), false);
        zzb.zza(parcel, 5, videoCapabilities.zzyc(), false);
        zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzeF, reason: merged with bridge method [inline-methods] */
    public VideoCapabilities createFromParcel(Parcel parcel) {
        boolean[] zArrZzu = null;
        boolean zZzc = false;
        int iZzau = zza.zzau(parcel);
        boolean[] zArrZzu2 = null;
        boolean zZzc2 = false;
        boolean zZzc3 = false;
        int iZzg = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = zza.zzat(parcel);
            switch (zza.zzca(iZzat)) {
                case 1:
                    zZzc3 = zza.zzc(parcel, iZzat);
                    break;
                case 2:
                    zZzc2 = zza.zzc(parcel, iZzat);
                    break;
                case 3:
                    zZzc = zza.zzc(parcel, iZzat);
                    break;
                case 4:
                    zArrZzu2 = zza.zzu(parcel, iZzat);
                    break;
                case 5:
                    zArrZzu = zza.zzu(parcel, iZzat);
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
        return new VideoCapabilities(iZzg, zZzc3, zZzc2, zZzc, zArrZzu2, zArrZzu);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzgY, reason: merged with bridge method [inline-methods] */
    public VideoCapabilities[] newArray(int i) {
        return new VideoCapabilities[i];
    }
}
