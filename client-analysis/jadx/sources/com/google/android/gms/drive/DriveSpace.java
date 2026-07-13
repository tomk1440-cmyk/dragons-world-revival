package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmr;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class DriveSpace implements SafeParcelable {
    public static final Parcelable.Creator<DriveSpace> CREATOR = new zzg();
    public static final DriveSpace zzaoP = new DriveSpace("DRIVE");
    public static final DriveSpace zzaoQ = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzaoR = new DriveSpace(ShareConstants.PHOTOS);
    public static final Set<DriveSpace> zzaoS = zzmr.zza(zzaoP, zzaoQ, zzaoR);
    public static final String zzaoT = TextUtils.join(",", zzaoS.toArray());
    private static final Pattern zzaoU = Pattern.compile("[A-Z0-9_]*");
    private final String mName;
    final int mVersionCode;

    DriveSpace(int versionCode, String name) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzz(name);
    }

    private DriveSpace(String name) {
        this(1, name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != DriveSpace.class) {
            return false;
        }
        return this.mName.equals(((DriveSpace) o).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
