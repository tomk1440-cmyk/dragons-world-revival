package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzk;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class zzb implements SensorEventDispatcher {
    private final zzk zzaBh;

    zzb(zzk zzkVar) {
        this.zzaBh = (zzk) zzx.zzz(zzkVar);
    }

    @Override // com.google.android.gms.fitness.service.SensorEventDispatcher
    public void publish(DataPoint dataPoint) throws RemoteException {
        dataPoint.zzui();
        this.zzaBh.zzc(dataPoint);
    }

    @Override // com.google.android.gms.fitness.service.SensorEventDispatcher
    public void publish(List<DataPoint> dataPoints) throws RemoteException {
        Iterator<DataPoint> it = dataPoints.iterator();
        while (it.hasNext()) {
            publish(it.next());
        }
    }
}
