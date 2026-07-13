package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzcb {
    private String zzxB;
    private zzbz zzxC;
    private zzcb zzxD;
    boolean zzxi;
    private final List<zzbz> zzxz = new LinkedList();
    private final Map<String, String> zzxA = new LinkedHashMap();
    private final Object zzpV = new Object();

    public zzcb(boolean z, String str, String str2) {
        this.zzxi = z;
        this.zzxA.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        this.zzxA.put("ad_format", str2);
    }

    public void zzN(String str) {
        if (this.zzxi) {
            synchronized (this.zzpV) {
                this.zzxB = str;
            }
        }
    }

    public boolean zza(zzbz zzbzVar, long j, String... strArr) {
        synchronized (this.zzpV) {
            for (String str : strArr) {
                this.zzxz.add(new zzbz(j, str, zzbzVar));
            }
        }
        return true;
    }

    public boolean zza(zzbz zzbzVar, String... strArr) {
        if (!this.zzxi || zzbzVar == null) {
            return false;
        }
        return zza(zzbzVar, com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime(), strArr);
    }

    public zzbz zzb(long j) {
        if (this.zzxi) {
            return new zzbz(j, null, null);
        }
        return null;
    }

    public void zzc(zzcb zzcbVar) {
        synchronized (this.zzpV) {
            this.zzxD = zzcbVar;
        }
    }

    public void zzc(String str, String str2) {
        zzbv zzbvVarZzhb;
        if (!this.zzxi || TextUtils.isEmpty(str2) || (zzbvVarZzhb = com.google.android.gms.ads.internal.zzr.zzbF().zzhb()) == null) {
            return;
        }
        synchronized (this.zzpV) {
            zzbvVarZzhb.zzL(str).zza(this.zzxA, str, str2);
        }
    }

    public zzbz zzdB() {
        return zzb(com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime());
    }

    public void zzdC() {
        synchronized (this.zzpV) {
            this.zzxC = zzdB();
        }
    }

    public String zzdD() {
        String string;
        StringBuilder sb = new StringBuilder();
        synchronized (this.zzpV) {
            for (zzbz zzbzVar : this.zzxz) {
                long time = zzbzVar.getTime();
                String strZzdy = zzbzVar.zzdy();
                zzbz zzbzVarZzdz = zzbzVar.zzdz();
                if (zzbzVarZzdz != null && time > 0) {
                    sb.append(strZzdy).append('.').append(time - zzbzVarZzdz.getTime()).append(',');
                }
            }
            this.zzxz.clear();
            if (!TextUtils.isEmpty(this.zzxB)) {
                sb.append(this.zzxB);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            string = sb.toString();
        }
        return string;
    }

    public zzbz zzdE() {
        zzbz zzbzVar;
        synchronized (this.zzpV) {
            zzbzVar = this.zzxC;
        }
        return zzbzVar;
    }

    Map<String, String> zzn() {
        Map<String, String> mapZza;
        synchronized (this.zzpV) {
            zzbv zzbvVarZzhb = com.google.android.gms.ads.internal.zzr.zzbF().zzhb();
            mapZza = (zzbvVarZzhb == null || this.zzxD == null) ? this.zzxA : zzbvVarZzhb.zza(this.zzxA, this.zzxD.zzn());
        }
        return mapZza;
    }
}
