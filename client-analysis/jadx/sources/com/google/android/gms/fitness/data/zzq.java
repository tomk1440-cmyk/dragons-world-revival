package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class zzq implements Parcelable.Creator<Session> {
    static void zza(Session session, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, session.zzlO());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, session.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, session.zzud());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, session.getName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, session.getIdentifier(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, session.getDescription(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 7, session.zzub());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, (Parcelable) session.zzum(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, session.zzuw(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdb, reason: merged with bridge method [inline-methods] */
    public Session createFromParcel(Parcel parcel) {
        long jZzi = 0;
        int iZzg = 0;
        Long lZzj = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Application application = null;
        String strZzp = null;
        String strZzp2 = null;
        String strZzp3 = null;
        long jZzi2 = 0;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    jZzi2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 2:
                    jZzi = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, iZzat);
                    break;
                case 3:
                    strZzp3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 4:
                    strZzp2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 5:
                    strZzp = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, iZzat);
                    break;
                case 7:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 8:
                    application = (Application) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, Application.CREATOR);
                    break;
                case 9:
                    lZzj = com.google.android.gms.common.internal.safeparcel.zza.zzj(parcel, iZzat);
                    break;
                case 1000:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new Session(iZzg2, jZzi2, jZzi, strZzp3, strZzp2, strZzp, iZzg, application, lZzj);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzfb, reason: merged with bridge method [inline-methods] */
    public Session[] newArray(int i) {
        return new Session[i];
    }
}
