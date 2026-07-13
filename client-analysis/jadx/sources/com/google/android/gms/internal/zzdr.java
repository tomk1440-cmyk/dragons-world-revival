package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public abstract class zzdr implements Releasable {
    protected Context mContext;
    protected String zzzN;
    protected WeakReference<zzjp> zzzO;

    public zzdr(zzjp zzjpVar) {
        this.mContext = zzjpVar.getContext();
        this.zzzN = com.google.android.gms.ads.internal.zzr.zzbC().zze(this.mContext, zzjpVar.zzhX().afmaVersion);
        this.zzzO = new WeakReference<>(zzjpVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zzW(String str) {
        switch (str) {
            case "error":
            case "playerFailed":
            case "inProgress":
            case "contentLengthMissing":
                return "internal";
            case "noCacheDir":
            case "expireFailed":
                return "io";
            case "badUrl":
            case "downloadTimeout":
                return "network";
            case "sizeExceeded":
            case "externalAbort":
                return "policy";
            default:
                return "internal";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(String str, Map<String, String> map) {
        zzjp zzjpVar = this.zzzO.get();
        if (zzjpVar != null) {
            zzjpVar.zza(str, map);
        }
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    public abstract boolean zzU(String str);

    protected String zzV(String str) {
        return com.google.android.gms.ads.internal.client.zzn.zzcS().zzaH(str);
    }

    protected void zza(final String str, final String str2, final int i) {
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.2
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheComplete");
                map.put("src", str);
                map.put("cachedSrc", str2);
                map.put("totalBytes", Integer.toString(i));
                zzdr.this.zza("onPrecacheEvent", map);
            }
        });
    }

    protected void zza(final String str, final String str2, final int i, final int i2, final boolean z) {
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheProgress");
                map.put("src", str);
                map.put("cachedSrc", str2);
                map.put("bytesLoaded", Integer.toString(i));
                map.put("totalBytes", Integer.toString(i2));
                map.put("cacheReady", z ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                zzdr.this.zza("onPrecacheEvent", map);
            }
        });
    }

    protected void zza(final String str, final String str2, final String str3, final String str4) {
        com.google.android.gms.ads.internal.util.client.zza.zzMS.post(new Runnable() { // from class: com.google.android.gms.internal.zzdr.3
            @Override // java.lang.Runnable
            public void run() {
                HashMap map = new HashMap();
                map.put("event", "precacheCanceled");
                map.put("src", str);
                if (!TextUtils.isEmpty(str2)) {
                    map.put("cachedSrc", str2);
                }
                map.put(ShareConstants.MEDIA_TYPE, zzdr.this.zzW(str3));
                map.put("reason", str3);
                if (!TextUtils.isEmpty(str4)) {
                    map.put("message", str4);
                }
                zzdr.this.zza("onPrecacheEvent", map);
            }
        });
    }
}
