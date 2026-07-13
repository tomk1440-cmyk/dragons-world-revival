package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.nearby.bootstrap.Device;

/* JADX INFO: loaded from: classes.dex */
public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzbaR;
    private final Device zzbaS;
    private final zzqe zzbaT;
    private final zzqf zzbaU;
    private final zzqg zzbaV;
    private final String zzbaW;
    private final byte zzbaX;

    ConnectRequest(int versionCode, Device device, String name, String description, byte deviceType, long timeoutMillis, String token, byte connectType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.zzbaS = (Device) zzx.zzz(device);
        this.name = zzx.zzcM(name);
        this.description = (String) zzx.zzz(description);
        this.zzbaR = deviceType;
        this.timeoutMillis = timeoutMillis;
        this.zzbaX = connectType;
        this.zzbaW = token;
        zzx.zzz(connectionListener);
        this.zzbaT = zzqe.zza.zzdq(connectionListener);
        zzx.zzz(dataListener);
        this.zzbaU = zzqf.zza.zzdr(dataListener);
        zzx.zzz(callback);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzbaV == null) {
            return null;
        }
        return this.zzbaV.asBinder();
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzbaW;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza zzaVar = CREATOR;
        zza.zza(this, out, flags);
    }

    public byte zzEb() {
        return this.zzbaR;
    }

    public Device zzEd() {
        return this.zzbaS;
    }

    public long zzEe() {
        return this.timeoutMillis;
    }

    public byte zzEf() {
        return this.zzbaX;
    }

    public IBinder zzEg() {
        if (this.zzbaT == null) {
            return null;
        }
        return this.zzbaT.asBinder();
    }

    public IBinder zzEh() {
        if (this.zzbaU == null) {
            return null;
        }
        return this.zzbaU.asBinder();
    }
}
