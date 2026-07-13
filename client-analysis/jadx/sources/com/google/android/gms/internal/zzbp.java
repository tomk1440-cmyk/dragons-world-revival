package com.google.android.gms.internal;

import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzbp<T> {
    private final int zzvr;
    private final String zzvs;
    private final T zzvt;

    private zzbp(int i, String str, T t) {
        this.zzvr = i;
        this.zzvs = str;
        this.zzvt = t;
        com.google.android.gms.ads.internal.zzr.zzbK().zza(this);
    }

    public static zzbp<String> zza(int i, String str) {
        zzbp<String> zzbpVarZza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzr.zzbK().zzb(zzbpVarZza);
        return zzbpVarZza;
    }

    public static zzbp<Integer> zza(int i, String str, int i2) {
        return new zzbp<Integer>(i, str, Integer.valueOf(i2)) { // from class: com.google.android.gms.internal.zzbp.2
            @Override // com.google.android.gms.internal.zzbp
            /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public Integer zza(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), zzdq().intValue()));
            }
        };
    }

    public static zzbp<Long> zza(int i, String str, long j) {
        return new zzbp<Long>(i, str, Long.valueOf(j)) { // from class: com.google.android.gms.internal.zzbp.3
            @Override // com.google.android.gms.internal.zzbp
            /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
            public Long zza(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), zzdq().longValue()));
            }
        };
    }

    public static zzbp<Boolean> zza(int i, String str, Boolean bool) {
        return new zzbp<Boolean>(i, str, bool) { // from class: com.google.android.gms.internal.zzbp.1
            @Override // com.google.android.gms.internal.zzbp
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Boolean zza(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zzdq().booleanValue()));
            }
        };
    }

    public static zzbp<String> zza(int i, String str, String str2) {
        return new zzbp<String>(i, str, str2) { // from class: com.google.android.gms.internal.zzbp.4
            @Override // com.google.android.gms.internal.zzbp
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public String zza(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), zzdq());
            }
        };
    }

    public static zzbp<String> zzb(int i, String str) {
        zzbp<String> zzbpVarZza = zza(i, str, (String) null);
        com.google.android.gms.ads.internal.zzr.zzbK().zzc(zzbpVarZza);
        return zzbpVarZza;
    }

    public T get() {
        return (T) com.google.android.gms.ads.internal.zzr.zzbL().zzd(this);
    }

    public String getKey() {
        return this.zzvs;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzdq() {
        return this.zzvt;
    }
}
