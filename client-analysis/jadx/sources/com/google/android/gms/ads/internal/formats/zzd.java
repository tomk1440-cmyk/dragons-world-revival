package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzhb;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzd extends zzcl.zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzpV = new Object();
    private String zzxW;
    private List<zzc> zzxX;
    private String zzxY;
    private zzch zzxZ;
    private String zzya;
    private double zzyb;
    private String zzyc;
    private String zzyd;
    private zza zzye;
    private zzh zzyf;

    public zzd(String str, List list, String str2, zzch zzchVar, String str3, double d, String str4, String str5, zza zzaVar, Bundle bundle) {
        this.zzxW = str;
        this.zzxX = list;
        this.zzxY = str2;
        this.zzxZ = zzchVar;
        this.zzya = str3;
        this.zzyb = d;
        this.zzyc = str4;
        this.zzyd = str5;
        this.zzye = zzaVar;
        this.mExtras = bundle;
    }

    @Override // com.google.android.gms.internal.zzcl
    public void destroy() {
        this.zzxW = null;
        this.zzxX = null;
        this.zzxY = null;
        this.zzxZ = null;
        this.zzya = null;
        this.zzyb = 0.0d;
        this.zzyc = null;
        this.zzyd = null;
        this.zzye = null;
        this.mExtras = null;
        this.zzpV = null;
        this.zzyf = null;
    }

    @Override // com.google.android.gms.internal.zzcl
    public String getBody() {
        return this.zzxY;
    }

    @Override // com.google.android.gms.internal.zzcl
    public String getCallToAction() {
        return this.zzya;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzcl
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.zzcl
    public String getHeadline() {
        return this.zzxW;
    }

    @Override // com.google.android.gms.internal.zzcl
    public List getImages() {
        return this.zzxX;
    }

    @Override // com.google.android.gms.internal.zzcl
    public String getPrice() {
        return this.zzyd;
    }

    @Override // com.google.android.gms.internal.zzcl
    public double getStarRating() {
        return this.zzyb;
    }

    @Override // com.google.android.gms.internal.zzcl
    public String getStore() {
        return this.zzyc;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void zzb(zzh zzhVar) {
        synchronized (this.zzpV) {
            this.zzyf = zzhVar;
        }
    }

    @Override // com.google.android.gms.internal.zzcl
    public zzch zzdK() {
        return this.zzxZ;
    }

    @Override // com.google.android.gms.internal.zzcl
    public com.google.android.gms.dynamic.zzd zzdL() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzyf);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String zzdM() {
        return "2";
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza zzdN() {
        return this.zzye;
    }
}
