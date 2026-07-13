package com.adjust.sdk;

/* JADX INFO: loaded from: classes.dex */
public interface ILogger {
    void Assert(String str, Object... objArr);

    void debug(String str, Object... objArr);

    void error(String str, Object... objArr);

    void info(String str, Object... objArr);

    void lockLogLevel();

    void setLogLevel(LogLevel logLevel);

    void setLogLevelString(String str);

    void verbose(String str, Object... objArr);

    void warn(String str, Object... objArr);
}
