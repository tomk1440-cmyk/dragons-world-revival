package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final String zzaJA;
    private final String zzaJB;
    private final String zzaJC;
    private final int zzaJr;
    private final int zzaJs;
    private final boolean zzaJt;
    private final long zzaJu;
    private final String zzaJv;
    private final long zzaJw;
    private final String zzaJx;
    private final String zzaJy;
    private final long zzaJz;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.zzaJr = variant.getTimeSpan();
        this.zzaJs = variant.getCollection();
        this.zzaJt = variant.hasPlayerInfo();
        this.zzaJu = variant.getRawPlayerScore();
        this.zzaJv = variant.getDisplayPlayerScore();
        this.zzaJw = variant.getPlayerRank();
        this.zzaJx = variant.getDisplayPlayerRank();
        this.zzaJy = variant.getPlayerScoreTag();
        this.zzaJz = variant.getNumScores();
        this.zzaJA = variant.zzxL();
        this.zzaJB = variant.zzxM();
        this.zzaJC = variant.zzxN();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzw.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzxL(), leaderboardVariant.zzxN(), leaderboardVariant.zzxM());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzw.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzw.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzw.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzw.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzw.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzw.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzw.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzw.equal(leaderboardVariant2.zzxL(), leaderboardVariant.zzxL()) && zzw.equal(leaderboardVariant2.zzxN(), leaderboardVariant.zzxN()) && zzw.equal(leaderboardVariant2.zzxM(), leaderboardVariant.zzxM());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzw.zzy(leaderboardVariant).zzg("TimeSpan", TimeSpan.zzgw(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzgw(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zzxL()).zzg("WindowPageNextToken", leaderboardVariant.zzxN()).zzg("WindowPagePrevToken", leaderboardVariant.zzxM()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public int getCollection() {
        return this.zzaJs;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String getDisplayPlayerRank() {
        return this.zzaJx;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String getDisplayPlayerScore() {
        return this.zzaJv;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long getNumScores() {
        return this.zzaJz;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long getPlayerRank() {
        return this.zzaJw;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String getPlayerScoreTag() {
        return this.zzaJy;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public long getRawPlayerScore() {
        return this.zzaJu;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public int getTimeSpan() {
        return this.zzaJr;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public boolean hasPlayerInfo() {
        return this.zzaJt;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String zzxL() {
        return this.zzaJA;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String zzxM() {
        return this.zzaJB;
    }

    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public String zzxN() {
        return this.zzaJC;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzxO, reason: merged with bridge method [inline-methods] */
    public LeaderboardVariant freeze() {
        return this;
    }
}
