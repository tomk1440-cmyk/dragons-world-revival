package com.unity3d.ads.metadata;

import android.content.Context;
import com.unity3d.ads.device.Storage;
import com.unity3d.ads.device.StorageEvent;
import com.unity3d.ads.device.StorageManager;
import com.unity3d.ads.log.DeviceLog;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MetaData {
    private String _category;
    protected Context _context;
    protected Map<String, Object> _metaData;

    public MetaData(Context context) {
        this._context = context.getApplicationContext();
    }

    public void setCategory(String category) {
        this._category = category;
    }

    public String getCategory() {
        return this._category;
    }

    public void set(String key, Object value) {
        if (this._metaData == null) {
            this._metaData = new HashMap();
        }
        String finalKey = key;
        if (getCategory() != null) {
            finalKey = getCategory() + "." + key;
        }
        this._metaData.put(finalKey + ".value", value);
        this._metaData.put(finalKey + ".ts", Long.valueOf(System.currentTimeMillis()));
    }

    public Map<String, Object> getEntries() {
        return this._metaData;
    }

    public void commit() {
        if (StorageManager.init(this._context)) {
            Storage storage = StorageManager.getStorage(StorageManager.StorageType.PUBLIC);
            if (this._metaData != null) {
                for (String key : this._metaData.keySet()) {
                    if (storage != null) {
                        storage.set(key, this._metaData.get(key));
                    }
                }
                if (storage != null) {
                    storage.writeStorage();
                    storage.sendEvent(StorageEvent.SET, this._metaData);
                    return;
                }
                return;
            }
            return;
        }
        DeviceLog.error("Unity Ads could not commit metadata due to storage error");
    }
}
