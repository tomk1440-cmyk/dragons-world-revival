package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzaJJ;
    private final Bundle zzaJZ;
    private final String[] zzaKa;
    private final int zzaKi;

    TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder builder) {
        this.zzaJJ = builder.zzaJJ;
        this.zzaKi = builder.zzaKi;
        this.zzaJZ = builder.zzaJZ;
        this.zzaKa = (String[]) builder.zzaJY.toArray(new String[builder.zzaJY.size()]);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public Bundle getAutoMatchCriteria() {
        return this.zzaJZ;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public String[] getInvitedPlayerIds() {
        return this.zzaKa;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public int getVariant() {
        return this.zzaJJ;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public int zzxP() {
        return this.zzaKi;
    }
}
