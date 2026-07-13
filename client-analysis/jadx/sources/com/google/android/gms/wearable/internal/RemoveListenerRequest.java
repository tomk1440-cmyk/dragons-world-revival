package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class RemoveListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbg();
    final int mVersionCode;
    public final zzaw zzbrB;

    RemoveListenerRequest(int versionCode, IBinder listener) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzbrB = zzaw.zza.zzet(listener);
        } else {
            this.zzbrB = null;
        }
    }

    public RemoveListenerRequest(zzaw listener) {
        this.mVersionCode = 1;
        this.zzbrB = listener;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbg.zza(this, dest, flags);
    }

    IBinder zzIy() {
        if (this.zzbrB == null) {
            return null;
        }
        return this.zzbrB.asBinder();
    }
}
