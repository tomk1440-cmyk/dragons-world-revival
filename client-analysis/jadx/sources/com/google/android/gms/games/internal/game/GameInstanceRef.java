package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.PlatformType;

/* JADX INFO: loaded from: classes.dex */
public final class GameInstanceRef extends zzc implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public String toString() {
        return zzw.zzy(this).zzg("ApplicationId", getApplicationId()).zzg("DisplayName", getDisplayName()).zzg("SupportsRealTime", Boolean.valueOf(zzxn())).zzg("SupportsTurnBased", Boolean.valueOf(zzxo())).zzg("PlatformType", PlatformType.zzgw(zzur())).zzg("PackageName", getPackageName()).zzg("PiracyCheckEnabled", Boolean.valueOf(zzxp())).zzg("Installed", Boolean.valueOf(zzxq())).toString();
    }

    public int zzur() {
        return getInteger("platform_type");
    }

    public boolean zzxn() {
        return getInteger("real_time_support") > 0;
    }

    public boolean zzxo() {
        return getInteger("turn_based_support") > 0;
    }

    public boolean zzxp() {
        return getInteger("piracy_check") > 0;
    }

    public boolean zzxq() {
        return getInteger("installed") > 0;
    }
}
