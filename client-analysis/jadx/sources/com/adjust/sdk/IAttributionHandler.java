package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public interface IAttributionHandler {
    void checkSessionResponse(SessionResponseData sessionResponseData);

    void getAttribution();

    void init(IActivityHandler iActivityHandler, ActivityPackage activityPackage, boolean z);

    void pauseSending();

    void resumeSending();

    void teardown();
}
