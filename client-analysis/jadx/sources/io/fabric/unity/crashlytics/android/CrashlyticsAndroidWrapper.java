package io.fabric.unity.crashlytics.android;

/* JADX INFO: loaded from: classes.dex */
public class CrashlyticsAndroidWrapper {
    public static void crash() {
        new Thread(new Runnable() { // from class: io.fabric.unity.crashlytics.android.CrashlyticsAndroidWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException("Forced runtime exception");
            }
        }).start();
    }
}
