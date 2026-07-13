package com.google.android.gms.games.multiplayer.realtime;

/* JADX INFO: loaded from: classes.dex */
public interface RoomUpdateListener {
    void onJoinedRoom(int i, Room room);

    void onLeftRoom(int i, String str);

    void onRoomConnected(int i, Room room);

    void onRoomCreated(int i, Room room);
}
