package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentAnnotationEntity implements SafeParcelable, AppContentAnnotation {
    public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
    private final int mVersionCode;
    private final String zzaDA;
    private final String zzaDB;
    private final int zzaDC;
    private final int zzaDD;
    private final Bundle zzaDE;
    private final Uri zzaDz;
    private final String zzapg;
    private final String zzaxl;
    private final String zzyv;

    AppContentAnnotationEntity(int versionCode, String description, Uri imageUri, String title, String id, String layoutSlot, String imageDefaultId, int imageHeight, int imageWidth, Bundle modifiers) {
        this.mVersionCode = versionCode;
        this.zzaxl = description;
        this.zzyv = id;
        this.zzaDB = imageDefaultId;
        this.zzaDC = imageHeight;
        this.zzaDz = imageUri;
        this.zzaDD = imageWidth;
        this.zzaDA = layoutSlot;
        this.zzaDE = modifiers;
        this.zzapg = title;
    }

    public AppContentAnnotationEntity(AppContentAnnotation annotation) {
        this.mVersionCode = 4;
        this.zzaxl = annotation.getDescription();
        this.zzyv = annotation.getId();
        this.zzaDB = annotation.zzvT();
        this.zzaDC = annotation.zzvU();
        this.zzaDz = annotation.zzvV();
        this.zzaDD = annotation.zzvX();
        this.zzaDA = annotation.zzvY();
        this.zzaDE = annotation.zzvW();
        this.zzapg = annotation.getTitle();
    }

    static int zza(AppContentAnnotation appContentAnnotation) {
        return zzw.hashCode(appContentAnnotation.getDescription(), appContentAnnotation.getId(), appContentAnnotation.zzvT(), Integer.valueOf(appContentAnnotation.zzvU()), appContentAnnotation.zzvV(), Integer.valueOf(appContentAnnotation.zzvX()), appContentAnnotation.zzvY(), appContentAnnotation.zzvW(), appContentAnnotation.getTitle());
    }

    static boolean zza(AppContentAnnotation appContentAnnotation, Object obj) {
        if (!(obj instanceof AppContentAnnotation)) {
            return false;
        }
        if (appContentAnnotation == obj) {
            return true;
        }
        AppContentAnnotation appContentAnnotation2 = (AppContentAnnotation) obj;
        return zzw.equal(appContentAnnotation2.getDescription(), appContentAnnotation.getDescription()) && zzw.equal(appContentAnnotation2.getId(), appContentAnnotation.getId()) && zzw.equal(appContentAnnotation2.zzvT(), appContentAnnotation.zzvT()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzvU()), Integer.valueOf(appContentAnnotation.zzvU())) && zzw.equal(appContentAnnotation2.zzvV(), appContentAnnotation.zzvV()) && zzw.equal(Integer.valueOf(appContentAnnotation2.zzvX()), Integer.valueOf(appContentAnnotation.zzvX())) && zzw.equal(appContentAnnotation2.zzvY(), appContentAnnotation.zzvY()) && zzw.equal(appContentAnnotation2.zzvW(), appContentAnnotation.zzvW()) && zzw.equal(appContentAnnotation2.getTitle(), appContentAnnotation.getTitle());
    }

    static String zzb(AppContentAnnotation appContentAnnotation) {
        return zzw.zzy(appContentAnnotation).zzg("Description", appContentAnnotation.getDescription()).zzg("Id", appContentAnnotation.getId()).zzg("ImageDefaultId", appContentAnnotation.zzvT()).zzg("ImageHeight", Integer.valueOf(appContentAnnotation.zzvU())).zzg("ImageUri", appContentAnnotation.zzvV()).zzg("ImageWidth", Integer.valueOf(appContentAnnotation.zzvX())).zzg("LayoutSlot", appContentAnnotation.zzvY()).zzg("Modifiers", appContentAnnotation.zzvW()).zzg("Title", appContentAnnotation.getTitle()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String getTitle() {
        return this.zzapg;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        AppContentAnnotationEntityCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String zzvT() {
        return this.zzaDB;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int zzvU() {
        return this.zzaDC;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Uri zzvV() {
        return this.zzaDz;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public Bundle zzvW() {
        return this.zzaDE;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public int zzvX() {
        return this.zzaDD;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAnnotation
    public String zzvY() {
        return this.zzaDA;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzvZ, reason: merged with bridge method [inline-methods] */
    public AppContentAnnotation freeze() {
        return this;
    }
}
