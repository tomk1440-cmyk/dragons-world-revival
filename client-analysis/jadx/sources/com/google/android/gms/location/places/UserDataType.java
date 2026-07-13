package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmr;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class UserDataType implements SafeParcelable {
    final int mVersionCode;
    final String zzJN;
    final int zzaQb;
    public static final UserDataType zzaPX = zzy("test_type", 1);
    public static final UserDataType zzaPY = zzy("labeled_place", 6);
    public static final UserDataType zzaPZ = zzy("here_content", 7);
    public static final Set<UserDataType> zzaQa = zzmr.zza(zzaPX, zzaPY, zzaPZ);
    public static final zzm CREATOR = new zzm();

    UserDataType(int versionCode, String type, int enumValue) {
        zzx.zzcM(type);
        this.mVersionCode = versionCode;
        this.zzJN = type;
        this.zzaQb = enumValue;
    }

    private static UserDataType zzy(String str, int i) {
        return new UserDataType(0, str, i);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UserDataType)) {
            return false;
        }
        UserDataType userDataType = (UserDataType) object;
        return this.zzJN.equals(userDataType.zzJN) && this.zzaQb == userDataType.zzaQb;
    }

    public int hashCode() {
        return this.zzJN.hashCode();
    }

    public String toString() {
        return this.zzJN;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }
}
