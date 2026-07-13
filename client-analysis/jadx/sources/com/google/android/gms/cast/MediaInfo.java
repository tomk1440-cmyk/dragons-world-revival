package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zznb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class MediaInfo {
    public static final int STREAM_TYPE_BUFFERED = 1;
    public static final int STREAM_TYPE_INVALID = -1;
    public static final int STREAM_TYPE_LIVE = 2;
    public static final int STREAM_TYPE_NONE = 0;
    public static final long UNKNOWN_DURATION = -1;
    private final String zzaaN;
    private int zzaaO;
    private String zzaaP;
    private MediaMetadata zzaaQ;
    private long zzaaR;
    private List<MediaTrack> zzaaS;
    private TextTrackStyle zzaaT;
    private JSONObject zzaaU;

    public static class Builder {
        private final MediaInfo zzaaV;

        public Builder(String contentId) throws IllegalArgumentException {
            if (TextUtils.isEmpty(contentId)) {
                throw new IllegalArgumentException("Content ID cannot be empty");
            }
            this.zzaaV = new MediaInfo(contentId);
        }

        public MediaInfo build() throws IllegalArgumentException {
            this.zzaaV.zznN();
            return this.zzaaV;
        }

        public Builder setContentType(String contentType) throws IllegalArgumentException {
            this.zzaaV.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzaaV.setCustomData(customData);
            return this;
        }

        public Builder setMediaTracks(List<MediaTrack> mediaTracks) {
            this.zzaaV.zzu(mediaTracks);
            return this;
        }

        public Builder setMetadata(MediaMetadata metadata) {
            this.zzaaV.zza(metadata);
            return this;
        }

        public Builder setStreamDuration(long duration) throws IllegalArgumentException {
            this.zzaaV.zzx(duration);
            return this;
        }

        public Builder setStreamType(int streamType) throws IllegalArgumentException {
            this.zzaaV.setStreamType(streamType);
            return this;
        }

        public Builder setTextTrackStyle(TextTrackStyle textTrackStyle) {
            this.zzaaV.setTextTrackStyle(textTrackStyle);
            return this;
        }
    }

    MediaInfo(String contentId) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentId)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        this.zzaaN = contentId;
        this.zzaaO = -1;
        this.zzaaR = -1L;
    }

    MediaInfo(JSONObject json) throws JSONException {
        this.zzaaN = json.getString("contentId");
        String string = json.getString("streamType");
        if ("NONE".equals(string)) {
            this.zzaaO = 0;
        } else if ("BUFFERED".equals(string)) {
            this.zzaaO = 1;
        } else if ("LIVE".equals(string)) {
            this.zzaaO = 2;
        } else {
            this.zzaaO = -1;
        }
        this.zzaaP = json.getString("contentType");
        if (json.has("metadata")) {
            JSONObject jSONObject = json.getJSONObject("metadata");
            this.zzaaQ = new MediaMetadata(jSONObject.getInt("metadataType"));
            this.zzaaQ.zzg(jSONObject);
        }
        this.zzaaR = -1L;
        if (json.has("duration") && !json.isNull("duration")) {
            double dOptDouble = json.optDouble("duration", 0.0d);
            if (!Double.isNaN(dOptDouble) && !Double.isInfinite(dOptDouble)) {
                this.zzaaR = zzf.zzg(dOptDouble);
            }
        }
        if (json.has("tracks")) {
            this.zzaaS = new ArrayList();
            JSONArray jSONArray = json.getJSONArray("tracks");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.zzaaS.add(new MediaTrack(jSONArray.getJSONObject(i)));
            }
        } else {
            this.zzaaS = null;
        }
        if (json.has("textTrackStyle")) {
            JSONObject jSONObject2 = json.getJSONObject("textTrackStyle");
            TextTrackStyle textTrackStyle = new TextTrackStyle();
            textTrackStyle.zzg(jSONObject2);
            this.zzaaT = textTrackStyle;
        } else {
            this.zzaaT = null;
        }
        this.zzaaU = json.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaInfo)) {
            return false;
        }
        MediaInfo mediaInfo = (MediaInfo) other;
        if ((this.zzaaU == null) != (mediaInfo.zzaaU == null)) {
            return false;
        }
        if (this.zzaaU == null || mediaInfo.zzaaU == null || zznb.zze(this.zzaaU, mediaInfo.zzaaU)) {
            return zzf.zza(this.zzaaN, mediaInfo.zzaaN) && this.zzaaO == mediaInfo.zzaaO && zzf.zza(this.zzaaP, mediaInfo.zzaaP) && zzf.zza(this.zzaaQ, mediaInfo.zzaaQ) && this.zzaaR == mediaInfo.zzaaR;
        }
        return false;
    }

    public String getContentId() {
        return this.zzaaN;
    }

    public String getContentType() {
        return this.zzaaP;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public List<MediaTrack> getMediaTracks() {
        return this.zzaaS;
    }

    public MediaMetadata getMetadata() {
        return this.zzaaQ;
    }

    public long getStreamDuration() {
        return this.zzaaR;
    }

    public int getStreamType() {
        return this.zzaaO;
    }

    public TextTrackStyle getTextTrackStyle() {
        return this.zzaaT;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaaN, Integer.valueOf(this.zzaaO), this.zzaaP, this.zzaaQ, Long.valueOf(this.zzaaR), String.valueOf(this.zzaaU));
    }

    void setContentType(String contentType) throws IllegalArgumentException {
        if (TextUtils.isEmpty(contentType)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        this.zzaaP = contentType;
    }

    void setCustomData(JSONObject customData) {
        this.zzaaU = customData;
    }

    void setStreamType(int streamType) throws IllegalArgumentException {
        if (streamType < -1 || streamType > 2) {
            throw new IllegalArgumentException("invalid stream type");
        }
        this.zzaaO = streamType;
    }

    public void setTextTrackStyle(TextTrackStyle textTrackStyle) {
        this.zzaaT = textTrackStyle;
    }

    public JSONObject toJson() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentId", this.zzaaN);
            switch (this.zzaaO) {
                case 1:
                    str = "BUFFERED";
                    break;
                case 2:
                    str = "LIVE";
                    break;
                default:
                    str = "NONE";
                    break;
            }
            jSONObject.put("streamType", str);
            if (this.zzaaP != null) {
                jSONObject.put("contentType", this.zzaaP);
            }
            if (this.zzaaQ != null) {
                jSONObject.put("metadata", this.zzaaQ.toJson());
            }
            if (this.zzaaR <= -1) {
                jSONObject.put("duration", JSONObject.NULL);
            } else {
                jSONObject.put("duration", zzf.zzA(this.zzaaR));
            }
            if (this.zzaaS != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<MediaTrack> it = this.zzaaS.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJson());
                }
                jSONObject.put("tracks", jSONArray);
            }
            if (this.zzaaT != null) {
                jSONObject.put("textTrackStyle", this.zzaaT.toJson());
            }
            if (this.zzaaU != null) {
                jSONObject.put("customData", this.zzaaU);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    void zza(MediaMetadata mediaMetadata) {
        this.zzaaQ = mediaMetadata;
    }

    void zznN() throws IllegalArgumentException {
        if (TextUtils.isEmpty(this.zzaaN)) {
            throw new IllegalArgumentException("content ID cannot be null or empty");
        }
        if (TextUtils.isEmpty(this.zzaaP)) {
            throw new IllegalArgumentException("content type cannot be null or empty");
        }
        if (this.zzaaO == -1) {
            throw new IllegalArgumentException("a valid stream type must be specified");
        }
    }

    void zzu(List<MediaTrack> list) {
        this.zzaaS = list;
    }

    void zzx(long j) throws IllegalArgumentException {
        if (j < 0 && j != -1) {
            throw new IllegalArgumentException("Invalid stream duration");
        }
        this.zzaaR = j;
    }
}
