package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzhd extends com.google.android.gms.ads.internal.request.zzj.zza {
    private static zzhd zzIQ;
    private static final Object zzqy = new Object();
    private final Context mContext;
    private final zzhc zzIR;
    private final zzbm zzIS;
    private final zzeg zzIT;

    zzhd(Context context, zzbm zzbmVar, zzhc zzhcVar) {
        this.mContext = context;
        this.zzIR = zzhcVar;
        this.zzIS = zzbmVar;
        this.zzIT = new zzeg(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(8487000, 8487000, true), zzbmVar.zzdp(), new zzeg.zzb<zzed>() { // from class: com.google.android.gms.internal.zzhd.6
            @Override // com.google.android.gms.internal.zzeg.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zze(zzed zzedVar) {
                zzedVar.zza("/log", zzde.zzzf);
            }
        }, new zzeg.zzc());
    }

    private static AdResponseParcel zza(final Context context, final zzeg zzegVar, final zzbm zzbmVar, final zzhc zzhcVar, final AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        zzjg zzjgVarZza;
        String string;
        zzin.zzaI("Starting ad request from service.");
        zzbt.initialize(context);
        final zzcb zzcbVar = new zzcb(zzbt.zzwg.get().booleanValue(), "load_ad", adRequestInfoParcel.zzrp.zzuh);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzHL != -1) {
            zzcbVar.zza(zzcbVar.zzb(adRequestInfoParcel.zzHL), "cts");
        }
        zzbz zzbzVarZzdB = zzcbVar.zzdB();
        final Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzHA == null) ? null : adRequestInfoParcel.zzHA;
        if (!zzbt.zzwp.get().booleanValue() || zzhcVar.zzIP == null) {
            bundle = bundle2;
            zzjgVarZza = null;
        } else {
            if (bundle2 == null && zzbt.zzwq.get().booleanValue()) {
                zzin.v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                bundle = bundle2;
                zzjgVarZza = zziq.zza(new Callable<Void>() { // from class: com.google.android.gms.internal.zzhd.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zzdt, reason: merged with bridge method [inline-methods] */
                    public Void call() throws Exception {
                        zzhcVar.zzIP.zza(context, adRequestInfoParcel.zzHu.packageName, bundle2);
                        return null;
                    }
                });
            } else {
                bundle = bundle2;
                zzjgVarZza = null;
            }
        }
        zzhcVar.zzIK.zzex();
        zzhj zzhjVarZzE = com.google.android.gms.ads.internal.zzr.zzbI().zzE(context);
        if (zzhjVarZzE.zzKc == -1) {
            zzin.zzaI("Device is offline.");
            return new AdResponseParcel(2);
        }
        String string2 = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzHI : UUID.randomUUID().toString();
        final zzhf zzhfVar = new zzhf(string2, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzHt.extras != null && (string = adRequestInfoParcel.zzHt.extras.getString("_ad")) != null) {
            return zzhe.zza(context, adRequestInfoParcel, string);
        }
        Location locationZzd = zzhcVar.zzIK.zzd(250L);
        String token = zzhcVar.zzIL.getToken(context, adRequestInfoParcel.zzrj, adRequestInfoParcel.zzHu.packageName);
        List<String> listZza = zzhcVar.zzII.zza(adRequestInfoParcel);
        String strZzf = zzhcVar.zzIM.zzf(adRequestInfoParcel);
        zzhn.zza zzaVarZzF = zzhcVar.zzIN.zzF(context);
        if (zzjgVarZza != null) {
            try {
                zzin.v("Waiting for app index fetching task.");
                zzjgVarZza.get(zzbt.zzwr.get().longValue(), TimeUnit.MILLISECONDS);
                zzin.v("App index fetching task completed.");
            } catch (InterruptedException e) {
                e = e;
                zzin.zzd("Failed to fetch app index signal", e);
            } catch (ExecutionException e2) {
                e = e2;
                zzin.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e3) {
                zzin.zzaI("Timed out waiting for app index fetching task");
            }
        }
        JSONObject jSONObjectZza = zzhe.zza(context, adRequestInfoParcel, zzhjVarZzE, zzaVarZzF, locationZzd, zzbmVar, token, strZzf, listZza, bundle);
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                jSONObjectZza.put("request_id", string2);
            } catch (JSONException e4) {
            }
        }
        if (jSONObjectZza == null) {
            return new AdResponseParcel(0);
        }
        final String string3 = jSONObjectZza.toString();
        zzcbVar.zza(zzbzVarZzdB, "arc");
        final zzbz zzbzVarZzdB2 = zzcbVar.zzdB();
        if (zzbt.zzvC.get().booleanValue()) {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzhd.2
                @Override // java.lang.Runnable
                public void run() {
                    zzeg.zzd zzdVarZzer = zzegVar.zzer();
                    zzhfVar.zzb(zzdVarZzer);
                    zzcbVar.zza(zzbzVarZzdB2, "rwc");
                    final zzbz zzbzVarZzdB3 = zzcbVar.zzdB();
                    zzdVarZzer.zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.internal.zzhd.2.1
                        @Override // com.google.android.gms.internal.zzji.zzc
                        /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
                        public void zze(zzeh zzehVar) {
                            zzcbVar.zza(zzbzVarZzdB3, "jsf");
                            zzcbVar.zzdC();
                            zzehVar.zza("/invalidRequest", zzhfVar.zzJk);
                            zzehVar.zza("/loadAdURL", zzhfVar.zzJl);
                            try {
                                zzehVar.zze("AFMA_buildAdURL", string3);
                            } catch (Exception e5) {
                                zzin.zzb("Error requesting an ad url", e5);
                            }
                        }
                    }, new zzji.zza() { // from class: com.google.android.gms.internal.zzhd.2.2
                        @Override // com.google.android.gms.internal.zzji.zza
                        public void run() {
                        }
                    });
                }
            });
        } else {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzhd.3
                @Override // java.lang.Runnable
                public void run() {
                    zzjp zzjpVarZza = com.google.android.gms.ads.internal.zzr.zzbD().zza(context, new AdSizeParcel(), false, false, null, adRequestInfoParcel.zzrl);
                    if (com.google.android.gms.ads.internal.zzr.zzbF().zzhi()) {
                        zzjpVarZza.clearCache(true);
                    }
                    zzjpVarZza.getWebView().setWillNotDraw(true);
                    zzhfVar.zzh(zzjpVarZza);
                    zzcbVar.zza(zzbzVarZzdB2, "rwc");
                    zzjq.zza zzaVarZza = zzhd.zza(string3, zzcbVar, zzcbVar.zzdB());
                    zzjq zzjqVarZzhU = zzjpVarZza.zzhU();
                    zzjqVarZzhU.zza("/invalidRequest", zzhfVar.zzJk);
                    zzjqVarZzhU.zza("/loadAdURL", zzhfVar.zzJl);
                    zzjqVarZzhU.zza("/log", zzde.zzzf);
                    zzjqVarZzhU.zza(zzaVarZza);
                    zzin.zzaI("Loading the JS library.");
                    zzjpVarZza.loadUrl(zzbmVar.zzdp());
                }
            });
        }
        try {
            zzhi zzhiVar = zzhfVar.zzgC().get(10L, TimeUnit.SECONDS);
            if (zzhiVar == null) {
                return new AdResponseParcel(0);
            }
            if (zzhiVar.getErrorCode() != -2) {
                return new AdResponseParcel(zzhiVar.getErrorCode());
            }
            if (zzcbVar.zzdE() != null) {
                zzcbVar.zza(zzcbVar.zzdE(), "rur");
            }
            AdResponseParcel adResponseParcelZza = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzrl.afmaVersion, zzhiVar.getUrl(), zzhiVar.zzgG() ? zzhcVar.zzIH.zzaz(adRequestInfoParcel.zzHu.packageName) : null, zzhiVar.zzgH() ? token : null, zzhiVar, zzcbVar, zzhcVar);
            if (adResponseParcelZza.zzIf == 1) {
                zzhcVar.zzIL.clearToken(context, adRequestInfoParcel.zzHu.packageName);
            }
            zzcbVar.zza(zzbzVarZzdB, "tts");
            adResponseParcelZza.zzIh = zzcbVar.zzdD();
            return adResponseParcelZza;
        } catch (Exception e5) {
            return new AdResponseParcel(0);
        } finally {
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.internal.zzhd.4
                @Override // java.lang.Runnable
                public void run() {
                    zzhcVar.zzIJ.zza(context, zzhfVar, adRequestInfoParcel.zzrl);
                }
            });
        }
    }

    public static AdResponseParcel zza(AdRequestInfoParcel adRequestInfoParcel, Context context, String str, String str2, String str3, String str4, zzhi zzhiVar, zzcb zzcbVar, zzhc zzhcVar) {
        InputStreamReader inputStreamReader;
        BufferedOutputStream bufferedOutputStream;
        zzbz zzbzVarZzdB = zzcbVar != null ? zzcbVar.zzdB() : null;
        try {
            zzhg zzhgVar = new zzhg(adRequestInfoParcel);
            zzin.zzaI("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzr.zzbG().elapsedRealtime();
            int i = 0;
            URL url2 = url;
            while (true) {
                if (zzhcVar != null) {
                    zzhcVar.zzIO.zzgJ();
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    com.google.android.gms.ads.internal.zzr.zzbC().zza(context, str, false, httpURLConnection);
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        httpURLConnection.addRequestProperty(HttpRequest.HEADER_AUTHORIZATION, "Bearer " + str4);
                    }
                    if (zzhiVar != null && !TextUtils.isEmpty(zzhiVar.zzgF())) {
                        httpURLConnection.setDoOutput(true);
                        byte[] bytes = zzhiVar.zzgF().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                            try {
                                bufferedOutputStream.write(bytes);
                                zzna.zzb(bufferedOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                zzna.zzb(bufferedOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = null;
                        }
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (responseCode < 200 || responseCode >= 300) {
                        zza(url2.toString(), headerFields, null, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzin.zzaK("Received error HTTP response code: " + responseCode);
                            AdResponseParcel adResponseParcel = new AdResponseParcel(0);
                            httpURLConnection.disconnect();
                            if (zzhcVar != null) {
                                zzhcVar.zzIO.zzgK();
                            }
                            return adResponseParcel;
                        }
                        String headerField = httpURLConnection.getHeaderField(HttpRequest.HEADER_LOCATION);
                        if (TextUtils.isEmpty(headerField)) {
                            zzin.zzaK("No location header to follow redirect.");
                            AdResponseParcel adResponseParcel2 = new AdResponseParcel(0);
                            httpURLConnection.disconnect();
                            if (zzhcVar != null) {
                                zzhcVar.zzIO.zzgK();
                            }
                            return adResponseParcel2;
                        }
                        URL url3 = new URL(headerField);
                        int i2 = i + 1;
                        if (i2 > 5) {
                            zzin.zzaK("Too many redirects.");
                            AdResponseParcel adResponseParcel3 = new AdResponseParcel(0);
                            httpURLConnection.disconnect();
                            if (zzhcVar != null) {
                                zzhcVar.zzIO.zzgK();
                            }
                            return adResponseParcel3;
                        }
                        zzhgVar.zzj(headerFields);
                        httpURLConnection.disconnect();
                        if (zzhcVar != null) {
                            zzhcVar.zzIO.zzgK();
                        }
                        i = i2;
                        url2 = url3;
                    } else {
                        String string = url2.toString();
                        try {
                            inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                            try {
                                String strZza = com.google.android.gms.ads.internal.zzr.zzbC().zza(inputStreamReader);
                                zzna.zzb(inputStreamReader);
                                zza(string, headerFields, strZza, responseCode);
                                zzhgVar.zzb(string, headerFields, strZza);
                                if (zzcbVar != null) {
                                    zzcbVar.zza(zzbzVarZzdB, "ufe");
                                }
                                AdResponseParcel adResponseParcelZzj = zzhgVar.zzj(jElapsedRealtime);
                                httpURLConnection.disconnect();
                                if (zzhcVar != null) {
                                    zzhcVar.zzIO.zzgK();
                                }
                                return adResponseParcelZzj;
                            } catch (Throwable th3) {
                                th = th3;
                                zzna.zzb(inputStreamReader);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            inputStreamReader = null;
                        }
                    }
                } catch (Throwable th5) {
                    httpURLConnection.disconnect();
                    if (zzhcVar != null) {
                        zzhcVar.zzIO.zzgK();
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            zzin.zzaK("Error while connecting to ad server: " + e.getMessage());
            return new AdResponseParcel(2);
        }
    }

    public static zzhd zza(Context context, zzbm zzbmVar, zzhc zzhcVar) {
        zzhd zzhdVar;
        synchronized (zzqy) {
            if (zzIQ == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzIQ = new zzhd(context, zzbmVar, zzhcVar);
            }
            zzhdVar = zzIQ;
        }
        return zzhdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzjq.zza zza(final String str, final zzcb zzcbVar, final zzbz zzbzVar) {
        return new zzjq.zza() { // from class: com.google.android.gms.internal.zzhd.5
            @Override // com.google.android.gms.internal.zzjq.zza
            public void zza(zzjp zzjpVar, boolean z) {
                zzcbVar.zza(zzbzVar, "jsf");
                zzcbVar.zzdC();
                zzjpVar.zze("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzin.zzQ(2)) {
            zzin.v("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    zzin.v("    " + str3 + ":");
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        zzin.v("      " + it.next());
                    }
                }
            }
            zzin.v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    zzin.v(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                zzin.v("    null");
            }
            zzin.v("  Response Code:\n    " + i + "\n}");
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzj
    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final com.google.android.gms.ads.internal.request.zzk zzkVar) {
        com.google.android.gms.ads.internal.zzr.zzbF().zzb(this.mContext, adRequestInfoParcel.zzrl);
        zziq.zza(new Runnable() { // from class: com.google.android.gms.internal.zzhd.7
            @Override // java.lang.Runnable
            public void run() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzhd.this.zzd(adRequestInfoParcel);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzr.zzbF().zzb((Throwable) e, true);
                    zzin.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzkVar.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzin.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.request.zzj
    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzIT, this.zzIS, this.zzIR, adRequestInfoParcel);
    }
}
