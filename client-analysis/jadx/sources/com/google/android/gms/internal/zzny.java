package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzny<T extends IInterface> extends com.google.android.gms.common.internal.zzj<T> {
    protected zzny(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, i, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Set<Scope> zzb(Set<Scope> set) {
        return com.google.android.gms.fitness.zza.zze(set);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        return !zznv.zzaD(getContext());
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzqK() {
        return true;
    }
}
