package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.CommonStatusCodes;

/* JADX INFO: loaded from: classes.dex */
public class NearbyMessagesStatusCodes extends CommonStatusCodes {
    public static final int APP_NOT_OPTED_IN = 2802;
    public static final int APP_QUOTA_LIMIT_REACHED = 2804;
    public static final int BLE_ADVERTISING_UNSUPPORTED = 2821;
    public static final int BLE_SCANNING_UNSUPPORTED = 2822;
    public static final int BLUETOOTH_OFF = 2820;
    public static final int DISALLOWED_CALLING_CONTEXT = 2803;
    public static final int TOO_MANY_PENDING_INTENTS = 2801;

    private NearbyMessagesStatusCodes() {
    }

    public static String getStatusCodeString(int statusCode) {
        switch (statusCode) {
            case TOO_MANY_PENDING_INTENTS /* 2801 */:
                return "TOO_MANY_PENDING_INTENTS";
            case APP_NOT_OPTED_IN /* 2802 */:
                return "APP_NOT_OPTED_IN";
            case DISALLOWED_CALLING_CONTEXT /* 2803 */:
                return "DISALLOWED_CALLING_CONTEXT";
            case BLUETOOTH_OFF /* 2820 */:
                return "BLUETOOTH_OFF";
            case BLE_ADVERTISING_UNSUPPORTED /* 2821 */:
                return "BLE_ADVERTISING_UNSUPPORTED";
            case BLE_SCANNING_UNSUPPORTED /* 2822 */:
                return "BLE_SCANNING_UNSUPPORTED";
            default:
                return CommonStatusCodes.getStatusCodeString(statusCode);
        }
    }
}
