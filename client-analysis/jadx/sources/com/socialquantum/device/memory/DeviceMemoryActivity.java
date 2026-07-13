package com.socialquantum.device.memory;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class DeviceMemoryActivity implements Application.ActivityLifecycleCallbacks {
    static final String APPLICATION_PAUSED_KEY = "application_paused";
    static final String TAG = "DeviceMemoryActivity";
    private static Boolean isEnabled = false;

    public static void enable() {
        Log.i(TAG, "enable");
        isEnabled = true;
    }

    public static void disable() {
        Log.i(TAG, "enable");
        isEnabled = false;
    }

    public static void createMemoryChunk() {
        MemoryUtil.Instance().createMemoryChunk();
    }

    public void onLowMemory(int level) {
        Log.w(TAG, "Low memory warning received");
        if (isEnabled.booleanValue()) {
            MemoryUtil.Instance().reportMemory(level);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.i(TAG, "Activity onActivityCreated");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Log.i(TAG, "Activity onActivityStarted");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Log.i(TAG, "Activity onActivityResumed");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Log.i(TAG, "Activity onActivityPaused");
        Application app = activity.getApplication();
        SharedPreferences prefs = app.getSharedPreferences(app.getPackageName(), 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(APPLICATION_PAUSED_KEY, 1);
        editor.commit();
        disable();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Log.i(TAG, "Activity onActivityStopped");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Log.i(TAG, "Activity onActivitySaveInstanceState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Log.i(TAG, "Activity onActivityDestroyed");
    }
}
