package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzro;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public class zzd implements zzp {
    private final Context mContext;
    private final Lock zzXG;
    private final zzj zzagW;
    private final zzl zzagX;
    private final zzl zzagY;
    private final Looper zzagr;
    private final Api.zzb zzahb;
    private Bundle zzahc;
    private final Map<Api.zzc<?>, zzl> zzagZ = new ArrayMap();
    private final Set<zzu> zzaha = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult zzahd = null;
    private ConnectionResult zzahe = null;
    private boolean zzahf = false;
    private int zzahg = 0;

    public zzd(Context context, zzj zzjVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zzb> map, com.google.android.gms.common.internal.zzf zzfVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzrn, zzro> zzaVar, ArrayList<zzc> arrayList) {
        this.mContext = context;
        this.zzagW = zzjVar;
        this.zzXG = lock;
        this.zzagr = looper;
        Api.zzb zzbVar = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Api.zzc<?> zzcVar2 : map.keySet()) {
            Api.zzb zzbVar2 = map.get(zzcVar2);
            zzbVar = zzbVar2.zznb() ? zzbVar2 : zzbVar;
            if (zzbVar2.zzmE()) {
                arrayMap.put(zzcVar2, zzbVar2);
            } else {
                arrayMap2.put(zzcVar2, zzbVar2);
            }
        }
        this.zzahb = zzbVar;
        if (arrayMap.isEmpty()) {
            throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        }
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.zzc<?> zzcVarZzoR = api.zzoR();
            if (arrayMap.containsKey(zzcVarZzoR)) {
                arrayMap3.put(api, map2.get(api));
            } else {
                if (!arrayMap2.containsKey(zzcVarZzoR)) {
                    throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (zzc zzcVar3 : arrayList) {
            if (arrayMap3.containsKey(zzcVar3.zzagT)) {
                arrayList2.add(zzcVar3);
            } else {
                if (!arrayMap4.containsKey(zzcVar3.zzagT)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
                }
                arrayList3.add(zzcVar3);
            }
        }
        this.zzagX = new zzl(context, this.zzagW, lock, looper, zzcVar, arrayMap2, null, arrayMap4, null, arrayList3, new zzp.zza() { // from class: com.google.android.gms.common.api.internal.zzd.1
            @Override // com.google.android.gms.common.api.internal.zzp.zza
            public void zzc(int i, boolean z) {
                zzd.this.zzXG.lock();
                try {
                    if (zzd.this.zzahf || zzd.this.zzahe == null || !zzd.this.zzahe.isSuccess()) {
                        zzd.this.zzahf = false;
                        zzd.this.zzb(i, z);
                    } else {
                        zzd.this.zzahf = true;
                        zzd.this.zzagY.onConnectionSuspended(i);
                    }
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            @Override // com.google.android.gms.common.api.internal.zzp.zza
            public void zzd(@NonNull ConnectionResult connectionResult) {
                zzd.this.zzXG.lock();
                try {
                    zzd.this.zzahd = connectionResult;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            @Override // com.google.android.gms.common.api.internal.zzp.zza
            public void zzi(@Nullable Bundle bundle) {
                zzd.this.zzXG.lock();
                try {
                    zzd.this.zzh(bundle);
                    zzd.this.zzahd = ConnectionResult.zzafB;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }
        });
        this.zzagY = new zzl(context, this.zzagW, lock, looper, zzcVar, arrayMap, zzfVar, arrayMap3, zzaVar, arrayList2, new zzp.zza() { // from class: com.google.android.gms.common.api.internal.zzd.2
            @Override // com.google.android.gms.common.api.internal.zzp.zza
            public void zzc(int i, boolean z) {
                zzd.this.zzXG.lock();
                try {
                    if (zzd.this.zzahf) {
                        zzd.this.zzahf = false;
                        zzd.this.zzb(i, z);
                    } else {
                        zzd.this.zzahf = true;
                        zzd.this.zzagX.onConnectionSuspended(i);
                    }
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            @Override // com.google.android.gms.common.api.internal.zzp.zza
            public void zzd(@NonNull ConnectionResult connectionResult) {
                zzd.this.zzXG.lock();
                try {
                    zzd.this.zzahe = connectionResult;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }

            @Override // com.google.android.gms.common.api.internal.zzp.zza
            public void zzi(@Nullable Bundle bundle) {
                zzd.this.zzXG.lock();
                try {
                    zzd.this.zzahe = ConnectionResult.zzafB;
                    zzd.this.zzpm();
                } finally {
                    zzd.this.zzXG.unlock();
                }
            }
        });
        Iterator it = arrayMap2.keySet().iterator();
        while (it.hasNext()) {
            this.zzagZ.put((Api.zzc) it.next(), this.zzagX);
        }
        Iterator it2 = arrayMap.keySet().iterator();
        while (it2.hasNext()) {
            this.zzagZ.put((Api.zzc) it2.next(), this.zzagY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.zzagW.zzc(i, z);
        this.zzahe = null;
        this.zzahd = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.zzahg) {
            case 2:
                this.zzagW.zzd(connectionResult);
            case 1:
                zzpo();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.zzahg = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zzc(zza.AbstractC0049zza<? extends Result, ? extends Api.zzb> abstractC0049zza) {
        Object objZzoR = abstractC0049zza.zzoR();
        com.google.android.gms.common.internal.zzx.zzb(this.zzagZ.containsKey(objZzoR), "GoogleApiClient is not configured to use the API required for this call.");
        return this.zzagZ.get(objZzoR).equals(this.zzagY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzh(Bundle bundle) {
        if (this.zzahc == null) {
            this.zzahc = bundle;
        } else if (bundle != null) {
            this.zzahc.putAll(bundle);
        }
    }

    private void zzpl() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzagX.connect();
        this.zzagY.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzpm() {
        if (zzc(this.zzahd)) {
            if (zzc(this.zzahe) || zzpp()) {
                zzpn();
                return;
            }
            if (this.zzahe != null) {
                if (this.zzahg == 1) {
                    zzpo();
                    return;
                } else {
                    zzb(this.zzahe);
                    this.zzagX.disconnect();
                    return;
                }
            }
            return;
        }
        if (this.zzahd != null && zzc(this.zzahe)) {
            this.zzagY.disconnect();
            zzb(this.zzahd);
        } else {
            if (this.zzahd == null || this.zzahe == null) {
                return;
            }
            ConnectionResult connectionResult = this.zzahd;
            if (this.zzagY.zzair < this.zzagX.zzair) {
                connectionResult = this.zzahe;
            }
            zzb(connectionResult);
        }
    }

    private void zzpn() {
        switch (this.zzahg) {
            case 2:
                this.zzagW.zzi(this.zzahc);
            case 1:
                zzpo();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.zzahg = 0;
    }

    private void zzpo() {
        Iterator<zzu> it = this.zzaha.iterator();
        while (it.hasNext()) {
            it.next().zzna();
        }
        this.zzaha.clear();
    }

    private boolean zzpp() {
        return this.zzahe != null && this.zzahe.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzpq() {
        if (this.zzahb == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.zzagW.getSessionId(), this.zzahb.zznc(), 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public ConnectionResult blockingConnect(long timeout, @NonNull TimeUnit unit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void connect() {
        this.zzahg = 2;
        this.zzahf = false;
        zzpl();
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean disconnect() {
        this.zzahe = null;
        this.zzahd = null;
        this.zzahg = 0;
        boolean zDisconnect = this.zzagX.disconnect();
        boolean zDisconnect2 = this.zzagY.disconnect();
        zzpo();
        return zDisconnect && zDisconnect2;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append((CharSequence) prefix).append("authClient").println(":");
        this.zzagY.dump(prefix + "  ", fd, writer, args);
        writer.append((CharSequence) prefix).append("anonClient").println(":");
        this.zzagX.dump(prefix + "  ", fd, writer, args);
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        if (this.zzagZ.get(api.zzoR()).equals(this.zzagY)) {
            return zzpp() ? new ConnectionResult(4, zzpq()) : this.zzagY.getConnectionResult(api);
        }
        return this.zzagX.getConnectionResult(api);
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean isConnected() {
        boolean z = true;
        this.zzXG.lock();
        try {
            if (!this.zzagX.isConnected() || (!zzpk() && !zzpp() && this.zzahg != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean isConnecting() {
        this.zzXG.lock();
        try {
            return this.zzahg == 2;
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public <A extends Api.zzb, R extends Result, T extends zza.AbstractC0049zza<R, A>> T zza(@NonNull T t) {
        if (!zzc((zza.AbstractC0049zza<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.zzagX.zza(t);
        }
        if (!zzpp()) {
            return (T) this.zzagY.zza(t);
        }
        t.zzw(new Status(4, null, zzpq()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public boolean zza(zzu zzuVar) {
        this.zzXG.lock();
        try {
            if ((!isConnecting() && !isConnected()) || zzpk()) {
                return false;
            }
            this.zzaha.add(zzuVar);
            if (this.zzahg == 0) {
                this.zzahg = 1;
            }
            this.zzahe = null;
            this.zzagY.connect();
            return true;
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public <A extends Api.zzb, T extends zza.AbstractC0049zza<? extends Result, A>> T zzb(@NonNull T t) {
        if (!zzc((zza.AbstractC0049zza<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.zzagX.zzb(t);
        }
        if (!zzpp()) {
            return (T) this.zzagY.zzb(t);
        }
        t.zzw(new Status(4, null, zzpq()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void zzoW() {
        this.zzXG.lock();
        try {
            boolean zIsConnecting = isConnecting();
            this.zzagY.disconnect();
            this.zzahe = new ConnectionResult(4);
            if (zIsConnecting) {
                new Handler(this.zzagr).post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zzd.3
                    @Override // java.lang.Runnable
                    public void run() {
                        zzd.this.zzXG.lock();
                        try {
                            zzd.this.zzpm();
                        } finally {
                            zzd.this.zzXG.unlock();
                        }
                    }
                });
            } else {
                zzpo();
            }
        } finally {
            this.zzXG.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzp
    public void zzpj() {
        this.zzagX.zzpj();
        this.zzagY.zzpj();
    }

    public boolean zzpk() {
        return this.zzagY.isConnected();
    }
}
