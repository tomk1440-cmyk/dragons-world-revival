package com.google.android.gms.games.video;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class VideoRef extends zzc implements Video {
    VideoRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.video.Video
    public int getDuration() {
        return getInteger("duration");
    }

    @Override // com.google.android.gms.games.video.Video
    public long getFileSize() {
        return getLong("filesize");
    }

    @Override // com.google.android.gms.games.video.Video
    public String getPackageName() {
        return getString("package");
    }

    @Override // com.google.android.gms.games.video.Video
    public long getStartTime() {
        return getLong("start_time");
    }

    public String toString() {
        return VideoEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((VideoEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.video.Video
    public String zzxX() {
        return getString("filepath");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzyg, reason: merged with bridge method [inline-methods] */
    public Video freeze() {
        return new VideoEntity(this);
    }
}
