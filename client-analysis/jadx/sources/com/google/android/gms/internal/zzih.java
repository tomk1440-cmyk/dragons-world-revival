package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzih implements zzip.zzb {
    private Context mContext;
    private final String zzLq;
    private final zzii zzLr;
    private String zzLz;
    private VersionInfoParcel zzpT;
    private zzax zzpl;
    private String zzzN;
    private final Object zzpV = new Object();
    private BigInteger zzLs = BigInteger.ONE;
    private final HashSet<zzig> zzLt = new HashSet<>();
    private final HashMap<String, zzik> zzLu = new HashMap<>();
    private boolean zzLv = false;
    private boolean zzJz = true;
    private int zzLw = 0;
    private boolean zzqA = false;
    private zzbv zzLx = null;
    private boolean zzJA = true;
    private zzbe zzsZ = null;
    private zzbf zzLy = null;
    private zzbd zzta = null;
    private final LinkedList<Thread> zzLA = new LinkedList<>();
    private final zzha zztb = null;
    private Boolean zzLB = null;
    private boolean zzLC = false;
    private boolean zzLD = false;

    public zzih(zzir zzirVar) {
        this.zzLq = zzirVar.zzhs();
        this.zzLr = new zzii(this.zzLq);
    }

    public String getSessionId() {
        return this.zzLq;
    }

    public void zzB(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzJA != z) {
                zzip.zzb(this.mContext, z);
            }
            this.zzJA = z;
            zzbf zzbfVarZzG = zzG(this.mContext);
            if (zzbfVarZzG != null && !zzbfVarZzG.isAlive()) {
                zzin.zzaJ("start fetching content...");
                zzbfVarZzG.zzcG();
            }
        }
    }

    public void zzC(boolean z) {
        synchronized (this.zzpV) {
            this.zzLC = z;
        }
    }

    public zzbf zzG(Context context) {
        if (!zzbt.zzwj.get().booleanValue() || !zzne.zzsg() || zzgY()) {
            return null;
        }
        synchronized (this.zzpV) {
            if (this.zzsZ == null) {
                if (!(context instanceof Activity)) {
                    return null;
                }
                this.zzsZ = new zzbe((Application) context.getApplicationContext(), (Activity) context);
            }
            if (this.zzta == null) {
                this.zzta = new zzbd();
            }
            if (this.zzLy == null) {
                this.zzLy = new zzbf(this.zzsZ, this.zzta, new zzha(this.mContext, this.zzpT, null, null));
            }
            this.zzLy.zzcG();
            return this.zzLy;
        }
    }

    public Bundle zza(Context context, zzij zzijVar, String str) {
        Bundle bundle;
        synchronized (this.zzpV) {
            bundle = new Bundle();
            bundle.putBundle(SettingsJsonConstants.APP_KEY, this.zzLr.zzc(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzLu.keySet()) {
                bundle2.putBundle(str2, this.zzLu.get(str2).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzig> it = this.zzLt.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzijVar.zza(this.zzLt);
            this.zzLt.clear();
        }
        return bundle;
    }

    public Future zza(Context context, boolean z) {
        Future futureZza;
        synchronized (this.zzpV) {
            if (z != this.zzJz) {
                this.zzJz = z;
                futureZza = zzip.zza(context, z);
            } else {
                futureZza = null;
            }
        }
        return futureZza;
    }

    public void zza(zzig zzigVar) {
        synchronized (this.zzpV) {
            this.zzLt.add(zzigVar);
        }
    }

    public void zza(String str, zzik zzikVar) {
        synchronized (this.zzpV) {
            this.zzLu.put(str, zzikVar);
        }
    }

    public void zza(Thread thread) {
        zzha.zza(this.mContext, thread, this.zzpT);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    public Future zzaA(String str) {
        Future futureZzd;
        synchronized (this.zzpV) {
            if (str == null) {
                futureZzd = null;
            } else if (str.equals(this.zzLz)) {
                futureZzd = null;
            } else {
                this.zzLz = str;
                futureZzd = zzip.zzd(this.mContext, str);
            }
            throw th;
        }
        return futureZzd;
    }

    @TargetApi(23)
    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.zzpV) {
            if (!this.zzqA) {
                this.mContext = context.getApplicationContext();
                this.zzpT = versionInfoParcel;
                zzip.zza(context, this);
                zzip.zzb(context, this);
                zzip.zzc(context, this);
                zzip.zzd(context, this);
                zza(Thread.currentThread());
                this.zzzN = com.google.android.gms.ads.internal.zzr.zzbC().zze(context, versionInfoParcel.afmaVersion);
                if (zzne.zzsn() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzLD = true;
                }
                this.zzpl = new zzax(context.getApplicationContext(), this.zzpT, new zzeg(context.getApplicationContext(), this.zzpT, zzbt.zzvB.get()));
                zzhk();
                com.google.android.gms.ads.internal.zzr.zzbM().zzz(this.mContext);
                this.zzqA = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zzpV) {
            this.zzLB = bool;
        }
    }

    public void zzb(Throwable th, boolean z) {
        new zzha(this.mContext, this.zzpT, null, null).zza(th, z);
    }

    public void zzb(HashSet<zzig> hashSet) {
        synchronized (this.zzpV) {
            this.zzLt.addAll(hashSet);
        }
    }

    public String zzd(int i, String str) {
        Resources resources = this.zzpT.zzNb ? this.mContext.getResources() : com.google.android.gms.common.zze.getRemoteResource(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    @Override // com.google.android.gms.internal.zzip.zzb
    public void zze(Bundle bundle) {
        synchronized (this.zzpV) {
            this.zzJz = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.zzJz;
            this.zzLw = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.zzLw;
            if (bundle.containsKey("content_url_opted_out")) {
                zzB(bundle.getBoolean("content_url_opted_out"));
            }
            if (bundle.containsKey("content_url_hashes")) {
                this.zzLz = bundle.getString("content_url_hashes");
            }
        }
    }

    public boolean zzgY() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzJA;
        }
        return z;
    }

    public String zzgZ() {
        String string;
        synchronized (this.zzpV) {
            string = this.zzLs.toString();
            this.zzLs = this.zzLs.add(BigInteger.ONE);
        }
        return string;
    }

    public zzii zzha() {
        zzii zziiVar;
        synchronized (this.zzpV) {
            zziiVar = this.zzLr;
        }
        return zziiVar;
    }

    public zzbv zzhb() {
        zzbv zzbvVar;
        synchronized (this.zzpV) {
            zzbvVar = this.zzLx;
        }
        return zzbvVar;
    }

    public boolean zzhc() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzLv;
            this.zzLv = true;
        }
        return z;
    }

    public boolean zzhd() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzJz || this.zzLD;
        }
        return z;
    }

    public String zzhe() {
        String str;
        synchronized (this.zzpV) {
            str = this.zzzN;
        }
        return str;
    }

    public String zzhf() {
        String str;
        synchronized (this.zzpV) {
            str = this.zzLz;
        }
        return str;
    }

    public Boolean zzhg() {
        Boolean bool;
        synchronized (this.zzpV) {
            bool = this.zzLB;
        }
        return bool;
    }

    public zzax zzhh() {
        return this.zzpl;
    }

    public boolean zzhi() {
        boolean z;
        synchronized (this.zzpV) {
            if (this.zzLw < zzbt.zzwA.get().intValue()) {
                this.zzLw = zzbt.zzwA.get().intValue();
                zzip.zza(this.mContext, this.zzLw);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzhj() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzLC;
        }
        return z;
    }

    void zzhk() {
        try {
            this.zzLx = com.google.android.gms.ads.internal.zzr.zzbH().zza(new zzbu(this.mContext, this.zzpT.afmaVersion));
        } catch (IllegalArgumentException e) {
            zzin.zzd("Cannot initialize CSI reporter.", e);
        }
    }
}
