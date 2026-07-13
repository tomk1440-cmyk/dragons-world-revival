package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzhb;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzn {
    private static final Object zzqy = new Object();
    private static zzn zzur;
    private final com.google.android.gms.ads.internal.util.client.zza zzus = new com.google.android.gms.ads.internal.util.client.zza();
    private final zze zzut = new zze();
    private final zzl zzuu = new zzl();
    private final zzaf zzuv = new zzaf();
    private final zzcv zzuw = new zzcv();
    private final com.google.android.gms.ads.internal.reward.client.zzf zzux = new com.google.android.gms.ads.internal.reward.client.zzf();

    static {
        zza(new zzn());
    }

    protected zzn() {
    }

    protected static void zza(zzn zznVar) {
        synchronized (zzqy) {
            zzur = zznVar;
        }
    }

    private static zzn zzcR() {
        zzn zznVar;
        synchronized (zzqy) {
            zznVar = zzur;
        }
        return zznVar;
    }

    public static com.google.android.gms.ads.internal.util.client.zza zzcS() {
        return zzcR().zzus;
    }

    public static zze zzcT() {
        return zzcR().zzut;
    }

    public static zzl zzcU() {
        return zzcR().zzuu;
    }

    public static zzaf zzcV() {
        return zzcR().zzuv;
    }

    public static zzcv zzcW() {
        return zzcR().zzuw;
    }

    public static com.google.android.gms.ads.internal.reward.client.zzf zzcX() {
        return zzcR().zzux;
    }
}
