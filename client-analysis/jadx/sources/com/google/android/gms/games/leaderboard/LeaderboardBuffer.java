package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class LeaderboardBuffer extends zzf<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
    public Leaderboard zzk(int i, int i2) {
        return new LeaderboardRef(this.zzahi, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String zzqg() {
        return "external_leaderboard_id";
    }
}
