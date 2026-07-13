package com.google.android.gms.games.video;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes.dex */
public final class VideoBuffer extends AbstractDataBuffer<Video> {
    public VideoBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: zzgX, reason: merged with bridge method [inline-methods] */
    public VideoRef get(int i) {
        return new VideoRef(this.zzahi, i);
    }
}
