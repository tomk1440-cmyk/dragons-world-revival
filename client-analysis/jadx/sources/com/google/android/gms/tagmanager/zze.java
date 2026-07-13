package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zze extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzbhD = com.google.android.gms.internal.zzae.COMPONENT.toString();
    private static final String zzbhE = com.google.android.gms.internal.zzae.CONVERSION_ID.toString();
    private final Context context;

    public zze(Context context) {
        super(ID, zzbhE);
        this.context = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        com.google.android.gms.internal.zzag.zza zzaVar = map.get(zzbhE);
        if (zzaVar == null) {
            return zzdf.zzHF();
        }
        String strZzg = zzdf.zzg(zzaVar);
        com.google.android.gms.internal.zzag.zza zzaVar2 = map.get(zzbhD);
        String strZzf = zzax.zzf(this.context, strZzg, zzaVar2 != null ? zzdf.zzg(zzaVar2) : null);
        return strZzf != null ? zzdf.zzR(strZzf) : zzdf.zzHF();
    }
}
