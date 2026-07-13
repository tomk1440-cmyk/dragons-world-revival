package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;

/* JADX INFO: loaded from: classes.dex */
public final class QuestsImpl implements Quests {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends LoadsImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ int[] zzaGY;
        final /* synthetic */ int zzaGl;
        final /* synthetic */ String zzaHa;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaGY, this.zzaGl, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends LoadsImpl {
        final /* synthetic */ boolean zzaFO;
        final /* synthetic */ String zzaFQ;
        final /* synthetic */ String[] zzaGZ;
        final /* synthetic */ String zzaHa;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaFQ, this.zzaHa, this.zzaFO, this.zzaGZ);
        }
    }

    private static abstract class AcceptImpl extends Games.BaseGamesApiMethodImpl<Quests.AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaw, reason: merged with bridge method [inline-methods] */
        public Quests.AcceptQuestResult zzc(final Status status) {
            return new Quests.AcceptQuestResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.AcceptImpl.1
                @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
                public Quest getQuest() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ClaimImpl extends Games.BaseGamesApiMethodImpl<Quests.ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzax, reason: merged with bridge method [inline-methods] */
        public Quests.ClaimMilestoneResult zzc(final Status status) {
            return new Quests.ClaimMilestoneResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.ClaimImpl.1
                @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
                public Milestone getMilestone() {
                    return null;
                }

                @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
                public Quest getQuest() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadsImpl extends Games.BaseGamesApiMethodImpl<Quests.LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzay, reason: merged with bridge method [inline-methods] */
        public Quests.LoadQuestsResult zzc(final Status status) {
            return new Quests.LoadQuestsResult() { // from class: com.google.android.gms.games.internal.api.QuestsImpl.LoadsImpl.1
                @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzbI(status.getStatusCode()));
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

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.zzb(new AcceptImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzh(this, questId);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.zzb(new ClaimImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, questId, milestoneId);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.zzh(apiClient).zzdI(questId);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.zzh(apiClient).zzb(questSelectors);
    }

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.LoadQuestsResult> load(GoogleApiClient apiClient, final int[] questSelectors, final int sortOrder, final boolean forceReload) {
        return apiClient.zza(new LoadsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, questSelectors, sortOrder, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public PendingResult<Quests.LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.zza(new LoadsImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.QuestsImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(this, forceReload, questIds);
            }
        });
    }

    @Override // com.google.android.gms.games.quest.Quests
    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzc(apiClient.zzr(listener));
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzdJ(questId);
        }
    }

    @Override // com.google.android.gms.games.quest.Quests
    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzwF();
        }
    }
}
