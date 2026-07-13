package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationsImpl implements Notifications {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1, reason: invalid class name */
    class AnonymousClass1 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaGC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzaGC, true);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzao, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusChangeResult zzc(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.1.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2, reason: invalid class name */
    class AnonymousClass2 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaGC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzaGC, false);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzao, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusChangeResult zzc(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.2.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3, reason: invalid class name */
    class AnonymousClass3 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusLoadResult> {
        final /* synthetic */ String zzaGC;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzaGC);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzap, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusLoadResult zzc(final Status status) {
            return new Notifications.GameMuteStatusLoadResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.3.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4, reason: invalid class name */
    class AnonymousClass4 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaFO;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this, this.zzaFO);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5, reason: invalid class name */
    class AnonymousClass5 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzaGG;
        final /* synthetic */ Bundle zzaGH;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaGG, this.zzaGH);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6, reason: invalid class name */
    class AnonymousClass6 extends InboxCountImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this);
        }
    }

    private static abstract class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl<Notifications.ContactSettingLoadResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzaq, reason: merged with bridge method [inline-methods] */
        public Notifications.ContactSettingLoadResult zzc(final Status status) {
            return new Notifications.ContactSettingLoadResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl<Status> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends Games.BaseGamesApiMethodImpl<Notifications.InboxCountResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzar, reason: merged with bridge method [inline-methods] */
        public Notifications.InboxCountResult zzc(final Status status) {
            return new Notifications.InboxCountResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzgt(notificationTypes);
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
