package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class ClientAppContext implements SafeParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zza();
    final int versionCode;
    public final boolean zzbbH;
    public final String zzbco;
    public final String zzbcp;
    public final int zzbcq;

    ClientAppContext(int versionCode, String realClientPackageName, String zeroPartyIdentifier, boolean useRealClientApiKey, int callingContext) {
        this.versionCode = versionCode;
        this.zzbco = realClientPackageName;
        this.zzbcp = zeroPartyIdentifier;
        this.zzbbH = useRealClientApiKey;
        this.zzbcq = callingContext;
    }

    public ClientAppContext(String realClientPackageName, String zeroPartyIdentifier) {
        this(realClientPackageName, zeroPartyIdentifier, false);
    }

    public ClientAppContext(String realClientPackageName, String zeroPartyIdentifier, boolean useRealClientApiKey) {
        this(realClientPackageName, zeroPartyIdentifier, useRealClientApiKey, 0);
    }

    public ClientAppContext(String realClientPackageName, String zeroPartyIdentifier, boolean useRealClientApiKey, int callingContext) {
        this(1, realClientPackageName, zeroPartyIdentifier, useRealClientApiKey, callingContext);
    }

    private static boolean zzT(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) other;
        return zzT(this.zzbco, clientAppContext.zzbco) && zzT(this.zzbcp, clientAppContext.zzbcp) && this.zzbbH == clientAppContext.zzbbH && this.zzbcq == clientAppContext.zzbcq;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbco, this.zzbcp, Boolean.valueOf(this.zzbbH), Integer.valueOf(this.zzbcq));
    }

    public String toString() {
        return String.format("{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, callingContext: %d}", this.zzbco, this.zzbcp, Boolean.valueOf(this.zzbbH), Integer.valueOf(this.zzbcq));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
