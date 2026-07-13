package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
public final class zzmd extends LruCache<zza, Drawable> {

    public static final class zza {
        public final int zzakx;
        public final int zzaky;

        public zza(int i, int i2) {
            this.zzakx = i;
            this.zzaky = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return zzaVar.zzakx == this.zzakx && zzaVar.zzaky == this.zzaky;
        }

        public int hashCode() {
            return com.google.android.gms.common.internal.zzw.hashCode(Integer.valueOf(this.zzakx), Integer.valueOf(this.zzaky));
        }
    }

    public zzmd() {
        super(10);
    }
}
