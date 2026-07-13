package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaDQ;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.zzaDQ = numChildren;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "section_data", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getId() {
        return getString("section_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getTitle() {
        return getString("section_title");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getType() {
        return getString("section_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzvQ() {
        return getString("section_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzwc() {
        return getString("section_subtitle");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzwl() {
        return getString("section_card_type");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwm, reason: merged with bridge method [inline-methods] */
    public AppContentSection freeze() {
        return new AppContentSectionEntity(this);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* JADX INFO: renamed from: zzwn, reason: merged with bridge method [inline-methods] */
    public ArrayList<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "section_actions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* JADX INFO: renamed from: zzwo, reason: merged with bridge method [inline-methods] */
    public ArrayList<AppContentAnnotation> zzwa() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "section_annotations", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    /* JADX INFO: renamed from: zzwp, reason: merged with bridge method [inline-methods] */
    public ArrayList<AppContentCard> zzwk() {
        ArrayList<AppContentCard> arrayList = new ArrayList<>(this.zzaDQ);
        for (int i = 0; i < this.zzaDQ; i++) {
            arrayList.add(new AppContentCardRef(this.zzaDN, this.zzaje + i));
        }
        return arrayList;
    }
}
