package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzg();
    private final String mName;
    final int mVersionCode;
    private boolean zzTb;
    private final int zzabB;
    private final int zzapo;
    private final String zzawc;
    private final boolean zzbqY;
    private String zzbqZ;
    private boolean zzbra;
    private String zzbrb;

    ConnectionConfiguration(int versionCode, String name, String address, int type, int role, boolean connectionEnabled, boolean isConnected, String peerNodeId, boolean btlePriority, String nodeId) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzawc = address;
        this.zzabB = type;
        this.zzapo = role;
        this.zzbqY = connectionEnabled;
        this.zzTb = isConnected;
        this.zzbqZ = peerNodeId;
        this.zzbra = btlePriority;
        this.zzbrb = nodeId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) o;
        return zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && zzw.equal(this.mName, connectionConfiguration.mName) && zzw.equal(this.zzawc, connectionConfiguration.zzawc) && zzw.equal(Integer.valueOf(this.zzabB), Integer.valueOf(connectionConfiguration.zzabB)) && zzw.equal(Integer.valueOf(this.zzapo), Integer.valueOf(connectionConfiguration.zzapo)) && zzw.equal(Boolean.valueOf(this.zzbqY), Boolean.valueOf(connectionConfiguration.zzbqY)) && zzw.equal(Boolean.valueOf(this.zzbra), Boolean.valueOf(connectionConfiguration.zzbra));
    }

    public String getAddress() {
        return this.zzawc;
    }

    public String getName() {
        return this.mName;
    }

    public String getNodeId() {
        return this.zzbrb;
    }

    public int getRole() {
        return this.zzapo;
    }

    public int getType() {
        return this.zzabB;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.mName, this.zzawc, Integer.valueOf(this.zzabB), Integer.valueOf(this.zzapo), Boolean.valueOf(this.zzbqY), Boolean.valueOf(this.zzbra));
    }

    public boolean isConnected() {
        return this.zzTb;
    }

    public boolean isEnabled() {
        return this.zzbqY;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ ");
        sb.append("mName=" + this.mName);
        sb.append(", mAddress=" + this.zzawc);
        sb.append(", mType=" + this.zzabB);
        sb.append(", mRole=" + this.zzapo);
        sb.append(", mEnabled=" + this.zzbqY);
        sb.append(", mIsConnected=" + this.zzTb);
        sb.append(", mPeerNodeId=" + this.zzbqZ);
        sb.append(", mBtlePriority=" + this.zzbra);
        sb.append(", mNodeId=" + this.zzbrb);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public String zzIt() {
        return this.zzbqZ;
    }

    public boolean zzIu() {
        return this.zzbra;
    }
}
