package com.google.android.gms.internal;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public final class zzhg {
    private final AdRequestInfoParcel zzCu;
    private List<String> zzGK;
    private RewardItemParcel zzJE;
    private List<String> zzJF;
    private List<String> zzJG;
    private String zzJn;
    private String zzJo;
    private List<String> zzJp;
    private String zzJq;
    private String zzJr;
    private List<String> zzJs;
    private String zzxY;
    private long zzJt = -1;
    private boolean zzJu = false;
    private final long zzJv = -1;
    private long zzJw = -1;
    private int mOrientation = -1;
    private boolean zzJx = false;
    private boolean zzJy = false;
    private boolean zzJz = false;
    private boolean zzJA = true;
    private int zzJB = 0;
    private String zzJC = "";
    private boolean zzJD = false;
    private boolean zzuS = false;
    private boolean zzJH = false;

    public zzhg(AdRequestInfoParcel adRequestInfoParcel) {
        this.zzCu = adRequestInfoParcel;
    }

    private void zzA(Map<String, List<String>> map) {
        String strZzd = zzd(map, "X-Afma-Fluid");
        if (strZzd == null || !strZzd.equals(SettingsJsonConstants.ICON_HEIGHT_KEY)) {
            return;
        }
        this.zzJD = true;
    }

    private void zzB(Map<String, List<String>> map) {
        this.zzuS = "native_express".equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzC(Map<String, List<String>> map) {
        this.zzJE = RewardItemParcel.zzay(zzd(map, "X-Afma-Rewards"));
    }

    private void zzD(Map<String, List<String>> map) {
        if (this.zzJF != null) {
            return;
        }
        this.zzJF = zzf(map, "X-Afma-Reward-Video-Start-Urls");
    }

    private void zzE(Map<String, List<String>> map) {
        if (this.zzJG != null) {
            return;
        }
        this.zzJG = zzf(map, "X-Afma-Reward-Video-Complete-Urls");
    }

    private void zzF(Map<String, List<String>> map) {
        this.zzJH |= zzg(map, "X-Afma-Use-Displayed-Impression");
    }

    static String zzd(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    static long zze(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list != null && !list.isEmpty()) {
            String str2 = list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                zzin.zzaK("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1L;
    }

    static List<String> zzf(Map<String, List<String>> map, String str) {
        String str2;
        List<String> list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private boolean zzg(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        return (list == null || list.isEmpty() || !Boolean.valueOf(list.get(0)).booleanValue()) ? false : true;
    }

    private void zzk(Map<String, List<String>> map) {
        this.zzJn = zzd(map, "X-Afma-Ad-Size");
    }

    private void zzl(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Click-Tracking-Urls");
        if (listZzf != null) {
            this.zzJp = listZzf;
        }
    }

    private void zzm(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzJq = list.get(0);
    }

    private void zzn(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Tracking-Urls");
        if (listZzf != null) {
            this.zzJs = listZzf;
        }
    }

    private void zzo(Map<String, List<String>> map) {
        long jZze = zze(map, "X-Afma-Interstitial-Timeout");
        if (jZze != -1) {
            this.zzJt = jZze;
        }
    }

    private void zzp(Map<String, List<String>> map) {
        this.zzJr = zzd(map, "X-Afma-ActiveView");
    }

    private void zzq(Map<String, List<String>> map) {
        this.zzJy = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(zzd(map, "X-Afma-Ad-Format"));
    }

    private void zzr(Map<String, List<String>> map) {
        this.zzJx |= zzg(map, "X-Afma-Custom-Rendering-Allowed");
    }

    private void zzs(Map<String, List<String>> map) {
        this.zzJu |= zzg(map, "X-Afma-Mediation");
    }

    private void zzt(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-Manual-Tracking-Urls");
        if (listZzf != null) {
            this.zzGK = listZzf;
        }
    }

    private void zzu(Map<String, List<String>> map) {
        long jZze = zze(map, "X-Afma-Refresh-Rate");
        if (jZze != -1) {
            this.zzJw = jZze;
        }
    }

    private void zzv(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Orientation");
        if (list == null || list.isEmpty()) {
            return;
        }
        String str = list.get(0);
        if ("portrait".equalsIgnoreCase(str)) {
            this.mOrientation = com.google.android.gms.ads.internal.zzr.zzbE().zzhw();
        } else if ("landscape".equalsIgnoreCase(str)) {
            this.mOrientation = com.google.android.gms.ads.internal.zzr.zzbE().zzhv();
        }
    }

    private void zzw(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Use-HTTPS");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzJz = Boolean.valueOf(list.get(0)).booleanValue();
    }

    private void zzx(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Content-Url-Opted-Out");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzJA = Boolean.valueOf(list.get(0)).booleanValue();
    }

    private void zzy(Map<String, List<String>> map) {
        List<String> listZzf = zzf(map, "X-Afma-OAuth-Token-Status");
        this.zzJB = 0;
        if (listZzf == null) {
            return;
        }
        for (String str : listZzf) {
            if ("Clear".equalsIgnoreCase(str)) {
                this.zzJB = 1;
                return;
            } else if ("No-Op".equalsIgnoreCase(str)) {
                this.zzJB = 0;
                return;
            }
        }
    }

    private void zzz(Map<String, List<String>> map) {
        List<String> list = map.get("X-Afma-Gws-Query-Id");
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzJC = list.get(0);
    }

    public void zzb(String str, Map<String, List<String>> map, String str2) {
        this.zzJo = str;
        this.zzxY = str2;
        zzj(map);
    }

    public AdResponseParcel zzj(long j) {
        return new AdResponseParcel(this.zzCu, this.zzJo, this.zzxY, this.zzJp, this.zzJs, this.zzJt, this.zzJu, -1L, this.zzGK, this.zzJw, this.mOrientation, this.zzJn, j, this.zzJq, this.zzJr, this.zzJx, this.zzJy, this.zzJz, this.zzJA, false, this.zzJB, this.zzJC, this.zzJD, this.zzuS, this.zzJE, this.zzJF, this.zzJG, this.zzJH);
    }

    public void zzj(Map<String, List<String>> map) {
        zzk(map);
        zzl(map);
        zzm(map);
        zzn(map);
        zzo(map);
        zzs(map);
        zzt(map);
        zzu(map);
        zzv(map);
        zzp(map);
        zzw(map);
        zzr(map);
        zzq(map);
        zzx(map);
        zzy(map);
        zzz(map);
        zzA(map);
        zzB(map);
        zzC(map);
        zzD(map);
        zzE(map);
        zzF(map);
    }
}
