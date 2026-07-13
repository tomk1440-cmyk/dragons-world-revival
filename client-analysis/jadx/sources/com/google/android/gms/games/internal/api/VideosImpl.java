package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: loaded from: classes.dex */
public final class VideosImpl implements Videos {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.VideosImpl$1, reason: invalid class name */
    class AnonymousClass1 extends Games.BaseGamesApiMethodImpl<Status> {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String zzaHU;
        final /* synthetic */ VideoConfiguration zzaHV;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHU, this.zzaHV);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.VideosImpl$2, reason: invalid class name */
    class AnonymousClass2 extends CapabilitiesImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.VideosImpl$3, reason: invalid class name */
    class AnonymousClass3 extends AvailableImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.VideosImpl$4, reason: invalid class name */
    class AnonymousClass4 extends ListImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }

    private static abstract class AvailableImpl extends Games.BaseGamesApiMethodImpl<Videos.VideoAvailableResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaO, reason: merged with bridge method [inline-methods] */
        public Videos.VideoAvailableResult zzc(final Status status) {
            return new Videos.VideoAvailableResult() { // from class: com.google.android.gms.games.internal.api.VideosImpl.AvailableImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class CapabilitiesImpl extends Games.BaseGamesApiMethodImpl<Videos.VideoCapabilitiesResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaP, reason: merged with bridge method [inline-methods] */
        public Videos.VideoCapabilitiesResult zzc(final Status status) {
            return new Videos.VideoCapabilitiesResult() { // from class: com.google.android.gms.games.internal.api.VideosImpl.CapabilitiesImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ListImpl extends Games.BaseGamesApiMethodImpl<Videos.ListVideosResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaQ, reason: merged with bridge method [inline-methods] */
        public Videos.ListVideosResult zzc(final Status status) {
            return new Videos.ListVideosResult() { // from class: com.google.android.gms.games.internal.api.VideosImpl.ListImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }
}
