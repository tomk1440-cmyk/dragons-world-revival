package com.crashlytics.android.core;

import android.os.AsyncTask;
import com.facebook.appevents.AppEventsConstants;
import io.fabric.sdk.android.Fabric;

/* JADX INFO: loaded from: classes.dex */
public class CrashTest {
    public void throwRuntimeException(String message) {
        throw new RuntimeException(message);
    }

    public int stackOverflow() {
        return stackOverflow() + ((int) Math.random());
    }

    public void indexOutOfBounds() {
        int[] ints = new int[2];
        int intValue = ints[10];
        Fabric.getLogger().d(CrashlyticsCore.TAG, "Out of bounds value: " + intValue);
    }

    public void crashAsyncTask(final long delayMs) {
        AsyncTask<Void, Void, Void> bgTask = new AsyncTask<Void, Void, Void>() { // from class: com.crashlytics.android.core.CrashTest.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... params) {
                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                }
                CrashTest.this.throwRuntimeException("Background thread crash");
                return null;
            }
        };
        bgTask.execute((Void) null);
    }

    public void throwFiveChainedExceptions() {
        try {
            privateMethodThatThrowsException(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        } catch (Exception ex) {
            try {
                throw new RuntimeException("2", ex);
            } catch (Exception ex2) {
                try {
                    throw new RuntimeException("3", ex2);
                } catch (Exception ex3) {
                    try {
                        throw new RuntimeException("4", ex3);
                    } catch (Exception ex4) {
                        throw new RuntimeException("5", ex4);
                    }
                }
            }
        }
    }

    private void privateMethodThatThrowsException(String message) {
        throw new RuntimeException(message);
    }
}
