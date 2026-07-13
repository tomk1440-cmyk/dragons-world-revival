package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjp;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzc extends zzb implements zzg, zzft {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzexVar, versionInfoParcel, zzdVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected zzjp zza(zzif.zza zzaVar, zze zzeVar) {
        zzjp zzjpVar;
        View nextView = this.zzpj.zzrm.getNextView();
        if (nextView instanceof zzjp) {
            zzin.zzaI("Reusing webview...");
            zzjp zzjpVar2 = (zzjp) nextView;
            zzjpVar2.zza(this.zzpj.context, this.zzpj.zzrp, this.zzpe);
            zzjpVar = zzjpVar2;
        } else {
            if (nextView != 0) {
                this.zzpj.zzrm.removeView(nextView);
            }
            zzjp zzjpVarZza = zzr.zzbD().zza(this.zzpj.context, this.zzpj.zzrp, false, false, this.zzpj.zzrk, this.zzpj.zzrl, this.zzpe, this.zzpm);
            if (this.zzpj.zzrp.zzuj == null) {
                zzb(zzjpVarZza.getView());
            }
            zzjpVar = zzjpVarZza;
        }
        zzjpVar.zzhU().zzb(this, this, this, this, false, this, null, zzeVar, this);
        zza(zzjpVar);
        zzjpVar.zzaM(zzaVar.zzLd.zzHI);
        return zzjpVar;
    }

    @Override // com.google.android.gms.internal.zzft
    public void zza(int i, int i2, int i3, int i4) {
        zzaS();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzcf zzcfVar) {
        zzx.zzcD("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrE = zzcfVar;
    }

    protected void zza(zzeh zzehVar) {
        zzehVar.zza("/trackActiveViewUnit", new zzdf() { // from class: com.google.android.gms.ads.internal.zzc.1
            @Override // com.google.android.gms.internal.zzdf
            public void zza(zzjp zzjpVar, Map<String, String> map) {
                if (zzc.this.zzpj.zzrq != null) {
                    zzc.this.zzpl.zza(zzc.this.zzpj.zzrp, zzc.this.zzpj.zzrq, zzjpVar.getView(), zzjpVar);
                } else {
                    zzin.zzaK("Request to enable ActiveView before adState is available.");
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zza(final zzif.zza zzaVar, final zzcb zzcbVar) {
        if (zzaVar.errorCode != -2) {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzc.2
                @Override // java.lang.Runnable
                public void run() {
                    zzc.this.zzb(new zzif(zzaVar, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (zzaVar.zzrp != null) {
            this.zzpj.zzrp = zzaVar.zzrp;
        }
        if (!zzaVar.zzLe.zzHT || zzaVar.zzLe.zzum) {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzc.3
                @Override // java.lang.Runnable
                public void run() {
                    if (zzaVar.zzLe.zzIc && zzc.this.zzpj.zzrE != null) {
                        zzcc zzccVar = new zzcc(zzc.this, zzaVar.zzLe.zzEF != null ? zzr.zzbC().zzaC(zzaVar.zzLe.zzEF) : null, zzaVar.zzLe.body);
                        zzc.this.zzpj.zzrL = 1;
                        try {
                            zzc.this.zzph = false;
                            zzc.this.zzpj.zzrE.zza(zzccVar);
                            return;
                        } catch (RemoteException e) {
                            zzin.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                            zzc.this.zzph = true;
                        }
                    }
                    final zze zzeVar = new zze();
                    zzjp zzjpVarZza = zzc.this.zza(zzaVar, zzeVar);
                    zzeVar.zza(new zze.zzb(zzaVar, zzjpVarZza));
                    zzjpVarZza.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.ads.internal.zzc.3.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View v, MotionEvent event) {
                            zzeVar.recordClick();
                            return false;
                        }
                    });
                    zzjpVarZza.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.ads.internal.zzc.3.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            zzeVar.recordClick();
                        }
                    });
                    zzc.this.zzpj.zzrL = 0;
                    zzc.this.zzpj.zzro = zzr.zzbB().zza(zzc.this.zzpj.context, zzc.this, zzaVar, zzc.this.zzpj.zzrk, zzjpVarZza, zzc.this.zzpn, zzc.this, zzcbVar);
                }
            });
            return;
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = zzr.zzbB().zza(this.zzpj.context, this, zzaVar, this.zzpj.zzrk, null, this.zzpn, this, zzcbVar);
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    protected boolean zza(zzif zzifVar, zzif zzifVar2) {
        if (this.zzpj.zzbW() && this.zzpj.zzrm != null) {
            this.zzpj.zzrm.zzcc().zzaF(zzifVar2.zzHY);
        }
        return super.zza(zzifVar, zzifVar2);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public void zzbd() {
        onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public void zzbe() {
        recordImpression();
        zzaP();
    }

    @Override // com.google.android.gms.internal.zzft
    public void zzbf() {
        zzaQ();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public void zzc(View view) {
        this.zzpj.zzrK = view;
        zzb(new zzif(this.zzpj.zzrr, null, null, null, null, null, null));
    }
}
