package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.GamesLog;

/* JADX INFO: loaded from: classes.dex */
public final class MilestoneRef extends zzc implements Milestone {
    MilestoneRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    private long zzxQ() {
        return getLong("initial_value");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.zzc
    public boolean equals(Object obj) {
        return MilestoneEntity.zza(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public Milestone freeze() {
        return new MilestoneEntity(this);
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public byte[] getCompletionRewardData() {
        return getByteArray("completion_reward_data");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public long getCurrentProgress() {
        long jZzxQ;
        long j = 0;
        switch (getState()) {
            case 1:
                jZzxQ = 0;
                break;
            case 2:
                jZzxQ = getLong("current_value");
                if (getLong("quest_state") != 6) {
                    jZzxQ -= zzxQ();
                }
                break;
            case 3:
            case 4:
                jZzxQ = getTargetProgress();
                break;
            default:
                jZzxQ = 0;
                break;
        }
        if (jZzxQ < 0) {
            GamesLog.zzA("MilestoneRef", "Current progress should never be negative");
        } else {
            j = jZzxQ;
        }
        if (j <= getTargetProgress()) {
            return j;
        }
        GamesLog.zzA("MilestoneRef", "Current progress should never exceed target progress");
        return getTargetProgress();
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public String getEventId() {
        return getString("external_event_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public String getMilestoneId() {
        return getString("external_milestone_id");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public int getState() {
        return getInteger("milestone_state");
    }

    @Override // com.google.android.gms.games.quest.Milestone
    public long getTargetProgress() {
        return getLong("target_value");
    }

    @Override // com.google.android.gms.common.data.zzc
    public int hashCode() {
        return MilestoneEntity.zza(this);
    }

    public String toString() {
        return MilestoneEntity.zzb(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        ((MilestoneEntity) freeze()).writeToParcel(dest, flags);
    }
}
