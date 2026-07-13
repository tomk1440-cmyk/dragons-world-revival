package com.adjust.sdk;

import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ResponseData {
    public ActivityKind activityKind;
    public String adid;
    public AdjustAttribution attribution;
    public JSONObject jsonResponse;
    public String message;
    public boolean success;
    public String timestamp;
    public boolean willRetry;

    protected ResponseData() {
    }

    public static ResponseData buildResponseData(ActivityPackage activityPackage) {
        ResponseData responseData;
        ActivityKind activityKind = activityPackage.getActivityKind();
        switch (activityKind) {
            case SESSION:
                responseData = new SessionResponseData();
                break;
            case ATTRIBUTION:
                responseData = new AttributionResponseData();
                break;
            case EVENT:
                responseData = new EventResponseData(activityPackage);
                break;
            default:
                responseData = new ResponseData();
                break;
        }
        responseData.activityKind = activityKind;
        return responseData;
    }

    public String toString() {
        return String.format(Locale.US, "message:%s timestamp:%s json:%s", this.message, this.timestamp, this.jsonResponse);
    }
}
