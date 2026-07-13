package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements ChannelApi {

    static final class zza implements ChannelApi.OpenChannelResult {
        private final Status zzUX;
        private final Channel zzbrY;

        zza(Status status, Channel channel) {
            this.zzUX = (Status) com.google.android.gms.common.internal.zzx.zzz(status);
            this.zzbrY = channel;
        }

        @Override // com.google.android.gms.wearable.ChannelApi.OpenChannelResult
        public Channel getChannel() {
            return this.zzbrY;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    static final class zzb extends zzi<Status> {
        private final String zzVo;
        private ChannelApi.ChannelListener zzbrZ;

        zzb(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzbrZ = (ChannelApi.ChannelListener) com.google.android.gms.common.internal.zzx.zzz(channelListener);
            this.zzVo = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzbp zzbpVar) throws RemoteException {
            zzbpVar.zza(this, this.zzbrZ, this.zzVo);
            this.zzbrZ = null;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            this.zzbrZ = null;
            return status;
        }
    }

    private static com.google.android.gms.wearable.internal.zzb.zza<ChannelApi.ChannelListener> zza(final IntentFilter[] intentFilterArr) {
        return new com.google.android.gms.wearable.internal.zzb.zza<ChannelApi.ChannelListener>() { // from class: com.google.android.gms.wearable.internal.zzl.2
            /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
            public void zza2(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar) throws RemoteException {
                zzbpVar.zza(zzbVar, channelListener, zzqVar, (String) null, intentFilterArr);
            }

            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public /* bridge */ /* synthetic */ void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb zzbVar, ChannelApi.ChannelListener channelListener, com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar) throws RemoteException {
                zza2(zzbpVar, (com.google.android.gms.common.api.internal.zza.zzb<Status>) zzbVar, channelListener, zzqVar);
            }
        };
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<Status> addListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        com.google.android.gms.common.internal.zzx.zzb(client, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(listener, "listener is null");
        return com.google.android.gms.wearable.internal.zzb.zza(client, zza(new IntentFilter[]{zzbn.zzgM(ChannelApi.ACTION_CHANNEL_EVENT)}), listener);
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient client, final String nodeId, final String path) {
        com.google.android.gms.common.internal.zzx.zzb(client, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(nodeId, "nodeId is null");
        com.google.android.gms.common.internal.zzx.zzb(path, "path is null");
        return client.zza(new zzi<ChannelApi.OpenChannelResult>(client) { // from class: com.google.android.gms.wearable.internal.zzl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zze(this, nodeId, path);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbs, reason: merged with bridge method [inline-methods] */
            public ChannelApi.OpenChannelResult zzc(Status status) {
                return new zza(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelApi
    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelApi.ChannelListener listener) {
        com.google.android.gms.common.internal.zzx.zzb(client, "client is null");
        com.google.android.gms.common.internal.zzx.zzb(listener, "listener is null");
        return client.zza(new zzb(client, listener, null));
    }
}
