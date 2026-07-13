package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzga;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzb extends zza implements com.google.android.gms.ads.internal.overlay.zzg, com.google.android.gms.ads.internal.purchase.zzj, zzdh, zzep {
    private final Messenger mMessenger;
    protected final zzex zzpn;
    protected transient boolean zzpo;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        this(new zzs(context, adSizeParcel, str, versionInfoParcel), zzexVar, null, zzdVar);
    }

    zzb(zzs zzsVar, zzex zzexVar, zzq zzqVar, zzd zzdVar) {
        super(zzsVar, zzqVar, zzdVar);
        this.zzpn = zzexVar;
        this.mMessenger = new Messenger(new zzga(this.zzpj.context));
        this.zzpo = false;
    }

    private AdRequestInfoParcel.zza zza(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo = this.zzpj.context.getApplicationInfo();
        try {
            packageInfo = this.zzpj.context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzpj.context.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (this.zzpj.zzrm != null && this.zzpj.zzrm.getParent() != null) {
            int[] iArr = new int[2];
            this.zzpj.zzrm.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int width = this.zzpj.zzrm.getWidth();
            int height = this.zzpj.zzrm.getHeight();
            int i3 = 0;
            if (this.zzpj.zzrm.isShown() && i + width > 0 && i2 + height > 0 && i <= displayMetrics.widthPixels && i2 <= displayMetrics.heightPixels) {
                i3 = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i);
            bundle2.putInt("y", i2);
            bundle2.putInt(SettingsJsonConstants.ICON_WIDTH_KEY, width);
            bundle2.putInt(SettingsJsonConstants.ICON_HEIGHT_KEY, height);
            bundle2.putInt("visible", i3);
        }
        String strZzgZ = zzr.zzbF().zzgZ();
        this.zzpj.zzrs = new zzig(strZzgZ, this.zzpj.zzrj);
        this.zzpj.zzrs.zzk(adRequestParcel);
        String strZza = zzr.zzbC().zza(this.zzpj.context, this.zzpj.zzrm, this.zzpj.zzrp);
        long value = 0;
        if (this.zzpj.zzrw != null) {
            try {
                value = this.zzpj.zzrw.getValue();
            } catch (RemoteException e2) {
                zzin.zzaK("Cannot get correlation id, default to 0.");
            }
        }
        String string = UUID.randomUUID().toString();
        Bundle bundleZza = zzr.zzbF().zza(this.zzpj.context, this, strZzgZ);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.zzpj.zzrC.size(); i4++) {
            arrayList.add(this.zzpj.zzrC.keyAt(i4));
        }
        return new AdRequestInfoParcel.zza(bundle2, adRequestParcel, this.zzpj.zzrp, this.zzpj.zzrj, applicationInfo, packageInfo, strZzgZ, zzr.zzbF().getSessionId(), this.zzpj.zzrl, bundleZza, this.zzpj.zzrH, arrayList, bundle, zzr.zzbF().zzhd(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, strZza, value, string, zzbt.zzdr(), this.zzpj.zzri, this.zzpj.zzrD, new CapabilityParcel(this.zzpj.zzrx != null, this.zzpj.zzry != null && zzr.zzbF().zzhj(), this.zzpm.zzpy.zzfM()), this.zzpj.zzca(), zzr.zzbC().zzbt(), zzr.zzbC().zzR(this.zzpj.context), zzr.zzbC().zzl(this.zzpj.zzrm));
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public String getMediationAdapterClassName() {
        if (this.zzpj.zzrq == null) {
            return null;
        }
        return this.zzpj.zzrq.zzCr;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zza
    public void onAdClicked() {
        if (this.zzpj.zzrq == null) {
            zzin.zzaK("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (this.zzpj.zzrq.zzKV != null && this.zzpj.zzrq.zzKV.zzBQ != null) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzKV.zzBQ);
        }
        if (this.zzpj.zzrq.zzCp != null && this.zzpj.zzrq.zzCp.zzBE != null) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, this.zzpj.zzrq, this.zzpj.zzrj, false, this.zzpj.zzrq.zzCp.zzBE);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void onPause() {
        this.zzpl.zzk(this.zzpj.zzrq);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void onResume() {
        this.zzpl.zzl(this.zzpj.zzrq);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        zzx.zzcD("pause must be called on the main UI thread.");
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzED != null && this.zzpj.zzbW()) {
            zzr.zzbE().zzi(this.zzpj.zzrq.zzED);
        }
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzCq != null) {
            try {
                this.zzpj.zzrq.zzCq.pause();
            } catch (RemoteException e) {
                zzin.zzaK("Could not pause mediation adapter.");
            }
        }
        this.zzpl.zzk(this.zzpj.zzrq);
        this.zzpi.pause();
    }

    public void recordImpression() {
        zza(this.zzpj.zzrq, false);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        zzx.zzcD("resume must be called on the main UI thread.");
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzED != null && this.zzpj.zzbW()) {
            zzr.zzbE().zzj(this.zzpj.zzrq.zzED);
        }
        if (this.zzpj.zzrq != null && this.zzpj.zzrq.zzCq != null) {
            try {
                this.zzpj.zzrq.zzCq.resume();
            } catch (RemoteException e) {
                zzin.zzaK("Could not resume mediation adapter.");
            }
        }
        this.zzpi.resume();
        this.zzpl.zzl(this.zzpj.zzrq);
    }

    @Override // com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgd zzgdVar) {
        zzx.zzcD("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzpj.zzrx = zzgdVar;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgh zzghVar, String str) {
        zzx.zzcD("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzpj.zzrI = new com.google.android.gms.ads.internal.purchase.zzk(str);
        this.zzpj.zzry = zzghVar;
        if (zzr.zzbF().zzhc() || zzghVar == null) {
            return;
        }
        new com.google.android.gms.ads.internal.purchase.zzc(this.zzpj.context, this.zzpj.zzry, this.zzpj.zzrI).zzgd();
    }

    protected void zza(zzif zzifVar, boolean z) {
        if (zzifVar == null) {
            zzin.zzaK("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(zzifVar);
        if (zzifVar.zzKV != null && zzifVar.zzKV.zzBR != null) {
            zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzifVar, this.zzpj.zzrj, z, zzifVar.zzKV.zzBR);
        }
        if (zzifVar.zzCp == null || zzifVar.zzCp.zzBF == null) {
            return;
        }
        zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzifVar, this.zzpj.zzrj, z, zzifVar.zzCp.zzBF);
    }

    @Override // com.google.android.gms.internal.zzdh
    public void zza(String str, ArrayList<String> arrayList) {
        com.google.android.gms.ads.internal.purchase.zzd zzdVar = new com.google.android.gms.ads.internal.purchase.zzd(str, arrayList, this.zzpj.context, this.zzpj.zzrl.afmaVersion);
        if (this.zzpj.zzrx != null) {
            try {
                this.zzpj.zzrx.zza(zzdVar);
                return;
            } catch (RemoteException e) {
                zzin.zzaK("Could not start In-App purchase.");
                return;
            }
        }
        zzin.zzaK("InAppPurchaseListener is not set. Try to launch default purchase flow.");
        if (!com.google.android.gms.ads.internal.client.zzn.zzcS().zzU(this.zzpj.context)) {
            zzin.zzaK("Google Play Service unavailable, cannot launch default purchase flow.");
            return;
        }
        if (this.zzpj.zzry == null) {
            zzin.zzaK("PlayStorePurchaseListener is not set.");
            return;
        }
        if (this.zzpj.zzrI == null) {
            zzin.zzaK("PlayStorePurchaseVerifier is not initialized.");
            return;
        }
        if (this.zzpj.zzrM) {
            zzin.zzaK("An in-app purchase request is already in progress, abort");
            return;
        }
        this.zzpj.zzrM = true;
        try {
            if (this.zzpj.zzry.isValidPurchase(str)) {
                zzr.zzbM().zza(this.zzpj.context, this.zzpj.zzrl.zzNb, new GInAppPurchaseManagerInfoParcel(this.zzpj.context, this.zzpj.zzrI, zzdVar, this));
            } else {
                this.zzpj.zzrM = false;
            }
        } catch (RemoteException e2) {
            zzin.zzaK("Could not start In-App purchase.");
            this.zzpj.zzrM = false;
        }
    }

    @Override // com.google.android.gms.ads.internal.purchase.zzj
    public void zza(String str, boolean z, int i, final Intent intent, com.google.android.gms.ads.internal.purchase.zzf zzfVar) {
        try {
            if (this.zzpj.zzry != null) {
                this.zzpj.zzry.zza(new com.google.android.gms.ads.internal.purchase.zzg(this.zzpj.context, str, z, i, intent, zzfVar));
            }
        } catch (RemoteException e) {
            zzin.zzaK("Fail to invoke PlayStorePurchaseListener.");
        }
        zzir.zzMc.postDelayed(new Runnable() { // from class: com.google.android.gms.ads.internal.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                int iZzd = zzr.zzbM().zzd(intent);
                zzr.zzbM();
                if (iZzd == 0 && zzb.this.zzpj.zzrq != null && zzb.this.zzpj.zzrq.zzED != null && zzb.this.zzpj.zzrq.zzED.zzhS() != null) {
                    zzb.this.zzpj.zzrq.zzED.zzhS().close();
                }
                zzb.this.zzpj.zzrM = false;
            }
        }, 500L);
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(AdRequestParcel adRequestParcel, zzcb zzcbVar) {
        if (!zzaV()) {
            return false;
        }
        Bundle bundleZza = zza(zzr.zzbF().zzG(this.zzpj.context));
        this.zzpi.cancel();
        this.zzpj.zzrL = 0;
        AdRequestInfoParcel.zza zzaVarZza = zza(adRequestParcel, bundleZza);
        zzcbVar.zzc("seq_num", zzaVarZza.zzHw);
        zzcbVar.zzc("request_id", zzaVarZza.zzHI);
        zzcbVar.zzc("session_id", zzaVarZza.zzHx);
        if (zzaVarZza.zzHu != null) {
            zzcbVar.zzc("app_version", String.valueOf(zzaVarZza.zzHu.versionCode));
        }
        this.zzpj.zzrn = zzr.zzby().zza(this.zzpj.context, zzaVarZza, this.zzpj.zzrk, this);
        return true;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzif zzifVar, boolean z) {
        if (!z && this.zzpj.zzbW()) {
            if (zzifVar.zzBU > 0) {
                this.zzpi.zza(adRequestParcel, zzifVar.zzBU);
            } else if (zzifVar.zzKV != null && zzifVar.zzKV.zzBU > 0) {
                this.zzpi.zza(adRequestParcel, zzifVar.zzKV.zzBU);
            } else if (!zzifVar.zzHT && zzifVar.errorCode == 2) {
                this.zzpi.zzg(adRequestParcel);
            }
        }
        return this.zzpi.zzbw();
    }

    @Override // com.google.android.gms.ads.internal.zza
    boolean zza(zzif zzifVar) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzpk != null) {
            adRequestParcel = this.zzpk;
            this.zzpk = null;
        } else {
            adRequestParcel = zzifVar.zzHt;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, zzifVar, z);
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected boolean zza(zzif zzifVar, zzif zzifVar2) {
        int i;
        int i2 = 0;
        if (zzifVar != null && zzifVar.zzCs != null) {
            zzifVar.zzCs.zza((zzep) null);
        }
        if (zzifVar2.zzCs != null) {
            zzifVar2.zzCs.zza(this);
        }
        if (zzifVar2.zzKV != null) {
            i = zzifVar2.zzKV.zzBZ;
            i2 = zzifVar2.zzKV.zzCa;
        } else {
            i = 0;
        }
        this.zzpj.zzrJ.zzg(i, i2);
        return true;
    }

    protected boolean zzaV() {
        return zzr.zzbC().zza(this.zzpj.context.getPackageManager(), this.zzpj.context.getPackageName(), "android.permission.INTERNET") && zzr.zzbC().zzI(this.zzpj.context);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void zzaW() {
        this.zzpl.zzi(this.zzpj.zzrq);
        this.zzpo = false;
        zzaQ();
        this.zzpj.zzrs.zzgU();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzg
    public void zzaX() {
        this.zzpo = true;
        zzaS();
    }

    @Override // com.google.android.gms.internal.zzep
    public void zzaY() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.zzep
    public void zzaZ() {
        zzaW();
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.zzgr.zza
    public void zzb(zzif zzifVar) {
        super.zzb(zzifVar);
        if (zzifVar.errorCode != 3 || zzifVar.zzKV == null || zzifVar.zzKV.zzBS == null) {
            return;
        }
        zzin.zzaI("Pinging no fill URLs.");
        zzr.zzbP().zza(this.zzpj.context, this.zzpj.zzrl.afmaVersion, zzifVar, this.zzpj.zzrj, false, zzifVar.zzKV.zzBS);
    }

    @Override // com.google.android.gms.internal.zzep
    public void zzba() {
        zzaO();
    }

    @Override // com.google.android.gms.internal.zzep
    public void zzbb() {
        zzaX();
    }

    @Override // com.google.android.gms.internal.zzep
    public void zzbc() {
        if (this.zzpj.zzrq != null) {
            zzin.zzaK("Mediation adapter " + this.zzpj.zzrq.zzCr + " refreshed, but mediation adapters should never refresh.");
        }
        zza(this.zzpj.zzrq, true);
        zzaT();
    }

    @Override // com.google.android.gms.ads.internal.zza
    protected boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzpo;
    }
}
