package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class RoomConfigImpl extends RoomConfig {
    private final String zzUO;
    private final int zzaJJ;
    private final RoomUpdateListener zzaJU;
    private final RoomStatusUpdateListener zzaJV;
    private final RealTimeMessageReceivedListener zzaJW;
    private final Bundle zzaJZ;
    private final String[] zzaKa;

    RoomConfigImpl(RoomConfig.Builder builder) {
        this.zzaJU = builder.zzaJU;
        this.zzaJV = builder.zzaJV;
        this.zzaJW = builder.zzaJW;
        this.zzUO = builder.zzaJX;
        this.zzaJJ = builder.zzaJJ;
        this.zzaJZ = builder.zzaJZ;
        this.zzaKa = (String[]) builder.zzaJY.toArray(new String[builder.zzaJY.size()]);
        zzx.zzb(this.zzaJW, "Must specify a message listener");
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public String getInvitationId() {
        return this.zzUO;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public String[] getInvitedPlayerIds() {
        return this.zzaKa;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzaJW;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzaJV;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzaJU;
    }

    @Override // com.google.android.gms.games.multiplayer.realtime.RoomConfig
    public int getVariant() {
        return this.zzaJJ;
    }
}
