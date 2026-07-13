package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzms;

/* JADX INFO: loaded from: classes.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final String mName;
    private final int mVersionCode;
    private String zzWQ;
    private final long zzaCO;
    private final int zzaCP;
    private final long zzaCQ;
    private final MostRecentGameInfoEntity zzaCR;
    private final PlayerLevelInfo zzaCS;
    private final boolean zzaCT;
    private final boolean zzaCU;
    private final String zzaCV;
    private final Uri zzaCW;
    private final String zzaCX;
    private final Uri zzaCY;
    private final String zzaCZ;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final String zzaCo;
    private final String zzaCp;
    private String zzacX;
    private final String zzapg;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.PlayerEntityCreator, android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzeb, reason: merged with bridge method [inline-methods] */
        public PlayerEntity createFromParcel(Parcel parcel) {
            if (PlayerEntity.zzd(PlayerEntity.zzqB()) || PlayerEntity.zzcF(PlayerEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            return new PlayerEntity(13, string, string2, string3 == null ? null : Uri.parse(string3), string4 == null ? null : Uri.parse(string4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible, boolean hasDebugAccess, String gamerTag, String name, Uri bannerImageLandscapeUri, String bannerImageLandscapeUrl, Uri bannerImagePortraitUri, String bannerImagePortraitUrl) {
        this.mVersionCode = versionCode;
        this.zzacX = playerId;
        this.zzWQ = displayName;
        this.zzaCd = iconImageUri;
        this.zzaCo = iconImageUrl;
        this.zzaCe = hiResImageUri;
        this.zzaCp = hiResImageUrl;
        this.zzaCO = retrievedTimestamp;
        this.zzaCP = isInCircles;
        this.zzaCQ = lastPlayedWithTimestamp;
        this.zzapg = title;
        this.zzaCT = isProfileVisible;
        this.zzaCR = mostRecentGameInfo;
        this.zzaCS = playerLevelInfo;
        this.zzaCU = hasDebugAccess;
        this.zzaCV = gamerTag;
        this.mName = name;
        this.zzaCW = bannerImageLandscapeUri;
        this.zzaCX = bannerImageLandscapeUrl;
        this.zzaCY = bannerImagePortraitUri;
        this.zzaCZ = bannerImagePortraitUrl;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean isPlusEnabled) {
        this.mVersionCode = 13;
        this.zzacX = isPlusEnabled ? player.getPlayerId() : null;
        this.zzWQ = player.getDisplayName();
        this.zzaCd = player.getIconImageUri();
        this.zzaCo = player.getIconImageUrl();
        this.zzaCe = player.getHiResImageUri();
        this.zzaCp = player.getHiResImageUrl();
        this.zzaCO = player.getRetrievedTimestamp();
        this.zzaCP = player.zzvG();
        this.zzaCQ = player.getLastPlayedWithTimestamp();
        this.zzapg = player.getTitle();
        this.zzaCT = player.zzvH();
        MostRecentGameInfo mostRecentGameInfoZzvI = player.zzvI();
        this.zzaCR = mostRecentGameInfoZzvI != null ? new MostRecentGameInfoEntity(mostRecentGameInfoZzvI) : null;
        this.zzaCS = player.getLevelInfo();
        this.zzaCU = player.zzvF();
        this.zzaCV = player.zzvE();
        this.mName = player.getName();
        this.zzaCW = player.getBannerImageLandscapeUri();
        this.zzaCX = player.getBannerImageLandscapeUrl();
        this.zzaCY = player.getBannerImagePortraitUri();
        this.zzaCZ = player.getBannerImagePortraitUrl();
        if (isPlusEnabled) {
            zzb.zzv(this.zzacX);
        }
        zzb.zzv(this.zzWQ);
        zzb.zzab(this.zzaCO > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.equal(player2.getPlayerId(), player.getPlayerId()) && zzw.equal(player2.getDisplayName(), player.getDisplayName()) && zzw.equal(Boolean.valueOf(player2.zzvF()), Boolean.valueOf(player.zzvF())) && zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzw.equal(player2.getTitle(), player.getTitle()) && zzw.equal(player2.getLevelInfo(), player.getLevelInfo()) && zzw.equal(player2.zzvE(), player.zzvE()) && zzw.equal(player2.getName(), player.getName()) && zzw.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && zzw.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri());
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzvF()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzvE(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri());
    }

    static String zzc(Player player) {
        return zzw.zzy(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzvF())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zzvE()).zzg("Name", player.getName()).zzg("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", player.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Player freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getBannerImageLandscapeUri() {
        return this.zzaCW;
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return this.zzaCX;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getBannerImagePortraitUri() {
        return this.zzaCY;
    }

    @Override // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return this.zzaCZ;
    }

    @Override // com.google.android.gms.games.Player
    public String getDisplayName() {
        return this.zzWQ;
    }

    @Override // com.google.android.gms.games.Player
    public void getDisplayName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzWQ, dataOut);
    }

    @Override // com.google.android.gms.games.Player
    public Uri getHiResImageUri() {
        return this.zzaCe;
    }

    @Override // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return this.zzaCp;
    }

    @Override // com.google.android.gms.games.Player
    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    @Override // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return this.zzaCo;
    }

    @Override // com.google.android.gms.games.Player
    public long getLastPlayedWithTimestamp() {
        return this.zzaCQ;
    }

    @Override // com.google.android.gms.games.Player
    public PlayerLevelInfo getLevelInfo() {
        return this.zzaCS;
    }

    @Override // com.google.android.gms.games.Player
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.Player
    public String getPlayerId() {
        return this.zzacX;
    }

    @Override // com.google.android.gms.games.Player
    public long getRetrievedTimestamp() {
        return this.zzaCO;
    }

    @Override // com.google.android.gms.games.Player
    public String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.Player
    public void getTitle(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzapg, dataOut);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.games.Player
    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    @Override // com.google.android.gms.games.Player
    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (!zzqC()) {
            PlayerEntityCreator.zza(this, dest, flags);
            return;
        }
        dest.writeString(this.zzacX);
        dest.writeString(this.zzWQ);
        dest.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
        dest.writeString(this.zzaCe != null ? this.zzaCe.toString() : null);
        dest.writeLong(this.zzaCO);
    }

    @Override // com.google.android.gms.games.Player
    public String zzvE() {
        return this.zzaCV;
    }

    @Override // com.google.android.gms.games.Player
    public boolean zzvF() {
        return this.zzaCU;
    }

    @Override // com.google.android.gms.games.Player
    public int zzvG() {
        return this.zzaCP;
    }

    @Override // com.google.android.gms.games.Player
    public boolean zzvH() {
        return this.zzaCT;
    }

    @Override // com.google.android.gms.games.Player
    public MostRecentGameInfo zzvI() {
        return this.zzaCR;
    }
}
