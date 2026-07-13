package android.support.v4.media;

import android.view.KeyEvent;

/* JADX INFO: loaded from: classes.dex */
interface TransportMediatorCallback {
    long getPlaybackPosition();

    void handleAudioFocusChange(int i);

    void handleKey(KeyEvent keyEvent);

    void playbackPositionUpdate(long j);
}
