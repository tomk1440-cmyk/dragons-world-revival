package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;

/* JADX INFO: loaded from: classes.dex */
public final class zzqk extends com.google.android.gms.common.internal.zzj<zzqn> {
    private final long zzaEg;

    private static final class zza extends zzb {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;

        public zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<Connections.MessageListener> zzqVar) {
            super(zzqVar);
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zziZ(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    private static class zzb extends zzqj {
        private final com.google.android.gms.common.api.internal.zzq<Connections.MessageListener> zzbbb;

        zzb(com.google.android.gms.common.api.internal.zzq<Connections.MessageListener> zzqVar) {
            this.zzbbb = zzqVar;
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzbbb.zza(new com.google.android.gms.common.api.internal.zzq.zzb<Connections.MessageListener>() { // from class: com.google.android.gms.internal.zzqk.zzb.2
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzbbb.zza(new com.google.android.gms.common.api.internal.zzq.zzb<Connections.MessageListener>() { // from class: com.google.android.gms.internal.zzqk.zzb.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }
    }

    private static class zzc extends zzqj {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzbbf;

        zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            this.zzbbf = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zzja(int i) throws RemoteException {
            this.zzbbf.zzs(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;
        private final com.google.android.gms.common.api.internal.zzq<Connections.ConnectionResponseCallback> zzbbg;

        public zzd(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<Connections.ConnectionResponseCallback> zzqVar, com.google.android.gms.common.api.internal.zzq<Connections.MessageListener> zzqVar2) {
            super(zzqVar2);
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            this.zzbbg = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzbbg.zza(new com.google.android.gms.common.api.internal.zzq.zzb<Connections.ConnectionResponseCallback>() { // from class: com.google.android.gms.internal.zzqk.zzd.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zziY(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    private static final class zze extends zzqj {
        private final com.google.android.gms.common.api.internal.zza.zzb<Connections.StartAdvertisingResult> zzamC;
        private final com.google.android.gms.common.api.internal.zzq<Connections.ConnectionRequestListener> zzbbi;

        zze(com.google.android.gms.common.api.internal.zza.zzb<Connections.StartAdvertisingResult> zzbVar, com.google.android.gms.common.api.internal.zzq<Connections.ConnectionRequestListener> zzqVar) {
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onConnectionRequest(final String remoteEndpointId, final String remoteDeviceId, final String remoteEndpointName, final byte[] payload) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<Connections.ConnectionRequestListener>() { // from class: com.google.android.gms.internal.zzqk.zze.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(remoteEndpointId, remoteDeviceId, remoteEndpointName, payload);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zzm(int i, String str) throws RemoteException {
            this.zzamC.zzs(new zzf(new Status(i), str));
        }
    }

    private static final class zzf implements Connections.StartAdvertisingResult {
        private final Status zzUX;
        private final String zzbbm;

        zzf(Status status, String str) {
            this.zzUX = status;
            this.zzbbm = str;
        }

        @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
        public String getLocalEndpointName() {
            return this.zzbbm;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zzg extends zzqj {
        private final com.google.android.gms.common.api.internal.zza.zzb<Status> zzamC;
        private final com.google.android.gms.common.api.internal.zzq<Connections.EndpointDiscoveryListener> zzbbi;

        zzg(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<Connections.EndpointDiscoveryListener> zzqVar) {
            this.zzamC = (com.google.android.gms.common.api.internal.zza.zzb) com.google.android.gms.common.internal.zzx.zzz(zzbVar);
            this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onEndpointFound(final String endpointId, final String deviceId, final String serviceId, final String name) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<Connections.EndpointDiscoveryListener>() { // from class: com.google.android.gms.internal.zzqk.zzg.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(endpointId, deviceId, serviceId, name);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<Connections.EndpointDiscoveryListener>() { // from class: com.google.android.gms.internal.zzqk.zzg.2
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.internal.zzqj, com.google.android.gms.internal.zzqm
        public void zziW(int i) throws RemoteException {
            this.zzamC.zzs(new Status(i));
        }
    }

    public zzqk(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzaEg = hashCode();
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        if (isConnected()) {
            try {
                zzqJ().zzF(this.zzaEg);
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public String zzEj() {
        try {
            return zzqJ().zzaj(this.zzaEg);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String zzEk() {
        try {
            return zzqJ().zzEk();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzEl() {
        try {
            zzqJ().zzag(this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzEm() {
        try {
            zzqJ().zzai(this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str, long j, com.google.android.gms.common.api.internal.zzq<Connections.EndpointDiscoveryListener> zzqVar) throws RemoteException {
        zzqJ().zza(new zzg(zzbVar, zzqVar), str, j, this.zzaEg);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Connections.StartAdvertisingResult> zzbVar, String str, AppMetadata appMetadata, long j, com.google.android.gms.common.api.internal.zzq<Connections.ConnectionRequestListener> zzqVar) throws RemoteException {
        zzqJ().zza(new zze(zzbVar, zzqVar), str, appMetadata, j, this.zzaEg);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str, String str2, byte[] bArr, com.google.android.gms.common.api.internal.zzq<Connections.ConnectionResponseCallback> zzqVar, com.google.android.gms.common.api.internal.zzq<Connections.MessageListener> zzqVar2) throws RemoteException {
        zzqJ().zza(new zzd(zzbVar, zzqVar, zzqVar2), str, str2, bArr, this.zzaEg);
    }

    public void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str, byte[] bArr, com.google.android.gms.common.api.internal.zzq<Connections.MessageListener> zzqVar) throws RemoteException {
        zzqJ().zza(new zza(zzbVar, zzqVar), str, bArr, this.zzaEg);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            zzqJ().zza(strArr, bArr, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            zzqJ().zzb(strArr, bArr, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdv, reason: merged with bridge method [inline-methods] */
    public zzqn zzW(IBinder iBinder) {
        return zzqn.zza.zzdx(iBinder);
    }

    public void zzfA(String str) {
        try {
            zzqJ().zzi(str, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    public void zzfz(String str) {
        try {
            zzqJ().zzh(str, this.zzaEg);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, String str) throws RemoteException {
        zzqJ().zza(new zzc(zzbVar), str, this.zzaEg);
    }
}
