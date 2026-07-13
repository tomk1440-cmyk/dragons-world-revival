package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class zzl {
    private static boolean zzaed = false;
    protected final String mTag;
    private final boolean zzaee;
    private boolean zzaef;
    private boolean zzaeg;
    private String zzaeh;

    public zzl(String str) {
        this(str, zzox());
    }

    public zzl(String str, boolean z) {
        zzx.zzh(str, "The log tag cannot be null or empty.");
        this.mTag = str;
        this.zzaee = str.length() <= 23;
        this.zzaef = z;
        this.zzaeg = false;
    }

    public static boolean zzox() {
        return zzaed;
    }

    public void zzY(boolean z) {
        this.zzaef = z;
    }

    public void zza(String str, Object... objArr) {
        if (zzow()) {
            Log.v(this.mTag, zzg(str, objArr));
        }
    }

    public void zzb(String str, Object... objArr) {
        if (zzov() || zzaed) {
            Log.d(this.mTag, zzg(str, objArr));
        }
    }

    public void zzb(Throwable th, String str, Object... objArr) {
        if (zzov() || zzaed) {
            Log.d(this.mTag, zzg(str, objArr), th);
        }
    }

    public void zzc(String str, Object... objArr) {
        Log.e(this.mTag, zzg(str, objArr));
    }

    public void zzc(Throwable th, String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr), th);
    }

    public void zzcn(String str) {
        this.zzaeh = TextUtils.isEmpty(str) ? null : String.format("[%s] ", str);
    }

    public void zze(String str, Object... objArr) {
        Log.i(this.mTag, zzg(str, objArr));
    }

    public void zzf(String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr));
    }

    protected String zzg(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.zzaeh) ? this.zzaeh + str : str;
    }

    public boolean zzov() {
        return this.zzaef || (this.zzaee && Log.isLoggable(this.mTag, 3));
    }

    public boolean zzow() {
        return this.zzaeg;
    }
}
