package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzb;

/* JADX INFO: loaded from: classes.dex */
public class PlayerStatsRef extends zzc implements PlayerStats {
    private Bundle zzaLk;

    PlayerStatsRef(DataHolder holder, int rowIndex) {
        super(holder, rowIndex);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return PlayerStatsEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getChurnProbability() {
        return getFloat("churn_probability");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public float getSpendProbability() {
        if (zzcz("spend_probability")) {
            return getFloat("spend_probability");
        }
        return -1.0f;
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return PlayerStatsEntity.zza(this);
    }

    public String toString() {
        return PlayerStatsEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerStatsEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.stats.PlayerStats
    public Bundle zzxV() {
        if (this.zzaLk != null) {
            return this.zzaLk;
        }
        this.zzaLk = new Bundle();
        String string = getString("unknown_raw_keys");
        String string2 = getString("unknown_raw_values");
        if (string != null && string2 != null) {
            String[] strArrSplit = string.split(",");
            String[] strArrSplit2 = string2.split(",");
            zzb.zza(strArrSplit.length <= strArrSplit2.length, "Invalid raw arguments!");
            for (int i = 0; i < strArrSplit.length; i++) {
                this.zzaLk.putString(strArrSplit[i], strArrSplit2[i]);
            }
        }
        return this.zzaLk;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzxW, reason: merged with bridge method [inline-methods] */
    public PlayerStats freeze() {
        return new PlayerStatsEntity(this);
    }
}
