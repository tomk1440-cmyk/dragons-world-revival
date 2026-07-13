package com.crashlytics.android.core;

/* JADX INFO: loaded from: classes.dex */
interface StackTraceTrimmingStrategy {
    StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr);
}
