package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzpg implements SessionsApi {

    private static class zza extends zzou.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SessionReadResult> zzamC;

        private zza(com.google.android.gms.common.api.internal.zza.zzb<SessionReadResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzou
        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzamC.zzs(sessionReadResult);
        }
    }

    private static class zzb extends zzov.zza {
        private final com.google.android.gms.common.api.internal.zza.zzb<SessionStopResult> zzamC;

        private zzb(com.google.android.gms.common.api.internal.zza.zzb<SessionStopResult> zzbVar) {
            this.zzamC = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzov
        public void zza(SessionStopResult sessionStopResult) {
            this.zzamC.zzs(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zzof.zza<SessionStopResult>(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzO, reason: merged with bridge method [inline-methods] */
            public SessionStopResult zzc(Status status) {
                return SessionStopResult.zzV(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzof zzofVar) throws RemoteException {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionStopRequest(str, str2, new zzb(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzof.zzc(client) { // from class: com.google.android.gms.internal.zzpg.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzof zzofVar) throws RemoteException {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionInsertRequest(request, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zzof.zza<SessionReadResult>(client) { // from class: com.google.android.gms.internal.zzpg.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zzb
            /* JADX INFO: renamed from: zzP, reason: merged with bridge method [inline-methods] */
            public SessionReadResult zzc(Status status) {
                return SessionReadResult.zzU(status);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzof zzofVar) throws RemoteException {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionReadRequest(request, new zza(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        com.google.android.gms.common.internal.zzx.zzb(session, "Session cannot be null");
        com.google.android.gms.common.internal.zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, "Cannot start a session which has already ended");
        return client.zzb(new zzof.zzc(client) { // from class: com.google.android.gms.internal.zzpg.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzof zzofVar) throws RemoteException {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionStartRequest(session, new zzph(this)));
            }
        });
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, (String) null, identifier);
    }

    @Override // com.google.android.gms.fitness.SessionsApi
    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzof.zzc(client) { // from class: com.google.android.gms.internal.zzpg.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzof zzofVar) throws RemoteException {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionUnregistrationRequest(intent, new zzph(this)));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzof.zzc(googleApiClient) { // from class: com.google.android.gms.internal.zzpg.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzof zzofVar) throws RemoteException {
                ((zzoq) zzofVar.zzqJ()).zza(new SessionRegistrationRequest(pendingIntent, new zzph(this), i));
            }
        });
    }
}
