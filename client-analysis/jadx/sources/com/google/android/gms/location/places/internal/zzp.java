package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;

/* JADX INFO: loaded from: classes.dex */
public class zzp implements PlacePhotoMetadata {
    private int mIndex;
    private final int zzDF;
    private final int zzDG;
    private final String zzaQR;
    private final CharSequence zzaQS;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaQR = str;
        this.zzDF = i;
        this.zzDG = i2;
        this.zzaQS = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzp)) {
            return false;
        }
        zzp zzpVar = (zzp) other;
        return zzpVar.zzDF == this.zzDF && zzpVar.zzDG == this.zzDG && zzw.equal(zzpVar.zzaQR, this.zzaQR) && zzw.equal(zzpVar.zzaQS, this.zzaQS);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public CharSequence getAttributions() {
        return this.zzaQS;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxHeight() {
        return this.zzDG;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxWidth() {
        return this.zzDF;
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, final int width, final int height) {
        return client.zza(new com.google.android.gms.location.places.zzf.zza<zze>(Places.zzaPN, client) { // from class: com.google.android.gms.location.places.internal.zzp.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zze zzeVar) throws RemoteException {
                zzeVar.zza(new com.google.android.gms.location.places.zzf(this), zzp.this.zzaQR, width, height, zzp.this.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzDF), Integer.valueOf(this.zzDG), this.zzaQR, this.zzaQS);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzzz, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata freeze() {
        return this;
    }
}
