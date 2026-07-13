package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public abstract class WriteAwareParcelable implements Parcelable {
    private volatile transient boolean zzapw = false;

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzx.zzab(!zzsT());
        this.zzapw = true;
        zzJ(dest, flags);
    }

    protected abstract void zzJ(Parcel parcel, int i);

    public final boolean zzsT() {
        return this.zzapw;
    }
}
