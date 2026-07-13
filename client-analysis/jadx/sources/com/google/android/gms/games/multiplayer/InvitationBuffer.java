package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

/* JADX INFO: loaded from: classes.dex */
public final class InvitationBuffer extends zzf<Invitation> {
    public InvitationBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.data.zzf
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public Invitation zzk(int i, int i2) {
        return new InvitationRef(this.zzahi, i, i2);
    }

    @Override // com.google.android.gms.common.data.zzf
    protected String zzqg() {
        return "external_invitation_id";
    }
}
