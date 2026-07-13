package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;

/* JADX INFO: loaded from: classes.dex */
public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzqg zzbaV;
    private final String zzbaW;

    ContinueConnectRequest(int versionCode, String token, IBinder callback) {
        this.versionCode = versionCode;
        this.zzbaW = (String) zzx.zzz(token);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public String getToken() {
        return this.zzbaW;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, out, flags);
    }
}
