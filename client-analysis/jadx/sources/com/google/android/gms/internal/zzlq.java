package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.cast.CastRemoteDisplay;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public class zzlq implements CastRemoteDisplayApi {
    private static final com.google.android.gms.cast.internal.zzl zzaaf = new com.google.android.gms.cast.internal.zzl("CastRemoteDisplayApiImpl");
    private Api.zzc<zzlr> zzaeE;
    private VirtualDisplay zzaeF;
    private final zzlu zzaeG = new zzlu.zza() { // from class: com.google.android.gms.internal.zzlq.1
        @Override // com.google.android.gms.internal.zzlu
        public void zzbp(int i) {
            zzlq.zzaaf.zzb("onRemoteDisplayEnded", new Object[0]);
            zzlq.this.zzoB();
        }
    };

    private abstract class zza extends zzls.zza {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzls
        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzls
        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzls
        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.android.gms.internal.zzls
        public void zzoD() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private abstract class zzb extends com.google.android.gms.common.api.internal.zza.AbstractC0049zza<CastRemoteDisplay.CastRemoteDisplaySessionResult, zzlr> {

        @TargetApi(19)
        protected final class zza extends zza {
            private final zzlr zzaeJ;

            public zza(zzlr zzlrVar) {
                super();
                this.zzaeJ = zzlrVar;
            }

            private int zzj(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            @Override // com.google.android.gms.internal.zzlq.zza, com.google.android.gms.internal.zzls
            public void onError(int statusCode) throws RemoteException {
                zzlq.zzaaf.zzb("onError: %d", Integer.valueOf(statusCode));
                zzlq.this.zzoB();
                zzb.this.zza(new zzc(Status.zzagE));
            }

            @Override // com.google.android.gms.internal.zzlq.zza, com.google.android.gms.internal.zzls
            public void zza(int i, int i2, Surface surface) {
                zzlq.zzaaf.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzaeJ.getContext().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
                if (displayManager == null) {
                    zzlq.zzaaf.zzc("Unable to get the display manager", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                    return;
                }
                zzlq.this.zzoB();
                int iZzj = zzj(i, i2);
                zzlq.this.zzaeF = displayManager.createVirtualDisplay("private_display", i, i2, iZzj, surface, 2);
                if (zzlq.this.zzaeF == null) {
                    zzlq.zzaaf.zzc("Unable to create virtual display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                } else if (zzlq.this.zzaeF.getDisplay() == null) {
                    zzlq.zzaaf.zzc("Virtual display does not have a display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                } else {
                    try {
                        this.zzaeJ.zza(this, zzlq.this.zzaeF.getDisplay().getDisplayId());
                    } catch (RemoteException | IllegalStateException e) {
                        zzlq.zzaaf.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        zzb.this.zza(new zzc(Status.zzagE));
                    }
                }
            }

            @Override // com.google.android.gms.internal.zzlq.zza, com.google.android.gms.internal.zzls
            public void zzoD() {
                zzlq.zzaaf.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = zzlq.this.zzaeF.getDisplay();
                if (display != null) {
                    zzb.this.zza(new zzc(display));
                } else {
                    zzlq.zzaaf.zzc("Virtual display no longer has a display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzagE));
                }
            }
        }

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzlq$zzb$zzb, reason: collision with other inner class name */
        protected final class BinderC0135zzb extends zza {
            protected BinderC0135zzb() {
                super();
            }

            @Override // com.google.android.gms.internal.zzlq.zza, com.google.android.gms.internal.zzls
            public void onDisconnected() throws RemoteException {
                zzlq.zzaaf.zzb("onDisconnected", new Object[0]);
                zzlq.this.zzoB();
                zzb.this.zza(new zzc(Status.zzagC));
            }

            @Override // com.google.android.gms.internal.zzlq.zza, com.google.android.gms.internal.zzls
            public void onError(int statusCode) throws RemoteException {
                zzlq.zzaaf.zzb("onError: %d", Integer.valueOf(statusCode));
                zzlq.this.zzoB();
                zzb.this.zza(new zzc(Status.zzagE));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(zzlq.this.zzaeE, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.zzb
        /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public CastRemoteDisplay.CastRemoteDisplaySessionResult zzc(Status status) {
            return new zzc(status);
        }
    }

    private static final class zzc implements CastRemoteDisplay.CastRemoteDisplaySessionResult {
        private final Status zzUX;
        private final Display zzaar;

        public zzc(Display display) {
            this.zzUX = Status.zzagC;
            this.zzaar = display;
        }

        public zzc(Status status) {
            this.zzUX = status;
            this.zzaar = null;
        }

        @Override // com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult
        public Display getPresentationDisplay() {
            return this.zzaar;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }
    }

    public zzlq(Api.zzc<zzlr> zzcVar) {
        this.zzaeE = zzcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public void zzoB() {
        if (this.zzaeF != null) {
            if (this.zzaeF.getDisplay() != null) {
                zzaaf.zzb("releasing virtual display: " + this.zzaeF.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzaeF.release();
            this.zzaeF = null;
        }
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, final String appId) {
        zzaaf.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.internal.zzlq.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzlr zzlrVar) throws RemoteException {
                zzlrVar.zza(new zzb.zza(zzlrVar), zzlq.this.zzaeG, appId);
            }
        });
    }

    @Override // com.google.android.gms.cast.CastRemoteDisplayApi
    public PendingResult<CastRemoteDisplay.CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzaaf.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(apiClient) { // from class: com.google.android.gms.internal.zzlq.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.internal.zza.AbstractC0049zza
            public void zza(zzlr zzlrVar) throws RemoteException {
                zzlrVar.zza((zzls) new zzb.BinderC0135zzb());
            }
        });
    }
}
