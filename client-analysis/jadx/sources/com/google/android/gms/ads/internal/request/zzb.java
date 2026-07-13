package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzit;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjj;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzb extends zzim implements zzc.zza {
    private final Context mContext;
    zzeo zzCf;
    private AdRequestInfoParcel zzCu;
    AdResponseParcel zzGe;
    private Runnable zzGf;
    private final Object zzGg = new Object();
    private final com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza zzHg;
    private final AdRequestInfoParcel.zza zzHh;
    zzit zzHi;
    private final zzan zzyt;

    @zzhb
    static final class zza extends Exception {
        private final int zzGu;

        public zza(String str, int i) {
            super(str);
            this.zzGu = i;
        }

        public int getErrorCode() {
            return this.zzGu;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza interfaceC0027zza) {
        this.zzHg = interfaceC0027zza;
        this.mContext = context;
        this.zzHh = zzaVar;
        this.zzyt = zzanVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzc(int i, String str) {
        if (i == 3 || i == -1) {
            zzin.zzaJ(str);
        } else {
            zzin.zzaK(str);
        }
        if (this.zzGe == null) {
            this.zzGe = new AdResponseParcel(i);
        } else {
            this.zzGe = new AdResponseParcel(i, this.zzGe.zzBU);
        }
        this.zzHg.zza(new zzif.zza(this.zzCu != null ? this.zzCu : new AdRequestInfoParcel(this.zzHh, null, -1L), this.zzGe, this.zzCf, null, i, -1L, this.zzGe.zzHX, null));
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
        synchronized (this.zzGg) {
            if (this.zzHi != null) {
                this.zzHi.cancel();
            }
        }
    }

    zzit zza(VersionInfoParcel versionInfoParcel, zzji<AdRequestInfoParcel> zzjiVar) {
        return zzc.zza(this.mContext, versionInfoParcel, zzjiVar, this);
    }

    protected AdSizeParcel zzb(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzGe.zzHW == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] strArrSplit = this.zzGe.zzHW.split("x");
        if (strArrSplit.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzGe.zzHW, 0);
        }
        try {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzrp.zzuj) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i3 = adSizeParcel.width == -1 ? (int) (adSizeParcel.widthPixels / f) : adSizeParcel.width;
                int i4 = adSizeParcel.height == -2 ? (int) (adSizeParcel.heightPixels / f) : adSizeParcel.height;
                if (i == i3 && i2 == i4) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzrp.zzuj);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzGe.zzHW, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzGe.zzHW, 0);
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(@NonNull AdResponseParcel adResponseParcel) {
        JSONObject jSONObject;
        zzin.zzaI("Received ad response.");
        this.zzGe = adResponseParcel;
        long jElapsedRealtime = zzr.zzbG().elapsedRealtime();
        synchronized (this.zzGg) {
            this.zzHi = null;
        }
        try {
            if (this.zzGe.errorCode != -2 && this.zzGe.errorCode != -3) {
                throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzGe.errorCode, this.zzGe.errorCode);
            }
            zzgq();
            AdSizeParcel adSizeParcelZzb = this.zzCu.zzrp.zzuj != null ? zzb(this.zzCu) : null;
            zzr.zzbF().zzB(this.zzGe.zzId);
            if (TextUtils.isEmpty(this.zzGe.zzIb)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(this.zzGe.zzIb);
                } catch (Exception e) {
                    zzin.zzb("Error parsing the JSON for Active View.", e);
                    jSONObject = null;
                }
            }
            this.zzHg.zza(new zzif.zza(this.zzCu, this.zzGe, this.zzCf, adSizeParcelZzb, -2, jElapsedRealtime, this.zzGe.zzHX, jSONObject));
            zzir.zzMc.removeCallbacks(this.zzGf);
        } catch (zza e2) {
            zzc(e2.getErrorCode(), e2.getMessage());
            zzir.zzMc.removeCallbacks(this.zzGf);
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        zzin.zzaI("AdLoaderBackgroundTask started.");
        this.zzGf = new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzb.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzb.this.zzGg) {
                    if (zzb.this.zzHi == null) {
                        return;
                    }
                    zzb.this.onStop();
                    zzb.this.zzc(2, "Timed out waiting for ad response.");
                }
            }
        };
        zzir.zzMc.postDelayed(this.zzGf, zzbt.zzwX.get().longValue());
        final zzjj zzjjVar = new zzjj();
        long jElapsedRealtime = zzr.zzbG().elapsedRealtime();
        zziq.zza(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzb.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (zzb.this.zzGg) {
                    zzb.this.zzHi = zzb.this.zza(zzb.this.zzHh.zzrl, zzjjVar);
                    if (zzb.this.zzHi == null) {
                        zzb.this.zzc(0, "Could not start the ad request service.");
                        zzir.zzMc.removeCallbacks(zzb.this.zzGf);
                    }
                }
            }
        });
        this.zzCu = new AdRequestInfoParcel(this.zzHh, this.zzyt.zzab().zzb(this.mContext), jElapsedRealtime);
        zzjjVar.zzh(this.zzCu);
    }

    protected void zzgq() throws zza {
        if (this.zzGe.errorCode == -3) {
            return;
        }
        if (TextUtils.isEmpty(this.zzGe.body)) {
            throw new zza("No fill from ad server.", 3);
        }
        zzr.zzbF().zza(this.mContext, this.zzGe.zzHB);
        if (this.zzGe.zzHT) {
            try {
                this.zzCf = new zzeo(this.zzGe.body);
            } catch (JSONException e) {
                throw new zza("Could not parse mediation config: " + this.zzGe.body, 0);
            }
        }
    }
}
