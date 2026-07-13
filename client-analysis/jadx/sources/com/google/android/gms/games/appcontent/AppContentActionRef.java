package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzahi, this.zzaDN, "action_data", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String getId() {
        return getString("action_id");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String getType() {
        return getString(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public AppContentAnnotation zzvO() {
        ArrayList<AppContentAnnotation> arrayListZzb = AppContentUtils.zzb(this.zzahi, this.zzaDN, "action_annotation", this.zzaje);
        if (arrayListZzb.size() == 1) {
            return arrayListZzb.get(0);
        }
        return null;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public List<AppContentCondition> zzvP() {
        return AppContentUtils.zzc(this.zzahi, this.zzaDN, "action_conditions", this.zzaje);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String zzvQ() {
        return getString("action_content_description");
    }

    @Override // com.google.android.gms.games.appcontent.AppContentAction
    public String zzvR() {
        return getString("overflow_text");
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzvS, reason: merged with bridge method [inline-methods] */
    public AppContentAction freeze() {
        return new AppContentActionEntity(this);
    }
}
