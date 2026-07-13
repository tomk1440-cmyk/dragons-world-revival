package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class MetaDataStore {
    private static final String KEYDATA_SUFFIX = "keys";
    private static final String KEY_USER_EMAIL = "userEmail";
    private static final String KEY_USER_ID = "userId";
    private static final String KEY_USER_NAME = "userName";
    private static final String METADATA_EXT = ".meta";
    private static final String USERDATA_SUFFIX = "user";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final File filesDir;

    public MetaDataStore(File filesDir) {
        this.filesDir = filesDir;
    }

    public void writeUserData(String sessionId, UserMetaData data) throws Throwable {
        File f = getUserDataFileForSession(sessionId);
        Writer writer = null;
        try {
            try {
                String userDataString = userDataToJson(data);
                Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), UTF_8));
                try {
                    writer2.write(userDataString);
                    writer2.flush();
                    CommonUtils.closeOrLog(writer2, "Failed to close user metadata file.");
                    writer = writer2;
                } catch (Exception e) {
                    e = e;
                    writer = writer2;
                    Fabric.getLogger().e(CrashlyticsCore.TAG, "Error serializing user metadata.", e);
                    CommonUtils.closeOrLog(writer, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    writer = writer2;
                    CommonUtils.closeOrLog(writer, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public UserMetaData readUserData(String sessionId) throws Throwable {
        UserMetaData userMetaDataJsonToUserData;
        File f = getUserDataFileForSession(sessionId);
        if (!f.exists()) {
            return UserMetaData.EMPTY;
        }
        InputStream is = null;
        try {
            try {
                InputStream is2 = new FileInputStream(f);
                try {
                    userMetaDataJsonToUserData = jsonToUserData(CommonUtils.streamToString(is2));
                    CommonUtils.closeOrLog(is2, "Failed to close user metadata file.");
                } catch (Exception e) {
                    e = e;
                    is = is2;
                    Fabric.getLogger().e(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
                    CommonUtils.closeOrLog(is, "Failed to close user metadata file.");
                    userMetaDataJsonToUserData = UserMetaData.EMPTY;
                } catch (Throwable th) {
                    th = th;
                    is = is2;
                    CommonUtils.closeOrLog(is, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return userMetaDataJsonToUserData;
    }

    public void writeKeyData(String sessionId, Map<String, String> keyData) throws Throwable {
        File f = getKeysFileForSession(sessionId);
        Writer writer = null;
        try {
            try {
                String keyDataString = keysDataToJson(keyData);
                Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), UTF_8));
                try {
                    writer2.write(keyDataString);
                    writer2.flush();
                    CommonUtils.closeOrLog(writer2, "Failed to close key/value metadata file.");
                    writer = writer2;
                } catch (Exception e) {
                    e = e;
                    writer = writer2;
                    Fabric.getLogger().e(CrashlyticsCore.TAG, "Error serializing key/value metadata.", e);
                    CommonUtils.closeOrLog(writer, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    writer = writer2;
                    CommonUtils.closeOrLog(writer, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public Map<String, String> readKeyData(String sessionId) throws Throwable {
        Map<String, String> mapEmptyMap;
        File f = getKeysFileForSession(sessionId);
        if (!f.exists()) {
            return Collections.emptyMap();
        }
        InputStream is = null;
        try {
            try {
                InputStream is2 = new FileInputStream(f);
                try {
                    mapEmptyMap = jsonToKeysData(CommonUtils.streamToString(is2));
                    CommonUtils.closeOrLog(is2, "Failed to close user metadata file.");
                } catch (Exception e) {
                    e = e;
                    is = is2;
                    Fabric.getLogger().e(CrashlyticsCore.TAG, "Error deserializing user metadata.", e);
                    CommonUtils.closeOrLog(is, "Failed to close user metadata file.");
                    mapEmptyMap = Collections.emptyMap();
                } catch (Throwable th) {
                    th = th;
                    is = is2;
                    CommonUtils.closeOrLog(is, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return mapEmptyMap;
    }

    private File getUserDataFileForSession(String sessionId) {
        return new File(this.filesDir, sessionId + USERDATA_SUFFIX + METADATA_EXT);
    }

    private File getKeysFileForSession(String sessionId) {
        return new File(this.filesDir, sessionId + KEYDATA_SUFFIX + METADATA_EXT);
    }

    private static UserMetaData jsonToUserData(String json) throws JSONException {
        JSONObject dataObj = new JSONObject(json);
        String id = valueOrNull(dataObj, KEY_USER_ID);
        String name = valueOrNull(dataObj, KEY_USER_NAME);
        String email = valueOrNull(dataObj, KEY_USER_EMAIL);
        return new UserMetaData(id, name, email);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.crashlytics.android.core.MetaDataStore$1] */
    private static String userDataToJson(final UserMetaData userData) throws JSONException {
        return new JSONObject() { // from class: com.crashlytics.android.core.MetaDataStore.1
            {
                put(MetaDataStore.KEY_USER_ID, userData.id);
                put(MetaDataStore.KEY_USER_NAME, userData.name);
                put(MetaDataStore.KEY_USER_EMAIL, userData.email);
            }
        }.toString();
    }

    private static Map<String, String> jsonToKeysData(String json) throws JSONException {
        JSONObject dataObj = new JSONObject(json);
        Map<String, String> keyData = new HashMap<>();
        Iterator<String> keyIter = dataObj.keys();
        while (keyIter.hasNext()) {
            String key = keyIter.next();
            keyData.put(key, valueOrNull(dataObj, key));
        }
        return keyData;
    }

    private static String keysDataToJson(Map<String, String> keyData) throws JSONException {
        return new JSONObject(keyData).toString();
    }

    private static String valueOrNull(JSONObject json, String key) {
        if (json.isNull(key)) {
            return null;
        }
        return json.optString(key, null);
    }
}
