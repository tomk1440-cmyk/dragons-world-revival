package com.unity3d.ads.log;

/* JADX INFO: loaded from: classes.dex */
public class DeviceLogLevel {
    private static final String LOG_TAG = "UnityAds";
    private String _receivingMethodName;

    public DeviceLogLevel(String receivingMethodName) {
        this._receivingMethodName = null;
        this._receivingMethodName = receivingMethodName;
    }

    public String getLogTag() {
        return LOG_TAG;
    }

    public String getReceivingMethodName() {
        return this._receivingMethodName;
    }
}
