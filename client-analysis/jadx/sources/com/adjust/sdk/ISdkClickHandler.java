package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public interface ISdkClickHandler {
    void init(boolean z);

    void pauseSending();

    void resumeSending();

    void sendSdkClick(ActivityPackage activityPackage);

    void teardown();
}
