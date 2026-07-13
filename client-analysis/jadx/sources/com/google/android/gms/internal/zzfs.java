package com.google.android.gms.internal;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzfs {
    private final String zzDJ;
    private final zzjp zzpD;

    public zzfs(zzjp zzjpVar) {
        this(zzjpVar, "");
    }

    public zzfs(zzjp zzjpVar, String str) {
        this.zzpD = zzjpVar;
        this.zzDJ = str;
    }

    public void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzpD.zzb("onScreenInfoChanged", new JSONObject().put(SettingsJsonConstants.ICON_WIDTH_KEY, i).put(SettingsJsonConstants.ICON_HEIGHT_KEY, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            zzin.zzb("Error occured while obtaining screen information.", e);
        }
    }

    public void zzam(String str) {
        try {
            this.zzpD.zzb("onError", new JSONObject().put("message", str).put(NativeProtocol.WEB_DIALOG_ACTION, this.zzDJ));
        } catch (JSONException e) {
            zzin.zzb("Error occurred while dispatching error event.", e);
        }
    }

    public void zzan(String str) {
        try {
            this.zzpD.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching ready Event.", e);
        }
    }

    public void zzao(String str) {
        try {
            this.zzpD.zzb("onStateChanged", new JSONObject().put(ServerProtocol.DIALOG_PARAM_STATE, str));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching state change.", e);
        }
    }

    public void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzpD.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(SettingsJsonConstants.ICON_WIDTH_KEY, i3).put(SettingsJsonConstants.ICON_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching size change.", e);
        }
    }

    public void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzpD.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(SettingsJsonConstants.ICON_WIDTH_KEY, i3).put(SettingsJsonConstants.ICON_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzin.zzb("Error occured while dispatching default position.", e);
        }
    }
}
