package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface AppContentCard extends Parcelable, Freezable<AppContentCard> {
    List<AppContentAction> getActions();

    String getDescription();

    Bundle getExtras();

    String getId();

    String getTitle();

    String getType();

    List<AppContentCondition> zzvP();

    String zzvQ();

    List<AppContentAnnotation> zzwa();

    int zzwb();

    String zzwc();

    int zzwd();
}
