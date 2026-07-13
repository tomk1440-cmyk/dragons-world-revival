package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String cacheKey) {
        Validate.notNull(context, "context");
        this.cacheKey = Utility.isNullOrEmpty(cacheKey) ? DEFAULT_CACHE_KEY : cacheKey;
        Context applicationContext = context.getApplicationContext();
        this.cache = (applicationContext != null ? applicationContext : context).getSharedPreferences(this.cacheKey, 0);
    }

    public Bundle load() {
        Bundle settings = new Bundle();
        Map<String, ?> allCachedEntries = this.cache.getAll();
        for (String key : allCachedEntries.keySet()) {
            try {
                deserializeKey(key, settings);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + key + "' -- " + e);
                return null;
            }
        }
        return settings;
    }

    public void save(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        SharedPreferences.Editor editor = this.cache.edit();
        for (String key : bundle.keySet()) {
            try {
                serializeKey(key, bundle, editor);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + key + "' -- " + e);
                return;
            }
        }
        editor.apply();
    }

    public void clear() {
        this.cache.edit().clear().apply();
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        String token;
        if (bundle == null || (token = bundle.getString(TOKEN_KEY)) == null || token.length() == 0) {
            return false;
        }
        long expiresMilliseconds = bundle.getLong(EXPIRATION_DATE_KEY, 0L);
        return expiresMilliseconds != 0;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(TOKEN_KEY);
    }

    public static void putToken(Bundle bundle, String value) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(value, JSON_VALUE);
        bundle.putString(TOKEN_KEY, value);
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, EXPIRATION_DATE_KEY);
    }

    public static void putExpirationDate(Bundle bundle, Date value) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(value, JSON_VALUE);
        putDate(bundle, EXPIRATION_DATE_KEY, value);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(EXPIRATION_DATE_KEY);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long value) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(EXPIRATION_DATE_KEY, value);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        ArrayList<String> arrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (arrayList == null) {
            return null;
        }
        return new HashSet(arrayList);
    }

    public static void putPermissions(Bundle bundle, Collection<String> value) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(value, JSON_VALUE);
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList<>(value));
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> value) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(value, JSON_VALUE);
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList<>(value));
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey(TOKEN_SOURCE_KEY)) {
            return (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY);
        }
        boolean isSSO = bundle.getBoolean(IS_SSO_KEY);
        return isSSO ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static void putSource(Bundle bundle, AccessTokenSource value) {
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable(TOKEN_SOURCE_KEY, value);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshDate(Bundle bundle, Date value) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(value, JSON_VALUE);
        putDate(bundle, LAST_REFRESH_DATE_KEY, value);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long value) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(LAST_REFRESH_DATE_KEY, value);
    }

    public static String getApplicationId(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(APPLICATION_ID_KEY);
    }

    public static void putApplicationId(Bundle bundle, String value) {
        Validate.notNull(bundle, "bundle");
        bundle.putString(APPLICATION_ID_KEY, value);
    }

    static Date getDate(Bundle bundle, String key) {
        if (bundle == null) {
            return null;
        }
        long n = bundle.getLong(key, INVALID_BUNDLE_MILLISECONDS);
        if (n != INVALID_BUNDLE_MILLISECONDS) {
            return new Date(n);
        }
        return null;
    }

    static void putDate(Bundle bundle, String key, Date date) {
        bundle.putLong(key, date.getTime());
    }

    private void serializeKey(String key, Bundle bundle, SharedPreferences.Editor editor) throws JSONException {
        int i = 0;
        Object value = bundle.get(key);
        if (value != null) {
            String supportedType = null;
            JSONArray jsonArray = null;
            JSONObject json = new JSONObject();
            if (value instanceof Byte) {
                supportedType = TYPE_BYTE;
                json.put(JSON_VALUE, ((Byte) value).intValue());
            } else if (value instanceof Short) {
                supportedType = TYPE_SHORT;
                json.put(JSON_VALUE, ((Short) value).intValue());
            } else if (value instanceof Integer) {
                supportedType = TYPE_INTEGER;
                json.put(JSON_VALUE, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                supportedType = "long";
                json.put(JSON_VALUE, ((Long) value).longValue());
            } else if (value instanceof Float) {
                supportedType = TYPE_FLOAT;
                json.put(JSON_VALUE, ((Float) value).doubleValue());
            } else if (value instanceof Double) {
                supportedType = TYPE_DOUBLE;
                json.put(JSON_VALUE, ((Double) value).doubleValue());
            } else if (value instanceof Boolean) {
                supportedType = TYPE_BOOLEAN;
                json.put(JSON_VALUE, ((Boolean) value).booleanValue());
            } else if (value instanceof Character) {
                supportedType = TYPE_CHAR;
                json.put(JSON_VALUE, value.toString());
            } else if (value instanceof String) {
                supportedType = TYPE_STRING;
                json.put(JSON_VALUE, (String) value);
            } else if (value instanceof Enum) {
                supportedType = TYPE_ENUM;
                json.put(JSON_VALUE, value.toString());
                json.put(JSON_VALUE_ENUM_TYPE, value.getClass().getName());
            } else {
                jsonArray = new JSONArray();
                if (value instanceof byte[]) {
                    supportedType = TYPE_BYTE_ARRAY;
                    byte[] bArr = (byte[]) value;
                    int length = bArr.length;
                    while (i < length) {
                        byte v = bArr[i];
                        jsonArray.put((int) v);
                        i++;
                    }
                } else if (value instanceof short[]) {
                    supportedType = TYPE_SHORT_ARRAY;
                    short[] sArr = (short[]) value;
                    int length2 = sArr.length;
                    while (i < length2) {
                        short v2 = sArr[i];
                        jsonArray.put((int) v2);
                        i++;
                    }
                } else if (value instanceof int[]) {
                    supportedType = TYPE_INTEGER_ARRAY;
                    int[] iArr = (int[]) value;
                    int length3 = iArr.length;
                    while (i < length3) {
                        int v3 = iArr[i];
                        jsonArray.put(v3);
                        i++;
                    }
                } else if (value instanceof long[]) {
                    supportedType = TYPE_LONG_ARRAY;
                    long[] jArr = (long[]) value;
                    int length4 = jArr.length;
                    while (i < length4) {
                        long v4 = jArr[i];
                        jsonArray.put(v4);
                        i++;
                    }
                } else if (value instanceof float[]) {
                    supportedType = TYPE_FLOAT_ARRAY;
                    float[] fArr = (float[]) value;
                    int length5 = fArr.length;
                    while (i < length5) {
                        float v5 = fArr[i];
                        jsonArray.put(v5);
                        i++;
                    }
                } else if (value instanceof double[]) {
                    supportedType = TYPE_DOUBLE_ARRAY;
                    double[] dArr = (double[]) value;
                    int length6 = dArr.length;
                    while (i < length6) {
                        double v6 = dArr[i];
                        jsonArray.put(v6);
                        i++;
                    }
                } else if (value instanceof boolean[]) {
                    supportedType = TYPE_BOOLEAN_ARRAY;
                    boolean[] zArr = (boolean[]) value;
                    int length7 = zArr.length;
                    while (i < length7) {
                        boolean v7 = zArr[i];
                        jsonArray.put(v7);
                        i++;
                    }
                } else if (value instanceof char[]) {
                    supportedType = TYPE_CHAR_ARRAY;
                    char[] cArr = (char[]) value;
                    int length8 = cArr.length;
                    while (i < length8) {
                        char v8 = cArr[i];
                        jsonArray.put(String.valueOf(v8));
                        i++;
                    }
                } else if (value instanceof List) {
                    supportedType = TYPE_STRING_LIST;
                    List<String> stringList = (List) value;
                    for (String str : stringList) {
                        if (str == null) {
                            str = JSONObject.NULL;
                        }
                        jsonArray.put(str);
                    }
                } else {
                    jsonArray = null;
                }
            }
            if (supportedType != null) {
                json.put(JSON_VALUE_TYPE, supportedType);
                if (jsonArray != null) {
                    json.putOpt(JSON_VALUE, jsonArray);
                }
                String jsonString = json.toString();
                editor.putString(key, jsonString);
            }
        }
    }

    private void deserializeKey(String key, Bundle bundle) throws JSONException {
        String jsonString = this.cache.getString(key, "{}");
        JSONObject json = new JSONObject(jsonString);
        String valueType = json.getString(JSON_VALUE_TYPE);
        if (valueType.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(key, json.getBoolean(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_BOOLEAN_ARRAY)) {
            JSONArray jsonArray = json.getJSONArray(JSON_VALUE);
            boolean[] array = new boolean[jsonArray.length()];
            for (int i = 0; i < array.length; i++) {
                array[i] = jsonArray.getBoolean(i);
            }
            bundle.putBooleanArray(key, array);
            return;
        }
        if (valueType.equals(TYPE_BYTE)) {
            bundle.putByte(key, (byte) json.getInt(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_BYTE_ARRAY)) {
            JSONArray jsonArray2 = json.getJSONArray(JSON_VALUE);
            byte[] array2 = new byte[jsonArray2.length()];
            for (int i2 = 0; i2 < array2.length; i2++) {
                array2[i2] = (byte) jsonArray2.getInt(i2);
            }
            bundle.putByteArray(key, array2);
            return;
        }
        if (valueType.equals(TYPE_SHORT)) {
            bundle.putShort(key, (short) json.getInt(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_SHORT_ARRAY)) {
            JSONArray jsonArray3 = json.getJSONArray(JSON_VALUE);
            short[] array3 = new short[jsonArray3.length()];
            for (int i3 = 0; i3 < array3.length; i3++) {
                array3[i3] = (short) jsonArray3.getInt(i3);
            }
            bundle.putShortArray(key, array3);
            return;
        }
        if (valueType.equals(TYPE_INTEGER)) {
            bundle.putInt(key, json.getInt(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_INTEGER_ARRAY)) {
            JSONArray jsonArray4 = json.getJSONArray(JSON_VALUE);
            int[] array4 = new int[jsonArray4.length()];
            for (int i4 = 0; i4 < array4.length; i4++) {
                array4[i4] = jsonArray4.getInt(i4);
            }
            bundle.putIntArray(key, array4);
            return;
        }
        if (valueType.equals("long")) {
            bundle.putLong(key, json.getLong(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_LONG_ARRAY)) {
            JSONArray jsonArray5 = json.getJSONArray(JSON_VALUE);
            long[] array5 = new long[jsonArray5.length()];
            for (int i5 = 0; i5 < array5.length; i5++) {
                array5[i5] = jsonArray5.getLong(i5);
            }
            bundle.putLongArray(key, array5);
            return;
        }
        if (valueType.equals(TYPE_FLOAT)) {
            bundle.putFloat(key, (float) json.getDouble(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_FLOAT_ARRAY)) {
            JSONArray jsonArray6 = json.getJSONArray(JSON_VALUE);
            float[] array6 = new float[jsonArray6.length()];
            for (int i6 = 0; i6 < array6.length; i6++) {
                array6[i6] = (float) jsonArray6.getDouble(i6);
            }
            bundle.putFloatArray(key, array6);
            return;
        }
        if (valueType.equals(TYPE_DOUBLE)) {
            bundle.putDouble(key, json.getDouble(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_DOUBLE_ARRAY)) {
            JSONArray jsonArray7 = json.getJSONArray(JSON_VALUE);
            double[] array7 = new double[jsonArray7.length()];
            for (int i7 = 0; i7 < array7.length; i7++) {
                array7[i7] = jsonArray7.getDouble(i7);
            }
            bundle.putDoubleArray(key, array7);
            return;
        }
        if (valueType.equals(TYPE_CHAR)) {
            String charString = json.getString(JSON_VALUE);
            if (charString != null && charString.length() == 1) {
                bundle.putChar(key, charString.charAt(0));
                return;
            }
            return;
        }
        if (valueType.equals(TYPE_CHAR_ARRAY)) {
            JSONArray jsonArray8 = json.getJSONArray(JSON_VALUE);
            char[] array8 = new char[jsonArray8.length()];
            for (int i8 = 0; i8 < array8.length; i8++) {
                String charString2 = jsonArray8.getString(i8);
                if (charString2 != null && charString2.length() == 1) {
                    array8[i8] = charString2.charAt(0);
                }
            }
            bundle.putCharArray(key, array8);
            return;
        }
        if (valueType.equals(TYPE_STRING)) {
            bundle.putString(key, json.getString(JSON_VALUE));
            return;
        }
        if (valueType.equals(TYPE_STRING_LIST)) {
            JSONArray jsonArray9 = json.getJSONArray(JSON_VALUE);
            int numStrings = jsonArray9.length();
            ArrayList<String> stringList = new ArrayList<>(numStrings);
            for (int i9 = 0; i9 < numStrings; i9++) {
                Object jsonStringValue = jsonArray9.get(i9);
                stringList.add(i9, jsonStringValue == JSONObject.NULL ? null : (String) jsonStringValue);
            }
            bundle.putStringArrayList(key, stringList);
            return;
        }
        if (valueType.equals(TYPE_ENUM)) {
            try {
                String enumType = json.getString(JSON_VALUE_ENUM_TYPE);
                Enum<?> enumValue = Enum.valueOf(Class.forName(enumType), json.getString(JSON_VALUE));
                bundle.putSerializable(key, enumValue);
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }
}
