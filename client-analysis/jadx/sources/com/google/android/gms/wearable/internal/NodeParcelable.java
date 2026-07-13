package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

/* JADX INFO: loaded from: classes.dex */
public class NodeParcelable implements SafeParcelable, Node {
    public static final Parcelable.Creator<NodeParcelable> CREATOR = new zzbc();
    final int mVersionCode;
    private final String zzWQ;
    private final int zzbsY;
    private final boolean zzbsZ;
    private final String zzyv;

    NodeParcelable(int versionCode, String id, String displayName, int hopCount, boolean isNearby) {
        this.mVersionCode = versionCode;
        this.zzyv = id;
        this.zzWQ = displayName;
        this.zzbsY = hopCount;
        this.zzbsZ = isNearby;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o instanceof NodeParcelable) {
            return ((NodeParcelable) o).zzyv.equals(this.zzyv);
        }
        return false;
    }

    @Override // com.google.android.gms.wearable.Node
    public String getDisplayName() {
        return this.zzWQ;
    }

    public int getHopCount() {
        return this.zzbsY;
    }

    @Override // com.google.android.gms.wearable.Node
    public String getId() {
        return this.zzyv;
    }

    public int hashCode() {
        return this.zzyv.hashCode();
    }

    @Override // com.google.android.gms.wearable.Node
    public boolean isNearby() {
        return this.zzbsZ;
    }

    public String toString() {
        return "Node{" + this.zzWQ + ", id=" + this.zzyv + ", hops=" + this.zzbsY + ", isNearby=" + this.zzbsZ + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags);
    }
}
