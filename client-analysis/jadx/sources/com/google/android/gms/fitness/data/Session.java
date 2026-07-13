package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class Session implements SafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzq();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzRD;
    private final long zzavV;
    private final int zzawf;
    private final Application zzaws;
    private final String zzaxk;
    private final String zzaxl;
    private final Long zzaxm;

    public static class Builder {
        private Application zzaws;
        private String zzaxk;
        private String zzaxl;
        private Long zzaxm;
        private long zzRD = 0;
        private long zzavV = 0;
        private String mName = null;
        private int zzawf = 4;

        public Session build() {
            zzx.zza(this.zzRD > 0, "Start time should be specified.");
            zzx.zza(this.zzavV == 0 || this.zzavV > this.zzRD, "End time should be later than start time.");
            if (this.zzaxk == null) {
                this.zzaxk = (this.mName == null ? "" : this.mName) + this.zzRD;
            }
            return new Session(this);
        }

        public Builder setActiveTime(long time, TimeUnit timeUnit) {
            this.zzaxm = Long.valueOf(timeUnit.toMillis(time));
            return this;
        }

        public Builder setActivity(String activity) {
            return zzfa(FitnessActivities.zzdm(activity));
        }

        public Builder setDescription(String description) {
            zzx.zzb(description.length() <= 1000, "Session description cannot exceed %d characters", 1000);
            this.zzaxl = description;
            return this;
        }

        public Builder setEndTime(long time, TimeUnit timeUnit) {
            zzx.zza(time >= 0, "End time should be positive.");
            this.zzavV = timeUnit.toMillis(time);
            return this;
        }

        public Builder setIdentifier(String identifier) {
            zzx.zzac(identifier != null && TextUtils.getTrimmedLength(identifier) > 0);
            this.zzaxk = identifier;
            return this;
        }

        public Builder setName(String name) {
            zzx.zzb(name.length() <= 100, "Session name cannot exceed %d characters", 100);
            this.mName = name;
            return this;
        }

        public Builder setStartTime(long time, TimeUnit timeUnit) {
            zzx.zza(time > 0, "Start time should be positive.");
            this.zzRD = timeUnit.toMillis(time);
            return this;
        }

        public Builder zzfa(int i) {
            this.zzawf = i;
            return this;
        }
    }

    Session(int versionCode, long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, Application application, Long activeTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzRD = startTimeMillis;
        this.zzavV = endTimeMillis;
        this.mName = name;
        this.zzaxk = identifier;
        this.zzaxl = description;
        this.zzawf = activityType;
        this.zzaws = application;
        this.zzaxm = activeTimeMillis;
    }

    public Session(long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, Application application, Long activeTimeMillis) {
        this(3, startTimeMillis, endTimeMillis, name, identifier, description, activityType, application, activeTimeMillis);
    }

    private Session(Builder builder) {
        this(builder.zzRD, builder.zzavV, builder.mName, builder.zzaxk, builder.zzaxl, builder.zzawf, builder.zzaws, builder.zzaxm);
    }

    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) com.google.android.gms.common.internal.safeparcel.zzc.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String activity) {
        return MIME_TYPE_PREFIX + activity;
    }

    private boolean zza(Session session) {
        return this.zzRD == session.zzRD && this.zzavV == session.zzavV && zzw.equal(this.mName, session.mName) && zzw.equal(this.zzaxk, session.zzaxk) && zzw.equal(this.zzaxl, session.zzaxl) && zzw.equal(this.zzaws, session.zzaws) && this.zzawf == session.zzawf;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Session) && zza((Session) o));
    }

    public long getActiveTime(TimeUnit timeUnit) {
        zzx.zza(this.zzaxm != null, "Active time is not set");
        return timeUnit.convert(this.zzaxm.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzawf);
    }

    public String getAppPackageName() {
        if (this.zzaws == null) {
            return null;
        }
        return this.zzaws.getPackageName();
    }

    public String getDescription() {
        return this.zzaxl;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavV, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzaxk;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzRD, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasActiveTime() {
        return this.zzaxm != null;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzRD), Long.valueOf(this.zzavV), this.zzaxk);
    }

    public boolean isOngoing() {
        return this.zzavV == 0;
    }

    public String toString() {
        return zzw.zzy(this).zzg("startTime", Long.valueOf(this.zzRD)).zzg("endTime", Long.valueOf(this.zzavV)).zzg("name", this.mName).zzg(SettingsJsonConstants.APP_IDENTIFIER_KEY, this.zzaxk).zzg("description", this.zzaxl).zzg("activity", Integer.valueOf(this.zzawf)).zzg("application", this.zzaws).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }

    public long zzlO() {
        return this.zzRD;
    }

    public int zzub() {
        return this.zzawf;
    }

    public long zzud() {
        return this.zzavV;
    }

    public Application zzum() {
        return this.zzaws;
    }

    public Long zzuw() {
        return this.zzaxm;
    }
}
