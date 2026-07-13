package com.google.android.gms.wearable;

/* JADX INFO: loaded from: classes.dex */
public interface MessageEvent {
    byte[] getData();

    String getPath();

    int getRequestId();

    String getSourceNodeId();
}
