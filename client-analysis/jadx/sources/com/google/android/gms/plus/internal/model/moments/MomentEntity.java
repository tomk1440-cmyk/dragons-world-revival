package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzbeM = new HashMap<>();
    final int mVersionCode;
    String zzJN;
    final Set<Integer> zzbeN;
    String zzbfA;
    ItemScopeEntity zzbfI;
    ItemScopeEntity zzbfJ;
    String zzyv;

    static {
        zzbeM.put(ShareConstants.WEB_DIALOG_PARAM_ID, FastJsonResponse.Field.zzl(ShareConstants.WEB_DIALOG_PARAM_ID, 2));
        zzbeM.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
        zzbeM.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
        zzbeM.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
        zzbeM.put(ShareConstants.MEDIA_TYPE, FastJsonResponse.Field.zzl(ShareConstants.MEDIA_TYPE, 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzbeN = new HashSet();
    }

    MomentEntity(Set<Integer> indicatorSet, int versionCode, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzyv = id;
        this.zzbfI = result;
        this.zzbfA = startDate;
        this.zzbfJ = target;
        this.zzJN = type;
    }

    public MomentEntity(Set<Integer> indicatorSet, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzbeN = indicatorSet;
        this.mVersionCode = 1;
        this.zzyv = id;
        this.zzbfI = result;
        this.zzbfA = startDate;
        this.zzbfJ = target;
        this.zzJN = type;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zzb zzbVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzbeM.values()) {
            if (zza(field)) {
                if (momentEntity.zza(field) && zzb(field).equals(momentEntity.zzb(field))) {
                }
                return false;
            }
            if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getId() {
        return this.zzyv;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getResult() {
        return this.zzbfI;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getStartDate() {
        return this.zzbfA;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public ItemScope getTarget() {
        return this.zzbfJ;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public String getType() {
        return this.zzJN;
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasId() {
        return this.zzbeN.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasResult() {
        return this.zzbeN.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasStartDate() {
        return this.zzbeN.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasTarget() {
        return this.zzbeN.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.Moment
    public boolean hasType() {
        return this.zzbeN.contains(7);
    }

    public int hashCode() {
        int iHashCode = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = zzbeM.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field<?, ?> next = it.next();
            if (zza(next)) {
                iHashCode = zzb(next).hashCode() + i + next.zzrs();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, out, flags);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* JADX INFO: renamed from: zzFl, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzrl() {
        return zzbeM;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzFn, reason: merged with bridge method [inline-methods] */
    public MomentEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzbeN.contains(Integer.valueOf(field.zzrs()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrs()) {
            case 2:
                return this.zzyv;
            case 3:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrs());
            case 4:
                return this.zzbfI;
            case 5:
                return this.zzbfA;
            case 6:
                return this.zzbfJ;
            case 7:
                return this.zzJN;
        }
    }
}
