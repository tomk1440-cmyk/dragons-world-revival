package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class PutDataRequest implements SafeParcelable {
    public static final String WEAR_URI_SCHEME = "wear";
    private final Uri mUri;
    final int mVersionCode;
    private byte[] zzaKm;
    private final Bundle zzbrh;
    private long zzbri;
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new zzh();
    private static final long zzbrf = TimeUnit.MINUTES.toMillis(30);
    private static final Random zzbrg = new SecureRandom();

    private PutDataRequest(int versionCode, Uri uri) {
        this(versionCode, uri, new Bundle(), null, zzbrf);
    }

    PutDataRequest(int versionCode, Uri uri, Bundle assets, byte[] data, long syncDeadline) {
        this.mVersionCode = versionCode;
        this.mUri = uri;
        this.zzbrh = assets;
        this.zzbrh.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.zzaKm = data;
        this.zzbri = syncDeadline;
    }

    public static PutDataRequest create(String path) {
        return zzr(zzgL(path));
    }

    public static PutDataRequest createFromDataItem(DataItem source) {
        PutDataRequest putDataRequestZzr = zzr(source.getUri());
        for (Map.Entry<String, DataItemAsset> entry : source.getAssets().entrySet()) {
            if (entry.getValue().getId() == null) {
                throw new IllegalStateException("Cannot create an asset for a put request without a digest: " + entry.getKey());
            }
            putDataRequestZzr.putAsset(entry.getKey(), Asset.createFromRef(entry.getValue().getId()));
        }
        putDataRequestZzr.setData(source.getData());
        return putDataRequestZzr;
    }

    public static PutDataRequest createWithAutoAppendedId(String pathPrefix) {
        StringBuilder sb = new StringBuilder(pathPrefix);
        if (!pathPrefix.endsWith("/")) {
            sb.append("/");
        }
        sb.append("PN").append(zzbrg.nextLong());
        return new PutDataRequest(2, zzgL(sb.toString()));
    }

    private static Uri zzgL(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("An empty path was supplied.");
        }
        if (!str.startsWith("/")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        if (str.startsWith("//")) {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        return new Uri.Builder().scheme(WEAR_URI_SCHEME).path(str).build();
    }

    public static PutDataRequest zzr(Uri uri) {
        return new PutDataRequest(2, uri);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Asset getAsset(String key) {
        return (Asset) this.zzbrh.getParcelable(key);
    }

    public Map<String, Asset> getAssets() {
        HashMap map = new HashMap();
        for (String str : this.zzbrh.keySet()) {
            map.put(str, (Asset) this.zzbrh.getParcelable(str));
        }
        return Collections.unmodifiableMap(map);
    }

    public byte[] getData() {
        return this.zzaKm;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean hasAsset(String key) {
        return this.zzbrh.containsKey(key);
    }

    public boolean isUrgent() {
        return this.zzbri == 0;
    }

    public PutDataRequest putAsset(String key, Asset value) {
        zzx.zzz(key);
        zzx.zzz(value);
        this.zzbrh.putParcelable(key, value);
        return this;
    }

    public PutDataRequest removeAsset(String key) {
        this.zzbrh.remove(key);
        return this;
    }

    public PutDataRequest setData(byte[] data) {
        this.zzaKm = data;
        return this;
    }

    public PutDataRequest setUrgent() {
        this.zzbri = 0L;
        return this;
    }

    public String toString() {
        return toString(Log.isLoggable(DataMap.TAG, 3));
    }

    public String toString(boolean verbose) {
        StringBuilder sb = new StringBuilder("PutDataRequest[");
        sb.append("dataSz=" + (this.zzaKm == null ? "null" : Integer.valueOf(this.zzaKm.length)));
        sb.append(", numAssets=" + this.zzbrh.size());
        sb.append(", uri=" + this.mUri);
        sb.append(", syncDeadline=" + this.zzbri);
        if (!verbose) {
            sb.append("]");
            return sb.toString();
        }
        sb.append("]\n  assets: ");
        for (String str : this.zzbrh.keySet()) {
            sb.append("\n    " + str + ": " + this.zzbrh.getParcelable(str));
        }
        sb.append("\n  ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public Bundle zzIv() {
        return this.zzbrh;
    }

    public long zzIw() {
        return this.zzbri;
    }
}
