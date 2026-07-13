package com.socialquantum.notifications.local;

import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AlarmOptions {
    private String notificationId = "";
    private String alarmTitle = "";
    private String message = "";
    private long triggerTime = 0;
    private long repeatInterval = 0;
    private long removalTime = 0;

    public void parseOptions(JSONArray optionsArr) {
        JSONObject options = optionsArr.optJSONObject(0);
        if (options != null) {
            this.alarmTitle = options.optString("title");
            this.message = options.optString("subTitle");
            this.triggerTime = options.optLong("triggerTime");
            this.repeatInterval = options.optLong("repeatInterval");
            this.removalTime = options.optLong("removalTime");
            this.notificationId = options.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
        }
    }

    public JSONArray optionsToJson() {
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("title", this.alarmTitle);
            jsonObject.put("subTitle", this.message);
            jsonObject.put("triggerTime", this.triggerTime);
            jsonObject.put("repeatInterval", this.repeatInterval);
            jsonObject.put("removalTime", this.removalTime);
            jsonObject.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.notificationId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        array.put(jsonObject);
        return array;
    }

    public long getTriggerTime() {
        return this.triggerTime;
    }

    public void setTriggerTime(long triggerTime) {
        this.triggerTime = triggerTime;
    }

    public long getTimeRepeatInterval() {
        return this.repeatInterval;
    }

    public void setTimeRepeatInterval(long repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public long getRemovalTime() {
        return this.removalTime;
    }

    public void setRemovalTime(long removalTime) {
        this.removalTime = removalTime;
    }

    public String getTitle() {
        return this.alarmTitle;
    }

    public void setTitle(String alarmTitle) {
        this.alarmTitle = alarmTitle;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNotificationId() {
        return this.notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }
}
