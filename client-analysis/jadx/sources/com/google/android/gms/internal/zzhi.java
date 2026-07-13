package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
class zzhi {
    private final String zzEY;
    private String zzF;
    private int zzGu;
    private final List<String> zzJI;
    private final List<String> zzJJ;
    private final String zzJK;
    private final String zzJL;
    private final String zzJM;
    private final String zzJN;
    private final boolean zzJO;
    private final boolean zzJP;

    public zzhi(int i, Map<String, String> map) {
        this.zzF = map.get("url");
        this.zzJL = map.get("base_uri");
        this.zzJM = map.get("post_parameters");
        this.zzJO = parseBoolean(map.get("drt_include"));
        this.zzJP = parseBoolean(map.get("pan_include"));
        this.zzJK = map.get("activation_overlay_url");
        this.zzJJ = zzav(map.get("check_packages"));
        this.zzEY = map.get("request_id");
        this.zzJN = map.get(ShareConstants.MEDIA_TYPE);
        this.zzJI = zzav(map.get("errors"));
        this.zzGu = i;
    }

    private static boolean parseBoolean(String bool) {
        return bool != null && (bool.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES) || bool.equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE));
    }

    private List<String> zzav(String str) {
        if (str == null) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    public int getErrorCode() {
        return this.zzGu;
    }

    public String getRequestId() {
        return this.zzEY;
    }

    public String getType() {
        return this.zzJN;
    }

    public String getUrl() {
        return this.zzF;
    }

    public void setUrl(String url) {
        this.zzF = url;
    }

    public List<String> zzgE() {
        return this.zzJI;
    }

    public String zzgF() {
        return this.zzJM;
    }

    public boolean zzgG() {
        return this.zzJO;
    }

    public boolean zzgH() {
        return this.zzJP;
    }
}
