package com.google.android.gms.internal;

import android.support.v4.widget.ExploreByTouchHelper;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbd {
    private int zzsW;
    private final Object zzpV = new Object();
    private List<zzbc> zzsX = new LinkedList();

    public boolean zza(zzbc zzbcVar) {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzsX.contains(zzbcVar);
        }
        return z;
    }

    public boolean zzb(zzbc zzbcVar) {
        boolean z;
        synchronized (this.zzpV) {
            Iterator<zzbc> it = this.zzsX.iterator();
            while (it.hasNext()) {
                zzbc next = it.next();
                if (zzbcVar != next && next.zzcy().equals(zzbcVar.zzcy())) {
                    it.remove();
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    public void zzc(zzbc zzbcVar) {
        synchronized (this.zzpV) {
            if (this.zzsX.size() >= 10) {
                zzin.zzaI("Queue is full, current size = " + this.zzsX.size());
                this.zzsX.remove(0);
            }
            int i = this.zzsW;
            this.zzsW = i + 1;
            zzbcVar.zzh(i);
            this.zzsX.add(zzbcVar);
        }
    }

    public zzbc zzcF() {
        int i;
        zzbc zzbcVar;
        zzbc zzbcVar2 = null;
        synchronized (this.zzpV) {
            if (this.zzsX.size() == 0) {
                zzin.zzaI("Queue empty");
                return null;
            }
            if (this.zzsX.size() < 2) {
                zzbc zzbcVar3 = this.zzsX.get(0);
                zzbcVar3.zzcA();
                return zzbcVar3;
            }
            int i2 = ExploreByTouchHelper.INVALID_ID;
            for (zzbc zzbcVar4 : this.zzsX) {
                int score = zzbcVar4.getScore();
                if (score > i2) {
                    zzbcVar = zzbcVar4;
                    i = score;
                } else {
                    i = i2;
                    zzbcVar = zzbcVar2;
                }
                i2 = i;
                zzbcVar2 = zzbcVar;
            }
            this.zzsX.remove(zzbcVar2);
            return zzbcVar2;
        }
    }
}
