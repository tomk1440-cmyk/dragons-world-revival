package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Patterns;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ProxyRequest implements SafeParcelable {
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;
    Bundle zzWB;
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zzb();
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int LAST_CODE = 7;

    public static class Builder {
        private String zzWC;
        private int zzWD = ProxyRequest.HTTP_METHOD_GET;
        private long zzWE = 3000;
        private byte[] zzWF = null;
        private Bundle zzWG = new Bundle();

        public Builder(String url) {
            zzx.zzcM(url);
            if (!Patterns.WEB_URL.matcher(url).matches()) {
                throw new IllegalArgumentException("The supplied url [ " + url + "] is not match Patterns.WEB_URL!");
            }
            this.zzWC = url;
        }

        public ProxyRequest build() {
            if (this.zzWF == null) {
                this.zzWF = new byte[0];
            }
            return new ProxyRequest(2, this.zzWC, this.zzWD, this.zzWE, this.zzWF, this.zzWG);
        }

        public Builder putHeader(String name, String value) {
            zzx.zzh(name, "Header name cannot be null or empty!");
            Bundle bundle = this.zzWG;
            if (value == null) {
                value = "";
            }
            bundle.putString(name, value);
            return this;
        }

        public Builder setBody(byte[] body) {
            this.zzWF = body;
            return this;
        }

        public Builder setHttpMethod(int method) {
            zzx.zzb(method >= 0 && method <= ProxyRequest.LAST_CODE, "Unrecognized http method code.");
            this.zzWD = method;
            return this;
        }

        public Builder setTimeoutMillis(long timeoutMillis) {
            zzx.zzb(timeoutMillis >= 0, "The specified timeout must be non-negative.");
            this.zzWE = timeoutMillis;
            return this;
        }
    }

    ProxyRequest(int version, String googleUrl, int httpMethod, long timeoutMillis, byte[] body, Bundle headers) {
        this.versionCode = version;
        this.url = googleUrl;
        this.httpMethod = httpMethod;
        this.timeoutMillis = timeoutMillis;
        this.body = body;
        this.zzWB = headers;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, String> getHeaderMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.zzWB.size());
        for (String str : this.zzWB.keySet()) {
            linkedHashMap.put(str, this.zzWB.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.httpMethod + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
