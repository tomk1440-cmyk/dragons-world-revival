package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzms;

/* JADX INFO: loaded from: classes.dex */
public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final String zzaDj;
    private final Uri zzaDk;
    private final String zzaDl;
    private final Uri zzaDm;
    private final String zzaDn;
    private final int zzaDo;
    private final String zzaDp;
    private final PlayerEntity zzaDq;
    private final int zzaDr;
    private final String zzaDs;
    private final long zzaDt;
    private final long zzaDu;
    private final int zzabB;
    private final String zzaxl;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.mVersionCode = versionCode;
        this.zzaDj = achievementId;
        this.zzabB = type;
        this.mName = name;
        this.zzaxl = description;
        this.zzaDk = unlockedImageUri;
        this.zzaDl = unlockedImageUrl;
        this.zzaDm = revealedImageUri;
        this.zzaDn = revealedImageUrl;
        this.zzaDo = totalSteps;
        this.zzaDp = formattedTotalSteps;
        this.zzaDq = player;
        this.mState = state;
        this.zzaDr = currentSteps;
        this.zzaDs = formattedCurrentSteps;
        this.zzaDt = lastUpdatedTimestamp;
        this.zzaDu = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzaDj = achievement.getAchievementId();
        this.zzabB = achievement.getType();
        this.mName = achievement.getName();
        this.zzaxl = achievement.getDescription();
        this.zzaDk = achievement.getUnlockedImageUri();
        this.zzaDl = achievement.getUnlockedImageUrl();
        this.zzaDm = achievement.getRevealedImageUri();
        this.zzaDn = achievement.getRevealedImageUrl();
        this.zzaDq = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaDt = achievement.getLastUpdatedTimestamp();
        this.zzaDu = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaDo = achievement.getTotalSteps();
            this.zzaDp = achievement.getFormattedTotalSteps();
            this.zzaDr = achievement.getCurrentSteps();
            this.zzaDs = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaDo = 0;
            this.zzaDp = null;
            this.zzaDr = 0;
            this.zzaDs = null;
        }
        zzb.zzv(this.zzaDj);
        zzb.zzv(this.zzaxl);
    }

    static int zza(Achievement achievement) {
        int totalSteps;
        int currentSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        boolean zEqual;
        boolean zEqual2;
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            zEqual2 = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            zEqual = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            zEqual = true;
            zEqual2 = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && zEqual2 && zEqual;
    }

    static String zzb(Achievement achievement) {
        zzw.zza zzaVarZzg = zzw.zzy(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzaVarZzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzaVarZzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzaVarZzg.toString();
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
    public Achievement freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getAchievementId() {
        return this.zzaDj;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getCurrentSteps() {
        zzb.zzab(getType() == 1);
        return zzvM();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getDescription(CharArrayBuffer dataOut) {
        zzms.zzb(this.zzaxl, dataOut);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedCurrentSteps() {
        zzb.zzab(getType() == 1);
        return zzvN();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        zzb.zzab(getType() == 1);
        zzms.zzb(this.zzaDs, dataOut);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedTotalSteps() {
        zzb.zzab(getType() == 1);
        return zzvL();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        zzb.zzab(getType() == 1);
        zzms.zzb(this.zzaDp, dataOut);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getLastUpdatedTimestamp() {
        return this.zzaDt;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public void getName(CharArrayBuffer dataOut) {
        zzms.zzb(this.mName, dataOut);
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Player getPlayer() {
        return this.zzaDq;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getRevealedImageUri() {
        return this.zzaDm;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return this.zzaDn;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getState() {
        return this.mState;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getTotalSteps() {
        zzb.zzab(getType() == 1);
        return zzvK();
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public int getType() {
        return this.zzabB;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getUnlockedImageUri() {
        return this.zzaDk;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return this.zzaDl;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.games.achievement.Achievement
    public long getXpValue() {
        return this.zzaDu;
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
    public void writeToParcel(Parcel dest, int flags) {
        AchievementEntityCreator.zza(this, dest, flags);
    }

    public int zzvK() {
        return this.zzaDo;
    }

    public String zzvL() {
        return this.zzaDp;
    }

    public int zzvM() {
        return this.zzaDr;
    }

    public String zzvN() {
        return this.zzaDs;
    }
}
