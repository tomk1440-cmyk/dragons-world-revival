package com.unity3d.ads;

import android.app.Activity;
import android.os.Build;
import com.unity3d.ads.adunit.AdUnitOpen;
import com.unity3d.ads.api.AdUnit;
import com.unity3d.ads.api.Broadcast;
import com.unity3d.ads.api.Cache;
import com.unity3d.ads.api.Connectivity;
import com.unity3d.ads.api.DeviceInfo;
import com.unity3d.ads.api.Intent;
import com.unity3d.ads.api.Lifecycle;
import com.unity3d.ads.api.Listener;
import com.unity3d.ads.api.Placement;
import com.unity3d.ads.api.Request;
import com.unity3d.ads.api.Resolve;
import com.unity3d.ads.api.Sdk;
import com.unity3d.ads.api.Storage;
import com.unity3d.ads.api.VideoPlayer;
import com.unity3d.ads.cache.CacheThread;
import com.unity3d.ads.configuration.Configuration;
import com.unity3d.ads.configuration.EnvironmentCheck;
import com.unity3d.ads.configuration.InitializeThread;
import com.unity3d.ads.connectivity.ConnectivityMonitor;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.Utilities;
import com.unity3d.ads.properties.ClientProperties;
import com.unity3d.ads.properties.SdkProperties;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class UnityAds {
    private static boolean _configurationInitialized = false;
    private static boolean _debugMode = false;

    public enum FinishState {
        ERROR,
        SKIPPED,
        COMPLETED
    }

    public enum PlacementState {
        READY,
        NOT_AVAILABLE,
        DISABLED,
        WAITING,
        NO_FILL
    }

    public enum UnityAdsError {
        NOT_INITIALIZED,
        INITIALIZE_FAILED,
        INVALID_ARGUMENT,
        VIDEO_PLAYER_ERROR,
        INIT_SANITY_CHECK_FAIL,
        AD_BLOCKER_DETECTED,
        FILE_IO_ERROR,
        DEVICE_ID_ERROR,
        SHOW_ERROR,
        INTERNAL_ERROR
    }

    public static void initialize(Activity activity, String gameId, IUnityAdsListener listener) {
        initialize(activity, gameId, listener, false);
    }

    public static void initialize(Activity activity, String gameId, IUnityAdsListener listener, boolean testMode) {
        DeviceLog.entered();
        if (_configurationInitialized) {
            if (ClientProperties.getGameId() != null && !ClientProperties.getGameId().equals(gameId)) {
                DeviceLog.warning("You are trying to re-initialize with a different gameId");
                return;
            }
            return;
        }
        _configurationInitialized = true;
        if (!isSupported()) {
            DeviceLog.error("Error while initializing Unity Ads: device is not supported");
            return;
        }
        SdkProperties.setInitializationTime(System.currentTimeMillis());
        if (gameId == null || gameId.length() == 0) {
            DeviceLog.error("Error while initializing Unity Ads: empty game ID, halting Unity Ads init");
            if (listener != null) {
                listener.onUnityAdsError(UnityAdsError.INVALID_ARGUMENT, "Empty game ID");
                return;
            }
            return;
        }
        if (activity == null) {
            DeviceLog.error("Error while initializing Unity Ads: null activity, halting Unity Ads init");
            if (listener != null) {
                listener.onUnityAdsError(UnityAdsError.INVALID_ARGUMENT, "Null activity");
                return;
            }
            return;
        }
        if (testMode) {
            DeviceLog.info("Initializing Unity Ads " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + gameId + " in test mode");
        } else {
            DeviceLog.info("Initializing Unity Ads " + SdkProperties.getVersionName() + " (" + SdkProperties.getVersionCode() + ") with game id " + gameId + " in production mode");
        }
        setDebugMode(_debugMode);
        ClientProperties.setGameId(gameId);
        ClientProperties.setListener(listener);
        ClientProperties.setApplicationContext(activity.getApplicationContext());
        ClientProperties.setApplication(activity.getApplication());
        SdkProperties.setTestMode(testMode);
        if (EnvironmentCheck.isEnvironmentOk()) {
            DeviceLog.info("Unity Ads environment check OK");
            Configuration configuration = new Configuration();
            Class[] apiClassList = {AdUnit.class, Broadcast.class, Cache.class, Connectivity.class, DeviceInfo.class, Listener.class, Storage.class, Sdk.class, Request.class, Resolve.class, VideoPlayer.class, Placement.class, Intent.class, Lifecycle.class};
            configuration.setWebAppApiClassList(apiClassList);
            InitializeThread.initialize(configuration);
            return;
        }
        DeviceLog.error("Error during Unity Ads environment check, halting Unity Ads init");
        if (listener != null) {
            listener.onUnityAdsError(UnityAdsError.INIT_SANITY_CHECK_FAIL, "Unity Ads init environment check failed");
        }
    }

    public static boolean isInitialized() {
        return SdkProperties.isInitialized();
    }

    public static void setListener(IUnityAdsListener listener) {
        ClientProperties.setListener(listener);
    }

    public static IUnityAdsListener getListener() {
        return ClientProperties.getListener();
    }

    public static boolean isSupported() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static String getVersion() {
        return SdkProperties.getVersionName();
    }

    public static boolean isReady() {
        return isSupported() && isInitialized() && com.unity3d.ads.placement.Placement.isReady();
    }

    public static boolean isReady(String placementId) {
        return isSupported() && isInitialized() && placementId != null && com.unity3d.ads.placement.Placement.isReady(placementId);
    }

    public static PlacementState getPlacementState() {
        return (isSupported() && isInitialized()) ? com.unity3d.ads.placement.Placement.getPlacementState() : PlacementState.NOT_AVAILABLE;
    }

    public static PlacementState getPlacementState(String placementId) {
        return (isSupported() && isInitialized() && placementId != null) ? com.unity3d.ads.placement.Placement.getPlacementState(placementId) : PlacementState.NOT_AVAILABLE;
    }

    public static void show(Activity activity) {
        show(activity, com.unity3d.ads.placement.Placement.getDefaultPlacement());
    }

    public static void show(final Activity activity, final String placementId) {
        if (activity == null) {
            handleShowError(placementId, UnityAdsError.INVALID_ARGUMENT, "Activity must not be null");
            return;
        }
        if (isReady(placementId)) {
            DeviceLog.info("Unity Ads opening new ad unit for placement " + placementId);
            ClientProperties.setActivity(activity);
            new Thread(new Runnable() { // from class: com.unity3d.ads.UnityAds.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject options = new JSONObject();
                    try {
                        options.put("requestedOrientation", activity.getRequestedOrientation());
                    } catch (JSONException e) {
                        DeviceLog.exception("JSON error while constructing show options", e);
                    }
                    try {
                        if (!AdUnitOpen.open(placementId, options)) {
                            UnityAds.handleShowError(placementId, UnityAdsError.INTERNAL_ERROR, "Webapp timeout, shutting down Unity Ads");
                            com.unity3d.ads.placement.Placement.reset();
                            CacheThread.cancel();
                            ConnectivityMonitor.stopAll();
                        }
                    } catch (NoSuchMethodException exception) {
                        DeviceLog.exception("Could not get callback method", exception);
                        UnityAds.handleShowError(placementId, UnityAdsError.SHOW_ERROR, "Could not get com.unity3d.ads.properties.showCallback method");
                    }
                }
            }).start();
        } else if (!isSupported()) {
            handleShowError(placementId, UnityAdsError.NOT_INITIALIZED, "Unity Ads is not supported for this device");
        } else if (!isInitialized()) {
            handleShowError(placementId, UnityAdsError.NOT_INITIALIZED, "Unity Ads is not initialized");
        } else {
            handleShowError(placementId, UnityAdsError.SHOW_ERROR, "Placement \"" + placementId + "\" is not ready");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleShowError(final String placementId, final UnityAdsError error, String message) {
        final String errorMessage = "Unity Ads show failed: " + message;
        DeviceLog.error(errorMessage);
        final IUnityAdsListener listener = ClientProperties.getListener();
        if (listener != null) {
            Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.ads.UnityAds.2
                @Override // java.lang.Runnable
                public void run() {
                    listener.onUnityAdsError(error, errorMessage);
                    listener.onUnityAdsFinish(placementId, FinishState.ERROR);
                }
            });
        }
    }

    public static void setDebugMode(boolean debugMode) {
        _debugMode = debugMode;
        if (debugMode) {
            DeviceLog.setLogLevel(8);
        } else {
            DeviceLog.setLogLevel(4);
        }
    }

    public static boolean getDebugMode() {
        return _debugMode;
    }
}
