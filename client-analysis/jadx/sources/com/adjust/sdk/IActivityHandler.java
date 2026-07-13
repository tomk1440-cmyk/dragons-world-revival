package com.adjust.sdk;

import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityHandler {
    void addSessionCallbackParameter(String str, String str2);

    void addSessionPartnerParameter(String str, String str2);

    void finishedTrackingActivity(ResponseData responseData);

    void init(AdjustConfig adjustConfig);

    boolean isEnabled();

    void launchAttributionResponseTasks(AttributionResponseData attributionResponseData);

    void launchEventResponseTasks(EventResponseData eventResponseData);

    void launchSessionResponseTasks(SessionResponseData sessionResponseData);

    void onPause();

    void onResume();

    void readOpenUrl(Uri uri, long j);

    void removeSessionCallbackParameter(String str);

    void removeSessionPartnerParameter(String str);

    void resetSessionCallbackParameters();

    void resetSessionPartnerParameters();

    void sendFirstPackages();

    void sendReferrer(String str, long j);

    void setAskingAttribution(boolean z);

    void setEnabled(boolean z);

    void setOfflineMode(boolean z);

    void setPushToken(String str);

    void teardown(boolean z);

    void trackEvent(AdjustEvent adjustEvent);

    boolean updateAttributionI(AdjustAttribution adjustAttribution);
}
