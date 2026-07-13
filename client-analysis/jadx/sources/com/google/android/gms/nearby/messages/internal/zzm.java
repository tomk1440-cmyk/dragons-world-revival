package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishCallback;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes.dex */
public class zzm extends com.google.android.gms.common.internal.zzj<com.google.android.gms.nearby.messages.internal.zzf> {
    private final boolean zzbcv;
    private final ClientAppContext zzbcw;
    private final zzg<StatusCallback, zze> zzbcx;
    private final zzg<MessageListener, zzc> zzbcy;

    private interface zza<C> {
        com.google.android.gms.common.api.internal.zzq<C> zzEE();
    }

    @TargetApi(14)
    private static class zzb implements Application.ActivityLifecycleCallbacks {
        private final Activity zzbcA;
        private final zzm zzbcB;

        private zzb(Activity activity, zzm zzmVar) {
            this.zzbcA = activity;
            this.zzbcB = zzmVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity == this.zzbcA) {
                Log.v("NearbyMessagesClient", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity == this.zzbcA) {
                try {
                    this.zzbcB.zzjq(1);
                } catch (RemoteException e) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", activity.getPackageName(), e));
                }
            }
        }
    }

    private static class zzc extends com.google.android.gms.nearby.messages.internal.zzd.zza implements zza<MessageListener> {
        private final com.google.android.gms.common.api.internal.zzq<MessageListener> zzbbi;

        private zzc(com.google.android.gms.common.api.internal.zzq<MessageListener> zzqVar) {
            this.zzbbi = zzqVar;
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzm.zza
        public com.google.android.gms.common.api.internal.zzq<MessageListener> zzEE() {
            return this.zzbbi;
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzd
        public void zza(final MessageWrapper messageWrapper) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zzc.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(MessageListener messageListener) {
                    messageListener.onFound(messageWrapper.zzbcu);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzd
        public void zza(final MessageWrapper[] messageWrapperArr) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zzc.2
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(MessageListener messageListener) {
                    for (MessageWrapper messageWrapper : messageWrapperArr) {
                        messageListener.zza(messageWrapper.zzbcu);
                    }
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzd
        public void zzb(final MessageWrapper messageWrapper) throws RemoteException {
            this.zzbbi.zza(new com.google.android.gms.common.api.internal.zzq.zzb<MessageListener>() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zzc.3
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(MessageListener messageListener) {
                    messageListener.onLost(messageWrapper.zzbcu);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }
    }

    private static class zzd extends com.google.android.gms.nearby.messages.internal.zzg.zza {
        private final PublishCallback zzbcG;

        private zzd(PublishCallback publishCallback) {
            this.zzbcG = publishCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static zzd zza(@Nullable PublishCallback publishCallback) {
            if (publishCallback == null) {
                return null;
            }
            return new zzd(publishCallback);
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzg
        public void onExpired() {
            this.zzbcG.onExpired();
        }
    }

    private static class zze extends zzh.zza implements zza<StatusCallback> {
        private final com.google.android.gms.common.api.internal.zzq<StatusCallback> zzbcH;

        private zze(com.google.android.gms.common.api.internal.zzq<StatusCallback> zzqVar) {
            this.zzbcH = zzqVar;
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzh
        public void onPermissionChanged(final boolean granted) {
            this.zzbcH.zza(new com.google.android.gms.common.api.internal.zzq.zzb<StatusCallback>() { // from class: com.google.android.gms.nearby.messages.internal.zzm.zze.1
                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void zzt(StatusCallback statusCallback) {
                    statusCallback.onPermissionChanged(granted);
                }

                @Override // com.google.android.gms.common.api.internal.zzq.zzb
                public void zzpr() {
                }
            });
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzm.zza
        public com.google.android.gms.common.api.internal.zzq<StatusCallback> zzEE() {
            return this.zzbcH;
        }
    }

    private static class zzf extends zzi.zza {
        private final SubscribeCallback zzbcK;

        private zzf(SubscribeCallback subscribeCallback) {
            this.zzbcK = subscribeCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Nullable
        public static zzf zza(@Nullable SubscribeCallback subscribeCallback) {
            if (subscribeCallback == null) {
                return null;
            }
            return new zzf(subscribeCallback);
        }

        @Override // com.google.android.gms.nearby.messages.internal.zzi
        public void onExpired() {
            this.zzbcK.onExpired();
        }
    }

    private static abstract class zzg<C, W extends zza<C>> {
        private final SimpleArrayMap<C, W> zzanP;

        private zzg() {
            this.zzanP = new SimpleArrayMap<>(1);
        }

        @Nullable
        W zzG(C c) {
            return this.zzanP.get(c);
        }

        @Nullable
        W zzH(C c) {
            W wRemove = this.zzanP.remove(c);
            if (wRemove != null) {
                wRemove.zzEE().clear();
            }
            return wRemove;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        W zza(com.google.android.gms.common.api.internal.zzq<C> zzqVar, C c) {
            W w = this.zzanP.get(c);
            if (w != null) {
                zzqVar.clear();
                return w;
            }
            W w2 = (W) zzf(zzqVar);
            this.zzanP.put(c, w2);
            return w2;
        }

        protected abstract W zzf(com.google.android.gms.common.api.internal.zzq<C> zzqVar);
    }

    @TargetApi(14)
    zzm(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar, MessagesOptions messagesOptions) {
        super(context, looper, 62, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzbcx = new zzg<StatusCallback, zze>() { // from class: com.google.android.gms.nearby.messages.internal.zzm.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.nearby.messages.internal.zzm.zzg
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public zze zzf(com.google.android.gms.common.api.internal.zzq<StatusCallback> zzqVar) {
                return new zze(zzqVar);
            }
        };
        this.zzbcy = new zzg<MessageListener, zzc>() { // from class: com.google.android.gms.nearby.messages.internal.zzm.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.nearby.messages.internal.zzm.zzg
            /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
            public zzc zzf(com.google.android.gms.common.api.internal.zzq<MessageListener> zzqVar) {
                return new zzc(zzqVar);
            }
        };
        String strZzqv = zzfVar.zzqv();
        int iZzaU = zzaU(context);
        if (messagesOptions != null) {
            this.zzbcw = new ClientAppContext(strZzqv, messagesOptions.zzbbF, messagesOptions.zzbbH, iZzaU);
            this.zzbcv = messagesOptions.zzbbG;
        } else {
            this.zzbcw = new ClientAppContext(strZzqv, null, false, iZzaU);
            this.zzbcv = false;
        }
        if (iZzaU == 1 && zzne.zzsg()) {
            Activity activity = (Activity) context;
            Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName()));
            activity.getApplication().registerActivityLifecycleCallbacks(new zzb(activity, this));
        }
    }

    private static <C> com.google.android.gms.common.api.internal.zzq<C> zza(GoogleApiClient googleApiClient, C c, zzg<C, ? extends zza<C>> zzgVar) {
        zza zzaVarZzG = zzgVar.zzG(c);
        return zzaVarZzG != null ? zzaVarZzG.zzEE() : googleApiClient.zzr(c);
    }

    private static int zzaU(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        try {
            zzjq(2);
        } catch (RemoteException e) {
            Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e));
        }
        super.disconnect();
    }

    com.google.android.gms.common.api.internal.zzq<MessageListener> zza(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, messageListener, this.zzbcy);
    }

    com.google.android.gms.common.api.internal.zzq<StatusCallback> zza(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        return zza(googleApiClient, statusCallback, this.zzbcx);
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, PendingIntent pendingIntent) throws RemoteException {
        zzqJ().zza(new UnsubscribeRequest(null, zzp.zzn(zzbVar), pendingIntent, 0, this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) throws RemoteException {
        zzqJ().zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), zzp.zzn(zzbVar), subscribeOptions.getFilter(), pendingIntent, 0, null, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<MessageListener> zzqVar, MessageListener messageListener) throws RemoteException {
        if (this.zzbcy.zzG(messageListener) == null) {
            return;
        }
        zzqJ().zza(new UnsubscribeRequest((IBinder) this.zzbcy.zza(zzqVar, messageListener), zzp.zzn(zzbVar), null, 0, this.zzbcw));
        this.zzbcy.zzH(messageListener);
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<MessageListener> zzqVar, MessageListener messageListener, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) throws RemoteException {
        zzqJ().zza(new SubscribeRequest((IBinder) this.zzbcy.zza(zzqVar, messageListener), subscribeOptions.getStrategy(), zzp.zzn(zzbVar), subscribeOptions.getFilter(), null, 0, bArr, this.zzbcv, zzf.zza(subscribeOptions.getCallback()), this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<StatusCallback> zzqVar, StatusCallback statusCallback) throws RemoteException {
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(zzbVar), (IBinder) this.zzbcx.zza(zzqVar, statusCallback), this.zzbcw);
        registerStatusCallbackRequest.zzbcX = true;
        zzqJ().zza(registerStatusCallbackRequest);
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, MessageWrapper messageWrapper) throws RemoteException {
        zzqJ().zza(new UnpublishRequest(messageWrapper, zzp.zzn(zzbVar), this.zzbcw));
    }

    void zza(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, MessageWrapper messageWrapper, PublishOptions publishOptions) throws RemoteException {
        zzqJ().zza(new PublishRequest(messageWrapper, publishOptions.getStrategy(), zzp.zzn(zzbVar), this.zzbcv, zzd.zza(publishOptions.getCallback()), this.zzbcw));
    }

    void zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, com.google.android.gms.common.api.internal.zzq<StatusCallback> zzqVar, StatusCallback statusCallback) throws RemoteException {
        if (this.zzbcx.zzG(statusCallback) == null) {
            return;
        }
        RegisterStatusCallbackRequest registerStatusCallbackRequest = new RegisterStatusCallbackRequest(zzp.zzn(zzbVar), (IBinder) this.zzbcx.zza(zzqVar, statusCallback), this.zzbcw);
        registerStatusCallbackRequest.zzbcX = false;
        zzqJ().zza(registerStatusCallbackRequest);
        this.zzbcx.zzH(statusCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzdE, reason: merged with bridge method [inline-methods] */
    public com.google.android.gms.nearby.messages.internal.zzf zzW(IBinder iBinder) {
        return com.google.android.gms.nearby.messages.internal.zzf.zza.zzdA(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    @NonNull
    protected String zzgu() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    @NonNull
    protected String zzgv() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    void zzjq(int i) throws RemoteException {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i)));
                return;
        }
        if (!isConnected()) {
            Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str));
            return;
        }
        HandleClientLifecycleEventRequest handleClientLifecycleEventRequest = new HandleClientLifecycleEventRequest(this.zzbcw, i);
        Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", str));
        zzqJ().zza(handleClientLifecycleEventRequest);
    }

    void zzm(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws RemoteException {
        zzqJ().zza(new GetPermissionStatusRequest(zzp.zzn(zzbVar), this.zzbcw));
    }
}
