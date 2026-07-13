package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class GameRef extends zzc implements Game {
    public GameRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    @Override // com.google.android.gms.games.Game
    public boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return GameEntity.zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Game freeze() {
        return new GameEntity(this);
    }

    @Override // com.google.android.gms.games.Game
    public int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    @Override // com.google.android.gms.games.Game
    public String getApplicationId() {
        return getString("external_game_id");
    }

    @Override // com.google.android.gms.games.Game
    public String getDescription() {
        return getString("game_description");
    }

    @Override // com.google.android.gms.games.Game
    public void getDescription(CharArrayBuffer dataOut) {
        zza("game_description", dataOut);
    }

    @Override // com.google.android.gms.games.Game
    public String getDeveloperName() {
        return getString("developer_name");
    }

    @Override // com.google.android.gms.games.Game
    public void getDeveloperName(CharArrayBuffer dataOut) {
        zza("developer_name", dataOut);
    }

    @Override // com.google.android.gms.games.Game
    public String getDisplayName() {
        return getString("display_name");
    }

    @Override // com.google.android.gms.games.Game
    public void getDisplayName(CharArrayBuffer dataOut) {
        zza("display_name", dataOut);
    }

    @Override // com.google.android.gms.games.Game
    public Uri getFeaturedImageUri() {
        return zzcA("featured_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public Uri getHiResImageUri() {
        return zzcA("game_hi_res_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public Uri getIconImageUri() {
        return zzcA("game_icon_image_uri");
    }

    @Override // com.google.android.gms.games.Game
    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    @Override // com.google.android.gms.games.Game
    public int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    @Override // com.google.android.gms.games.Game
    public String getPrimaryCategory() {
        return getString("primary_category");
    }

    @Override // com.google.android.gms.games.Game
    public String getSecondaryCategory() {
        return getString("secondary_category");
    }

    @Override // com.google.android.gms.games.Game
    public String getThemeColor() {
        return getString("theme_color");
    }

    @Override // com.google.android.gms.games.Game
    public boolean hasGamepadSupport() {
        return getInteger("gamepad_support") > 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return GameEntity.zza(this);
    }

    @Override // com.google.android.gms.games.Game
    public boolean isMuted() {
        return getBoolean("muted");
    }

    @Override // com.google.android.gms.games.Game
    public boolean isRealTimeMultiplayerEnabled() {
        return getInteger("real_time_support") > 0;
    }

    @Override // com.google.android.gms.games.Game
    public boolean isTurnBasedMultiplayerEnabled() {
        return getInteger("turn_based_support") > 0;
    }

    public String toString() {
        return GameEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((GameEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.Game
    public String zzvA() {
        return getString("package_name");
    }

    @Override // com.google.android.gms.games.Game
    public int zzvB() {
        return getInteger("gameplay_acl_status");
    }

    @Override // com.google.android.gms.games.Game
    public boolean zzvx() {
        return getBoolean("play_enabled_game");
    }

    @Override // com.google.android.gms.games.Game
    public boolean zzvy() {
        return getBoolean("identity_sharing_confirmed");
    }

    @Override // com.google.android.gms.games.Game
    public boolean zzvz() {
        return getInteger("installed") > 0;
    }
}
