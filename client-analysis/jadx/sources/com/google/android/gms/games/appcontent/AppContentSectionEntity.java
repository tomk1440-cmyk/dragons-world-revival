package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int mVersionCode;
    private final String zzJN;
    private final ArrayList<AppContentAnnotationEntity> zzaDF;
    private final String zzaDH;
    private final ArrayList<AppContentCardEntity> zzaDO;
    private final String zzaDP;
    private final String zzaDw;
    private final String zzapg;
    private final String zzyv;

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.mVersionCode = versionCode;
        this.mActions = actions;
        this.zzaDF = annotations;
        this.zzaDO = cards;
        this.zzaDP = cardType;
        this.zzaDw = contentDescription;
        this.mExtras = extras;
        this.zzyv = id;
        this.zzaDH = subtitle;
        this.zzapg = title;
        this.zzJN = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        this.mVersionCode = 5;
        this.zzaDP = section.zzwl();
        this.zzaDw = section.zzvQ();
        this.mExtras = section.getExtras();
        this.zzyv = section.getId();
        this.zzaDH = section.zzwc();
        this.zzapg = section.getTitle();
        this.zzJN = section.getType();
        List<AppContentAction> actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) actions.get(i).freeze());
        }
        List<AppContentCard> listZzwk = section.zzwk();
        int size2 = listZzwk.size();
        this.zzaDO = new ArrayList<>(size2);
        for (int i2 = 0; i2 < size2; i2++) {
            this.zzaDO.add((AppContentCardEntity) listZzwk.get(i2).freeze());
        }
        List<AppContentAnnotation> listZzwa = section.zzwa();
        int size3 = listZzwa.size();
        this.zzaDF = new ArrayList<>(size3);
        for (int i3 = 0; i3 < size3; i3++) {
            this.zzaDF.add((AppContentAnnotationEntity) listZzwa.get(i3).freeze());
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzw.hashCode(appContentSection.getActions(), appContentSection.zzwa(), appContentSection.zzwk(), appContentSection.zzwl(), appContentSection.zzvQ(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzwc(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzw.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzw.equal(appContentSection2.zzwa(), appContentSection.zzwa()) && zzw.equal(appContentSection2.zzwk(), appContentSection.zzwk()) && zzw.equal(appContentSection2.zzwl(), appContentSection.zzwl()) && zzw.equal(appContentSection2.zzvQ(), appContentSection.zzvQ()) && zzw.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzw.equal(appContentSection2.getId(), appContentSection.getId()) && zzw.equal(appContentSection2.zzwc(), appContentSection.zzwc()) && zzw.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzw.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzw.zzy(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzwa()).zzg("Cards", appContentSection.zzwk()).zzg("CardType", appContentSection.zzwl()).zzg("ContentDescription", appContentSection.zzvQ()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzwc()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String getTitle() {
        return this.zzapg;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
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
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzvQ() {
        return this.zzaDw;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentAnnotation> zzwa() {
        return new ArrayList(this.zzaDF);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzwc() {
        return this.zzaDH;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public List<AppContentCard> zzwk() {
        return new ArrayList(this.zzaDO);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentSection
    public String zzwl() {
        return this.zzaDP;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwm, reason: merged with bridge method [inline-methods] */
    public AppContentSection freeze() {
        return this;
    }
}
