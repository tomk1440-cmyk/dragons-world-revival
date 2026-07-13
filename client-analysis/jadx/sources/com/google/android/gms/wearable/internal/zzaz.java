package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz implements MessageApi {

    private static final class zza extends zzi<Status> {
        private com.google.android.gms.common.api.internal.zzq<MessageApi.MessageListener> zzbbi;
        private MessageApi.MessageListener zzbsS;
        private IntentFilter[] zzbsT;

        private zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, com.google.android.gms.common.api.internal.zzq<MessageApi.MessageListener> zzqVar, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbsS = (MessageApi.MessageListener) com.google.android.gms.common.internal.zzx.zzz(messageListener);
            this.zzbbi = (com.google.android.gms.common.api.internal.zzq) com.google.android.gms.common.internal.zzx.zzz(zzqVar);
            this.zzbsT = (IntentFilter[]) com.google.android.gms.common.internal.zzx.zzz(intentFilterArr);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(zzbp zzbpVar) throws RemoteException {
            zzbpVar.zza(this, this.zzbsS, this.zzbbi, this.zzbsT);
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            this.zzbsS = null;
            this.zzbbi = null;
            this.zzbsT = null;
            return status;
        }
    }

    public static class zzb implements MessageApi.SendMessageResult {
        private final Status zzUX;
        private final int zzaox;

        public zzb(Status status, int i) {
            this.zzUX = status;
            this.zzaox = i;
        }

        @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
        public int getRequestId() {
            return this.zzaox;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, googleApiClient.zzr(messageListener), intentFilterArr));
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> addListener(GoogleApiClient client, MessageApi.MessageListener listener) {
        return zza(client, listener, new IntentFilter[]{zzbn.zzgM(MessageApi.ACTION_MESSAGE_RECEIVED)});
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> addListener(GoogleApiClient client, MessageApi.MessageListener listener, Uri uri, int filterType) {
        com.google.android.gms.common.internal.zzx.zzb(uri != null, "uri must not be null");
        com.google.android.gms.common.internal.zzx.zzb(filterType == 0 || filterType == 1, "invalid filter type");
        return zza(client, listener, new IntentFilter[]{zzbn.zza(MessageApi.ACTION_MESSAGE_RECEIVED, uri, filterType)});
    }

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageApi.MessageListener listener) {
        return client.zza(new zzi<Status>(client) { // from class: com.google.android.gms.wearable.internal.zzaz.2
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

    @Override // com.google.android.gms.wearable.MessageApi
    public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient client, final String nodeId, final String action, final byte[] data) {
        return client.zza(new zzi<MessageApi.SendMessageResult>(client) { // from class: com.google.android.gms.wearable.internal.zzaz.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzbp zzbpVar) throws RemoteException {
                zzbpVar.zza(this, nodeId, action, data);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzbz, reason: merged with bridge method [inline-methods] */
            public MessageApi.SendMessageResult zzc(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
