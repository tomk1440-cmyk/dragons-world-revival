package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzph extends zzow.zza {
    private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

    public zzph(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
        this.zzamC = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzow
    public void zzp(Status status) {
        this.zzamC.zzs(status);
    }
}
