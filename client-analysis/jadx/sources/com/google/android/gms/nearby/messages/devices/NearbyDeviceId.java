package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class NearbyDeviceId implements SafeParcelable {
    public static final Parcelable.Creator<NearbyDeviceId> CREATOR = new zzh();
    public static final NearbyDeviceId zzbcl = new NearbyDeviceId();
    final int mVersionCode;
    private final int zzabB;
    final byte[] zzbbY;
    private final zzb zzbcm;
    private final zzd zzbcn;

    private NearbyDeviceId() {
        this(1, 1, null);
    }

    NearbyDeviceId(int versionCode, int type, byte[] bytes) {
        this.mVersionCode = versionCode;
        this.zzabB = type;
        this.zzbbY = bytes;
        this.zzbcm = type == 2 ? new zzb(bytes) : null;
        this.zzbcn = type == 3 ? new zzd(bytes) : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NearbyDeviceId)) {
            return false;
        }
        NearbyDeviceId nearbyDeviceId = (NearbyDeviceId) o;
        return zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(nearbyDeviceId.zzabB)) && zzw.equal(this.zzbbY, nearbyDeviceId.zzbbY);
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzabB), this.zzbbY);
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder().append("NearbyDeviceId{");
        switch (this.zzabB) {
            case 1:
                sbAppend.append("UNKNOWN");
                break;
            case 2:
                sbAppend.append("eddystoneUid=").append(this.zzbcm);
                break;
            case 3:
                sbAppend.append("iBeaconId=").append(this.zzbcn);
                break;
        }
        sbAppend.append("}");
        return sbAppend.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
