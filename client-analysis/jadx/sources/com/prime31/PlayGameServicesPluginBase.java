package com.prime31;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import com.facebook.share.internal.ShareConstants;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PlayGameServicesPluginBase {
    protected static final String MANAGER_NAME = "GPGManager";
    protected static final String MULTIPLAYER_MANAGER_NAME = "GPGMultiplayerManager";
    protected static final String TAG = "Prime31";
    protected static final String TURN_BASED_MANAGER_NAME = "GPGTurnBasedManager";
    private static PlayGameServicesPlugin _instance;
    private static RealtimeMultiplayer _realtimeMultiplayer;
    private static TurnBasedMultiplayer _turnBasedMultiplayer;
    public Activity _activity;
    private Field _unityPlayerActivityField;
    private Class<?> _unityPlayerClass;
    private Method _unitySendMessageMethod;

    public static PlayGameServicesPlugin instance() {
        if (_instance == null) {
            _instance = new PlayGameServicesPlugin();
        }
        return _instance;
    }

    public static RealtimeMultiplayer realtimeMultiplayerInstance() {
        if (_realtimeMultiplayer == null) {
            _realtimeMultiplayer = new RealtimeMultiplayer();
        }
        return _realtimeMultiplayer;
    }

    public static TurnBasedMultiplayer turnBasedMultiplayerInstance() {
        if (_turnBasedMultiplayer == null) {
            _turnBasedMultiplayer = new TurnBasedMultiplayer();
        }
        return _turnBasedMultiplayer;
    }

    public PlayGameServicesPluginBase() {
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
        Log.i(TAG, "UnitySendMessage: GPGManager, " + m + ", " + p);
    }

    protected void UnitySendMultiplayerMessage(String m, String p) {
        if (p == null) {
            p = "";
        }
        if (this._unitySendMessageMethod != null) {
            try {
                this._unitySendMessageMethod.invoke(null, MULTIPLAYER_MANAGER_NAME, m, p);
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
        Log.i(TAG, "UnitySendMessage: GPGMultiplayerManager, " + m + ", " + p);
    }

    protected void UnitySendTBMultiplayerMessage(String m, String p) {
        if (p == null) {
            p = "";
        }
        if (this._unitySendMessageMethod != null) {
            try {
                this._unitySendMessageMethod.invoke(null, TURN_BASED_MANAGER_NAME, m, p);
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
        Log.i(TAG, "UnitySendMessage: GPGTurnBasedManager, " + m + ", " + p);
    }

    protected void runSafelyOnUiThread(Runnable r) {
        runSafelyOnUiThread(r, null);
    }

    protected void runSafelyOnUiThread(final Runnable r, final String methodName) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.prime31.PlayGameServicesPluginBase.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    r.run();
                } catch (Exception e) {
                    if (methodName != null) {
                        PlayGameServicesPluginBase.this.UnitySendMessage(methodName, e.getMessage());
                    }
                    Log.e(PlayGameServicesPluginBase.TAG, "Exception running command on UI thread: " + e.getMessage());
                }
            }
        });
    }

    protected String jsonize(HashMap<String, Object> map) {
        try {
            JSONObject json = new JSONObject(map);
            return json.toString();
        } catch (Exception e) {
            Log.i(TAG, "Error creating JSON" + e.getMessage());
            return "{}";
        }
    }

    protected String jsonizeIdentiferAndError(String identifier, String error) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(SettingsJsonConstants.APP_IDENTIFIER_KEY, identifier);
        map.put("error", error);
        return jsonize(map);
    }

    protected String jsonizeCloudData(int key, String data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", Integer.valueOf(key));
        map.put(ShareConstants.WEB_DIALOG_PARAM_DATA, data);
        return jsonize(map);
    }
}
