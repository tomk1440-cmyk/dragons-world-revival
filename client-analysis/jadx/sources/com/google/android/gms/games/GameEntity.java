package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

/* JADX INFO: loaded from: classes.dex */
public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final int mVersionCode;
    private final boolean zzDZ;
    private final String zzWQ;
    private final String zzZC;
    private final String zzaCa;
    private final String zzaCb;
    private final String zzaCc;
    private final Uri zzaCd;
    private final Uri zzaCe;
    private final Uri zzaCf;
    private final boolean zzaCg;
    private final boolean zzaCh;
    private final String zzaCi;
    private final int zzaCj;
    private final int zzaCk;
    private final int zzaCl;
    private final boolean zzaCm;
    private final boolean zzaCn;
    private final String zzaCo;
    private final String zzaCp;
    private final String zzaCq;
    private final boolean zzaCr;
    private final boolean zzaCs;
    private final String zzaCt;
    private final boolean zzaCu;
    private final String zzaxl;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        @Override // com.google.android.gms.games.GameEntityCreator, android.os.Parcelable.Creator
        /* JADX INFO: renamed from: zzea */
        public GameEntity createFromParcel(Parcel parcel) {
            if (GameEntity.zzd(GameEntity.zzqB()) || GameEntity.zzcF(GameEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            Uri uri = string7 == null ? null : Uri.parse(string7);
            String string8 = parcel.readString();
            Uri uri2 = string8 == null ? null : Uri.parse(string8);
            String string9 = parcel.readString();
            return new GameEntity(7, string, string2, string3, string4, string5, string6, uri, uri2, string9 == null ? null : Uri.parse(string9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor, boolean hasGamepadSupport) {
        this.mVersionCode = versionCode;
        this.zzZC = applicationId;
        this.zzWQ = displayName;
        this.zzaCa = primaryCategory;
        this.zzaCb = secondaryCategory;
        this.zzaxl = description;
        this.zzaCc = developerName;
        this.zzaCd = iconImageUri;
        this.zzaCo = iconImageUrl;
        this.zzaCe = hiResImageUri;
        this.zzaCp = hiResImageUrl;
        this.zzaCf = featuredImageUri;
        this.zzaCq = featuredImageUrl;
        this.zzaCg = playEnabledGame;
        this.zzaCh = instanceInstalled;
        this.zzaCi = instancePackageName;
        this.zzaCj = gameplayAclStatus;
        this.zzaCk = achievementTotalCount;
        this.zzaCl = leaderboardCount;
        this.zzaCm = realTimeEnabled;
        this.zzaCn = turnBasedEnabled;
        this.zzDZ = muted;
        this.zzaCr = identitySharingConfirmed;
        this.zzaCs = snapshotsEnabled;
        this.zzaCt = themeColor;
        this.zzaCu = hasGamepadSupport;
    }

    public GameEntity(Game game) {
        this.mVersionCode = 7;
        this.zzZC = game.getApplicationId();
        this.zzaCa = game.getPrimaryCategory();
        this.zzaCb = game.getSecondaryCategory();
        this.zzaxl = game.getDescription();
        this.zzaCc = game.getDeveloperName();
        this.zzWQ = game.getDisplayName();
        this.zzaCd = game.getIconImageUri();
        this.zzaCo = game.getIconImageUrl();
        this.zzaCe = game.getHiResImageUri();
        this.zzaCp = game.getHiResImageUrl();
        this.zzaCf = game.getFeaturedImageUri();
        this.zzaCq = game.getFeaturedImageUrl();
        this.zzaCg = game.zzvx();
        this.zzaCh = game.zzvz();
        this.zzaCi = game.zzvA();
        this.zzaCj = game.zzvB();
        this.zzaCk = game.getAchievementTotalCount();
        this.zzaCl = game.getLeaderboardCount();
        this.zzaCm = game.isRealTimeMultiplayerEnabled();
        this.zzaCn = game.isTurnBasedMultiplayerEnabled();
        this.zzDZ = game.isMuted();
        this.zzaCr = game.zzvy();
        this.zzaCs = game.areSnapshotsEnabled();
        this.zzaCt = game.getThemeColor();
        this.zzaCu = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzw.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzvx()), Boolean.valueOf(game.zzvz()), game.zzvA(), Integer.valueOf(game.zzvB()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzvy()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.equal(game2.getApplicationId(), game.getApplicationId()) && zzw.equal(game2.getDisplayName(), game.getDisplayName()) && zzw.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzw.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzw.equal(game2.getDescription(), game.getDescription()) && zzw.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzw.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzw.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzw.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(game2.zzvx()), Boolean.valueOf(game.zzvx())) && zzw.equal(Boolean.valueOf(game2.zzvz()), Boolean.valueOf(game.zzvz())) && zzw.equal(game2.zzvA(), game.zzvA()) && zzw.equal(Integer.valueOf(game2.zzvB()), Integer.valueOf(game.zzvB())) && zzw.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            if (zzw.equal(Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(game2.zzvy()), Boolean.valueOf(game.zzvy())))) && zzw.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzw.equal(game2.getThemeColor(), game.getThemeColor()) && zzw.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzw.zzy(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zzvx())).zzg("InstanceInstalled", Boolean.valueOf(game.zzvz())).zzg("InstancePackageName", game.zzvA()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    @Override // com.google.android.gms.games.Game
    public boolean areSnapshotsEnabled() {
        return this.zzaCs;
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
    public Game freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.Game
    public int getAchievementTotalCount() {
        return this.zzaCk;
    }

    @Override // com.google.android.gms.games.Game
    public String getApplicationId() {
        return this.zzZC;
    }

    @Override // com.google.android.gms.games.Game
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.Game
    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    @Override // com.google.android.gms.games.Game
    public String getDeveloperName() {
        return this.zzaCc;
    }

    @Override // com.google.android.gms.games.Game
    public void getDeveloperName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaCc, dataOut);
    }

    @Override // com.google.android.gms.games.Game
    public String getDisplayName() {
        return this.zzWQ;
    }

    @Override // com.google.android.gms.games.Game
    public void getDisplayName(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzWQ, dataOut);
    }

    @Override // com.google.android.gms.games.Game
    public Uri getFeaturedImageUri() {
        return this.zzaCf;
    }

    @Override // com.google.android.gms.games.Game
    public String getFeaturedImageUrl() {
        return this.zzaCq;
    }

    @Override // com.google.android.gms.games.Game
    public Uri getHiResImageUri() {
        return this.zzaCe;
    }

    @Override // com.google.android.gms.games.Game
    public String getHiResImageUrl() {
        return this.zzaCp;
    }

    @Override // com.google.android.gms.games.Game
    public Uri getIconImageUri() {
        return this.zzaCd;
    }

    @Override // com.google.android.gms.games.Game
    public String getIconImageUrl() {
        return this.zzaCo;
    }

    @Override // com.google.android.gms.games.Game
    public int getLeaderboardCount() {
        return this.zzaCl;
    }

    @Override // com.google.android.gms.games.Game
    public String getPrimaryCategory() {
        return this.zzaCa;
    }

    @Override // com.google.android.gms.games.Game
    public String getSecondaryCategory() {
        return this.zzaCb;
    }

    @Override // com.google.android.gms.games.Game
    public String getThemeColor() {
        return this.zzaCt;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.games.Game
    public boolean hasGamepadSupport() {
        return this.zzaCu;
    }

    public int hashCode() {
        return zza(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.Game
    public boolean isMuted() {
        return this.zzDZ;
    }

    @Override // com.google.android.gms.games.Game
    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzaCm;
    }

    @Override // com.google.android.gms.games.Game
    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzaCn;
    }

    public String toString() {
        return zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        if (!zzqC()) {
            GameEntityCreator.zza(this, dest, flags);
            return;
        }
        dest.writeString(this.zzZC);
        dest.writeString(this.zzWQ);
        dest.writeString(this.zzaCa);
        dest.writeString(this.zzaCb);
        dest.writeString(this.zzaxl);
        dest.writeString(this.zzaCc);
        dest.writeString(this.zzaCd == null ? null : this.zzaCd.toString());
        dest.writeString(this.zzaCe == null ? null : this.zzaCe.toString());
        dest.writeString(this.zzaCf != null ? this.zzaCf.toString() : null);
        dest.writeInt(this.zzaCg ? 1 : 0);
        dest.writeInt(this.zzaCh ? 1 : 0);
        dest.writeString(this.zzaCi);
        dest.writeInt(this.zzaCj);
        dest.writeInt(this.zzaCk);
        dest.writeInt(this.zzaCl);
    }

    @Override // com.google.android.gms.games.Game
    public String zzvA() {
        return this.zzaCi;
    }

    @Override // com.google.android.gms.games.Game
    public int zzvB() {
        return this.zzaCj;
    }

    @Override // com.google.android.gms.games.Game
    public boolean zzvx() {
        return this.zzaCg;
    }

    @Override // com.google.android.gms.games.Game
    public boolean zzvy() {
        return this.zzaCr;
    }

    @Override // com.google.android.gms.games.Game
    public boolean zzvz() {
        return this.zzaCh;
    }
}
