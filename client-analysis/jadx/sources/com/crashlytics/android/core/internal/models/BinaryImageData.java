package com.crashlytics.android.core.internal.models;

/* JADX INFO: loaded from: classes.dex */
public class BinaryImageData {
    public final long baseAddress;
    public final String id;
    public final String path;
    public final long size;

    public BinaryImageData(long baseAddress, long size, String path, String id) {
        this.baseAddress = baseAddress;
        this.size = size;
        this.path = path;
        this.id = id;
    }
}
