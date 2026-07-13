package io.fabric.unity.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;

/* JADX INFO: loaded from: classes.dex */
public class FabricInitializer {
    private static Context savedContext = null;
    private static String AUTOMATIC = "Automatic";
    private static String MANUAL = "Manual";

    public enum Caller {
        Android,
        Unity
    }

    public static String JNI_InitializeFabric() {
        return initializeFabric(savedContext, Caller.Unity);
    }

    public static String initializeFabric(Context context, Caller originator) {
        savedContext = context;
        if (savedContext == null) {
            throw new FabricInitializationException("Fabric did not find a valid application context.");
        }
        Bundle metadata = getManifestMetadata(savedContext);
        if (metadata == null) {
            throw new FabricInitializationException("Fabric initialization metadata missing. Check your AndroidManifest.xml");
        }
        BundleKitDataProvider provider = new BundleKitDataProvider(metadata);
        KitData[] kitDataArray = provider.getKitData();
        Kit[] kits = new KitInstantiator(metadata).createKitsFromKitData(kitDataArray);
        if (kits == null || kits.length < 1) {
            Log.w(Fabric.TAG, "Fabric found no kits to initialize.");
            return "";
        }
        String initializationType = provider.getInitializationType();
        if ((initializationType.equals(AUTOMATIC) && originator == Caller.Android) || (initializationType.equals(MANUAL) && originator == Caller.Unity)) {
            Fabric.with(savedContext, kits);
        }
        return provider.getInitializationKitsList();
    }

    private static Bundle getManifestMetadata(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            ApplicationInfo appInfo = packageManager.getApplicationInfo(packageName, 128);
            Bundle metaData = appInfo.metaData;
            return metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(Fabric.TAG, "Could not retrieve application metadata", e);
            return null;
        }
    }
}
