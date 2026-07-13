package io.fabric.unity.android;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class FabricApplication extends Application {
    static final String TAG = "Fabric";

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        FabricInitializer.initializeFabric(this, FabricInitializer.Caller.Android);
    }
}
