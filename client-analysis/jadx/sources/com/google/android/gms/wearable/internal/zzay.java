package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzay<T> {
    private final Map<T, zzbq<T>> zzaxd = new HashMap();

    private static class zza<T> extends zzbo.zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zza(Map<T, zzbq<T>> map, T t, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            super(zzbVar);
            this.zzbsM = new WeakReference<>(map);
            this.zzbsN = new WeakReference<>(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(Status status) {
            Map<T, zzbq<T>> map = this.zzbsM.get();
            T t = this.zzbsN.get();
            if (!status.getStatus().isSuccess() && map != null && t != null) {
                synchronized (map) {
                    zzbq<T> zzbqVarRemove = map.remove(t);
                    if (zzbqVarRemove != null) {
                        zzbqVarRemove.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    private static class zzb<T> extends zzbo.zzb<Status> {
        private WeakReference<Map<T, zzbq<T>>> zzbsM;
        private WeakReference<T> zzbsN;

        zzb(Map<T, zzbq<T>> map, T t, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
            super(zzbVar);
            this.zzbsM = new WeakReference<>(map);
            this.zzbsN = new WeakReference<>(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzav
        public void zza(Status status) {
            Map<T, zzbq<T>> map = this.zzbsM.get();
            T t = this.zzbsN.get();
            if (status.getStatus().getStatusCode() == 4002 && map != null && t != null) {
                synchronized (map) {
                    zzbq<T> zzbqVarRemove = map.remove(t);
                    if (zzbqVarRemove != null) {
                        zzbqVarRemove.clear();
                    }
                }
            }
            zzX(status);
        }
    }

    zzay() {
    }

    public void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, T t) throws RemoteException {
        synchronized (this.zzaxd) {
            zzbq<T> zzbqVarRemove = this.zzaxd.remove(t);
            if (zzbqVarRemove == null) {
                zzbVar.zzs(new Status(4002));
            } else {
                zzbqVarRemove.clear();
                zzbpVar.zzqJ().zza(new zzb(this.zzaxd, t, zzbVar), new RemoveListenerRequest(zzbqVarRemove));
            }
        }
    }

    public void zza(zzbp zzbpVar, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar, T t, zzbq<T> zzbqVar) throws RemoteException {
        synchronized (this.zzaxd) {
            if (this.zzaxd.get(t) != null) {
                zzbVar.zzs(new Status(4001));
                return;
            }
            this.zzaxd.put(t, zzbqVar);
            try {
                zzbpVar.zzqJ().zza(new zza(this.zzaxd, t, zzbVar), new AddListenerRequest(zzbqVar));
            } catch (RemoteException e) {
                this.zzaxd.remove(t);
                throw e;
            }
        }
    }

    public void zzev(IBinder iBinder) {
        synchronized (this.zzaxd) {
            zzax zzaxVarZzeu = zzax.zza.zzeu(iBinder);
            zzbo.zzo zzoVar = new zzbo.zzo();
            for (Map.Entry<T, zzbq<T>> entry : this.zzaxd.entrySet()) {
                zzbq<T> value = entry.getValue();
                try {
                    zzaxVarZzeu.zza(zzoVar, new AddListenerRequest(value));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + value);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + value);
                }
            }
        }
    }
}
