package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzaw extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.INSTALL_REFERRER.toString();
    private static final String zzbhD = com.google.android.gms.internal.zzae.COMPONENT.toString();
    private final Context context;

    public zzaw(Context context) {
        super(ID, new String[0]);
        this.context = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String strZzm = zzax.zzm(this.context, map.get(zzbhD) != null ? zzdf.zzg(map.get(zzbhD)) : null);
        return strZzm != null ? zzdf.zzR(strZzm) : zzdf.zzHF();
    }
}
