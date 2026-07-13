package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzn extends zzy.zza {
    private static final Object zzqy = new Object();
    private static zzn zzqz;
    private final Context mContext;
    private final Object zzpV = new Object();
    private float zzqB = -1.0f;
    private boolean zzqA = false;

    zzn(Context context) {
        this.mContext = context;
    }

    public static zzn zzbs() {
        zzn zznVar;
        synchronized (zzqy) {
            zznVar = zzqz;
        }
        return zznVar;
    }

    public static zzn zzr(Context context) {
        zzn zznVar;
        synchronized (zzqy) {
            if (zzqz == null) {
                zzqz = new zzn(context.getApplicationContext());
            }
            zznVar = zzqz;
        }
        return zznVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzy
    public void setAppVolume(float volume) {
        synchronized (this.zzpV) {
            this.zzqB = volume;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzy
    public void zza() {
        synchronized (zzqy) {
            if (this.zzqA) {
                zzin.zzaK("Mobile ads is initialized already.");
            } else {
                this.zzqA = true;
            }
        }
    }

    public float zzbt() {
        float f;
        synchronized (this.zzpV) {
            f = this.zzqB;
        }
        return f;
    }

    public boolean zzbu() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzqB >= 0.0f;
        }
        return z;
    }
}
