package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 4, dataRow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentConditionEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentConditionEntity.zza(this);
    }

    public String toString() {
        return AppContentConditionEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentConditionEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzwf() {
        return getString("condition_default_value");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzwg() {
        return getString("condition_expected_value");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzwh() {
        return getString("condition_predicate");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public Bundle zzwi() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "condition_predicate_parameters", this.zzaje);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwj, reason: merged with bridge method [inline-methods] */
    public AppContentCondition freeze() {
        return new AppContentConditionEntity(this);
    }
}
