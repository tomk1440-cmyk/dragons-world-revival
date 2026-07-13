package com.prime31;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class GoogleIABPluginBase {
    protected static final String MANAGER_NAME = "GoogleIABManager";
    protected static final String TAG = "Prime31";
    private static GoogleIABPlugin _instance;
    public Activity _activity;
    protected LinearLayout _layout;
    private Field _unityPlayerActivityField;
    private Class<?> _unityPlayerClass;
    private Method _unitySendMessageMethod;

    public static GoogleIABPlugin instance() {
        if (_instance == null) {
            _instance = new GoogleIABPlugin();
        }
        return _instance;
    }

    public GoogleIABPluginBase() {
        try {
            this._unityPlayerClass = Class.forName("com.unity3d.player.UnityPlayer");
            this._unityPlayerActivityField = this._unityPlayerClass.getField("currentActivity");
            this._unitySendMessageMethod = this._unityPlayerClass.getMethod("UnitySendMessage", String.class, String.class, String.class);
        } catch (ClassNotFoundException e) {
            Log.i(TAG, "could not find UnityPlayer class: " + e.getMessage());
        } catch (NoSuchFieldException e2) {
            Log.i(TAG, "could not find currentActivity field: " + e2.getMessage());
        } catch (Exception e3) {
            Log.i(TAG, "unkown exception occurred locating getActivity(): " + e3.getMessage());
        }
    }

    protected Activity getActivity() {
        if (this._unityPlayerActivityField != null) {
            try {
                Activity activity = (Activity) this._unityPlayerActivityField.get(this._unityPlayerClass);
                if (activity == null) {
                    Log.e(TAG, "Something has gone terribly wrong. The Unity Activity does not exist. This could be due to a low memory situation");
                    return activity;
                }
                return activity;
            } catch (Exception e) {
                Log.i(TAG, "error getting currentActivity: " + e.getMessage());
            }
        }
        return this._activity;
    }

    protected void UnitySendMessage(String m, String p) {
        if (p == null) {
            p = "";
        }
        if (this._unitySendMessageMethod != null) {
            try {
                this._unitySendMessageMethod.invoke(null, MANAGER_NAME, m, p);
                return;
            } catch (IllegalAccessException e) {
                Log.i(TAG, "could not find UnitySendMessage method: " + e.getMessage());
                return;
            } catch (IllegalArgumentException e2) {
                Log.i(TAG, "could not find UnitySendMessage method: " + e2.getMessage());
                return;
            } catch (InvocationTargetException e3) {
                Log.i(TAG, "could not find UnitySendMessage method: " + e3.getMessage());
                return;
            }
        }
        Toast.makeText(getActivity(), "UnitySendMessage:\n" + m + "\n" + p, 1).show();
        Log.i(TAG, "UnitySendMessage: GoogleIABManager, " + m + ", " + p);
    }

    protected void runSafelyOnUiThread(Runnable r) {
        runSafelyOnUiThread(r, null);
    }

    protected void runSafelyOnUiThread(final Runnable r, final String methodName) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.prime31.GoogleIABPluginBase.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.run();
                } catch (Exception e) {
                    if (methodName != null) {
                        GoogleIABPluginBase.this.UnitySendMessage(methodName, e.getMessage());
                    }
                    Log.e(GoogleIABPluginBase.TAG, "Exception running command on UI thread: " + e.getMessage());
                }
            }
        });
    }

    protected void persist(String key, String value) {
        IABConstants.logEntering(getClass().getSimpleName(), "persist", new Object[]{key, value});
        try {
            SharedPreferences prefs = getActivity().getSharedPreferences("P31Preferences", 0);
            prefs.edit().putString(key, value).commit();
        } catch (Exception e) {
            Log.i(TAG, "error in persist: " + e.getMessage());
        }
    }

    protected String unpersist(String key, boolean deleteKeyAfterFetching) {
        IABConstants.logEntering(getClass().getSimpleName(), "unpersist", new Object[]{key, true});
        String val = "";
        try {
            SharedPreferences prefs = getActivity().getSharedPreferences("P31Preferences", 0);
            val = prefs.getString(key, null);
            if (deleteKeyAfterFetching) {
                prefs.edit().remove(key).commit();
            }
            return val;
        } catch (Exception e) {
            Log.i(TAG, "error in unpersist: " + e.getMessage());
            return val;
        }
    }
}
