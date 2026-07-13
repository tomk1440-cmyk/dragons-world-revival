package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class PlaceReport implements SafeParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaPH;
    private final String zzaPI;

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.mVersionCode = versionCode;
        this.zzaPH = placeId;
        this.mTag = tag;
        this.zzaPI = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzk(placeId, tag, "unknown");
    }

    private static boolean zzel(String str) {
        switch (str) {
            case "unknown":
            case "userReported":
            case "inferredGeofencing":
            case "inferredRadioSignals":
            case "inferredReverseGeocoding":
            case "inferredSnappedToRoad":
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzx.zzz(str);
        zzx.zzcM(str2);
        zzx.zzcM(str3);
        zzx.zzb(zzel(str3), "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzw.equal(this.zzaPH, placeReport.zzaPH) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaPI, placeReport.zzaPI);
    }

    public String getPlaceId() {
        return this.zzaPH;
    }

    public String getSource() {
        return this.zzaPI;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaPH, this.mTag, this.zzaPI);
    }

    public String toString() {
        zzw.zza zzaVarZzy = zzw.zzy(this);
        zzaVarZzy.zzg("placeId", this.zzaPH);
        zzaVarZzy.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzaPI)) {
            zzaVarZzy.zzg(ShareConstants.FEED_SOURCE_PARAM, this.zzaPI);
        }
        return zzaVarZzy.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
