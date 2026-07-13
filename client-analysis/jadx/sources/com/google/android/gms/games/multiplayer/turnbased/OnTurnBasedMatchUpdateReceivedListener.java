package com.google.android.gms.games.multiplayer.turnbased;

/* JADX INFO: loaded from: classes.dex */
public interface OnTurnBasedMatchUpdateReceivedListener {
    void onTurnBasedMatchReceived(TurnBasedMatch turnBasedMatch);

    void onTurnBasedMatchRemoved(String str);
}
