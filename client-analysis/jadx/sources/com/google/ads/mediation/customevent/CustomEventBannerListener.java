package com.google.ads.mediation.customevent;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface CustomEventBannerListener extends CustomEventListener {
    void onClick();

    void onReceivedAd(View view);
}
