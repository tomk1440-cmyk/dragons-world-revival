package com.adjust.sdk;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AdjustConfig {
    public static final String ENVIRONMENT_PRODUCTION = "production";
    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    boolean allowSuppressLogLevel;
    String appToken;
    Context context;
    Class deepLinkComponent;
    String defaultTracker;
    Double delayStart;
    Boolean deviceKnown;
    String environment;
    boolean eventBufferingEnabled;
    ILogger logger;
    OnAttributionChangedListener onAttributionChangedListener;
    OnDeeplinkResponseListener onDeeplinkResponseListener;
    OnEventTrackingFailedListener onEventTrackingFailedListener;
    OnEventTrackingSucceededListener onEventTrackingSucceededListener;
    OnSessionTrackingFailedListener onSessionTrackingFailedListener;
    OnSessionTrackingSucceededListener onSessionTrackingSucceededListener;
    String processName;
    String pushToken;
    String referrer;
    long referrerClickTime;
    String sdkPrefix;
    boolean sendInBackground;
    List<IRunActivityHandler> sessionParametersActionsArray;
    String userAgent;

    public AdjustConfig(Context context, String appToken, String environment) {
        init(context, appToken, environment, false);
    }

    public AdjustConfig(Context context, String appToken, String environment, boolean allowSuppressLogLevel) {
        init(context, appToken, environment, allowSuppressLogLevel);
    }

    private void init(Context context, String appToken, String environment, boolean allowSuppressLogLevel) {
        this.allowSuppressLogLevel = allowSuppressLogLevel;
        this.logger = AdjustFactory.getLogger();
        setLogLevel(LogLevel.INFO, environment);
        if (isValid(context, appToken, environment)) {
            this.context = context.getApplicationContext();
            this.appToken = appToken;
            this.environment = environment;
            this.eventBufferingEnabled = false;
            this.sendInBackground = false;
        }
    }

    public void setEventBufferingEnabled(Boolean eventBufferingEnabled) {
        if (eventBufferingEnabled == null) {
            this.eventBufferingEnabled = false;
        } else {
            this.eventBufferingEnabled = eventBufferingEnabled.booleanValue();
        }
    }

    public void setSendInBackground(boolean sendInBackground) {
        this.sendInBackground = sendInBackground;
    }

    public void setLogLevel(LogLevel logLevel) {
        setLogLevel(logLevel, this.environment);
    }

    public void setSdkPrefix(String sdkPrefix) {
        this.sdkPrefix = sdkPrefix;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setDefaultTracker(String defaultTracker) {
        this.defaultTracker = defaultTracker;
    }

    public void setOnAttributionChangedListener(OnAttributionChangedListener onAttributionChangedListener) {
        this.onAttributionChangedListener = onAttributionChangedListener;
    }

    public void setDeviceKnown(boolean deviceKnown) {
        this.deviceKnown = Boolean.valueOf(deviceKnown);
    }

    public void setDeepLinkComponent(Class deepLinkComponent) {
        this.deepLinkComponent = deepLinkComponent;
    }

    public void setOnEventTrackingSucceededListener(OnEventTrackingSucceededListener onEventTrackingSucceededListener) {
        this.onEventTrackingSucceededListener = onEventTrackingSucceededListener;
    }

    public void setOnEventTrackingFailedListener(OnEventTrackingFailedListener onEventTrackingFailedListener) {
        this.onEventTrackingFailedListener = onEventTrackingFailedListener;
    }

    public void setOnSessionTrackingSucceededListener(OnSessionTrackingSucceededListener onSessionTrackingSucceededListener) {
        this.onSessionTrackingSucceededListener = onSessionTrackingSucceededListener;
    }

    public void setOnSessionTrackingFailedListener(OnSessionTrackingFailedListener onSessionTrackingFailedListener) {
        this.onSessionTrackingFailedListener = onSessionTrackingFailedListener;
    }

    public void setOnDeeplinkResponseListener(OnDeeplinkResponseListener onDeeplinkResponseListener) {
        this.onDeeplinkResponseListener = onDeeplinkResponseListener;
    }

    public void setDelayStart(double delayStart) {
        this.delayStart = Double.valueOf(delayStart);
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public boolean isValid() {
        return this.appToken != null;
    }

    private boolean isValid(Context context, String appToken, String environment) {
        return checkAppToken(appToken) && checkEnvironment(environment) && checkContext(context);
    }

    private void setLogLevel(LogLevel logLevel, String environment) {
        LogLevel newLogLevel;
        if (ENVIRONMENT_PRODUCTION.equals(environment)) {
            if (this.allowSuppressLogLevel) {
                newLogLevel = LogLevel.SUPRESS;
            } else {
                newLogLevel = LogLevel.ASSERT;
            }
        } else if (!this.allowSuppressLogLevel && logLevel == LogLevel.SUPRESS) {
            newLogLevel = LogLevel.ASSERT;
        } else {
            newLogLevel = logLevel;
        }
        this.logger.setLogLevel(newLogLevel);
    }

    private boolean checkContext(Context context) {
        if (context == null) {
            this.logger.error("Missing context", new Object[0]);
            return false;
        }
        if (!Util.checkPermission(context, "android.permission.INTERNET")) {
            this.logger.error("Missing permission: INTERNET", new Object[0]);
            return false;
        }
        return true;
    }

    private boolean checkAppToken(String appToken) {
        if (appToken == null) {
            this.logger.error("Missing App Token", new Object[0]);
            return false;
        }
        if (appToken.length() == 12) {
            return true;
        }
        this.logger.error("Malformed App Token '%s'", appToken);
        return false;
    }

    private boolean checkEnvironment(String environment) {
        if (environment == null) {
            this.logger.error("Missing environment", new Object[0]);
            return false;
        }
        if (environment.equals(ENVIRONMENT_SANDBOX)) {
            this.logger.Assert("SANDBOX: Adjust is running in Sandbox mode. Use this setting for testing. Don't forget to set the environment to `production` before publishing!", new Object[0]);
            return true;
        }
        if (environment.equals(ENVIRONMENT_PRODUCTION)) {
            this.logger.Assert("PRODUCTION: Adjust is running in Production mode. Use this setting only for the build that you want to publish. Set the environment to `sandbox` if you want to test your app!", new Object[0]);
            return true;
        }
        this.logger.error("Unknown environment '%s'", environment);
        return false;
    }
}
