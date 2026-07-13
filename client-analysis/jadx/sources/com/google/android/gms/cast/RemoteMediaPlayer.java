package com.google.android.gms.cast;

import android.annotation.SuppressLint;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"MissingRemoteException"})
public class RemoteMediaPlayer implements Cast.MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    private OnPreloadStatusUpdatedListener zzabG;
    private OnQueueStatusUpdatedListener zzabH;
    private OnMetadataUpdatedListener zzabI;
    private OnStatusUpdatedListener zzabJ;
    private final Object zzpV = new Object();
    private final zza zzabF = new zza();
    private final zzm zzabE = new zzm(null) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.1
        @Override // com.google.android.gms.cast.internal.zzm
        protected void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onPreloadStatusUpdated() {
            RemoteMediaPlayer.this.onPreloadStatusUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onQueueStatusUpdated() {
            RemoteMediaPlayer.this.onQueueStatusUpdated();
        }

        @Override // com.google.android.gms.cast.internal.zzm
        protected void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class zza implements zzn {
        private GoogleApiClient zzaci;
        private long zzacj = 0;

        /* JADX INFO: renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zza$zza, reason: collision with other inner class name */
        private final class C0046zza implements ResultCallback<Status> {
            private final long zzack;

            C0046zza(long j) {
                this.zzack = j;
            }

            @Override // com.google.android.gms.common.api.ResultCallback
            /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    return;
                }
                RemoteMediaPlayer.this.zzabE.zzb(this.zzack, status.getStatusCode());
            }
        }

        public zza() {
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzaci == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzaci, str, str2).setResultCallback(new C0046zza(j));
        }

        public void zzc(GoogleApiClient googleApiClient) {
            this.zzaci = googleApiClient;
        }

        @Override // com.google.android.gms.cast.internal.zzn
        public long zznQ() {
            long j = this.zzacj + 1;
            this.zzacj = j;
            return j;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzacm;

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzacm = new zzo() { // from class: com.google.android.gms.cast.RemoteMediaPlayer.zzb.1
                @Override // com.google.android.gms.cast.internal.zzo
                public void zza(long j, int i, Object obj) {
                    zzb.this.zza(new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
                }

                @Override // com.google.android.gms.cast.internal.zzo
                public void zzy(long j) {
                    zzb.this.zza(zzb.this.zzc(new Status(2103)));
                }
            };
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
        public MediaChannelResult zzc(final Status status) {
            return new MediaChannelResult() { // from class: com.google.android.gms.cast.RemoteMediaPlayer.zzb.2
                @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
                public JSONObject getCustomData() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzUX;
        private final JSONObject zzaaU;

        zzc(Status status, JSONObject jSONObject) {
            this.zzUX = status;
            this.zzaaU = jSONObject;
        }

        @Override // com.google.android.gms.cast.RemoteMediaPlayer.MediaChannelResult
        public JSONObject getCustomData() {
            return this.zzaaU;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public RemoteMediaPlayer() {
        this.zzabE.zza(this.zzabF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.zzabI != null) {
            this.zzabI.onMetadataUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPreloadStatusUpdated() {
        if (this.zzabG != null) {
            this.zzabG.onPreloadStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onQueueStatusUpdated() {
        if (this.zzabH != null) {
            this.zzabH.onQueueStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.zzabJ != null) {
            this.zzabJ.onStatusUpdated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int zzbf(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpV) {
            approximateStreamPosition = this.zzabE.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpV) {
            mediaInfo = this.zzabE.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpV) {
            mediaStatus = this.zzabE.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzabE.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpV) {
            streamDuration = this.zzabE.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0L, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0L, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(final GoogleApiClient apiClient, final MediaInfo mediaInfo, final boolean autoplay, final long playPosition, final long[] activeTrackIds, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, mediaInfo, autoplay, playPosition, activeTrackIds, customData);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    @Override // com.google.android.gms.cast.Cast.MessageReceivedCallback
    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzabE.zzcf(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.17
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.19
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zzc(this.zzacm, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        return queueInsertItems(apiClient, new MediaQueueItem[]{item}, 0, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(final GoogleApiClient apiClient, final MediaQueueItem item, final int insertBeforeItemId, final long playPosition, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, new MediaQueueItem[]{item}, insertBeforeItemId, 0, 0, playPosition, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueInsertAndPlayItem(GoogleApiClient apiClient, MediaQueueItem item, int insertBeforeItemId, JSONObject customData) {
        return queueInsertAndPlayItem(apiClient, item, insertBeforeItemId, -1L, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(final GoogleApiClient apiClient, final MediaQueueItem[] itemsToInsert, final int insertBeforeItemId, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, itemsToInsert, insertBeforeItemId, 0, -1, -1L, customData);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(final GoogleApiClient apiClient, final int itemId, final long playPosition, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    if (RemoteMediaPlayer.this.zzbf(itemId) == -1) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, itemId, playPosition, (MediaQueueItem[]) null, 0, (Integer) null, customData);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        return queueJumpToItem(apiClient, itemId, -1L, customData);
    }

    public PendingResult<MediaChannelResult> queueLoad(final GoogleApiClient apiClient, final MediaQueueItem[] items, final int startIndex, final int repeatMode, final long playPosition, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, items, startIndex, repeatMode, playPosition, customData);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        return queueLoad(apiClient, items, startIndex, repeatMode, -1L, customData);
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(final GoogleApiClient apiClient, final int itemId, final int newIndex, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    int iZzbf = RemoteMediaPlayer.this.zzbf(itemId);
                    if (iZzbf == -1) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    if (newIndex < 0) {
                        zza(zzc(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", Integer.valueOf(newIndex)))));
                        return;
                    }
                    if (iZzbf == newIndex) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    MediaQueueItem queueItem = RemoteMediaPlayer.this.getMediaStatus().getQueueItem(newIndex > iZzbf ? newIndex + 1 : newIndex);
                    int itemId2 = queueItem != null ? queueItem.getItemId() : 0;
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, new int[]{itemId}, itemId2, customData);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.11
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, (MediaQueueItem[]) null, 1, (Integer) null, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.10
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, (MediaQueueItem[]) null, -1, (Integer) null, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(final GoogleApiClient apiClient, final int itemId, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    if (RemoteMediaPlayer.this.zzbf(itemId) == -1) {
                        zza(zzc(new Status(0)));
                        return;
                    }
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzabE.zza(this.zzacm, new int[]{itemId}, customData);
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                    } finally {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(final GoogleApiClient apiClient, final int[] itemIdsToRemove, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, itemIdsToRemove, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(final GoogleApiClient apiClient, final int[] itemIdsToReorder, final int insertBeforeItemId, final JSONObject customData) throws IllegalArgumentException {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, itemIdsToReorder, insertBeforeItemId, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(final GoogleApiClient apiClient, final int repeatMode, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.13
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, (MediaQueueItem[]) null, 0, Integer.valueOf(repeatMode), customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(final GoogleApiClient apiClient, final MediaQueueItem[] itemsToUpdate, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, 0, -1L, itemsToUpdate, 0, (Integer) null, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.23
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(final GoogleApiClient apiClient, final long position, final int resumeState, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.20
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, position, resumeState, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (IOException e) {
                            zza(zzc(new Status(2100)));
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        }
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, trackIds);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzabI = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzabG = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzabH = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzabJ = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.22
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, muteState, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException | IllegalStateException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(final GoogleApiClient apiClient, final double volume, final JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.21
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, volume, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle == null) {
            throw new IllegalArgumentException("trackStyle cannot be null");
        }
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zza(this.zzacm, trackStyle);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.cast.RemoteMediaPlayer.18
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) {
                synchronized (RemoteMediaPlayer.this.zzpV) {
                    RemoteMediaPlayer.this.zzabF.zzc(apiClient);
                    try {
                        try {
                            RemoteMediaPlayer.this.zzabE.zzb(this.zzacm, customData);
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzabF.zzc(null);
                            throw th;
                        }
                    } catch (IOException e) {
                        zza(zzc(new Status(2100)));
                        RemoteMediaPlayer.this.zzabF.zzc(null);
                    }
                }
            }
        });
    }
}
