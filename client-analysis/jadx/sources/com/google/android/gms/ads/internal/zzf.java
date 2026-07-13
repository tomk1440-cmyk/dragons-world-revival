package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjq;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzf extends zzc implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private boolean zzpE;

    public class zza {
        public zza() {
        }

        public void onClick() {
            zzf.this.onAdClicked();
        }
    }

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzexVar, versionInfoParcel, zzdVar);
    }

    private AdSizeParcel zzb(zzif.zza zzaVar) {
        AdSize adSizeZzcQ;
        if (zzaVar.zzLe.zzul) {
            return this.zzpj.zzrp;
        }
        String str = zzaVar.zzLe.zzHW;
        if (str != null) {
            String[] strArrSplit = str.split("[xX]");
            strArrSplit[0] = strArrSplit[0].trim();
            strArrSplit[1] = strArrSplit[1].trim();
            adSizeZzcQ = new AdSize(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
        } else {
            adSizeZzcQ = this.zzpj.zzrp.zzcQ();
        }
        return new AdSizeParcel(this.zzpj.context, adSizeZzcQ);
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
    private boolean zzb(zzif zzifVar, zzif zzifVar2) {
        if (zzifVar2.zzHT) {
            View viewZzf = zzm.zzf(zzifVar2);
            if (viewZzf == null) {
                zzin.zzaK("Could not get mediation view");
                return false;
            }
            View nextView = this.zzpj.zzrm.getNextView();
            if (nextView != 0) {
                if (nextView instanceof zzjp) {
                    ((zzjp) nextView).destroy();
                }
                this.zzpj.zzrm.removeView(nextView);
            }
            if (!zzm.zzg(zzifVar2)) {
                try {
                    zzb(viewZzf);
                } catch (Throwable th) {
                    zzin.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            }
        } else if (zzifVar2.zzKW != null && zzifVar2.zzED != null) {
            zzifVar2.zzED.zza(zzifVar2.zzKW);
            this.zzpj.zzrm.removeAllViews();
            this.zzpj.zzrm.setMinimumWidth(zzifVar2.zzKW.widthPixels);
            this.zzpj.zzrm.setMinimumHeight(zzifVar2.zzKW.heightPixels);
            zzb(zzifVar2.zzED.getView());
        }
        if (this.zzpj.zzrm.getChildCount() > 1) {
            this.zzpj.zzrm.showNext();
        }
        if (zzifVar != null) {
            View nextView2 = this.zzpj.zzrm.getNextView();
            if (nextView2 instanceof zzjp) {
                ((zzjp) nextView2).zza(this.zzpj.context, this.zzpj.zzrp, this.zzpe);
            } else if (nextView2 != 0) {
                this.zzpj.zzrm.removeView(nextView2);
            }
            this.zzpj.zzbV();
        }
        this.zzpj.zzrm.setVisibility(0);
        return true;
    }

    private void zzd(final zzif zzifVar) {
        if (!this.zzpj.zzbW()) {
            if (this.zzpj.zzrK == null || zzifVar.zzKT == null) {
                return;
            }
            this.zzpl.zza(this.zzpj.zzrp, zzifVar, this.zzpj.zzrK);
            return;
        }
        if (zzifVar.zzED != null) {
            if (zzifVar.zzKT != null) {
                this.zzpl.zza(this.zzpj.zzrp, zzifVar);
            }
            if (zzifVar.zzcv()) {
                this.zzpl.zza(this.zzpj.zzrp, zzifVar).zza(zzifVar.zzED);
            } else {
                zzifVar.zzED.zzhU().zza(new zzjq.zzb() { // from class: com.google.android.gms.ads.internal.zzf.1
                    @Override // com.google.android.gms.internal.zzjq.zzb
                    public void zzbi() {
                        zzf.this.zzpl.zza(zzf.this.zzpj.zzrp, zzifVar).zza(zzifVar.zzED);
                    }
                });
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        zze(this.zzpj.zzrq);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        zze(this.zzpj.zzrq);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void setManualImpressionsEnabled(boolean enabled) {
        zzx.zzcD("setManualImpressionsEnabled must be called from the main thread.");
        this.zzpE = enabled;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected zzjp zza(zzif.zza zzaVar, zze zzeVar) {
        if (this.zzpj.zzrp.zzul) {
            this.zzpj.zzrp = zzb(zzaVar);
        }
        return super.zza(zzaVar, zzeVar);
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected void zza(zzif zzifVar, boolean z) {
        super.zza(zzifVar, z);
        if (zzm.zzg(zzifVar)) {
            zzm.zza(zzifVar, new zza());
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzif zzifVar, zzif zzifVar2) {
        if (!super.zza(zzifVar, zzifVar2)) {
            return false;
        }
        if (this.zzpj.zzbW() && !zzb(zzifVar, zzifVar2)) {
            zzf(0);
            return false;
        }
        if (zzifVar2.zzIm) {
            zze(zzifVar2);
            zzjk.zza((View) this.zzpj.zzrm, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzjk.zza((View) this.zzpj.zzrm, (ViewTreeObserver.OnScrollChangedListener) this);
        } else if (!this.zzpj.zzbX() || zzbt.zzxg.get().booleanValue()) {
            zza(zzifVar2, false);
        }
        zzd(zzifVar2);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zzaV() {
        boolean z = true;
        if (!zzr.zzbC().zza(this.zzpj.context.getPackageManager(), this.zzpj.context.getPackageName(), "android.permission.INTERNET")) {
            com.google.android.gms.ads.internal.client.zzn.zzcS().zza(this.zzpj.zzrm, this.zzpj.zzrp, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzr.zzbC().zzI(this.zzpj.context)) {
            com.google.android.gms.ads.internal.client.zzn.zzcS().zza(this.zzpj.zzrm, this.zzpj.zzrp, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzpj.zzrm != null) {
            this.zzpj.zzrm.setVisibility(0);
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(zze(adRequestParcel));
    }

    AdRequestParcel zze(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zztH == this.zzpE) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.versionCode, adRequestParcel.zztC, adRequestParcel.extras, adRequestParcel.zztD, adRequestParcel.zztE, adRequestParcel.zztF, adRequestParcel.zztG, adRequestParcel.zztH || this.zzpE, adRequestParcel.zztI, adRequestParcel.zztJ, adRequestParcel.zztK, adRequestParcel.zztL, adRequestParcel.zztM, adRequestParcel.zztN, adRequestParcel.zztO, adRequestParcel.zztP, adRequestParcel.zztQ, adRequestParcel.zztR);
    }

    void zze(zzif zzifVar) {
        if (zzifVar == null || zzifVar.zzKU || this.zzpj.zzrm == null || !zzr.zzbC().zza(this.zzpj.zzrm, this.zzpj.context) || !this.zzpj.zzrm.getGlobalVisibleRect(new Rect(), null)) {
            return;
        }
        zza(zzifVar, false);
        zzifVar.zzKU = true;
    }
}
