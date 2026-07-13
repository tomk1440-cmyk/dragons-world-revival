package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentAnnotationRef extends MultiDataBufferRef implements AppContentAnnotation {
    AppContentAnnotationRef(ArrayList<DataHolder> dataHolders, int dataRow) {
        super(dataHolders, 2, dataRow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentAnnotationEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getDescription() {
        return getString("annotation_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getId() {
        return getString("annotation_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getTitle() {
        return getString("annotation_title");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentAnnotationEntity.zza(this);
    }

    public String toString() {
        return AppContentAnnotationEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentAnnotationEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String zzvT() {
        return getString("annotation_image_default_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int zzvU() {
        return getInteger("annotation_image_height");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Uri zzvV() {
        return zzcA("annotation_image_uri");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Bundle zzvW() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "annotation_modifiers", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int zzvX() {
        return getInteger("annotation_image_width");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String zzvY() {
        return getString("annotation_layout_slot");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzvZ, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotation freeze() {
        return new AppContentAnnotationEntity(this);
    }
}
