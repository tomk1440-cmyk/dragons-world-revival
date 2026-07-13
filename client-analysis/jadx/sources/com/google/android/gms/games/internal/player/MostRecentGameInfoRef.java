package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

/* JADX INFO: loaded from: classes.dex */
public final class MostRecentGameInfoRef extends zzc implements MostRecentGameInfo {
    private final PlayerColumnNames zzaDh;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.zzaDh = columnNames;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.zza(this, obj);
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return MostRecentGameInfoEntity.zza(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public long zzxA() {
        return getLong(this.zzaDh.zzaIM);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzxB() {
        return zzcA(this.zzaDh.zzaIN);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzxC() {
        return zzcA(this.zzaDh.zzaIO);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzxD() {
        return zzcA(this.zzaDh.zzaIP);
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzxE, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfo freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String zzxy() {
        return getString(this.zzaDh.zzaIK);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String zzxz() {
        return getString(this.zzaDh.zzaIL);
    }
}
