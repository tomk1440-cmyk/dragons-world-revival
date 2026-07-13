package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzhr extends com.google.android.gms.ads.internal.reward.client.zza.AbstractBinderC0031zza {
    private final String zzJN;
    private final int zzKt;

    public zzhr(String str, int i) {
        this.zzJN = str;
        this.zzKt = i;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public int getAmount() {
        return this.zzKt;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public String getType() {
        return this.zzJN;
    }
}
