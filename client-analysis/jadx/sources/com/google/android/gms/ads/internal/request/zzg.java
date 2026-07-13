package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzhb;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzg extends zzk.zza {
    private final WeakReference<zzc.zza> zzHR;

    public zzg(zzc.zza zzaVar) {
        this.zzHR = new WeakReference<>(zzaVar);
    }

    @Override // com.google.android.gms.ads.internal.request.zzk
    public void zzb(AdResponseParcel adResponseParcel) {
        zzc.zza zzaVar = this.zzHR.get();
        if (zzaVar != null) {
            zzaVar.zzb(adResponseParcel);
        }
    }
}
