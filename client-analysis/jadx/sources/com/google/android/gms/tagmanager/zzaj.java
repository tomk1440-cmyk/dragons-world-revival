package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzaj {
    private static void zza(DataLayer dataLayer, com.google.android.gms.internal.zzaf.zzd zzdVar) {
        for (com.google.android.gms.internal.zzag.zza zzaVar : zzdVar.zziD) {
            dataLayer.zzfX(zzdf.zzg(zzaVar));
        }
    }

    public static void zza(DataLayer dataLayer, com.google.android.gms.internal.zzaf.zzi zziVar) {
        if (zziVar.zzjs == null) {
            zzbg.zzaK("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, zziVar.zzjs);
        zzb(dataLayer, zziVar.zzjs);
        zzc(dataLayer, zziVar.zzjs);
    }

    private static void zzb(DataLayer dataLayer, com.google.android.gms.internal.zzaf.zzd zzdVar) {
        for (com.google.android.gms.internal.zzag.zza zzaVar : zzdVar.zziC) {
            Map<String, Object> mapZzc = zzc(zzaVar);
            if (mapZzc != null) {
                dataLayer.push(mapZzc);
            }
        }
    }

    private static Map<String, Object> zzc(com.google.android.gms.internal.zzag.zza zzaVar) {
        Object objZzl = zzdf.zzl(zzaVar);
        if (objZzl instanceof Map) {
            return (Map) objZzl;
        }
        zzbg.zzaK("value: " + objZzl + " is not a map value, ignored.");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    /* JADX WARN: Code duplicated, block: B:29:0x009b  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b3  */
    private static void zzc(DataLayer dataLayer, com.google.android.gms.internal.zzaf.zzd zzdVar) {
        Map<String, Object> mapZzn;
        Object obj;
        for (com.google.android.gms.internal.zzaf.zzc zzcVar : zzdVar.zziE) {
            if (zzcVar.key == null) {
                zzbg.zzaK("GaExperimentRandom: No key");
            } else {
                Object objValueOf = dataLayer.get(zzcVar.key);
                Long lValueOf = !(objValueOf instanceof Number) ? null : Long.valueOf(((Number) objValueOf).longValue());
                long j = zzcVar.zziy;
                long j2 = zzcVar.zziz;
                if (zzcVar.zziA && lValueOf != null && lValueOf.longValue() >= j && lValueOf.longValue() <= j2) {
                    dataLayer.zzfX(zzcVar.key);
                    mapZzn = dataLayer.zzn(zzcVar.key, objValueOf);
                    if (zzcVar.zziB > 0) {
                        if (mapZzn.containsKey("gtm")) {
                            obj = mapZzn.get("gtm");
                            if (obj instanceof Map) {
                                ((Map) obj).put("lifetime", Long.valueOf(zzcVar.zziB));
                            } else {
                                zzbg.zzaK("GaExperimentRandom: gtm not a map");
                            }
                        } else {
                            mapZzn.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzcVar.zziB)));
                        }
                    }
                    dataLayer.push(mapZzn);
                } else if (j <= j2) {
                    objValueOf = Long.valueOf(Math.round((Math.random() * (j2 - j)) + j));
                    dataLayer.zzfX(zzcVar.key);
                    mapZzn = dataLayer.zzn(zzcVar.key, objValueOf);
                    if (zzcVar.zziB > 0) {
                        if (mapZzn.containsKey("gtm")) {
                            mapZzn.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzcVar.zziB)));
                        } else {
                            obj = mapZzn.get("gtm");
                            if (obj instanceof Map) {
                                ((Map) obj).put("lifetime", Long.valueOf(zzcVar.zziB));
                            } else {
                                zzbg.zzaK("GaExperimentRandom: gtm not a map");
                            }
                        }
                    }
                    dataLayer.push(mapZzn);
                } else {
                    zzbg.zzaK("GaExperimentRandom: random range invalid");
                }
            }
        }
    }
}
