package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzkh<T> extends zzkg.zza {
    protected com.google.android.gms.common.api.internal.zza.zzb<T> zzUz;

    public zzkh(com.google.android.gms.common.api.internal.zza.zzb<T> zzbVar) {
        this.zzUz = zzbVar;
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(GetRecentContextCall.Response response) {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(Status status) {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(Status status, ParcelFileDescriptor parcelFileDescriptor) {
    }

    @Override // com.google.android.gms.internal.zzkg
    public void zza(Status status, boolean z) {
    }
}
