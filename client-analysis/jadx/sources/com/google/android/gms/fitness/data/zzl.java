package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzl extends zzk.zza {
    private final OnDataPointListener zzaxb;

    public static class zza {
        private static final zza zzaxc = new zza();
        private final Map<OnDataPointListener, zzl> zzaxd = new HashMap();

        private zza() {
        }

        public static zza zzuu() {
            return zzaxc;
        }

        public zzl zza(OnDataPointListener onDataPointListener) {
            zzl zzlVar;
            synchronized (this.zzaxd) {
                zzlVar = this.zzaxd.get(onDataPointListener);
                if (zzlVar == null) {
                    zzlVar = new zzl(onDataPointListener);
                    this.zzaxd.put(onDataPointListener, zzlVar);
                }
            }
            return zzlVar;
        }

        public zzl zzb(OnDataPointListener onDataPointListener) {
            zzl zzlVar;
            synchronized (this.zzaxd) {
                zzlVar = this.zzaxd.get(onDataPointListener);
            }
            return zzlVar;
        }

        public zzl zzc(OnDataPointListener onDataPointListener) {
            zzl zzlVarRemove;
            synchronized (this.zzaxd) {
                zzlVarRemove = this.zzaxd.remove(onDataPointListener);
                if (zzlVarRemove == null) {
                    zzlVarRemove = new zzl(onDataPointListener);
                }
            }
            return zzlVarRemove;
        }
    }

    private zzl(OnDataPointListener onDataPointListener) {
        this.zzaxb = (OnDataPointListener) zzx.zzz(onDataPointListener);
    }

    @Override // com.google.android.gms.fitness.data.zzk
    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzaxb.onDataPoint(dataPoint);
    }
}
