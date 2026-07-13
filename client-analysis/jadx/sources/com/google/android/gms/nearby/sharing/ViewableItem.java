package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewableItem implements SafeParcelable {
    public static final Parcelable.Creator<ViewableItem> CREATOR = new zzf();
    private final int versionCode;
    private String[] zzbdj;

    private ViewableItem() {
        this.versionCode = 1;
    }

    ViewableItem(int versionCode, String[] uris) {
        this.versionCode = versionCode;
        this.zzbdj = uris;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof ViewableItem) {
            return zzw.equal(this.zzbdj, ((ViewableItem) o).zzbdj);
        }
        return false;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbdj);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.zzbdj) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String[] zzEN() {
        return this.zzbdj;
    }
}
