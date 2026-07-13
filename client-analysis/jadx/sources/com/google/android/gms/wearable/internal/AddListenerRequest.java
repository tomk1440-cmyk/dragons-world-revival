package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class AddListenerRequest implements SafeParcelable {
    public static final Parcelable.Creator<AddListenerRequest> CREATOR = new zzc();
    final int mVersionCode;
    public final zzaw zzbrB;
    public final IntentFilter[] zzbrC;
    public final String zzbrD;
    public final String zzbrE;

    AddListenerRequest(int versionCode, IBinder listener, IntentFilter[] filters, String channelToken, String capability) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzbrB = zzaw.zza.zzet(listener);
        } else {
            this.zzbrB = null;
        }
        this.zzbrC = filters;
        this.zzbrD = channelToken;
        this.zzbrE = capability;
    }

    public AddListenerRequest(zzbq stub) {
        this.mVersionCode = 1;
        this.zzbrB = stub;
        this.zzbrC = stub.zzIO();
        this.zzbrD = stub.zzIP();
        this.zzbrE = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    IBinder zzIy() {
        if (this.zzbrB == null) {
            return null;
        }
        return this.zzbrB.asBinder();
    }
}
