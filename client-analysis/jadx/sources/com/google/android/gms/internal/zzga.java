package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzga extends Handler {
    private final zzfz zzFq;

    public zzga(Context context) {
        this(new zzgb(context.getApplicationContext() != null ? context.getApplicationContext() : context));
    }

    public zzga(zzfz zzfzVar) {
        this.zzFq = zzfzVar;
    }

    private void zzd(JSONObject jSONObject) {
        try {
            this.zzFq.zza(jSONObject.getString("request_id"), jSONObject.getString("base_url"), jSONObject.getString("html"));
        } catch (Exception e) {
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        try {
            Bundle data = msg.getData();
            if (data == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(data.getString(ShareConstants.WEB_DIALOG_PARAM_DATA));
            if ("fetch_html".equals(jSONObject.getString("message_name"))) {
                zzd(jSONObject);
            }
        } catch (Exception e) {
        }
    }
}
