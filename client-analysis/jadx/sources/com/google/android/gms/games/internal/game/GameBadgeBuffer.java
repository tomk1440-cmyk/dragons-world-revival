package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class GameBadgeBuffer extends AbstractDataBuffer<GameBadge> {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: zzgy, reason: merged with bridge method [inline-methods] */
    public GameBadge get(int i) {
        return new GameBadgeRef(this.zzahi, i);
    }
}
