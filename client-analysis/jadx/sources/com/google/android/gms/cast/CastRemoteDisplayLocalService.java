package com.google.android.gms.cast;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.R;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public abstract class CastRemoteDisplayLocalService extends Service {
    private static final zzl zzaaf = new zzl("CastRemoteDisplayLocalService");
    private static final int zzaag = R.id.cast_notification_id;
    private static final Object zzaah = new Object();
    private static AtomicBoolean zzaai = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzaax;
    private Handler mHandler;
    private Notification mNotification;
    private String zzZC;
    private GoogleApiClient zzaaj;
    private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzaak;
    private Callbacks zzaal;
    private zzb zzaam;
    private NotificationSettings zzaan;
    private boolean zzaao;
    private PendingIntent zzaap;
    private CastDevice zzaaq;
    private Display zzaar;
    private Context zzaas;
    private ServiceConnection zzaat;
    private MediaRouter zzaau;
    private boolean zzaav = false;
    private final MediaRouter.Callback zzaaw = new MediaRouter.Callback() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.1
        public void onRouteUnselected(MediaRouter router, MediaRouter.RouteInfo info) {
            CastRemoteDisplayLocalService.this.zzbe("onRouteUnselected");
            if (CastRemoteDisplayLocalService.this.zzaaq == null) {
                CastRemoteDisplayLocalService.this.zzbe("onRouteUnselected, no device was selected");
            } else if (CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.this.zzaaq.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                CastRemoteDisplayLocalService.this.zzbe("onRouteUnselected, device does not match");
            }
        }
    };
    private final IBinder zzaay = new zza();

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);

        void onServiceCreated(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzaaF;
        private String zzaaG;
        private String zzaaH;

        public static final class Builder {
            private NotificationSettings zzaaI = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzaaI.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzaaI.zzaaG)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    }
                    if (!TextUtils.isEmpty(this.zzaaI.zzaaH)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    }
                    if (this.zzaaI.zzaaF != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzaaI.zzaaG) && TextUtils.isEmpty(this.zzaaI.zzaaH) && this.zzaaI.zzaaF == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzaaI;
            }

            public Builder setNotification(Notification notification) {
                this.zzaaI.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzaaI.zzaaF = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzaaI.zzaaH = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzaaI.zzaaG = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzaaF = newSettings.zzaaF;
            this.zzaaG = newSettings.zzaaG;
            this.zzaaH = newSettings.zzaaH;
        }
    }

    private class zza extends Binder {
        private zza() {
        }

        CastRemoteDisplayLocalService zznM() {
            return CastRemoteDisplayLocalService.this;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzaaf.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzaah) {
            castRemoteDisplayLocalService = zzaax;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzaaf.zzY(true);
    }

    public static void startService(final Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, final String applicationId, final CastDevice device, final NotificationSettings notificationSettings, final Callbacks callbacks) {
        zzaaf.zzb("Starting Service", new Object[0]);
        synchronized (zzaah) {
            if (zzaax != null) {
                zzaaf.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzS(true);
            }
        }
        zzb(activityContext, serviceClass);
        zzx.zzb(activityContext, "activityContext is required.");
        zzx.zzb(serviceClass, "serviceClass is required.");
        zzx.zzb(applicationId, "applicationId is required.");
        zzx.zzb(device, "device is required.");
        zzx.zzb(notificationSettings, "notificationSettings is required.");
        zzx.zzb(callbacks, "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzaaF == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        }
        if (zzaai.getAndSet(true)) {
            zzaaf.zzc("Service is already being started, startService has been called twice", new Object[0]);
            return;
        }
        Intent intent = new Intent(activityContext, serviceClass);
        activityContext.startService(intent);
        activityContext.bindService(intent, new ServiceConnection() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.4
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName className, IBinder binder) {
                CastRemoteDisplayLocalService castRemoteDisplayLocalServiceZznM = ((zza) binder).zznM();
                if (castRemoteDisplayLocalServiceZznM == null || !castRemoteDisplayLocalServiceZznM.zza(applicationId, device, notificationSettings, activityContext, this, callbacks)) {
                    CastRemoteDisplayLocalService.zzaaf.zzc("Connected but unable to get the service instance", new Object[0]);
                    callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                    CastRemoteDisplayLocalService.zzaai.set(false);
                    try {
                        activityContext.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName arg0) {
                CastRemoteDisplayLocalService.zzaaf.zzb("onServiceDisconnected", new Object[0]);
                callbacks.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                CastRemoteDisplayLocalService.zzaai.set(false);
                try {
                    activityContext.unbindService(this);
                } catch (IllegalArgumentException e) {
                    CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                }
            }
        }, 64);
    }

    public static void stopService() {
        zzS(false);
    }

    private void zzQ(final boolean z) {
        if (this.mHandler != null) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.mHandler.post(new Runnable() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.5
                    @Override // java.lang.Runnable
                    public void run() {
                        CastRemoteDisplayLocalService.this.zzR(z);
                    }
                });
            } else {
                zzR(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzR(boolean z) {
        zzbe("Stopping Service");
        zzx.zzcD("stopServiceInstanceInternal must be called on the main thread");
        if (!z && this.zzaau != null) {
            zzbe("Setting default route");
            this.zzaau.selectRoute(this.zzaau.getDefaultRoute());
        }
        if (this.zzaam != null) {
            zzbe("Unregistering notification receiver");
            unregisterReceiver(this.zzaam);
        }
        zznF();
        zznG();
        zznB();
        if (this.zzaaj != null) {
            this.zzaaj.disconnect();
            this.zzaaj = null;
        }
        if (this.zzaas != null && this.zzaat != null) {
            try {
                this.zzaas.unbindService(this.zzaat);
            } catch (IllegalArgumentException e) {
                zzbe("No need to unbind service, already unbound");
            }
            this.zzaat = null;
            this.zzaas = null;
        }
        this.zzZC = null;
        this.zzaaj = null;
        this.mNotification = null;
        this.zzaar = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzS(boolean z) {
        zzaaf.zzb("Stopping Service", new Object[0]);
        zzaai.set(false);
        synchronized (zzaah) {
            if (zzaax == null) {
                zzaaf.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzaax;
            zzaax = null;
            castRemoteDisplayLocalService.zzQ(z);
        }
    }

    private Notification zzT(boolean z) {
        int i;
        int i2;
        zzbe("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        String string = this.zzaan.zzaaG;
        String str = this.zzaan.zzaaH;
        if (z) {
            i = R.string.cast_notification_connected_message;
            i2 = R.drawable.cast_ic_notification_on;
        } else {
            i = R.string.cast_notification_connecting_message;
            i2 = R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(string)) {
            string = getString(i3);
        }
        return new NotificationCompat.Builder(this).setContentTitle(string).setContentText(TextUtils.isEmpty(str) ? getString(i, new Object[]{this.zzaaq.getFriendlyName()}) : str).setContentIntent(this.zzaan.zzaaF).setSmallIcon(i2).setOngoing(true).addAction(android.R.drawable.ic_menu_close_clear_cancel, getString(R.string.cast_notification_disconnect), zznH()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.10
            @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
            public void onConnected(Bundle bundle) {
                CastRemoteDisplayLocalService.this.zzbe("onConnected");
                CastRemoteDisplayLocalService.this.zznC();
            }

            @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
            public void onConnectionSuspended(int cause) {
                CastRemoteDisplayLocalService.zzaaf.zzf(String.format("[Instance: %s] ConnectionSuspended %d", this, Integer.valueOf(cause)), new Object[0]);
            }
        }, new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.2
            @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
            public void onConnectionFailed(ConnectionResult connectionResult) {
                CastRemoteDisplayLocalService.this.zzbh("Connection failed: " + connectionResult);
                CastRemoteDisplayLocalService.this.zznE();
            }
        }).addApi(CastRemoteDisplay.API, new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(castDevice, this.zzaak).build()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(Display display) {
        this.zzaar = display;
        if (this.zzaao) {
            this.mNotification = zzT(true);
            startForeground(zzaag, this.mNotification);
        }
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionStarted(this);
            this.zzaal = null;
        }
        onCreatePresentation(this.zzaar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(NotificationSettings notificationSettings) {
        zzx.zzcD("updateNotificationSettingsInternal must be called on the main thread");
        if (this.zzaan == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzaao) {
            zzx.zzb(notificationSettings.mNotification, "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzaan.mNotification = this.mNotification;
        } else {
            if (notificationSettings.mNotification != null) {
                throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
            }
            if (notificationSettings.zzaaF != null) {
                this.zzaan.zzaaF = notificationSettings.zzaaF;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaG)) {
                this.zzaan.zzaaG = notificationSettings.zzaaG;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzaaH)) {
                this.zzaan.zzaaH = notificationSettings.zzaaH;
            }
            this.mNotification = zzT(true);
        }
        startForeground(zzaag, this.mNotification);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zza(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzbe("startRemoteDisplaySession");
        zzx.zzcD("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzaah) {
            if (zzaax != null) {
                zzaaf.zzf("An existing service had not been stopped before starting one", new Object[0]);
                return false;
            }
            zzaax = this;
            this.zzaal = callbacks;
            this.zzZC = str;
            this.zzaaq = castDevice;
            this.zzaas = context;
            this.zzaat = serviceConnection;
            this.zzaau = MediaRouter.getInstance(getApplicationContext());
            MediaRouteSelector mediaRouteSelectorBuild = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzZC)).build();
            zzbe("addMediaRouterCallback");
            this.zzaau.addCallback(mediaRouteSelectorBuild, this.zzaaw, 4);
            this.zzaak = new CastRemoteDisplay.CastRemoteDisplaySessionCallbacks() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.7
                @Override // com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks
                public void onRemoteDisplayEnded(Status status) {
                    CastRemoteDisplayLocalService.zzaaf.zzb(String.format("Cast screen has ended: %d", Integer.valueOf(status.getStatusCode())), new Object[0]);
                    CastRemoteDisplayLocalService.zzS(false);
                }
            };
            this.mNotification = notificationSettings.mNotification;
            this.zzaam = new zzb();
            registerReceiver(this.zzaam, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
            this.zzaan = new NotificationSettings(notificationSettings);
            if (this.zzaan.mNotification == null) {
                this.zzaao = true;
                this.mNotification = zzT(false);
            } else {
                this.zzaao = false;
                this.mNotification = this.zzaan.mNotification;
            }
            startForeground(zzaag, this.mNotification);
            this.zzaaj = zza(castDevice);
            this.zzaaj.connect();
            if (this.zzaal != null) {
                this.zzaal.onServiceCreated(this);
            }
            return true;
        }
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) cls), 128);
            if (serviceInfo == null || !serviceInfo.exported) {
            } else {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbe(String str) {
        zzaaf.zzb("[Instance: %s] %s", this, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbh(String str) {
        zzaaf.zzc("[Instance: %s] %s", this, str);
    }

    private void zznB() {
        if (this.zzaau != null) {
            zzx.zzcD("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzbe("removeMediaRouterCallback");
            this.zzaau.removeCallback(this.zzaaw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznC() {
        zzbe("startRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzaaj, this.zzZC).setResultCallback(new ResultCallback<CastRemoteDisplay.CastRemoteDisplaySessionResult>() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.8
                @Override // com.google.android.gms.common.api.ResultCallback
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void onResult(CastRemoteDisplay.CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
                    if (!castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                        CastRemoteDisplayLocalService.zzaaf.zzc("Connection was not successful", new Object[0]);
                        CastRemoteDisplayLocalService.this.zznE();
                        return;
                    }
                    CastRemoteDisplayLocalService.zzaaf.zzb("startRemoteDisplay successful", new Object[0]);
                    synchronized (CastRemoteDisplayLocalService.zzaah) {
                        if (CastRemoteDisplayLocalService.zzaax == null) {
                            CastRemoteDisplayLocalService.zzaaf.zzb("Remote Display started but session already cancelled", new Object[0]);
                            CastRemoteDisplayLocalService.this.zznE();
                        } else {
                            Display presentationDisplay = castRemoteDisplaySessionResult.getPresentationDisplay();
                            if (presentationDisplay != null) {
                                CastRemoteDisplayLocalService.this.zza(presentationDisplay);
                            } else {
                                CastRemoteDisplayLocalService.zzaaf.zzc("Cast Remote Display session created without display", new Object[0]);
                            }
                            CastRemoteDisplayLocalService.zzaai.set(false);
                            if (CastRemoteDisplayLocalService.this.zzaas != null && CastRemoteDisplayLocalService.this.zzaat != null) {
                                try {
                                    CastRemoteDisplayLocalService.this.zzaas.unbindService(CastRemoteDisplayLocalService.this.zzaat);
                                } catch (IllegalArgumentException e) {
                                    CastRemoteDisplayLocalService.zzaaf.zzb("No need to unbind service, already unbound", new Object[0]);
                                }
                                CastRemoteDisplayLocalService.this.zzaat = null;
                                CastRemoteDisplayLocalService.this.zzaas = null;
                            }
                        }
                    }
                }
            });
        }
    }

    private void zznD() {
        zzbe("stopRemoteDisplay");
        if (this.zzaaj == null || !this.zzaaj.isConnected()) {
            zzaaf.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzaaj).setResultCallback(new ResultCallback<CastRemoteDisplay.CastRemoteDisplaySessionResult>() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.9
                @Override // com.google.android.gms.common.api.ResultCallback
                /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
                public void onResult(CastRemoteDisplay.CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
                    if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                        CastRemoteDisplayLocalService.this.zzbe("remote display stopped");
                    } else {
                        CastRemoteDisplayLocalService.this.zzbe("Unable to stop the remote display, result unsuccessful");
                    }
                    CastRemoteDisplayLocalService.this.zzaar = null;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznE() {
        if (this.zzaal != null) {
            this.zzaal.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzaal = null;
        }
        stopService();
    }

    private void zznF() {
        zzbe("stopRemoteDisplaySession");
        zznD();
        onDismissPresentation();
    }

    private void zznG() {
        zzbe("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zznH() {
        if (this.zzaap == null) {
            this.zzaap = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzaap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.content.ContextWrapper, android.content.Context
    public Display getDisplay() {
        return this.zzaar;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        zzbe("onBind");
        return this.zzaay;
    }

    @Override // android.app.Service
    public void onCreate() {
        zzbe("onCreate");
        super.onCreate();
        this.mHandler = new Handler(getMainLooper());
        this.mHandler.postDelayed(new Runnable() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.3
            @Override // java.lang.Runnable
            public void run() {
                CastRemoteDisplayLocalService.this.zzbe("onCreate after delay. The local service been started: " + CastRemoteDisplayLocalService.this.zzaav);
                if (CastRemoteDisplayLocalService.this.zzaav) {
                    return;
                }
                CastRemoteDisplayLocalService.this.zzbh("The local service has not been been started, stopping it");
                CastRemoteDisplayLocalService.this.stopSelf();
            }
        }, 100L);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        zzbe("onStartCommand");
        this.zzaav = true;
        return 2;
    }

    public void updateNotificationSettings(final NotificationSettings notificationSettings) {
        zzx.zzb(notificationSettings, "notificationSettings is required.");
        zzx.zzb(this.mHandler, "Service is not ready yet.");
        this.mHandler.post(new Runnable() { // from class: com.google.android.gms.cast.CastRemoteDisplayLocalService.6
            @Override // java.lang.Runnable
            public void run() {
                CastRemoteDisplayLocalService.this.zza(notificationSettings);
            }
        });
    }
}
