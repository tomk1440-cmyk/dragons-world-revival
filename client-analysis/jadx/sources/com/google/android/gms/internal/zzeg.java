package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzeg {
    private final Context mContext;
    private final String zzAY;
    private zzb<zzed> zzAZ;
    private zzb<zzed> zzBa;
    private zze zzBb;
    private int zzBc;
    private final VersionInfoParcel zzpT;
    private final Object zzpV;

    /* JADX INFO: renamed from: com.google.android.gms.internal.zzeg$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ zze zzBd;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzeg$1$1, reason: invalid class name and collision with other inner class name */
        class C01041 implements zzed.zza {
            final /* synthetic */ zzed zzBf;

            C01041(zzed zzedVar) {
                this.zzBf = zzedVar;
            }

            @Override // com.google.android.gms.internal.zzed.zza
            public void zzeo() {
                zzir.zzMc.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.zzeg.1.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (zzeg.this.zzpV) {
                            if (AnonymousClass1.this.zzBd.getStatus() == -1 || AnonymousClass1.this.zzBd.getStatus() == 1) {
                                return;
                            }
                            AnonymousClass1.this.zzBd.reject();
                            zzir.runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzeg.1.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C01041.this.zzBf.destroy();
                                }
                            });
                            zzin.v("Could not receive loaded message in a timely manner. Rejecting.");
                        }
                    }
                }, zza.zzBn);
            }
        }

        AnonymousClass1(zze zzeVar) {
            this.zzBd = zzeVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            final zzed zzedVarZza = zzeg.this.zza(zzeg.this.mContext, zzeg.this.zzpT);
            zzedVarZza.zza(new C01041(zzedVarZza));
            zzedVarZza.zza("/jsLoaded", new zzdf() { // from class: com.google.android.gms.internal.zzeg.1.2
                @Override // com.google.android.gms.internal.zzdf
                public void zza(zzjp zzjpVar, Map<String, String> map) {
                    synchronized (zzeg.this.zzpV) {
                        if (AnonymousClass1.this.zzBd.getStatus() == -1 || AnonymousClass1.this.zzBd.getStatus() == 1) {
                            return;
                        }
                        zzeg.this.zzBc = 0;
                        zzeg.this.zzAZ.zze(zzedVarZza);
                        AnonymousClass1.this.zzBd.zzh(zzedVarZza);
                        zzeg.this.zzBb = AnonymousClass1.this.zzBd;
                        zzin.v("Successfully loaded JS Engine.");
                    }
                }
            });
            final zzja zzjaVar = new zzja();
            zzdf zzdfVar = new zzdf() { // from class: com.google.android.gms.internal.zzeg.1.3
                @Override // com.google.android.gms.internal.zzdf
                public void zza(zzjp zzjpVar, Map<String, String> map) {
                    synchronized (zzeg.this.zzpV) {
                        zzin.zzaJ("JS Engine is requesting an update");
                        if (zzeg.this.zzBc == 0) {
                            zzin.zzaJ("Starting reload.");
                            zzeg.this.zzBc = 2;
                            zzeg.this.zzeq();
                        }
                        zzedVarZza.zzb("/requestReload", (zzdf) zzjaVar.get());
                    }
                }
            };
            zzjaVar.set(zzdfVar);
            zzedVarZza.zza("/requestReload", zzdfVar);
            if (zzeg.this.zzAY.endsWith(".js")) {
                zzedVarZza.zzZ(zzeg.this.zzAY);
            } else if (zzeg.this.zzAY.startsWith("<html>")) {
                zzedVarZza.zzab(zzeg.this.zzAY);
            } else {
                zzedVarZza.zzaa(zzeg.this.zzAY);
            }
            zzir.zzMc.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.zzeg.1.4
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzeg.this.zzpV) {
                        if (AnonymousClass1.this.zzBd.getStatus() == -1 || AnonymousClass1.this.zzBd.getStatus() == 1) {
                            return;
                        }
                        AnonymousClass1.this.zzBd.reject();
                        zzir.runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzeg.1.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                zzedVarZza.destroy();
                            }
                        });
                        zzin.v("Could not receive loaded message in a timely manner. Rejecting.");
                    }
                }
            }, zza.zzBm);
        }
    }

    static class zza {
        static int zzBm = 60000;
        static int zzBn = 10000;
    }

    public interface zzb<T> {
        void zze(T t);
    }

    public static class zzc<T> implements zzb<T> {
        @Override // com.google.android.gms.internal.zzeg.zzb
        public void zze(T t) {
        }
    }

    public static class zzd extends zzjj<zzeh> {
        private final zze zzBo;
        private boolean zzBp;
        private final Object zzpV = new Object();

        public zzd(zze zzeVar) {
            this.zzBo = zzeVar;
        }

        public void release() {
            synchronized (this.zzpV) {
                if (this.zzBp) {
                    return;
                }
                this.zzBp = true;
                zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzeg.zzd.1
                    @Override // com.google.android.gms.internal.zzji.zzc
                    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
                    public void zze(zzeh zzehVar) {
                        zzin.v("Ending javascript session.");
                        ((zzei) zzehVar).zzew();
                    }
                }, new zzji.zzb());
                zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzeg.zzd.2
                    @Override // com.google.android.gms.internal.zzji.zzc
                    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
                    public void zze(zzeh zzehVar) {
                        zzin.v("Releasing engine reference.");
                        zzd.this.zzBo.zzet();
                    }
                }, new zzji.zza() { // from class: com.google.android.gms.internal.zzeg.zzd.3
                    @Override // com.google.android.gms.internal.zzji.zza
                    public void run() {
                        zzd.this.zzBo.zzet();
                    }
                });
            }
        }
    }

    public static class zze extends zzjj<zzed> {
        private zzb<zzed> zzBa;
        private final Object zzpV = new Object();
        private boolean zzBr = false;
        private int zzBs = 0;

        public zze(zzb<zzed> zzbVar) {
            this.zzBa = zzbVar;
        }

        public zzd zzes() {
            final zzd zzdVar = new zzd(this);
            synchronized (this.zzpV) {
                zza(new zzji.zzc<zzed>() { // from class: com.google.android.gms.internal.zzeg.zze.1
                    @Override // com.google.android.gms.internal.zzji.zzc
                    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                    public void zze(zzed zzedVar) {
                        zzin.v("Getting a new session for JS Engine.");
                        zzdVar.zzh(zzedVar.zzen());
                    }
                }, new zzji.zza() { // from class: com.google.android.gms.internal.zzeg.zze.2
                    @Override // com.google.android.gms.internal.zzji.zza
                    public void run() {
                        zzin.v("Rejecting reference for JS Engine.");
                        zzdVar.reject();
                    }
                });
                com.google.android.gms.common.internal.zzx.zzab(this.zzBs >= 0);
                this.zzBs++;
            }
            return zzdVar;
        }

        protected void zzet() {
            synchronized (this.zzpV) {
                com.google.android.gms.common.internal.zzx.zzab(this.zzBs >= 1);
                zzin.v("Releasing 1 reference for JS Engine");
                this.zzBs--;
                zzev();
            }
        }

        public void zzeu() {
            synchronized (this.zzpV) {
                com.google.android.gms.common.internal.zzx.zzab(this.zzBs >= 0);
                zzin.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzBr = true;
                zzev();
            }
        }

        protected void zzev() {
            synchronized (this.zzpV) {
                com.google.android.gms.common.internal.zzx.zzab(this.zzBs >= 0);
                if (this.zzBr && this.zzBs == 0) {
                    zzin.v("No reference is left (including root). Cleaning up engine.");
                    zza(new zzji.zzc<zzed>() { // from class: com.google.android.gms.internal.zzeg.zze.3
                        @Override // com.google.android.gms.internal.zzji.zzc
                        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                        public void zze(final zzed zzedVar) {
                            zzir.runOnUiThread(new Runnable() { // from class: com.google.android.gms.internal.zzeg.zze.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    zze.this.zzBa.zze(zzedVar);
                                    zzedVar.destroy();
                                }
                            });
                        }
                    }, new zzji.zzb());
                } else {
                    zzin.v("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public zzeg(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzpV = new Object();
        this.zzBc = 1;
        this.zzAY = str;
        this.mContext = context.getApplicationContext();
        this.zzpT = versionInfoParcel;
        this.zzAZ = new zzc();
        this.zzBa = new zzc();
    }

    public zzeg(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzed> zzbVar, zzb<zzed> zzbVar2) {
        this(context, versionInfoParcel, str);
        this.zzAZ = zzbVar;
        this.zzBa = zzbVar2;
    }

    private zze zzep() {
        zze zzeVar = new zze(this.zzBa);
        zzir.runOnUiThread(new AnonymousClass1(zzeVar));
        return zzeVar;
    }

    protected zzed zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzef(context, versionInfoParcel, null);
    }

    protected zze zzeq() {
        final zze zzeVarZzep = zzep();
        zzeVarZzep.zza(new zzji.zzc<zzed>() { // from class: com.google.android.gms.internal.zzeg.2
            @Override // com.google.android.gms.internal.zzji.zzc
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zze(zzed zzedVar) {
                synchronized (zzeg.this.zzpV) {
                    zzeg.this.zzBc = 0;
                    if (zzeg.this.zzBb != null && zzeVarZzep != zzeg.this.zzBb) {
                        zzin.v("New JS engine is loaded, marking previous one as destroyable.");
                        zzeg.this.zzBb.zzeu();
                    }
                    zzeg.this.zzBb = zzeVarZzep;
                }
            }
        }, new zzji.zza() { // from class: com.google.android.gms.internal.zzeg.3
            @Override // com.google.android.gms.internal.zzji.zza
            public void run() {
                synchronized (zzeg.this.zzpV) {
                    zzeg.this.zzBc = 1;
                    zzin.v("Failed loading new engine. Marking new engine destroyable.");
                    zzeVarZzep.zzeu();
                }
            }
        });
        return zzeVarZzep;
    }

    public zzd zzer() {
        zzd zzdVarZzes;
        synchronized (this.zzpV) {
            if (this.zzBb == null || this.zzBb.getStatus() == -1) {
                this.zzBc = 2;
                this.zzBb = zzeq();
                zzdVarZzes = this.zzBb.zzes();
            } else if (this.zzBc == 0) {
                zzdVarZzes = this.zzBb.zzes();
            } else if (this.zzBc == 1) {
                this.zzBc = 2;
                zzeq();
                zzdVarZzes = this.zzBb.zzes();
            } else {
                zzdVarZzes = this.zzBc == 2 ? this.zzBb.zzes() : this.zzBb.zzes();
            }
        }
        return zzdVarZzes;
    }
}
