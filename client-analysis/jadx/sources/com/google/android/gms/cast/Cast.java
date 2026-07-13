package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final Api.zza<zze, CastOptions> zzUJ = new Api.zza<zze, CastOptions>() { // from class: com.google.android.gms.cast.Cast.1
        @Override // com.google.android.gms.common.api.Api.zza
        public zze zza(Context context, Looper looper, zzf zzfVar, CastOptions castOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(castOptions, "Setting the API options is required.");
            return new zze(context, looper, zzfVar, castOptions.zzZL, castOptions.zzZN, castOptions.zzZM, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<CastOptions> API = new Api<>("Cast.API", zzUJ, zzk.zzUI);
    public static final CastApi CastApi = new CastApi.zza();

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        public static final class zza implements CastApi {
            @Override // com.google.android.gms.cast.Cast.CastApi
            public int getActiveInputState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzol();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).getApplicationMetadata();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).getApplicationStatus();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public int getStandbyState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzom();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).zzok();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzUI)).isMute();
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return zza(client, null, null, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId) {
                return zza(client, applicationId, null, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, String applicationId, String sessionId) {
                return zza(client, applicationId, sessionId, null);
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(client) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.2
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(applicationId, false, (com.google.android.gms.common.api.internal.zza.zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.zzb(new zza(client) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.3
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(applicationId, options, this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new LaunchOptions.Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.zzb(new zzh(client) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.5
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zzb(this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzcg(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void requestStatus(GoogleApiClient client) throws IllegalStateException, IOException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzoj();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.zzb(new zzh(client) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.1
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(namespace, message, this);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IllegalStateException, IOException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zza(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void setMute(GoogleApiClient client, boolean mute) throws IllegalStateException, IOException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzX(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public void setVolume(GoogleApiClient client, double volume) throws IllegalStateException, IOException, IllegalArgumentException {
                try {
                    ((zze) client.zza(zzk.zzUI)).zzf(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.zzb(new zzh(client) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.6
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza("", this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            @Override // com.google.android.gms.cast.Cast.CastApi
            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.zzb(new zzh(client) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.7
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            zze(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            zzeVar.zza(sessionId, this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> zza(GoogleApiClient googleApiClient, final String str, final String str2, final JoinOptions joinOptions) {
                return googleApiClient.zzb(new zza(googleApiClient) { // from class: com.google.android.gms.cast.Cast.CastApi.zza.4
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
                    public void zza(zze zzeVar) throws RemoteException {
                        try {
                            zzeVar.zza(str, str2, joinOptions, this);
                        } catch (IllegalStateException e) {
                            zzbj(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IllegalStateException, IOException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IllegalStateException, IOException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IllegalStateException, IOException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IllegalStateException, IOException, IllegalArgumentException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements Api.ApiOptions.HasOptions {
        final CastDevice zzZL;
        final Listener zzZM;
        private final int zzZN;

        public static final class Builder {
            CastDevice zzZO;
            Listener zzZP;
            private int zzZQ;

            public Builder(CastDevice castDevice, Listener castListener) {
                zzx.zzb(castDevice, "CastDevice parameter cannot be null");
                zzx.zzb(castListener, "CastListener parameter cannot be null");
                this.zzZO = castDevice;
                this.zzZP = castListener;
                this.zzZQ = 0;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.zzZQ |= 1;
                } else {
                    this.zzZQ &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzZL = builder.zzZO;
            this.zzZM = builder.zzZP;
            this.zzZN = builder.zzZQ;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int activeInputState) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int standbyState) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private static abstract class zza extends com.google.android.gms.cast.internal.zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzo, reason: merged with bridge method [inline-methods] */
        public ApplicationConnectionResult zzc(final Status status) {
            return new ApplicationConnectionResult() { // from class: com.google.android.gms.cast.Cast.zza.1
                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public String getApplicationStatus() {
                    return null;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public String getSessionId() {
                    return null;
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
