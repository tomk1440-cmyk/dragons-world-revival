package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class zzl implements zzp {
    private final Context mContext;
    private final Lock zzXG;
    final zzj zzagW;
    private final com.google.android.gms.common.zzc zzags;
    final Api.zza<? extends zzrn, zzro> zzagt;
    final Map<Api<?>, Integer> zzahA;
    final Map<Api.zzc<?>, Api.zzb> zzahT;
    final com.google.android.gms.common.internal.zzf zzahz;
    private final Condition zzaim;
    private final zzb zzain;
    private volatile zzk zzaip;
    int zzair;
    final zzp.zza zzais;
    final Map<Api.zzc<?>, ConnectionResult> zzaio = new HashMap();
    private ConnectionResult zzaiq = null;

    static abstract class zza {
        private final zzk zzait;

        protected zza(zzk zzkVar) {
            this.zzait = zzkVar;
        }

        public final void zzd(zzl zzlVar) {
            zzlVar.zzXG.lock();
            try {
                if (zzlVar.zzaip != this.zzait) {
                    return;
                }
                zzpt();
            } finally {
                zzlVar.zzXG.unlock();
            }
        }

        protected abstract void zzpt();
    }

    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    ((zza) msg.obj).zzd(zzl.this);
                    return;
                case 2:
                    throw ((RuntimeException) msg.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    public zzl(Context context, zzj zzjVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zzb> map, com.google.android.gms.common.internal.zzf zzfVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zzaVar, ArrayList<zzc> arrayList, zzp.zza zzaVar2) {
        this.mContext = context;
        this.zzXG = lock;
        this.zzags = zzcVar;
        this.zzahT = map;
        this.zzahz = zzfVar;
        this.zzahA = map2;
        this.zzagt = zzaVar;
        this.zzagW = zzjVar;
        this.zzais = zzaVar2;
        Iterator<zzc> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.zzain = new zzb(looper);
        this.zzaim = lock.newCondition();
        this.zzaip = new zzi(this);
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.zzaim.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.zzafB;
        }
        return this.zzaiq != null ? this.zzaiq : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        connect();
        long nanos = unit.toNanos(timeout);
        while (isConnecting()) {
            if (nanos <= 0) {
                disconnect();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.zzaim.awaitNanos(nanos);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.zzafB;
        }
        return this.zzaiq != null ? this.zzaiq : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void connect() {
        this.zzaip.connect();
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean disconnect() {
        boolean zDisconnect = this.zzaip.disconnect();
        if (zDisconnect) {
            this.zzaio.clear();
        }
        return zDisconnect;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String str = prefix + "  ";
        for (Api<?> api : this.zzahA.keySet()) {
            writer.append((CharSequence) prefix).append((CharSequence) api.getName()).println(":");
            this.zzahT.get(api.zzoR()).dump(str, fd, writer, args);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc<?> zzcVarZzoR = api.zzoR();
        if (this.zzahT.containsKey(zzcVarZzoR)) {
            if (this.zzahT.get(zzcVarZzoR).isConnected()) {
                return ConnectionResult.zzafB;
            }
            if (this.zzaio.containsKey(zzcVarZzoR)) {
                return this.zzaio.get(zzcVarZzoR);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean isConnected() {
        return this.zzaip instanceof zzg;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean isConnecting() {
        return this.zzaip instanceof zzh;
    }

    public void onConnected(@Nullable Bundle connectionHint) {
        this.zzXG.lock();
        try {
            this.zzaip.onConnected(connectionHint);
        } finally {
            this.zzXG.unlock();
        }
    }

    public void onConnectionSuspended(int cause) {
        this.zzXG.lock();
        try {
            this.zzaip.onConnectionSuspended(cause);
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public <A extends Api.zzb, R extends Result, T extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<R, A>> T zza(@NonNull T t) {
        return (T) this.zzaip.zza(t);
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.zzXG.lock();
        try {
            this.zzaip.zza(connectionResult, api, i);
        } finally {
            this.zzXG.unlock();
        }
    }

    void zza(zza zzaVar) {
        this.zzain.sendMessage(this.zzain.obtainMessage(1, zzaVar));
    }

    void zza(RuntimeException runtimeException) {
        this.zzain.sendMessage(this.zzain.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean zza(zzu zzuVar) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public <A extends Api.zzb, T extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<? extends Result, A>> T zzb(@NonNull T t) {
        return (T) this.zzaip.zzb(t);
    }

    void zzh(ConnectionResult connectionResult) {
        this.zzXG.lock();
        try {
            this.zzaiq = connectionResult;
            this.zzaip = new zzi(this);
            this.zzaip.begin();
            this.zzaim.signalAll();
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void zzoW() {
    }

    void zzpK() {
        this.zzXG.lock();
        try {
            this.zzaip = new zzh(this, this.zzahz, this.zzahA, this.zzags, this.zzagt, this.zzXG, this.mContext);
            this.zzaip.begin();
            this.zzaim.signalAll();
        } finally {
            this.zzXG.unlock();
        }
    }

    void zzpL() {
        this.zzXG.lock();
        try {
            this.zzagW.zzpF();
            this.zzaip = new zzg(this);
            this.zzaip.begin();
            this.zzaim.signalAll();
        } finally {
            this.zzXG.unlock();
        }
    }

    void zzpM() {
        Iterator<Api.zzb> it = this.zzahT.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void zzpj() {
        if (isConnected()) {
            ((zzg) this.zzaip).zzps();
        }
    }
}
