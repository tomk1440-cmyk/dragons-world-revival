package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;

/* JADX INFO: loaded from: classes.dex */
public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzbaR;
    private final zzqe zzbaT;
    private final zzqf zzbaU;
    private final zzqg zzbaV;

    EnableTargetRequest(int versionCode, String name, String description, byte deviceType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.name = zzx.zzcM(name);
        this.description = (String) zzx.zzz(description);
        this.zzbaR = deviceType;
        zzx.zzz(connectionListener);
        this.zzbaT = zzqe.zza.zzdq(connectionListener);
        zzx.zzz(dataListener);
        this.zzbaU = zzqf.zza.zzdr(dataListener);
        zzx.zzz(callback);
        this.zzbaV = zzqg.zza.zzds(callback);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zze zzeVar = CREATOR;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zze zzeVar = CREATOR;
        zze.zza(this, out, flags);
    }

    public byte zzEb() {
        return this.zzbaR;
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
