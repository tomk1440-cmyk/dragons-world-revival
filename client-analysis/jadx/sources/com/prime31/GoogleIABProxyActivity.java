package com.prime31;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class GoogleIABProxyActivity extends Activity {
    private static final int RC_REQUEST = 10001;
    private static final String TAG = "Prime31-Proxy";
    private Boolean _created = false;
    private Boolean _didCompletePurcaseFlow = false;

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this._created.booleanValue()) {
            Log.i("Prime31", "activity created twice. stopping one instance");
            return;
        }
        this._created = true;
        try {
            String sku = getIntent().getExtras().getString("sku");
            String itemType = getIntent().getExtras().getString("itemType");
            String developerPayload = getIntent().getExtras().getString("developerPayload");
            Log.i(TAG, "proxy received action. sku: " + sku);
            boolean res = GoogleIABPlugin.instance().helper.launchPurchaseFlow(this, sku, itemType, null, 10001, GoogleIABPlugin.instance(), developerPayload);
            if (!res) {
                finish();
            }
        } catch (Exception e) {
            Log.i(TAG, "unhandled exception while attempting to purchase item: " + e.getMessage());
            Log.i(TAG, "going to end the async operation with null data to clear out the queue");
            this._didCompletePurcaseFlow = true;
            if (GoogleIABPlugin.instance().helper == null) {
                Log.e(TAG, "FATAL ERROR: Plugin singleton helper is null. Aborting operation.");
            } else {
                GoogleIABPlugin.instance().helper.handleActivityResult(10001, 0, null);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        this._didCompletePurcaseFlow = true;
        IABConstants.logEntering(getClass().getSimpleName(), "onActivityResult", new Object[]{Integer.valueOf(requestCode), Integer.valueOf(resultCode), data});
        if (GoogleIABPlugin.instance().helper == null) {
            Log.e(TAG, "FATAL ERROR: Plugin singleton helper is null in onActivityResult. Attempting to abort operation to avoid a crash.");
            super.onActivityResult(requestCode, resultCode, data);
            finish();
        } else {
            if (!GoogleIABPlugin.instance().helper.handleActivityResult(requestCode, resultCode, data)) {
                super.onActivityResult(requestCode, resultCode, data);
            } else {
                Log.d(TAG, "onActivityResult handled by IABUtil. All done here.");
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (!this._didCompletePurcaseFlow.booleanValue()) {
            Log.d(TAG, "in onStop but we didnt complete the purchase flow. Canceling it now.");
            GoogleIABPlugin.instance().helper.handleActivityResult(10001, 0, null);
        }
        Log.d(TAG, "GoogleIABProxyActivity onStop");
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "GoogleIABProxyActivity onDestroy");
    }
}
