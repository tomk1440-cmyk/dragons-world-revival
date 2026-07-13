package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzov;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;

/* JADX INFO: loaded from: classes.dex */
public class SessionStopRequest implements SafeParcelable {
    public static final Parcelable.Creator<SessionStopRequest> CREATOR = new zzab();
    private final String mName;
    private final int mVersionCode;
    private final zzov zzaBz;
    private final String zzaxk;

    SessionStopRequest(int versionCode, String name, String identifier, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzaxk = identifier;
        this.zzaBz = zzov.zza.zzbQ(callback);
    }

    public SessionStopRequest(String name, String identifier, zzov callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzaxk = identifier;
        this.zzaBz = callback;
    }

    private boolean zzb(SessionStopRequest sessionStopRequest) {
        return com.google.android.gms.common.internal.zzw.equal(this.mName, sessionStopRequest.mName) && com.google.android.gms.common.internal.zzw.equal(this.zzaxk, sessionStopRequest.zzaxk);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStopRequest) && zzb((SessionStopRequest) o));
    }

    public IBinder getCallbackBinder() {
        if (this.zzaBz == null) {
            return null;
        }
        return this.zzaBz.asBinder();
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.zzw.hashCode(this.mName, this.zzaxk);
    }

    public String toString() {
        return com.google.android.gms.common.internal.zzw.zzy(this).zzg("name", this.mName).zzg(SettingsJsonConstants.APP_IDENTIFIER_KEY, this.zzaxk).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }
}
