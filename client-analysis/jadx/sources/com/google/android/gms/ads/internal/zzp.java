package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzcf;
import com.google.android.gms.internal.zzcr;
import com.google.android.gms.internal.zzcs;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzp extends zzb {
    public zzp(Context context, zzd zzdVar, AdSizeParcel adSizeParcel, String str, zzex zzexVar, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzexVar, versionInfoParcel, zzdVar);
    }

    private static com.google.android.gms.ads.internal.formats.zzd zza(zzfb zzfbVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zzd(zzfbVar.getHeadline(), zzfbVar.getImages(), zzfbVar.getBody(), zzfbVar.zzdK() != null ? zzfbVar.zzdK() : null, zzfbVar.getCallToAction(), zzfbVar.getStarRating(), zzfbVar.getStore(), zzfbVar.getPrice(), null, zzfbVar.getExtras());
    }

    private static com.google.android.gms.ads.internal.formats.zze zza(zzfc zzfcVar) throws RemoteException {
        return new com.google.android.gms.ads.internal.formats.zze(zzfcVar.getHeadline(), zzfcVar.getImages(), zzfcVar.getBody(), zzfcVar.zzdO() != null ? zzfcVar.zzdO() : null, zzfcVar.getCallToAction(), zzfcVar.getAdvertiser(), null, zzfcVar.getExtras());
    }

    private void zza(final com.google.android.gms.ads.internal.formats.zzd zzdVar) {
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzp.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzp.this.zzpj.zzrz.zza(zzdVar);
                } catch (RemoteException e) {
                    zzin.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final com.google.android.gms.ads.internal.formats.zze zzeVar) {
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzp.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzp.this.zzpj.zzrA.zza(zzeVar);
                } catch (RemoteException e) {
                    zzin.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    private void zza(final zzif zzifVar, final String str) {
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzp.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zzp.this.zzpj.zzrC.get(str).zza((com.google.android.gms.ads.internal.formats.zzf) zzifVar.zzLa);
                } catch (RemoteException e) {
                    zzin.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzu
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(SimpleArrayMap<String, zzcu> simpleArrayMap) {
        zzx.zzcD("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzpj.zzrC = simpleArrayMap;
    }

    public void zza(com.google.android.gms.ads.internal.formats.zzh zzhVar) {
        if (this.zzpj.zzrq.zzKT != null) {
            zzr.zzbF().zzhh().zza(this.zzpj.zzrp, this.zzpj.zzrq, zzhVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzcf zzcfVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzu
    public void zza(zzgd zzgdVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza
    public void zza(final zzif.zza zzaVar, zzcb zzcbVar) {
        if (zzaVar.zzrp != null) {
            this.zzpj.zzrp = zzaVar.zzrp;
        }
        if (zzaVar.errorCode != -2) {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.zzp.1
                @Override // java.lang.Runnable
                public void run() {
                    zzp.this.zzb(new zzif(zzaVar, null, null, null, null, null, null));
                }
            });
            return;
        }
        this.zzpj.zzrL = 0;
        this.zzpj.zzro = zzr.zzbB().zza(this.zzpj.context, this, zzaVar, this.zzpj.zzrk, null, this.zzpn, this, zzcbVar);
        zzin.zzaI("AdRenderer: " + this.zzpj.zzro.getClass().getName());
    }

    public void zza(List<String> list) {
        zzx.zzcD("setNativeTemplates must be called on the main UI thread.");
        this.zzpj.zzrH = list;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzif zzifVar, boolean z) {
        return this.zzpi.zzbw();
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    protected boolean zza(zzif zzifVar, zzif zzifVar2) {
        zza((List<String>) null);
        if (!this.zzpj.zzbW()) {
            throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
        }
        if (zzifVar2.zzHT) {
            try {
                zzfb zzfbVarZzeF = zzifVar2.zzCq.zzeF();
                zzfc zzfcVarZzeG = zzifVar2.zzCq.zzeG();
                if (zzfbVarZzeF != null) {
                    com.google.android.gms.ads.internal.formats.zzd zzdVarZza = zza(zzfbVarZzeF);
                    zzdVarZza.zzb(new com.google.android.gms.ads.internal.formats.zzg(this.zzpj.context, this, this.zzpj.zzrk, zzfbVarZzeF));
                    zza(zzdVarZza);
                } else {
                    if (zzfcVarZzeG == null) {
                        zzin.zzaK("No matching mapper for retrieved native ad template.");
                        zzf(0);
                        return false;
                    }
                    com.google.android.gms.ads.internal.formats.zze zzeVarZza = zza(zzfcVarZzeG);
                    zzeVarZza.zzb(new com.google.android.gms.ads.internal.formats.zzg(this.zzpj.context, this, this.zzpj.zzrk, zzfcVarZzeG));
                    zza(zzeVarZza);
                }
            } catch (RemoteException e) {
                zzin.zzd("Failed to get native ad mapper", e);
            }
        } else {
            com.google.android.gms.ads.internal.formats.zzh.zza zzaVar = zzifVar2.zzLa;
            if ((zzaVar instanceof com.google.android.gms.ads.internal.formats.zze) && this.zzpj.zzrA != null) {
                zza((com.google.android.gms.ads.internal.formats.zze) zzifVar2.zzLa);
            } else if ((zzaVar instanceof com.google.android.gms.ads.internal.formats.zzd) && this.zzpj.zzrz != null) {
                zza((com.google.android.gms.ads.internal.formats.zzd) zzifVar2.zzLa);
            } else {
                if (!(zzaVar instanceof com.google.android.gms.ads.internal.formats.zzf) || this.zzpj.zzrC == null || this.zzpj.zzrC.get(((com.google.android.gms.ads.internal.formats.zzf) zzaVar).getCustomTemplateId()) == null) {
                    zzin.zzaK("No matching listener for retrieved native ad template.");
                    zzf(0);
                    return false;
                }
                zza(zzifVar2, ((com.google.android.gms.ads.internal.formats.zzf) zzaVar).getCustomTemplateId());
            }
        }
        return super.zza(zzifVar, zzifVar2);
    }

    public void zzb(SimpleArrayMap<String, zzct> simpleArrayMap) {
        zzx.zzcD("setOnCustomClickListener must be called on the main UI thread.");
        this.zzpj.zzrB = simpleArrayMap;
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzx.zzcD("setNativeAdOptions must be called on the main UI thread.");
        this.zzpj.zzrD = nativeAdOptionsParcel;
    }

    public void zzb(zzcr zzcrVar) {
        zzx.zzcD("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrz = zzcrVar;
    }

    public void zzb(zzcs zzcsVar) {
        zzx.zzcD("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzpj.zzrA = zzcsVar;
    }

    public SimpleArrayMap<String, zzcu> zzbv() {
        zzx.zzcD("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzpj.zzrC;
    }

    public zzct zzs(String str) {
        zzx.zzcD("getOnCustomClickListener must be called on the main UI thread.");
        return this.zzpj.zzrB.get(str);
    }
}
