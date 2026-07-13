package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

/* JADX INFO: loaded from: classes.dex */
public final class RequestType {
    private RequestType() {
    }

    public static String zzgw(int i) {
        switch (i) {
            case 1:
                return "GIFT";
            case 2:
                return "WISH";
            default:
                GamesLog.zzA("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
