package com.adjust.sdk;

import android.content.Context;
import android.content.res.Configuration;
import com.adjust.sdk.plugin.Plugin;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class Reflection {
    public static Object getVMRuntimeObject() {
        try {
            return invokeStaticMethod("dalvik.system.VMRuntime", "getRuntime", null, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getVmInstructionSet() {
        try {
            Object VMRuntimeObject = getVMRuntimeObject();
            return (String) invokeInstanceMethod(VMRuntimeObject, "vmInstructionSet", null, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getPlayAdId(Context context) {
        try {
            Object AdvertisingInfoObject = getAdvertisingInfoObject(context);
            return (String) invokeInstanceMethod(AdvertisingInfoObject, "getId", null, new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Boolean isPlayTrackingEnabled(Context context) {
        try {
            Object AdvertisingInfoObject = getAdvertisingInfoObject(context);
            Boolean isLimitedTrackingEnabled = (Boolean) invokeInstanceMethod(AdvertisingInfoObject, "isLimitAdTrackingEnabled", null, new Object[0]);
            if (isLimitedTrackingEnabled == null) {
                return null;
            }
            return Boolean.valueOf(isLimitedTrackingEnabled.booleanValue() ? false : true);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getMacAddress(Context context) {
        try {
            return (String) invokeStaticMethod("com.adjust.sdk.plugin.MacAddressUtil", "getMacAddress", new Class[]{Context.class}, context);
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getAndroidId(Context context) {
        try {
            return (String) invokeStaticMethod("com.adjust.sdk.plugin.AndroidIdUtil", "getAndroidId", new Class[]{Context.class}, context);
        } catch (Throwable th) {
            return null;
        }
    }

    private static Object getAdvertisingInfoObject(Context context) throws Exception {
        return invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    public static String[] getSupportedAbis() {
        try {
            String[] supportedAbis = (String[]) readField("android.os.Build", "SUPPORTED_ABIS");
            return supportedAbis;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getCpuAbi() {
        try {
            String cpuAbi = (String) readField("android.os.Build", "CPU_ABI");
            return cpuAbi;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Locale getLocaleFromLocaleList(Configuration configuration) {
        Locale locale = null;
        try {
            Object localesList = invokeInstanceMethod(configuration, "getLocales", null, new Object[0]);
            if (localesList == null) {
                return null;
            }
            locale = (Locale) invokeInstanceMethod(localesList, "get", new Class[]{Integer.TYPE}, 0);
        } catch (Throwable th) {
        }
        return locale;
    }

    public static Locale getLocaleFromField(Configuration configuration) {
        try {
            Locale locale = (Locale) readField("android.content.res.Configuration", "locale", configuration);
            return locale;
        } catch (Throwable th) {
            return null;
        }
    }

    public static Class forName(String className) {
        try {
            return Class.forName(className);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object createDefaultInstance(String className) {
        Class classObject = forName(className);
        Object instance = createDefaultInstance(classObject);
        return instance;
    }

    public static Object createDefaultInstance(Class classObject) {
        try {
            return classObject.newInstance();
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object createInstance(String className, Class[] cArgs, Object... args) {
        try {
            return Class.forName(className).getConstructor(cArgs).newInstance(args);
        } catch (Throwable th) {
            return null;
        }
    }

    public static Object invokeStaticMethod(String className, String methodName, Class[] cArgs, Object... args) throws Exception {
        return invokeMethod(Class.forName(className), methodName, null, cArgs, args);
    }

    public static Object invokeInstanceMethod(Object instance, String methodName, Class[] cArgs, Object... args) throws Exception {
        return invokeMethod(instance.getClass(), methodName, instance, cArgs, args);
    }

    public static Object invokeMethod(Class classObject, String methodName, Object instance, Class[] cArgs, Object... args) throws Exception {
        Method methodObject = classObject.getMethod(methodName, cArgs);
        if (methodObject == null) {
            return null;
        }
        return methodObject.invoke(instance, args);
    }

    public static Object readField(String className, String fieldName) throws Exception {
        return readField(className, fieldName, null);
    }

    public static Object readField(String className, String fieldName, Object instance) throws Exception {
        Field fieldObject;
        Class classObject = forName(className);
        if (classObject == null || (fieldObject = classObject.getField(fieldName)) == null) {
            return null;
        }
        return fieldObject.get(instance);
    }

    public static Map<String, String> getPluginKeys(Context context) {
        Map<String, String> pluginKeys = new HashMap<>();
        for (Plugin plugin : getPlugins()) {
            Map.Entry<String, String> pluginEntry = plugin.getParameter(context);
            if (pluginEntry != null) {
                pluginKeys.put(pluginEntry.getKey(), pluginEntry.getValue());
            }
        }
        if (pluginKeys.size() == 0) {
            return null;
        }
        return pluginKeys;
    }

    private static List<Plugin> getPlugins() {
        List<Plugin> plugins = new ArrayList<>(Constants.PLUGINS.size());
        for (String pluginName : Constants.PLUGINS) {
            Object pluginObject = createDefaultInstance(pluginName);
            if (pluginObject != null && (pluginObject instanceof Plugin)) {
                plugins.add((Plugin) pluginObject);
            }
        }
        return plugins;
    }
}
