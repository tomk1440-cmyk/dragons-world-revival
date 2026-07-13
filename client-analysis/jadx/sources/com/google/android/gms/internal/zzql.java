package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzql implements Connections {
    public static final Api.zzc<zzqk> zzUI = new Api.zzc<>();
    public static final Api.zza<zzqk, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzqk, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.internal.zzql.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public zzqk zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzqk(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private static abstract class zza<R extends Result> extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, zzqk> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzql.zzUI, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<Connections.StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzbc, reason: merged with bridge method [inline-methods] */
        public Connections.StartAdvertisingResult zzc(final Status status) {
            return new Connections.StartAdvertisingResult() { // from class: com.google.android.gms.internal.zzql.zzb.1
                @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
                public String getLocalEndpointName() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    public static zzqk zzd(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzx.zzb(googleApiClient != null, "GoogleApiClient parameter is required.");
        com.google.android.gms.common.internal.zzx.zza(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzqk zze(GoogleApiClient googleApiClient, boolean z) {
        com.google.android.gms.common.internal.zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean zHasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (z && !zHasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
        if (zHasConnectedApi) {
            return (zzqk) googleApiClient.zza(zzUI);
        }
        return null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient apiClient, final String remoteEndpointId, final byte[] payload, Connections.MessageListener messageListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = apiClient.zzr(messageListener);
        return apiClient.zzb(new zzc(apiClient) { // from class: com.google.android.gms.internal.zzql.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzqk zzqkVar) throws RemoteException {
                zzqkVar.zza(this, remoteEndpointId, payload, zzqVarZzr);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void disconnectFromEndpoint(GoogleApiClient apiClient, String remoteEndpointId) {
        zzd(apiClient, false).zzfA(remoteEndpointId);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public String getLocalDeviceId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzEk();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public String getLocalEndpointId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzEj();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient apiClient, final String remoteEndpointId) {
        return apiClient.zzb(new zzc(apiClient) { // from class: com.google.android.gms.internal.zzql.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzqk zzqkVar) throws RemoteException {
                zzqkVar.zzp(this, remoteEndpointId);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> sendConnectionRequest(GoogleApiClient apiClient, final String name, final String remoteEndpointId, final byte[] payload, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = apiClient.zzr(connectionResponseCallback);
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr2 = apiClient.zzr(messageListener);
        return apiClient.zzb(new zzc(apiClient) { // from class: com.google.android.gms.internal.zzql.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzqk zzqkVar) throws RemoteException {
                zzqkVar.zza(this, name, remoteEndpointId, payload, zzqVarZzr, zzqVarZzr2);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendReliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zza(new String[]{remoteEndpointId}, payload);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendReliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zza((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendUnreliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zzb(new String[]{remoteEndpointId}, payload);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void sendUnreliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zzb((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Connections.StartAdvertisingResult> startAdvertising(GoogleApiClient apiClient, final String name, final AppMetadata appMetadata, final long durationMillis, Connections.ConnectionRequestListener connectionRequestListener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = apiClient.zzr(connectionRequestListener);
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.internal.zzql.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzqk zzqkVar) throws RemoteException {
                zzqkVar.zza(this, name, appMetadata, durationMillis, zzqVarZzr);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public PendingResult<Status> startDiscovery(GoogleApiClient apiClient, final String serviceId, final long durationMillis, Connections.EndpointDiscoveryListener listener) {
        final com.google.android.gms.common.api.internal.zzq zzqVarZzr = apiClient.zzr(listener);
        return apiClient.zzb(new zzc(apiClient) { // from class: com.google.android.gms.internal.zzql.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzqk zzqkVar) throws RemoteException {
                zzqkVar.zza(this, serviceId, durationMillis, zzqVarZzr);
            }
        });
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void stopAdvertising(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzEl();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void stopAllEndpoints(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzEm();
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public void stopDiscovery(GoogleApiClient apiClient, String serviceId) {
        zzd(apiClient, false).zzfz(serviceId);
    }
}
