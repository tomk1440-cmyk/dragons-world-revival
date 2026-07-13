package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.AbstractDataBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class GameNotificationBuffer extends AbstractDataBuffer<GameNotification> {
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* JADX INFO: renamed from: zzgD, reason: merged with bridge method [inline-methods] */
    public GameNotification get(int i) {
        return new GameNotificationRef(this.zzahi, i);
    }
}
