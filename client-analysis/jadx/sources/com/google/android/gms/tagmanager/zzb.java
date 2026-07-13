package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzb extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ADVERTISER_ID.toString();
    private final zza zzbhC;

    public zzb(Context context) {
        this(zza.zzaW(context));
    }

    zzb(zza zzaVar) {
        super(ID, new String[0]);
        this.zzbhC = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String strZzFQ = this.zzbhC.zzFQ();
        return strZzFQ == null ? zzdf.zzHF() : zzdf.zzR(strZzFQ);
    }
}
