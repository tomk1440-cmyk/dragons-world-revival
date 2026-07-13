package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface AppContentAction extends Parcelable, Freezable<AppContentAction> {
    Bundle getExtras();

    String getId();

    String getType();

    AppContentAnnotation zzvO();

    List<AppContentCondition> zzvP();

    String zzvQ();

    String zzvR();
}
