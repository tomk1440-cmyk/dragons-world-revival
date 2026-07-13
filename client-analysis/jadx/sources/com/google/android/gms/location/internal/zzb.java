package com.google.android.gms.location.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends com.google.android.gms.common.internal.zzj<zzi> {
    private final String zzaOs;
    protected final zzp<zzi> zzaOt;

    public zzb(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, looper, 23, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaOt = new zzp<zzi>() { // from class: com.google.android.gms.location.internal.zzb.1
            @Override // com.google.android.gms.location.internal.zzp
            public void zzqI() {
                zzb.this.zzqI();
            }

            @Override // com.google.android.gms.location.internal.zzp
            /* JADX INFO: renamed from: zzyM, reason: merged with bridge method [inline-methods] */
            public zzi zzqJ() throws DeadObjectException {
                return zzb.this.zzqJ();
            }
        };
        this.zzaOs = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzcg, reason: merged with bridge method [inline-methods] */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.zzcj(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zzaOs);
        return bundle;
    }
}
