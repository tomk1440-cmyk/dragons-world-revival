package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.Multiplayer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomConfig {

    public static final class Builder {
        int zzaJJ;
        final RoomUpdateListener zzaJU;
        RoomStatusUpdateListener zzaJV;
        RealTimeMessageReceivedListener zzaJW;
        String zzaJX;
        ArrayList<String> zzaJY;
        Bundle zzaJZ;

        private Builder(RoomUpdateListener updateListener) {
            this.zzaJX = null;
            this.zzaJJ = -1;
            this.zzaJY = new ArrayList<>();
            this.zzaJU = (RoomUpdateListener) zzx.zzb(updateListener, "Must provide a RoomUpdateListener");
        }

        public Builder addPlayersToInvite(ArrayList<String> playerIds) {
            zzx.zzz(playerIds);
            this.zzaJY.addAll(playerIds);
            return this;
        }

        public Builder addPlayersToInvite(String... playerIds) {
            zzx.zzz(playerIds);
            this.zzaJY.addAll(Arrays.asList(playerIds));
            return this;
        }

        public RoomConfig build() {
            return new RoomConfigImpl(this);
        }

        public Builder setAutoMatchCriteria(Bundle autoMatchCriteria) {
            this.zzaJZ = autoMatchCriteria;
            return this;
        }

        public Builder setInvitationIdToAccept(String invitationId) {
            zzx.zzz(invitationId);
            this.zzaJX = invitationId;
            return this;
        }

        public Builder setMessageReceivedListener(RealTimeMessageReceivedListener listener) {
            this.zzaJW = listener;
            return this;
        }

        public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener listener) {
            this.zzaJV = listener;
            return this;
        }

        public Builder setVariant(int variant) {
            zzx.zzb(variant == -1 || variant > 0, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
            this.zzaJJ = variant;
            return this;
        }
    }

    protected RoomConfig() {
    }

    public static Builder builder(RoomUpdateListener listener) {
        return new Builder(listener);
    }

    public static Bundle createAutoMatchCriteria(int minAutoMatchPlayers, int maxAutoMatchPlayers, long exclusiveBitMask) {
        Bundle bundle = new Bundle();
        bundle.putInt(Multiplayer.EXTRA_MIN_AUTOMATCH_PLAYERS, minAutoMatchPlayers);
        bundle.putInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS, maxAutoMatchPlayers);
        bundle.putLong(Multiplayer.EXTRA_EXCLUSIVE_BIT_MASK, exclusiveBitMask);
        return bundle;
    }

    public abstract Bundle getAutoMatchCriteria();

    public abstract String getInvitationId();

    public abstract String[] getInvitedPlayerIds();

    public abstract RealTimeMessageReceivedListener getMessageReceivedListener();

    public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();

    public abstract RoomUpdateListener getRoomUpdateListener();

    public abstract int getVariant();
}
