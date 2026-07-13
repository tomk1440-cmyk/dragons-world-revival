package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int mVersionCode;
    private final Long zzaKO;
    private final Uri zzaKQ;
    private final Long zzaKR;
    private BitmapTeleporter zzaKS;
    private final String zzaxl;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this.mVersionCode = versionCode;
        this.zzaxl = description;
        this.zzaKR = playedTimeMillis;
        this.zzaKS = coverImage;
        this.zzaKQ = coverImageUri;
        this.zzaKO = progressValue;
        if (this.zzaKS != null) {
            zzx.zza(this.zzaKQ == null, "Cannot set both a URI and an image");
        } else if (this.zzaKQ != null) {
            zzx.zza(this.zzaKS == null, "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this(5, description, playedTimeMillis, coverImage, coverImageUri, progressValue);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public Bitmap getCoverImage() {
        if (this.zzaKS == null) {
            return null;
        }
        return this.zzaKS.zzqa();
    }

    public Uri getCoverImageUri() {
        return this.zzaKQ;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public Long getPlayedTimeMillis() {
        return this.zzaKR;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public Long getProgressValue() {
        return this.zzaKO;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotMetadataChange
    public BitmapTeleporter zzxU() {
        return this.zzaKS;
    }
}
