package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbb implements NodeApi {

    public static class zza implements NodeApi.GetConnectedNodesResult {
        private final Status zzUX;
        private final List<Node> zzbsW;

        public zza(Status status, List<Node> list) {
            this.zzUX = status;
            this.zzbsW = list;
        }

        @Override // com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
        public List<Node> getNodes() {
            return this.zzbsW;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zzb implements NodeApi.GetLocalNodeResult {
        private final Status zzUX;
        private final Node zzbsX;

        public zzb(Status status, Node node) {
            this.zzUX = status;
            this.zzbsX = node;
        }

        @Override // com.google.android.gms.wearable.NodeApi.GetLocalNodeResult
        public Node getNode() {
            return this.zzbsX;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static com.google.android.gms.wearable.internal.zzb.zza<NodeApi.NodeListener> zza(final IntentFilter[] intentFilterArr) {
        return new com.google.android.gms.wearable.internal.zzb.zza<NodeApi.NodeListener>() { // from class: com.google.android.gms.wearable.internal.zzbb.3
            /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
            public void zza2(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, NodeApi.NodeListener nodeListener, com.google.android.gms.common.api.internal.zzq<NodeApi.NodeListener> zzqVar) throws RemoteException {
                zzbpVar.zza(zzbVar, nodeListener, zzqVar, intentFilterArr);
            }

            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public /* bridge */ /* synthetic */ void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb zzbVar, NodeApi.NodeListener nodeListener, com.google.android.gms.common.api.internal.zzq<NodeApi.NodeListener> zzqVar) throws RemoteException {
                zza2(zzbpVar, (com.google.android.gms.common.api.internal.zza.zzb<Status>) zzbVar, nodeListener, zzqVar);
            }
        };
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<Status> addListener(GoogleApiClient client, NodeApi.NodeListener listener) {
        return com.google.android.gms.wearable.internal.zzb.zza(client, zza(new IntentFilter[]{zzbn.zzgM("com.google.android.gms.wearable.NODE_CHANGED")}), listener);
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<NodeApi.GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new zzi<NodeApi.GetConnectedNodesResult>(client) { // from class: com.google.android.gms.wearable.internal.zzbb.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzt(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbB, reason: merged with bridge method [inline-methods] */
            public NodeApi.GetConnectedNodesResult zzc(Status status) {
                return new zza(status, new ArrayList());
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<NodeApi.GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new zzi<NodeApi.GetLocalNodeResult>(client) { // from class: com.google.android.gms.wearable.internal.zzbb.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzs(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbA, reason: merged with bridge method [inline-methods] */
            public NodeApi.GetLocalNodeResult zzc(Status status) {
                return new zzb(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.NodeApi
    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeApi.NodeListener listener) {
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.zzbb.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, listener);
            }

            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public Status zzc(Status status) {
                return status;
            }
        });
    }
}
