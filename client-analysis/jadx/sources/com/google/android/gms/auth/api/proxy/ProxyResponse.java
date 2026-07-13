package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProxyResponse implements SafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzc();
    public static final int STATUS_CODE_NO_CONNECTION = -1;
    public final byte[] body;
    public final int googlePlayServicesStatusCode;
    public final PendingIntent recoveryAction;
    public final int statusCode;
    final int versionCode;
    final Bundle zzWB;

    ProxyResponse(int version, int googlePlayServicesStatusCode, PendingIntent recoveryAction, int statusCode, Bundle headers, byte[] body) {
        this.versionCode = version;
        this.googlePlayServicesStatusCode = googlePlayServicesStatusCode;
        this.statusCode = statusCode;
        this.zzWB = headers;
        this.body = body;
        this.recoveryAction = recoveryAction;
    }

    public ProxyResponse(int googlePlayServicesStatusCode, PendingIntent recoveryAction, int statusCode, Bundle headers, byte[] body) {
        this(1, googlePlayServicesStatusCode, recoveryAction, statusCode, headers, body);
    }

    private ProxyResponse(int responseCode, Bundle headers, byte[] body) {
        this(1, 0, null, responseCode, headers, body);
    }

    public ProxyResponse(int responseCode, Map<String, String> headers, byte[] body) {
        this(responseCode, zzL(headers), body);
    }

    public static ProxyResponse createErrorProxyResponse(int googlePlayServicesStatusCode, PendingIntent recoveryAction, int statusCode, Map<String, String> headers, byte[] body) {
        return new ProxyResponse(1, googlePlayServicesStatusCode, recoveryAction, statusCode, zzL(headers), body);
    }

    private static Bundle zzL(Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (map == null) {
            return bundle;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaders() {
        HashMap map = new HashMap();
        for (String str : this.zzWB.keySet()) {
            map.put(str, this.zzWB.getString(str));
        }
        return map;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }
}
