package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfr extends zzfs implements zzdf {
    private final Context mContext;
    DisplayMetrics zzDA;
    private float zzDB;
    int zzDC;
    int zzDD;
    private int zzDE;
    int zzDF;
    int zzDG;
    int zzDH;
    int zzDI;
    private final zzbl zzDz;
    private final zzjp zzpD;
    private final WindowManager zzsb;

    public zzfr(zzjp zzjpVar, Context context, zzbl zzblVar) {
        super(zzjpVar);
        this.zzDC = -1;
        this.zzDD = -1;
        this.zzDF = -1;
        this.zzDG = -1;
        this.zzDH = -1;
        this.zzDI = -1;
        this.zzpD = zzjpVar;
        this.mContext = context;
        this.zzDz = zzblVar;
        this.zzsb = (WindowManager) context.getSystemService("window");
    }

    private void zzeQ() {
        this.zzDA = new DisplayMetrics();
        Display defaultDisplay = this.zzsb.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzDA);
        this.zzDB = this.zzDA.density;
        this.zzDE = defaultDisplay.getRotation();
    }

    private void zzeV() {
        int[] iArr = new int[2];
        this.zzpD.getLocationOnScreen(iArr);
        zzf(com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, iArr[0]), com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, iArr[1]));
    }

    private zzfq zzeY() {
        return new zzfq.zza().zzr(this.zzDz.zzdj()).zzq(this.zzDz.zzdk()).zzs(this.zzDz.zzdo()).zzt(this.zzDz.zzdl()).zzu(this.zzDz.zzdm()).zzeP();
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        zzeT();
    }

    void zzeR() {
        this.zzDC = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, this.zzDA.widthPixels);
        this.zzDD = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, this.zzDA.heightPixels);
        Activity activityZzhP = this.zzpD.zzhP();
        if (activityZzhP == null || activityZzhP.getWindow() == null) {
            this.zzDF = this.zzDC;
            this.zzDG = this.zzDD;
        } else {
            int[] iArrZze = com.google.android.gms.ads.internal.zzr.zzbC().zze(activityZzhP);
            this.zzDF = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, iArrZze[0]);
            this.zzDG = com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(this.zzDA, iArrZze[1]);
        }
    }

    void zzeS() {
        if (this.zzpD.zzaN().zzui) {
            this.zzDH = this.zzDC;
            this.zzDI = this.zzDD;
        } else {
            this.zzpD.measure(0, 0);
            this.zzDH = com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, this.zzpD.getMeasuredWidth());
            this.zzDI = com.google.android.gms.ads.internal.client.zzn.zzcS().zzc(this.mContext, this.zzpD.getMeasuredHeight());
        }
    }

    public void zzeT() {
        zzeQ();
        zzeR();
        zzeS();
        zzeW();
        zzeX();
        zzeV();
        zzeU();
    }

    void zzeU() {
        if (zzin.zzQ(2)) {
            zzin.zzaJ("Dispatching Ready Event.");
        }
        zzan(this.zzpD.zzhX().afmaVersion);
    }

    void zzeW() {
        zza(this.zzDC, this.zzDD, this.zzDF, this.zzDG, this.zzDB, this.zzDE);
    }

    void zzeX() {
        this.zzpD.zzb("onDeviceFeaturesReceived", zzeY().toJson());
    }

    public void zzf(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? com.google.android.gms.ads.internal.zzr.zzbC().zzh((Activity) this.mContext)[0] : 0), this.zzDH, this.zzDI);
        this.zzpD.zzhU().zze(i, i2);
    }
}
