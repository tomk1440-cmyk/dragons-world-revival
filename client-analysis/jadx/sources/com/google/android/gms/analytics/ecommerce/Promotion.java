package com.google.android.gms.analytics.ecommerce;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Promotion {
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    Map<String, String> zzPU = new HashMap();

    void put(String name, String value) {
        zzx.zzb(name, "Name should be non-null");
        this.zzPU.put(name, value);
    }

    public Promotion setCreative(String value) {
        put("cr", value);
        return this;
    }

    public Promotion setId(String value) {
        put(ShareConstants.WEB_DIALOG_PARAM_ID, value);
        return this;
    }

    public Promotion setName(String value) {
        put("nm", value);
        return this;
    }

    public Promotion setPosition(String value) {
        put("ps", value);
        return this;
    }

    public String toString() {
        return zze.zzO(this.zzPU);
    }

    public Map<String, String> zzba(String str) {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : this.zzPU.entrySet()) {
            map.put(str + entry.getKey(), entry.getValue());
        }
        return map;
    }
}
