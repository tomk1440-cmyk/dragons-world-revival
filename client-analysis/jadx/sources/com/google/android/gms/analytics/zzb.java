package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzkc;
import com.google.android.gms.internal.zzkd;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpt;
import com.google.android.gms.internal.zzpu;
import com.google.android.gms.internal.zzpv;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.internal.zzpx;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.measurement.zzi;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzb extends com.google.android.gms.analytics.internal.zzc implements zzi {
    private static DecimalFormat zzOU;
    private final zzf zzOK;
    private final String zzOV;
    private final Uri zzOW;
    private final boolean zzOX;
    private final boolean zzOY;

    public zzb(zzf zzfVar, String str) {
        this(zzfVar, str, true, false);
    }

    public zzb(zzf zzfVar, String str, boolean z, boolean z2) {
        super(zzfVar);
        zzx.zzcM(str);
        this.zzOK = zzfVar;
        this.zzOV = str;
        this.zzOX = z;
        this.zzOY = z2;
        this.zzOW = zzaU(this.zzOV);
    }

    private static String zzH(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zzb(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        map.put(str, i + "x" + i2);
    }

    private static void zza(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }

    static Uri zzaU(String str) {
        zzx.zzcM(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String zzb(double d) {
        if (zzOU == null) {
            zzOU = new DecimalFormat("0.######");
        }
        return zzOU.format(d);
    }

    private static void zzb(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public static Map<String, String> zzc(com.google.android.gms.measurement.zzc zzcVar) {
        HashMap map = new HashMap();
        zzkd zzkdVar = (zzkd) zzcVar.zze(zzkd.class);
        if (zzkdVar != null) {
            for (Map.Entry<String, Object> entry : zzkdVar.zziR().entrySet()) {
                String strZzi = zzi(entry.getValue());
                if (strZzi != null) {
                    map.put(entry.getKey(), strZzi);
                }
            }
        }
        zzke zzkeVar = (zzke) zzcVar.zze(zzke.class);
        if (zzkeVar != null) {
            zzb(map, "t", zzkeVar.zziS());
            zzb(map, "cid", zzkeVar.getClientId());
            zzb(map, "uid", zzkeVar.getUserId());
            zzb(map, "sc", zzkeVar.zziV());
            zza(map, "sf", zzkeVar.zziX());
            zza(map, "ni", zzkeVar.zziW());
            zzb(map, "adid", zzkeVar.zziT());
            zza(map, "ate", zzkeVar.zziU());
        }
        zzpw zzpwVar = (zzpw) zzcVar.zze(zzpw.class);
        if (zzpwVar != null) {
            zzb(map, "cd", zzpwVar.zzBc());
            zza(map, "a", zzpwVar.zzBd());
            zzb(map, "dr", zzpwVar.zzBe());
        }
        zzpu zzpuVar = (zzpu) zzcVar.zze(zzpu.class);
        if (zzpuVar != null) {
            zzb(map, "ec", zzpuVar.zzAZ());
            zzb(map, "ea", zzpuVar.getAction());
            zzb(map, "el", zzpuVar.getLabel());
            zza(map, "ev", zzpuVar.getValue());
        }
        zzpr zzprVar = (zzpr) zzcVar.zze(zzpr.class);
        if (zzprVar != null) {
            zzb(map, "cn", zzprVar.getName());
            zzb(map, "cs", zzprVar.getSource());
            zzb(map, "cm", zzprVar.zzAK());
            zzb(map, "ck", zzprVar.zzAL());
            zzb(map, "cc", zzprVar.getContent());
            zzb(map, "ci", zzprVar.getId());
            zzb(map, "anid", zzprVar.zzAM());
            zzb(map, "gclid", zzprVar.zzAN());
            zzb(map, "dclid", zzprVar.zzAO());
            zzb(map, "aclid", zzprVar.zzAP());
        }
        zzpv zzpvVar = (zzpv) zzcVar.zze(zzpv.class);
        if (zzpvVar != null) {
            zzb(map, "exd", zzpvVar.getDescription());
            zza(map, "exf", zzpvVar.zzBa());
        }
        zzpx zzpxVar = (zzpx) zzcVar.zze(zzpx.class);
        if (zzpxVar != null) {
            zzb(map, "sn", zzpxVar.zzBg());
            zzb(map, "sa", zzpxVar.getAction());
            zzb(map, "st", zzpxVar.getTarget());
        }
        zzpy zzpyVar = (zzpy) zzcVar.zze(zzpy.class);
        if (zzpyVar != null) {
            zzb(map, "utv", zzpyVar.zzBh());
            zza(map, "utt", zzpyVar.getTimeInMillis());
            zzb(map, "utc", zzpyVar.zzAZ());
            zzb(map, "utl", zzpyVar.getLabel());
        }
        zzkb zzkbVar = (zzkb) zzcVar.zze(zzkb.class);
        if (zzkbVar != null) {
            for (Map.Entry<Integer, String> entry2 : zzkbVar.zziP().entrySet()) {
                String strZzU = zzc.zzU(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(strZzU)) {
                    map.put(strZzU, entry2.getValue());
                }
            }
        }
        zzkc zzkcVar = (zzkc) zzcVar.zze(zzkc.class);
        if (zzkcVar != null) {
            for (Map.Entry<Integer, Double> entry3 : zzkcVar.zziQ().entrySet()) {
                String strZzW = zzc.zzW(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(strZzW)) {
                    map.put(strZzW, zzb(entry3.getValue().doubleValue()));
                }
            }
        }
        zzpt zzptVar = (zzpt) zzcVar.zze(zzpt.class);
        if (zzptVar != null) {
            ProductAction productActionZzAV = zzptVar.zzAV();
            if (productActionZzAV != null) {
                for (Map.Entry<String, String> entry4 : productActionZzAV.build().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        map.put(entry4.getKey().substring(1), entry4.getValue());
                    } else {
                        map.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            Iterator<Promotion> it = zzptVar.zzAY().iterator();
            int i = 1;
            while (it.hasNext()) {
                map.putAll(it.next().zzba(zzc.zzaa(i)));
                i++;
            }
            Iterator<Product> it2 = zzptVar.zzAW().iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                map.putAll(it2.next().zzba(zzc.zzY(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry5 : zzptVar.zzAX().entrySet()) {
                List<Product> value = entry5.getValue();
                String strZzad = zzc.zzad(i3);
                Iterator<Product> it3 = value.iterator();
                int i4 = 1;
                while (it3.hasNext()) {
                    map.putAll(it3.next().zzba(strZzad + zzc.zzab(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    map.put(strZzad + "nm", entry5.getKey());
                }
                i3++;
            }
        }
        zzps zzpsVar = (zzps) zzcVar.zze(zzps.class);
        if (zzpsVar != null) {
            zzb(map, "ul", zzpsVar.getLanguage());
            zza(map, "sd", zzpsVar.zzAQ());
            zza(map, "sr", zzpsVar.zzAR(), zzpsVar.zzAS());
            zza(map, "vp", zzpsVar.zzAT(), zzpsVar.zzAU());
        }
        zzpq zzpqVar = (zzpq) zzcVar.zze(zzpq.class);
        if (zzpqVar != null) {
            zzb(map, "an", zzpqVar.zzlg());
            zzb(map, "aid", zzpqVar.zzwK());
            zzb(map, "aiid", zzpqVar.zzAJ());
            zzb(map, "av", zzpqVar.zzli());
        }
        return map;
    }

    private static String zzi(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.doubleValue() != 0.0d) {
                return zzb(d.doubleValue());
            }
            return null;
        }
        if (!(obj instanceof Boolean)) {
            return String.valueOf(obj);
        }
        if (obj != Boolean.FALSE) {
            return AppEventsConstants.EVENT_PARAM_VALUE_YES;
        }
        return null;
    }

    @Override // com.google.android.gms.measurement.zzi
    public void zzb(com.google.android.gms.measurement.zzc zzcVar) {
        zzx.zzz(zzcVar);
        zzx.zzb(zzcVar.zzAz(), "Can't deliver not submitted measurement");
        zzx.zzcE("deliver should be called on worker thread");
        com.google.android.gms.measurement.zzc zzcVarZzAu = zzcVar.zzAu();
        zzke zzkeVar = (zzke) zzcVarZzAu.zzf(zzke.class);
        if (TextUtils.isEmpty(zzkeVar.zziS())) {
            zzjm().zzh(zzc(zzcVarZzAu), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(zzkeVar.getClientId())) {
            zzjm().zzh(zzc(zzcVarZzAu), "Ignoring measurement without client id");
            return;
        }
        if (this.zzOK.zzjz().getAppOptOut()) {
            return;
        }
        double dZziX = zzkeVar.zziX();
        if (zzam.zza(dZziX, zzkeVar.getClientId())) {
            zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(dZziX));
            return;
        }
        Map<String, String> mapZzc = zzc(zzcVarZzAu);
        mapZzc.put("v", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        mapZzc.put("_v", zze.zzQm);
        mapZzc.put("tid", this.zzOV);
        if (this.zzOK.zzjz().isDryRunEnabled()) {
            zzc("Dry run is enabled. GoogleAnalytics would have sent", zzH(mapZzc));
            return;
        }
        HashMap map = new HashMap();
        zzam.zzc(map, "uid", zzkeVar.getUserId());
        zzpq zzpqVar = (zzpq) zzcVar.zze(zzpq.class);
        if (zzpqVar != null) {
            zzam.zzc(map, "an", zzpqVar.zzlg());
            zzam.zzc(map, "aid", zzpqVar.zzwK());
            zzam.zzc(map, "av", zzpqVar.zzli());
            zzam.zzc(map, "aiid", zzpqVar.zzAJ());
        }
        mapZzc.put("_s", String.valueOf(zziH().zza(new zzh(0L, zzkeVar.getClientId(), this.zzOV, !TextUtils.isEmpty(zzkeVar.zziT()), 0L, map))));
        zziH().zza(new zzab(zzjm(), mapZzc, zzcVar.zzAx(), true));
    }

    @Override // com.google.android.gms.measurement.zzi
    public Uri zziA() {
        return this.zzOW;
    }
}
