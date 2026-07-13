package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzer implements zzes.zza {
    private final Context mContext;
    private final String zzCd;
    private final long zzCe;
    private final zzeo zzCf;
    private final zzen zzCg;
    private final AdSizeParcel zzCh;
    private zzey zzCi;
    private zzfa zzCk;
    private final NativeAdOptionsParcel zzpP;
    private final List<String> zzpQ;
    private final VersionInfoParcel zzpT;
    private final zzex zzpn;
    private final AdRequestParcel zzqH;
    private final boolean zzsA;
    private final boolean zzuS;
    private final Object zzpV = new Object();
    private int zzCj = -2;

    public zzer(Context context, String str, zzex zzexVar, zzeo zzeoVar, zzen zzenVar, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.mContext = context;
        this.zzpn = zzexVar;
        this.zzCg = zzenVar;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzCd = zzey();
        } else {
            this.zzCd = str;
        }
        this.zzCf = zzeoVar;
        this.zzCe = zzeoVar.zzBP != -1 ? zzeoVar.zzBP : 10000L;
        this.zzqH = adRequestParcel;
        this.zzCh = adSizeParcel;
        this.zzpT = versionInfoParcel;
        this.zzsA = z;
        this.zzuS = z2;
        this.zzpP = nativeAdOptionsParcel;
        this.zzpQ = list;
    }

    private void zza(long j, long j2, long j3, long j4) {
        while (this.zzCj == -2) {
            zzb(j, j2, j3, j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(zzeq zzeqVar) {
        if ("com.google.ads.mediation.AdUrlAdapter".equals(this.zzCd)) {
            Bundle bundle = this.zzqH.zztM.getBundle(this.zzCd);
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("sdk_less_network_id", this.zzCg.zzBA);
            this.zzqH.zztM.putBundle(this.zzCd, bundle);
        }
        String strZzac = zzac(this.zzCg.zzBG);
        try {
            if (this.zzpT.zzNa < 4100000) {
                if (this.zzCh.zzui) {
                    this.zzCi.zza(com.google.android.gms.dynamic.zze.zzC(this.mContext), this.zzqH, strZzac, zzeqVar);
                } else {
                    this.zzCi.zza(com.google.android.gms.dynamic.zze.zzC(this.mContext), this.zzCh, this.zzqH, strZzac, zzeqVar);
                }
            } else if (this.zzsA) {
                this.zzCi.zza(com.google.android.gms.dynamic.zze.zzC(this.mContext), this.zzqH, strZzac, this.zzCg.zzBz, zzeqVar, this.zzpP, this.zzpQ);
            } else if (this.zzCh.zzui) {
                this.zzCi.zza(com.google.android.gms.dynamic.zze.zzC(this.mContext), this.zzqH, strZzac, this.zzCg.zzBz, zzeqVar);
            } else if (!this.zzuS || this.zzCg.zzBJ == null) {
                this.zzCi.zza(com.google.android.gms.dynamic.zze.zzC(this.mContext), this.zzCh, this.zzqH, strZzac, this.zzCg.zzBz, zzeqVar);
            } else {
                this.zzCi.zza(com.google.android.gms.dynamic.zze.zzC(this.mContext), this.zzqH, strZzac, this.zzCg.zzBz, zzeqVar, new NativeAdOptionsParcel(zzad(this.zzCg.zzBN)), this.zzCg.zzBM);
            }
        } catch (RemoteException e) {
            zzin.zzd("Could not request ad from mediation adapter.", e);
            zzr(5);
        }
    }

    private String zzac(String str) {
        if (str == null || !zzeB() || zzs(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            zzin.zzaK("Could not remove field. Returning the original value");
            return str;
        }
    }

    private static NativeAdOptions zzad(String str) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(zzae(jSONObject.optString("native_image_orientation", "any")));
        } catch (JSONException e) {
            zzin.zzd("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private static int zzae(String str) {
        if ("landscape".equals(str)) {
            return 2;
        }
        return "portrait".equals(str) ? 1 : 0;
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (jElapsedRealtime - j);
        long j6 = j4 - (jElapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            zzin.zzaJ("Timed out waiting for adapter.");
            this.zzCj = 3;
        } else {
            try {
                this.zzpV.wait(Math.min(j5, j6));
            } catch (InterruptedException e) {
                this.zzCj = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzey zzeA() {
        zzin.zzaJ("Instantiating mediation adapter: " + this.zzCd);
        if (zzbt.zzwV.get().booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzCd)) {
            return new zzfe(new AdMobAdapter());
        }
        if (zzbt.zzwW.get().booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzCd)) {
            return new zzfe(new AdUrlAdapter());
        }
        try {
            return this.zzpn.zzaf(this.zzCd);
        } catch (RemoteException e) {
            zzin.zza("Could not instantiate mediation adapter: " + this.zzCd, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzeB() {
        return this.zzCf.zzBX != -1;
    }

    private int zzeC() {
        if (this.zzCg.zzBG == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzCg.zzBG);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzCd)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int iOptInt = zzs(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return iOptInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : iOptInt;
        } catch (JSONException e) {
            zzin.zzaK("Could not convert to json. Returning 0");
            return 0;
        }
    }

    private String zzey() {
        try {
            return (TextUtils.isEmpty(this.zzCg.zzBD) || !this.zzpn.zzag(this.zzCg.zzBD)) ? "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException e) {
            zzin.zzaK("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzfa zzez() {
        if (this.zzCj != 0 || !zzeB()) {
            return null;
        }
        try {
            if (zzs(4) && this.zzCk != null && this.zzCk.zzeD() != 0) {
                return this.zzCk;
            }
        } catch (RemoteException e) {
            zzin.zzaK("Could not get cpm value from MediationResponseMetadata");
        }
        return zzt(zzeC());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzs(int i) {
        Bundle interstitialAdapterInfo;
        try {
            if (this.zzsA) {
                interstitialAdapterInfo = this.zzCi.zzeI();
            } else {
                interstitialAdapterInfo = this.zzCh.zzui ? this.zzCi.getInterstitialAdapterInfo() : this.zzCi.zzeH();
            }
            if (interstitialAdapterInfo != null) {
                return (interstitialAdapterInfo.getInt("capabilities", 0) & i) == i;
            }
            return false;
        } catch (RemoteException e) {
            zzin.zzaK("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static zzfa zzt(final int i) {
        return new zzfa.zza() { // from class: com.google.android.gms.internal.zzer.2
            @Override // com.google.android.gms.internal.zzfa
            public int zzeD() throws RemoteException {
                return i;
            }
        };
    }

    public void cancel() {
        synchronized (this.zzpV) {
            try {
                if (this.zzCi != null) {
                    this.zzCi.destroy();
                }
            } catch (RemoteException e) {
                zzin.zzd("Could not destroy mediation adapter.", e);
            }
            this.zzCj = -1;
            this.zzpV.notify();
        }
    }

    public zzes zza(long j, long j2) {
        zzes zzesVar;
        synchronized (this.zzpV) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            final zzeq zzeqVar = new zzeq();
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzer.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzer.this.zzpV) {
                        if (zzer.this.zzCj != -2) {
                            return;
                        }
                        zzer.this.zzCi = zzer.this.zzeA();
                        if (zzer.this.zzCi == null) {
                            zzer.this.zzr(4);
                            return;
                        }
                        if (!zzer.this.zzeB() || zzer.this.zzs(1)) {
                            zzeqVar.zza(zzer.this);
                            zzer.this.zza(zzeqVar);
                        } else {
                            zzin.zzaK("Ignoring adapter " + zzer.this.zzCd + " as delayed impression is not supported");
                            zzer.this.zzr(2);
                        }
                    }
                }
            });
            zza(jElapsedRealtime, this.zzCe, j, j2);
            zzesVar = new zzes(this.zzCg, this.zzCi, this.zzCd, zzeqVar, this.zzCj, zzez());
        }
        return zzesVar;
    }

    @Override // com.google.android.gms.internal.zzes.zza
    public void zza(int i, zzfa zzfaVar) {
        synchronized (this.zzpV) {
            this.zzCj = i;
            this.zzCk = zzfaVar;
            this.zzpV.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzes.zza
    public void zzr(int i) {
        synchronized (this.zzpV) {
            this.zzCj = i;
            this.zzpV.notify();
        }
    }
}
