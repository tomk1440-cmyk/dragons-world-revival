package com.google.android.gms.tagmanager;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zzy implements zzbh {
    private int zzRB = 5;

    @Override // com.google.android.gms.tagmanager.zzbh
    public void e(String message) {
        if (this.zzRB <= 6) {
            Log.e("GoogleTagManager", message);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void setLogLevel(int logLevel) {
        this.zzRB = logLevel;
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void v(String message) {
        if (this.zzRB <= 2) {
            Log.v("GoogleTagManager", message);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzaI(String str) {
        if (this.zzRB <= 3) {
            Log.d("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzaJ(String str) {
        if (this.zzRB <= 4) {
            Log.i("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzaK(String str) {
        if (this.zzRB <= 5) {
            Log.w("GoogleTagManager", str);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzb(String str, Throwable th) {
        if (this.zzRB <= 6) {
            Log.e("GoogleTagManager", str, th);
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbh
    public void zzd(String str, Throwable th) {
        if (this.zzRB <= 5) {
            Log.w("GoogleTagManager", str, th);
        }
    }
}
