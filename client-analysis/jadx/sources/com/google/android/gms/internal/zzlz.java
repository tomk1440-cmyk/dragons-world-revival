package com.google.android.gms.internal;

import android.os.Binder;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzlz<T> {
    private T zzSC = null;
    protected final String zzvs;
    protected final T zzvt;
    private static final Object zzqy = new Object();
    private static zza zzaiV = null;
    private static int zzaiW = 0;
    private static String zzaiX = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzlz(String str, T t) {
        this.zzvs = str;
        this.zzvt = t;
    }

    public static boolean isInitialized() {
        return zzaiV != null;
    }

    public static zzlz<Float> zza(String str, Float f) {
        return new zzlz<Float>(str, f) { // from class: com.google.android.gms.internal.zzlz.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* JADX INFO: renamed from: zzcx, reason: merged with bridge method [inline-methods] */
            public Float zzct(String str2) {
                return zzlz.zzaiV.zzb(this.zzvs, (Float) this.zzvt);
            }
        };
    }

    public static zzlz<Integer> zza(String str, Integer num) {
        return new zzlz<Integer>(str, num) { // from class: com.google.android.gms.internal.zzlz.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* JADX INFO: renamed from: zzcw, reason: merged with bridge method [inline-methods] */
            public Integer zzct(String str2) {
                return zzlz.zzaiV.zzb(this.zzvs, (Integer) this.zzvt);
            }
        };
    }

    public static zzlz<Long> zza(String str, Long l) {
        return new zzlz<Long>(str, l) { // from class: com.google.android.gms.internal.zzlz.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* JADX INFO: renamed from: zzcv, reason: merged with bridge method [inline-methods] */
            public Long zzct(String str2) {
                return zzlz.zzaiV.getLong(this.zzvs, (Long) this.zzvt);
            }
        };
    }

    public static zzlz<Boolean> zzk(String str, boolean z) {
        return new zzlz<Boolean>(str, Boolean.valueOf(z)) { // from class: com.google.android.gms.internal.zzlz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* JADX INFO: renamed from: zzcu, reason: merged with bridge method [inline-methods] */
            public Boolean zzct(String str2) {
                return zzlz.zzaiV.zza(this.zzvs, (Boolean) this.zzvt);
            }
        };
    }

    public static int zzpW() {
        return zzaiW;
    }

    public static zzlz<String> zzv(String str, String str2) {
        return new zzlz<String>(str, str2) { // from class: com.google.android.gms.internal.zzlz.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzlz
            /* JADX INFO: renamed from: zzcy, reason: merged with bridge method [inline-methods] */
            public String zzct(String str3) {
                return zzlz.zzaiV.getString(this.zzvs, (String) this.zzvt);
            }
        };
    }

    public final T get() {
        return this.zzSC != null ? this.zzSC : zzct(this.zzvs);
    }

    protected abstract T zzct(String str);

    public final T zzpX() {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return get();
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
