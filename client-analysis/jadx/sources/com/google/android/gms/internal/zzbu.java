package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzbu {
    private Context mContext;
    private String zzsy;
    private boolean zzxi = zzbt.zzwg.get().booleanValue();
    private String zzxj = zzbt.zzwh.get();
    private Map<String, String> zzxk = new LinkedHashMap();

    public zzbu(Context context, String str) {
        this.mContext = null;
        this.zzsy = null;
        this.mContext = context;
        this.zzsy = str;
        this.zzxk.put("s", "gmob_sdk");
        this.zzxk.put("v", "3");
        this.zzxk.put("os", Build.VERSION.RELEASE);
        this.zzxk.put("sdk", Build.VERSION.SDK);
        this.zzxk.put("device", com.google.android.gms.ads.internal.zzr.zzbC().zzht());
        this.zzxk.put(SettingsJsonConstants.APP_KEY, context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        zzhj zzhjVarZzE = com.google.android.gms.ads.internal.zzr.zzbI().zzE(this.mContext);
        this.zzxk.put("network_coarse", Integer.toString(zzhjVarZzE.zzKc));
        this.zzxk.put("network_fine", Integer.toString(zzhjVarZzE.zzKd));
    }

    Context getContext() {
        return this.mContext;
    }

    String zzcs() {
        return this.zzsy;
    }

    boolean zzdu() {
        return this.zzxi;
    }

    String zzdv() {
        return this.zzxj;
    }

    Map<String, String> zzdw() {
        return this.zzxk;
    }
}
