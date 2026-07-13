package com.google.ads.mediation.customevent;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CustomEventListener {
    void onDismissScreen();

    void onFailedToReceiveAd();

    void onLeaveApplication();

    void onPresentScreen();
}
