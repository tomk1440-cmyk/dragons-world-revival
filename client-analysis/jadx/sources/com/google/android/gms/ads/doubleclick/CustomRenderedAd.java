package com.google.android.gms.ads.doubleclick;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface CustomRenderedAd {
    String getBaseUrl();

    String getContent();

    void onAdRendered(View view);

    void recordClick();

    void recordImpression();
}
