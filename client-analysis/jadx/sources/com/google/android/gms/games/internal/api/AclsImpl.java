package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;

/* JADX INFO: loaded from: classes.dex */
public final class AclsImpl implements Acls {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.AclsImpl$2, reason: invalid class name */
    class AnonymousClass2 extends LoadNotifyAclImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.AclsImpl$3, reason: invalid class name */
    class AnonymousClass3 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzaFV;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, this.zzaFV);
        }
    }

    private static abstract class LoadNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzad, reason: merged with bridge method [inline-methods] */
        public Acls.LoadAclResult zzc(Status status) {
            return AclsImpl.zzab(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends Games.BaseGamesApiMethodImpl<Status> {
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status zzc(Status status) {
            return status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Acls.LoadAclResult zzab(final Status status) {
        return new Acls.LoadAclResult() { // from class: com.google.android.gms.games.internal.api.AclsImpl.1
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
