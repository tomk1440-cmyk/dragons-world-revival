package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList<AppContentAnnotationEntity> zzaDF;
    private final int zzaDG;
    private final String zzaDH;
    private final int zzaDI;
    private final ArrayList<AppContentConditionEntity> zzaDv;
    private final String zzaDw;
    private final String zzapg;
    private final String zzaxl;
    private final String zzyv;

    AppContentCardEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentAnnotationEntity> annotations, ArrayList<AppContentConditionEntity> conditions, String contentDescription, int currentProgress, String description, Bundle extras, String subtitle, String title, int totalProgress, String type, String id) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaDF = annotations;
        this.zzaDv = conditions;
        this.zzaDw = contentDescription;
        this.zzaDG = currentProgress;
        this.zzaxl = description;
        this.mExtras = extras;
        this.zzyv = id;
        this.zzaDH = subtitle;
        this.zzapg = title;
        this.zzaDI = totalProgress;
        this.zzJN = type;
    }

    public AppContentCardEntity(AppContentCard card) {
        this.mVersionCode = 4;
        this.zzaDw = card.zzvQ();
        this.zzaDG = card.zzwb();
        this.zzaxl = card.getDescription();
        this.mExtras = card.getExtras();
        this.zzyv = card.getId();
        this.zzapg = card.getTitle();
        this.zzaDH = card.zzwc();
        this.zzaDI = card.zzwd();
        this.zzJN = card.getType();
        List<AppContentAction> actions = card.getActions();
        int size = actions.size();
        this.mActions = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) actions.get(i).freeze());
        }
        List<AppContentAnnotation> listZzwa = card.zzwa();
        int size2 = listZzwa.size();
        this.zzaDF = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaDF.add((AppContentAnnotationEntity) listZzwa.get(i2).freeze());
        }
        List<AppContentCondition> listZzvP = card.zzvP();
        int size3 = listZzvP.size();
        this.zzaDv = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaDv.add((AppContentConditionEntity) listZzvP.get(i3).freeze());
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzw.hashCode(appContentCard.getActions(), appContentCard.zzwa(), appContentCard.zzvP(), appContentCard.zzvQ(), Integer.valueOf(appContentCard.zzwb()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzwc(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzwd()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzw.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzw.equal(appContentCard2.zzwa(), appContentCard.zzwa()) && zzw.equal(appContentCard2.zzvP(), appContentCard.zzvP()) && zzw.equal(appContentCard2.zzvQ(), appContentCard.zzvQ()) && zzw.equal(Integer.valueOf(appContentCard2.zzwb()), Integer.valueOf(appContentCard.zzwb())) && zzw.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzw.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzw.equal(appContentCard2.getId(), appContentCard.getId()) && zzw.equal(appContentCard2.zzwc(), appContentCard.zzwc()) && zzw.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzw.equal(Integer.valueOf(appContentCard2.zzwd()), Integer.valueOf(appContentCard.zzwd())) && zzw.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzw.zzy(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzwa()).zzg("Conditions", appContentCard.zzvP()).zzg("ContentDescription", appContentCard.zzvQ()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzwb())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzwc()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzwd())).zzg("Type", appContentCard.getType()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getDescription() {
        return this.zzaxl;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String getType() {
        return this.zzJN;
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
        AppContentCardEntityCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentCondition> zzvP() {
        return new ArrayList(this.zzaDv);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String zzvQ() {
        return this.zzaDw;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public List<AppContentAnnotation> zzwa() {
        return new ArrayList(this.zzaDF);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int zzwb() {
        return this.zzaDG;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public String zzwc() {
        return this.zzaDH;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCard
    public int zzwd() {
        return this.zzaDI;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwe, reason: merged with bridge method [inline-methods] */
    public AppContentCard freeze() {
        return this;
    }
}
