package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes.dex */
public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
    final int mVersionCode;
    final String zzaoV;
    final boolean zzaoW;
    final boolean zzapa;
    final DriveId zzaqj;
    final MetadataBundle zzaqk;
    final Contents zzaql;
    final int zzaqm;
    final int zzaqn;
    final boolean zzaqo;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean notifyOnCompletion, String trackingTag, int commitStrategy, int contentsRequestId, boolean isContentsValidForConflictDetection, boolean mustCreateNewRevision) {
        this.mVersionCode = versionCode;
        this.zzaqj = id;
        this.zzaqk = metadataChangeSet;
        this.zzaql = contentsReference;
        this.zzaoW = notifyOnCompletion;
        this.zzaoV = trackingTag;
        this.zzaqm = commitStrategy;
        this.zzaqn = contentsRequestId;
        this.zzaqo = isContentsValidForConflictDetection;
        this.zzapa = mustCreateNewRevision;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, int contentsRequestId, boolean isContentsValidForConflictDetection, com.google.android.gms.drive.zzi fileUpdateOptions) {
        this(1, id, metadataChangeSet, null, fileUpdateOptions.zzsC(), fileUpdateOptions.zzsB(), fileUpdateOptions.zzsD(), contentsRequestId, isContentsValidForConflictDetection, fileUpdateOptions.zzsI());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
