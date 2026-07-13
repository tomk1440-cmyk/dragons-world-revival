package com.adjust.sdk;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AdjustInstance {
    private ActivityHandler activityHandler;
    private String pushToken;
    private String referrer;
    private long referrerClickTime;
    private List<IRunActivityHandler> sessionParametersActionsArray;

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    public void onCreate(AdjustConfig adjustConfig) {
        if (this.activityHandler != null) {
            getLogger().error("Adjust already initialized", new Object[0]);
            return;
        }
        adjustConfig.referrer = this.referrer;
        adjustConfig.referrerClickTime = this.referrerClickTime;
        adjustConfig.sessionParametersActionsArray = this.sessionParametersActionsArray;
        adjustConfig.pushToken = this.pushToken;
        this.activityHandler = ActivityHandler.getInstance(adjustConfig);
    }

    public void trackEvent(AdjustEvent event) {
        if (checkActivityHandler()) {
            this.activityHandler.trackEvent(event);
        }
    }

    public void onResume() {
        if (checkActivityHandler()) {
            this.activityHandler.onResume();
        }
    }

    public void onPause() {
        if (checkActivityHandler()) {
            this.activityHandler.onPause();
        }
    }

    public void setEnabled(boolean enabled) {
        if (checkActivityHandler()) {
            this.activityHandler.setEnabled(enabled);
        }
    }

    public boolean isEnabled() {
        if (checkActivityHandler()) {
            return this.activityHandler.isEnabled();
        }
        return false;
    }

    public void appWillOpenUrl(Uri url) {
        if (checkActivityHandler()) {
            long clickTime = System.currentTimeMillis();
            this.activityHandler.readOpenUrl(url, clickTime);
        }
    }

    public void sendReferrer(String referrer) {
        long clickTime = System.currentTimeMillis();
        if (this.activityHandler == null) {
            this.referrer = referrer;
            this.referrerClickTime = clickTime;
        } else {
            this.activityHandler.sendReferrer(referrer, clickTime);
        }
    }

    public void setOfflineMode(boolean enabled) {
        if (checkActivityHandler()) {
            this.activityHandler.setOfflineMode(enabled);
        }
    }

    public void sendFirstPackages() {
        if (checkActivityHandler()) {
            this.activityHandler.sendFirstPackages();
        }
    }

    public void addSessionCallbackParameter(final String key, final String value) {
        if (this.activityHandler != null) {
            this.activityHandler.addSessionCallbackParameter(key, value);
            return;
        }
        if (this.sessionParametersActionsArray == null) {
            this.sessionParametersActionsArray = new ArrayList();
        }
        this.sessionParametersActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.1
            @Override // com.adjust.sdk.IRunActivityHandler
            public void run(ActivityHandler activityHandler) {
                activityHandler.addSessionCallbackParameterI(key, value);
            }
        });
    }

    public void addSessionPartnerParameter(final String key, final String value) {
        if (this.activityHandler != null) {
            this.activityHandler.addSessionPartnerParameter(key, value);
            return;
        }
        if (this.sessionParametersActionsArray == null) {
            this.sessionParametersActionsArray = new ArrayList();
        }
        this.sessionParametersActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.2
            @Override // com.adjust.sdk.IRunActivityHandler
            public void run(ActivityHandler activityHandler) {
                activityHandler.addSessionPartnerParameterI(key, value);
            }
        });
    }

    public void removeSessionCallbackParameter(final String key) {
        if (this.activityHandler != null) {
            this.activityHandler.removeSessionCallbackParameter(key);
            return;
        }
        if (this.sessionParametersActionsArray == null) {
            this.sessionParametersActionsArray = new ArrayList();
        }
        this.sessionParametersActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.3
            @Override // com.adjust.sdk.IRunActivityHandler
            public void run(ActivityHandler activityHandler) {
                activityHandler.removeSessionCallbackParameterI(key);
            }
        });
    }

    public void removeSessionPartnerParameter(final String key) {
        if (this.activityHandler != null) {
            this.activityHandler.removeSessionPartnerParameter(key);
            return;
        }
        if (this.sessionParametersActionsArray == null) {
            this.sessionParametersActionsArray = new ArrayList();
        }
        this.sessionParametersActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.4
            @Override // com.adjust.sdk.IRunActivityHandler
            public void run(ActivityHandler activityHandler) {
                activityHandler.removeSessionPartnerParameterI(key);
            }
        });
    }

    public void resetSessionCallbackParameters() {
        if (this.activityHandler != null) {
            this.activityHandler.resetSessionCallbackParameters();
            return;
        }
        if (this.sessionParametersActionsArray == null) {
            this.sessionParametersActionsArray = new ArrayList();
        }
        this.sessionParametersActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.5
            @Override // com.adjust.sdk.IRunActivityHandler
            public void run(ActivityHandler activityHandler) {
                activityHandler.resetSessionCallbackParametersI();
            }
        });
    }

    public void resetSessionPartnerParameters() {
        if (this.activityHandler != null) {
            this.activityHandler.resetSessionPartnerParameters();
            return;
        }
        if (this.sessionParametersActionsArray == null) {
            this.sessionParametersActionsArray = new ArrayList();
        }
        this.sessionParametersActionsArray.add(new IRunActivityHandler() { // from class: com.adjust.sdk.AdjustInstance.6
            @Override // com.adjust.sdk.IRunActivityHandler
            public void run(ActivityHandler activityHandler) {
                activityHandler.resetSessionPartnerParametersI();
            }
        });
    }

    public void teardown(boolean deleteState) {
        if (checkActivityHandler()) {
            this.activityHandler.teardown(deleteState);
            this.activityHandler = null;
        }
    }

    public void setPushToken(String token) {
        this.pushToken = token;
        if (this.activityHandler != null) {
            this.activityHandler.setPushToken(token);
        }
    }

    public String getAdid() {
        if (checkActivityHandler()) {
            return this.activityHandler.getAdid();
        }
        return null;
    }

    public AdjustAttribution getAttribution() {
        if (checkActivityHandler()) {
            return this.activityHandler.getAttribution();
        }
        return null;
    }

    private boolean checkActivityHandler() {
        if (this.activityHandler != null) {
            return true;
        }
        getLogger().error("Adjust not initialized correctly", new Object[0]);
        return false;
    }
}
