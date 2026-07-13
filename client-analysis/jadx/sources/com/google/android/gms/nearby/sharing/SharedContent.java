package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SharedContent implements SafeParcelable {
    public static final Parcelable.Creator<SharedContent> CREATOR = new zzc();
    private final int versionCode;

    @Deprecated
    private String zzbdg;
    private ViewableItem[] zzbdh;
    private LocalContent[] zzbdi;

    private SharedContent() {
        this.versionCode = 2;
    }

    SharedContent(int versionCode, String uri, ViewableItem[] viewableItems, LocalContent[] localContents) {
        this.versionCode = versionCode;
        this.zzbdg = uri;
        this.zzbdh = viewableItems;
        this.zzbdi = localContents;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) o;
        return zzw.equal(this.zzbdh, sharedContent.zzbdh) && zzw.equal(this.zzbdi, sharedContent.zzbdi) && zzw.equal(this.zzbdg, sharedContent.zzbdg);
    }

    public String getUri() {
        return this.zzbdg;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzbdh, this.zzbdi, this.zzbdg);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.zzbdh) + ", localContents=" + Arrays.toString(this.zzbdi) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public ViewableItem[] zzEL() {
        return this.zzbdh;
    }

    public LocalContent[] zzEM() {
        return this.zzbdi;
    }
}
