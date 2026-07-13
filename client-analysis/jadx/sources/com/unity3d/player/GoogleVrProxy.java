package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.View;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
class GoogleVrProxy {
    private c e;
    private k a = null;
    private boolean b = false;
    private boolean c = false;
    private Context d = null;
    private String f = "";
    private Runnable g = null;
    private a h = new a();

    class a {
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public boolean e = true;
        public boolean f = false;

        a() {
        }

        public final boolean a() {
            return this.a && this.b;
        }

        public final void b() {
            this.a = false;
            this.b = false;
            this.d = false;
            this.e = true;
            this.f = false;
        }
    }

    public GoogleVrProxy(c cVar) {
        this.e = null;
        initVrJni();
        this.e = cVar;
    }

    private void a(Runnable runnable) {
        if (this.d instanceof Activity) {
            ((Activity) this.d).runOnUiThread(runnable);
        } else {
            d.Log(5, "Not running Google VR from an Activity; Ignoring execution request...");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.e != null) {
            this.e.reportError("Google VR Error [" + this.f + "]", str);
        } else {
            d.Log(6, "Google VR Error [" + this.f + "]: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.h.d = z;
    }

    private static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    private boolean a(ClassLoader classLoader) {
        try {
            Class<?> clsLoadClass = classLoader.loadClass("com.unity3d.unitygvr.GoogleVR");
            k kVar = new k(clsLoadClass, clsLoadClass.getConstructor(new Class[0]).newInstance(new Object[0]));
            kVar.a("initialize", new Class[]{Activity.class, Context.class, SurfaceView.class, Boolean.TYPE});
            kVar.a("deinitialize", new Class[0]);
            kVar.a("load", new Class[]{Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Runnable.class});
            kVar.a("enable", new Class[]{Boolean.TYPE});
            kVar.a("unload", new Class[0]);
            kVar.a("pause", new Class[0]);
            kVar.a("resume", new Class[0]);
            kVar.a("getGvrLayout", new Class[0]);
            this.a = kVar;
            return true;
        } catch (Exception e) {
            a("Exception initializing GoogleVR from Unity library. " + e.getLocalizedMessage());
            return false;
        }
    }

    private boolean b(final Runnable runnable) {
        boolean z = false;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return true;
        }
        final Semaphore semaphore = new Semaphore(0);
        a(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    GoogleVrProxy.this.a("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                } finally {
                    semaphore.release();
                }
            }
        });
        try {
            if (semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                z = true;
            } else {
                a("Timeout waiting for vr state change!");
            }
        } catch (InterruptedException e) {
            a("Interrupted while trying to acquire sync lock. " + e.getLocalizedMessage());
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        return this.h.d;
    }

    static /* synthetic */ k f(GoogleVrProxy googleVrProxy) {
        googleVrProxy.a = null;
        return null;
    }

    private final native void initVrJni();

    public final void a(Intent intent) {
        if (intent == null || !intent.getBooleanExtra("android.intent.extra.VR_LAUNCH", false)) {
            return;
        }
        this.c = true;
    }

    public final boolean a() {
        return this.h.a;
    }

    public final boolean a(Activity activity, Context context, SurfaceView surfaceView, Runnable runnable) {
        boolean zBooleanValue;
        if (activity == null || context == null || surfaceView == null || runnable == null) {
            a("Invalid parameters passed to Google VR initiialization.");
            return false;
        }
        this.h.b();
        this.d = context;
        this.g = runnable;
        if (!a(19)) {
            a("Google VR requires a device that supports an api version of 19 (KitKat) or better.");
            return false;
        }
        if (this.c && !a(24)) {
            a("Daydream requires a device that supports an api version of 24 (Nougat) or better.");
            return false;
        }
        if (!a(UnityPlayer.class.getClassLoader())) {
            return false;
        }
        try {
            zBooleanValue = ((Boolean) this.a.a("initialize", activity, context, surfaceView, Boolean.valueOf(this.c))).booleanValue();
        } catch (Exception e) {
            a("Exception while trying to intialize Unity Google VR Library. " + e.getLocalizedMessage());
            zBooleanValue = false;
        }
        if (!zBooleanValue) {
            a("Unable to initialize GoogleVR library.");
            return false;
        }
        this.h.a = true;
        this.f = "";
        return true;
    }

