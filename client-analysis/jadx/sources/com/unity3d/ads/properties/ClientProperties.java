package com.unity3d.ads.properties;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.log.DeviceLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes.dex */
public class ClientProperties {
    private static final X500Principal DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static WeakReference<Activity> _activity;
    private static Application _application;
    private static Context _applicationContext;
    private static String _gameId;
    private static IUnityAdsListener _listener;

    public static Activity getActivity() {
        return _activity.get();
    }

    public static void setActivity(Activity activity) {
        _activity = new WeakReference<>(activity);
    }

    public static Context getApplicationContext() {
        return _applicationContext;
    }

    public static void setApplicationContext(Context context) {
        _applicationContext = context;
    }

    public static Application getApplication() {
        return _application;
    }

    public static void setApplication(Application application) {
        _application = application;
    }

    public static IUnityAdsListener getListener() {
        return _listener;
    }

    public static void setListener(IUnityAdsListener listener) {
        _listener = listener;
    }

    public static String getGameId() {
        return _gameId;
    }

    public static void setGameId(String gameId) {
        _gameId = gameId;
    }

    public static String getAppName() {
        return _applicationContext.getPackageName();
    }

    public static String getAppVersion() {
        String pkgName = getApplicationContext().getPackageName();
        PackageManager pm = getApplicationContext().getPackageManager();
        try {
            return pm.getPackageInfo(pkgName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Error getting package info", e);
            return null;
        }
    }

    public static boolean isAppDebuggable() {
        boolean debuggable = false;
        boolean couldNotGetApplicationInfo = false;
        if (getApplicationContext() == null) {
            return false;
        }
        PackageManager pm = getApplicationContext().getPackageManager();
        String pkgName = getApplicationContext().getPackageName();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(pkgName, 0);
            int i = appinfo.flags & 2;
            appinfo.flags = i;
            if (i != 0) {
                debuggable = true;
            }
        } catch (PackageManager.NameNotFoundException e) {
            DeviceLog.exception("Could not find name", e);
            couldNotGetApplicationInfo = true;
        }
        if (couldNotGetApplicationInfo) {
            try {
                PackageInfo pinfo = pm.getPackageInfo(pkgName, 64);
                Signature[] signatures = pinfo.signatures;
                for (Signature signature : signatures) {
                    CertificateFactory cf = CertificateFactory.getInstance("X.509");
                    ByteArrayInputStream stream = new ByteArrayInputStream(signature.toByteArray());
                    X509Certificate cert = (X509Certificate) cf.generateCertificate(stream);
                    debuggable = cert.getSubjectX500Principal().equals(DEBUG_CERT);
                    if (debuggable) {
                        return debuggable;
                    }
                }
                return debuggable;
            } catch (PackageManager.NameNotFoundException e2) {
                DeviceLog.exception("Could not find name", e2);
                return debuggable;
            } catch (CertificateException e3) {
                DeviceLog.exception("Certificate exception", e3);
                return debuggable;
            }
        }
        return debuggable;
    }
}
