package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzms;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardEntity implements Leaderboard {
    private final String zzWQ;
    private final Uri zzaCd;
    private final String zzaCo;
    private final String zzaIZ;
    private final int zzaJa;
    private final ArrayList<LeaderboardVariantEntity> zzaJb;
    private final Game zzaJc;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzaIZ = leaderboard.getLeaderboardId();
        this.zzWQ = leaderboard.getDisplayName();
        this.zzaCd = leaderboard.getIconImageUri();
        this.zzaCo = leaderboard.getIconImageUrl();
        this.zzaJa = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzaJc = game == null ? null : new GameEntity(game);
        ArrayList<LeaderboardVariant> variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzaJb = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.zzaJb.add((LeaderboardVariantEntity) variants.get(i).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzw.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzw.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzw.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzw.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzw.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzw.zzy(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String getDisplayName() {
        return this.zzWQ;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public void getDisplayName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzWQ, dataOut);
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public Game getGame() {
        return this.zzaJc;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String getIconImageUrl() {
        return this.zzaCo;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public String getLeaderboardId() {
        return this.zzaIZ;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public int getScoreOrder() {
        return this.zzaJa;
    }

    @Override // com.google.android.gms.games.leaderboard.Leaderboard
    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList<>(this.zzaJb);
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

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzxI, reason: merged with bridge method [inline-methods] */
    public Leaderboard freeze() {
        return this;
    }
}
