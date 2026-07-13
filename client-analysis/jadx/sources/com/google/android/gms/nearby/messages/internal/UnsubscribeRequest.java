package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class UnsubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzu();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;

    @Deprecated
    public final boolean zzbbH;
    public final zzd zzbcY;

    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;
    public final PendingIntent zzbda;
    public final int zzbdb;

    UnsubscribeRequest(int versionCode, IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, boolean useRealClientApiKey, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcY = zzd.zza.zzdy(messageListener);
        this.zzbcr = zze.zza.zzdz(callbackAsBinder);
        this.zzbda = pendingIntent;
        this.zzbdb = messageListenerKey;
        this.zzbbF = zeroPartyPackageName;
        this.zzbco = realClientPackageName;
        this.zzbbH = useRealClientApiKey;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    UnsubscribeRequest(IBinder messageListener, IBinder callbackAsBinder, PendingIntent pendingIntent, int messageListenerKey, ClientAppContext clientAppContext) {
        this(1, messageListener, callbackAsBinder, pendingIntent, messageListenerKey, null, null, false, clientAppContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzu.zza(this, dest, flags);
    }

    IBinder zzED() {
        return this.zzbcr.asBinder();
    }

    IBinder zzEH() {
        if (this.zzbcY == null) {
            return null;
        }
        return this.zzbcY.asBinder();
    }
}
