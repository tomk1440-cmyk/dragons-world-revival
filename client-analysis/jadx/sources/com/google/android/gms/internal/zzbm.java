package com.google.android.gms.internal;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzbm {
    private String zzvq;

    public zzbm() {
        this(zzbt.zzvB.zzdq());
    }

    public zzbm(String str) {
        this.zzvq = TextUtils.isEmpty(str) ? zzbt.zzvB.zzdq() : str;
    }

    public String zzdp() {
        return this.zzvq;
    }
}
