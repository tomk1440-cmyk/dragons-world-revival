package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: loaded from: classes.dex */
class zzs implements Logger {
    private boolean zzPk;
    private int zzRB = 2;

    zzs() {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void error(Exception exception) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void error(String msg) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public int getLogLevel() {
        return this.zzRB;
    }

    @Override // com.google.android.gms.analytics.Logger
    public void info(String msg) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void setLogLevel(int level) {
        this.zzRB = level;
        if (this.zzPk) {
            return;
        }
        Log.i(zzy.zzRL.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + zzy.zzRL.get() + " DEBUG");
        this.zzPk = true;
    }

    @Override // com.google.android.gms.analytics.Logger
    public void verbose(String msg) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void warn(String msg) {
    }
}
