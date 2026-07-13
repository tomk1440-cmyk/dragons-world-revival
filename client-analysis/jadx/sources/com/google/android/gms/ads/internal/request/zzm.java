package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzbm;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzed;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhe;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzjp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzm extends zzim {
    private final Context mContext;
    private final Object zzGg;
    private final com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza zzHg;
    private final AdRequestInfoParcel.zza zzHh;
    private zzeg.zzd zzIC;
    static final long zzIw = TimeUnit.SECONDS.toMillis(10);
    private static final Object zzqy = new Object();
    private static boolean zzIx = false;
    private static zzeg zzIy = null;
    private static zzdg zzIz = null;
    private static zzdk zzIA = null;
    private static zzdf zzIB = null;

    public static class zza implements zzeg.zzb<zzed> {
        @Override // com.google.android.gms.internal.zzeg.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zze(zzed zzedVar) {
            zzm.zzd(zzedVar);
        }
    }

    public static class zzb implements zzeg.zzb<zzed> {
        @Override // com.google.android.gms.internal.zzeg.zzb
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void zze(zzed zzedVar) {
            zzm.zzc(zzedVar);
        }
    }

    public static class zzc implements zzdf {
        @Override // com.google.android.gms.internal.zzdf
        public void zza(zzjp zzjpVar, Map<String, String> map) {
            String str = map.get("request_id");
            zzin.zzaK("Invalid request: " + map.get("errors"));
            zzm.zzIA.zzS(str);
        }
    }

    public zzm(Context context, AdRequestInfoParcel.zza zzaVar, com.google.android.gms.ads.internal.request.zza.InterfaceC0027zza interfaceC0027zza) {
        super(true);
        this.zzGg = new Object();
        this.zzHg = interfaceC0027zza;
        this.mContext = context;
        this.zzHh = zzaVar;
        synchronized (zzqy) {
            if (!zzIx) {
                zzIA = new zzdk();
                zzIz = new zzdg(context.getApplicationContext(), zzaVar.zzrl);
                zzIB = new zzc();
                zzIy = new zzeg(this.mContext.getApplicationContext(), this.zzHh.zzrl, zzbt.zzvB.get(), new zzb(), new zza());
                zzIx = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject jSONObjectZza;
        AdvertisingIdClient.Info advertisingIdInfo;
        Bundle bundle = adRequestInfoParcel.zzHt.extras.getBundle("sdk_less_server_data");
        String string = adRequestInfoParcel.zzHt.extras.getString("sdk_less_network_id");
        if (bundle == null || (jSONObjectZza = zzhe.zza(this.mContext, adRequestInfoParcel, zzr.zzbI().zzE(this.mContext), null, null, new zzbm(zzbt.zzvB.get()), null, null, new ArrayList(), null)) == null) {
            return null;
        }
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzin.zzd("Cannot get advertising id info", e);
            advertisingIdInfo = null;
        }
        HashMap map = new HashMap();
        map.put("request_id", str);
        map.put("network_id", string);
        map.put("request_param", jSONObjectZza);
        map.put(ShareConstants.WEB_DIALOG_PARAM_DATA, bundle);
        if (advertisingIdInfo != null) {
            map.put("adid", advertisingIdInfo.getId());
            map.put("lat", Integer.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzr.zzbC().zzG(map);
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static void zzc(zzed zzedVar) {
        zzedVar.zza("/loadAd", zzIA);
        zzedVar.zza("/fetchHttpRequest", zzIz);
        zzedVar.zza("/invalidRequest", zzIB);
    }

    protected static void zzd(zzed zzedVar) {
        zzedVar.zzb("/loadAd", zzIA);
        zzedVar.zzb("/fetchHttpRequest", zzIz);
        zzedVar.zzb("/invalidRequest", zzIB);
    }

    private AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        final String string = UUID.randomUUID().toString();
        final JSONObject jSONObjectZza = zza(adRequestInfoParcel, string);
        if (jSONObjectZza == null) {
            return new AdResponseParcel(0);
        }
        long jElapsedRealtime = zzr.zzbG().elapsedRealtime();
        Future<JSONObject> futureZzR = zzIA.zzR(string);
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzm.2
            @Override // java.lang.Runnable
            public void run() {
                zzm.this.zzIC = zzm.zzIy.zzer();
                zzm.this.zzIC.zza(new zzji.zzc<zzeh>() { // from class: com.google.android.gms.ads.internal.request.zzm.2.1
                    @Override // com.google.android.gms.internal.zzji.zzc
                    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
                    public void zze(zzeh zzehVar) {
                        try {
                            zzehVar.zza("AFMA_getAdapterLessMediationAd", jSONObjectZza);
                        } catch (Exception e) {
                            zzin.zzb("Error requesting an ad url", e);
                            zzm.zzIA.zzS(string);
                        }
                    }
                }, new zzji.zza() { // from class: com.google.android.gms.ads.internal.request.zzm.2.2
                    @Override // com.google.android.gms.internal.zzji.zza
                    public void run() {
                        zzm.zzIA.zzS(string);
                    }
                });
            }
        });
        try {
            JSONObject jSONObject = futureZzR.get(zzIw - (zzr.zzbG().elapsedRealtime() - jElapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel adResponseParcelZza = zzhe.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (adResponseParcelZza.errorCode == -3 || !TextUtils.isEmpty(adResponseParcelZza.body)) ? adResponseParcelZza : new AdResponseParcel(3);
        } catch (InterruptedException e) {
            return new AdResponseParcel(-1);
        } catch (CancellationException e2) {
            return new AdResponseParcel(-1);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        } catch (TimeoutException e4) {
            return new AdResponseParcel(2);
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
        synchronized (this.zzGg) {
            com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzm.3
                @Override // java.lang.Runnable
                public void run() {
                    if (zzm.this.zzIC != null) {
                        zzm.this.zzIC.release();
                        zzm.this.zzIC = null;
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        zzin.zzaI("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzHh, null, -1L);
        AdResponseParcel adResponseParcelZze = zze(adRequestInfoParcel);
        final zzif.zza zzaVar = new zzif.zza(adRequestInfoParcel, adResponseParcelZze, null, null, adResponseParcelZze.errorCode, zzr.zzbG().elapsedRealtime(), adResponseParcelZze.zzHX, null);
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzm.1
            @Override // java.lang.Runnable
            public void run() {
                zzm.this.zzHg.zza(zzaVar);
                if (zzm.this.zzIC != null) {
                    zzm.this.zzIC.release();
                    zzm.this.zzIC = null;
                }
            }
        });
    }
}
