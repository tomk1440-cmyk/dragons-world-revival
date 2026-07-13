package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Presentation;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.view.Display;
import android.view.Window;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public abstract class CastPresentation extends Presentation {
    public CastPresentation(Context serviceContext, Display display) {
        super(serviceContext, display);
        zznA();
    }

    public CastPresentation(Context serviceContext, Display display, int theme) {
        super(serviceContext, display, theme);
        zznA();
    }

    private void zznA() {
        Window window = getWindow();
        if (window != null) {
            window.setType(2030);
            window.addFlags(DriveFile.MODE_READ_ONLY);
            window.addFlags(ViewCompat.MEASURED_STATE_TOO_SMALL);
            window.addFlags(1024);
        }
    }
}
