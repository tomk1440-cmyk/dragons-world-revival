package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.nearby.messages.Strategy;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class zzpw extends com.google.android.gms.measurement.zze<zzpw> {
    private String zzaUQ;
    private int zzaUR;
    private int zzaUS;
    private String zzaUT;
    private String zzaUU;
    private boolean zzaUV;
    private boolean zzaUW;
    private boolean zzaUX;

    public zzpw() {
        this(false);
    }

    public zzpw(boolean z) {
        this(z, zzBb());
    }

    public zzpw(boolean z, int i) {
        com.google.android.gms.common.internal.zzx.zzbV(i);
        this.zzaUR = i;
        this.zzaUW = z;
    }

    static int zzBb() {
        UUID uuidRandomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (uuidRandomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        int mostSignificantBits = (int) (uuidRandomUUID.getMostSignificantBits() & 2147483647L);
        if (mostSignificantBits != 0) {
            return mostSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Strategy.TTL_SECONDS_INFINITE;
    }

    private void zzBf() {
        if (this.zzaUX) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public void setScreenName(String screenName) {
        zzBf();
        this.zzaUQ = screenName;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("screenName", this.zzaUQ);
        map.put("interstitial", Boolean.valueOf(this.zzaUV));
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.zzaUW));
        map.put("screenId", Integer.valueOf(this.zzaUR));
        map.put("referrerScreenId", Integer.valueOf(this.zzaUS));
        map.put("referrerScreenName", this.zzaUT);
        map.put("referrerUri", this.zzaUU);
        return zzF(map);
    }

    public String zzBc() {
        return this.zzaUQ;
    }

    public int zzBd() {
        return this.zzaUR;
    }

    public String zzBe() {
        return this.zzaUU;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpw zzpwVar) {
        if (!TextUtils.isEmpty(this.zzaUQ)) {
            zzpwVar.setScreenName(this.zzaUQ);
        }
        if (this.zzaUR != 0) {
            zzpwVar.zziF(this.zzaUR);
        }
        if (this.zzaUS != 0) {
            zzpwVar.zziG(this.zzaUS);
        }
        if (!TextUtils.isEmpty(this.zzaUT)) {
            zzpwVar.zzeH(this.zzaUT);
        }
        if (!TextUtils.isEmpty(this.zzaUU)) {
            zzpwVar.zzeI(this.zzaUU);
        }
        if (this.zzaUV) {
            zzpwVar.zzaq(this.zzaUV);
        }
        if (this.zzaUW) {
            zzpwVar.zzap(this.zzaUW);
        }
    }

    public void zzap(boolean z) {
        zzBf();
        this.zzaUW = z;
    }

    public void zzaq(boolean z) {
        zzBf();
        this.zzaUV = z;
    }

    public void zzeH(String str) {
        zzBf();
        this.zzaUT = str;
    }

    public void zzeI(String str) {
        zzBf();
        if (TextUtils.isEmpty(str)) {
            this.zzaUU = null;
        } else {
            this.zzaUU = str;
        }
    }

    public void zziF(int i) {
        zzBf();
        this.zzaUR = i;
    }

    public void zziG(int i) {
        zzBf();
        this.zzaUS = i;
    }
}
