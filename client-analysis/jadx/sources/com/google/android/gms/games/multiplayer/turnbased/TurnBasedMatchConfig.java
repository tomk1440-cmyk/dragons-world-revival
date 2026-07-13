package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class TurnBasedMatchConfig {

    public static final class Builder {
        int zzaJJ;
        ArrayList<String> zzaJY;
        Bundle zzaJZ;
        int zzaKi;

        private Builder() {
            this.zzaJJ = -1;
            this.zzaJY = new ArrayList<>();
            this.zzaJZ = null;
            this.zzaKi = 2;
        }

        public Builder addInvitedPlayer(String playerId) {
            zzx.zzz(playerId);
            this.zzaJY.add(playerId);
            return this;
        }

        public Builder addInvitedPlayers(ArrayList<String> playerIds) {
            zzx.zzz(playerIds);
            this.zzaJY.addAll(playerIds);
            return this;
        }

        public TurnBasedMatchConfig build() {
            return new TurnBasedMatchConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.zzaJZ = autoMatchCriteria;
            return this;
        }

        public Builder setVariant(int variant) {
            zzx.zzb(variant == -1 || variant > 0, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
            this.zzaJJ = variant;
            return this;
        }
    }

    protected TurnBasedMatchConfig() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String[] getInvitedPlayerIds();

    public abstract int getVariant();

    public abstract int zzxP();
}
