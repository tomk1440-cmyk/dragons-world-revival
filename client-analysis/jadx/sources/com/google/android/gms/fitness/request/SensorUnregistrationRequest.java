package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* JADX INFO: loaded from: classes.dex */
public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SensorUnregistrationRequest> CREATOR = new zzw();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;
    private final com.google.android.gms.fitness.data.zzk zzaBh;

    SensorUnregistrationRequest(int versionCode, IBinder listenerBinder, PendingIntent pendingIntent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaBh = listenerBinder == null ? null : com.google.android.gms.fitness.data.zzk.zza.zzbt(listenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public SensorUnregistrationRequest(com.google.android.gms.fitness.data.zzk listener, PendingIntent pendingIntent, zzow callback) {
        this.mVersionCode = 4;
        this.zzaBh = listener;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = callback;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public PendingIntent getIntent() {
        return this.mPendingIntent;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("SensorUnregistrationRequest{%s}", this.zzaBh);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzw.zza(this, parcel, flags);
    }

    IBinder zzvb() {
        if (this.zzaBh == null) {
            return null;
        }
        return this.zzaBh.asBinder();
    }
}
