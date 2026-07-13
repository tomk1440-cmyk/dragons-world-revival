package com.google.android.gms.location.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private final String zzEY;
    private final int zzaNC;
    private final short zzaNE;
    private final double zzaNF;
    private final double zzaNG;
    private final float zzaNH;
    private final int zzaNI;
    private final int zzaNJ;
    private final long zzaOZ;

    public ParcelableGeofence(int version, String requestId, int transitionTypes, short type, double latitude, double longitude, float radius, long expireAt, int notificationResponsiveness, int loiteringDelayMillis) {
        zzek(requestId);
        zze(radius);
        zza(latitude, longitude);
        int transitionTypes2 = zzhF(transitionTypes);
        this.mVersionCode = version;
        this.zzaNE = type;
        this.zzEY = requestId;
        this.zzaNF = latitude;
        this.zzaNG = longitude;
        this.zzaNH = radius;
        this.zzaOZ = expireAt;
        this.zzaNC = transitionTypes2;
        this.zzaNI = notificationResponsiveness;
        this.zzaNJ = loiteringDelayMillis;
    }

    public ParcelableGeofence(String requestId, int transitionTypes, short type, double latitude, double longitude, float radius, long expireAt, int notificationResponsiveness, int loiteringDelayMillis) {
        this(1, requestId, transitionTypes, type, latitude, longitude, radius, expireAt, notificationResponsiveness, loiteringDelayMillis);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        }
        if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void zze(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static void zzek(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static int zzhF(int i) {
        int i2 = i & 7;
        if (i2 == 0) {
            throw new IllegalArgumentException("No supported transition specified: " + i);
        }
        return i2;
    }

    @SuppressLint({"DefaultLocale"})
    private static String zzhG(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static ParcelableGeofence zzo(byte[] bArr) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        ParcelableGeofence parcelableGeofenceCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return parcelableGeofenceCreateFromParcel;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzo zzoVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ParcelableGeofence)) {
            ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
            return this.zzaNH == parcelableGeofence.zzaNH && this.zzaNF == parcelableGeofence.zzaNF && this.zzaNG == parcelableGeofence.zzaNG && this.zzaNE == parcelableGeofence.zzaNE;
        }
        return false;
    }

    public long getExpirationTime() {
        return this.zzaOZ;
    }

    public double getLatitude() {
        return this.zzaNF;
    }

    public double getLongitude() {
        return this.zzaNG;
    }

    public int getNotificationResponsiveness() {
        return this.zzaNI;
    }

    @Override // com.google.android.gms.location.Geofence
    public String getRequestId() {
        return this.zzEY;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.zzaNF);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.zzaNG);
        return (((((((i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaNH)) * 31) + this.zzaNE) * 31) + this.zzaNC;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", zzhG(this.zzaNE), this.zzEY, Integer.valueOf(this.zzaNC), Double.valueOf(this.zzaNF), Double.valueOf(this.zzaNG), Float.valueOf(this.zzaNH), Integer.valueOf(this.zzaNI / 1000), Integer.valueOf(this.zzaNJ), Long.valueOf(this.zzaOZ));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        zzo zzoVar = CREATOR;
        zzo.zza(this, parcel, flags);
    }

    public short zzyT() {
        return this.zzaNE;
    }

    public float zzyU() {
        return this.zzaNH;
    }

    public int zzyV() {
        return this.zzaNC;
    }

    public int zzyW() {
        return this.zzaNJ;
    }
}
