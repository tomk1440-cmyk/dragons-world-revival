package com.unity3d.ads.device;

import android.text.TextUtils;
import com.unity3d.ads.log.DeviceLog;
import com.unity3d.ads.misc.Utilities;
import com.unity3d.ads.webview.WebViewApp;
import com.unity3d.ads.webview.WebViewEventCategory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class Storage {
    private JSONObject _data;
    private String _targetFileName;
    private StorageManager.StorageType _type;

    public Storage(String targetFileName, StorageManager.StorageType type) {
        this._targetFileName = targetFileName;
        this._type = type;
    }

    public StorageManager.StorageType getType() {
        return this._type;
    }

    public synchronized boolean set(String key, Object value) {
        boolean z = false;
        synchronized (this) {
            try {
                if (this._data == null || key == null || key.length() == 0 || value == null) {
                    DeviceLog.error("Storage not properly initialized or incorrect parameters:" + this._data + ", " + key + ", " + value);
                } else {
                    createObjectTree(getParentObjectTreeFor(key));
                    if (findObject(getParentObjectTreeFor(key)) instanceof JSONObject) {
                        JSONObject parentObject = (JSONObject) findObject(getParentObjectTreeFor(key));
                        String[] objects = key.split("\\.");
                        if (parentObject != null) {
                            try {
                                parentObject.put(objects[objects.length - 1], value);
                            } catch (JSONException e) {
                                DeviceLog.exception("Couldn't set value", e);
                            }
                        }
                        z = true;
                    } else {
                        DeviceLog.debug("Cannot set subvalue to an object that is not JSONObject");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public synchronized Object get(String key) {
        JSONObject parentObject;
        Object o = null;
        synchronized (this) {
            if (this._data == null) {
                DeviceLog.error("Data is NULL, readStorage probably not called");
            } else {
                String[] objects = key.split("\\.");
                if ((findObject(getParentObjectTreeFor(key)) instanceof JSONObject) && (parentObject = (JSONObject) findObject(getParentObjectTreeFor(key))) != null) {
                    o = null;
                    try {
                        if (parentObject.has(objects[objects.length - 1])) {
                            o = parentObject.get(objects[objects.length - 1]);
                        }
                    } catch (Exception e) {
                        DeviceLog.exception("Error getting data", e);
                    }
                }
            }
        }
        return o;
    }

    public synchronized List<String> getKeys(String key, boolean recursive) {
        List<String> keys;
        if (get(key) instanceof JSONObject) {
            JSONObject parentObject = (JSONObject) get(key);
            keys = new ArrayList<>();
            if (parentObject != null) {
                Iterator<String> i = parentObject.keys();
                while (i.hasNext()) {
                    String currentKey = i.next();
                    List<String> subkeys = null;
                    if (recursive) {
                        subkeys = getKeys(key + "." + currentKey, recursive);
                    }
                    keys.add(currentKey);
                    if (subkeys != null) {
                        for (String subkey : subkeys) {
                            keys.add(currentKey + "." + subkey);
                        }
                    }
                }
            }
        } else {
            keys = null;
        }
        return keys;
    }

    public synchronized boolean delete(String key) {
        JSONObject parentObject;
        boolean z = false;
        synchronized (this) {
            if (this._data == null) {
                DeviceLog.error("Data is NULL, readStorage probably not called");
            } else {
                String[] objects = key.split("\\.");
                if ((findObject(getParentObjectTreeFor(key)) instanceof JSONObject) && (parentObject = (JSONObject) findObject(getParentObjectTreeFor(key))) != null && parentObject.remove(objects[objects.length - 1]) != null) {
                    z = true;
                }
            }
        }
        return z;
    }

    public synchronized boolean readStorage() {
        boolean z = false;
        synchronized (this) {
            File f = new File(this._targetFileName);
            String fileData = Utilities.readFile(f);
            if (fileData != null) {
                try {
                    this._data = new JSONObject(Utilities.readFile(f));
                    z = true;
                } catch (Exception e) {
                    DeviceLog.exception("Error creating storage JSON", e);
                }
            }
        }
        return z;
    }

    public synchronized boolean initStorage() {
        readStorage();
        if (this._data == null) {
            this._data = new JSONObject();
        }
        return true;
    }

    public synchronized boolean writeStorage() {
        File f;
        f = new File(this._targetFileName);
        return this._data != null ? Utilities.writeFile(f, this._data.toString()) : false;
    }

    public synchronized boolean clearStorage() {
        File f;
        this._data = null;
        f = new File(this._targetFileName);
        return f.delete();
    }

    public synchronized void clearData() {
        this._data = null;
    }

    public synchronized boolean hasData() {
        return this._data != null && this._data.length() > 0;
    }

    public synchronized boolean storageFileExists() {
        File f;
        f = new File(this._targetFileName);
        return f.exists();
    }

    public synchronized void sendEvent(StorageEvent eventType, Object... params) {
        boolean success = false;
        if (WebViewApp.getCurrentApp() != null) {
            ArrayList<Object> par = new ArrayList<>();
            par.addAll(Arrays.asList(params));
            par.add(0, this._type.name());
            Object[] paramsArray = par.toArray();
            success = WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORAGE, eventType, paramsArray);
        }
        if (!success) {
            DeviceLog.debug("Couldn't send storage event to WebApp");
        }
    }

    private synchronized Object findObject(String key) {
        JSONObject jSONObject = null;
        synchronized (this) {
            String[] objects = key.split("\\.");
            JSONObject parentObject = this._data;
            if (key.length() == 0) {
                jSONObject = parentObject;
            } else {
                for (int idx = 0; idx < objects.length; idx++) {
                    if (parentObject.has(objects[idx])) {
                        try {
                            parentObject = parentObject.getJSONObject(objects[idx]);
                        } catch (Exception e) {
                            DeviceLog.exception("Couldn't read JSONObject: " + objects[idx], e);
                            return jSONObject;
                        }
                    }
                }
                jSONObject = parentObject;
            }
        }
        return jSONObject;
    }

    private synchronized void createObjectTree(String tree) {
        try {
            String[] objects = tree.split("\\.");
            JSONObject parentObject = this._data;
            if (tree.length() != 0) {
                for (int idx = 0; idx < objects.length; idx++) {
                    if (!parentObject.has(objects[idx])) {
                        try {
                            parentObject = parentObject.put(objects[idx], new JSONObject()).getJSONObject(objects[idx]);
                        } catch (Exception e) {
                            DeviceLog.exception("Couldn't create new JSONObject", e);
                        }
                    } else {
                        try {
                            parentObject = parentObject.getJSONObject(objects[idx]);
                        } catch (Exception e2) {
                            DeviceLog.exception("Couldn't get existing JSONObject", e2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private synchronized String getParentObjectTreeFor(String tree) {
        String parentObject;
        Object[] objects = tree.split("\\.");
        ArrayList<String> tmpObs = new ArrayList<>(Arrays.asList(objects));
        tmpObs.remove(tmpObs.size() - 1);
        Object[] objects2 = tmpObs.toArray();
        parentObject = TextUtils.join(".", objects2);
        return parentObject;
    }
}
