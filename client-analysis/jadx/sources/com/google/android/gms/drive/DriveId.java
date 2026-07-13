package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;

/* JADX INFO: loaded from: classes.dex */
public class DriveId implements SafeParcelable {
    public static final Parcelable.Creator<DriveId> CREATOR = new zze();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzaoL;
    final long zzaoM;
    final int zzaoN;
    private volatile String zzaoO;
    final long zzaou;
    private volatile String zzaow;

    DriveId(int versionCode, String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this.zzaow = null;
        this.zzaoO = null;
        this.mVersionCode = versionCode;
        this.zzaoL = resourceId;
        zzx.zzac(!"".equals(resourceId));
        zzx.zzac((resourceId == null && sqlId == -1) ? false : true);
        this.zzaoM = sqlId;
        this.zzaou = databaseInstanceId;
        this.zzaoN = resourceType;
    }

    public DriveId(String resourceId, long sqlId, long databaseInstanceId, int resourceType) {
        this(1, resourceId, sqlId, databaseInstanceId, resourceType);
    }

    public static DriveId decodeFromString(String s) {
        zzx.zzb(s.startsWith("DriveId:"), "Invalid DriveId: " + s);
        return zzl(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcW(String str) {
        zzx.zzz(str);
        return new DriveId(str, -1L, -1L, -1);
    }

    static DriveId zzl(byte[] bArr) {
        try {
            zzat zzatVarZzm = zzat.zzm(bArr);
            return new DriveId(zzatVarZzm.versionCode, "".equals(zzatVarZzm.zzarY) ? null : zzatVarZzm.zzarY, zzatVarZzm.zzarZ, zzatVarZzm.zzarW, zzatVarZzm.zzasa);
        } catch (zzst e) {
            throw new IllegalArgumentException();
        }
    }

    private byte[] zzsA() {
        zzau zzauVar = new zzau();
        zzauVar.zzarZ = this.zzaoM;
        zzauVar.zzarW = this.zzaou;
        return zzsu.toByteArray(zzauVar);
    }

    public DriveFile asDriveFile() {
        if (this.zzaoN == 1) {
            throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
        }
        return new zzw(this);
    }

    public DriveFolder asDriveFolder() {
        if (this.zzaoN == 0) {
            throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
        }
        return new zzy(this);
    }

    public DriveResource asDriveResource() {
        if (this.zzaoN == 1) {
            return asDriveFolder();
        }
        return this.zzaoN == 0 ? asDriveFile() : new zzab(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzaow == null) {
            this.zzaow = "DriveId:" + Base64.encodeToString(zzsu(), 10);
        }
        return this.zzaow;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DriveId)) {
            return false;
        }
        DriveId driveId = (DriveId) obj;
        if (driveId.zzaou != this.zzaou) {
            return false;
        }
        if (driveId.zzaoM == -1 && this.zzaoM == -1) {
            return driveId.zzaoL.equals(this.zzaoL);
        }
        if (this.zzaoL == null || driveId.zzaoL == null) {
            return driveId.zzaoM == this.zzaoM;
        }
        if (driveId.zzaoM != this.zzaoM) {
            return false;
        }
        if (driveId.zzaoL.equals(this.zzaoL)) {
            return true;
        }
        zzz.zzz("DriveId", "Unexpected unequal resourceId for same DriveId object.");
        return false;
    }

    public String getResourceId() {
        return this.zzaoL;
    }

    public int getResourceType() {
        return this.zzaoN;
    }

    public int hashCode() {
        return this.zzaoM == -1 ? this.zzaoL.hashCode() : (String.valueOf(this.zzaou) + String.valueOf(this.zzaoM)).hashCode();
    }

    public final String toInvariantString() {
        if (this.zzaoO == null) {
            this.zzaoO = Base64.encodeToString(zzsA(), 10);
        }
        return this.zzaoO;
    }

    public String toString() {
        return encodeToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }

    final byte[] zzsu() {
        zzat zzatVar = new zzat();
        zzatVar.versionCode = this.mVersionCode;
        zzatVar.zzarY = this.zzaoL == null ? "" : this.zzaoL;
        zzatVar.zzarZ = this.zzaoM;
        zzatVar.zzarW = this.zzaou;
        zzatVar.zzasa = this.zzaoN;
        return zzsu.toByteArray(zzatVar);
    }
}
