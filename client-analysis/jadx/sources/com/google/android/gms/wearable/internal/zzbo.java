package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.NodeApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
final class zzbo {

    static final class zza extends zzb<CapabilityApi.AddLocalCapabilityResult> {
        public zza(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.AddLocalCapabilityResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zza(zzbk.zzgc(addLocalCapabilityResponse.statusCode)));
        }
    }

    static abstract class zzb<T> extends com.google.android.gms.wearable.internal.zza {
        private com.google.android.gms.common.api.internal.zza.zzb<T> zzUz;

        public zzb(com.google.android.gms.common.api.internal.zza.zzb<T> zzbVar) {
            this.zzUz = zzbVar;
        }

        public void zzX(T t) {
            com.google.android.gms.common.api.internal.zza.zzb<T> zzbVar = this.zzUz;
            if (zzbVar != null) {
                zzbVar.zzs(t);
                this.zzUz = null;
            }
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzX(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DataApi.DeleteDataItemsResult> {
        public zze(com.google.android.gms.common.api.internal.zza.zzb<DataApi.DeleteDataItemsResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzX(new zzx.zzb(zzbk.zzgc(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbsz));
        }
    }

    static final class zzf extends zzb<CapabilityApi.GetAllCapabilitiesResult> {
        public zzf(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.GetAllCapabilitiesResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zzd(zzbk.zzgc(getAllCapabilitiesResponse.statusCode), zzbo.zzG(getAllCapabilitiesResponse.zzbsA)));
        }
    }

    static final class zzg extends zzb<CapabilityApi.GetCapabilityResult> {
        public zzg(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.GetCapabilityResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zze(zzbk.zzgc(getCapabilityResponse.statusCode), new com.google.android.gms.wearable.internal.zzj.zzc(getCapabilityResponse.zzbsB)));
        }
    }

    static final class zzh extends zzb<Channel.GetInputStreamResult> {
        private final com.google.android.gms.wearable.internal.zzt zzbtd;

        public zzh(com.google.android.gms.common.api.internal.zza.zzb<Channel.GetInputStreamResult> zzbVar, com.google.android.gms.wearable.internal.zzt zztVar) {
            super(zzbVar);
            this.zzbtd = (com.google.android.gms.wearable.internal.zzt) com.google.android.gms.common.internal.zzx.zzz(zztVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            com.google.android.gms.wearable.internal.zzp zzpVar = null;
            if (getChannelInputStreamResponse.zzbsC != null) {
                zzpVar = new com.google.android.gms.wearable.internal.zzp(new ParcelFileDescriptor.AutoCloseInputStream(getChannelInputStreamResponse.zzbsC));
                this.zzbtd.zza(zzpVar.zzIJ());
            }
            zzX(new ChannelImpl.zza(new Status(getChannelInputStreamResponse.statusCode), zzpVar));
        }
    }

    static final class zzi extends zzb<Channel.GetOutputStreamResult> {
        private final com.google.android.gms.wearable.internal.zzt zzbtd;

        public zzi(com.google.android.gms.common.api.internal.zza.zzb<Channel.GetOutputStreamResult> zzbVar, com.google.android.gms.wearable.internal.zzt zztVar) {
            super(zzbVar);
            this.zzbtd = (com.google.android.gms.wearable.internal.zzt) com.google.android.gms.common.internal.zzx.zzz(zztVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            com.google.android.gms.wearable.internal.zzq zzqVar = null;
            if (getChannelOutputStreamResponse.zzbsC != null) {
                zzqVar = new com.google.android.gms.wearable.internal.zzq(new ParcelFileDescriptor.AutoCloseOutputStream(getChannelOutputStreamResponse.zzbsC));
                this.zzbtd.zza(zzqVar.zzIJ());
            }
            zzX(new ChannelImpl.zzb(new Status(getChannelOutputStreamResponse.statusCode), zzqVar));
        }
    }

    static final class zzj extends zzb<NodeApi.GetConnectedNodesResult> {
        public zzj(com.google.android.gms.common.api.internal.zza.zzb<NodeApi.GetConnectedNodesResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbsI);
            zzX(new zzbb.zza(zzbk.zzgc(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataApi.DataItemResult> {
        public zzk(com.google.android.gms.common.api.internal.zza.zzb<DataApi.DataItemResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetDataItemResponse getDataItemResponse) {
            zzX(new zzx.zza(zzbk.zzgc(getDataItemResponse.statusCode), getDataItemResponse.zzbsJ));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(com.google.android.gms.common.api.internal.zza.zzb<DataItemBuffer> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zzah(DataHolder dataHolder) {
            zzX(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<DataApi.GetFdForAssetResult> {
        public zzm(com.google.android.gms.common.api.internal.zza.zzb<DataApi.GetFdForAssetResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzX(new zzx.zzc(zzbk.zzgc(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbsK));
        }
    }

    static final class zzn extends zzb<NodeApi.GetLocalNodeResult> {
        public zzn(com.google.android.gms.common.api.internal.zza.zzb<NodeApi.GetLocalNodeResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzX(new zzbb.zzb(zzbk.zzgc(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbsL));
        }
    }

    static final class zzo extends com.google.android.gms.wearable.internal.zza {
        zzo() {
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(Status status) {
        }
    }

    static final class zzp extends zzb<ChannelApi.OpenChannelResult> {
        public zzp(com.google.android.gms.common.api.internal.zza.zzb<ChannelApi.OpenChannelResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(OpenChannelResponse openChannelResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzl.zza(zzbk.zzgc(openChannelResponse.statusCode), openChannelResponse.zzbsc));
        }
    }

    static final class zzq extends zzb<DataApi.DataItemResult> {
        private final List<FutureTask<Boolean>> zzzM;

        zzq(com.google.android.gms.common.api.internal.zza.zzb<DataApi.DataItemResult> zzbVar, List<FutureTask<Boolean>> list) {
            super(zzbVar);
            this.zzzM = list;
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(PutDataResponse putDataResponse) {
            zzX(new zzx.zza(zzbk.zzgc(putDataResponse.statusCode), putDataResponse.zzbsJ));
            if (putDataResponse.statusCode != 0) {
                Iterator<FutureTask<Boolean>> it = this.zzzM.iterator();
                while (it.hasNext()) {
                    it.next().cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzX(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<CapabilityApi.RemoveLocalCapabilityResult> {
        public zzs(com.google.android.gms.common.api.internal.zza.zzb<CapabilityApi.RemoveLocalCapabilityResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzX(new com.google.android.gms.wearable.internal.zzj.zza(zzbk.zzgc(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<MessageApi.SendMessageResult> {
        public zzt(com.google.android.gms.common.api.internal.zza.zzb<MessageApi.SendMessageResult> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(SendMessageResponse sendMessageResponse) {
            zzX(new zzaz.zzb(zzbk.zzgc(sendMessageResponse.statusCode), sendMessageResponse.zzaNj));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            super(zzbVar);
        }

        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzX(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, CapabilityInfo> zzG(List<CapabilityInfoParcelable> list) {
        HashMap map = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            map.put(capabilityInfoParcelable.getName(), new com.google.android.gms.wearable.internal.zzj.zzc(capabilityInfoParcelable));
        }
        return map;
    }
}
