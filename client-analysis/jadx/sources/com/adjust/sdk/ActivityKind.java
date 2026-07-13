package com.adjust.sdk;

import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* JADX INFO: loaded from: classes.dex */
public enum ActivityKind {
    UNKNOWN,
    SESSION,
    EVENT,
    CLICK,
    ATTRIBUTION,
    REVENUE,
    REATTRIBUTION,
    INFO;

    public static ActivityKind fromString(String string) {
        if (SettingsJsonConstants.SESSION_KEY.equals(string)) {
            return SESSION;
        }
        if ("event".equals(string)) {
            return EVENT;
        }
        if ("click".equals(string)) {
            return CLICK;
        }
        if ("attribution".equals(string)) {
            return ATTRIBUTION;
        }
        if ("info".equals(string)) {
            return INFO;
        }
        return UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (this) {
            case SESSION:
                return SettingsJsonConstants.SESSION_KEY;
            case EVENT:
                return "event";
            case CLICK:
                return "click";
            case ATTRIBUTION:
                return "attribution";
            case INFO:
                return "info";
            default:
                return "unknown";
        }
    }
}
