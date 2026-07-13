package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class DeviceInfo {
    String abi;
    String androidId;
    String apiLevel;
    String appVersion;
    String buildName;
    String clientSdk;
    String country;
    String deviceManufacturer;
    String deviceName;
    String deviceType;
    String displayHeight;
    String displayWidth;
    String fbAttributionId;
    String hardwareName;
    String language;
    String macSha1;
    String macShortMd5;
    String osName;
    String osVersion;
    String packageName;
    Map<String, String> pluginKeys;
    String screenDensity;
    String screenFormat;
    String screenSize;
    String vmInstructionSet;

    DeviceInfo(Context context, String sdkPrefix) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        Locale locale = Util.getLocale(configuration);
        int screenLayout = configuration.screenLayout;
        boolean isGooglePlayServicesAvailable = Util.getPlayAdId(context) != null;
        String macAddress = getMacAddress(context, isGooglePlayServicesAvailable);
        context.getContentResolver();
        this.packageName = getPackageName(context);
        this.appVersion = getAppVersion(context);
        this.deviceType = getDeviceType(screenLayout);
        this.deviceName = getDeviceName();
        this.deviceManufacturer = getDeviceManufacturer();
        this.osName = getOsName();
        this.osVersion = getOsVersion();
        this.apiLevel = getApiLevel();
        this.language = getLanguage(locale);
        this.country = getCountry(locale);
        this.screenSize = getScreenSize(screenLayout);
        this.screenFormat = getScreenFormat(screenLayout);
        this.screenDensity = getScreenDensity(displayMetrics);
        this.displayWidth = getDisplayWidth(displayMetrics);
        this.displayHeight = getDisplayHeight(displayMetrics);
        this.clientSdk = getClientSdk(sdkPrefix);
        this.androidId = getAndroidId(context, isGooglePlayServicesAvailable);
        this.fbAttributionId = getFacebookAttributionId(context);
        this.pluginKeys = Util.getPluginKeys(context);
        this.macSha1 = getMacSha1(macAddress);
        this.macShortMd5 = getMacShortMd5(macAddress);
        this.hardwareName = getHardwareName();
        this.abi = getABI();
        this.buildName = getBuildName();
        this.vmInstructionSet = getVmInstructionSet();
    }

    private String getMacAddress(Context context, boolean isGooglePlayServicesAvailable) {
        if (isGooglePlayServicesAvailable) {
            return null;
        }
        if (!Util.checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            AdjustFactory.getLogger().warn("Missing permission: ACCESS_WIFI_STATE", new Object[0]);
        }
        return Util.getMacAddress(context);
    }

    private String getPackageName(Context context) {
        return context.getPackageName();
    }

    private String getAppVersion(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String name = context.getPackageName();
            PackageInfo info = packageManager.getPackageInfo(name, 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private String getDeviceType(int screenLayout) {
        int screenSize = screenLayout & 15;
        switch (screenSize) {
            case 1:
            case 2:
                return "phone";
            case 3:
            case 4:
                return "tablet";
            default:
                return null;
        }
    }

    private String getDeviceName() {
        return Build.MODEL;
    }

    private String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    private String getOsName() {
        return AbstractSpiCall.ANDROID_CLIENT_TYPE;
    }

    private String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    private String getApiLevel() {
        return "" + Build.VERSION.SDK_INT;
    }

    private String getLanguage(Locale locale) {
        return locale.getLanguage();
    }

    private String getCountry(Locale locale) {
        return locale.getCountry();
    }

    private String getBuildName() {
        return Build.ID;
    }

    private String getHardwareName() {
        return Build.DISPLAY;
    }

    private String getScreenSize(int screenLayout) {
        int screenSize = screenLayout & 15;
        switch (screenSize) {
            case 1:
                return Constants.SMALL;
            case 2:
                return Constants.NORMAL;
            case 3:
                return Constants.LARGE;
            case 4:
                return Constants.XLARGE;
            default:
                return null;
        }
    }

    private String getScreenFormat(int screenLayout) {
        int screenFormat = screenLayout & 48;
        switch (screenFormat) {
            case 16:
                return Constants.NORMAL;
            case 32:
                return Constants.LONG;
            default:
                return null;
        }
    }

    private String getScreenDensity(DisplayMetrics displayMetrics) {
        int density = displayMetrics.densityDpi;
        if (density == 0) {
            return null;
        }
        if (density < 140) {
            return Constants.LOW;
        }
        if (density > 200) {
            return Constants.HIGH;
        }
        return Constants.MEDIUM;
    }

    private String getDisplayWidth(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.widthPixels);
    }

    private String getDisplayHeight(DisplayMetrics displayMetrics) {
        return String.valueOf(displayMetrics.heightPixels);
    }

    private String getClientSdk(String sdkPrefix) {
        return sdkPrefix == null ? Constants.CLIENT_SDK : String.format(Locale.US, "%s@%s", sdkPrefix, Constants.CLIENT_SDK);
    }

    private String getMacSha1(String macAddress) {
        if (macAddress == null) {
            return null;
        }
        return Util.sha1(macAddress);
    }

    private String getMacShortMd5(String macAddress) {
        if (macAddress == null) {
            return null;
        }
        String macShort = macAddress.replaceAll(":", "");
        return Util.md5(macShort);
    }

    private String getAndroidId(Context context, boolean isGooglePlayServicesAvailable) {
        if (isGooglePlayServicesAvailable) {
            return null;
        }
        return Util.getAndroidId(context);
    }

    private String getFacebookAttributionId(Context context) {
        String string;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
            String[] projection = {"aid"};
            Cursor cursor = contentResolver.query(uri, projection, null, null, null);
            if (cursor == null) {
                string = null;
            } else if (!cursor.moveToFirst()) {
                cursor.close();
                string = null;
            } else {
                string = cursor.getString(cursor.getColumnIndex("aid"));
                cursor.close();
            }
            return string;
        } catch (Exception e) {
            return null;
        }
    }

    private String getABI() {
        String[] SupportedABIS = Util.getSupportedAbis();
        return (SupportedABIS == null || SupportedABIS.length == 0) ? Util.getCpuAbi() : SupportedABIS[0];
    }

    private String getVmInstructionSet() {
        String instructionSet = Util.getVmInstructionSet();
        return instructionSet;
    }
}
