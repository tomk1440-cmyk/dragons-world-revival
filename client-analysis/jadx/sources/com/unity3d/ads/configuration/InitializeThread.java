package com.unity3d.ads.configuration;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.ConditionVariable;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.api.Lifecycle;
import com.unity3d.ads.broadcast.BroadcastMonitor;
import com.unity3d.ads.cache.CacheThread;
import com.unity3d.ads.connectivity.ConnectivityMonitor;
import com.unity3d.ads.connectivity.IConnectivityListener;
import com.unity3d.ads.device.AdvertisingId;
import com.unity3d.ads.device.StorageManager;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.Utilities;
import com.unity3d.ads.placement.Placement;
import com.unity3d.ads.properties.ClientProperties;
import com.unity3d.ads.properties.SdkProperties;
import com.unity3d.ads.request.WebRequest;
import com.unity3d.ads.request.WebRequestThread;
import com.unity3d.ads.webview.WebViewApp;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class InitializeThread extends Thread {
    private static InitializeThread _thread;
    private InitializeState _state;
    private boolean _stopThread = false;

    private InitializeThread(InitializeState state) {
        this._state = state;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this._state != null && !(this._state instanceof InitializeStateComplete) && !this._stopThread) {
            this._state = this._state.execute();
        }
        _thread = null;
    }

    public void quit() {
        this._stopThread = true;
    }

    public static synchronized void initialize(Configuration configuration) {
        if (_thread == null) {
            _thread = new InitializeThread(new InitializeStateReset(configuration));
            _thread.setName("UnityAdsInitializeThread");
            _thread.start();
        }
    }

    private static abstract class InitializeState {
        public abstract InitializeState execute();

        private InitializeState() {
        }
    }

    public static class InitializeStateReset extends InitializeState {
        private Configuration _configuration;

        public InitializeStateReset(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: starting init");
            final ConditionVariable cv = new ConditionVariable();
            final WebViewApp currentApp = WebViewApp.getCurrentApp();
            boolean success = true;
            if (currentApp != null) {
                currentApp.setWebAppLoaded(false);
                currentApp.setWebAppInitialized(false);
                if (currentApp.getWebView() != null) {
                    Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.ads.configuration.InitializeThread.InitializeStateReset.1
                        @Override // java.lang.Runnable
                        public void run() {
                            currentApp.getWebView().destroy();
                            currentApp.setWebView(null);
                            cv.open();
                        }
                    });
                    success = cv.block(10000L);
                }
                if (!success) {
                    return new InitializeStateError("reset webapp", new Exception("Reset failed on opening ConditionVariable"));
                }
            }
            if (Build.VERSION.SDK_INT > 13) {
                unregisterLifecycleCallbacks();
            }
            SdkProperties.setInitialized(false);
            Placement.reset();
            BroadcastMonitor.removeAllBroadcastListeners();
            CacheThread.cancel();
            WebRequestThread.cancel();
            ConnectivityMonitor.stopAll();
            StorageManager.init(ClientProperties.getApplicationContext());
            AdvertisingId.init(ClientProperties.getApplicationContext());
            this._configuration.setConfigUrl(SdkProperties.getConfigUrl());
            return new InitializeStateAdBlockerCheck(this._configuration);
        }

        @TargetApi(14)
        private void unregisterLifecycleCallbacks() {
            if (Lifecycle.getLifecycleListener() != null) {
                if (ClientProperties.getApplication() != null) {
                    ClientProperties.getApplication().unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
                }
                Lifecycle.setLifecycleListener(null);
            }
        }
    }

    public static class InitializeStateAdBlockerCheck extends InitializeState {
        private InetAddress _address;
        private Configuration _configuration;

        public InitializeStateAdBlockerCheck(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        /* JADX WARN: Type inference failed for: r5v3, types: [com.unity3d.ads.configuration.InitializeThread$InitializeStateAdBlockerCheck$1] */
        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: checking for ad blockers");
            try {
                final String configHost = new URL(this._configuration.getConfigUrl()).getHost();
                final ConditionVariable cv = new ConditionVariable();
                new Thread() { // from class: com.unity3d.ads.configuration.InitializeThread.InitializeStateAdBlockerCheck.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            InitializeStateAdBlockerCheck.this._address = InetAddress.getByName(configHost);
                            cv.open();
                        } catch (Exception e) {
                            DeviceLog.exception("Couldn't get address. Host: " + configHost, e);
                            cv.open();
                        }
                    }
                }.start();
                boolean success = cv.block(2000L);
                if (success && this._address != null && this._address.isLoopbackAddress()) {
                    DeviceLog.error("Unity Ads init: halting init because Unity Ads config resolves to loopback address (due to ad blocker?)");
                    final IUnityAdsListener listener = UnityAds.getListener();
                    if (listener != null) {
                        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.ads.configuration.InitializeThread.InitializeStateAdBlockerCheck.2
                            @Override // java.lang.Runnable
                            public void run() {
                                listener.onUnityAdsError(UnityAds.UnityAdsError.AD_BLOCKER_DETECTED, "Unity Ads config server resolves to loopback address (due to ad blocker?)");
                            }
                        });
                    }
                    return null;
                }
                return new InitializeStateConfig(this._configuration);
            } catch (MalformedURLException e) {
                return new InitializeStateConfig(this._configuration);
            }
        }
    }

    public static class InitializeStateConfig extends InitializeState {
        private Configuration _configuration;
        private int _maxRetries;
        private int _retries;
        private int _retryDelay;

        public InitializeStateConfig(Configuration configuration) {
            super();
            this._retries = 0;
            this._maxRetries = 6;
            this._retryDelay = 5;
            this._configuration = configuration;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
            try {
                this._configuration.makeRequest();
                return new InitializeStateLoadCache(this._configuration);
            } catch (Exception e) {
                if (this._retries < this._maxRetries) {
                    this._retryDelay *= 2;
                    this._retries++;
                    return new InitializeStateRetry(this, this._retryDelay);
                }
                return new InitializeStateNetworkError(e, this);
            }
        }
    }

    public static class InitializeStateLoadCache extends InitializeState {
        private Configuration _configuration;

        public InitializeStateLoadCache(Configuration configuration) {
            super();
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            try {
                byte[] localWebViewData = Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
                String localWebViewHash = Utilities.Sha256(localWebViewData);
                if (localWebViewHash != null && localWebViewHash.equals(this._configuration.getWebViewHash())) {
                    try {
                        String webViewDataString = new String(localWebViewData, "UTF-8");
                        DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                        return new InitializeStateCreate(this._configuration, webViewDataString);
                    } catch (UnsupportedEncodingException e) {
                        return new InitializeStateError("load cache", e);
                    }
                }
                return new InitializeStateLoadWeb(this._configuration);
            } catch (IOException e2) {
                DeviceLog.debug("Unity Ads init: webapp not found in local cache: " + e2.getMessage());
                return new InitializeStateLoadWeb(this._configuration);
            }
        }
    }

    public static class InitializeStateLoadWeb extends InitializeState {
        private Configuration _configuration;
        private int _maxRetries;
        private int _retries;
        private int _retryDelay;

        public InitializeStateLoadWeb(Configuration configuration) {
            super();
            this._retries = 0;
            this._maxRetries = 6;
            this._retryDelay = 5;
            this._configuration = configuration;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() throws Throwable {
            DeviceLog.info("Unity Ads init: loading webapp from " + this._configuration.getWebViewUrl());
            try {
                WebRequest request = new WebRequest(this._configuration.getWebViewUrl(), HttpRequest.METHOD_GET, null);
                try {
                    String webViewData = request.makeRequest();
                    String webViewHash = this._configuration.getWebViewHash();
                    if (webViewHash != null && !Utilities.Sha256(webViewData).equals(webViewHash)) {
                        return new InitializeStateError("load web", new Exception("Invalid webViewHash"));
                    }
                    if (webViewHash != null) {
                        Utilities.writeFile(new File(SdkProperties.getLocalWebViewFile()), webViewData);
                    }
                    return new InitializeStateCreate(this._configuration, webViewData);
                } catch (Exception e) {
                    if (this._retries < this._maxRetries) {
                        this._retryDelay *= 2;
                        this._retries++;
                        return new InitializeStateRetry(this, this._retryDelay);
                    }
                    return new InitializeStateNetworkError(e, this);
                }
            } catch (MalformedURLException e2) {
                DeviceLog.exception("Malformed URL", e2);
                return new InitializeStateError("make webrequest", e2);
            }
        }
    }

    public static class InitializeStateCreate extends InitializeState {
        private Configuration _configuration;
        private String _webViewData;

        public InitializeStateCreate(Configuration configuration, String webViewData) {
            super();
            this._configuration = configuration;
            this._webViewData = webViewData;
        }

        public Configuration getConfiguration() {
            return this._configuration;
        }

        public String getWebData() {
            return this._webViewData;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration configuration = this._configuration;
            configuration.setWebViewData(this._webViewData);
            try {
                boolean createSuccessFull = WebViewApp.create(configuration);
                if (createSuccessFull) {
                    return new InitializeStateComplete();
                }
                DeviceLog.error("Unity Ads WebApp creation failed!");
                return new InitializeStateError("create webapp", new Exception("Creation of WebApp failed!"));
            } catch (IllegalThreadStateException e) {
                DeviceLog.exception("Illegal Thread", e);
                return new InitializeStateError("create webapp", e);
            }
        }
    }

    public static class InitializeStateComplete extends InitializeState {
        public InitializeStateComplete() {
            super();
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            return null;
        }
    }

    public static class InitializeStateError extends InitializeState {
        Exception _exception;
        String _state;

        public InitializeStateError(String state, Exception exception) {
            super();
            this._state = state;
            this._exception = exception;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.error("Unity Ads init: halting init in " + this._state + ": " + this._exception.getMessage());
            final IUnityAdsListener listener = UnityAds.getListener();
            final String message = "Init failed in " + this._state;
            if (UnityAds.getListener() != null) {
                Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.ads.configuration.InitializeThread.InitializeStateError.1
                    @Override // java.lang.Runnable
                    public void run() {
                        listener.onUnityAdsError(UnityAds.UnityAdsError.INITIALIZE_FAILED, message);
                    }
                });
                return null;
            }
            return null;
        }
    }

    public static class InitializeStateNetworkError extends InitializeStateError implements IConnectivityListener {
        protected static final int CONNECTED_EVENT_THRESHOLD_MS = 10000;
        protected static final int MAX_CONNECTED_EVENTS = 500;
        private ConditionVariable _conditionVariable;
        private InitializeState _erroredState;
        private static int _receivedConnectedEvents = 0;
        private static long _lastConnectedEventTimeMs = 0;

        public InitializeStateNetworkError(Exception exception, InitializeState erroredState) {
            super("network error", exception);
            this._erroredState = erroredState;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeStateError, com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.error("Unity Ads init: network error, waiting for connection events");
            this._conditionVariable = new ConditionVariable();
            ConnectivityMonitor.addListener(this);
            if (this._conditionVariable.block(600000L)) {
                ConnectivityMonitor.removeListener(this);
                return this._erroredState;
            }
            ConnectivityMonitor.removeListener(this);
            return new InitializeStateError("network error", new Exception("No connected events within the timeout!"));
        }

        @Override // com.unity3d.ads.connectivity.IConnectivityListener
        public void onConnected() {
            _receivedConnectedEvents++;
            DeviceLog.debug("Unity Ads init got connected event");
            if (shouldHandleConnectedEvent()) {
                this._conditionVariable.open();
            }
            if (_receivedConnectedEvents > MAX_CONNECTED_EVENTS) {
                ConnectivityMonitor.removeListener(this);
            }
            _lastConnectedEventTimeMs = System.currentTimeMillis();
        }

        @Override // com.unity3d.ads.connectivity.IConnectivityListener
        public void onDisconnected() {
            DeviceLog.debug("Unity Ads init got disconnected event");
        }

        private boolean shouldHandleConnectedEvent() {
            return System.currentTimeMillis() - _lastConnectedEventTimeMs >= 10000 && _receivedConnectedEvents <= MAX_CONNECTED_EVENTS;
        }
    }

    public static class InitializeStateRetry extends InitializeState {
        int _delay;
        InitializeState _state;

        public InitializeStateRetry(InitializeState state, int delay) {
            super();
            this._state = state;
            this._delay = delay;
        }

        @Override // com.unity3d.ads.configuration.InitializeThread.InitializeState
        public InitializeState execute() {
            DeviceLog.debug("Unity Ads init: retrying in " + this._delay + " seconds");
            try {
                Thread.sleep(((long) this._delay) * 1000);
            } catch (InterruptedException e) {
                DeviceLog.exception("Init retry interrupted", e);
            }
            return this._state;
        }
    }
}
