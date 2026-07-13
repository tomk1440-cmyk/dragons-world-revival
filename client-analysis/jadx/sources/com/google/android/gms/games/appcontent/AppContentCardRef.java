package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzahi, this.zzaDN, "card_actions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getDescription() {
        return getString("card_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "card_data", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getId() {
        return getString("card_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getTitle() {
        return getString("card_title");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getType() {
        return getString("card_type");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentCondition> zzvP() {
        return AppContentUtils.zzc(this.zzahi, this.zzaDN, "card_conditions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String zzvQ() {
        return getString("card_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAnnotation> zzwa() {
        return AppContentUtils.zzb(this.zzahi, this.zzaDN, "card_annotations", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int zzwb() {
        return getInteger("card_current_steps");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String zzwc() {
        return getString("card_subtitle");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int zzwd() {
        return getInteger("card_total_steps");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwe, reason: merged with bridge method [inline-methods] */
    public AppContentCard freeze() {
        return new AppContentCardEntity(this);
    }
}
