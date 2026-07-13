package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzaCS;
    private final PlayerColumnNames zzaDh;
    private final MostRecentGameInfoRef zzaDi;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.zzaDh = new PlayerColumnNames(prefix);
        this.zzaDi = new MostRecentGameInfoRef(holder, dataRow, this.zzaDh);
        if (!zzvJ()) {
            this.zzaCS = null;
            return;
        }
        int integer = getInteger(this.zzaDh.zzaIC);
        int integer2 = getInteger(this.zzaDh.zzaIF);
        PlayerLevel playerLevel = new PlayerLevel(integer, getLong(this.zzaDh.zzaID), getLong(this.zzaDh.zzaIE));
        this.zzaCS = new PlayerLevelInfo(getLong(this.zzaDh.zzaIB), getLong(this.zzaDh.zzaIH), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(this.zzaDh.zzaIE), getLong(this.zzaDh.zzaIG)) : playerLevel);
    }

    private boolean zzvJ() {
        return (zzcB(this.zzaDh.zzaIB) || getLong(this.zzaDh.zzaIB) == -1) ? false : true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Player freeze() {
        return new PlayerEntity(this);
    }

    @Override // com.google.android.gms.games.Player
    public Uri getBannerImageLandscapeUri() {
        return zzcA(this.zzaDh.zzaIS);
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return getString(this.zzaDh.zzaIT);
    }

    @Override // com.google.android.gms.games.Player
    public Uri getBannerImagePortraitUri() {
        return zzcA(this.zzaDh.zzaIU);
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return getString(this.zzaDh.zzaIV);
    }

    @Override // com.google.android.gms.games.Player
    public String getDisplayName() {
        return getString(this.zzaDh.zzaIt);
    }

    @Override // com.google.android.gms.games.Player
    public void getDisplayName(CharArrayBuffer dataOut) {
        zza(this.zzaDh.zzaIt, dataOut);
    }

    @Override // com.google.android.gms.games.Player
    public Uri getHiResImageUri() {
        return zzcA(this.zzaDh.zzaIw);
    }

    @Override // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return getString(this.zzaDh.zzaIx);
    }

    @Override // com.google.android.gms.games.Player
    public Uri getIconImageUri() {
        return zzcA(this.zzaDh.zzaIu);
    }

    @Override // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return getString(this.zzaDh.zzaIv);
    }

    @Override // com.google.android.gms.games.Player
    public long getLastPlayedWithTimestamp() {
        if (!zzcz(this.zzaDh.zzaIA) || zzcB(this.zzaDh.zzaIA)) {
            return -1L;
        }
        return getLong(this.zzaDh.zzaIA);
    }

    @Override // com.google.android.gms.games.Player
    public PlayerLevelInfo getLevelInfo() {
        return this.zzaCS;
    }

    @Override // com.google.android.gms.games.Player
    public String getName() {
        return getString(this.zzaDh.name);
    }

    @Override // com.google.android.gms.games.Player
    public String getPlayerId() {
        return getString(this.zzaDh.zzaIs);
    }

    @Override // com.google.android.gms.games.Player
    public long getRetrievedTimestamp() {
        return getLong(this.zzaDh.zzaIy);
    }

    @Override // com.google.android.gms.games.Player
    public String getTitle() {
        return getString(this.zzaDh.title);
    }

    @Override // com.google.android.gms.games.Player
    public void getTitle(CharArrayBuffer dataOut) {
        zza(this.zzaDh.title, dataOut);
    }

    @Override // com.google.android.gms.games.Player
    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public String toString() {
        return PlayerEntity.zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }

    @Override // com.google.android.gms.games.Player
    public String zzvE() {
        return getString(this.zzaDh.zzaIR);
    }

    @Override // com.google.android.gms.games.Player
    public boolean zzvF() {
        return getBoolean(this.zzaDh.zzaIQ);
    }

    @Override // com.google.android.gms.games.Player
    public int zzvG() {
        return getInteger(this.zzaDh.zzaIz);
    }

    @Override // com.google.android.gms.games.Player
    public boolean zzvH() {
        return getBoolean(this.zzaDh.zzaIJ);
    }

    @Override // com.google.android.gms.games.Player
    public MostRecentGameInfo zzvI() {
        if (zzcB(this.zzaDh.zzaIK)) {
            return null;
        }
        return this.zzaDi;
    }
}
