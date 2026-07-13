package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

/* JADX INFO: loaded from: classes.dex */
public class zzq extends zzt implements PlacePhotoMetadata {
    private final String zzaQR;

    public zzq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
        this.zzaQR = getString("photo_fife_url");
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public CharSequence getAttributions() {
        return zzG("photo_attributions", null);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxHeight() {
        return zzz("photo_max_height", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public int getMaxWidth() {
        return zzz("photo_max_width", 0);
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    @Override // com.google.android.gms.location.places.PlacePhotoMetadata
    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        return freeze().getScaledPhoto(client, width, height);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzzz, reason: merged with bridge method [inline-methods] */
    public PlacePhotoMetadata freeze() {
        return new zzp(this.zzaQR, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzaje);
    }
}
