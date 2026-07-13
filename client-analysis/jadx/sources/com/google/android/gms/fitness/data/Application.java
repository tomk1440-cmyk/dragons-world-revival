package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class Application implements SafeParcelable {
    private final int mVersionCode;
    private final String zzTJ;
    private final String zzadc;
    private final String zzawb;
    public static final Application zzawa = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
    public static final Parcelable.Creator<Application> CREATOR = new zza();

    Application(int versionCode, String packageName, String version, String domainName) {
        this.mVersionCode = versionCode;
        this.zzTJ = (String) zzx.zzz(packageName);
        this.zzadc = "";
        this.zzawb = domainName;
    }

    public Application(String packageName, String version, String domainName) {
        this(1, packageName, "", domainName);
    }

    private boolean zza(Application application) {
        return this.zzTJ.equals(application.zzTJ) && zzw.equal(this.zzadc, application.zzadc) && zzw.equal(this.zzawb, application.zzawb);
    }

    public static Application zzdn(String str) {
        return zzg(str, null, null);
    }

    public static Application zzg(String str, String str2, String str3) {
        return "com.google.android.gms".equals(str) ? zzawa : new Application(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Application) && zza((Application) that));
    }

    public String getPackageName() {
        return this.zzTJ;
    }

    public String getVersion() {
        return this.zzadc;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTJ, this.zzadc, this.zzawb);
    }

    public String toString() {
        return String.format("Application{%s:%s:%s}", this.zzTJ, this.zzadc, this.zzawb);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public String zzua() {
        return this.zzawb;
    }
}
