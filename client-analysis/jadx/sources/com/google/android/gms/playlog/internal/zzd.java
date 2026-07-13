package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqu;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    private final zzqu.zza zzbdJ;
    private zzf zzbdy = null;
    private boolean zzbdK = true;

    public zzd(zzqu.zza zzaVar) {
        this.zzbdJ = zzaVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle connectionHint) {
        this.zzbdy.zzau(false);
        if (this.zzbdK && this.zzbdJ != null) {
            this.zzbdJ.zzES();
        }
        this.zzbdK = false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult result) {
        this.zzbdy.zzau(true);
        if (this.zzbdK && this.zzbdJ != null) {
            if (result.hasResolution()) {
                this.zzbdJ.zzc(result.getResolution());
            } else {
                this.zzbdJ.zzET();
            }
        }
        this.zzbdK = false;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int cause) {
        this.zzbdy.zzau(true);
    }

    public void zza(zzf zzfVar) {
        this.zzbdy = zzfVar;
    }

    public void zzat(boolean z) {
        this.zzbdK = z;
    }
}
