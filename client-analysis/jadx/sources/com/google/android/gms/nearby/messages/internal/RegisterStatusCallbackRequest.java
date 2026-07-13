package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RegisterStatusCallbackRequest implements SafeParcelable {
    public static final Parcelable.Creator<RegisterStatusCallbackRequest> CREATOR = new zzr();
    final int versionCode;

    @Deprecated
    public String zzbbF;
    public final zzh zzbcW;
    public boolean zzbcX;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    RegisterStatusCallbackRequest(int versionCode, IBinder callbackAsBinder, IBinder statusCallbackAsBinder, boolean isRegister, String zeroPartyPackageName, ClientAppContext clientAppContext) {
        this.versionCode = versionCode;
        this.zzbcr = zze.zza.zzdz(callbackAsBinder);
        this.zzbcW = zzh.zza.zzdC(statusCallbackAsBinder);
        this.zzbcX = isRegister;
        this.zzbbF = zeroPartyPackageName;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(null, this.zzbbF) : clientAppContext;
    }

    RegisterStatusCallbackRequest(IBinder callbackAsBinder, IBinder statusCallbackAsBinder, ClientAppContext clientAppContext) {
        this(1, callbackAsBinder, statusCallbackAsBinder, false, null, clientAppContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    IBinder zzEG() {
        return this.zzbcW.asBinder();
    }
}
