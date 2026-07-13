package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public class JoinOptions implements SafeParcelable {
    public static final Parcelable.Creator<JoinOptions> CREATOR = new zzc();
    private final int mVersionCode;
    private int zzaaJ;

    public JoinOptions() {
        this(1, 0);
    }

    JoinOptions(int versionCode, int connectionType) {
        this.mVersionCode = versionCode;
        this.zzaaJ = connectionType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof JoinOptions) && this.zzaaJ == ((JoinOptions) obj).zzaaJ;
    }

    public int getConnectionType() {
        return this.zzaaJ;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaaJ));
    }

    public String toString() {
        String str;
        switch (this.zzaaJ) {
            case 0:
                str = "STRONG";
                break;
            case 1:
            default:
                str = "UNKNOWN";
                break;
            case 2:
                str = "INVISIBLE";
                break;
        }
        return String.format("joinOptions(connectionType=%s)", str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzc.zza(this, out, flags);
    }
}
