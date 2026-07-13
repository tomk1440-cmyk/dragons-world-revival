package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* JADX INFO: loaded from: classes.dex */
public final class SubscribeRequest implements SafeParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzs();
    final int mVersionCode;

    @Deprecated
    public final String zzbbF;
    public final boolean zzbbG;

    @Deprecated
    public final boolean zzbbH;
    public final Strategy zzbcU;
    public final zzd zzbcY;
    public final MessageFilter zzbcZ;

    @Deprecated
    public final String zzbco;
    public final zze zzbcr;
    public final ClientAppContext zzbcs;
    public final PendingIntent zzbda;
    public final int zzbdb;
    public final byte[] zzbdc;
    public final zzi zzbdd;

    SubscribeRequest(int versionCode, IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName, byte[] hint, boolean isIgnoreNearbyPermission, IBinder subscribeCallbackAsBinder, boolean useRealClientApiKey, ClientAppContext clientAppContext) {
        this.mVersionCode = versionCode;
        this.zzbcY = zzd.zza.zzdy(messageListener);
        this.zzbcU = strategy;
        this.zzbcr = zze.zza.zzdz(callbackAsBinder);
        this.zzbcZ = filter;
        this.zzbda = pendingIntent;
        this.zzbdb = messageListenerKey;
        this.zzbbF = zeroPartyPackageName;
        this.zzbco = realClientPackageName;
        this.zzbdc = hint;
        this.zzbbG = isIgnoreNearbyPermission;
        this.zzbdd = subscribeCallbackAsBinder == null ? null : zzi.zza.zzdD(subscribeCallbackAsBinder);
        this.zzbbH = useRealClientApiKey;
        this.zzbcs = clientAppContext == null ? new ClientAppContext(this.zzbco, this.zzbbF, this.zzbbH) : clientAppContext;
    }

    public SubscribeRequest(IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, byte[] hint, boolean isIgnoreNearbyPermission, IBinder subscribeCallbackAsBinder, ClientAppContext clientAppContext) {
        this(3, messageListener, strategy, callbackAsBinder, filter, pendingIntent, messageListenerKey, null, null, hint, isIgnoreNearbyPermission, subscribeCallbackAsBinder, false, clientAppContext);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzs.zza(this, dest, flags);
    }

    IBinder zzED() {
        if (this.zzbcr == null) {
            return null;
        }
        return this.zzbcr.asBinder();
    }

    IBinder zzEH() {
        if (this.zzbcY == null) {
            return null;
        }
        return this.zzbcY.asBinder();
    }

    IBinder zzEI() {
        if (this.zzbdd == null) {
            return null;
        }
        return this.zzbdd.asBinder();
    }
}
