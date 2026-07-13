package com.unity3d.ads.webview.bridge;

import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.webview.WebViewApp;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NativeCallback {
    private static AtomicInteger _callbackCount = new AtomicInteger(0);
    private Method _callback;
    private String _id;

    public NativeCallback(Method callback) {
        this._callback = callback;
        this._id = this._callback.getName().toUpperCase(Locale.US) + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + _callbackCount.getAndIncrement();
    }

    public String getId() {
        return this._id;
    }

    public void invoke(String status, Object... values) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object[] values2;
        try {
            Object cbs = CallbackStatus.valueOf(status);
            if (values == null) {
                values2 = new Object[]{cbs};
            } else {
                ArrayList<Object> tmpAr = new ArrayList<>(Arrays.asList(values));
                tmpAr.add(0, cbs);
                values2 = tmpAr.toArray();
            }
            this._callback.invoke(null, values2);
            WebViewApp.getCurrentApp().removeCallback(this);
        } catch (Exception e) {
            DeviceLog.error("Illegal status");
            WebViewApp.getCurrentApp().removeCallback(this);
            throw e;
        }
    }
}
