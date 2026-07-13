package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

/* JADX INFO: loaded from: classes.dex */
public final class GamesDataChangeUris {
    private static final Uri zzaIa = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
    public static final Uri zzaIb = zzaIa.buildUpon().appendPath("invitations").build();
    public static final Uri zzaIc = zzaIa.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
}
