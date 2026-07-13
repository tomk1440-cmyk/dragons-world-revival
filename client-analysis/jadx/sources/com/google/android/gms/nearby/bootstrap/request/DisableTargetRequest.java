package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;

/* JADX INFO: loaded from: classes.dex */
public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    private final zzqg zzbaV;

    DisableTargetRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzz(callback);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzc zzcVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzc zzcVar = CREATOR;
        zzc.zza(this, out, flags);
    }
}