    public final void b() {
        Activity activity = (Activity) this.d;
        if (!this.c || this.h.f || activity == null) {
            return;
        }
        this.h.f = true;
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        activity.startActivity(intent);
    }

    public final void c() {
        resumeGvrLayout();
    }

    protected long loadGoogleVr(final boolean z, final boolean z2, final boolean z3) {
        if (!this.h.a) {
            return 0L;
        }
        final AtomicLong atomicLong = new AtomicLong(0L);
        this.f = (z || z2) ? "Daydream" : "Cardboard";
        if (!b(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    atomicLong.set(((Long) GoogleVrProxy.this.a.a("load", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), GoogleVrProxy.this.g)).longValue());
                    GoogleVrProxy.this.h.b = true;
                } catch (Exception e) {
                    GoogleVrProxy.this.a("Exception caught while loading GoogleVR. " + e.getLocalizedMessage());
                    atomicLong.set(0L);
                }
            }
        }) || atomicLong.longValue() == 0) {
            a("Google VR had a fatal issue while loading. VR will not be available.");
        }
        return atomicLong.longValue();
    }

    protected void pauseGvrLayout() {
        if (this.h.a() && !this.h.e) {
            if (this.a != null) {
                this.a.a("pause", new Object[0]);
            }
            this.h.e = true;
        }
    }

    protected void resumeGvrLayout() {
        if (this.h.a() && this.h.e) {
            if (this.a != null) {
                this.a.a("resume", new Object[0]);
            }
            this.h.e = false;
        }
    }

    protected void setGoogleVrModeEnabled(final boolean z) {
        if (!this.h.a() || this.e == null || this.d == null) {
            return;
        }
        a(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.3
            @Override // java.lang.Runnable
            public final void run() {
                if (z == GoogleVrProxy.this.d()) {
                    return;
                }
                try {
                    if (z && !GoogleVrProxy.this.d()) {
                        if (GoogleVrProxy.this.a != null && GoogleVrProxy.this.e != null && !GoogleVrProxy.this.e.addViewToPlayer((View) GoogleVrProxy.this.a.a("getGvrLayout", new Object[0]), true)) {
                            GoogleVrProxy.this.a("Unable to add Google VR to view hierarchy.");
                            return;
                        }
                        if (GoogleVrProxy.this.h.e) {
                            GoogleVrProxy.this.resumeGvrLayout();
                        }
                        if (GoogleVrProxy.this.a != null) {
                            GoogleVrProxy.this.a.a("enable", true);
                        }
                        GoogleVrProxy.this.a(true);
                        return;
                    }
                    if (z || !GoogleVrProxy.this.d()) {
                        return;
                    }
                    GoogleVrProxy.this.a(false);
                    if (GoogleVrProxy.this.a != null) {
                        GoogleVrProxy.this.a.a("enable", false);
                    }
                    if (!GoogleVrProxy.this.h.e) {
                        GoogleVrProxy.this.pauseGvrLayout();
                    }
                    if (GoogleVrProxy.this.a == null || GoogleVrProxy.this.e == null) {
                        return;
                    }
                    GoogleVrProxy.this.e.removeViewFromPlayer((View) GoogleVrProxy.this.a.a("getGvrLayout", new Object[0]));
                } catch (Exception e) {
                    GoogleVrProxy.this.a("Exception enabling Google VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }

    protected void unloadGoogleVr() {
        if (this.h.d) {
            setGoogleVrModeEnabled(false);
        }
        if (this.h.c) {
            this.h.c = false;
        }
        a(new Runnable() { // from class: com.unity3d.player.GoogleVrProxy.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (GoogleVrProxy.this.a != null) {
                        GoogleVrProxy.this.a.a("unload", new Object[0]);
                        GoogleVrProxy.this.a.a("deinitialize", new Object[0]);
                        GoogleVrProxy.f(GoogleVrProxy.this);
                    }
                    GoogleVrProxy.this.h.b();
                } catch (Exception e) {
                    GoogleVrProxy.this.a("Exception unloading Google VR on UI Thread. " + e.getLocalizedMessage());
                }
            }
        });
    }
}
