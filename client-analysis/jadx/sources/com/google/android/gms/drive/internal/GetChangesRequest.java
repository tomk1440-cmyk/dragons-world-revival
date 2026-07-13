package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class GetChangesRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetChangesRequest> CREATOR = new zzah();
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final ChangeSequenceNumber zzarJ;
    final int zzarK;
    final boolean zzarL;

    private GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this.mVersionCode = versionCode;
        this.zzarJ = fromSequenceNumber;
        this.zzarK = maxResults;
        this.zzapB = spacesList;
        this.zzapC = spaces;
        this.zzarL = includeUnsubscribed;
    }

    GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList, boolean includeUnsubscribed) {
        this(versionCode, fromSequenceNumber, maxResults, spacesList, spacesList == null ? null : new HashSet(spacesList), includeUnsubscribed);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
