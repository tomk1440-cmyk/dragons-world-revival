package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class Operator implements SafeParcelable {
    final String mTag;
    final int mVersionCode;
    public static final Parcelable.Creator<Operator> CREATOR = new zzn();
    public static final Operator zzaux = new Operator("=");
    public static final Operator zzauy = new Operator("<");
    public static final Operator zzauz = new Operator("<=");
    public static final Operator zzauA = new Operator(">");
    public static final Operator zzauB = new Operator(">=");
    public static final Operator zzauC = new Operator("and");
    public static final Operator zzauD = new Operator("or");
    public static final Operator zzauE = new Operator("not");
    public static final Operator zzauF = new Operator("contains");

    Operator(int versionCode, String tag) {
        this.mVersionCode = versionCode;
        this.mTag = tag;
    }

    private Operator(String tag) {
        this(1, tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Operator operator = (Operator) obj;
            if (this.mTag == null) {
                return operator.mTag == null;
            }
            return this.mTag.equals(operator.mTag);
        }
        return false;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzn.zza(this, out, flags);
    }
}
