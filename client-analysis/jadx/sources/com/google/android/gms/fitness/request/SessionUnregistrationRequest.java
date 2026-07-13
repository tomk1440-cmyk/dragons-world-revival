package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

/* JADX INFO: loaded from: classes.dex */
public class SessionUnregistrationRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionUnregistrationRequest> CREATOR = new zzac();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzow zzaAD;

    SessionUnregistrationRequest(int versionCode, PendingIntent intent, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mPendingIntent = intent;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public SessionUnregistrationRequest(PendingIntent pendingIntent, zzow callback) {
        this.mVersionCode = 5;
        this.mPendingIntent = pendingIntent;
        this.zzaAD = callback;
    }

    private boolean zzb(SessionUnregistrationRequest sessionUnregistrationRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mPendingIntent, sessionUnregistrationRequest.mPendingIntent);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionUnregistrationRequest) && zzb((SessionUnregistrationRequest) that));
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

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mPendingIntent);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("pendingIntent", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzac.zza(this, parcel, flags);
    }
}
