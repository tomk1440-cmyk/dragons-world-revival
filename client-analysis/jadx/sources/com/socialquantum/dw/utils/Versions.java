package com.socialquantum.dw.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Versions {
    private static final String FB_INT = "567932989917303";
    private static final String FB_RU = "352155171562610";
    private static String applicationId;
    private static BuildType buildType = BuildType.UNKNOWN;
    private static String gmsId;

    public enum BuildType {
        INT,
        RU,
        UNKNOWN
    }

    public static BuildType type() {
        return buildType;
    }

    public static String appId() {
        return applicationId;
    }

    public static String gmsId() {
        return gmsId;
    }

    public static void loadMetadata(Context context) {
        BuildType buildType2;
        Log.d("DW Utils", "Loading metadata");
        if (context != null) {
            try {
                ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                applicationId = FB_RU;
                if (ai != null && ai.metaData != null && gmsId == null) {
                    gmsId = ai.metaData.getString("com.google.android.gms.appstate.APP_ID");
                }
                if (applicationId == null) {
                    buildType2 = BuildType.UNKNOWN;
                } else {
                    buildType2 = applicationId == FB_INT ? BuildType.INT : BuildType.RU;
                }
                buildType = buildType2;
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }
}
