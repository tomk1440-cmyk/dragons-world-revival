package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzc extends zzak {
    private static final String ID = com.google.android.gms.internal.zzad.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzbhC;

    public zzc(Context context) {
        this(zza.zzaW(context));
    }

    zzc(zza zzaVar) {
        super(ID, new String[0]);
        this.zzbhC = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzFW() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        return zzdf.zzR(Boolean.valueOf(!this.zzbhC.isLimitAdTrackingEnabled()));
    }
}
