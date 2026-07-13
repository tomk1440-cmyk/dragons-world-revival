package android.support.v4.media.session;

import android.media.session.MediaSession;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi22 {
    MediaSessionCompatApi22() {
    }

    public static void setRatingType(Object sessionObj, int type) {
        ((MediaSession) sessionObj).setRatingType(type);
    }
}
