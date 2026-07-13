package com.adjust.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.Settings;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    private static final String fieldReadErrorMessage = "Unable to read '%s' field in migration device with message (%s)";
    private static String userAgent;
    public static final DecimalFormat SecondsDisplayFormat = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME);
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z";
    public static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);

    private static ILogger getLogger() {
        return AdjustFactory.getLogger();
    }

    protected static String createUuid() {
        return UUID.randomUUID().toString();
    }

    public static String quote(String string) {
        if (string == null) {
            return null;
        }
        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(string);
        return matcher.find() ? String.format(Locale.US, "'%s'", string) : string;
    }

    public static String getPlayAdId(Context context) {
        return Reflection.getPlayAdId(context);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.adjust.sdk.Util$1] */
    public static void getGoogleAdId(Context context, final OnDeviceIdsRead onDeviceIdRead) {
        ILogger logger = AdjustFactory.getLogger();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            logger.debug("GoogleAdId being read in the background", new Object[0]);
            String GoogleAdId = getPlayAdId(context);
            logger.debug("GoogleAdId read " + GoogleAdId, new Object[0]);
            onDeviceIdRead.onGoogleAdIdRead(GoogleAdId);
            return;
        }
        logger.debug("GoogleAdId being read in the foreground", new Object[0]);
        new AsyncTask<Context, Void, String>() { // from class: com.adjust.sdk.Util.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public String doInBackground(Context... params) {
                ILogger logger2 = AdjustFactory.getLogger();
                Context innerContext = params[0];
                String innerResult = Util.getPlayAdId(innerContext);
                logger2.debug("GoogleAdId read " + innerResult, new Object[0]);
                return innerResult;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public void onPostExecute(String playAdiId) {
                AdjustFactory.getLogger();
                onDeviceIdRead.onGoogleAdIdRead(playAdiId);
            }
        }.execute(context);
    }

    public static Boolean isPlayTrackingEnabled(Context context) {
        return Reflection.isPlayTrackingEnabled(context);
    }

    public static String getMacAddress(Context context) {
        return Reflection.getMacAddress(context);
    }

    public static Map<String, String> getPluginKeys(Context context) {
        return Reflection.getPluginKeys(context);
    }

    public static String getAndroidId(Context context) {
        return Reflection.getAndroidId(context);
    }

    public static <T> T readObject(Context context, String filename, String objectName, Class<T> type) {
        Closeable closable = null;
        T object = null;
        try {
            try {
                FileInputStream inputStream = context.openFileInput(filename);
                BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
                ObjectInputStream objectStream = new ObjectInputStream(bufferedStream);
                closable = objectStream;
                try {
                    object = type.cast(objectStream.readObject());
                    getLogger().debug("Read %s: %s", objectName, object);
                } catch (ClassCastException e) {
                    getLogger().error("Failed to cast %s object (%s)", objectName, e.getMessage());
                } catch (ClassNotFoundException e2) {
                    getLogger().error("Failed to find %s class (%s)", objectName, e2.getMessage());
                } catch (Exception e3) {
                    getLogger().error("Failed to read %s object (%s)", objectName, e3.getMessage());
                }
            } catch (Exception e4) {
                getLogger().error("Failed to open %s file for reading (%s)", objectName, e4);
            }
        } catch (FileNotFoundException e5) {
            getLogger().debug("%s file not found", objectName);
        }
        if (closable != null) {
            try {
                closable.close();
            } catch (Exception e6) {
                getLogger().error("Failed to close %s file for reading (%s)", objectName, e6);
            }
        }
        return object;
    }

    public static <T> void writeObject(T object, Context context, String filename, String objectName) {
        Closeable closable = null;
        try {
            FileOutputStream outputStream = context.openFileOutput(filename, 0);
            BufferedOutputStream bufferedStream = new BufferedOutputStream(outputStream);
            ObjectOutputStream objectStream = new ObjectOutputStream(bufferedStream);
            closable = objectStream;
            try {
                objectStream.writeObject(object);
                getLogger().debug("Wrote %s: %s", objectName, object);
            } catch (NotSerializableException e) {
                getLogger().error("Failed to serialize %s", objectName);
            }
        } catch (Exception e2) {
            getLogger().error("Failed to open %s for writing (%s)", objectName, e2);
        }
        if (closable != null) {
            try {
                closable.close();
            } catch (Exception e3) {
                getLogger().error("Failed to close %s file for writing (%s)", objectName, e3);
            }
        }
    }

    public static ResponseData readHttpResponse(HttpsURLConnection connection, ActivityPackage activityPackage) throws Exception {
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        ILogger logger = getLogger();
        try {
            try {
                connection.connect();
                Integer responseCode = Integer.valueOf(connection.getResponseCode());
                if (responseCode.intValue() >= 400) {
                    inputStream = connection.getErrorStream();
                } else {
                    inputStream = connection.getInputStream();
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                if (connection != null) {
                    connection.disconnect();
                }
                ResponseData responseData = ResponseData.buildResponseData(activityPackage);
                String stringResponse = sb.toString();
                logger.verbose("Response: %s", stringResponse);
                if (stringResponse != null && stringResponse.length() != 0) {
                    JSONObject jsonResponse = null;
                    try {
                        JSONObject jsonResponse2 = new JSONObject(stringResponse);
                        jsonResponse = jsonResponse2;
                    } catch (JSONException e) {
                        String message = String.format("Failed to parse json response. (%s)", e.getMessage());
                        logger.error(message, new Object[0]);
                        responseData.message = message;
                    }
                    if (jsonResponse != null) {
                        responseData.jsonResponse = jsonResponse;
                        String message2 = jsonResponse.optString("message", null);
                        responseData.message = message2;
                        responseData.timestamp = jsonResponse.optString("timestamp", null);
                        responseData.adid = jsonResponse.optString("adid", null);
                        if (message2 == null) {
                            message2 = "No message found";
                        }
                        if (responseCode != null && responseCode.intValue() == 200) {
                            logger.info("%s", message2);
                            responseData.success = true;
                        } else {
                            logger.error("%s", message2);
                        }
                    }
                }
                return responseData;
            } catch (Exception e2) {
                logger.error("Failed to read response. (%s)", e2.getMessage());
                throw e2;
            }
        } catch (Throwable th) {
            if (connection != null) {
                connection.disconnect();
            }
            throw th;
        }
    }

    public static AdjustFactory.URLGetConnection createGETHttpsURLConnection(String urlString, String clientSdk) throws IOException {
        try {
            URL url = new URL(urlString);
            AdjustFactory.URLGetConnection urlGetConnection = AdjustFactory.getHttpsURLGetConnection(url);
            HttpsURLConnection connection = urlGetConnection.httpsURLConnection;
            setDefaultHttpsUrlConnectionProperties(connection, clientSdk);
            connection.setRequestMethod(HttpRequest.METHOD_GET);
            return urlGetConnection;
        } catch (IOException e) {
            throw e;
        }
    }

    public static HttpsURLConnection createPOSTHttpsURLConnection(String urlString, String clientSdk, Map<String, String> parameters, int queueSize) throws Throwable {
        DataOutputStream wr = null;
        try {
            try {
                URL url = new URL(urlString);
                HttpsURLConnection connection = AdjustFactory.getHttpsURLConnection(url);
                setDefaultHttpsUrlConnectionProperties(connection, clientSdk);
                connection.setRequestMethod(HttpRequest.METHOD_POST);
                connection.setUseCaches(false);
                connection.setDoInput(true);
                connection.setDoOutput(true);
                DataOutputStream wr2 = new DataOutputStream(connection.getOutputStream());
                try {
                    wr2.writeBytes(getPostDataString(parameters, queueSize));
                    if (wr2 != null) {
                        try {
                            wr2.flush();
                            wr2.close();
                        } catch (Exception e) {
                        }
                    }
                    return connection;
                } catch (IOException e2) {
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    wr = wr2;
                    if (wr != null) {
                        try {
                            wr.flush();
                            wr.close();
                        } catch (Exception e3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                throw e4;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String getPostDataString(Map<String, String> body, int queueSize) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : body.entrySet()) {
            String encodedName = URLEncoder.encode(entry.getKey(), "UTF-8");
            String value = entry.getValue();
            String encodedValue = value != null ? URLEncoder.encode(value, "UTF-8") : "";
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(encodedName);
            result.append("=");
            result.append(encodedValue);
        }
        long now = System.currentTimeMillis();
        String dateString = dateFormatter.format(Long.valueOf(now));
        result.append("&");
        result.append(URLEncoder.encode("sent_at", "UTF-8"));
        result.append("=");
        result.append(URLEncoder.encode(dateString, "UTF-8"));
        if (queueSize > 0) {
            result.append("&");
            result.append(URLEncoder.encode("queue_size", "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode("" + queueSize, "UTF-8"));
        }
        return result.toString();
    }

    public static void setDefaultHttpsUrlConnectionProperties(HttpsURLConnection connection, String clientSdk) {
        connection.setRequestProperty("Client-SDK", clientSdk);
        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);
        if (userAgent != null) {
            connection.setRequestProperty("User-Agent", userAgent);
        }
    }

    public static boolean checkPermission(Context context, String permission) {
        int result = context.checkCallingOrSelfPermission(permission);
        return result == 0;
    }

    public static String readStringField(ObjectInputStream.GetField fields, String name, String defaultValue) {
        return (String) readObjectField(fields, name, defaultValue);
    }

    public static <T> T readObjectField(ObjectInputStream.GetField getField, String str, T t) {
        try {
            return (T) getField.get(str, t);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, str, e.getMessage());
            return t;
        }
    }

    public static boolean readBooleanField(ObjectInputStream.GetField fields, String name, boolean defaultValue) {
        try {
            return fields.get(name, defaultValue);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, name, e.getMessage());
            return defaultValue;
        }
    }

    public static int readIntField(ObjectInputStream.GetField fields, String name, int defaultValue) {
        try {
            return fields.get(name, defaultValue);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, name, e.getMessage());
            return defaultValue;
        }
    }

    public static long readLongField(ObjectInputStream.GetField fields, String name, long defaultValue) {
        try {
            return fields.get(name, defaultValue);
        } catch (Exception e) {
            getLogger().debug(fieldReadErrorMessage, name, e.getMessage());
            return defaultValue;
        }
    }

    public static boolean equalObject(Object first, Object second) {
        if (first == null || second == null) {
            return first == null && second == null;
        }
        return first.equals(second);
    }

    public static boolean equalsDouble(Double first, Double second) {
        if (first == null || second == null) {
            return first == null && second == null;
        }
        return Double.doubleToLongBits(first.doubleValue()) == Double.doubleToLongBits(second.doubleValue());
    }

    public static boolean equalString(String first, String second) {
        return equalObject(first, second);
    }

    public static boolean equalEnum(Enum first, Enum second) {
        return equalObject(first, second);
    }

    public static boolean equalLong(Long first, Long second) {
        return equalObject(first, second);
    }

    public static boolean equalInt(Integer first, Integer second) {
        return equalObject(first, second);
    }

    public static boolean equalBoolean(Boolean first, Boolean second) {
        return equalObject(first, second);
    }

    public static int hashBoolean(Boolean value) {
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    public static int hashLong(Long value) {
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    public static int hashString(String value) {
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    public static int hashEnum(Enum value) {
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    public static int hashObject(Object value) {
        if (value == null) {
            return 0;
        }
        return value.hashCode();
    }

    public static String sha1(String text) {
        return hash(text, "SHA-1");
    }

    public static String md5(String text) {
        return hash(text, "MD5");
    }

    public static String hash(String text, String method) {
        try {
            byte[] bytes = text.getBytes("UTF-8");
            MessageDigest mesd = MessageDigest.getInstance(method);
            mesd.update(bytes, 0, bytes.length);
            byte[] hash = mesd.digest();
            String hashString = convertToHex(hash);
            return hashString;
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertToHex(byte[] bytes) {
        BigInteger bigInt = new BigInteger(1, bytes);
        String formatString = "%0" + (bytes.length << 1) + "x";
        return String.format(Locale.US, formatString, bigInt);
    }

    public static String[] getSupportedAbis() {
        return Reflection.getSupportedAbis();
    }

    public static String getCpuAbi() {
        return Reflection.getCpuAbi();
    }

    public static String getReasonString(String message, Throwable throwable) {
        return throwable != null ? String.format(Locale.US, "%s: %s", message, throwable) : String.format(Locale.US, "%s", message);
    }

    public static long getWaitingTime(int retries, BackoffStrategy backoffStrategy) {
        if (retries < backoffStrategy.minRetries) {
            return 0L;
        }
        int expon = retries - backoffStrategy.minRetries;
        long exponentialTime = ((long) Math.pow(2.0d, expon)) * backoffStrategy.milliSecondMultiplier;
        long ceilingTime = Math.min(exponentialTime, backoffStrategy.maxWait);
        double randomDouble = randomInRange(backoffStrategy.minRange, backoffStrategy.maxRange);
        double waitingTime = ceilingTime * randomDouble;
        return (long) waitingTime;
    }

    private static double randomInRange(double minRange, double maxRange) {
        Random random = new Random();
        double range = maxRange - minRange;
        double scaled = random.nextDouble() * range;
        double shifted = scaled + minRange;
        return shifted;
    }

    public static boolean isValidParameter(String attribute, String attributeType, String parameterName) {
        if (attribute == null) {
            getLogger().error("%s parameter %s is missing", parameterName, attributeType);
            return false;
        }
        if (!attribute.equals("")) {
            return true;
        }
        getLogger().error("%s parameter %s is empty", parameterName, attributeType);
        return false;
    }

    public static Map<String, String> mergeParameters(Map<String, String> target, Map<String, String> source, String parameterName) {
        if (target != null) {
            if (source == null) {
                return target;
            }
            Map<String, String> mergedParameters = new HashMap<>(target);
            ILogger logger = getLogger();
            for (Map.Entry<String, String> parameterSourceEntry : source.entrySet()) {
                String oldValue = mergedParameters.put(parameterSourceEntry.getKey(), parameterSourceEntry.getValue());
                if (oldValue != null) {
                    logger.warn("Key %s with value %s from %s parameter was replaced by value %s", parameterSourceEntry.getKey(), oldValue, parameterName, parameterSourceEntry.getValue());
                }
            }
            return mergedParameters;
        }
        return source;
    }

    public static void setUserAgent(String userAgent2) {
        userAgent = userAgent2;
    }

    public static String getVmInstructionSet() {
        return Reflection.getVmInstructionSet();
    }

    public static Locale getLocale(Configuration configuration) {
        Locale locale = Reflection.getLocaleFromLocaleList(configuration);
        return locale != null ? locale : Reflection.getLocaleFromField(configuration);
    }

    public static String getFireAdvertisingId(ContentResolver contentResolver) {
        if (contentResolver == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean getFireTrackingEnabled(ContentResolver contentResolver) {
        try {
            return Boolean.valueOf(Settings.Secure.getInt(contentResolver, "limit_ad_tracking") == 0);
        } catch (Exception e) {
            return null;
        }
    }
}
