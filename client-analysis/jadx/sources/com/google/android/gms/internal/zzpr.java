package com.google.android.gms.internal;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.facebook.share.internal.ShareConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzpr extends com.google.android.gms.measurement.zze<zzpr> {
    private String mName;
    private String zzaPI;
    private String zzaUF;
    private String zzaUG;
    private String zzaUH;
    private String zzaUI;
    private String zzaUJ;
    private String zzaUK;
    private String zzxG;
    private String zzyv;

    public String getContent() {
        return this.zzxG;
    }

    public String getId() {
        return this.zzyv;
    }

    public String getName() {
        return this.mName;
    }

    public String getSource() {
        return this.zzaPI;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String toString() {
        HashMap map = new HashMap();
        map.put("name", this.mName);
        map.put(ShareConstants.FEED_SOURCE_PARAM, this.zzaPI);
        map.put(Constants.MEDIUM, this.zzaUF);
        map.put("keyword", this.zzaUG);
        map.put("content", this.zzxG);
        map.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.zzyv);
        map.put("adNetworkId", this.zzaUH);
        map.put("gclid", this.zzaUI);
        map.put("dclid", this.zzaUJ);
        map.put("aclid", this.zzaUK);
        return zzF(map);
    }

    public String zzAK() {
        return this.zzaUF;
    }

    public String zzAL() {
        return this.zzaUG;
    }

    public String zzAM() {
        return this.zzaUH;
    }

    public String zzAN() {
        return this.zzaUI;
    }

    public String zzAO() {
        return this.zzaUJ;
    }

    public String zzAP() {
        return this.zzaUK;
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzpr zzprVar) {
        if (!TextUtils.isEmpty(this.mName)) {
            zzprVar.setName(this.mName);
        }
        if (!TextUtils.isEmpty(this.zzaPI)) {
            zzprVar.zzev(this.zzaPI);
        }
        if (!TextUtils.isEmpty(this.zzaUF)) {
            zzprVar.zzew(this.zzaUF);
        }
        if (!TextUtils.isEmpty(this.zzaUG)) {
            zzprVar.zzex(this.zzaUG);
        }
        if (!TextUtils.isEmpty(this.zzxG)) {
            zzprVar.zzey(this.zzxG);
        }
        if (!TextUtils.isEmpty(this.zzyv)) {
            zzprVar.zzez(this.zzyv);
        }
        if (!TextUtils.isEmpty(this.zzaUH)) {
            zzprVar.zzeA(this.zzaUH);
        }
        if (!TextUtils.isEmpty(this.zzaUI)) {
            zzprVar.zzeB(this.zzaUI);
        }
        if (!TextUtils.isEmpty(this.zzaUJ)) {
            zzprVar.zzeC(this.zzaUJ);
        }
        if (TextUtils.isEmpty(this.zzaUK)) {
            return;
        }
        zzprVar.zzeD(this.zzaUK);
    }

    public void zzeA(String str) {
        this.zzaUH = str;
    }

    public void zzeB(String str) {
        this.zzaUI = str;
    }

    public void zzeC(String str) {
        this.zzaUJ = str;
    }

    public void zzeD(String str) {
        this.zzaUK = str;
    }

    public void zzev(String str) {
        this.zzaPI = str;
    }

    public void zzew(String str) {
        this.zzaUF = str;
    }

    public void zzex(String str) {
        this.zzaUG = str;
    }

    public void zzey(String str) {
        this.zzxG = str;
    }

    public void zzez(String str) {
        this.zzyv = str;
    }
}
