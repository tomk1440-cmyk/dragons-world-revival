package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class zzg implements zzk {
    private final zzl zzahj;
    private boolean zzahk = false;

    public zzg(zzl zzlVar) {
        this.zzahj = zzlVar;
    }

    private <A extends Api.zzb> void zza(zzj.zze<A> zzeVar) throws DeadObjectException {
        this.zzahj.zzagW.zzb(zzeVar);
        Api.zzb zzbVarZza = this.zzahj.zzagW.zza(zzeVar.zzoR());
        if (zzbVarZza.isConnected() || !this.zzahj.zzaio.containsKey(zzeVar.zzoR())) {
            zzeVar.zzb(zzbVarZza);
        } else {
            zzeVar.zzw(new Status(17));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void connect() {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zza(new zzl.zza(this) { // from class: com.google.android.gms.common.api.internal.zzg.2
                @Override // com.google.android.gms.common.api.internal.zzl.zza
                public void zzpt() {
                    zzg.this.zzahj.zzais.zzi(null);
                }
            });
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public boolean disconnect() {
        if (this.zzahk) {
            return false;
        }
        if (!this.zzahj.zzagW.zzpG()) {
            this.zzahj.zzh(null);
            return true;
        }
        this.zzahk = true;
        Iterator<zzx> it = this.zzahj.zzagW.zzaia.iterator();
        while (it.hasNext()) {
            it.next().zzpU();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnected(Bundle connectionHint) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void onConnectionSuspended(int cause) {
        this.zzahj.zzh(null);
        this.zzahj.zzais.zzc(cause, this.zzahk);
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public <A extends Api.zzb, R extends Result, T extends zza.AbstractC0049zza<R, A>> T zza(T t) {
        return (T) zzb(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzk
    public <A extends Api.zzb, T extends zza.AbstractC0049zza<? extends Result, A>> T zzb(T t) {
        try {
            zza((zzj.zze) t);
        } catch (DeadObjectException e) {
            this.zzahj.zza(new zzl.zza(this) { // from class: com.google.android.gms.common.api.internal.zzg.1
                @Override // com.google.android.gms.common.api.internal.zzl.zza
                public void zzpt() {
                    zzg.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }

    void zzps() {
        if (this.zzahk) {
            this.zzahk = false;
            this.zzahj.zzagW.zzaa(false);
            disconnect();
        }
    }
}
