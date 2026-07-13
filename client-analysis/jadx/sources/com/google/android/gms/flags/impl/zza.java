package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import com.google.android.gms.internal.zzpl;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza<T> {

    /* JADX INFO: renamed from: com.google.android.gms.flags.impl.zza$zza, reason: collision with other inner class name */
    public static class C0083zza extends zza<Boolean> {
        public static Boolean zza(final SharedPreferences sharedPreferences, final String str, final Boolean bool) {
            return (Boolean) zzpl.zzb(new Callable<Boolean>() { // from class: com.google.android.gms.flags.impl.zza.zza.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzvt, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, bool.booleanValue()));
                }
            });
        }
    }

    public static class zzb extends zza<Integer> {
        public static Integer zza(final SharedPreferences sharedPreferences, final String str, final Integer num) {
            return (Integer) zzpl.zzb(new Callable<Integer>() { // from class: com.google.android.gms.flags.impl.zza.zzb.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzvu, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return Integer.valueOf(sharedPreferences.getInt(str, num.intValue()));
                }
            });
        }
    }

    public static class zzc extends zza<Long> {
        public static Long zza(final SharedPreferences sharedPreferences, final String str, final Long l) {
            return (Long) zzpl.zzb(new Callable<Long>() { // from class: com.google.android.gms.flags.impl.zza.zzc.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzvv, reason: merged with bridge method [inline-methods] */
                public Long call() {
                    return Long.valueOf(sharedPreferences.getLong(str, l.longValue()));
                }
            });
        }
    }

    public static class zzd extends zza<String> {
        public static String zza(final SharedPreferences sharedPreferences, final String str, final String str2) {
            return (String) zzpl.zzb(new Callable<String>() { // from class: com.google.android.gms.flags.impl.zza.zzd.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzkp, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return sharedPreferences.getString(str, str2);
                }
            });
        }
    }
}
