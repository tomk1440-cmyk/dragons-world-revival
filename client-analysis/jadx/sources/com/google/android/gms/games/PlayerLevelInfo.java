package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerLevelInfo implements SafeParcelable {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
    private final int mVersionCode;
    private final long zzaDd;
    private final long zzaDe;
    private final PlayerLevel zzaDf;
    private final PlayerLevel zzaDg;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        zzx.zzab(currentXpTotal != -1);
        zzx.zzz(currentLevel);
        zzx.zzz(nextLevel);
        this.mVersionCode = versionCode;
        this.zzaDd = currentXpTotal;
        this.zzaDe = lastLevelUpTimestamp;
        this.zzaDf = currentLevel;
        this.zzaDg = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzaDd), Long.valueOf(playerLevelInfo.zzaDd)) && zzw.equal(Long.valueOf(this.zzaDe), Long.valueOf(playerLevelInfo.zzaDe)) && zzw.equal(this.zzaDf, playerLevelInfo.zzaDf) && zzw.equal(this.zzaDg, playerLevelInfo.zzaDg);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzaDf;
    }

    public long getCurrentXpTotal() {
        return this.zzaDd;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzaDe;
    }

    public PlayerLevel getNextLevel() {
        return this.zzaDg;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaDd), Long.valueOf(this.zzaDe), this.zzaDf, this.zzaDg);
    }

    public boolean isMaxLevel() {
        return this.zzaDf.equals(this.zzaDg);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.zza(this, out, flags);
    }
}
