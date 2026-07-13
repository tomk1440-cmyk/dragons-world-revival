package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class ReceiveContentRequest implements SafeParcelable {
    public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzbdk;
    public zzc zzbdo;
    public zza zzbdp;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzbdk = clientBinder;
        this.zzbdp = zza.AbstractBinderC0260zza.zzdF(contentReceiverAsBinder);
        this.packageName = packageName;
        this.zzbdo = zzc.zza.zzdH(callbackAsBinder);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbdo.asBinder();
    }

    IBinder zzEQ() {
        if (this.zzbdp == null) {
            return null;
        }
        return this.zzbdp.asBinder();
    }
}
