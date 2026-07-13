package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerColumnNames {
    public final String name;
    public final String title;
    public final String zzaIA;
    public final String zzaIB;
    public final String zzaIC;
    public final String zzaID;
    public final String zzaIE;
    public final String zzaIF;
    public final String zzaIG;
    public final String zzaIH;
    public final String zzaII;
    public final String zzaIJ;
    public final String zzaIK;
    public final String zzaIL;
    public final String zzaIM;
    public final String zzaIN;
    public final String zzaIO;
    public final String zzaIP;
    public final String zzaIQ;
    public final String zzaIR;
    public final String zzaIS;
    public final String zzaIT;
    public final String zzaIU;
    public final String zzaIV;
    public final String zzaIs;
    public final String zzaIt;
    public final String zzaIu;
    public final String zzaIv;
    public final String zzaIw;
    public final String zzaIx;
    public final String zzaIy;
    public final String zzaIz;

    public PlayerColumnNames(String prefix) {
        if (TextUtils.isEmpty(prefix)) {
            this.zzaIs = "external_player_id";
            this.zzaIt = "profile_name";
            this.zzaIu = "profile_icon_image_uri";
            this.zzaIv = "profile_icon_image_url";
            this.zzaIw = "profile_hi_res_image_uri";
            this.zzaIx = "profile_hi_res_image_url";
            this.zzaIy = "last_updated";
            this.zzaIz = "is_in_circles";
            this.zzaIA = "played_with_timestamp";
            this.zzaIB = "current_xp_total";
            this.zzaIC = "current_level";
            this.zzaID = "current_level_min_xp";
            this.zzaIE = "current_level_max_xp";
            this.zzaIF = "next_level";
            this.zzaIG = "next_level_max_xp";
            this.zzaIH = "last_level_up_timestamp";
            this.title = "player_title";
            this.zzaII = "has_all_public_acls";
            this.zzaIJ = "is_profile_visible";
            this.zzaIK = "most_recent_external_game_id";
            this.zzaIL = "most_recent_game_name";
            this.zzaIM = "most_recent_activity_timestamp";
            this.zzaIN = "most_recent_game_icon_uri";
            this.zzaIO = "most_recent_game_hi_res_uri";
            this.zzaIP = "most_recent_game_featured_uri";
            this.zzaIQ = "has_debug_access";
            this.zzaIR = "gamer_tag";
            this.name = "real_name";
            this.zzaIS = "banner_image_landscape_uri";
            this.zzaIT = "banner_image_landscape_url";
            this.zzaIU = "banner_image_portrait_uri";
            this.zzaIV = "banner_image_portrait_url";
            return;
        }
        this.zzaIs = prefix + "external_player_id";
        this.zzaIt = prefix + "profile_name";
        this.zzaIu = prefix + "profile_icon_image_uri";
        this.zzaIv = prefix + "profile_icon_image_url";
        this.zzaIw = prefix + "profile_hi_res_image_uri";
        this.zzaIx = prefix + "profile_hi_res_image_url";
        this.zzaIy = prefix + "last_updated";
        this.zzaIz = prefix + "is_in_circles";
        this.zzaIA = prefix + "played_with_timestamp";
        this.zzaIB = prefix + "current_xp_total";
        this.zzaIC = prefix + "current_level";
        this.zzaID = prefix + "current_level_min_xp";
        this.zzaIE = prefix + "current_level_max_xp";
        this.zzaIF = prefix + "next_level";
        this.zzaIG = prefix + "next_level_max_xp";
        this.zzaIH = prefix + "last_level_up_timestamp";
        this.title = prefix + "player_title";
        this.zzaII = prefix + "has_all_public_acls";
        this.zzaIJ = prefix + "is_profile_visible";
        this.zzaIK = prefix + "most_recent_external_game_id";
        this.zzaIL = prefix + "most_recent_game_name";
        this.zzaIM = prefix + "most_recent_activity_timestamp";
        this.zzaIN = prefix + "most_recent_game_icon_uri";
        this.zzaIO = prefix + "most_recent_game_hi_res_uri";
        this.zzaIP = prefix + "most_recent_game_featured_uri";
        this.zzaIQ = prefix + "has_debug_access";
        this.zzaIR = prefix + "gamer_tag";
        this.name = prefix + "real_name";
        this.zzaIS = prefix + "banner_image_landscape_uri";
        this.zzaIT = prefix + "banner_image_landscape_url";
        this.zzaIU = prefix + "banner_image_portrait_uri";
        this.zzaIV = prefix + "banner_image_portrait_url";
    }
}
