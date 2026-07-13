package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class SaveRequest implements SafeParcelable {
    public static final Parcelable.Creator<SaveRequest> CREATOR = new zzk();
    final int mVersionCode;
    private final Credential zzWu;

    SaveRequest(int version, Credential credential) {
        this.mVersionCode = version;
        this.zzWu = credential;
    }

    public SaveRequest(Credential credential) {
        this(1, credential);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Credential getCredential() {
        return this.zzWu;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }
}
