package com.google.android.gms.games.video;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: loaded from: classes.dex */
public interface Video extends Parcelable, Freezable<Video> {
    int getDuration();

    long getFileSize();

    String getPackageName();

    long getStartTime();

    String zzxX();
}
