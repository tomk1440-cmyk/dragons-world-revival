package com.socialquantum.adinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.socialquantum.dw.utils.storage.FileSystem;

/* JADX INFO: loaded from: classes.dex */
public class AdInstallReferenceReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d("AmazonADM", "Install notification");
        ReadUrlReference(context, intent, "AdInstallReferenceReceiver");
    }

    private void ReadUrlReference(Context context, Intent intent, String logCaption) {
        try {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                Log.d(logCaption, "Ad reference url is not specified (extras == null)");
            } else {
                String referrerString = extras.getString(Constants.REFERRER);
                if (referrerString == null) {
                    Log.d(logCaption, "Ad reference url is not specified (referrerString == null)");
                } else {
                    String dummyUri = "x://?referrer=" + referrerString;
                    FileSystem.SaveUrlReferenceToFile(context, dummyUri, logCaption);
                }
            }
        } catch (Exception e) {
            Log.d(logCaption, "Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
