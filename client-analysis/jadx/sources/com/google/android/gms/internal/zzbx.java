package com.google.android.gms.internal;

import android.support.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbx {
    @Nullable
    public static zzbz zza(@Nullable zzcb zzcbVar, long j) {
        if (zzcbVar == null) {
            return null;
        }
        return zzcbVar.zzb(j);
    }

    public static boolean zza(@Nullable zzcb zzcbVar, @Nullable zzbz zzbzVar, long j, String... strArr) {
        if (zzcbVar == null || zzbzVar == null) {
            return false;
        }
        return zzcbVar.zza(zzbzVar, j, strArr);
    }

    public static boolean zza(@Nullable zzcb zzcbVar, @Nullable zzbz zzbzVar, String... strArr) {
        if (zzcbVar == null || zzbzVar == null) {
            return false;
        }
        return zzcbVar.zza(zzbzVar, strArr);
    }

    @Nullable
    public static zzbz zzb(@Nullable zzcb zzcbVar) {
        if (zzcbVar == null) {
            return null;
        }
        return zzcbVar.zzdB();
    }
}
