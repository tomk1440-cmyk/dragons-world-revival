package com.unity3d.ads.device;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.Utilities;
import com.unity3d.ads.properties.ClientProperties;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class Device {

    public enum MemoryInfoType {
        TOTAL_MEMORY,
        FREE_MEMORY
    }

    public static int getApiLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static int getScreenLayout() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getConfiguration().screenLayout;
        }
        return -1;
    }

    @SuppressLint({"DefaultLocale"})
    public static String getAndroidId() {
        try {
            String androidID = Settings.Secure.getString(ClientProperties.getApplicationContext().getContentResolver(), "android_id");
            return androidID;
        } catch (Exception e) {
            DeviceLog.exception("Problems fetching androidId", e);
            return null;
        }
    }

    public static String getAdvertisingTrackingId() {
        return AdvertisingId.getAdvertisingTrackingId();
    }

    public static boolean isLimitAdTrackingEnabled() {
        return AdvertisingId.getLimitedAdTracking();
    }

    public static boolean isUsingWifi() {
        ConnectivityManager mConnectivity;
        if (ClientProperties.getApplicationContext() == null || (mConnectivity = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        TelephonyManager mTelephony = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        NetworkInfo info = mConnectivity.getActiveNetworkInfo();
        if (info == null || !mConnectivity.getBackgroundDataSetting() || !mConnectivity.getActiveNetworkInfo().isConnected() || mTelephony == null) {
            return false;
        }
        int netType = info.getType();
        return netType == 1 && info.isConnected();
    }

    public static int getNetworkType() {
        if (ClientProperties.getApplicationContext() == null) {
            return -1;
        }
        TelephonyManager tm = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        return tm.getNetworkType();
    }

    public static String getNetworkOperator() {
        if (ClientProperties.getApplicationContext() == null) {
            return "";
        }
        TelephonyManager tm = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        return tm.getNetworkOperator();
    }

    public static String getNetworkOperatorName() {
        if (ClientProperties.getApplicationContext() == null) {
            return "";
        }
        TelephonyManager tm = (TelephonyManager) ClientProperties.getApplicationContext().getSystemService("phone");
        return tm.getNetworkOperatorName();
    }

    public static int getScreenDensity() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
        }
        return -1;
    }

    public static int getScreenWidth() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        }
        return -1;
    }

    public static int getScreenHeight() {
        if (ClientProperties.getApplicationContext() != null) {
            return ClientProperties.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        }
        return -1;
    }

    public static boolean isActiveNetworkConnected() {
        ConnectivityManager cm;
        NetworkInfo activeNetwork;
        return (ClientProperties.getApplicationContext() == null || (cm = (ConnectivityManager) ClientProperties.getApplicationContext().getSystemService("connectivity")) == null || (activeNetwork = cm.getActiveNetworkInfo()) == null || !activeNetwork.isConnected()) ? false : true;
    }

    public static boolean isAppInstalled(String pkgname) {
        if (ClientProperties.getApplicationContext() == null) {
            return false;
        }
        PackageManager pm = ClientProperties.getApplicationContext().getPackageManager();
        try {
            PackageInfo pkgInfo = pm.getPackageInfo(pkgname, 0);
            return (pkgInfo == null || pkgInfo.packageName == null || !pkgname.equals(pkgInfo.packageName)) ? false : true;
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Couldn't find package: " + pkgname, e);
            return false;
        }
    }

    public static List<Map<String, Object>> getInstalledPackages(boolean hash) {
        List<Map<String, Object>> returnList = new ArrayList<>();
        if (ClientProperties.getApplicationContext() != null) {
            PackageManager pm = ClientProperties.getApplicationContext().getPackageManager();
            for (PackageInfo pkg : pm.getInstalledPackages(0)) {
                HashMap<String, Object> packageEntry = new HashMap<>();
                if (hash) {
                    packageEntry.put("name", Utilities.Sha256(pkg.packageName));
                } else {
                    packageEntry.put("name", pkg.packageName);
                }
                if (pkg.firstInstallTime > 0) {
                    packageEntry.put("time", Long.valueOf(pkg.firstInstallTime));
                }
                String installer = pm.getInstallerPackageName(pkg.packageName);
                if (installer != null && !installer.isEmpty()) {
                    packageEntry.put("installer", installer);
                }
                returnList.add(packageEntry);
            }
        }
        return returnList;
    }

    public static String getUniqueEventId() {
        return UUID.randomUUID().toString();
    }

    public static boolean isWiredHeadsetOn() {
        if (ClientProperties.getApplicationContext() == null) {
            return false;
        }
        AudioManager am = (AudioManager) ClientProperties.getApplicationContext().getSystemService("audio");
        return am.isWiredHeadsetOn();
    }

    public static String getSystemProperty(String propertyName, String defaultValue) {
        return defaultValue != null ? System.getProperty(propertyName, defaultValue) : System.getProperty(propertyName);
    }

    public static int getRingerMode() {
        if (ClientProperties.getApplicationContext() != null) {
            AudioManager am = (AudioManager) ClientProperties.getApplicationContext().getSystemService("audio");
            if (am != null) {
                return am.getRingerMode();
            }
            return -2;
        }
        return -1;
    }

    public static int getStreamVolume(int streamType) {
        if (ClientProperties.getApplicationContext() != null) {
            AudioManager am = (AudioManager) ClientProperties.getApplicationContext().getSystemService("audio");
            if (am != null) {
                return am.getStreamVolume(streamType);
            }
            return -2;
        }
        return -1;
    }

    public static int getScreenBrightness() {
        if (ClientProperties.getApplicationContext() != null) {
            return Settings.System.getInt(ClientProperties.getApplicationContext().getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    public static long getFreeSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return Math.round(file.getFreeSpace() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    }

    public static long getTotalSpace(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        return Math.round(file.getTotalSpace() / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID);
    }

    public static float getBatteryLevel() {
        Intent i;
        if (ClientProperties.getApplicationContext() == null || (i = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        int level = i.getIntExtra("level", -1);
        int scale = i.getIntExtra("scale", -1);
        return level / scale;
    }

    public static int getBatteryStatus() {
        Intent i;
        if (ClientProperties.getApplicationContext() == null || (i = ClientProperties.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1;
        }
        return i.getIntExtra("status", -1);
    }

    public static long getTotalMemory() {
        return getMemoryInfo(MemoryInfoType.TOTAL_MEMORY);
    }

    public static long getFreeMemory() {
        return getMemoryInfo(MemoryInfoType.FREE_MEMORY);
    }

    private static long getMemoryInfo(MemoryInfoType infoType) throws Throwable {
        int lineNumber = -1;
        switch (infoType) {
            case TOTAL_MEMORY:
                lineNumber = 1;
                break;
            case FREE_MEMORY:
                lineNumber = 2;
                break;
        }
        RandomAccessFile reader = null;
        String line = null;
        try {
            RandomAccessFile reader2 = new RandomAccessFile("/proc/meminfo", "r");
            for (int i = 0; i < lineNumber; i++) {
                try {
                    line = reader2.readLine();
                } catch (IOException e) {
                    e = e;
                    reader = reader2;
                    DeviceLog.exception("Error while reading memory info: " + infoType, e);
                    try {
                        reader.close();
                    } catch (IOException e2) {
                        DeviceLog.exception("Error closing RandomAccessFile", e2);
                    }
                    return -1L;
                } catch (Throwable th) {
                    th = th;
                    reader = reader2;
                    try {
                        reader.close();
                    } catch (IOException e3) {
                        DeviceLog.exception("Error closing RandomAccessFile", e3);
                    }
                    throw th;
                }
            }
            long memoryValueFromString = getMemoryValueFromString(line);
            try {
                reader2.close();
            } catch (IOException e4) {
                DeviceLog.exception("Error closing RandomAccessFile", e4);
            }
            return memoryValueFromString;
        } catch (IOException e5) {
            e = e5;
        }
    }

    private static long getMemoryValueFromString(String memVal) {
        if (memVal == null) {
            return -1L;
        }
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(memVal);
        String value = "";
        while (m.find()) {
            value = m.group(1);
        }
        return Long.parseLong(value);
    }

    public static boolean isRooted() {
        try {
            return searchPathForBinary("su");
        } catch (Exception e) {
            DeviceLog.exception("Rooted check failed", e);
            return false;
        }
    }

    private static boolean searchPathForBinary(String binary) {
        File[] pathDirFiles;
        String[] paths = System.getenv("PATH").split(":");
        for (String path : paths) {
            File pathDir = new File(path);
            if (pathDir.exists() && pathDir.isDirectory() && (pathDirFiles = pathDir.listFiles()) != null) {
                for (File fileInPath : pathDirFiles) {
                    if (fileInPath.getName().equals(binary)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String getGLVersion() {
        ActivityManager activityManager;
        ConfigurationInfo configurationInfo;
        if (ClientProperties.getApplicationContext() == null || (activityManager = (ActivityManager) ClientProperties.getApplicationContext().getSystemService("activity")) == null || (configurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
            return null;
        }
        return configurationInfo.getGlEsVersion();
    }

    public static String getBoard() {
        return Build.BOARD;
    }

    public static String getBootloader() {
        return Build.BOOTLOADER;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getHardware() {
        return Build.HARDWARE;
    }

    public static String getHost() {
        return Build.HOST;
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    public static ArrayList<String> getSupportedAbis() {
        return getApiLevel() < 21 ? getOldAbiList() : getNewAbiList();
    }

    public static List<Sensor> getSensorList() {
        if (ClientProperties.getApplicationContext() == null) {
            return null;
        }
        SensorManager sensorManager = (SensorManager) ClientProperties.getApplicationContext().getSystemService("sensor");
        return sensorManager.getSensorList(-1);
    }

    private static ArrayList<String> getOldAbiList() {
        ArrayList<String> abiList = new ArrayList<>();
        abiList.add(Build.CPU_ABI);
        abiList.add(Build.CPU_ABI2);
        return abiList;
    }

    @TargetApi(21)
    private static ArrayList<String> getNewAbiList() {
        ArrayList<String> abiList = new ArrayList<>();
        abiList.addAll(Arrays.asList(Build.SUPPORTED_ABIS));
        return abiList;
    }
}
