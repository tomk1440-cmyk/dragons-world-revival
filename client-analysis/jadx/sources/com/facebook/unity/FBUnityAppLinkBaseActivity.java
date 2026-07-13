package com.facebook.unity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class FBUnityAppLinkBaseActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Log.v(FB.TAG, "Saving deep link from deep linking activity");
        FB.SetIntent(getIntent());
        Log.v(FB.TAG, "Returning to main activity");
        Intent newIntent = new Intent(this, getMainActivityClass());
        startActivity(newIntent);
        finish();
    }

    private Class<?> getMainActivityClass() {
        String packageName = getPackageName();
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
        try {
            return Class.forName(launchIntent.getComponent().getClassName());
        } catch (Exception e) {
            Log.e(FB.TAG, "Unable to find Main Activity Class");
            return null;
        }
    }
}
