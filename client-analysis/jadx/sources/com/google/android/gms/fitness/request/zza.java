package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zza extends zzq.zza {
    private final BleScanCallback zzaAy;

    /* JADX INFO: renamed from: com.google.android.gms.fitness.request.zza$zza, reason: collision with other inner class name */
    public static class C0081zza {
        private static final C0081zza zzaAz = new C0081zza();
        private final Map<BleScanCallback, zza> zzaAA = new HashMap();

        private C0081zza() {
        }

        public static C0081zza zzuJ() {
            return zzaAz;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzaAA) {
                zzaVar = this.zzaAA.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                    this.zzaAA.put(bleScanCallback, zzaVar);
                }
            }
            return zzaVar;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzaAA) {
                zzaVar = this.zzaAA.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                }
            }
            return zzaVar;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzaAy = (BleScanCallback) com.google.android.gms.common.internal.zzx.zzz(bleScanCallback);
    }

    @Override // com.google.android.gms.fitness.request.zzq
    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzaAy.onDeviceFound(device);
    }

    @Override // com.google.android.gms.fitness.request.zzq
    public void onScanStopped() throws RemoteException {
        this.zzaAy.onScanStopped();
    }
}
