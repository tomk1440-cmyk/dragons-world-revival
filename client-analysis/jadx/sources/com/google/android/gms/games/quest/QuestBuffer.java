package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class QuestBuffer extends zzf<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String zzqg() {
        return "external_quest_id";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
    public Quest zzk(int i, int i2) {
        return new QuestRef(this.zzahi, i, i2);
    }
}
