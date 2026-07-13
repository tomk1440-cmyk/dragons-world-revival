package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzax implements zzay {
    private final VersionInfoParcel zzpT;
    private final Object zzpV = new Object();
    private final WeakHashMap<zzif, zzau> zzsB = new WeakHashMap<>();
    private final ArrayList<zzau> zzsC = new ArrayList<>();
    private final zzeg zzsD;
    private final Context zzsa;

    public zzax(Context context, VersionInfoParcel versionInfoParcel, zzeg zzegVar) {
        this.zzsa = context.getApplicationContext();
        this.zzpT = versionInfoParcel;
        this.zzsD = zzegVar;
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzifVar) {
        return zza(adSizeParcel, zzifVar, zzifVar.zzED.getView());
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzifVar, View view) {
        return zza(adSizeParcel, zzifVar, new zzau.zzd(view, zzifVar), (zzeh) null);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzifVar, View view, zzeh zzehVar) {
        return zza(adSizeParcel, zzifVar, new zzau.zzd(view, zzifVar), zzehVar);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzifVar, com.google.android.gms.ads.internal.formats.zzh zzhVar) {
        return zza(adSizeParcel, zzifVar, new zzau.zza(zzhVar), (zzeh) null);
    }

    public zzau zza(AdSizeParcel adSizeParcel, zzif zzifVar, zzbb zzbbVar, zzeh zzehVar) {
        zzau zzazVar;
        synchronized (this.zzpV) {
            if (zzh(zzifVar)) {
                zzazVar = this.zzsB.get(zzifVar);
            } else {
                zzazVar = zzehVar != null ? new zzaz(this.zzsa, adSizeParcel, zzifVar, this.zzpT, zzbbVar, zzehVar) : new zzba(this.zzsa, adSizeParcel, zzifVar, this.zzpT, zzbbVar, this.zzsD);
                zzazVar.zza(this);
                this.zzsB.put(zzifVar, zzazVar);
                this.zzsC.add(zzazVar);
            }
        }
        return zzazVar;
    }

    @Override // com.google.android.gms.internal.zzay
    public void zza(zzau zzauVar) {
        synchronized (this.zzpV) {
            if (!zzauVar.zzch()) {
                this.zzsC.remove(zzauVar);
                Iterator<Map.Entry<zzif, zzau>> it = this.zzsB.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzauVar) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzh(zzif zzifVar) {
        boolean z;
        synchronized (this.zzpV) {
            zzau zzauVar = this.zzsB.get(zzifVar);
            z = zzauVar != null && zzauVar.zzch();
        }
        return z;
    }

    public void zzi(zzif zzifVar) {
        synchronized (this.zzpV) {
            zzau zzauVar = this.zzsB.get(zzifVar);
            if (zzauVar != null) {
                zzauVar.zzcf();
            }
        }
    }

    public void zzj(zzif zzifVar) {
        synchronized (this.zzpV) {
            zzau zzauVar = this.zzsB.get(zzifVar);
            if (zzauVar != null) {
                zzauVar.stop();
            }
        }
    }

    public void zzk(zzif zzifVar) {
        synchronized (this.zzpV) {
            zzau zzauVar = this.zzsB.get(zzifVar);
            if (zzauVar != null) {
                zzauVar.pause();
            }
        }
    }

    public void zzl(zzif zzifVar) {
        synchronized (this.zzpV) {
            zzau zzauVar = this.zzsB.get(zzifVar);
            if (zzauVar != null) {
                zzauVar.resume();
            }
        }
    }
}
