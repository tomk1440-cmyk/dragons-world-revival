package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

/* JADX INFO: loaded from: classes.dex */
public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int mVersionCode;
    private final String zzaDJ;
    private final String zzaDK;
    private final String zzaDL;
    private final Bundle zzaDM;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.mVersionCode = versionCode;
        this.zzaDJ = defaultValue;
        this.zzaDK = expectedValue;
        this.zzaDL = predicate;
        this.zzaDM = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.mVersionCode = 1;
        this.zzaDJ = condition.zzwf();
        this.zzaDK = condition.zzwg();
        this.zzaDL = condition.zzwh();
        this.zzaDM = condition.zzwi();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzw.hashCode(appContentCondition.zzwf(), appContentCondition.zzwg(), appContentCondition.zzwh(), appContentCondition.zzwi());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzw.equal(appContentCondition2.zzwf(), appContentCondition.zzwf()) && zzw.equal(appContentCondition2.zzwg(), appContentCondition.zzwg()) && zzw.equal(appContentCondition2.zzwh(), appContentCondition.zzwh()) && zzw.equal(appContentCondition2.zzwi(), appContentCondition.zzwi());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzw.zzy(appContentCondition).zzg("DefaultValue", appContentCondition.zzwf()).zzg("ExpectedValue", appContentCondition.zzwg()).zzg("Predicate", appContentCondition.zzwh()).zzg("PredicateParameters", appContentCondition.zzwi()).toString();
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
        AppContentConditionEntityCreator.zza(this, out, flags);
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzwf() {
        return this.zzaDJ;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzwg() {
        return this.zzaDK;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public String zzwh() {
        return this.zzaDL;
    }

    @Override // com.google.android.gms.games.appcontent.AppContentCondition
    public Bundle zzwi() {
        return this.zzaDM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzwj, reason: merged with bridge method [inline-methods] */
    public AppContentCondition freeze() {
        return this;
    }
}
