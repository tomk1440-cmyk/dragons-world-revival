package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: loaded from: classes.dex */
public interface PlayerStats extends Parcelable, Freezable<PlayerStats> {
    public static final float UNSET_VALUE = -1.0f;

    float getAverageSessionLength();

    float getChurnProbability();

    int getDaysSinceLastPlayed();

    int getNumberOfPurchases();

    int getNumberOfSessions();

    float getSessionPercentile();

    float getSpendPercentile();

    float getSpendProbability();

    Bundle zzxV();
}
