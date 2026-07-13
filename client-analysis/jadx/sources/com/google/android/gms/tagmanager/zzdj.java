package com.google.android.gms.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes.dex */
class zzdj {
    private static zzbw<com.google.android.gms.internal.zzag.zza> zza(zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar) {
        try {
            return new zzbw<>(zzdf.zzR(zzgA(zzdf.zzg(zzbwVar.getObject()))), zzbwVar.zzGP());
        } catch (UnsupportedEncodingException e) {
            zzbg.zzb("Escape URI: unsupported encoding", e);
            return zzbwVar;
        }
    }

    private static zzbw<com.google.android.gms.internal.zzag.zza> zza(zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar, int i) {
        if (!zzn(zzbwVar.getObject())) {
            zzbg.e("Escaping can only be applied to strings.");
            return zzbwVar;
        }
        switch (i) {
            case 12:
                return zza(zzbwVar);
            default:
                zzbg.e("Unsupported Value Escaping: " + i);
                return zzbwVar;
        }
    }

    static zzbw<com.google.android.gms.internal.zzag.zza> zza(zzbw<com.google.android.gms.internal.zzag.zza> zzbwVar, int... iArr) {
        for (int i : iArr) {
            zzbwVar = zza(zzbwVar, i);
        }
        return zzbwVar;
    }

    static String zzgA(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean zzn(com.google.android.gms.internal.zzag.zza zzaVar) {
        return zzdf.zzl(zzaVar) instanceof String;
    }
}
