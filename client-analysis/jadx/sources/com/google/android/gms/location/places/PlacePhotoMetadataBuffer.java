package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzq;

/* JADX INFO: loaded from: classes.dex */
public class PlacePhotoMetadataBuffer extends AbstractDataBuffer<PlacePhotoMetadata> {
    public PlacePhotoMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlacePhotoMetadata get(int position) {
        return new zzq(this.zzahi, position);
    }
}
