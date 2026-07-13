package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

/* JADX INFO: loaded from: classes.dex */
public final class InvitationsImpl implements Invitations {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$2, reason: invalid class name */
    class AnonymousClass2 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int zzaGl;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, this.zzaFQ, this.zzaGl);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.InvitationsImpl$3, reason: invalid class name */
    class AnonymousClass3 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaGn;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this, this.zzaGn);
        }
    }

    private static abstract class LoadInvitationsImpl extends Games.BaseGamesApiMethodImpl<Invitations.LoadInvitationsResult> {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaj, reason: merged with bridge method [inline-methods] */
        public Invitations.LoadInvitationsResult zzc(final Status status) {
            return new Invitations.LoadInvitationsResult() { // from class: com.google.android.gms.games.internal.api.InvitationsImpl.LoadInvitationsImpl.1
                @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.zzbI(14));
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.zzh(apiClient).zzwC();
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public PendingResult<Invitations.LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.zza(new LoadInvitationsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.InvitationsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, sortOrder);
            }
        });
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zza(apiClient.zzr(listener));
        }
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations
    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwD();
        }
    }
}
