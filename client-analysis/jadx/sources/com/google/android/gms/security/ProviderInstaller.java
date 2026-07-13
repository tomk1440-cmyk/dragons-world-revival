package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final zzc zzbgP = zzc.zzoK();
    private static final Object zzqy = new Object();
    private static Method zzbgQ = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzb(context, "Context must not be null");
        zzbgP.zzak(context);
        Context remoteContext = zze.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (zzqy) {
            try {
                if (zzbgQ == null) {
                    zzaV(remoteContext);
                }
                zzbgQ.invoke(null, remoteContext);
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener listener) {
        zzx.zzb(context, "Context must not be null");
        zzx.zzb(listener, "Listener must not be null");
        zzx.zzcD("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() { // from class: com.google.android.gms.security.ProviderInstaller.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
            public Integer doInBackground(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return 0;
                } catch (GooglePlayServicesNotAvailableException e) {
                    return Integer.valueOf(e.errorCode);
                } catch (GooglePlayServicesRepairableException e2) {
                    return Integer.valueOf(e2.getConnectionStatusCode());
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Integer num) {
                if (num.intValue() == 0) {
                    listener.onProviderInstalled();
                } else {
                    listener.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzbgP.zza(context, num.intValue(), "pi"));
                }
            }
        }.execute(new Void[0]);
    }

    private static void zzaV(Context context) throws NoSuchMethodException, ClassNotFoundException {
        zzbgQ = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
    }
}
