package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class zzj implements CapabilityApi {

    public static class zza implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult {
        private final Status zzUX;

        public zza(Status status) {
            this.zzUX = status;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static class zzb implements CapabilityApi.CapabilityListener {
        final CapabilityApi.CapabilityListener zzbrQ;
        final String zzbrR;

        zzb(CapabilityApi.CapabilityListener capabilityListener, String str) {
            this.zzbrQ = capabilityListener;
            this.zzbrR = str;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (this.zzbrQ.equals(zzbVar.zzbrQ)) {
                return this.zzbrR.equals(zzbVar.zzbrR);
            }
            return false;
        }

        public int hashCode() {
            return (this.zzbrQ.hashCode() * 31) + this.zzbrR.hashCode();
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
        public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
            this.zzbrQ.onCapabilityChanged(capabilityInfo);
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzbrS;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzbrS = set;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public String getName() {
            return this.mName;
        }

        @Override // com.google.android.gms.wearable.CapabilityInfo
        public Set<Node> getNodes() {
            return this.zzbrS;
        }
    }

    public static class zzd implements CapabilityApi.GetAllCapabilitiesResult {
        private final Status zzUX;
        private final Map<String, CapabilityInfo> zzbrT;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzUX = status;
            this.zzbrT = map;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult
        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzbrT;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public static class zze implements CapabilityApi.GetCapabilityResult {
        private final Status zzUX;
        private final CapabilityInfo zzbrU;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzUX = status;
            this.zzbrU = capabilityInfo;
        }

        @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
        public CapabilityInfo getCapability() {
            return this.zzbrU;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private static final class zzf extends zzi<Status> {
        private CapabilityApi.CapabilityListener zzbrQ;

        private zzf(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener) {
            super(googleApiClient);
            this.zzbrQ = capabilityListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzbp zzbpVar) throws RemoteException {
            zzbpVar.zza(this, this.zzbrQ);
            this.zzbrQ = null;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            this.zzbrQ = null;
            return status;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, CapabilityApi.CapabilityListener capabilityListener, IntentFilter[] intentFilterArr) {
        return com.google.android.gms.wearable.internal.zzb.zza(googleApiClient, zza(intentFilterArr), capabilityListener);
    }

    private static com.google.android.gms.wearable.internal.zzb.zza<CapabilityApi.CapabilityListener> zza(final IntentFilter[] intentFilterArr) {
        return new com.google.android.gms.wearable.internal.zzb.zza<CapabilityApi.CapabilityListener>() { // from class: com.google.android.gms.wearable.internal.zzj.5
            /* JADX INFO: renamed from: zza, reason: avoid collision after fix types in other method */
            public void zza2(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, CapabilityApi.CapabilityListener capabilityListener, com.google.android.gms.common.api.internal.zzq<CapabilityApi.CapabilityListener> zzqVar) throws RemoteException {
                zzbpVar.zza(zzbVar, capabilityListener, zzqVar, intentFilterArr);
            }

            @Override // com.google.android.gms.wearable.internal.zzb.zza
            public /* bridge */ /* synthetic */ void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb zzbVar, CapabilityApi.CapabilityListener capabilityListener, com.google.android.gms.common.api.internal.zzq<CapabilityApi.CapabilityListener> zzqVar) throws RemoteException {
                zza2(zzbpVar, (com.google.android.gms.common.api.internal.zza.zzb<Status>) zzbVar, capabilityListener, zzqVar);
            }
        };
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> addCapabilityListener(GoogleApiClient client, CapabilityApi.CapabilityListener listener, String capability) {
        com.google.android.gms.common.internal.zzx.zzb(capability != null, "capability must not be null");
        zzb zzbVar = new zzb(listener, capability);
        IntentFilter intentFilterZzgM = zzbn.zzgM(CapabilityApi.ACTION_CAPABILITY_CHANGED);
        if (!capability.startsWith("/")) {
            capability = "/" + capability;
        }
        intentFilterZzgM.addDataPath(capability, 0);
        return zza(client, zzbVar, new IntentFilter[]{intentFilterZzgM});
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> addListener(GoogleApiClient client, CapabilityApi.CapabilityListener listener, Uri uri, int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(filterType == 0 || filterType == 1, "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(CapabilityApi.ACTION_CAPABILITY_CHANGED, uri, filterType)});
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzi<CapabilityApi.AddLocalCapabilityResult>(client) { // from class: com.google.android.gms.wearable.internal.zzj.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzr(this, capability);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbq, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.AddLocalCapabilityResult zzc(Status status) {
                return new zza(status);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient client, final int nodeFilter) {
        boolean z = true;
        if (nodeFilter != 0 && nodeFilter != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzx.zzac(z);
        return client.zza(new zzi<CapabilityApi.GetAllCapabilitiesResult>(client) { // from class: com.google.android.gms.wearable.internal.zzj.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzb(this, nodeFilter);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbp, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.GetAllCapabilitiesResult zzc(Status status) {
                return new zzd(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient client, final String capability, final int nodeFilter) {
        boolean z = true;
        if (nodeFilter != 0 && nodeFilter != 1) {
            z = false;
        }
        com.google.android.gms.common.internal.zzx.zzac(z);
        return client.zza(new zzi<CapabilityApi.GetCapabilityResult>(client) { // from class: com.google.android.gms.wearable.internal.zzj.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzg(this, capability, nodeFilter);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbo, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.GetCapabilityResult zzc(Status status) {
                return new zze(status, null);
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> removeCapabilityListener(GoogleApiClient client, CapabilityApi.CapabilityListener listener, String capability) {
        return client.zza(new zzf(client, new zzb(listener, capability)));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<Status> removeListener(GoogleApiClient client, CapabilityApi.CapabilityListener listener) {
        return client.zza(new zzf(client, listener));
    }

    @Override // com.google.android.gms.wearable.CapabilityApi
    public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzi<CapabilityApi.RemoveLocalCapabilityResult>(client) { // from class: com.google.android.gms.wearable.internal.zzj.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zzs(this, capability);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbr, reason: merged with bridge method [inline-methods] */
            public CapabilityApi.RemoveLocalCapabilityResult zzc(Status status) {
                return new zza(status);
            }
        });
    }
}
