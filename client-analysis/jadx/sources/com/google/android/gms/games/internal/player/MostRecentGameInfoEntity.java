package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int mVersionCode;
    private final String zzaIm;
    private final String zzaIn;
    private final long zzaIo;
    private final Uri zzaIp;
    private final Uri zzaIq;
    private final Uri zzaIr;

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.mVersionCode = versionCode;
        this.zzaIm = gameId;
        this.zzaIn = gameName;
        this.zzaIo = activityTimestampMillis;
        this.zzaIp = gameIconImageUri;
        this.zzaIq = gameHiResIconImageUri;
        this.zzaIr = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.mVersionCode = 2;
        this.zzaIm = info.zzxy();
        this.zzaIn = info.zzxz();
        this.zzaIo = info.zzxA();
        this.zzaIp = info.zzxB();
        this.zzaIq = info.zzxC();
        this.zzaIr = info.zzxD();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzxy(), mostRecentGameInfo.zzxz(), Long.valueOf(mostRecentGameInfo.zzxA()), mostRecentGameInfo.zzxB(), mostRecentGameInfo.zzxC(), mostRecentGameInfo.zzxD());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.equal(mostRecentGameInfo2.zzxy(), mostRecentGameInfo.zzxy()) && zzw.equal(mostRecentGameInfo2.zzxz(), mostRecentGameInfo.zzxz()) && zzw.equal(Long.valueOf(mostRecentGameInfo2.zzxA()), Long.valueOf(mostRecentGameInfo.zzxA())) && zzw.equal(mostRecentGameInfo2.zzxB(), mostRecentGameInfo.zzxB()) && zzw.equal(mostRecentGameInfo2.zzxC(), mostRecentGameInfo.zzxC()) && zzw.equal(mostRecentGameInfo2.zzxD(), mostRecentGameInfo.zzxD());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzy(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzxy()).zzg("GameName", mostRecentGameInfo.zzxz()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzxA())).zzg("GameIconUri", mostRecentGameInfo.zzxB()).zzg("GameHiResUri", mostRecentGameInfo.zzxC()).zzg("GameFeaturedUri", mostRecentGameInfo.zzxD()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        MostRecentGameInfoEntityCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public long zzxA() {
        return this.zzaIo;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzxB() {
        return this.zzaIp;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzxC() {
        return this.zzaIq;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public Uri zzxD() {
        return this.zzaIr;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzxE, reason: merged with bridge method [inline-methods] */
    public MostRecentGameInfo freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String zzxy() {
        return this.zzaIm;
    }

    @Override // com.google.android.gms.games.internal.player.MostRecentGameInfo
    public String zzxz() {
        return this.zzaIn;
    }
}
