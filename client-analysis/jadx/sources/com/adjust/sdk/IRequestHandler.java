package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public interface IRequestHandler {
    void init(IPackageHandler iPackageHandler);

    void sendPackage(ActivityPackage activityPackage, int i);

    void teardown();
}
