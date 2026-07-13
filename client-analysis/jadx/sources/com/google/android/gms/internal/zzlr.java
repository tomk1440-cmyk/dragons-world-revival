package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzlr extends com.google.android.gms.common.internal.zzj<zzlt> implements IBinder.DeathRecipient {
    private static final com.google.android.gms.cast.internal.zzl zzaaf = new com.google.android.gms.cast.internal.zzl("CastRemoteDisplayClientImpl");
    private CastDevice zzZO;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzaeL;

    public zzlr(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, CastDevice castDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks castRemoteDisplaySessionCallbacks, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 83, zzfVar, connectionCallbacks, onConnectionFailedListener);
        zzaaf.zzb("instance created", new Object[0]);
        this.zzaeL = castRemoteDisplaySessionCallbacks;
        this.zzZO = castDevice;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        zzaaf.zzb("disconnect", new Object[0]);
        this.zzaeL = null;
        this.zzZO = null;
        try {
            zzqJ().disconnect();
        } catch (RemoteException e) {
        } catch (IllegalStateException e2) {
        } finally {
            super.disconnect();
        }
    }

    public void zza(zzls zzlsVar) throws RemoteException {
        zzaaf.zzb("stopRemoteDisplay", new Object[0]);
        zzqJ().zza(zzlsVar);
    }

    public void zza(zzls zzlsVar, int i) throws RemoteException {
        zzqJ().zza(zzlsVar, i);
    }

    public void zza(zzls zzlsVar, final zzlu zzluVar, String str) throws RemoteException {
        zzaaf.zzb("startRemoteDisplay", new Object[0]);
        zzqJ().zza(zzlsVar, new zzlu.zza() { // from class: com.google.android.gms.internal.zzlr.1
            @Override // com.google.android.gms.internal.zzlu
            public void zzbp(int i) throws RemoteException {
                zzlr.zzaaf.zzb("onRemoteDisplayEnded", new Object[0]);
                if (zzluVar != null) {
                    zzluVar.zzbp(i);
                }
                if (zzlr.this.zzaeL != null) {
                    zzlr.this.zzaeL.onRemoteDisplayEnded(new Status(i));
                }
            }
        }, this.zzZO.getDeviceId(), str);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaG, reason: merged with bridge method [inline-methods] */
    public zzlt zzW(IBinder iBinder) {
        return zzlt.zza.zzaI(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }
}
