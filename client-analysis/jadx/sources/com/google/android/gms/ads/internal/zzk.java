package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdj;
import com.google.android.gms.internal.zzdn;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjp;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzk extends zzc implements zzdj, zzdn.zza {
    protected transient boolean zzqc;
    private boolean zzqd;
    private float zzqe;
    private String zzqf;

    @zzhb
    private class zza extends zzim {
        private final String zzqg;

        public zza(String str) {
            this.zzqg = str;
        }

        @Override // com.google.android.gms.internal.zzim
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzim
        public void zzbr() {
            zzr.zzbC().zzg(zzk.this.zzpj.context, this.zzqg);
        }
    }

    @zzhb
    private class zzb extends zzim {
        private final String zzqg;
        private final Bitmap zzqi;

        public zzb(Bitmap bitmap, String str) {
            this.zzqi = bitmap;
            this.zzqg = str;
        }

        @Override // com.google.android.gms.internal.zzim
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzim
        public void zzbr() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(zzk.this.zzpj.zzql, zzk.this.zzbo(), zzk.this.zzpj.zzql ? zzr.zzbC().zza(zzk.this.zzpj.context, this.zzqi, this.zzqg) : false ? this.zzqg : null, zzk.this.zzqd, zzk.this.zzqe);
            int requestedOrientation = zzk.this.zzpj.zzrq.zzED.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = zzk.this.zzpj.zzrq.orientation;
            }
            final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(zzk.this, zzk.this, zzk.this, zzk.this.zzpj.zzrq.zzED, requestedOrientation, zzk.this.zzpj.zzrl, zzk.this.zzpj.zzrq.zzHY, interstitialAdParameterParcel);
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzk.zzb.1
                @Override // java.lang.Runnable
                public void run() {
                    zzr.zzbA().zza(zzk.this.zzpj.context, adOverlayInfoParcel);
                }
            });
        }
    }

    public zzk(Context context, AdSizeParcel adSizeParcel, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzexVar, versionInfoParcel, zzdVar);
        this.zzqc = false;
        this.zzqf = "background" + hashCode() + ".png";
    }

    private void zzb(Bundle bundle) {
        zzr.zzbC().zzb(this.zzpj.context, this.zzpj.zzrl.afmaVersion, "gmob-apps", bundle, false);
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        zzx.zzcD("showInterstitial must be called on the main UI thread.");
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("The interstitial has not loaded.");
            return;
        }
        if (zzbt.zzwN.get().booleanValue()) {
            String packageName = this.zzpj.context.getApplicationContext() != null ? this.zzpj.context.getApplicationContext().getPackageName() : this.zzpj.context.getPackageName();
            if (!this.zzqc) {
                zzin.zzaK("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_before_load_finish");
                zzb(bundle);
            }
            if (!zzr.zzbC().zzO(this.zzpj.context)) {
                zzin.zzaK("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_app_not_in_foreground");
                zzb(bundle2);
            }
        }
        if (this.zzpj.zzbX()) {
            return;
        }
        if (this.zzpj.zzrq.zzHT) {
            try {
                this.zzpj.zzrq.zzCq.showInterstitial();
                return;
            } catch (RemoteException e) {
                zzin.zzd("Could not show interstitial.", e);
                zzbp();
                return;
            }
        }
        if (this.zzpj.zzrq.zzED == null) {
            zzin.zzaK("The interstitial failed to load.");
            return;
        }
        if (this.zzpj.zzrq.zzED.zzhY()) {
            zzin.zzaK("The interstitial is already showing.");
            return;
        }
        this.zzpj.zzrq.zzED.zzD(true);
        if (this.zzpj.zzrq.zzKT != null) {
            this.zzpl.zza(this.zzpj.zzrp, this.zzpj.zzrq);
        }
        Bitmap bitmapZzP = this.zzpj.zzql ? zzr.zzbC().zzP(this.zzpj.context) : null;
        if (zzbt.zzxe.get().booleanValue() && bitmapZzP != null) {
            new zzb(bitmapZzP, this.zzqf).zzgd();
            return;
        }
        InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzpj.zzql, zzbo(), null, false, 0.0f);
        int requestedOrientation = this.zzpj.zzrq.zzED.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzpj.zzrq.orientation;
        }
        zzr.zzbA().zza(this.zzpj.context, new AdOverlayInfoParcel(this, this, this, this.zzpj.zzrq.zzED, requestedOrientation, this.zzpj.zzrl, this.zzpj.zzrq.zzHY, interstitialAdParameterParcel));
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected zzjp zza(zzif.zza zzaVar, zze zzeVar) {
        zzjp zzjpVarZza = zzr.zzbD().zza(this.zzpj.context, this.zzpj.zzrp, false, false, this.zzpj.zzrk, this.zzpj.zzrl, this.zzpe, this.zzpm);
        zzjpVarZza.zzhU().zzb(this, null, this, this, zzbt.zzwv.get().booleanValue(), this, this, zzeVar, null);
        zza(zzjpVarZza);
        zzjpVarZza.zzaM(zzaVar.zzLd.zzHI);
        zzdn.zza(zzjpVarZza, this);
        return zzjpVarZza;
    }

    @Override // com.google.android.gms.internal.zzdj
    public void zza(boolean z, float f) {
        this.zzqd = z;
        this.zzqe = f;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(AdRequestParcel adRequestParcel, zzcb zzcbVar) {
        if (this.zzpj.zzrq == null) {
            return super.zza(adRequestParcel, zzcbVar);
        }
        zzin.zzaK("An interstitial is already loading. Aborting.");
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzif zzifVar, boolean z) {
        if (this.zzpj.zzbW() && zzifVar.zzED != null) {
            zzr.zzbE().zzi(zzifVar.zzED);
        }
        return this.zzpi.zzbw();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzif zzifVar, zzif zzifVar2) {
        if (!super.zza(zzifVar, zzifVar2)) {
            return false;
        }
        if (!this.zzpj.zzbW() && this.zzpj.zzrK != null && zzifVar2.zzKT != null) {
            this.zzpl.zza(this.zzpj.zzrp, zzifVar2, this.zzpj.zzrK);
        }
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zzaQ() {
        zzbp();
        super.zzaQ();
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected void zzaT() {
        super.zzaT();
        this.zzqc = true;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.overlay.zzg
    public void zzaX() {
        recordImpression();
        super.zzaX();
    }

    @Override // com.google.android.gms.internal.zzdn.zza
    public void zzb(RewardItemParcel rewardItemParcel) {
        if (this.zzpj.zzrq != null) {
            if (this.zzpj.zzrq.zzIl != null) {
                zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzIl);
            }
            if (this.zzpj.zzrq.zzIj != null) {
                rewardItemParcel = this.zzpj.zzrq.zzIj;
            }
        }
        zza(rewardItemParcel);
    }

    protected boolean zzbo() {
        Window window;
        if (!(this.zzpj.context instanceof Activity) || (window = ((Activity) this.zzpj.context).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    public void zzbp() {
        new zza(this.zzqf).zzgd();
        if (this.zzpj.zzbW()) {
            this.zzpj.zzbT();
            this.zzpj.zzrq = null;
            this.zzpj.zzql = false;
            this.zzqc = false;
        }
    }

    @Override // com.google.android.gms.internal.zzdn.zza
    public void zzbq() {
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzKX != null) {
            zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq.zzKX);
        }
        zzaU();
    }

    @Override // com.google.android.gms.internal.zzdj
    public void zzd(boolean z) {
        this.zzpj.zzql = z;
    }
}
