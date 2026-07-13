package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzj extends GoogleApiClient implements zzp.zza {
    private final Context mContext;
    private final Lock zzXG;
    private final int zzagp;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    final Api.zza<? extends zzrn, zzro> zzagt;
    final Map<Api<?>, Integer> zzahA;
    private final com.google.android.gms.common.internal.zzk zzahL;
    private volatile boolean zzahO;
    private final zza zzahR;
    zzc zzahS;
    final Map<Api.zzc<?>, Api.zzb> zzahT;
    private com.google.android.gms.common.api.zza zzahX;
    private final ArrayList<com.google.android.gms.common.api.internal.zzc> zzahY;
    private Integer zzahZ;
    final com.google.android.gms.common.internal.zzf zzahz;
    private zzp zzahM = null;
    final Queue<com.google.android.gms.common.api.internal.zza.AbstractC0049zza<?, ?>> zzahN = new LinkedList();
    private long zzahP = 120000;
    private long zzahQ = 5000;
    Set<Scope> zzahU = new HashSet();
    private final Set<zzq<?>> zzahV = Collections.newSetFromMap(new WeakHashMap());
    final Set<zze<?>> zzahW = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    Set<zzx> zzaia = null;
    private final zzd zzaib = new zzd() { // from class: com.google.android.gms.common.api.internal.zzj.1
        @Override // com.google.android.gms.common.api.internal.zzj.zzd
        public void zzc(zze<?> zzeVar) {
            zzj.this.zzahW.remove(zzeVar);
            if (zzeVar.zzpa() == null || zzj.this.zzahX == null) {
                return;
            }
            zzj.this.zzahX.remove(zzeVar.zzpa().intValue());
        }
    };
    private final com.google.android.gms.common.internal.zzk.zza zzaic = new com.google.android.gms.common.internal.zzk.zza() { // from class: com.google.android.gms.common.api.internal.zzj.2
        @Override // com.google.android.gms.common.internal.zzk.zza
        public boolean isConnected() {
            return zzj.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzk.zza
        public Bundle zzoi() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzj.this.zzpD();
                    break;
                case 2:
                    zzj.this.resume();
                    break;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    break;
            }
        }
    }

    private static class zzb implements IBinder.DeathRecipient, zzd {
        private final WeakReference<zze<?>> zzaii;
        private final WeakReference<com.google.android.gms.common.api.zza> zzaij;
        private final WeakReference<IBinder> zzaik;

        private zzb(zze zzeVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
            this.zzaij = new WeakReference<>(zzaVar);
            this.zzaii = new WeakReference<>(zzeVar);
            this.zzaik = new WeakReference<>(iBinder);
        }

        private void zzpI() {
            zze<?> zzeVar = this.zzaii.get();
            com.google.android.gms.common.api.zza zzaVar = this.zzaij.get();
            if (zzaVar != null && zzeVar != null) {
                zzaVar.remove(zzeVar.zzpa().intValue());
            }
            IBinder iBinder = this.zzaik.get();
            if (this.zzaik != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            zzpI();
        }

        @Override // com.google.android.gms.common.api.internal.zzj.zzd
        public void zzc(zze<?> zzeVar) {
            zzpI();
        }
    }

    static class zzc extends zzn {
        private WeakReference<zzj> zzail;

        zzc(zzj zzjVar) {
            this.zzail = new WeakReference<>(zzjVar);
        }

        @Override // com.google.android.gms.common.api.internal.zzn
        public void zzpJ() {
            zzj zzjVar = this.zzail.get();
            if (zzjVar == null) {
                return;
            }
            zzjVar.resume();
        }
    }

    interface zzd {
        void zzc(zze<?> zzeVar);
    }

    interface zze<A extends Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(zzd zzdVar);

        void zzb(A a) throws DeadObjectException;

        Api.zzc<A> zzoR();

        Integer zzpa();

        void zzpe();

        void zzpg();

        void zzw(Status status);

        void zzx(Status status);
    }

    public zzj(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, com.google.android.gms.common.zzc zzcVar, Api.zza<? extends zzrn, zzro> zzaVar, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zzb> map2, int i, int i2, ArrayList<com.google.android.gms.common.api.internal.zzc> arrayList) {
        this.zzahZ = null;
        this.mContext = context;
        this.zzXG = lock;
        this.zzahL = new com.google.android.gms.common.internal.zzk(looper, this.zzaic);
        this.zzagr = looper;
        this.zzahR = new zza(looper);
        this.zzags = zzcVar;
        this.zzagp = i;
        if (this.zzagp >= 0) {
            this.zzahZ = Integer.valueOf(i2);
        }
        this.zzahA = map;
        this.zzahT = map2;
        this.zzahY = arrayList;
        Iterator<GoogleApiClient.ConnectionCallbacks> it = list.iterator();
        while (it.hasNext()) {
            this.zzahL.registerConnectionCallbacks(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.zzahL.registerConnectionFailedListener(it2.next());
        }
        this.zzahz = zzfVar;
        this.zzagt = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.zzXG.lock();
        try {
            if (zzpB()) {
                zzpC();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    public static int zza(Iterable<Api.zzb> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zzb zzbVar : iterable) {
            if (zzbVar.zzmE()) {
                z3 = true;
            }
            z2 = zzbVar.zznb() ? true : z2;
        }
        if (z3) {
            return (z2 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzv zzvVar, final boolean z) {
        zzmf.zzamA.zzf(googleApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.google.android.gms.common.api.internal.zzj.5
            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(@NonNull Status status) {
                com.google.android.gms.auth.api.signin.internal.zzq.zzaf(zzj.this.mContext).zznr();
                if (status.isSuccess() && zzj.this.isConnected()) {
                    zzj.this.reconnect();
                }
                zzvVar.zza(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private static void zza(zze<?> zzeVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
        if (zzeVar.isReady()) {
            zzeVar.zza(new zzb(zzeVar, zzaVar, iBinder));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            zzeVar.zza(null);
            zzeVar.cancel();
            zzaVar.remove(zzeVar.zzpa().intValue());
        } else {
            zzb zzbVar = new zzb(zzeVar, zzaVar, iBinder);
            zzeVar.zza(zzbVar);
            try {
                iBinder.linkToDeath(zzbVar, 0);
            } catch (RemoteException e) {
                zzeVar.cancel();
                zzaVar.remove(zzeVar.zzpa().intValue());
            }
        }
    }

    private void zzbB(int i) {
        if (this.zzahZ == null) {
            this.zzahZ = Integer.valueOf(i);
        } else if (this.zzahZ.intValue() != i) {
            throw new IllegalStateException("Cannot use sign-in mode: " + zzbC(i) + ". Mode was already set to " + zzbC(this.zzahZ.intValue()));
        }
        if (this.zzahM != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.zzb zzbVar : this.zzahT.values()) {
            if (zzbVar.zzmE()) {
                z2 = true;
            }
            z = zzbVar.zznb() ? true : z;
        }
        switch (this.zzahZ.intValue()) {
            case 1:
                if (!z2) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            case 2:
                if (z2) {
                    this.zzahM = new com.google.android.gms.common.api.internal.zzd(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY);
                    return;
                }
                break;
        }
        this.zzahM = new zzl(this.mContext, this, this.zzXG, this.zzagr, this.zzags, this.zzahT, this.zzahz, this.zzahA, this.zzagt, this.zzahY, this);
    }

    static String zzbC(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void zzpC() {
        this.zzahL.zzqR();
        this.zzahM.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpD() {
        this.zzXG.lock();
        try {
            if (zzpF()) {
                zzpC();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        com.google.android.gms.common.internal.zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                com.google.android.gms.common.internal.zzx.zza(this.zzahZ != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            ConnectionResult connectionResultBlockingConnect = this.zzahM.blockingConnect();
            this.zzXG.unlock();
            return connectionResultBlockingConnect;
        } catch (Throwable th) {
            this.zzXG.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long timeout, @NonNull TimeUnit unit) {
        com.google.android.gms.common.internal.zzx.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        com.google.android.gms.common.internal.zzx.zzb(unit, "TimeUnit must not be null");
        this.zzXG.lock();
        try {
            if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzbB(this.zzahZ.intValue());
            this.zzahL.zzqR();
            ConnectionResult connectionResultBlockingConnect = this.zzahM.blockingConnect(timeout, unit);
            this.zzXG.unlock();
            return connectionResultBlockingConnect;
        } catch (Throwable th) {
            this.zzXG.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        com.google.android.gms.common.internal.zzx.zza(isConnected(), "GoogleApiClient is not connected yet.");
        com.google.android.gms.common.internal.zzx.zza(this.zzahZ.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzv zzvVar = new zzv(this);
        if (this.zzahT.containsKey(zzmf.zzUI)) {
            zza((GoogleApiClient) this, zzvVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient googleApiClientBuild = new GoogleApiClient.Builder(this.mContext).addApi(zzmf.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.common.api.internal.zzj.3
                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle connectionHint) {
                    zzj.this.zza((GoogleApiClient) atomicReference.get(), zzvVar, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int cause) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.common.api.internal.zzj.4
                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(@NonNull ConnectionResult result) {
                    zzvVar.zza(new Status(8));
                }
            }).setHandler(this.zzahR).build();
            atomicReference.set(googleApiClientBuild);
            googleApiClientBuild.connect();
        }
        return zzvVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.zzXG.lock();
        try {
            if (this.zzagp >= 0) {
                com.google.android.gms.common.internal.zzx.zza(this.zzahZ != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzahZ == null) {
                this.zzahZ = Integer.valueOf(zza(this.zzahT.values(), false));
            } else if (this.zzahZ.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzahZ.intValue());
            this.zzXG.unlock();
        } catch (Throwable th) {
            this.zzXG.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect(int signInMode) {
        boolean z = true;
        this.zzXG.lock();
        if (signInMode != 3 && signInMode != 1 && signInMode != 2) {
            z = false;
        }
        try {
            com.google.android.gms.common.internal.zzx.zzb(z, "Illegal sign-in mode: " + signInMode);
            zzbB(signInMode);
            zzpC();
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        this.zzXG.lock();
        try {
            zzaa((this.zzahM == null || this.zzahM.disconnect()) ? false : true);
            Iterator<zzq<?>> it = this.zzahV.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            this.zzahV.clear();
            for (com.google.android.gms.common.api.internal.zza.AbstractC0049zza<?, ?> abstractC0049zza : this.zzahN) {
                abstractC0049zza.zza((zzd) null);
                abstractC0049zza.cancel();
            }
            this.zzahN.clear();
            if (this.zzahM == null) {
                return;
            }
            zzpF();
            this.zzahL.zzqQ();
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append((CharSequence) prefix).append("mContext=").println(this.mContext);
        writer.append((CharSequence) prefix).append("mResuming=").print(this.zzahO);
        writer.append(" mWorkQueue.size()=").print(this.zzahN.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzahW.size());
        if (this.zzahM != null) {
            this.zzahM.dump(prefix, fd, writer, args);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzXG.lock();
        try {
            if (!isConnected() && !zzpB()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zzahT.containsKey(api.zzoR())) {
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
            ConnectionResult connectionResult = this.zzahM.getConnectionResult(api);
            if (connectionResult != null) {
                this.zzXG.unlock();
            } else if (zzpB()) {
                connectionResult = ConnectionResult.zzafB;
                this.zzXG.unlock();
            } else {
                Log.i("GoogleApiClientImpl", zzpH());
                Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult is not connected but is not present in the failed  connections map", new Exception());
                connectionResult = new ConnectionResult(8, null);
                this.zzXG.unlock();
            }
            return connectionResult;
        } catch (Throwable th) {
            this.zzXG.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzagr;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zzb zzbVar = this.zzahT.get(api.zzoR());
        return zzbVar != null && zzbVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        return this.zzahM != null && this.zzahM.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        return this.zzahM != null && this.zzahM.isConnecting();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks listener) {
        return this.zzahL.isConnectionCallbacksRegistered(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener listener) {
        return this.zzahL.isConnectionFailedListenerRegistered(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks listener) {
        this.zzahL.registerConnectionCallbacks(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener listener) {
        this.zzahL.registerConnectionFailedListener(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(@NonNull final FragmentActivity lifecycleActivity) {
        if (this.zzagp < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zzw zzwVarZza = zzw.zza(lifecycleActivity);
        if (zzwVarZza == null) {
            new Handler(this.mContext.getMainLooper()).post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zzj.6
                @Override // java.lang.Runnable
                public void run() {
                    if (lifecycleActivity.isFinishing() || lifecycleActivity.getSupportFragmentManager().isDestroyed()) {
                        return;
                    }
                    zzw.zzb(lifecycleActivity).zzbD(zzj.this.zzagp);
                }
            });
        } else {
            zzwVarZza.zzbD(this.zzagp);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks listener) {
        this.zzahL.unregisterConnectionCallbacks(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener listener) {
        this.zzahL.unregisterConnectionFailedListener(listener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public <C extends Api.zzb> C zza(@NonNull Api.zzc<C> zzcVar) {
        C c = (C) this.zzahT.get(zzcVar);
        com.google.android.gms.common.internal.zzx.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, A>> T zza(@NonNull T t) {
        com.google.android.gms.common.internal.zzx.zzb(t.zzoR() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        com.google.android.gms.common.internal.zzx.zzb(this.zzahT.containsKey(t.zzoR()), "GoogleApiClient is not configured to use the API required for this call.");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                this.zzahN.add(t);
            } else {
                t = (T) this.zzahM.zza(t);
            }
            return t;
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zza(zzx zzxVar) {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                this.zzaia = new HashSet();
            }
            this.zzaia.add(zzxVar);
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(@NonNull Api<?> api) {
        return this.zzahT.containsKey(api.zzoR());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(zzu zzuVar) {
        return this.zzahM != null && this.zzahM.zza(zzuVar);
    }

    void zzaa(boolean z) {
        for (zze<?> zzeVar : this.zzahW) {
            if (zzeVar.zzpa() != null) {
                zzeVar.zzpe();
                zza(zzeVar, this.zzahX, zza((Api.zzc) zzeVar.zzoR()).zzoT());
                this.zzahW.remove(zzeVar);
            } else if (z) {
                zzeVar.zzpg();
            } else {
                zzeVar.cancel();
                this.zzahW.remove(zzeVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<? extends Result, A>> T zzb(@NonNull T t) {
        com.google.android.gms.common.internal.zzx.zzb(t.zzoR() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.zzXG.lock();
        try {
            if (this.zzahM == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (zzpB()) {
                this.zzahN.add(t);
                while (!this.zzahN.isEmpty()) {
                    com.google.android.gms.common.api.internal.zza.AbstractC0049zza<?, ?> abstractC0049zzaRemove = this.zzahN.remove();
                    zzb((zze) abstractC0049zzaRemove);
                    abstractC0049zzaRemove.zzw(Status.zzagE);
                }
                this.zzXG.unlock();
            } else {
                t = (T) this.zzahM.zzb(t);
                this.zzXG.unlock();
            }
            return t;
        } catch (Throwable th) {
            this.zzXG.unlock();
            throw th;
        }
    }

    <A extends Api.zzb> void zzb(zze<A> zzeVar) {
        this.zzahW.add(zzeVar);
        zzeVar.zza(this.zzaib);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzb(zzx zzxVar) {
        this.zzXG.lock();
        try {
            if (this.zzaia == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zzaia.remove(zzxVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzpG()) {
                this.zzahM.zzpj();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp.zza
    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzpE();
        }
        for (zze<?> zzeVar : this.zzahW) {
            if (z) {
                zzeVar.zzpe();
            }
            zzeVar.zzx(new Status(8, "The connection to Google Play services was lost"));
        }
        this.zzahW.clear();
        this.zzahL.zzbT(i);
        this.zzahL.zzqQ();
        if (i == 2) {
            zzpC();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp.zza
    public void zzd(ConnectionResult connectionResult) {
        if (!this.zzags.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzpF();
        }
        if (zzpB()) {
            return;
        }
        this.zzahL.zzk(connectionResult);
        this.zzahL.zzqQ();
    }

    @Override // com.google.android.gms.common.api.internal.zzp.zza
    public void zzi(Bundle bundle) {
        while (!this.zzahN.isEmpty()) {
            zzb(this.zzahN.remove());
        }
        this.zzahL.zzk(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzoW() {
        if (this.zzahM != null) {
            this.zzahM.zzoW();
        }
    }

    boolean zzpB() {
        return this.zzahO;
    }

    void zzpE() {
        if (zzpB()) {
            return;
        }
        this.zzahO = true;
        if (this.zzahS == null) {
            this.zzahS = (zzc) zzn.zza(this.mContext.getApplicationContext(), new zzc(this), this.zzags);
        }
        this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(1), this.zzahP);
        this.zzahR.sendMessageDelayed(this.zzahR.obtainMessage(2), this.zzahQ);
    }

    boolean zzpF() {
        if (!zzpB()) {
            return false;
        }
        this.zzahO = false;
        this.zzahR.removeMessages(2);
        this.zzahR.removeMessages(1);
        if (this.zzahS != null) {
            this.zzahS.unregister();
            this.zzahS = null;
        }
        return true;
    }

    boolean zzpG() {
        boolean z = false;
        this.zzXG.lock();
        try {
            if (this.zzaia != null) {
                z = this.zzaia.isEmpty() ? false : true;
            }
            return z;
        } finally {
            this.zzXG.unlock();
        }
    }

    String zzpH() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzq<L> zzr(@NonNull L l) {
        com.google.android.gms.common.internal.zzx.zzb(l, "Listener must not be null");
        this.zzXG.lock();
        try {
            zzq<L> zzqVar = new zzq<>(this.zzagr, l);
            this.zzahV.add(zzqVar);
            return zzqVar;
        } finally {
            this.zzXG.unlock();
        }
    }
}
