package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public class AncsNotificationParcelable implements SafeParcelable, com.google.android.gms.wearable.zzd {
    public static final Parcelable.Creator<AncsNotificationParcelable> CREATOR = new zzh();
    private int mId;
    final int mVersionCode;
    private String zzTJ;
    private String zzWQ;
    private final String zzaDH;
    private final String zzaUa;
    private final String zzaaH;
    private final String zzapg;
    private final String zzbrH;
    private byte zzbrI;
    private byte zzbrJ;
    private byte zzbrK;
    private byte zzbrL;

    AncsNotificationParcelable(int versionCode, int id, String appId, String dateTime, String notificationText, String title, String subtitle, String displayName, byte eventId, byte eventFlags, byte categoryId, byte categoryCount, String packageName) {
        this.mId = id;
        this.mVersionCode = versionCode;
        this.zzaUa = appId;
        this.zzbrH = dateTime;
        this.zzaaH = notificationText;
        this.zzapg = title;
        this.zzaDH = subtitle;
        this.zzWQ = displayName;
        this.zzbrI = eventId;
        this.zzbrJ = eventFlags;
        this.zzbrK = categoryId;
        this.zzbrL = categoryCount;
        this.zzTJ = packageName;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) o;
        if (this.zzbrL == ancsNotificationParcelable.zzbrL && this.zzbrK == ancsNotificationParcelable.zzbrK && this.zzbrJ == ancsNotificationParcelable.zzbrJ && this.zzbrI == ancsNotificationParcelable.zzbrI && this.mId == ancsNotificationParcelable.mId && this.mVersionCode == ancsNotificationParcelable.mVersionCode && this.zzaUa.equals(ancsNotificationParcelable.zzaUa)) {
            if (this.zzbrH == null ? ancsNotificationParcelable.zzbrH != null : !this.zzbrH.equals(ancsNotificationParcelable.zzbrH)) {
                return false;
            }
            return this.zzWQ.equals(ancsNotificationParcelable.zzWQ) && this.zzaaH.equals(ancsNotificationParcelable.zzaaH) && this.zzaDH.equals(ancsNotificationParcelable.zzaDH) && this.zzapg.equals(ancsNotificationParcelable.zzapg);
        }
        return false;
    }

    public String getDisplayName() {
        return this.zzWQ == null ? this.zzaUa : this.zzWQ;
    }

    public int getId() {
        return this.mId;
    }

    public String getPackageName() {
        return this.zzTJ;
    }

    public String getTitle() {
        return this.zzapg;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzbrH != null ? this.zzbrH.hashCode() : 0) + (((((this.mVersionCode * 31) + this.mId) * 31) + this.zzaUa.hashCode()) * 31)) * 31) + this.zzaaH.hashCode()) * 31) + this.zzapg.hashCode()) * 31) + this.zzaDH.hashCode()) * 31) + this.zzWQ.hashCode()) * 31) + this.zzbrI) * 31) + this.zzbrJ) * 31) + this.zzbrK) * 31) + this.zzbrL;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.mVersionCode + ", mId=" + this.mId + ", mAppId='" + this.zzaUa + "', mDateTime='" + this.zzbrH + "', mNotificationText='" + this.zzaaH + "', mTitle='" + this.zzapg + "', mSubtitle='" + this.zzaDH + "', mDisplayName='" + this.zzWQ + "', mEventId=" + ((int) this.zzbrI) + ", mEventFlags=" + ((int) this.zzbrJ) + ", mCategoryId=" + ((int) this.zzbrK) + ", mCategoryCount=" + ((int) this.zzbrL) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public String zzIB() {
        return this.zzbrH;
    }

    public String zzIC() {
        return this.zzaaH;
    }

    public byte zzID() {
        return this.zzbrI;
    }

    public byte zzIE() {
        return this.zzbrJ;
    }

    public byte zzIF() {
        return this.zzbrK;
    }

    public byte zzIG() {
        return this.zzbrL;
    }

    public String zzwK() {
        return this.zzaUa;
    }

    public String zzwc() {
        return this.zzaDH;
    }
}
