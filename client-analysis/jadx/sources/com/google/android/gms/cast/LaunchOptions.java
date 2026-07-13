package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LaunchOptions implements SafeParcelable {
    public static final Parcelable.Creator<LaunchOptions> CREATOR = new zzd();
    private final int mVersionCode;
    private boolean zzaaK;
    private String zzaaL;

    public static final class Builder {
        private LaunchOptions zzaaM = new LaunchOptions();

        public LaunchOptions build() {
            return this.zzaaM;
        }

        public Builder setLocale(Locale locale) {
            this.zzaaM.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setRelaunchIfRunning(boolean relaunchIfRunning) {
            this.zzaaM.setRelaunchIfRunning(relaunchIfRunning);
            return this;
        }
    }

    public LaunchOptions() {
        this(1, false, zzf.zzb(Locale.getDefault()));
    }

    LaunchOptions(int versionCode, boolean relaunchIfRunning, String language) {
        this.mVersionCode = versionCode;
        this.zzaaK = relaunchIfRunning;
        this.zzaaL = language;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LaunchOptions)) {
            return false;
        }
        LaunchOptions launchOptions = (LaunchOptions) obj;
        return this.zzaaK == launchOptions.zzaaK && zzf.zza(this.zzaaL, launchOptions.zzaaL);
    }

    public String getLanguage() {
        return this.zzaaL;
    }

    public boolean getRelaunchIfRunning() {
        return this.zzaaK;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaaK), this.zzaaL);
    }

    public void setLanguage(String language) {
        this.zzaaL = language;
    }

    public void setRelaunchIfRunning(boolean relaunchIfRunning) {
        this.zzaaK = relaunchIfRunning;
    }

    public String toString() {
        return String.format("LaunchOptions(relaunchIfRunning=%b, language=%s)", Boolean.valueOf(this.zzaaK), this.zzaaL);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
