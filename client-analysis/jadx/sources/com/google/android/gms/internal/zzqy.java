package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class zzqy implements Moments {

    private static abstract class zza extends Plus.zza<Moments.LoadMomentsResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzbf, reason: merged with bridge method [inline-methods] */
        public Moments.LoadMomentsResult zzc(final Status status) {
            return new Moments.LoadMomentsResult() { // from class: com.google.android.gms.internal.zzqy.zza.1
                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getNextPageToken() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.plus.Moments.LoadMomentsResult
                public String getUpdated() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class zzb extends Plus.zza<Status> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static abstract class zzc extends Plus.zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzo(this);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Moments.LoadMomentsResult> load(GoogleApiClient googleApiClient, final int maxResults, final String pageToken, final Uri targetUrl, final String type, final String userId) {
        return googleApiClient.zza(new zza(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, maxResults, pageToken, targetUrl, type, userId);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.zzb(new zzb(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zzfG(momentId);
                zza(Status.zzagC);
            }
        });
    }

    @Override // com.google.android.gms.plus.Moments
    @SuppressLint({"MissingRemoteException"})
    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.zzb(new zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzqy.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(com.google.android.gms.plus.internal.zze zzeVar) {
                zzeVar.zza(this, moment);
            }
        });
    }
}
