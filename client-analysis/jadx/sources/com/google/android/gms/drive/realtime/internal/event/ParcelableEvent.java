package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableEvent implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();
    final int mVersionCode;
    final String zzLq;
    final String zzauL;
    final List<String> zzauR;
    final boolean zzauS;
    final boolean zzauT;
    final boolean zzauU;
    final String zzauV;
    final TextInsertedDetails zzauW;
    final TextDeletedDetails zzauX;
    final ValuesAddedDetails zzauY;
    final ValuesRemovedDetails zzauZ;
    final ValuesSetDetails zzava;
    final ValueChangedDetails zzavb;
    final ReferenceShiftedDetails zzavc;
    final ObjectChangedDetails zzavd;
    final FieldChangedDetails zzave;
    final String zzrG;

    ParcelableEvent(int versionCode, String sessionId, String userId, List<String> compoundOperationNames, boolean isLocal, boolean isUndo, boolean isRedo, String objectId, String objectType, TextInsertedDetails textInsertedDetails, TextDeletedDetails textDeletedDetails, ValuesAddedDetails valuesAddedDetails, ValuesRemovedDetails valuesRemovedDetails, ValuesSetDetails valuesSetDetails, ValueChangedDetails valueChangedDetails, ReferenceShiftedDetails referenceShiftedDetails, ObjectChangedDetails objectChangedDetails, FieldChangedDetails fieldChangedDetails) {
        this.mVersionCode = versionCode;
        this.zzLq = sessionId;
        this.zzrG = userId;
        this.zzauR = compoundOperationNames;
        this.zzauS = isLocal;
        this.zzauT = isUndo;
        this.zzauU = isRedo;
        this.zzauL = objectId;
        this.zzauV = objectType;
        this.zzauW = textInsertedDetails;
        this.zzauX = textDeletedDetails;
        this.zzauY = valuesAddedDetails;
        this.zzauZ = valuesRemovedDetails;
        this.zzava = valuesSetDetails;
        this.zzavb = valueChangedDetails;
        this.zzavc = referenceShiftedDetails;
        this.zzavd = objectChangedDetails;
        this.zzave = fieldChangedDetails;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
