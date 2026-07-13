package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Parcelable.Creator<CapabilityInfoParcelable> CREATOR = new zzk();
    private final String mName;
    final int mVersionCode;
    private final List<NodeParcelable> zzbrV;
    private final Object zzpV = new Object();
    private Set<Node> zzbrS = null;

    CapabilityInfoParcelable(int versionCode, String name, List<NodeParcelable> nodeList) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzbrV = nodeList;
        zzIH();
    }

    private void zzIH() {
        com.google.android.gms.common.internal.zzx.zzz(this.mName);
        com.google.android.gms.common.internal.zzx.zzz(this.zzbrV);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) o;
        if (this.mVersionCode != capabilityInfoParcelable.mVersionCode) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.zzbrV != null) {
            if (this.zzbrV.equals(capabilityInfoParcelable.zzbrV)) {
                return true;
            }
        } else if (capabilityInfoParcelable.zzbrV == null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzpV) {
            if (this.zzbrS == null) {
                this.zzbrS = new HashSet(this.zzbrV);
            }
            set = this.zzbrS;
        }
        return set;
    }

    public int hashCode() {
        return (((this.mName != null ? this.mName.hashCode() : 0) + (this.mVersionCode * 31)) * 31) + (this.zzbrV != null ? this.zzbrV.hashCode() : 0);
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzbrV + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    public List<NodeParcelable> zzII() {
        return this.zzbrV;
    }
}
