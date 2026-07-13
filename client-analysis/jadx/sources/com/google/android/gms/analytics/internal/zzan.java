package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class zzan extends zzd {
    protected boolean zzPi;
    protected int zzRB;
    protected String zzSE;
    protected String zzSF;
    protected int zzSH;
    protected boolean zzTv;
    protected boolean zzTw;
    protected boolean zzTx;

    public zzan(zzf zzfVar) {
        super(zzfVar);
    }

    private static int zzby(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return "error".equals(lowerCase) ? 3 : -1;
    }

    public int getLogLevel() {
        zzjv();
        return this.zzRB;
    }

    void zza(zzaa zzaaVar) {
        int iZzby;
        zzbd("Loading global XML config values");
        if (zzaaVar.zzlf()) {
            String strZzlg = zzaaVar.zzlg();
            this.zzSE = strZzlg;
            zzb("XML config - app name", strZzlg);
        }
        if (zzaaVar.zzlh()) {
            String strZzli = zzaaVar.zzli();
            this.zzSF = strZzli;
            zzb("XML config - app version", strZzli);
        }
        if (zzaaVar.zzlj() && (iZzby = zzby(zzaaVar.zzlk())) >= 0) {
            this.zzRB = iZzby;
            zza("XML config - log level", Integer.valueOf(iZzby));
        }
        if (zzaaVar.zzll()) {
            int iZzlm = zzaaVar.zzlm();
            this.zzSH = iZzlm;
            this.zzTw = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(iZzlm));
        }
        if (zzaaVar.zzln()) {
            boolean zZzlo = zzaaVar.zzlo();
            this.zzPi = zZzlo;
            this.zzTx = true;
            zzb("XML config - dry run", Boolean.valueOf(zZzlo));
        }
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        zzmd();
    }

    public String zzlg() {
        zzjv();
        return this.zzSE;
    }

    public String zzli() {
        zzjv();
        return this.zzSF;
    }

    public boolean zzlj() {
        zzjv();
        return this.zzTv;
    }

    public boolean zzll() {
        zzjv();
        return this.zzTw;
    }

    public boolean zzln() {
        zzjv();
        return this.zzTx;
    }

    public boolean zzlo() {
        zzjv();
        return this.zzPi;
    }

    public int zzmc() {
        zzjv();
        return this.zzSH;
    }

    protected void zzmd() {
        ApplicationInfo applicationInfo;
        int i;
        zzaa zzaaVarZzah;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (PackageManager.NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzbg("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle == null || (i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource")) <= 0 || (zzaaVarZzah = new zzz(zzji()).zzah(i)) == null) {
            return;
        }
        zza(zzaaVarZzah);
    }
}
