package com.unity3d.ads.configuration;

import android.os.Build;
import android.webkit.JavascriptInterface;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.properties.SdkProperties;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class EnvironmentCheck {
    public static boolean isEnvironmentOk() {
        return testProGuard() && testCacheDirectory();
    }

    public static boolean testProGuard() {
        boolean z = true;
        try {
            Class<?> webBridge = Class.forName("com.unity3d.ads.webview.bridge.WebViewBridgeInterface");
            Method handleInvocation = webBridge.getMethod("handleInvocation", String.class);
            Method handleCallback = webBridge.getMethod("handleCallback", String.class, String.class, String.class);
            if (hasJavascriptInterface(handleInvocation) && hasJavascriptInterface(handleCallback)) {
                DeviceLog.debug("Unity Ads ProGuard check OK");
            } else {
                DeviceLog.error("Unity Ads ProGuard check fail: missing @JavascriptInterface annotations in Unity Ads web bridge");
                z = false;
            }
            return z;
        } catch (ClassNotFoundException e) {
            DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge class not found", e);
            return false;
        } catch (NoSuchMethodException e2) {
            DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge methods not found", e2);
            return false;
        } catch (Exception e3) {
            DeviceLog.exception("Unknown exception during Unity Ads ProGuard check: " + e3.getMessage(), e3);
            return z;
        }
    }

    public static boolean testCacheDirectory() {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        if (cacheDirectory != null) {
            DeviceLog.debug("Unity Ads cache directory check OK");
            return true;
        }
        DeviceLog.error("Unity Ads cache directory check fail: no working cache directory available");
        return false;
    }

    private static boolean hasJavascriptInterface(Method m) {
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        }
        Annotation[] annotations = m.getAnnotations();
        if (annotations != null) {
            for (Annotation a : annotations) {
                if (a instanceof JavascriptInterface) {
                    return true;
                }
            }
        }
        return false;
    }
}
