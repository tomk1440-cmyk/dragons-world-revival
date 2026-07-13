package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrv;
import com.google.android.gms.internal.zzrw;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
class zzcl implements Runnable {
    private final Context mContext;
    private final String zzbhM;
    private volatile String zzbij;
    private final zzrw zzbke;
    private final String zzbkf;
    private zzbf<com.google.android.gms.internal.zzaf.zzj> zzbkg;
    private volatile zzs zzbkh;
    private volatile String zzbki;

    zzcl(Context context, String str, zzrw zzrwVar, zzs zzsVar) {
        this.mContext = context;
        this.zzbke = zzrwVar;
        this.zzbhM = str;
        this.zzbkh = zzsVar;
        this.zzbkf = "/r?id=" + str;
        this.zzbij = this.zzbkf;
        this.zzbki = null;
    }

    public zzcl(Context context, String str, zzs zzsVar) {
        this(context, str, new zzrw(), zzsVar);
    }

    private boolean zzGX() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.v("...no network connectivity");
        return false;
    }

    private void zzGY() {
        if (!zzGX()) {
            this.zzbkg.zza(zzbf.zza.NOT_AVAILABLE);
            return;
        }
        zzbg.v("Start loading resource from network ...");
        String strZzGZ = zzGZ();
        zzrv zzrvVarZzIa = this.zzbke.zzIa();
        try {
            try {
                InputStream inputStreamZzgI = zzrvVarZzIa.zzgI(strZzGZ);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    zzrs.zzb(inputStreamZzgI, byteArrayOutputStream);
                    com.google.android.gms.internal.zzaf.zzj zzjVarZzd = com.google.android.gms.internal.zzaf.zzj.zzd(byteArrayOutputStream.toByteArray());
                    zzbg.v("Successfully loaded supplemented resource: " + zzjVarZzd);
                    if (zzjVarZzd.zzju == null && zzjVarZzd.zzjt.length == 0) {
                        zzbg.v("No change for container: " + this.zzbhM);
                    }
                    this.zzbkg.zzI(zzjVarZzd);
                    zzrvVarZzIa.close();
                    zzbg.v("Load resource from network finished.");
                } catch (IOException e) {
                    zzbg.zzd("Error when parsing downloaded resources from url: " + strZzGZ + " " + e.getMessage(), e);
                    this.zzbkg.zza(zzbf.zza.SERVER_ERROR);
                    zzrvVarZzIa.close();
                }
            } catch (FileNotFoundException e2) {
                zzbg.zzaK("No data is retrieved from the given url: " + strZzGZ + ". Make sure container_id: " + this.zzbhM + " is correct.");
                this.zzbkg.zza(zzbf.zza.SERVER_ERROR);
                zzrvVarZzIa.close();
            } catch (IOException e3) {
                zzbg.zzd("Error when loading resources from url: " + strZzGZ + " " + e3.getMessage(), e3);
                this.zzbkg.zza(zzbf.zza.IO_ERROR);
                zzrvVarZzIa.close();
            }
        } catch (Throwable th) {
            zzrvVarZzIa.close();
            throw th;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.zzbkg == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.zzbkg.zzGk();
        zzGY();
    }

    String zzGZ() {
        String str = this.zzbkh.zzGm() + this.zzbij + "&v=a65833898";
        if (this.zzbki != null && !this.zzbki.trim().equals("")) {
            str = str + "&pv=" + this.zzbki;
        }
        return zzcb.zzGU().zzGV().equals(zzcb.zza.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    void zza(zzbf<com.google.android.gms.internal.zzaf.zzj> zzbfVar) {
        this.zzbkg = zzbfVar;
    }

    void zzfW(String str) {
        if (str == null) {
            this.zzbij = this.zzbkf;
        } else {
            zzbg.zzaI("Setting CTFE URL path: " + str);
            this.zzbij = str;
        }
    }

    void zzgl(String str) {
        zzbg.zzaI("Setting previous container version: " + str);
        this.zzbki = str;
    }
}
