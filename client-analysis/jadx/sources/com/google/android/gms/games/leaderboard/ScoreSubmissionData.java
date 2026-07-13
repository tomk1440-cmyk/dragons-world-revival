package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ScoreSubmissionData {
    private static final String[] zzaIX = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String zzaIZ;
    private HashMap<Integer, Result> zzaJD = new HashMap<>();
    private String zzacX;
    private int zzade;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return zzw.zzy(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzade = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        zzx.zzac(count == 3);
        for (int i = 0; i < count; i++) {
            int iZzbH = dataHolder.zzbH(i);
            if (i == 0) {
                this.zzaIZ = dataHolder.zzd("leaderboardId", i, iZzbH);
                this.zzacX = dataHolder.zzd("playerId", i, iZzbH);
            }
            if (dataHolder.zze("hasResult", i, iZzbH)) {
                zza(new Result(dataHolder.zzb("rawScore", i, iZzbH), dataHolder.zzd("formattedScore", i, iZzbH), dataHolder.zzd("scoreTag", i, iZzbH), dataHolder.zze("newBest", i, iZzbH)), dataHolder.zzc("timeSpan", i, iZzbH));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzaJD.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzaIZ;
    }

    public String getPlayerId() {
        return this.zzacX;
    }

    public Result getScoreResult(int timeSpan) {
        return this.zzaJD.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zzw.zza zzaVarZzg = zzw.zzy(this).zzg("PlayerId", this.zzacX).zzg("StatusCode", Integer.valueOf(this.zzade));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return zzaVarZzg.toString();
            }
            Result result = this.zzaJD.get(Integer.valueOf(i2));
            zzaVarZzg.zzg("TimesSpan", TimeSpan.zzgw(i2));
            zzaVarZzg.zzg("Result", result == null ? "null" : result.toString());
            i = i2 + 1;
        }
    }
}
