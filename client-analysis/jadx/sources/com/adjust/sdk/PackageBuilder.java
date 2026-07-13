package com.adjust.sdk;

import android.content.ContentResolver;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class PackageBuilder {
    private static ILogger logger = AdjustFactory.getLogger();
    private ActivityStateCopy activityStateCopy;
    private AdjustConfig adjustConfig;
    AdjustAttribution attribution;
    long clickTime;
    private long createdAt;
    String deeplink;
    private DeviceInfo deviceInfo;
    Map<String, String> extraParameters;
    String referrer;
    String reftag;

    private class ActivityStateCopy {
        int eventCount;
        long lastInterval;
        String pushToken;
        int sessionCount;
        long sessionLength;
        int subsessionCount;
        long timeSpent;
        String uuid;

        ActivityStateCopy(ActivityState activityState) {
            this.lastInterval = -1L;
            this.eventCount = -1;
            this.uuid = null;
            this.sessionCount = -1;
            this.subsessionCount = -1;
            this.sessionLength = -1L;
            this.timeSpent = -1L;
            this.pushToken = null;
            if (activityState != null) {
                this.lastInterval = activityState.lastInterval;
                this.eventCount = activityState.eventCount;
                this.uuid = activityState.uuid;
                this.sessionCount = activityState.sessionCount;
                this.subsessionCount = activityState.subsessionCount;
                this.sessionLength = activityState.sessionLength;
                this.timeSpent = activityState.timeSpent;
                this.pushToken = activityState.pushToken;
            }
        }
    }

    public PackageBuilder(AdjustConfig adjustConfig, DeviceInfo deviceInfo, ActivityState activityState, long createdAt) {
        this.adjustConfig = adjustConfig;
        this.deviceInfo = deviceInfo;
        this.activityStateCopy = new ActivityStateCopy(activityState);
        this.createdAt = createdAt;
    }

    public ActivityPackage buildSessionPackage(SessionParameters sessionParameters, boolean isInDelay) {
        Map<String, String> parameters = getDefaultParameters();
        addDuration(parameters, "last_interval", this.activityStateCopy.lastInterval);
        addString(parameters, "default_tracker", this.adjustConfig.defaultTracker);
        if (!isInDelay) {
            addMapJson(parameters, Constants.CALLBACK_PARAMETERS, sessionParameters.callbackParameters);
            addMapJson(parameters, Constants.PARTNER_PARAMETERS, sessionParameters.partnerParameters);
        }
        ActivityPackage sessionPackage = getDefaultActivityPackage(ActivityKind.SESSION);
        sessionPackage.setPath("/session");
        sessionPackage.setSuffix("");
        sessionPackage.setParameters(parameters);
        return sessionPackage;
    }

    public ActivityPackage buildEventPackage(AdjustEvent event, SessionParameters sessionParameters, boolean isInDelay) {
        Map<String, String> parameters = getDefaultParameters();
        addInt(parameters, "event_count", this.activityStateCopy.eventCount);
        addString(parameters, "event_token", event.eventToken);
        addDouble(parameters, "revenue", event.revenue);
        addString(parameters, InAppPurchaseMetaData.KEY_CURRENCY, event.currency);
        if (!isInDelay) {
            addMapJson(parameters, Constants.CALLBACK_PARAMETERS, Util.mergeParameters(sessionParameters.callbackParameters, event.callbackParameters, "Callback"));
            addMapJson(parameters, Constants.PARTNER_PARAMETERS, Util.mergeParameters(sessionParameters.partnerParameters, event.partnerParameters, "Partner"));
        }
        ActivityPackage eventPackage = getDefaultActivityPackage(ActivityKind.EVENT);
        eventPackage.setPath("/event");
        eventPackage.setSuffix(getEventSuffix(event));
        eventPackage.setParameters(parameters);
        if (isInDelay) {
            eventPackage.setCallbackParameters(event.callbackParameters);
            eventPackage.setPartnerParameters(event.partnerParameters);
        }
        return eventPackage;
    }

    public ActivityPackage buildClickPackage(String source) {
        Map<String, String> parameters = getIdsParameters();
        addString(parameters, ShareConstants.FEED_SOURCE_PARAM, source);
        addDate(parameters, "click_time", this.clickTime);
        addString(parameters, Constants.REFTAG, this.reftag);
        addMapJson(parameters, NativeProtocol.WEB_DIALOG_PARAMS, this.extraParameters);
        addString(parameters, Constants.REFERRER, this.referrer);
        addString(parameters, Constants.DEEPLINK, this.deeplink);
        injectAttribution(parameters);
        ActivityPackage clickPackage = getDefaultActivityPackage(ActivityKind.CLICK);
        clickPackage.setPath("/sdk_click");
        clickPackage.setSuffix("");
        clickPackage.setParameters(parameters);
        return clickPackage;
    }

    public ActivityPackage buildInfoPackage(String source) {
        Map<String, String> parameters = getIdsParameters();
        addString(parameters, ShareConstants.FEED_SOURCE_PARAM, source);
        injectAttribution(parameters);
        ActivityPackage clickPackage = getDefaultActivityPackage(ActivityKind.INFO);
        clickPackage.setPath("/sdk_info");
        clickPackage.setSuffix("");
        clickPackage.setParameters(parameters);
        return clickPackage;
    }

    public ActivityPackage buildAttributionPackage() {
        Map<String, String> parameters = getIdsParameters();
        ActivityPackage attributionPackage = getDefaultActivityPackage(ActivityKind.ATTRIBUTION);
        attributionPackage.setPath("attribution");
        attributionPackage.setSuffix("");
        attributionPackage.setParameters(parameters);
        return attributionPackage;
    }

    private ActivityPackage getDefaultActivityPackage(ActivityKind activityKind) {
        ActivityPackage activityPackage = new ActivityPackage(activityKind);
        activityPackage.setClientSdk(this.deviceInfo.clientSdk);
        return activityPackage;
    }

    private Map<String, String> getDefaultParameters() {
        Map<String, String> parameters = new HashMap<>();
        injectDeviceInfo(parameters);
        injectConfig(parameters);
        injectActivityState(parameters);
        injectCommonParameters(parameters);
        checkDeviceIds(parameters);
        return parameters;
    }

    private Map<String, String> getIdsParameters() {
        Map<String, String> parameters = new HashMap<>();
        injectDeviceInfoIds(parameters);
        injectConfig(parameters);
        injectCommonParameters(parameters);
        checkDeviceIds(parameters);
        return parameters;
    }

    private void injectDeviceInfo(Map<String, String> parameters) {
        injectDeviceInfoIds(parameters);
        addString(parameters, "fb_id", this.deviceInfo.fbAttributionId);
        addString(parameters, "package_name", this.deviceInfo.packageName);
        addString(parameters, "app_version", this.deviceInfo.appVersion);
        addString(parameters, "device_type", this.deviceInfo.deviceType);
        addString(parameters, "device_name", this.deviceInfo.deviceName);
        addString(parameters, "device_manufacturer", this.deviceInfo.deviceManufacturer);
        addString(parameters, "os_name", this.deviceInfo.osName);
        addString(parameters, "os_version", this.deviceInfo.osVersion);
        addString(parameters, "api_level", this.deviceInfo.apiLevel);
        addString(parameters, "language", this.deviceInfo.language);
        addString(parameters, "country", this.deviceInfo.country);
        addString(parameters, "screen_size", this.deviceInfo.screenSize);
        addString(parameters, "screen_format", this.deviceInfo.screenFormat);
        addString(parameters, "screen_density", this.deviceInfo.screenDensity);
        addString(parameters, "display_width", this.deviceInfo.displayWidth);
        addString(parameters, "display_height", this.deviceInfo.displayHeight);
        addString(parameters, "hardware_name", this.deviceInfo.hardwareName);
        addString(parameters, "cpu_type", this.deviceInfo.abi);
        addString(parameters, "os_build", this.deviceInfo.buildName);
        addString(parameters, "vm_isa", this.deviceInfo.vmInstructionSet);
        fillPluginKeys(parameters);
    }

    private void injectDeviceInfoIds(Map<String, String> parameters) {
        addString(parameters, "mac_sha1", this.deviceInfo.macSha1);
        addString(parameters, "mac_md5", this.deviceInfo.macShortMd5);
        addString(parameters, "android_id", this.deviceInfo.androidId);
    }

    private void injectConfig(Map<String, String> parameters) {
        addString(parameters, "app_token", this.adjustConfig.appToken);
        addString(parameters, "environment", this.adjustConfig.environment);
        addBoolean(parameters, "device_known", this.adjustConfig.deviceKnown);
        addBoolean(parameters, "needs_response_details", true);
        String playAdId = Util.getPlayAdId(this.adjustConfig.context);
        addString(parameters, "gps_adid", playAdId);
        Boolean isTrackingEnabled = Util.isPlayTrackingEnabled(this.adjustConfig.context);
        addBoolean(parameters, "tracking_enabled", isTrackingEnabled);
        addBoolean(parameters, "event_buffering_enabled", Boolean.valueOf(this.adjustConfig.eventBufferingEnabled));
        addString(parameters, "push_token", this.activityStateCopy.pushToken);
        ContentResolver contentResolver = this.adjustConfig.context.getContentResolver();
        String fireAdId = Util.getFireAdvertisingId(contentResolver);
        addString(parameters, "fire_adid", fireAdId);
        Boolean fireTrackingEnabled = Util.getFireTrackingEnabled(contentResolver);
        addBoolean(parameters, "fire_tracking_enabled", fireTrackingEnabled);
    }

    private void injectActivityState(Map<String, String> parameters) {
        addString(parameters, "android_uuid", this.activityStateCopy.uuid);
        addInt(parameters, "session_count", this.activityStateCopy.sessionCount);
        addInt(parameters, "subsession_count", this.activityStateCopy.subsessionCount);
        addDuration(parameters, "session_length", this.activityStateCopy.sessionLength);
        addDuration(parameters, "time_spent", this.activityStateCopy.timeSpent);
    }

    private void injectCommonParameters(Map<String, String> parameters) {
        addDate(parameters, "created_at", this.createdAt);
        addBoolean(parameters, "attribution_deeplink", true);
    }

    private void injectAttribution(Map<String, String> parameters) {
        if (this.attribution != null) {
            addString(parameters, "tracker", this.attribution.trackerName);
            addString(parameters, "campaign", this.attribution.campaign);
            addString(parameters, "adgroup", this.attribution.adgroup);
            addString(parameters, "creative", this.attribution.creative);
        }
    }

    private void checkDeviceIds(Map<String, String> parameters) {
        if (!parameters.containsKey("mac_sha1") && !parameters.containsKey("mac_md5") && !parameters.containsKey("android_id") && !parameters.containsKey("gps_adid")) {
            logger.error("Missing device id's. Please check if Proguard is correctly set with Adjust SDK", new Object[0]);
        }
    }

    private void fillPluginKeys(Map<String, String> parameters) {
        if (this.deviceInfo.pluginKeys != null) {
            for (Map.Entry<String, String> entry : this.deviceInfo.pluginKeys.entrySet()) {
                addString(parameters, entry.getKey(), entry.getValue());
            }
        }
    }

    private String getEventSuffix(AdjustEvent event) {
        return event.revenue == null ? String.format(Locale.US, "'%s'", event.eventToken) : String.format(Locale.US, "(%.5f %s, '%s')", event.revenue, event.currency, event.eventToken);
    }

    public static void addString(Map<String, String> parameters, String key, String value) {
        if (!TextUtils.isEmpty(value)) {
            parameters.put(key, value);
        }
    }

    public static void addInt(Map<String, String> parameters, String key, long value) {
        if (value >= 0) {
            String valueString = Long.toString(value);
            addString(parameters, key, valueString);
        }
    }

    public static void addDate(Map<String, String> parameters, String key, long value) {
        if (value >= 0) {
            String dateString = Util.dateFormatter.format(Long.valueOf(value));
            addString(parameters, key, dateString);
        }
    }

    public static void addDuration(Map<String, String> parameters, String key, long durationInMilliSeconds) {
        if (durationInMilliSeconds >= 0) {
            long durationInSeconds = (500 + durationInMilliSeconds) / 1000;
            addInt(parameters, key, durationInSeconds);
        }
    }

    public static void addMapJson(Map<String, String> parameters, String key, Map<String, String> map) {
        if (map != null && map.size() != 0) {
            JSONObject jsonObject = new JSONObject(map);
            String jsonString = jsonObject.toString();
            addString(parameters, key, jsonString);
        }
    }

    public static void addBoolean(Map<String, String> parameters, String key, Boolean value) {
        if (value != null) {
            int intValue = value.booleanValue() ? 1 : 0;
            addInt(parameters, key, intValue);
        }
    }

    public static void addDouble(Map<String, String> parameters, String key, Double value) {
        if (value != null) {
            String doubleString = String.format(Locale.US, "%.5f", value);
            addString(parameters, key, doubleString);
        }
    }
}
