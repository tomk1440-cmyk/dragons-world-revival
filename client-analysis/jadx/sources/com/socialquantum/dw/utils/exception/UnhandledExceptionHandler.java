package com.socialquantum.dw.utils.exception;

import android.os.Environment;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.unity3d.player.UnityPlayer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public class UnhandledExceptionHandler implements Thread.UncaughtExceptionHandler {
    private Thread.UncaughtExceptionHandler defaultHandler;
    final String INTERNAL_DOCUMENT_PATH = "/data" + File.separator + ShareConstants.WEB_DIALOG_PARAM_DATA;
    final String EXTERNAL_DOCUMENT_PATH = "/sdcard" + File.separator + "Android" + File.separator + ShareConstants.WEB_DIALOG_PARAM_DATA;
    private String mPackageName = "com.socialquantum.dragonlands";

    public UnhandledExceptionHandler(String _packageName) {
        this.defaultHandler = null;
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Log.i("UncaughtHandler", "UncaughtExceptionHandler:" + this.defaultHandler + " " + _packageName);
        Thread.setDefaultUncaughtExceptionHandler(this);
        Log.i("UncaughtHandler", "UncaughtExceptionHandler2 :" + Thread.getDefaultUncaughtExceptionHandler());
    }

    public static boolean isSdPresent() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread t, Throwable e) {
        Log.i("UncaughtHandler", "exception handled thread: " + t + " " + e.getMessage());
        Writer result = new StringWriter();
        PrintWriter printWriter = new PrintWriter(result);
        e.printStackTrace(printWriter);
        String stacktrace = result.toString();
        printWriter.close();
        String message = "JavaUnhandledExceptionHandler, thread: " + t + " " + e.getMessage();
        SaveCrashTeport(message, stacktrace);
        if (this.defaultHandler != null) {
            this.defaultHandler.uncaughtException(t, e);
        } else {
            System.exit(1);
        }
    }

    private String getApplicationName() {
        if (UnityPlayer.currentActivity != null) {
            Log.i("UncaughtHandler", "return real activity name: " + UnityPlayer.currentActivity.getApplicationInfo().name);
            return UnityPlayer.currentActivity.getApplicationInfo().name;
        }
        Log.i("UncaughtHandler", "return default activity " + this.mPackageName);
        return this.mPackageName;
    }

    private void SaveCrashTeport(String _reason, String _stackTrace) {
        String strDocumentDirectory;
        try {
            if (!isSdPresent()) {
                strDocumentDirectory = this.INTERNAL_DOCUMENT_PATH + File.separator + getApplicationName();
            } else {
                strDocumentDirectory = this.EXTERNAL_DOCUMENT_PATH + File.separator + getApplicationName();
            }
            Log.d("UncaughtHandler", "strDocumentDirectory: " + strDocumentDirectory);
            File file = new File(strDocumentDirectory, "unhandled.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, false);
            String outString = String.format("Reason : \n%s\nTrace : \n%s", _reason, _stackTrace);
            Log.d("UncaughtHandler", "outString : " + outString);
            writer.write(outString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            Log.d("UncaughtHandler", "Exception occured " + e.getMessage());
            e.printStackTrace();
        }
    }
}
