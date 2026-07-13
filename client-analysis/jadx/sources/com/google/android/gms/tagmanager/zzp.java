package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.internal.zzrr;
import com.google.android.gms.internal.zzrs;

/* JADX INFO: loaded from: classes.dex */
public class zzp extends com.google.android.gms.common.api.internal.zzb<ContainerHolder> {
    private final Context mContext;
    private final Looper zzagr;
    private final String zzbhM;
    private long zzbhR;
    private final TagManager zzbhY;
    private final zzd zzbib;
    private final zzcd zzbic;
    private final int zzbid;
    private zzf zzbie;
    private zzrr zzbif;
    private volatile zzo zzbig;
    private volatile boolean zzbih;
    private com.google.android.gms.internal.zzaf.zzj zzbii;
    private String zzbij;
    private zze zzbik;
    private zza zzbil;
    private final zzmq zzqW;

    /* JADX INFO: renamed from: com.google.android.gms.tagmanager.zzp$1, reason: invalid class name */
    class AnonymousClass1 {
    }

    interface zza {
        boolean zzb(Container container);
    }

    private class zzb implements zzbf<zzrq.zza> {
        private zzb() {
        }

        /* synthetic */ zzb(zzp zzpVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zzGk() {
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zzI(zzrq.zza zzaVar) {
            com.google.android.gms.internal.zzaf.zzj zzjVar;
            if (zzaVar.zzbme != null) {
                zzjVar = zzaVar.zzbme;
            } else {
                com.google.android.gms.internal.zzaf.zzf zzfVar = zzaVar.zzju;
                zzjVar = new com.google.android.gms.internal.zzaf.zzj();
                zzjVar.zzju = zzfVar;
                zzjVar.zzjt = null;
                zzjVar.zzjv = zzfVar.version;
            }
            zzp.this.zza(zzjVar, zzaVar.zzbmd, true);
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zza(zzbf.zza zzaVar) {
            if (zzp.this.zzbih) {
                return;
            }
            zzp.this.zzak(0L);
        }
    }

    private class zzc implements zzbf<com.google.android.gms.internal.zzaf.zzj> {
        private zzc() {
        }

        /* synthetic */ zzc(zzp zzpVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zzGk() {
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        public void zza(zzbf.zza zzaVar) {
            synchronized (zzp.this) {
                if (!zzp.this.isReady()) {
                    if (zzp.this.zzbig != null) {
                        zzp.this.zza(zzp.this.zzbig);
                    } else {
                        zzp.this.zza(zzp.this.zzc(Status.zzagF));
                    }
                }
            }
            zzp.this.zzak(3600000L);
        }

        @Override // com.google.android.gms.tagmanager.zzbf
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public void zzI(com.google.android.gms.internal.zzaf.zzj zzjVar) {
            synchronized (zzp.this) {
                if (zzjVar.zzju == null) {
                    if (zzp.this.zzbii.zzju == null) {
                        zzbg.e("Current resource is null; network resource is also null");
                        zzp.this.zzak(3600000L);
                        return;
                    }
                    zzjVar.zzju = zzp.this.zzbii.zzju;
                }
                zzp.this.zza(zzjVar, zzp.this.zzqW.currentTimeMillis(), false);
                zzbg.v("setting refresh time to current time: " + zzp.this.zzbhR);
                if (!zzp.this.zzGj()) {
                    zzp.this.zza(zzjVar);
                }
            }
        }
    }

    private class zzd implements zzo.zza {
        private zzd() {
        }

        /* synthetic */ zzd(zzp zzpVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public String zzGd() {
            return zzp.this.zzGd();
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public void zzGf() {
            if (zzp.this.zzbic.zzlw()) {
                zzp.this.zzak(0L);
            }
        }

        @Override // com.google.android.gms.tagmanager.zzo.zza
        public void zzfT(String str) {
            zzp.this.zzfT(str);
        }
    }

    interface zze extends Releasable {
        void zza(zzbf<com.google.android.gms.internal.zzaf.zzj> zzbfVar);

        void zzf(long j, String str);

        void zzfW(String str);
    }

    interface zzf extends Releasable {
        void zzGl();

        void zza(zzbf<zzrq.zza> zzbfVar);

        void zzb(zzrq.zza zzaVar);

        zzrs.zzc zzke(int i);
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf zzfVar, zze zzeVar, zzrr zzrrVar, zzmq zzmqVar, zzcd zzcdVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzbhY = tagManager;
        this.zzagr = looper == null ? Looper.getMainLooper() : looper;
        this.zzbhM = str;
        this.zzbid = i;
        this.zzbie = zzfVar;
        this.zzbik = zzeVar;
        this.zzbif = zzrrVar;
        this.zzbib = new zzd(this, null);
        this.zzbii = new com.google.android.gms.internal.zzaf.zzj();
        this.zzqW = zzmqVar;
        this.zzbic = zzcdVar;
        if (zzGj()) {
            zzfT(zzcb.zzGU().zzGW());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzsVar) {
        this(context, tagManager, looper, str, i, new zzcn(context, str), new zzcm(context, str, zzsVar), new zzrr(context), zzmt.zzsc(), new zzbe(30, 900000L, 5000L, "refreshing", zzmt.zzsc()));
        this.zzbif.zzgB(zzsVar.zzGm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzGj() {
        zzcb zzcbVarZzGU = zzcb.zzGU();
        return (zzcbVarZzGU.zzGV() == zzcb.zza.CONTAINER || zzcbVarZzGU.zzGV() == zzcb.zza.CONTAINER_DEBUG) && this.zzbhM.equals(zzcbVarZzGU.getContainerId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zza(com.google.android.gms.internal.zzaf.zzj zzjVar) {
        if (this.zzbie != null) {
            zzrq.zza zzaVar = new zzrq.zza();
            zzaVar.zzbmd = this.zzbhR;
            zzaVar.zzju = new com.google.android.gms.internal.zzaf.zzf();
            zzaVar.zzbme = zzjVar;
            this.zzbie.zzb(zzaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zza(com.google.android.gms.internal.zzaf.zzj zzjVar, long j, boolean z) {
        if (z) {
            if (!this.zzbih) {
            }
        }
        if (!isReady() || this.zzbig == null) {
        }
        this.zzbii = zzjVar;
        this.zzbhR = j;
        zzak(Math.max(0L, Math.min(43200000L, (this.zzbhR + 43200000) - this.zzqW.currentTimeMillis())));
        Container container = new Container(this.mContext, this.zzbhY.getDataLayer(), this.zzbhM, j, zzjVar);
        if (this.zzbig == null) {
            this.zzbig = new zzo(this.zzbhY, this.zzagr, container, this.zzbib);
        } else {
            this.zzbig.zza(container);
        }
        if (!isReady() && this.zzbil.zzb(container)) {
            zza(this.zzbig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzak(long j) {
        if (this.zzbik == null) {
            zzbg.zzaK("Refresh requested, but no network load scheduler.");
        } else {
            this.zzbik.zzf(j, this.zzbii.zzjv);
        }
    }

    private void zzaw(final boolean z) {
        AnonymousClass1 anonymousClass1 = null;
        this.zzbie.zza(new zzb(this, anonymousClass1));
        this.zzbik.zza(new zzc(this, anonymousClass1));
        zzrs.zzc zzcVarZzke = this.zzbie.zzke(this.zzbid);
        if (zzcVarZzke != null) {
            this.zzbig = new zzo(this.zzbhY, this.zzagr, new Container(this.mContext, this.zzbhY.getDataLayer(), this.zzbhM, 0L, zzcVarZzke), this.zzbib);
        }
        this.zzbil = new zza() { // from class: com.google.android.gms.tagmanager.zzp.3
            @Override // com.google.android.gms.tagmanager.zzp.zza
            public boolean zzb(Container container) {
                if (z) {
                    return container.getLastRefreshTime() + 43200000 >= zzp.this.zzqW.currentTimeMillis();
                }
                return !container.isDefault();
            }
        };
        if (zzGj()) {
            this.zzbik.zzf(0L, "");
        } else {
            this.zzbie.zzGl();
        }
    }

    synchronized String zzGd() {
        return this.zzbij;
    }

    public void zzGg() {
        zzrs.zzc zzcVarZzke = this.zzbie.zzke(this.zzbid);
        if (zzcVarZzke != null) {
            zza(new zzo(this.zzbhY, this.zzagr, new Container(this.mContext, this.zzbhY.getDataLayer(), this.zzbhM, 0L, zzcVarZzke), new zzo.zza() { // from class: com.google.android.gms.tagmanager.zzp.2
                @Override // com.google.android.gms.tagmanager.zzo.zza
                public String zzGd() {
                    return zzp.this.zzGd();
                }

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public void zzGf() {
                    zzbg.zzaK("Refresh ignored: container loaded as default only.");
                }

                @Override // com.google.android.gms.tagmanager.zzo.zza
                public void zzfT(String str) {
                    zzp.this.zzfT(str);
                }
            }));
        } else {
            zzbg.e("Default was requested, but no default container was found");
            zza(zzc(new Status(10, "Default was requested, but no default container was found", null)));
        }
        this.zzbik = null;
        this.zzbie = null;
    }

    public void zzGh() {
        zzaw(false);
    }

    public void zzGi() {
        zzaw(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zzb
    /* JADX INFO: renamed from: zzbn, reason: merged with bridge method [inline-methods] */
    public ContainerHolder zzc(Status status) {
        if (this.zzbig != null) {
            return this.zzbig;
        }
        if (status == Status.zzagF) {
            zzbg.e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    synchronized void zzfT(String str) {
        this.zzbij = str;
        if (this.zzbik != null) {
            this.zzbik.zzfW(str);
        }
    }
}
