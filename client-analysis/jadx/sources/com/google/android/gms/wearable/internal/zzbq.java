package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzbq<T> extends zzaw.zza {
    private com.google.android.gms.common.api.internal.zzq<MessageApi.MessageListener> zzbbb;
    private final IntentFilter[] zzbsT;
    private com.google.android.gms.common.api.internal.zzq<com.google.android.gms.wearable.zza.InterfaceC0282zza> zzbtp;
    private com.google.android.gms.common.api.internal.zzq<com.google.android.gms.wearable.zzc.zza> zzbtq;
    private com.google.android.gms.common.api.internal.zzq<DataApi.DataListener> zzbtr;
    private com.google.android.gms.common.api.internal.zzq<NodeApi.NodeListener> zzbts;
    private com.google.android.gms.common.api.internal.zzq<NodeApi.zza> zzbtt;
    private com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzbtu;
    private com.google.android.gms.common.api.internal.zzq<CapabilityApi.CapabilityListener> zzbtv;
    private final String zzbtw;

    private zzbq(IntentFilter[] intentFilterArr, String str) {
        this.zzbsT = (IntentFilter[]) com.google.android.gms.common.internal.zzx.zzz(intentFilterArr);
        this.zzbtw = str;
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<NodeApi.zza> zzI(final List<NodeParcelable> list) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<NodeApi.zza>() { // from class: com.google.android.gms.wearable.internal.zzbq.7
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(NodeApi.zza zzaVar) {
                zzaVar.onConnectedNodes(list);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    public static zzbq<ChannelApi.ChannelListener> zza(com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar, String str, IntentFilter[] intentFilterArr) {
        zzbq<ChannelApi.ChannelListener> zzbqVar = new zzbq<>(intentFilterArr, (String) com.google.android.gms.common.internal.zzx.zzz(str));
        ((zzbq) zzbqVar).zzbtu = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    public static zzbq<DataApi.DataListener> zza(com.google.android.gms.common.api.internal.zzq<DataApi.DataListener> zzqVar, IntentFilter[] intentFilterArr) {
        zzbq<DataApi.DataListener> zzbqVar = new zzbq<>(intentFilterArr, null);
        ((zzbq) zzbqVar).zzbtr = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<DataApi.DataListener> zzai(final DataHolder dataHolder) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<DataApi.DataListener>() { // from class: com.google.android.gms.wearable.internal.zzbq.3
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(DataApi.DataListener dataListener) {
                try {
                    dataListener.onDataChanged(new DataEventBuffer(dataHolder));
                } finally {
                    dataHolder.close();
                }
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
                dataHolder.close();
            }
        };
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<com.google.android.gms.wearable.zza.InterfaceC0282zza> zzb(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<com.google.android.gms.wearable.zza.InterfaceC0282zza>() { // from class: com.google.android.gms.wearable.internal.zzbq.2
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(com.google.android.gms.wearable.zza.InterfaceC0282zza interfaceC0282zza) {
                interfaceC0282zza.zza(amsEntityUpdateParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<com.google.android.gms.wearable.zzc.zza> zzb(final AncsNotificationParcelable ancsNotificationParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<com.google.android.gms.wearable.zzc.zza>() { // from class: com.google.android.gms.wearable.internal.zzbq.1
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(com.google.android.gms.wearable.zzc.zza zzaVar) {
                zzaVar.zza(ancsNotificationParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<CapabilityApi.CapabilityListener> zzb(final CapabilityInfoParcelable capabilityInfoParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<CapabilityApi.CapabilityListener>() { // from class: com.google.android.gms.wearable.internal.zzbq.9
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(CapabilityApi.CapabilityListener capabilityListener) {
                capabilityListener.onCapabilityChanged(capabilityInfoParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<ChannelApi.ChannelListener> zzb(final ChannelEventParcelable channelEventParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<ChannelApi.ChannelListener>() { // from class: com.google.android.gms.wearable.internal.zzbq.8
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
            public void zzt(ChannelApi.ChannelListener channelListener) {
                channelEventParcelable.zza(channelListener);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<MessageApi.MessageListener> zzb(final MessageEventParcelable messageEventParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<MessageApi.MessageListener>() { // from class: com.google.android.gms.wearable.internal.zzbq.4
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(MessageApi.MessageListener messageListener) {
                messageListener.onMessageReceived(messageEventParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    public static zzbq<MessageApi.MessageListener> zzb(com.google.android.gms.common.api.internal.zzq<MessageApi.MessageListener> zzqVar, IntentFilter[] intentFilterArr) {
        zzbq<MessageApi.MessageListener> zzbqVar = new zzbq<>(intentFilterArr, null);
        ((zzbq) zzbqVar).zzbbb = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<NodeApi.NodeListener> zzc(final NodeParcelable nodeParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<NodeApi.NodeListener>() { // from class: com.google.android.gms.wearable.internal.zzbq.5
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(NodeApi.NodeListener nodeListener) {
                nodeListener.onPeerConnected(nodeParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    public static zzbq<NodeApi.NodeListener> zzc(com.google.android.gms.common.api.internal.zzq<NodeApi.NodeListener> zzqVar, IntentFilter[] intentFilterArr) {
        zzbq<NodeApi.NodeListener> zzbqVar = new zzbq<>(intentFilterArr, null);
        ((zzbq) zzbqVar).zzbts = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static com.google.android.gms.common.api.internal.zzq.zzb<NodeApi.NodeListener> zzd(final NodeParcelable nodeParcelable) {
        return new com.google.android.gms.common.api.internal.zzq.zzb<NodeApi.NodeListener>() { // from class: com.google.android.gms.wearable.internal.zzbq.6
            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzt(NodeApi.NodeListener nodeListener) {
                nodeListener.onPeerDisconnected(nodeParcelable);
            }

            @Override // com.google.android.gms.common.api.internal.zzq.zzb
            public void zzpr() {
            }
        };
    }

    public static zzbq<ChannelApi.ChannelListener> zzd(com.google.android.gms.common.api.internal.zzq<ChannelApi.ChannelListener> zzqVar, IntentFilter[] intentFilterArr) {
        zzbq<ChannelApi.ChannelListener> zzbqVar = new zzbq<>(intentFilterArr, null);
        ((zzbq) zzbqVar).zzbtu = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    public static zzbq<CapabilityApi.CapabilityListener> zze(com.google.android.gms.common.api.internal.zzq<CapabilityApi.CapabilityListener> zzqVar, IntentFilter[] intentFilterArr) {
        zzbq<CapabilityApi.CapabilityListener> zzbqVar = new zzbq<>(intentFilterArr, null);
        ((zzbq) zzbqVar).zzbtv = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
        return zzbqVar;
    }

    private static void zzh(com.google.android.gms.common.api.internal.zzq<?> zzqVar) {
        if (zzqVar != null) {
            zzqVar.clear();
        }
    }

    public void clear() {
        zzh(this.zzbtp);
        this.zzbtp = null;
        zzh(this.zzbtq);
        this.zzbtq = null;
        zzh(this.zzbtr);
        this.zzbtr = null;
        zzh(this.zzbbb);
        this.zzbbb = null;
        zzh(this.zzbts);
        this.zzbts = null;
        zzh(this.zzbtt);
        this.zzbtt = null;
        zzh(this.zzbtu);
        this.zzbtu = null;
        zzh(this.zzbtv);
        this.zzbtv = null;
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void onConnectedNodes(List<NodeParcelable> connectedNodes) {
        if (this.zzbtt != null) {
            this.zzbtt.zza(zzI(connectedNodes));
        }
    }

    public IntentFilter[] zzIO() {
        return this.zzbsT;
    }

    public String zzIP() {
        return this.zzbtw;
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (this.zzbtp != null) {
            this.zzbtp.zza(zzb(amsEntityUpdateParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzbtq != null) {
            this.zzbtq.zza(zzb(ancsNotificationParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzbtv != null) {
            this.zzbtv.zza(zzb(capabilityInfoParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzbtu != null) {
            this.zzbtu.zza(zzb(channelEventParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzbbb != null) {
            this.zzbbb.zza(zzb(messageEventParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zza(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzc(nodeParcelable));
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zzag(DataHolder dataHolder) {
        if (this.zzbtr != null) {
            this.zzbtr.zza(zzai(dataHolder));
        } else {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.wearable.internal.zzaw
    public void zzb(NodeParcelable nodeParcelable) {
        if (this.zzbts != null) {
            this.zzbts.zza(zzd(nodeParcelable));
        }
    }
}
