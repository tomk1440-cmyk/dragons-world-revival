package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcn;
import com.google.android.gms.internal.zzhb;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zze extends zzcn.zza implements zzh.zza {
    private Bundle mExtras;
    private Object zzpV = new Object();
    private String zzxW;
    private List<zzc> zzxX;
    private String zzxY;
    private String zzya;
    private zza zzye;
    private zzh zzyf;
    private zzch zzyg;
    private String zzyh;

    public zze(String str, List list, String str2, zzch zzchVar, String str3, String str4, zza zzaVar, Bundle bundle) {
        this.zzxW = str;
        this.zzxX = list;
        this.zzxY = str2;
        this.zzyg = zzchVar;
        this.zzya = str3;
        this.zzyh = str4;
        this.zzye = zzaVar;
        this.mExtras = bundle;
    }

    @Override // com.google.android.gms.internal.zzcn
    public void destroy() {
        this.zzxW = null;
        this.zzxX = null;
        this.zzxY = null;
        this.zzyg = null;
        this.zzya = null;
        this.zzyh = null;
        this.zzye = null;
        this.mExtras = null;
        this.zzpV = null;
        this.zzyf = null;
    }

    @Override // com.google.android.gms.internal.zzcn
    public String getAdvertiser() {
        return this.zzyh;
    }

    @Override // com.google.android.gms.internal.zzcn
    public String getBody() {
        return this.zzxY;
    }

    @Override // com.google.android.gms.internal.zzcn
    public String getCallToAction() {
        return this.zzya;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String getCustomTemplateId() {
        return "";
    }

    @Override // com.google.android.gms.internal.zzcn
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.internal.zzcn
    public String getHeadline() {
        return this.zzxW;
    }

    @Override // com.google.android.gms.internal.zzcn
    public List getImages() {
        return this.zzxX;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public void zzb(zzh zzhVar) {
        synchronized (this.zzpV) {
            this.zzyf = zzhVar;
        }
    }

    @Override // com.google.android.gms.internal.zzcn
    public com.google.android.gms.dynamic.zzd zzdL() {
        return com.google.android.gms.dynamic.zze.zzC(this.zzyf);
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public String zzdM() {
        return AppEventsConstants.EVENT_PARAM_VALUE_YES;
    }

    @Override // com.google.android.gms.ads.internal.formats.zzh.zza
    public zza zzdN() {
        return this.zzye;
    }

    @Override // com.google.android.gms.internal.zzcn
    public zzch zzdO() {
        return this.zzyg;
    }
}
