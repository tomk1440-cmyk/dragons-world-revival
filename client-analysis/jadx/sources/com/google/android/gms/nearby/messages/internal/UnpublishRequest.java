package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class UnpublishRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnpublishRequest> CREATOR = new zzt();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;

    @Deprecated
    public final boolean zzbbH;
    public final MessageWrapper zzbcT;

    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;

    UnpublishRequest(int versionCode, MessageWrapper messageWrapper, IBinder callbackAsBinder, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcT = messageWrapper;
        this.zzbcr = zze.zza.zzdz(callbackAsBinder);
        this.zzbbF = zeroPartyPackageName;
        this.zzbco = realClientPackageName;
        this.zzbbH = useRealClientApiKey;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    UnpublishRequest(MessageWrapper messageWrapper, IBinder callbackAsBinder, ClientAppContext clientAppContext) {
        this(1, messageWrapper, callbackAsBinder, null, null, false, clientAppContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzt.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }
}
