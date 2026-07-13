package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private JSONObject zzaaU;
    private MediaInfo zzaaV;
    private long[] zzabj;
    private long zzabm;
    private double zzabn;
    private int zzabo;
    private int zzabp;
    private long zzabq;
    private long zzabr;
    private double zzabs;
    private boolean zzabt;
    private int zzabl = 0;
    private int zzabu = 0;
    private int zzabv = 0;
    private final zza zzabw = new zza();

    private class zza {
        private int zzabx = 0;
        private List<MediaQueueItem> zzaby = new ArrayList();
        private SparseArray<Integer> zzabz = new SparseArray<>();

        zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.zzabx = 0;
            this.zzaby.clear();
            this.zzabz.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzaby.clear();
            this.zzabz.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzaby.add(mediaQueueItem);
                this.zzabz.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzbd(int i) {
            return this.zzabz.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:50:0x00f7  */
        public boolean zzh(JSONObject jSONObject) throws JSONException {
            boolean z;
            boolean z2;
            int i = 2;
            if (jSONObject.has("repeatMode")) {
                int i2 = this.zzabx;
                switch (jSONObject.getString("repeatMode")) {
                    case "REPEAT_OFF":
                        i = 0;
                        break;
                    case "REPEAT_ALL":
                        i = 1;
                        break;
                    case "REPEAT_SINGLE":
                        break;
                    case "REPEAT_ALL_AND_SHUFFLE":
                        i = 3;
                        break;
                    default:
                        i = i2;
                        break;
                }
                if (this.zzabx != i) {
                    this.zzabx = i;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            if (!jSONObject.has("items")) {
                return z;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("items");
            int length = jSONArray.length();
            SparseArray sparseArray = new SparseArray();
            for (int i3 = 0; i3 < length; i3++) {
                sparseArray.put(i3, Integer.valueOf(jSONArray.getJSONObject(i3).getInt("itemId")));
            }
            MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[length];
            int i4 = 0;
            boolean z3 = z;
            while (i4 < length) {
                Integer num = (Integer) sparseArray.get(i4);
                JSONObject jSONObject2 = jSONArray.getJSONObject(i4);
                MediaQueueItem mediaQueueItemZzbb = zzbb(num.intValue());
                if (mediaQueueItemZzbb != null) {
                    boolean zZzh = z3 | mediaQueueItemZzbb.zzh(jSONObject2);
                    mediaQueueItemArr[i4] = mediaQueueItemZzbb;
                    z2 = i4 != zzbd(num.intValue()).intValue() ? true : zZzh;
                } else if (num.intValue() == MediaStatus.this.zzabl) {
                    mediaQueueItemArr[i4] = new MediaQueueItem.Builder(MediaStatus.this.zzaaV).build();
                    mediaQueueItemArr[i4].zzh(jSONObject2);
                    z2 = true;
                } else {
                    mediaQueueItemArr[i4] = new MediaQueueItem(jSONObject2);
                    z2 = true;
                }
                i4++;
                z3 = z2;
            }
            boolean z4 = this.zzaby.size() == length ? z3 : true;
            zza(mediaQueueItemArr);
            return z4;
        }

        public int getItemCount() {
            return this.zzaby.size();
        }

        public int getRepeatMode() {
            return this.zzabx;
        }

        public MediaQueueItem zzbb(int i) {
            Integer num = this.zzabz.get(i);
            if (num == null) {
                return null;
            }
            return this.zzaby.get(num.intValue());
        }

        public MediaQueueItem zzbc(int i) {
            if (i < 0 || i >= this.zzaby.size()) {
                return null;
            }
            return this.zzaby.get(i);
        }

        public List<MediaQueueItem> zznP() {
            return Collections.unmodifiableList(this.zzaby);
        }
    }

    public MediaStatus(JSONObject json) throws JSONException {
        zza(json, 0);
    }

    private boolean zzi(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public long[] getActiveTrackIds() {
        return this.zzabj;
    }

    public int getCurrentItemId() {
        return this.zzabl;
    }

    public JSONObject getCustomData() {
        return this.zzaaU;
    }

    public int getIdleReason() {
        return this.zzabp;
    }

    public int getLoadingItemId() {
        return this.zzabu;
    }

    public MediaInfo getMediaInfo() {
        return this.zzaaV;
    }

    public double getPlaybackRate() {
        return this.zzabn;
    }

    public int getPlayerState() {
        return this.zzabo;
    }

    public int getPreloadedItemId() {
        return this.zzabv;
    }

    public MediaQueueItem getQueueItem(int index) {
        return this.zzabw.zzbc(index);
    }

    public MediaQueueItem getQueueItemById(int itemId) {
        return this.zzabw.zzbb(itemId);
    }

    public int getQueueItemCount() {
        return this.zzabw.getItemCount();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzabw.zznP();
    }

    public int getQueueRepeatMode() {
        return this.zzabw.getRepeatMode();
    }

    public long getStreamPosition() {
        return this.zzabq;
    }

    public double getStreamVolume() {
        return this.zzabs;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.zzabr & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.zzabt;
    }

    public int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long[] jArr;
        boolean z;
        int i3;
        int i4;
        int i5 = 2;
        boolean z2 = true;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzabm) {
            this.zzabm = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            if (string.equals("IDLE")) {
                i4 = 1;
            } else if (string.equals("PLAYING")) {
                i4 = 2;
            } else if (string.equals("PAUSED")) {
                i4 = 3;
            } else {
                i4 = string.equals("BUFFERING") ? 4 : 0;
            }
            if (i4 != this.zzabo) {
                this.zzabo = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                if (!string2.equals("CANCELLED")) {
                    if (string2.equals("INTERRUPTED")) {
                        i5 = 3;
                    } else if (string2.equals("FINISHED")) {
                        i5 = 1;
                    } else {
                        i5 = string2.equals("ERROR") ? 4 : 0;
                    }
                }
                if (i5 != this.zzabp) {
                    this.zzabp = i5;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.zzabn != d) {
                this.zzabn = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long jZzg = zzf.zzg(jSONObject.getDouble("currentTime"));
            if (jZzg != this.zzabq) {
                this.zzabq = jZzg;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.zzabr) {
                this.zzabr = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has("volume") && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("volume");
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.zzabs) {
                this.zzabs = d2;
                i2 |= 2;
            }
            boolean z3 = jSONObject2.getBoolean("muted");
            if (z3 != this.zzabt) {
                this.zzabt = z3;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i6 = 0; i6 < length; i6++) {
                jArr2[i6] = jSONArray.getLong(i6);
            }
            if (this.zzabj != null && this.zzabj.length == length) {
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        z2 = false;
                        break;
                    }
                    if (this.zzabj[i7] != jArr2[i7]) {
                        break;
                    }
                    i7++;
                }
            }
            if (z2) {
                this.zzabj = jArr2;
            }
            z = z2;
            jArr = jArr2;
        } else if (this.zzabj != null) {
            z = true;
            jArr = null;
        } else {
            jArr = null;
            z = false;
        }
        if (z) {
            this.zzabj = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzaaU = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzaaV = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId") && this.zzabl != (i3 = jSONObject.getInt("currentItemId"))) {
            this.zzabl = i3;
            i2 |= 2;
        }
        int iOptInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzabv != iOptInt) {
            this.zzabv = iOptInt;
            i2 |= 16;
        }
        int iOptInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzabu != iOptInt2) {
            this.zzabu = iOptInt2;
            i2 |= 2;
        }
        if (!zzi(this.zzabo, this.zzabu)) {
            return this.zzabw.zzh(jSONObject) ? i2 | 8 : i2;
        }
        this.zzabl = 0;
        this.zzabu = 0;
        this.zzabv = 0;
        if (this.zzabw.getItemCount() <= 0) {
            return i2;
        }
        this.zzabw.clear();
        return i2 | 8;
    }

    public long zznO() {
        return this.zzabm;
    }
}
