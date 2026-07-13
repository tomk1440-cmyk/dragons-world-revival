package com.socialquantum.dw.mainactivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;
import com.chartboost.sdk.Chartboost;
import com.socialquantum.device.memory.DeviceMemoryActivity;
import com.socialquantum.dw.utils.Versions;
import com.socialquantum.dw.utils.android.AndroidIdUtil;
import com.socialquantum.dw.utils.exception.UncaughtExceptionHandler;
import com.socialquantum.googleplay.extention.PlayGameService;
import com.socialquantum.notifications.local.AlarmReceiver;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
public class UnityPlayerActivity extends com.unity3d.player.UnityPlayerActivity {
    private ActivityProxyObjectHelper _proxyHelper;
    private DeviceMemoryActivity deviceMemoryActivity;
    private Extender extender;
    private SharedPreferences mPackagePrefs;
    private String TAG = "UnityPlayerActivity";
    private String APP_PAUSED = "appWasPaused";
    private String APP_CRASHED = "crashed_with_uncaught_exception";

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        this.deviceMemoryActivity.onLowMemory(level);
        if (level <= 15) {
            Log.e(this.TAG, "Trim memory warning received" + level);
        } else {
            Log.w(this.TAG, "Trim memory received" + level);
        }
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        Log.w(this.TAG, "Low memory warning received");
        this.deviceMemoryActivity.onLowMemory(1000);
    }

    private void initDeviceMemoryActivity() {
        this.deviceMemoryActivity = new DeviceMemoryActivity();
        getApplication().registerComponentCallbacks(this);
        Log.d(this.TAG, "Installing uncaught exception handler");
        UncaughtExceptionHandler handler = new UncaughtExceptionHandler(this, getPackageName());
        Thread.setDefaultUncaughtExceptionHandler(handler);
        getApplication().registerActivityLifecycleCallbacks(this.deviceMemoryActivity);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Log.i(this.TAG, "onCreate");
        initDeviceMemoryActivity();
        Versions.loadMetadata(getApplicationContext());
        this.extender = GetExtender();
        super.onCreate(savedInstanceState);
        Bundle data = getIntent().getExtras();
        this.mPackagePrefs = getSharedPreferences(getPackageName(), 0);
        if (this.mPackagePrefs != null) {
            Log.i(this.TAG, "prefs not null");
            SharedPreferences.Editor editor = this.mPackagePrefs.edit();
            if (this.mPackagePrefs.contains(this.APP_PAUSED)) {
                Log.i(this.TAG, "containspause");
                if (this.mPackagePrefs.getInt(this.APP_PAUSED, 1) == 0) {
                    Log.i(this.TAG, "set crash to 1");
                    editor.putInt(this.APP_CRASHED, 1);
                }
            }
            Log.i(this.TAG, "clear pause");
            editor.putInt(this.APP_PAUSED, 0);
            SavePushInfo(editor, data);
            editor.commit();
        }
        try {
            this._proxyHelper = new ActivityProxyObjectHelper(this);
            this._proxyHelper.onCreate(savedInstanceState);
        } catch (Exception e) {
            Log.i(this.TAG, "Failed to create proxyHelper: " + e.getMessage());
        }
        this.extender.onCreate(this);
    }

    @Override // android.app.Activity
    public void onActivityResult(int request, int response, Intent data) {
        Log.i(this.TAG, "Activity resulg : req : " + request + " ; res : " + response + " ; d : " + data);
        switch (request) {
            case 90004:
                if (response == 10001) {
                    Log.i(this.TAG, "Sign out response was received.");
                    PlayGameService.instance().forceDisconnect();
                }
                break;
            case 321654987:
                if (request == 10007) {
                    Toast.makeText(this, "FAILED TO SEND REQUEST!", 1).show();
                }
                break;
        }
        Log.i(this.TAG, "onActivityResult request:" + request + " responce:" + response + " data:" + data);
        super.onActivityResult(request, response, data);
        this._proxyHelper.onActivityResult(request, response, data);
    }

    @Override // android.app.Activity
    public void onStart() {
        Log.i(this.TAG, "onStart");
        super.onStart();
        this.extender.onStart();
        Log.i(this.TAG, "Proxy helper start...");
        this._proxyHelper.invokeZeroParameterMethod("onStart");
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Log.i(this.TAG, "onNewIntent");
        super.onNewIntent(intent);
        setIntent(intent);
        this._proxyHelper.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onStop() {
        Log.e(this.TAG, "Unstopable activity was stopped!");
        super.onStop();
        this.extender.onStop();
        this._proxyHelper.invokeZeroParameterMethod("onStop");
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onDestroy() {
        Log.d(this.TAG, "onDestroy");
        super.onDestroy();
        this.extender.onDestroy();
        this._proxyHelper.invokeZeroParameterMethod("onDestroy");
        if (!AndroidIdUtil.sceneLoaded()) {
            Log.w(this.TAG, "KILLING PROCESS : " + Process.myPid());
            Process.killProcess(Process.myPid());
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        Log.e(this.TAG, "Unstopable activity was restarted!");
        super.onRestart();
        this._proxyHelper.invokeZeroParameterMethod("onRestart");
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onPause() {
        Log.i(this.TAG, "onPause");
        tryToKillApplication();
        if (this.mPackagePrefs != null) {
            SharedPreferences.Editor editor = this.mPackagePrefs.edit();
            editor.putInt(this.APP_PAUSED, 1);
            editor.commit();
        }
        super.onPause();
        this._proxyHelper.invokeZeroParameterMethod("onPause");
    }

    private void tryToKillApplication() {
        Log.i(this.TAG, "Maybe kill app ?");
        if (!AndroidIdUtil.sceneLoaded()) {
            Log.w(this.TAG, "FINISHING APP!");
            finish();
            Log.w(this.TAG, "SYS EXIT APP!");
            System.exit(0);
        }
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity
    public void onResume() {
        Log.i(this.TAG, "onResume");
        Bundle bundle = getIntent().getExtras();
        if (this.mPackagePrefs != null) {
            SharedPreferences.Editor editor = this.mPackagePrefs.edit();
            editor.putInt(this.APP_PAUSED, 0);
            SavePushInfo(editor, bundle);
            editor.commit();
        }
        super.onResume();
        Log.d(this.TAG, "Settings.getApplicationId() = " + Versions.appId());
        this._proxyHelper.invokeZeroParameterMethod("onResume");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        this._proxyHelper.invokeZeroParameterMethod("onBackPressed");
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Log.i(this.TAG, "onSaveInstanceState savedInstanceState:" + savedInstanceState);
        this._proxyHelper.onSaveInstanceState(savedInstanceState);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(this.TAG, "onRestoreInstanceState savedInstanceState:" + savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
        this._proxyHelper.onRestoreInstanceState(savedInstanceState);
    }

    @Override // com.unity3d.player.UnityPlayerActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this._proxyHelper.onConfigurationChanged(newConfig);
    }

    public void onSignInFailed() {
        Log.i(this.TAG, "onSignInFailed");
    }

    public void onSignInSucceeded() {
        Log.i(this.TAG, "onSignInSucceeded");
    }

    private void SavePushInfo(SharedPreferences.Editor editor, Bundle bundle) {
        Log.i(this.TAG, "SavePushInfo" + (editor == null) + " - " + (bundle == null));
        if (editor != null && bundle != null) {
            Log.i(this.TAG, "LaunchNotificationId SavePushInfo: nId=" + bundle.getString(AlarmReceiver.NOTIFICATION_ID) + ", tag=" + bundle.getString("tag"));
            String nId = bundle.getString(AlarmReceiver.NOTIFICATION_ID);
            if (nId != null && !nId.isEmpty()) {
                editor.putString("LaunchNotificationId", bundle.getString(AlarmReceiver.NOTIFICATION_ID));
            }
            String tag = bundle.getString("tag");
            if (tag != null && !tag.isEmpty()) {
                editor.putString("LaunchNotificationTag", bundle.getString("tag"));
            }
        }
    }

    private Extender GetExtender() {
        return Versions.type() == Versions.BuildType.INT ? new ChartboostExtender() : new EmptyExtender();
    }

    abstract class Extender {
        public abstract void onCreate(Activity activity);

        public abstract void onDestroy();

        public abstract void onStart();

        public abstract void onStop();

        Extender() {
        }
    }

    class ChartboostExtender extends Extender {
        private Activity activity;
        private Chartboost cb;

        public ChartboostExtender() {
            super();
            Log.i("ChartboostExt", "Creating extener");
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onCreate(Activity activity) {
            Log.i("ChartboostExt", "Creating chartboost");
            try {
                this.cb = Chartboost.sharedChartboost();
                this.cb.onCreate(activity, "529c52e49ddc353eba2187a8", "af7a6dc16fba5b6a2acc89d1c0dac1436663e8d8", null);
            } catch (Exception e) {
                Log.i("ChartboostExt", "Failed to create Chartboost: " + e.getMessage());
            }
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onStart() {
            Log.i("ChartboostExt", "Starting chartboost");
            this.cb.onStart(this.activity);
            this.cb.startSession();
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onStop() {
            this.cb.onStop(this.activity);
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onDestroy() {
            this.cb.onDestroy(this.activity);
        }
    }

    class EmptyExtender extends Extender {
        EmptyExtender() {
            super();
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onCreate(Activity activity) {
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onStart() {
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onStop() {
        }

        @Override // com.socialquantum.dw.mainactivity.UnityPlayerActivity.Extender
        public void onDestroy() {
        }
    }
}
