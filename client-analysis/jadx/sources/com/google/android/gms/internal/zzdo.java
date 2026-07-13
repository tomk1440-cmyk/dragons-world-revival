package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzdo implements zzdf {
    private final Map<zzjp, Integer> zzzI = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return com.google.android.gms.ads.internal.client.zzn.zzcS().zzb(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzin.zzaK("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    @Override // com.google.android.gms.internal.zzdf
    public void zza(zzjp zzjpVar, Map<String, String> map) {
        int i;
        com.google.android.gms.ads.internal.overlay.zzk zzkVarZzhM;
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str == null) {
            zzin.zzaK("Action missing from video GMSG.");
            return;
        }
        if (zzin.zzQ(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzin.zzaI("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzin.zzaK("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int color = Color.parseColor(str2);
                zzjo zzjoVarZzia = zzjpVar.zzia();
                if (zzjoVarZzia == null || (zzkVarZzhM = zzjoVarZzia.zzhM()) == null) {
                    this.zzzI.put(zzjpVar, Integer.valueOf(color));
                } else {
                    zzkVarZzhM.setBackgroundColor(color);
                }
                return;
            } catch (IllegalArgumentException e) {
                zzin.zzaK("Invalid color parameter in video GMSG.");
                return;
            }
        }
        zzjo zzjoVarZzia2 = zzjpVar.zzia();
        if (zzjoVarZzia2 == null) {
            zzin.zzaK("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = AppSettingsData.STATUS_NEW.equals(str);
        boolean zEquals2 = "position".equals(str);
        if (zEquals || zEquals2) {
            Context context = zzjpVar.getContext();
            int iZza = zza(context, map, "x", 0);
            int iZza2 = zza(context, map, "y", 0);
            int iZza3 = zza(context, map, "w", -1);
            int iZza4 = zza(context, map, "h", -1);
            try {
                i = Integer.parseInt(map.get("player"));
            } catch (NumberFormatException e2) {
                i = 0;
            }
            if (!zEquals || zzjoVarZzia2.zzhM() != null) {
                zzjoVarZzia2.zze(iZza, iZza2, iZza3, iZza4);
                return;
            }
            zzjoVarZzia2.zza(iZza, iZza2, iZza3, iZza4, i);
            if (this.zzzI.containsKey(zzjpVar)) {
                int iIntValue = this.zzzI.get(zzjpVar).intValue();
                com.google.android.gms.ads.internal.overlay.zzk zzkVarZzhM2 = zzjoVarZzia2.zzhM();
                zzkVarZzhM2.setBackgroundColor(iIntValue);
                zzkVarZzhM2.zzfE();
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzk zzkVarZzhM3 = zzjoVarZzia2.zzhM();
        if (zzkVarZzhM3 == null) {
            com.google.android.gms.ads.internal.overlay.zzk.zzg(zzjpVar);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzjpVar.getContext();
            int iZza5 = zza(context2, map, "x", 0);
            int iZza6 = zza(context2, map, "y", 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZza5, iZza6, 0);
            zzkVarZzhM3.zzd(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str3 = map.get("time");
            if (str3 == null) {
                zzin.zzaK("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzkVarZzhM3.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                return;
            } catch (NumberFormatException e3) {
                zzin.zzaK("Could not parse time parameter from currentTime video GMSG: " + str3);
                return;
            }
        }
        if ("hide".equals(str)) {
            zzkVarZzhM3.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            zzkVarZzhM3.zzfD();
            return;
        }
        if ("mimetype".equals(str)) {
            zzkVarZzhM3.setMimeType(map.get("mimetype"));
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean(map.get("muted"))) {
                zzkVarZzhM3.zzff();
                return;
            } else {
                zzkVarZzhM3.zzfg();
                return;
            }
        }
        if ("pause".equals(str)) {
            zzkVarZzhM3.pause();
            return;
        }
        if ("play".equals(str)) {
            zzkVarZzhM3.play();
            return;
        }
        if ("show".equals(str)) {
            zzkVarZzhM3.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            zzkVarZzhM3.zzap(map.get("src"));
            return;
        }
        if (!"volume".equals(str)) {
            if ("watermark".equals(str)) {
                zzkVarZzhM3.zzfE();
                return;
            } else {
                zzin.zzaK("Unknown video action: " + str);
                return;
            }
        }
        String str4 = map.get("volume");
        if (str4 == null) {
            zzin.zzaK("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            zzkVarZzhM3.zza(Float.parseFloat(str4));
        } catch (NumberFormatException e4) {
            zzin.zzaK("Could not parse volume parameter from volume video GMSG: " + str4);
        }
    }
}
