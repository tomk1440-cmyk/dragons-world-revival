package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zzj;
import com.google.android.gms.common.api.internal.zzq;
import com.google.android.gms.common.api.internal.zzu;
import com.google.android.gms.common.api.internal.zzw;
import com.google.android.gms.common.internal.zzad;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private static final Set<GoogleApiClient> zzagg = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {
        private final Context mContext;
        private Account zzTI;
        private String zzUW;
        private final Set<Scope> zzagh;
        private final Set<Scope> zzagi;
        private int zzagj;
        private View zzagk;
        private String zzagl;
        private final Map<Api<?>, zzf.zza> zzagm;
        private final Map<Api<?>, Api.ApiOptions> zzagn;
        private FragmentActivity zzago;
        private int zzagp;
        private OnConnectionFailedListener zzagq;
        private Looper zzagr;
        private com.google.android.gms.common.zzc zzags;
        private Api.zza<? extends zzrn, zzro> zzagt;
        private final ArrayList<ConnectionCallbacks> zzagu;
        private final ArrayList<OnConnectionFailedListener> zzagv;

        public Builder(@NonNull Context context) {
            this.zzagh = new HashSet();
            this.zzagi = new HashSet();
            this.zzagm = new ArrayMap();
            this.zzagn = new ArrayMap();
            this.zzagp = -1;
            this.zzags = com.google.android.gms.common.zzc.zzoK();
            this.zzagt = zzrl.zzUJ;
            this.zzagu = new ArrayList<>();
            this.zzagv = new ArrayList<>();
            this.mContext = context;
            this.zzagr = context.getMainLooper();
            this.zzUW = context.getPackageName();
            this.zzagl = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectedListener, @NonNull OnConnectionFailedListener connectionFailedListener) {
            this(context);
            zzx.zzb(connectedListener, "Must provide a connected listener");
            this.zzagu.add(connectedListener);
            zzx.zzb(connectionFailedListener, "Must provide a connection failed listener");
            this.zzagv.add(connectionFailedListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zzb, O> C zza(Api.zza<C, O> zzaVar, Object obj, Context context, Looper looper, zzf zzfVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return (C) zzaVar.zza(context, looper, zzfVar, obj, connectionCallbacks, onConnectionFailedListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zzd, O> zzad zza(Api.zze<C, O> zzeVar, Object obj, Context context, Looper looper, zzf zzfVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzad(context, looper, zzeVar.zzoU(), connectionCallbacks, onConnectionFailedListener, zzfVar, zzeVar.zzq(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid resolution mode: '" + i + "', use a constant from GoogleApiClient.ResolutionMode");
                }
                z = false;
            }
            HashSet hashSet = new HashSet(api.zzoP().zzo(o));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.zzagm.put(api, new zzf.zza(hashSet, z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void zza(zzw zzwVar, GoogleApiClient googleApiClient) {
            zzwVar.zza(this.zzagp, googleApiClient, this.zzagq);
        }

        private void zze(final GoogleApiClient googleApiClient) {
            zzw zzwVarZza = zzw.zza(this.zzago);
            if (zzwVarZza == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.common.api.GoogleApiClient.Builder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Builder.this.zzago.isFinishing() || Builder.this.zzago.getSupportFragmentManager().isDestroyed()) {
                            return;
                        }
                        Builder.this.zza(zzw.zzb(Builder.this.zzago), googleApiClient);
                    }
                });
            } else {
                zza(zzwVarZza, googleApiClient);
            }
        }

        private GoogleApiClient zzoZ() {
            Api.zzb zzbVarZza;
            Api<?> api;
            zzf zzfVarZzoY = zzoY();
            Api<?> api2 = null;
            Map<Api<?>, zzf.zza> mapZzqu = zzfVarZzoY.zzqu();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api<?> api3 = null;
            for (Api<?> api4 : this.zzagn.keySet()) {
                Api.ApiOptions apiOptions = this.zzagn.get(api4);
                int i = mapZzqu.get(api4) != null ? mapZzqu.get(api4).zzalf ? 1 : 2 : 0;
                arrayMap.put(api4, Integer.valueOf(i));
                com.google.android.gms.common.api.internal.zzc zzcVar = new com.google.android.gms.common.api.internal.zzc(api4, i);
                arrayList.add(zzcVar);
                if (api4.zzoS()) {
                    Api.zze<?, O> zzeVarZzoQ = api4.zzoQ();
                    Api<?> api5 = zzeVarZzoQ.getPriority() == 1 ? api4 : api3;
                    zzbVarZza = zza(zzeVarZzoQ, apiOptions, this.mContext, this.zzagr, zzfVarZzoY, zzcVar, zzcVar);
                    api = api5;
                } else {
                    Api.zza<?, O> zzaVarZzoP = api4.zzoP();
                    Api<?> api6 = zzaVarZzoP.getPriority() == 1 ? api4 : api3;
                    zzbVarZza = zza((Api.zza<Api.zzb, O>) zzaVarZzoP, (Object) apiOptions, this.mContext, this.zzagr, zzfVarZzoY, (ConnectionCallbacks) zzcVar, (OnConnectionFailedListener) zzcVar);
                    api = api6;
                }
                arrayMap2.put(api4.zzoR(), zzbVarZza);
                if (!zzbVarZza.zznb()) {
                    api4 = api2;
                } else if (api2 != null) {
                    throw new IllegalStateException(api4.getName() + " cannot be used with " + api2.getName());
                }
                api3 = api;
                api2 = api4;
            }
            if (api2 != null) {
                if (api3 != null) {
                    throw new IllegalStateException(api2.getName() + " cannot be used with " + api3.getName());
                }
                zzx.zza(this.zzTI == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api2.getName());
                zzx.zza(this.zzagh.equals(this.zzagi), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api2.getName());
            }
            return new zzj(this.mContext, new ReentrantLock(), this.zzagr, zzfVarZzoY, this.zzags, this.zzagt, arrayMap, this.zzagu, this.zzagv, arrayMap2, this.zzagp, zzj.zza(arrayMap2.values(), true), arrayList);
        }

        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzx.zzb(api, "Api must not be null");
            this.zzagn.put(api, null);
            List<Scope> listZzo = api.zzoP().zzo(null);
            this.zzagi.addAll(listZzo);
            this.zzagh.addAll(listZzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O options) {
            zzx.zzb(api, "Api must not be null");
            zzx.zzb(options, "Null options are not permitted for this Api");
            this.zzagn.put(api, options);
            List<Scope> listZzo = api.zzoP().zzo(options);
            this.zzagi.addAll(listZzo);
            this.zzagh.addAll(listZzo);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O options, Scope... scopes) {
            zzx.zzb(api, "Api must not be null");
            zzx.zzb(options, "Null options are not permitted for this Api");
            this.zzagn.put(api, options);
            zza(api, options, 1, scopes);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopes) {
            zzx.zzb(api, "Api must not be null");
            this.zzagn.put(api, null);
            zza(api, null, 1, scopes);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks listener) {
            zzx.zzb(listener, "Listener must not be null");
            this.zzagu.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener listener) {
            zzx.zzb(listener, "Listener must not be null");
            this.zzagv.add(listener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzx.zzb(scope, "Scope must not be null");
            this.zzagh.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzx.zzb(!this.zzagn.isEmpty(), "must call addApi() to add at least one API");
            GoogleApiClient googleApiClientZzoZ = zzoZ();
            synchronized (GoogleApiClient.zzagg) {
                GoogleApiClient.zzagg.add(googleApiClientZzoZ);
            }
            if (this.zzagp >= 0) {
                zze(googleApiClientZzoZ);
            }
            return googleApiClientZzoZ;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int clientId, @Nullable OnConnectionFailedListener unresolvedConnectionFailedListener) {
            zzx.zzb(clientId >= 0, "clientId must be non-negative");
            this.zzagp = clientId;
            this.zzago = (FragmentActivity) zzx.zzb(fragmentActivity, "Null activity is not permitted.");
            this.zzagq = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener unresolvedConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, unresolvedConnectionFailedListener);
        }

        public Builder setAccountName(String accountName) {
            this.zzTI = accountName == null ? null : new Account(accountName, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.zzagj = gravityForPopups;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzx.zzb(handler, "Handler must not be null");
            this.zzagr = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View viewForPopups) {
            zzx.zzb(viewForPopups, "View must not be null");
            this.zzagk = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public zzf zzoY() {
            zzro zzroVar = zzro.zzbgV;
            if (this.zzagn.containsKey(zzrl.API)) {
                zzroVar = (zzro) this.zzagn.get(zzrl.API);
            }
            return new zzf(this.zzTI, this.zzagh, this.zzagm, this.zzagj, this.zzagk, this.zzUW, this.zzagl, zzroVar);
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public interface zza {
        void zza(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        synchronized (zzagg) {
            String str = prefix + "  ";
            int i = 0;
            for (GoogleApiClient googleApiClient : zzagg) {
                writer.append((CharSequence) prefix).append("GoogleApiClient#").println(i);
                googleApiClient.dump(str, fd, writer, args);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzoV() {
        return zzagg;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int signInMode) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> zzcVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, A>> T zza(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zza(com.google.android.gms.common.api.internal.zzx zzxVar) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzu zzuVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<? extends Result, A>> T zzb(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public void zzb(com.google.android.gms.common.api.internal.zzx zzxVar) {
        throw new UnsupportedOperationException();
    }

    public void zzoW() {
        throw new UnsupportedOperationException();
    }

    public <L> zzq<L> zzr(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
