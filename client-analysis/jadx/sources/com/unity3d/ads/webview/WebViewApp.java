package com.unity3d.ads.webview;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Looper;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;
import com.unity3d.ads.configuration.Configuration;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.Utilities;
import com.unity3d.ads.properties.ClientProperties;
import com.unity3d.ads.properties.SdkProperties;
import com.unity3d.ads.webview.bridge.CallbackStatus;
import com.unity3d.ads.webview.bridge.Invocation;
import com.unity3d.ads.webview.bridge.NativeCallback;
import com.unity3d.ads.webview.bridge.WebViewBridge;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class WebViewApp extends WebViewClient {
    private static ConditionVariable _conditionVariable;
    private static WebViewApp _currentApp;
    private Configuration _configuration;
    private boolean _initialized;
    private HashMap<String, NativeCallback> _nativeCallbacks;
    private boolean _webAppLoaded;
    private WebView _webView;

    private WebViewApp(Configuration configuration) {
        this._webAppLoaded = false;
        this._initialized = false;
        setConfiguration(configuration);
        WebViewBridge.setClassTable(getConfiguration().getWebAppApiClassList());
        this._webView = new WebView(ClientProperties.getApplicationContext());
        this._webView.setWebViewClient(new WebAppClient());
        this._webView.setWebChromeClient(new WebAppChromeClient());
    }

    public WebViewApp() {
        this._webAppLoaded = false;
        this._initialized = false;
    }

    public void setWebAppLoaded(boolean loaded) {
        this._webAppLoaded = loaded;
    }

    public boolean isWebAppLoaded() {
        return this._webAppLoaded;
    }

    public void setWebAppInitialized(boolean initialized) {
        this._initialized = initialized;
        _conditionVariable.open();
    }

    public boolean isWebAppInitialized() {
        return this._initialized;
    }

    public WebView getWebView() {
        return this._webView;
    }

    public void setWebView(WebView webView) {
        this._webView = webView;
    }

    public Configuration getConfiguration() {
        return this._configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this._configuration = configuration;
    }

    private void invokeJavascriptMethod(String className, String methodName, JSONArray params) throws JSONException {
        String javaScriptString = "javascript:window." + className + "." + methodName + "(" + params.toString() + ");";
        DeviceLog.debug("Invoking javascript: " + javaScriptString);
        getWebView().invokeJavascript(javaScriptString);
    }

    public boolean sendEvent(Enum eventCategory, Enum eventId, Object... params) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("sendEvent ignored because web app is not loaded");
            return false;
        }
        JSONArray paramList = new JSONArray();
        paramList.put(eventCategory.name());
        paramList.put(eventId.name());
        for (Object o : params) {
            paramList.put(o);
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleEvent", paramList);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error while sending event to WebView", e);
            return false;
        }
    }

    public boolean invokeMethod(String className, String methodName, Method callback, Object... params) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeMethod ignored because web app is not loaded");
            return false;
        }
        JSONArray paramList = new JSONArray();
        paramList.put(className);
        paramList.put(methodName);
        if (callback != null) {
            NativeCallback nativeCallback = new NativeCallback(callback);
            addCallback(nativeCallback);
            paramList.put(nativeCallback.getId());
        } else {
            paramList.put((Object) null);
        }
        if (params != null) {
            for (Object o : params) {
                paramList.put(o);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleInvocation", paramList);
            return true;
        } catch (Exception e) {
            DeviceLog.exception("Error invoking javascript method", e);
            return false;
        }
    }

    public boolean invokeCallback(Invocation invocation) {
        if (!isWebAppLoaded()) {
            DeviceLog.debug("invokeBatchCallback ignored because web app is not loaded");
            return false;
        }
        JSONArray responseList = new JSONArray();
        ArrayList<ArrayList<Object>> responses = invocation.getResponses();
        if (responses != null && !responses.isEmpty()) {
            for (ArrayList<Object> response : responses) {
                CallbackStatus status = (CallbackStatus) response.get(0);
                Enum error = (Enum) response.get(1);
                Object[] params = (Object[]) response.get(2);
                Object callbackId = (String) params[0];
                Object[] params2 = Arrays.copyOfRange(params, 1, params.length);
                ArrayList<Object> tmp = new ArrayList<>();
                tmp.add(callbackId);
                tmp.add(status.toString());
                JSONArray paramArray = new JSONArray();
                if (error != null) {
                    paramArray.put(error.name());
                }
                for (Object o : params2) {
                    paramArray.put(o);
                }
                tmp.add(paramArray);
                JSONArray paramList = new JSONArray();
                for (Object o2 : tmp) {
                    paramList.put(o2);
                }
                responseList.put(paramList);
            }
        }
        try {
            invokeJavascriptMethod("nativebridge", "handleCallback", responseList);
        } catch (Exception e) {
            DeviceLog.exception("Error while invoking batch response for WebView", e);
        }
        return true;
    }

    public void addCallback(NativeCallback callback) {
        if (this._nativeCallbacks == null) {
            this._nativeCallbacks = new HashMap<>();
        }
        synchronized (this._nativeCallbacks) {
            this._nativeCallbacks.put(callback.getId(), callback);
        }
    }

    public void removeCallback(NativeCallback callback) {
        if (this._nativeCallbacks != null) {
            synchronized (this._nativeCallbacks) {
                this._nativeCallbacks.remove(callback.getId());
            }
        }
    }

    public NativeCallback getCallback(String callbackId) {
        NativeCallback nativeCallback;
        synchronized (this._nativeCallbacks) {
            nativeCallback = this._nativeCallbacks.get(callbackId);
        }
        return nativeCallback;
    }

    public static WebViewApp getCurrentApp() {
        return _currentApp;
    }

    public static void setCurrentApp(WebViewApp app) {
        _currentApp = app;
    }

    public static boolean create(final Configuration configuration) throws IllegalThreadStateException {
        DeviceLog.entered();
        if (Thread.currentThread().equals(Looper.getMainLooper().getThread())) {
            throw new IllegalThreadStateException("Cannot call create() from main thread!");
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.ads.webview.WebViewApp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    WebViewApp webViewApp = new WebViewApp(configuration);
                    String queryString = "?platform=android";
                    try {
                        if (configuration.getWebViewUrl() != null) {
                            queryString = "?platform=android&origin=" + URLEncoder.encode(configuration.getWebViewUrl(), "UTF-8");
                        }
                    } catch (UnsupportedEncodingException e) {
                        DeviceLog.exception("Unsupported charset when encoding origin url", e);
                    }
                    try {
                        if (configuration.getWebViewVersion() != null) {
                            queryString = queryString + "&version=" + URLEncoder.encode(configuration.getWebViewVersion(), "UTF-8");
                        }
                    } catch (UnsupportedEncodingException e2) {
                        DeviceLog.exception("Unsupported charset when encoding webview version", e2);
                    }
                    webViewApp.getWebView().loadDataWithBaseURL("file://" + SdkProperties.getLocalWebViewFile() + queryString, configuration.getWebViewData(), "text/html", "UTF-8", null);
                    WebViewApp.setCurrentApp(webViewApp);
                } catch (Exception e3) {
                    DeviceLog.error("Couldn't construct WebViewApp");
                    WebViewApp._conditionVariable.open();
                }
            }
        });
        _conditionVariable = new ConditionVariable();
        return _conditionVariable.block(60000L) && getCurrentApp() != null;
    }

    private class WebAppClient extends WebViewClient {
        private WebAppClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(android.webkit.WebView webview, String url) {
            super.onPageFinished(webview, url);
            DeviceLog.debug("onPageFinished url: " + url);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            DeviceLog.debug("Trying to load url: " + url);
            return false;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(android.webkit.WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            if (view != null) {
                DeviceLog.error("WEBVIEW_ERROR: " + view.toString());
            }
            if (request != null) {
                DeviceLog.error("WEBVIEW_ERROR: " + request.toString());
            }
            if (error != null) {
                DeviceLog.error("WEBVIEW_ERROR: " + error.toString());
            }
        }
    }

    private class WebAppChromeClient extends WebChromeClient {
        private WebAppChromeClient() {
        }

        @Override // android.webkit.WebChromeClient
        public void onConsoleMessage(String message, int lineNumber, String sourceID) {
            String sourceFile = sourceID;
            File tmp = null;
            try {
                File tmp2 = new File(sourceID);
                tmp = tmp2;
            } catch (Exception e) {
                DeviceLog.exception("Could not handle sourceId", e);
            }
            if (tmp != null) {
                sourceFile = tmp.getName();
            }
            if (Build.VERSION.SDK_INT < 19) {
                DeviceLog.debug("JavaScript (sourceId=" + sourceFile + ", line=" + lineNumber + "): " + message);
            }
        }
    }
}
