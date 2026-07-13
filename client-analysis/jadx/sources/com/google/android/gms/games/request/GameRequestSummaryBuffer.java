package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: zzgQ, reason: merged with bridge method [inline-methods] */
    public GameRequestSummary get(int i) {
        return new GameRequestSummaryRef(this.zzahi, i);
    }
}
