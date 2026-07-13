package com.google.android.gms.games.internal.constants;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardCollection {
    private LeaderboardCollection() {
    }

    public static String zzgw(int i) {
        switch (i) {
            case 0:
                return "PUBLIC";
            case 1:
                return "SOCIAL";
            case 2:
                return "SOCIAL_1P";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
