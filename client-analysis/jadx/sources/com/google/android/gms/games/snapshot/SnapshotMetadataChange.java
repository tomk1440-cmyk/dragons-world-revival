package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.BitmapTeleporter;

/* JADX INFO: loaded from: classes.dex */
public abstract class SnapshotMetadataChange {
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    public static final class Builder {
        private Long zzaKN;
        private Long zzaKO;
        private BitmapTeleporter zzaKP;
        private Uri zzaKQ;
        private String zzaxl;

        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zzaxl, this.zzaKN, this.zzaKP, this.zzaKQ, this.zzaKO);
        }

        public Builder fromMetadata(SnapshotMetadata metadata) {
            this.zzaxl = metadata.getDescription();
            this.zzaKN = Long.valueOf(metadata.getPlayedTime());
            this.zzaKO = Long.valueOf(metadata.getProgressValue());
            if (this.zzaKN.longValue() == -1) {
                this.zzaKN = null;
            }
            this.zzaKQ = metadata.getCoverImageUri();
            if (this.zzaKQ != null) {
                this.zzaKP = null;
            }
            return this;
        }

        public Builder setCoverImage(Bitmap coverImage) {
            this.zzaKP = new BitmapTeleporter(coverImage);
            this.zzaKQ = null;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaxl = description;
            return this;
        }

        public Builder setPlayedTimeMillis(long playedTimeMillis) {
            this.zzaKN = Long.valueOf(playedTimeMillis);
            return this;
        }

        public Builder setProgressValue(long progressValue) {
            this.zzaKO = Long.valueOf(progressValue);
            return this;
        }
    }

    protected SnapshotMetadataChange() {
    }

    public abstract Bitmap getCoverImage();

    public abstract String getDescription();

    public abstract Long getPlayedTimeMillis();

    public abstract Long getProgressValue();

    public abstract BitmapTeleporter zzxU();
}
