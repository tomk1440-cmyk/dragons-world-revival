package com.socialquantum.dw.mainactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ActivityProxyObjectHelper {
    private Activity _context;
    private List<Class<?>> _proxyClasses = new ArrayList();
    private String TAG = "MainActivity";

    public ActivityProxyObjectHelper(Activity context) {
        this._context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        Log.i(this.TAG, "Creating extentions ::: ");
        try {
            ApplicationInfo ai = this._context.getPackageManager().getApplicationInfo(this._context.getPackageName(), 128);
            Bundle bundle = ai.metaData;
            Log.i(this.TAG, "creation metaData size : " + bundle.keySet().size());
            for (String key : bundle.keySet()) {
                Log.i(this.TAG, "creation bundle keyset : " + key);
                try {
                    Object bundleValue = bundle.get(key);
                    if (bundleValue instanceof String) {
                        String value = (String) bundleValue;
                        Log.w(this.TAG, value);
                        if (value.equalsIgnoreCase("PlayGameService")) {
                            try {
                                Log.w(this.TAG, "0 - " + key);
                                Class<?> cls = Class.forName(key);
                                Log.w(this.TAG, "1 - " + key);
                                this._proxyClasses.add(cls);
                                Log.i(this.TAG, "found Activity proxy class: " + cls);
                            } catch (ClassNotFoundException e) {
                                Log.e(this.TAG, "no proxy class found for " + key);
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.i(this.TAG, "Failed to load meta-data, NameNotFound: " + e3.getMessage());
        } catch (NullPointerException e4) {
            Log.e(this.TAG, "Failed to load meta-data, NullPointer: " + e4.getMessage());
        }
        for (Class<?> cls2 : this._proxyClasses) {
            try {
                Log.i(this.TAG, "onCreate ::: " + cls2);
                Method m = cls2.getMethod("onCreate", Bundle.class);
                m.invoke(null, savedInstanceState);
            } catch (Exception e5) {
            }
        }
    }

    protected void onNewIntent(Intent intent) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onNewIntent", Intent.class);
                m.invoke(null, intent);
            } catch (Exception e) {
            }
        }
    }

    protected void onActivityResult(int request, int response, Intent data) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onActivityResult", Integer.TYPE, Integer.TYPE, Intent.class);
                m.invoke(null, Integer.valueOf(request), Integer.valueOf(response), data);
            } catch (Exception e) {
            }
        }
    }

    protected void invokeZeroParameterMethod(String method) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod(method, new Class[0]);
                m.invoke(null, new Object[0]);
            } catch (Exception e) {
            }
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onSaveInstanceState", Bundle.class);
                m.invoke(null, savedInstanceState);
            } catch (Exception e) {
            }
        }
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onRestoreInstanceState", Bundle.class);
                m.invoke(null, savedInstanceState);
            } catch (Exception e) {
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onConfigurationChanged", Configuration.class);
                m.invoke(null, newConfig);
            } catch (Exception e) {
            }
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onWindowFocusChanged", Boolean.TYPE);
                m.invoke(null, Boolean.valueOf(hasFocus));
            } catch (Exception e) {
            }
        }
    }

    public void onKeyDown(int keyCode, KeyEvent event) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onKeyDown", Integer.TYPE, KeyEvent.class);
                m.invoke(null, Integer.valueOf(keyCode), event);
            } catch (Exception e) {
            }
        }
    }

    public void onKeyUp(int keyCode, KeyEvent event) {
        Iterator<Class<?>> it = this._proxyClasses.iterator();
        while (it.hasNext()) {
            try {
                Method m = it.next().getMethod("onKeyDown", Integer.TYPE, KeyEvent.class);
                m.invoke(null, Integer.valueOf(keyCode), event);
            } catch (Exception e) {
            }
        }
    }
}
