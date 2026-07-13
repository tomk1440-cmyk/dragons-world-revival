package com.adjust.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes.dex */
public class AdjustReferrerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String referrer;
        String rawReferrer = intent.getStringExtra(Constants.REFERRER);
        if (rawReferrer != null) {
            try {
                referrer = URLDecoder.decode(rawReferrer, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                referrer = Constants.MALFORMED;
            }
            AdjustInstance adjust = Adjust.getDefaultInstance();
            adjust.sendReferrer(referrer);
        }
    }
}
