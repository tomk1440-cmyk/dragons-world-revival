package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;

/* JADX INFO: loaded from: classes.dex */
public class zzba implements Parcelable.Creator<OnEventResponse> {
    static void zza(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int iZzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, onEventResponse.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, onEventResponse.zzanf);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) onEventResponse.zzasl, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, (Parcelable) onEventResponse.zzasm, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) onEventResponse.zzasn, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, (Parcelable) onEventResponse.zzaso, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, (Parcelable) onEventResponse.zzasp, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, (Parcelable) onEventResponse.zzasq, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, iZzav);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzbD, reason: merged with bridge method [inline-methods] */
    public OnEventResponse createFromParcel(Parcel parcel) {
        int iZzg = 0;
        TransferProgressEvent transferProgressEvent = null;
        int iZzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        TransferStateEvent transferStateEvent = null;
        ChangesAvailableEvent changesAvailableEvent = null;
        QueryResultEventParcelable queryResultEventParcelable = null;
        CompletionEvent completionEvent = null;
        ChangeEvent changeEvent = null;
        int iZzg2 = 0;
        while (parcel.dataPosition() < iZzau) {
            int iZzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(iZzat)) {
                case 1:
                    iZzg2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 2:
                    iZzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, iZzat);
                    break;
                case 3:
                    changeEvent = (ChangeEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ChangeEvent.CREATOR);
                    break;
                case 4:
                case 8:
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, iZzat);
                    break;
                case 5:
                    completionEvent = (CompletionEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, CompletionEvent.CREATOR);
                    break;
                case 6:
                    queryResultEventParcelable = (QueryResultEventParcelable) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, QueryResultEventParcelable.CREATOR);
                    break;
                case 7:
                    changesAvailableEvent = (ChangesAvailableEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, ChangesAvailableEvent.CREATOR);
                    break;
                case 9:
                    transferStateEvent = (TransferStateEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TransferStateEvent.CREATOR);
                    break;
                case 10:
                    transferProgressEvent = (TransferProgressEvent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, iZzat, TransferProgressEvent.CREATOR);
                    break;
            }
        }
        if (parcel.dataPosition() != iZzau) {
            throw new com.google.android.gms.common.internal.safeparcel.zza.C0052zza("Overread allowed size end=" + iZzau, parcel);
        }
        return new OnEventResponse(iZzg2, iZzg, changeEvent, completionEvent, queryResultEventParcelable, changesAvailableEvent, transferStateEvent, transferProgressEvent);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: zzdy, reason: merged with bridge method [inline-methods] */
    public OnEventResponse[] newArray(int i) {
        return new OnEventResponse[i];
    }
}
