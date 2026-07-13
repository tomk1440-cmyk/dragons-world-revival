package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzsu;

/* JADX INFO: loaded from: classes.dex */
public class ChangeSequenceNumber implements SafeParcelable {
    public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int mVersionCode;
    final long zzaot;
    final long zzaou;
    final long zzaov;
    private volatile String zzaow = null;

    ChangeSequenceNumber(int versionCode, long sequenceNumber, long databaseInstanceId, long accountId) {
        zzx.zzac(sequenceNumber != -1);
        zzx.zzac(databaseInstanceId != -1);
        zzx.zzac(accountId != -1);
        this.mVersionCode = versionCode;
        this.zzaot = sequenceNumber;
        this.zzaou = databaseInstanceId;
        this.zzaov = accountId;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzaow == null) {
            this.zzaow = "ChangeSequenceNumber:" + Base64.encodeToString(zzsu(), 10);
        }
        return this.zzaow;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzaou == this.zzaou && changeSequenceNumber.zzaov == this.zzaov && changeSequenceNumber.zzaot == this.zzaot;
    }

    public int hashCode() {
        return (String.valueOf(this.zzaot) + String.valueOf(this.zzaou) + String.valueOf(this.zzaov)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    final byte[] zzsu() {
        zzas zzasVar = new zzas();
        zzasVar.versionCode = this.mVersionCode;
        zzasVar.zzarV = this.zzaot;
        zzasVar.zzarW = this.zzaou;
        zzasVar.zzarX = this.zzaov;
        return zzsu.toByteArray(zzasVar);
    }
}
