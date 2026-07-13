package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class zzi implements zzk {
    private final zzl zzahj;

    public zzi(zzl zzlVar) {
        this.zzahj = zzlVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void begin() {
        this.zzahj.zzpM();
        this.zzahj.zzagW.zzahU = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void connect() {
        this.zzahj.zzpK();
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public boolean disconnect() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnected(Bundle connectionHint) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnectionSuspended(int cause) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public <A extends Api.zzb, R extends Result, T extends zza.AbstractC0049zza<R, A>> T zza(T t) {
        this.zzahj.zzagW.zzahN.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public <A extends Api.zzb, T extends zza.AbstractC0049zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
