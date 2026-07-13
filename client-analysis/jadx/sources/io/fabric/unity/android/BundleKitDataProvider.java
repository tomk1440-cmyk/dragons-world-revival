package io.fabric.unity.android;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import io.fabric.sdk.android.Fabric;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class BundleKitDataProvider implements KitDataProvider {
    static final String INITIALIZATION_KITS_LIST = "InitializationKitsList";
    static final String INITIALIZATION_TYPE = "InitializationType";
    static final String KEY_PREFIX = "io.fabric";
    static final String KITS_KEY = "io.fabric.kits";
    static final String KITS_SUFFIX = ".kits";
    static final String NAME_SUFFIX = ".unqualified";
    private static final String[] NO_KEYS = new String[0];
    static final String QUALIFIED_SUFFIX = ".qualified";
    private final Bundle metadata;

    public BundleKitDataProvider(Bundle metadata) {
        this.metadata = metadata;
    }

    @Override // io.fabric.unity.android.KitDataProvider
    public KitData[] getKitData() {
        List<KitData> kitDataList = new LinkedList<>();
        String[] kitKeys = getKitKeys();
        for (String str : kitKeys) {
            String key = "io.fabric." + str;
            String nameKey = key + NAME_SUFFIX;
            String qualifiedKey = key + QUALIFIED_SUFFIX;
            if (!this.metadata.containsKey(nameKey)) {
                Log.w(Fabric.TAG, "Could not find kit info for key " + nameKey);
            } else {
                String name = this.metadata.getString(nameKey);
                String qualifiedName = this.metadata.getString(qualifiedKey);
                kitDataList.add(new KitData(name, qualifiedName));
            }
        }
        return (KitData[]) kitDataList.toArray(new KitData[kitDataList.size()]);
    }

    @Override // io.fabric.unity.android.KitDataProvider
    public String getInitializationType() {
        return this.metadata.getString("io.fabric.InitializationType");
    }

    @Override // io.fabric.unity.android.KitDataProvider
    public String getInitializationKitsList() {
        return this.metadata.getString("io.fabric.InitializationKitsList");
    }

    private String[] getKitKeys() {
        String kitsString = this.metadata.getString(KITS_KEY);
        return TextUtils.isEmpty(kitsString) ? NO_KEYS : kitsString.split(",");
    }
}
