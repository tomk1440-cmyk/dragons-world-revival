package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
interface FileLogStore {
    void closeLogFile();

    void deleteLogFile();

    ByteString getLogAsByteString();

    void writeToLog(long j, String str);
}
