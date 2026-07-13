package com.socialquantum.dw.utils.exception;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public final class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Context context;
    private String packageName;
    private final String UncaughtExceptionAndroidFlagKey = "uncaught_exception_android_flag";
    private final String UncaughtExceptionAndroidReasonKey = "uncaught_exception_android_reason";
    private final String UncaughtExceptionAndroidTraceKey = "uncaught_exception_android_trace";
    private final String CrashWithUnhandledExceptionFlagKey = "flag_crash_with_unhandled_exception";
    private final int CrashTimeout = 30000;
    private final Thread.UncaughtExceptionHandler defaultHandler = Thread.getDefaultUncaughtExceptionHandler();

    public UncaughtExceptionHandler(Context context, String packageName) {
        this.context = context;
        this.packageName = packageName;
        testCrash();
    }

    public void testCrash() {
        Handler crashHandler = new Handler();
        crashHandler.postDelayed(new Runnable() { // from class: com.socialquantum.dw.utils.exception.UncaughtExceptionHandler.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences prefs = UncaughtExceptionHandler.this.context.getSharedPreferences(UncaughtExceptionHandler.this.packageName, 0);
                int crashFlag = prefs.getInt("flag_crash_with_unhandled_exception", 0);
                if (crashFlag == 1) {
                    SharedPreferences.Editor prefsEditor = prefs.edit();
                    prefsEditor.putInt("flag_crash_with_unhandled_exception", 0);
                    prefsEditor.commit();
                    Object obj = null;
                    obj.toString();
                }
            }
        }, 30000L);
        File file = new File(Environment.getExternalStorageDirectory(), "javacrash");
        if (file.exists()) {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() { // from class: com.socialquantum.dw.utils.exception.UncaughtExceptionHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    Object obj = null;
                    obj.toString();
                }
            }, 5000L);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable ex) {
        SharedPreferences prefs = this.context.getSharedPreferences(this.packageName, 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("uncaught_exception_android_flag", 1);
        editor.putString("uncaught_exception_android_reason", ex.getMessage());
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        editor.putString("uncaught_exception_android_trace", sw.toString());
        editor.commit();
        this.defaultHandler.uncaughtException(thread, ex);
    }
}
