package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzow;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class SessionStartRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStartRequest> CREATOR = new zzaa();
    private final int mVersionCode;
    private final zzow zzaAD;
    private final Session zzavX;

    SessionStartRequest(int versionCode, Session session, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzavX = session;
        this.zzaAD = zzow.zza.zzbR(callback);
    }

    public SessionStartRequest(Session session, zzow callback) {
        com.google.android.gms.common.internal.zzx.zzb(session.getStartTime(TimeUnit.MILLISECONDS) < System.currentTimeMillis(), "Cannot start a session in the future");
        com.google.android.gms.common.internal.zzx.zzb(session.isOngoing(), "Cannot start a session which has already ended");
        this.mVersionCode = 3;
        this.zzavX = session;
        this.zzaAD = callback;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.zzavX, sessionStartRequest.zzavX);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStartRequest) && zzb((SessionStartRequest) o));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaAD == null) {
            return null;
        }
        return this.zzaAD.asBinder();
    }

    public Session getSession() {
        return this.zzavX;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.zzavX);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg(SettingsJsonConstants.SESSION_KEY, this.zzavX).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzaa.zza(this, dest, flags);
    }
}
