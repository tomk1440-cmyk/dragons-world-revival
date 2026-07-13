package com.google.android.gms.internal;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzrr {
    private final Context mContext;
    private String zzbio;
    private final zzrt zzbmf;
    Map<String, Object<zzrs.zzc>> zzbmg;
    private final Map<String, Object> zzbmh;
    private final zzmq zzqW;

    public zzrr(Context context) {
        this(context, new HashMap(), new zzrt(context), zzmt.zzsc());
    }

    zzrr(Context context, Map<String, Object> map, zzrt zzrtVar, zzmq zzmqVar) {
        this.zzbio = null;
        this.zzbmg = new HashMap();
        this.mContext = context;
        this.zzqW = zzmqVar;
        this.zzbmf = zzrtVar;
        this.zzbmh = map;
    }

    public void zzgB(String str) {
        this.zzbio = str;
    }
}
