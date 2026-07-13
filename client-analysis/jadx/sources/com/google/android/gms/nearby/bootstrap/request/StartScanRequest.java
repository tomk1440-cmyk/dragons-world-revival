package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqi;

/* JADX INFO: loaded from: classes.dex */
public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzqg zzbaV;
    private final zzqi zzbaY;

    StartScanRequest(int versionCode, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzz(scanListener);
        this.zzbaY = zzqi.zza.zzdu(scanListener);
        zzx.zzz(callback);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzg zzgVar = CREATOR;
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
        zzg zzgVar = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzEi() {
        if (this.zzbaY == null) {
            return null;
        }
        return this.zzbaY.asBinder();
    }
}
