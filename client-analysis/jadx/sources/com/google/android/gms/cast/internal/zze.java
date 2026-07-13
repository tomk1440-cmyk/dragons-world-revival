package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.JoinOptions;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zze extends com.google.android.gms.common.internal.zzj<zzi> {
    private static final zzl zzaaf = new zzl("CastClientImpl");
    private static final Object zzadP = new Object();
    private static final Object zzadQ = new Object();
    private final Cast.Listener zzZP;
    private double zzabs;
    private boolean zzabt;
    private final long zzadA;
    private zzb zzadB;
    private String zzadC;
    private boolean zzadD;
    private boolean zzadE;
    private boolean zzadF;
    private int zzadG;
    private int zzadH;
    private final AtomicLong zzadI;
    private String zzadJ;
    private String zzadK;
    private Bundle zzadL;
    private final Map<Long, com.google.android.gms.common.api.internal.zza.zzb<Status>> zzadM;
    private com.google.android.gms.common.api.internal.zza.zzb<Cast.ApplicationConnectionResult> zzadN;
    private com.google.android.gms.common.api.internal.zza.zzb<Status> zzadO;
    private ApplicationMetadata zzadx;
    private final CastDevice zzady;
    private final Map<String, Cast.MessageReceivedCallback> zzadz;

    private static final class zza implements Cast.ApplicationConnectionResult {
        private final String zzLq;
        private final Status zzUX;
        private final ApplicationMetadata zzadR;
        private final String zzadS;
        private final boolean zzadT;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzUX = status;
            this.zzadR = applicationMetadata;
            this.zzadS = str;
            this.zzLq = str2;
            this.zzadT = z;
        }

        @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
        public ApplicationMetadata getApplicationMetadata() {
            return this.zzadR;
        }

        @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
        public String getApplicationStatus() {
            return this.zzadS;
        }

        @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
        public String getSessionId() {
            return this.zzLq;
        }

        @Override // com.google.android.gms.common.api.Result
        public Status getStatus() {
            return this.zzUX;
        }

        @Override // com.google.android.gms.cast.Cast.ApplicationConnectionResult
        public boolean getWasLaunched() {
            return this.zzadT;
        }
    }

    private static class zzb extends zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzadU;

        public zzb(zze zzeVar) {
            this.zzadU = new AtomicReference<>(zzeVar);
            this.mHandler = new Handler(zzeVar.getLooper());
        }

        private void zza(zze zzeVar, long j, int i) {
            com.google.android.gms.common.api.internal.zza.zzb zzbVar;
            synchronized (zzeVar.zzadM) {
                zzbVar = (com.google.android.gms.common.api.internal.zza.zzb) zzeVar.zzadM.remove(Long.valueOf(j));
            }
            if (zzbVar != null) {
                zzbVar.zzs(new Status(i));
            }
        }

        private boolean zza(zze zzeVar, int i) {
            synchronized (zze.zzadQ) {
                if (zzeVar.zzadO == null) {
                    return false;
                }
                zzeVar.zzadO.zzs(new Status(i));
                zzeVar.zzadO = null;
                return true;
            }
        }

        public boolean isDisposed() {
            return this.zzadU.get() == null;
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void onApplicationDisconnected(final int statusCode) {
            final zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zzeVar.zzadJ = null;
            zzeVar.zzadK = null;
            zza(zzeVar, statusCode);
            if (zzeVar.zzZP != null) {
                this.mHandler.post(new Runnable() { // from class: com.google.android.gms.cast.internal.zze.zzb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzeVar.zzZP.onApplicationDisconnected(statusCode);
                    }
                });
            }
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zzeVar.zzadx = applicationMetadata;
            zzeVar.zzadJ = applicationMetadata.getApplicationId();
            zzeVar.zzadK = str2;
            synchronized (zze.zzadP) {
                if (zzeVar.zzadN != null) {
                    zzeVar.zzadN.zzs(new zza(new Status(0), applicationMetadata, str, str2, z));
                    zzeVar.zzadN = null;
                }
            }
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zza(String str, double d, boolean z) {
            zze.zzaaf.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zza(String str, long j, int i) {
            zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zza(zzeVar, j, i);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzb(final ApplicationStatus applicationStatus) {
            final zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zze.zzaaf.zzb("onApplicationStatusChanged", new Object[0]);
            this.mHandler.post(new Runnable() { // from class: com.google.android.gms.cast.internal.zze.zzb.3
                @Override // java.lang.Runnable
                public void run() {
                    zzeVar.zza(applicationStatus);
                }
            });
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzb(final DeviceStatus deviceStatus) {
            final zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zze.zzaaf.zzb("onDeviceStatusChanged", new Object[0]);
            this.mHandler.post(new Runnable() { // from class: com.google.android.gms.cast.internal.zze.zzb.2
                @Override // java.lang.Runnable
                public void run() {
                    zzeVar.zza(deviceStatus);
                }
            });
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzb(String str, byte[] bArr) {
            if (this.zzadU.get() == null) {
                return;
            }
            zze.zzaaf.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzbk(int i) {
            zze zzeVarZzos = zzos();
            if (zzeVarZzos == null) {
                return;
            }
            zze.zzaaf.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            if (i != 0) {
                zzeVarZzos.zzbS(2);
            }
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzbl(int i) {
            zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            synchronized (zze.zzadP) {
                if (zzeVar.zzadN != null) {
                    zzeVar.zzadN.zzs(new zza(new Status(i)));
                    zzeVar.zzadN = null;
                }
            }
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzbm(int i) {
            zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zza(zzeVar, i);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzbn(int i) {
            zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zza(zzeVar, i);
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzc(String str, long j) {
            zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zza(zzeVar, j, 0);
        }

        public zze zzos() {
            zze andSet = this.zzadU.getAndSet(null);
            if (andSet == null) {
                return null;
            }
            andSet.zzoh();
            return andSet;
        }

        @Override // com.google.android.gms.cast.internal.zzj
        public void zzt(final String str, final String str2) {
            final zze zzeVar = this.zzadU.get();
            if (zzeVar == null) {
                return;
            }
            zze.zzaaf.zzb("Receive (type=text, ns=%s) %s", str, str2);
            this.mHandler.post(new Runnable() { // from class: com.google.android.gms.cast.internal.zze.zzb.4
                @Override // java.lang.Runnable
                public void run() {
                    Cast.MessageReceivedCallback messageReceivedCallback;
                    synchronized (zzeVar.zzadz) {
                        messageReceivedCallback = (Cast.MessageReceivedCallback) zzeVar.zzadz.get(str);
                    }
                    if (messageReceivedCallback != null) {
                        messageReceivedCallback.onMessageReceived(zzeVar.zzady, str, str2);
                    } else {
                        zze.zzaaf.zzb("Discarded message for unknown namespace '%s'", str);
                    }
                }
            });
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, CastDevice castDevice, long j, Cast.Listener listener, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzady = castDevice;
        this.zzZP = listener;
        this.zzadA = j;
        this.zzadz = new HashMap();
        this.zzadI = new AtomicLong(0L);
        this.zzadM = new HashMap();
        zzoh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String strZzoe = applicationStatus.zzoe();
        if (zzf.zza(strZzoe, this.zzadC)) {
            z = false;
        } else {
            this.zzadC = strZzoe;
            z = true;
        }
        zzaaf.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadD));
        if (this.zzZP != null && (z || this.zzadD)) {
            this.zzZP.onApplicationStatusChanged();
        }
        this.zzadD = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(DeviceStatus deviceStatus) {
        boolean z;
        boolean z2;
        boolean z3;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzadx)) {
            this.zzadx = applicationMetadata;
            this.zzZP.onApplicationMetadataChanged(this.zzadx);
        }
        double dZzok = deviceStatus.zzok();
        if (dZzok == Double.NaN || Math.abs(dZzok - this.zzabs) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzabs = dZzok;
            z = true;
        }
        boolean zZzot = deviceStatus.zzot();
        if (zZzot != this.zzabt) {
            this.zzabt = zZzot;
            z = true;
        }
        zzaaf.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z || this.zzadE)) {
            this.zzZP.onVolumeChanged();
        }
        int iZzol = deviceStatus.zzol();
        if (iZzol != this.zzadG) {
            this.zzadG = iZzol;
            z2 = true;
        } else {
            z2 = false;
        }
        zzaaf.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z2 || this.zzadE)) {
            this.zzZP.onActiveInputStateChanged(this.zzadG);
        }
        int iZzom = deviceStatus.zzom();
        if (iZzom != this.zzadH) {
            this.zzadH = iZzom;
            z3 = true;
        } else {
            z3 = false;
        }
        zzaaf.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.zzadE));
        if (this.zzZP != null && (z3 || this.zzadE)) {
            this.zzZP.onStandbyStateChanged(this.zzadH);
        }
        this.zzadE = false;
    }

    private void zza(com.google.android.gms.common.api.internal.zza.zzb<Cast.ApplicationConnectionResult> zzbVar) {
        synchronized (zzadP) {
            if (this.zzadN != null) {
                this.zzadN.zzs(new zza(new Status(2002)));
            }
            this.zzadN = zzbVar;
        }
    }

    private void zzc(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) {
        synchronized (zzadQ) {
            if (this.zzadO != null) {
                zzbVar.zzs(new Status(2001));
            } else {
                this.zzadO = zzbVar;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzoh() {
        this.zzadF = false;
        this.zzadG = -1;
        this.zzadH = -1;
        this.zzadx = null;
        this.zzadC = null;
        this.zzabs = 0.0d;
        this.zzabt = false;
    }

    private void zzon() {
        zzaaf.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzadz) {
            this.zzadz.clear();
        }
    }

    private void zzoo() throws IllegalStateException {
        if (!this.zzadF || this.zzadB == null || this.zzadB.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        zzaaf.zzb("disconnect(); ServiceListener=%s, isConnected=%b", this.zzadB, Boolean.valueOf(isConnected()));
        zzb zzbVar = this.zzadB;
        this.zzadB = null;
        if (zzbVar == null || zzbVar.zzos() == null) {
            zzaaf.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzon();
        try {
            try {
                zzqJ().disconnect();
            } finally {
                super.disconnect();
            }
        } catch (RemoteException | IllegalStateException e) {
            zzaaf.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
            super.disconnect();
        }
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzoo();
        return this.zzadx;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzoo();
        return this.zzadC;
    }

    public boolean isMute() throws IllegalStateException {
        zzoo();
        return this.zzabt;
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        zzon();
    }

    public void zzX(boolean z) throws IllegalStateException, RemoteException {
        zzqJ().zza(z, this.zzabs, this.zzabt);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzaaf.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzadF = true;
            this.zzadD = true;
            this.zzadE = true;
        } else {
            this.zzadF = false;
        }
        if (i == 1001) {
            this.zzadL = new Bundle();
            this.zzadL.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IllegalStateException, RemoteException, IllegalArgumentException {
        zzf.zzch(str);
        zzcg(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzadz) {
                this.zzadz.put(str, messageReceivedCallback);
            }
            zzqJ().zzcl(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.internal.zza.zzb<Cast.ApplicationConnectionResult> zzbVar) throws IllegalStateException, RemoteException {
        zza(zzbVar);
        zzqJ().zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws IllegalStateException, RemoteException {
        zzc(zzbVar);
        zzqJ().zzck(str);
    }

    public void zza(String str, String str2, JoinOptions joinOptions, com.google.android.gms.common.api.internal.zza.zzb<Cast.ApplicationConnectionResult> zzbVar) throws IllegalStateException, RemoteException {
        zza(zzbVar);
        if (joinOptions == null) {
            joinOptions = new JoinOptions();
        }
        zzqJ().zza(str, str2, joinOptions);
    }

    public void zza(String str, String str2, com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws IllegalStateException, RemoteException, IllegalArgumentException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        }
        if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        }
        zzf.zzch(str);
        zzoo();
        long jIncrementAndGet = this.zzadI.incrementAndGet();
        try {
            this.zzadM.put(Long.valueOf(jIncrementAndGet), zzbVar);
            zzqJ().zzb(str, str2, jIncrementAndGet);
        } catch (Throwable th) {
            this.zzadM.remove(Long.valueOf(jIncrementAndGet));
            throw th;
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.common.api.internal.zza.zzb<Cast.ApplicationConnectionResult> zzbVar) throws IllegalStateException, RemoteException {
        LaunchOptions launchOptions = new LaunchOptions();
        launchOptions.setRelaunchIfRunning(z);
        zza(str, launchOptions, zzbVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: zzaE, reason: merged with bridge method [inline-methods] */
    public zzi zzW(IBinder iBinder) {
        return zzi.zza.zzaF(iBinder);
    }

    public void zzb(com.google.android.gms.common.api.internal.zza.zzb<Status> zzbVar) throws IllegalStateException, RemoteException {
        zzc(zzbVar);
        zzqJ().zzou();
    }

    public void zzcg(String str) throws RemoteException, IllegalArgumentException {
        Cast.MessageReceivedCallback messageReceivedCallbackRemove;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzadz) {
            messageReceivedCallbackRemove = this.zzadz.remove(str);
        }
        if (messageReceivedCallbackRemove != null) {
            try {
                zzqJ().zzcm(str);
            } catch (IllegalStateException e) {
                zzaaf.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzf(double d) throws IllegalStateException, RemoteException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        zzqJ().zza(d, this.zzabs, this.zzabt);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgu() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzgv() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzml() {
        Bundle bundle = new Bundle();
        zzaaf.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzadJ, this.zzadK);
        this.zzady.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzadA);
        this.zzadB = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzadB.asBinder()));
        if (this.zzadJ != null) {
            bundle.putString("last_application_id", this.zzadJ);
            if (this.zzadK != null) {
                bundle.putString("last_session_id", this.zzadK);
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.internal.zzk.zza
    public Bundle zzoi() {
        if (this.zzadL == null) {
            return super.zzoi();
        }
        Bundle bundle = this.zzadL;
        this.zzadL = null;
        return bundle;
    }

    public void zzoj() throws IllegalStateException, RemoteException {
        zzqJ().zzoj();
    }

    public double zzok() throws IllegalStateException {
        zzoo();
        return this.zzabs;
    }

    public int zzol() throws IllegalStateException {
        zzoo();
        return this.zzadG;
    }

    public int zzom() throws IllegalStateException {
        zzoo();
        return this.zzadH;
    }
}
