package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zzn implements Messages {
    public static final Api.zzc<zzm> zzUI = new Api.zzc<>();
    public static final Api.zza<zzm, MessagesOptions> zzUJ = new Api.zza<zzm, MessagesOptions>() { // from class: com.google.android.gms.nearby.messages.internal.zzn.1
        @Override // com.google.android.gms.common.api.Api.zza
        public int getPriority() {
            return Strategy.TTL_SECONDS_INFINITE;
        }

        @Override // com.google.android.gms.common.api.Api.zza
        public zzm zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, MessagesOptions messagesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzm(context, looper, connectionCallbacks, onConnectionFailedListener, zzfVar, messagesOptions);
        }
    };

    static abstract class zza extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<Status, zzm> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzn.zzUI, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Nullable
    private static Message zzA(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.MESSAGES");
    }

    @Nullable
    private static Message zzB(Intent intent) {
        return (Message) zzj.zzc(intent, "com.google.android.gms.nearby.messages.LOST_MESSAGE");
    }

    private static List<Message> zzC(Intent intent) {
        return zzj.zzd(intent, "com.google.android.gms.nearby.messages.UPDATED_MESSAGES");
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> getPermissionStatus(GoogleApiClient client) {
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zzm(this);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public void handleIntent(Intent intent, MessageListener messageListener) {
        Message messageZzA = zzA(intent);
        if (messageZzA != null) {
            messageListener.onFound(messageZzA);
        }
        Message messageZzB = zzB(intent);
        if (messageZzB != null) {
            messageListener.onLost(messageZzB);
        }
        Iterator<Message> it = zzC(intent).iterator();
        while (it.hasNext()) {
            messageListener.zza(it.next());
        }
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> publish(GoogleApiClient client, Message message) {
        return publish(client, message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> publish(GoogleApiClient client, final Message message, final PublishOptions options) {
        zzx.zzz(message);
        zzx.zzz(options);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, MessageWrapper.zzb(message), options);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult<Status> publish(GoogleApiClient client, Message message, Strategy strategy) {
        return publish(client, message, new PublishOptions.Builder().setStrategy(strategy).build());
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> registerStatusCallback(GoogleApiClient client, final StatusCallback statusCallback) {
        zzx.zzz(statusCallback);
        final com.google.android.gms.common.api.internal.zzq<StatusCallback> zzqVarZza = ((zzm) client.zza(zzUI)).zza(client, statusCallback);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, zzqVarZza, statusCallback);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> subscribe(GoogleApiClient client, PendingIntent pendingIntent) {
        return subscribe(client, pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> subscribe(GoogleApiClient client, final PendingIntent pendingIntent, final SubscribeOptions options) {
        zzx.zzz(pendingIntent);
        zzx.zzz(options);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, pendingIntent, options);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener) {
        return subscribe(client, listener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).build());
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    @Deprecated
    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy, MessageFilter filter) {
        return subscribe(client, listener, new SubscribeOptions.Builder().setStrategy(strategy).setFilter(filter).build());
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> subscribe(GoogleApiClient client, final MessageListener listener, final SubscribeOptions options) {
        zzx.zzz(listener);
        zzx.zzz(options);
        final com.google.android.gms.common.api.internal.zzq<MessageListener> zzqVarZza = ((zzm) client.zza(zzUI)).zza(client, listener);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, zzqVarZza, listener, options, null);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> unpublish(GoogleApiClient client, final Message message) {
        zzx.zzz(message);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, MessageWrapper.zzb(message));
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> unregisterStatusCallback(GoogleApiClient client, final StatusCallback statusCallback) {
        final com.google.android.gms.common.api.internal.zzq<StatusCallback> zzqVarZza = ((zzm) client.zza(zzUI)).zza(client, statusCallback);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zzb(this, zzqVarZza, statusCallback);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> unsubscribe(GoogleApiClient client, final PendingIntent pendingIntent) {
        zzx.zzz(pendingIntent);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, pendingIntent);
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public PendingResult<Status> unsubscribe(GoogleApiClient client, final MessageListener listener) {
        zzx.zzz(listener);
        final com.google.android.gms.common.api.internal.zzq<MessageListener> zzqVarZza = ((zzm) client.zza(zzUI)).zza(client, listener);
        return client.zzb(new zza(client) { // from class: com.google.android.gms.nearby.messages.internal.zzn.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzm zzmVar) throws RemoteException {
                zzmVar.zza(this, zzqVarZza, listener);
            }
        });
    }
}
