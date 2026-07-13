package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> zzaDN;

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public void release() {
        super.release();
        int size = this.zzaDN.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = this.zzaDN.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] */
    public AppContentSection zzk(int i, int i2) {
        return new AppContentSectionRef(this.zzaDN, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String zzqg() {
        return "section_id";
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String zzqi() {
        return "card_id";
    }
}
