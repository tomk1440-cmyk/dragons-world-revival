package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class HandleClientLifecycleEventRequest implements SafeParcelable {
    public static final Parcelable.Creator<HandleClientLifecycleEventRequest> CREATOR = new zzc();
    public final int versionCode;
    public final ClientAppContext zzbcs;
    public final int zzbct;

    HandleClientLifecycleEventRequest(int versionCode, ClientAppContext clientAppContext, int clientLifecycleEvent) {
        this.versionCode = versionCode;
        this.zzbcs = clientAppContext;
        this.zzbct = clientLifecycleEvent;
    }

    public HandleClientLifecycleEventRequest(ClientAppContext clientAppContext, int clientLifecycleEvent) {
        this(1, clientAppContext, clientLifecycleEvent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
