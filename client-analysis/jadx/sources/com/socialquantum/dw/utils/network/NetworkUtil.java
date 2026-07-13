package com.socialquantum.dw.utils.network;

import android.util.Log;
import com.socialquantum.dw.utils.exception.UnhandledExceptionHandler;

/* JADX INFO: loaded from: classes.dex */
public class NetworkUtil {
    public static String getProxy() {
        String host = System.getProperty("http.proxyHost");
        String port = System.getProperty("http.proxyPort");
        Log.i("proxyHelper", "proxy " + host + ":" + port);
        return (host == null || host == "") ? "" : host + ":" + port;
    }

    public static int invokeException() {
        return 1 / 0;
    }

    public static void invoke() {
        Thread.setDefaultUncaughtExceptionHandler(new UnhandledExceptionHandler("NetworkPlugin"));
    }
}
