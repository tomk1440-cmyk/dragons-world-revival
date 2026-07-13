package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzao;
import com.google.android.gms.drive.internal.zzz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc, zzq {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzakz;
    private CountDownLatch zzapL;
    zza zzapM;
    boolean zzapN;

    final class zza extends Handler {
        zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Message zzsW() {
            return obtainMessage(2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            zzz.zzy("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    DriveEventService.this.zza((OnEventResponse) msg.obj);
                    break;
                case 2:
                    getLooper().quit();
                    break;
                default:
                    zzz.zzz("DriveEventService", "Unexpected message type:" + msg.what);
                    break;
            }
        }
    }

    final class zzb extends zzao.zza {
        zzb() {
        }

        @Override // com.google.android.gms.drive.internal.zzao
        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (DriveEventService.this) {
                zzz.zzy("DriveEventService", "onEvent: " + onEventResponse);
                DriveEventService.this.zzsV();
                if (DriveEventService.this.zzapM != null) {
                    DriveEventService.this.zzapM.sendMessage(DriveEventService.this.zzapM.zzb(onEventResponse));
                } else {
                    zzz.zzA("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.zzapN = false;
        this.zzakz = -1;
        this.mName = name;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(OnEventResponse onEventResponse) {
        DriveEvent driveEventZzts = onEventResponse.zzts();
        zzz.zzy("DriveEventService", "handleEventMessage: " + driveEventZzts);
        try {
            switch (driveEventZzts.getType()) {
                case 1:
                    onChange((ChangeEvent) driveEventZzts);
                    break;
                case 2:
                    onCompletion((CompletionEvent) driveEventZzts);
                    break;
                case 3:
                case 5:
                case 6:
                default:
                    zzz.zzz(this.mName, "Unhandled event: " + driveEventZzts);
                    break;
                case 4:
                    zza((ChangesAvailableEvent) driveEventZzts);
                    break;
                case 7:
                    zza((TransferStateEvent) driveEventZzts);
                    break;
            }
        } catch (Exception e) {
            zzz.zza(this.mName, e, "Error handling event: " + driveEventZzts);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzsV() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid == this.zzakz) {
            return;
        }
        if (!GooglePlayServicesUtil.zzf(this, callingUid)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.zzakz = callingUid;
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [com.google.android.gms.drive.events.DriveEventService$1] */
    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        IBinder iBinderAsBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzapM == null && !this.zzapN) {
                this.zzapN = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzapL = new CountDownLatch(1);
                new Thread() { // from class: com.google.android.gms.drive.events.DriveEventService.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Looper.prepare();
                            DriveEventService.this.zzapM = DriveEventService.this.new zza();
                            DriveEventService.this.zzapN = false;
                            countDownLatch.countDown();
                            zzz.zzy("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            zzz.zzy("DriveEventService", "Finished loop");
                        } finally {
                            if (DriveEventService.this.zzapL != null) {
                                DriveEventService.this.zzapL.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000L, TimeUnit.MILLISECONDS)) {
                        zzz.zzA("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            iBinderAsBinder = new zzb().asBinder();
        } else {
            iBinderAsBinder = null;
        }
        return iBinderAsBinder;
    }

    @Override // com.google.android.gms.drive.events.ChangeListener
    public void onChange(ChangeEvent event) {
        zzz.zzz(this.mName, "Unhandled change event: " + event);
    }

    @Override // com.google.android.gms.drive.events.CompletionListener
    public void onCompletion(CompletionEvent event) {
        zzz.zzz(this.mName, "Unhandled completion event: " + event);
    }

    @Override // android.app.Service
    public synchronized void onDestroy() {
        zzz.zzy("DriveEventService", "onDestroy");
        if (this.zzapM != null) {
            this.zzapM.sendMessage(this.zzapM.zzsW());
            this.zzapM = null;
            try {
                if (!this.zzapL.await(5000L, TimeUnit.MILLISECONDS)) {
                    zzz.zzz("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzapL = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override // com.google.android.gms.drive.events.zzc
    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzz.zzz(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }

    public void zza(TransferStateEvent transferStateEvent) {
        zzz.zzz(this.mName, "Unhandled transfer state event: " + transferStateEvent);
    }
}
