package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzm extends zzc {
    private static final String NAMESPACE = zzf.zzci("com.google.cast.media");
    private final List<zzp> zzacA;
    private long zzaei;
    private MediaStatus zzaej;
    private final zzp zzaek;
    private final zzp zzael;
    private final zzp zzaem;
    private final zzp zzaen;
    private final zzp zzaeo;
    private final zzp zzaep;
    private final zzp zzaeq;
    private final zzp zzaer;
    private final zzp zzaes;
    private final zzp zzaet;
    private final zzp zzaeu;
    private final zzp zzaev;
    private final zzp zzaew;
    private final zzp zzaex;

    public zzm(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000L);
        this.zzaek = new zzp(86400000L);
        this.zzael = new zzp(86400000L);
        this.zzaem = new zzp(86400000L);
        this.zzaen = new zzp(86400000L);
        this.zzaeo = new zzp(86400000L);
        this.zzaep = new zzp(86400000L);
        this.zzaeq = new zzp(86400000L);
        this.zzaer = new zzp(86400000L);
        this.zzaes = new zzp(86400000L);
        this.zzaet = new zzp(86400000L);
        this.zzaeu = new zzp(86400000L);
        this.zzaev = new zzp(86400000L);
        this.zzaew = new zzp(86400000L);
        this.zzaex = new zzp(86400000L);
        this.zzacA = new ArrayList();
        this.zzacA.add(this.zzaek);
        this.zzacA.add(this.zzael);
        this.zzacA.add(this.zzaem);
        this.zzacA.add(this.zzaen);
        this.zzacA.add(this.zzaeo);
        this.zzacA.add(this.zzaep);
        this.zzacA.add(this.zzaeq);
        this.zzacA.add(this.zzaer);
        this.zzacA.add(this.zzaes);
        this.zzacA.add(this.zzaet);
        this.zzacA.add(this.zzaeu);
        this.zzacA.add(this.zzaev);
        this.zzacA.add(this.zzaew);
        this.zzacA.add(this.zzaex);
        zzoy();
    }

    private void zza(long j, JSONObject jSONObject) throws JSONException {
        int iZza;
        boolean z = true;
        boolean zZzB = this.zzaek.zzB(j);
        boolean z2 = this.zzaeo.zzoA() && !this.zzaeo.zzB(j);
        if ((!this.zzaep.zzoA() || this.zzaep.zzB(j)) && (!this.zzaeq.zzoA() || this.zzaeq.zzB(j))) {
            z = false;
        }
        int i = z2 ? 2 : 0;
        if (z) {
            i |= 1;
        }
        if (zZzB || this.zzaej == null) {
            this.zzaej = new MediaStatus(jSONObject);
            this.zzaei = SystemClock.elapsedRealtime();
            iZza = 31;
        } else {
            iZza = this.zzaej.zza(jSONObject, i);
        }
        if ((iZza & 1) != 0) {
            this.zzaei = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((iZza & 2) != 0) {
            this.zzaei = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((iZza & 4) != 0) {
            onMetadataUpdated();
        }
        if ((iZza & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((iZza & 16) != 0) {
            onPreloadStatusUpdated();
        }
        Iterator<zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            it.next().zzc(j, 0);
        }
    }

    private void zzoy() {
        this.zzaei = 0L;
        this.zzaej = null;
        Iterator<zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzaei == 0) {
            return 0L;
        }
        double playbackRate = this.zzaej.getPlaybackRate();
        long streamPosition = this.zzaej.getStreamPosition();
        int playerState = this.zzaej.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzaei;
        long j = jElapsedRealtime < 0 ? 0L : jElapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long j2 = streamPosition + ((long) (j * playbackRate));
        if (streamDuration <= 0 || j2 <= streamDuration) {
            streamDuration = j2 < 0 ? 0L : j2;
        }
        return streamDuration;
    }

    public MediaInfo getMediaInfo() {
        if (this.zzaej == null) {
            return null;
        }
        return this.zzaej.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzaej;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0L;
    }

    protected void onMetadataUpdated() {
    }

    protected void onPreloadStatusUpdated() {
    }

    protected void onQueueStatusUpdated() {
    }

    protected void onStatusUpdated() {
    }

    public long zza(zzo zzoVar) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long jZzog = zzog();
        this.zzaer.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject.put("requestId", jZzog);
            jSONObject.put(ShareConstants.MEDIA_TYPE, "GET_STATUS");
            if (this.zzaej != null) {
                jSONObject.put("mediaSessionId", this.zzaej.zznO());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, double d, JSONObject jSONObject) throws IllegalStateException, IOException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaep.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zznO());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, int i, long j, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) throws IllegalStateException, IOException {
        if (j != -1 && j < 0) {
            throw new IllegalArgumentException("playPosition cannot be negative: " + j);
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaev.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", zznO());
            if (i != 0) {
                jSONObject2.put("currentItemId", i);
            }
            if (i2 != 0) {
                jSONObject2.put("jump", i2);
            }
            if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case 1:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case 2:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case 3:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                }
            }
            if (j != -1) {
                jSONObject2.put("currentTime", zzf.zzA(j));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, long j, int i, JSONObject jSONObject) throws IllegalStateException, IOException {
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaeo.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "SEEK");
            jSONObject2.put("mediaSessionId", zznO());
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaek.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long jZzog = zzog();
        this.zzaet.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject.put("requestId", jZzog);
            jSONObject.put(ShareConstants.MEDIA_TYPE, "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zznO());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzael.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "PAUSE");
            jSONObject2.put("mediaSessionId", zznO());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, boolean z, JSONObject jSONObject) throws IllegalStateException, IOException {
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaeq.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zznO());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put("volume", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, int[] iArr, int i, JSONObject jSONObject) throws IllegalStateException, IOException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaex.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, int[] iArr, JSONObject jSONObject) throws IllegalStateException, IOException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaew.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long jZzog = zzog();
        this.zzaes.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject.put("requestId", jZzog);
            jSONObject.put(ShareConstants.MEDIA_TYPE, "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, MediaQueueItem[] mediaQueueItemArr, int i, int i2, int i3, long j, JSONObject jSONObject) throws IllegalStateException, IOException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        if (i2 != 0 && i3 != -1) {
            throw new IllegalArgumentException("can not set both currentItemId and currentItemIndexInItemsToInsert");
        }
        if (i3 != -1 && (i3 < 0 || i3 >= mediaQueueItemArr.length)) {
            throw new IllegalArgumentException(String.format("currentItemIndexInItemsToInsert %d out of range [0, %d).", Integer.valueOf(i3), Integer.valueOf(mediaQueueItemArr.length)));
        }
        if (j != -1 && j < 0) {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaeu.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "QUEUE_INSERT");
            jSONObject2.put("mediaSessionId", zznO());
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < mediaQueueItemArr.length; i4++) {
                jSONArray.put(i4, mediaQueueItemArr[i4].toJson());
            }
            jSONObject2.put("items", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (i2 != 0) {
                jSONObject2.put("currentItemId", i2);
            }
            if (i3 != -1) {
                jSONObject2.put("currentItemIndex", i3);
            }
            if (j != -1) {
                jSONObject2.put("currentTime", zzf.zzA(j));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zza(zzo zzoVar, MediaQueueItem[] mediaQueueItemArr, int i, int i2, long j, JSONObject jSONObject) throws IOException, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i < 0 || i >= mediaQueueItemArr.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        }
        if (j != -1 && j < 0) {
            throw new IllegalArgumentException("playPosition can not be negative: " + j);
        }
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaek.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "QUEUE_LOAD");
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
            }
            jSONObject2.put("items", jSONArray);
            switch (i2) {
                case 0:
                    jSONObject2.put("repeatMode", "REPEAT_OFF");
                    break;
                case 1:
                    jSONObject2.put("repeatMode", "REPEAT_ALL");
                    break;
                case 2:
                    jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                    break;
                case 3:
                    jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid repeat mode: " + i2);
            }
            jSONObject2.put("startIndex", i);
            if (j != -1) {
                jSONObject2.put("currentTime", zzf.zzA(j));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    public long zzb(zzo zzoVar, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaen.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "STOP");
            jSONObject2.put("mediaSessionId", zznO());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public void zzb(long j, int i) {
        Iterator<zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            it.next().zzc(j, i);
        }
    }

    public long zzc(zzo zzoVar, JSONObject jSONObject) throws IllegalStateException, IOException {
        JSONObject jSONObject2 = new JSONObject();
        long jZzog = zzog();
        this.zzaem.zza(jZzog, zzoVar);
        zzW(true);
        try {
            jSONObject2.put("requestId", jZzog);
            jSONObject2.put(ShareConstants.MEDIA_TYPE, "PLAY");
            jSONObject2.put("mediaSessionId", zznO());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), jZzog, (String) null);
        return jZzog;
    }

    @Override // com.google.android.gms.cast.internal.zzd
    public final void zzcf(String str) {
        this.zzadu.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(ShareConstants.MEDIA_TYPE);
            long jOptLong = jSONObject.optLong("requestId", -1L);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    zza(jOptLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzaej = null;
                onStatusUpdated();
                onMetadataUpdated();
                onQueueStatusUpdated();
                onPreloadStatusUpdated();
                this.zzaer.zzc(jOptLong, 0);
                return;
            }
            if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzadu.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("customData");
                Iterator<zzp> it = this.zzacA.iterator();
                while (it.hasNext()) {
                    it.next().zzc(jOptLong, 2100, jSONObjectOptJSONObject);
                }
                return;
            }
            if (string.equals("LOAD_FAILED")) {
                this.zzaek.zzc(jOptLong, 2100, jSONObject.optJSONObject("customData"));
                return;
            }
            if (string.equals("LOAD_CANCELLED")) {
                this.zzaek.zzc(jOptLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
                return;
            }
            if (string.equals("INVALID_REQUEST")) {
                this.zzadu.zzf("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("customData");
                Iterator<zzp> it2 = this.zzacA.iterator();
                while (it2.hasNext()) {
                    it2.next().zzc(jOptLong, 2100, jSONObjectOptJSONObject2);
                }
            }
        } catch (JSONException e) {
            this.zzadu.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zznO() throws IllegalStateException {
        if (this.zzaej == null) {
            throw new IllegalStateException("No current media session");
        }
        return this.zzaej.zznO();
    }

    @Override // com.google.android.gms.cast.internal.zzc, com.google.android.gms.cast.internal.zzd
    public void zzof() {
        super.zzof();
        zzoy();
    }

    @Override // com.google.android.gms.cast.internal.zzc
    protected boolean zzz(long j) {
        boolean z;
        Iterator<zzp> it = this.zzacA.iterator();
        while (it.hasNext()) {
            it.next().zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzp.zzaeB) {
            Iterator<zzp> it2 = this.zzacA.iterator();
            while (it2.hasNext()) {
                if (it2.next().zzoA()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
