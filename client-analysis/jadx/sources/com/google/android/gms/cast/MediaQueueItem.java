package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MediaQueueItem {
    public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
    public static final int INVALID_ITEM_ID = 0;
    private JSONObject zzaaU;
    private MediaInfo zzabd;
    private int zzabe;
    private boolean zzabf;
    private double zzabg;
    private double zzabh;
    private double zzabi;
    private long[] zzabj;

    public static class Builder {
        private final MediaQueueItem zzabk;

        public Builder(MediaInfo media) throws IllegalArgumentException {
            this.zzabk = new MediaQueueItem(media);
        }

        public Builder(MediaQueueItem item) throws IllegalArgumentException {
            this.zzabk = new MediaQueueItem();
        }

        public Builder(JSONObject json) throws JSONException {
            this.zzabk = new MediaQueueItem(json);
        }

        public MediaQueueItem build() {
            this.zzabk.zznN();
            return this.zzabk;
        }

        public Builder clearItemId() {
            this.zzabk.zzba(0);
            return this;
        }

        public Builder setActiveTrackIds(long[] activeTrackIds) {
            this.zzabk.zza(activeTrackIds);
            return this;
        }

        public Builder setAutoplay(boolean autoplay) {
            this.zzabk.zzV(autoplay);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzabk.setCustomData(customData);
            return this;
        }

        public Builder setPlaybackDuration(double playbackDuration) {
            this.zzabk.zzd(playbackDuration);
            return this;
        }

        public Builder setPreloadTime(double preloadTime) throws IllegalArgumentException {
            this.zzabk.zze(preloadTime);
            return this;
        }

        public Builder setStartTime(double startTime) throws IllegalArgumentException {
            this.zzabk.zzc(startTime);
            return this;
        }
    }

    private MediaQueueItem(MediaInfo media) throws IllegalArgumentException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = Double.POSITIVE_INFINITY;
        if (media == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzabd = media;
    }

    private MediaQueueItem(MediaQueueItem item) throws IllegalArgumentException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = Double.POSITIVE_INFINITY;
        this.zzabd = item.getMedia();
        if (this.zzabd == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.zzabe = item.getItemId();
        this.zzabf = item.getAutoplay();
        this.zzabg = item.getStartTime();
        this.zzabh = item.getPlaybackDuration();
        this.zzabi = item.getPreloadTime();
        this.zzabj = item.getActiveTrackIds();
        this.zzaaU = item.getCustomData();
    }

    MediaQueueItem(JSONObject json) throws JSONException {
        this.zzabe = 0;
        this.zzabf = true;
        this.zzabh = Double.POSITIVE_INFINITY;
        zzh(json);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaQueueItem)) {
            return false;
        }
        MediaQueueItem mediaQueueItem = (MediaQueueItem) other;
        if ((this.zzaaU == null) != (mediaQueueItem.zzaaU == null)) {
            return false;
        }
        if (this.zzaaU == null || mediaQueueItem.zzaaU == null || zznb.zze(this.zzaaU, mediaQueueItem.zzaaU)) {
            return zzf.zza(this.zzabd, mediaQueueItem.zzabd) && this.zzabe == mediaQueueItem.zzabe && this.zzabf == mediaQueueItem.zzabf && this.zzabg == mediaQueueItem.zzabg && this.zzabh == mediaQueueItem.zzabh && this.zzabi == mediaQueueItem.zzabi && zzf.zza(this.zzabj, mediaQueueItem.zzabj);
        }
        return false;
    }

    public long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public boolean getAutoplay() {
        return this.zzabf;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getItemId() {
        return this.zzabe;
    }

    public MediaInfo getMedia() {
        return this.zzabd;
    }

    public double getPlaybackDuration() {
        return this.zzabh;
    }

    public double getPreloadTime() {
        return this.zzabi;
    }

    public double getStartTime() {
        return this.zzabg;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzabd, Integer.valueOf(this.zzabe), Boolean.valueOf(this.zzabf), Double.valueOf(this.zzabg), Double.valueOf(this.zzabh), Double.valueOf(this.zzabi), this.zzabj, String.valueOf(this.zzaaU));
    }

    void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("media", this.zzabd.toJson());
            if (this.zzabe != 0) {
                jSONObject.put("itemId", this.zzabe);
            }
            jSONObject.put("autoplay", this.zzabf);
            jSONObject.put("startTime", this.zzabg);
            if (this.zzabh != Double.POSITIVE_INFINITY) {
                jSONObject.put("playbackDuration", this.zzabh);
            }
            jSONObject.put("preloadTime", this.zzabi);
            if (this.zzabj != null) {
                JSONArray jSONArray = new JSONArray();
                for (long j : this.zzabj) {
                    jSONArray.put(j);
                }
                jSONObject.put("activeTrackIds", jSONArray);
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zzV(boolean z) {
        this.zzabf = z;
    }

    void zza(long[] jArr) {
        this.zzabj = jArr;
    }

    void zzba(int i) {
        this.zzabe = i;
    }

    void zzc(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        this.zzabg = d;
    }

    void zzd(double d) throws IllegalArgumentException {
        if (Double.isNaN(d)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        this.zzabh = d;
    }

    void zze(double d) throws IllegalArgumentException {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
        }
        this.zzabi = d;
    }

    public boolean zzh(JSONObject jSONObject) throws JSONException {
        boolean z;
        boolean z2;
        long[] jArr;
        boolean z3;
        int i;
        if (jSONObject.has("media")) {
            this.zzabd = new MediaInfo(jSONObject.getJSONObject("media"));
            z = true;
        } else {
            z = false;
        }
        if (jSONObject.has("itemId") && this.zzabe != (i = jSONObject.getInt("itemId"))) {
            this.zzabe = i;
            z = true;
        }
        if (jSONObject.has("autoplay") && this.zzabf != (z3 = jSONObject.getBoolean("autoplay"))) {
            this.zzabf = z3;
            z = true;
        }
        if (jSONObject.has("startTime")) {
            double d = jSONObject.getDouble("startTime");
            if (Math.abs(d - this.zzabg) > 1.0E-7d) {
                this.zzabg = d;
                z = true;
            }
        }
        if (jSONObject.has("playbackDuration")) {
            double d2 = jSONObject.getDouble("playbackDuration");
            if (Math.abs(d2 - this.zzabh) > 1.0E-7d) {
                this.zzabh = d2;
                z = true;
            }
        }
        if (jSONObject.has("preloadTime")) {
            double d3 = jSONObject.getDouble("preloadTime");
            if (Math.abs(d3 - this.zzabi) > 1.0E-7d) {
                this.zzabi = d3;
                z = true;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                jArr2[i2] = jSONArray.getLong(i2);
            }
            if (this.zzabj != null && this.zzabj.length == length) {
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z2 = false;
                        jArr = jArr2;
                        break;
                    }
                    if (this.zzabj[i3] != jArr2[i3]) {
                        jArr = jArr2;
                        z2 = true;
                        break;
                    }
                    i3++;
                }
            } else {
                jArr = jArr2;
                z2 = true;
            }
        } else {
            z2 = false;
            jArr = null;
        }
        if (z2) {
            this.zzabj = jArr;
            z = true;
        }
        if (!jSONObject.has("customData")) {
            return z;
        }
        this.zzaaU = jSONObject.getJSONObject("customData");
        return true;
    }

    void zznN() throws IllegalArgumentException {
        if (this.zzabd == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (Double.isNaN(this.zzabg) || this.zzabg < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(this.zzabh)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(this.zzabi) || this.zzabi < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
    }
}
