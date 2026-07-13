package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoz;

/* JADX INFO: loaded from: classes.dex */
public final class Device implements SafeParcelable {
    public static final Parcelable.Creator<Device> CREATOR = new zzi();
    public static final int TYPE_CHEST_STRAP = 4;
    public static final int TYPE_PHONE = 1;
    public static final int TYPE_SCALE = 5;
    public static final int TYPE_TABLET = 2;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WATCH = 3;
    private final int mVersionCode;
    private final int zzabB;
    private final String zzadc;
    private final String zzawI;
    private final String zzawJ;
    private final String zzawK;
    private final int zzawL;

    Device(int versionCode, String manufacturer, String model, String version, String uid, int type, int platformType) {
        this.mVersionCode = versionCode;
        this.zzawI = (String) zzx.zzz(manufacturer);
        this.zzawJ = (String) zzx.zzz(model);
        this.zzadc = "";
        this.zzawK = (String) zzx.zzz(uid);
        this.zzabB = type;
        this.zzawL = platformType;
    }

    public Device(String manufacturer, String model, String uid, int type) {
        this(manufacturer, model, "", uid, type, 0);
    }

    public Device(String manufacturer, String model, String version, String uid, int type, int platformType) {
        this(1, manufacturer, model, "", uid, type, platformType);
    }

    public static Device getLocalDevice(Context context) {
        int iZzaG = zznv.zzaG(context);
        return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, zzaC(context), iZzaG, 2);
    }

    private boolean zza(Device device) {
        return zzw.equal(this.zzawI, device.zzawI) && zzw.equal(this.zzawJ, device.zzawJ) && zzw.equal(this.zzadc, device.zzadc) && zzw.equal(this.zzawK, device.zzawK) && this.zzabB == device.zzabB && this.zzawL == device.zzawL;
    }

    private static String zzaC(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private boolean zzus() {
        return zzur() == 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Device) && zza((Device) that));
    }

    public String getManufacturer() {
        return this.zzawI;
    }

    public String getModel() {
        return this.zzawJ;
    }

    String getStreamIdentifier() {
        return String.format("%s:%s:%s", this.zzawI, this.zzawJ, this.zzawK);
    }

    public int getType() {
        return this.zzabB;
    }

    public String getUid() {
        return this.zzawK;
    }

    public String getVersion() {
        return this.zzadc;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzawI, this.zzawJ, this.zzadc, this.zzawK, Integer.valueOf(this.zzabB));
    }

    public String toString() {
        return String.format("Device{%s:%s:%s:%s}", getStreamIdentifier(), this.zzadc, Integer.valueOf(this.zzabB), Integer.valueOf(this.zzawL));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzi.zza(this, parcel, flags);
    }

    public int zzur() {
        return this.zzawL;
    }

    public String zzut() {
        return zzus() ? this.zzawK : zzoz.zzdF(this.zzawK);
    }
}
