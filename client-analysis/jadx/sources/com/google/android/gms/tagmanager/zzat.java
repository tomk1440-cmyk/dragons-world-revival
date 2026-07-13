package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes.dex */
class zzat extends Thread implements zzas {
    private static zzat zzbjb;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean zzRE;
    private final LinkedBlockingQueue<Runnable> zzbja;
    private volatile zzau zzbjc;

    private zzat(Context context) {
        super("GAThread");
        this.zzbja = new LinkedBlockingQueue<>();
        this.zzRE = false;
        this.mClosed = false;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzat zzaZ(Context context) {
        if (zzbjb == null) {
            zzbjb = new zzat(context);
        }
        return zzbjb;
    }

    private String zzd(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.mClosed) {
            try {
                try {
                    Runnable runnableTake = this.zzbja.take();
                    if (!this.zzRE) {
                        runnableTake.run();
                    }
                } catch (InterruptedException e) {
                    zzbg.zzaJ(e.toString());
                }
            } catch (Throwable th) {
                zzbg.e("Error on Google TagManager Thread: " + zzd(th));
                zzbg.e("Google TagManager is shutting down.");
                this.zzRE = true;
            }
        }
    }

    @Override // com.google.android.gms.tagmanager.zzas
    public void zzgg(String str) {
        zzk(str, System.currentTimeMillis());
    }

    @Override // com.google.android.gms.tagmanager.zzas
    public void zzj(Runnable runnable) {
        this.zzbja.add(runnable);
    }

    void zzk(final String str, final long j) {
        zzj(new Runnable() { // from class: com.google.android.gms.tagmanager.zzat.1
            @Override // java.lang.Runnable
            public void run() {
                if (zzat.this.zzbjc == null) {
                    zzcu zzcuVarZzHo = zzcu.zzHo();
                    zzcuVarZzHo.zza(zzat.this.mContext, this);
                    zzat.this.zzbjc = zzcuVarZzHo.zzHr();
                }
                zzat.this.zzbjc.zzg(j, str);
            }
        });
    }
}
