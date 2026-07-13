package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzj<T extends IInterface> implements Api.zzb, zzk.zza {
    public static final String[] zzalJ = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzTI;
    private final Set<Scope> zzXf;
    private final Looper zzagr;
    private final com.google.android.gms.common.zzc zzags;
    private final com.google.android.gms.common.internal.zzf zzahz;
    private GoogleApiClient.zza zzalA;
    private T zzalB;
    private final ArrayList<zzj<T>.zzc<?>> zzalC;
    private zzj<T>.zze zzalD;
    private int zzalE;
    private final GoogleApiClient.ConnectionCallbacks zzalF;
    private final GoogleApiClient.OnConnectionFailedListener zzalG;
    private final int zzalH;
    protected AtomicInteger zzalI;
    private int zzals;
    private long zzalt;
    private long zzalu;
    private int zzalv;
    private long zzalw;
    private final zzl zzalx;
    private final Object zzaly;
    private zzs zzalz;
    private final Object zzpV;

    private abstract class zza extends zzj<T>.zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzalK;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.zzalK = bundle;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.zzj.zzc
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public void zzw(Boolean bool) {
            if (bool == null) {
                zzj.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (zzqL()) {
                        return;
                    }
                    zzj.this.zzb(1, null);
                    zzj(new ConnectionResult(8, null));
                    return;
                case 10:
                    zzj.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzj.this.zzb(1, null);
                    zzj(new ConnectionResult(this.statusCode, this.zzalK != null ? (PendingIntent) this.zzalK.getParcelable("pendingIntent") : null));
                    return;
            }
        }

        protected abstract void zzj(ConnectionResult connectionResult);

        protected abstract boolean zzqL();

        @Override // com.google.android.gms.common.internal.zzj.zzc
        protected void zzqM() {
        }
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.zzqM();
            zzcVar.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (zzj.this.zzalI.get() != msg.arg1) {
                if (zzb(msg)) {
                    zza(msg);
                    return;
                }
                return;
            }
            if ((msg.what == 1 || msg.what == 5) && !zzj.this.isConnecting()) {
                zza(msg);
                return;
            }
            if (msg.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(msg.arg2, null);
                zzj.this.zzalA.zza(connectionResult);
                zzj.this.onConnectionFailed(connectionResult);
                return;
            }
            if (msg.what == 4) {
                zzj.this.zzb(4, null);
                if (zzj.this.zzalF != null) {
                    zzj.this.zzalF.onConnectionSuspended(msg.arg2);
                }
                zzj.this.onConnectionSuspended(msg.arg2);
                zzj.this.zza(4, 1, (IInterface) null);
                return;
            }
            if (msg.what == 2 && !zzj.this.isConnected()) {
                zza(msg);
            } else if (zzb(msg)) {
                ((zzc) msg.obj).zzqN();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + msg.what, new Exception());
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        private boolean zzalM = false;

        public zzc(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzqO();
            synchronized (zzj.this.zzalC) {
                zzj.this.zzalC.remove(this);
            }
        }

        protected abstract void zzqM();

        public void zzqN() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.zzalM) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    zzw(tlistener);
                } catch (RuntimeException e) {
                    zzqM();
                    throw e;
                }
            } else {
                zzqM();
            }
            synchronized (this) {
                this.zzalM = true;
            }
            unregister();
        }

        public void zzqO() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        protected abstract void zzw(TListener tlistener);
    }

    public static final class zzd extends zzr.zza {
        private zzj zzalN;
        private final int zzalO;

        public zzd(@NonNull zzj zzjVar, int i) {
            this.zzalN = zzjVar;
            this.zzalO = i;
        }

        private void zzqP() {
            this.zzalN = null;
        }

        @Override // com.google.android.gms.common.internal.zzr
        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzx.zzb(this.zzalN, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzalN.zza(i, iBinder, bundle, this.zzalO);
            zzqP();
        }

        @Override // com.google.android.gms.common.internal.zzr
        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    public final class zze implements ServiceConnection {
        private final int zzalO;

        public zze(int i) {
            this.zzalO = i;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb(binder, "Expecting a valid IBinder");
            synchronized (zzj.this.zzaly) {
                zzj.this.zzalz = zzs.zza.zzaS(binder);
            }
            zzj.this.zzm(0, this.zzalO);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName component) {
            synchronized (zzj.this.zzaly) {
                zzj.this.zzalz = null;
            }
            zzj.this.mHandler.sendMessage(zzj.this.mHandler.obtainMessage(4, this.zzalO, 1));
        }
    }

    protected class zzf implements GoogleApiClient.zza {
        public zzf() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.zza
        public void zza(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzj.this.zza((zzp) null, zzj.this.zzXf);
            } else if (zzj.this.zzalG != null) {
                zzj.this.zzalG.onConnectionFailed(connectionResult);
            }
        }
    }

    protected final class zzg extends zzj<T>.zza {
        public final IBinder zzalP;

        @BinderThread
        public zzg(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzalP = iBinder;
        }

        @Override // com.google.android.gms.common.internal.zzj.zza
        protected void zzj(ConnectionResult connectionResult) {
            if (zzj.this.zzalG != null) {
                zzj.this.zzalG.onConnectionFailed(connectionResult);
            }
            zzj.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.zzj.zza
        protected boolean zzqL() {
            try {
                String interfaceDescriptor = this.zzalP.getInterfaceDescriptor();
                if (!zzj.this.zzgv().equals(interfaceDescriptor)) {
                    Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzgv() + " vs. " + interfaceDescriptor);
                    return false;
                }
                IInterface iInterfaceZzW = zzj.this.zzW(this.zzalP);
                if (iInterfaceZzW == null || !zzj.this.zza(2, 3, iInterfaceZzW)) {
                    return false;
                }
                Bundle bundleZzoi = zzj.this.zzoi();
                if (zzj.this.zzalF != null) {
                    zzj.this.zzalF.onConnected(bundleZzoi);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zzj<T>.zza {
        @BinderThread
        public zzh(int i) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.zzj.zza
        protected void zzj(ConnectionResult connectionResult) {
            zzj.this.zzalA.zza(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.zzj.zza
        protected boolean zzqL() {
            zzj.this.zzalA.zza(ConnectionResult.zzafB);
            return true;
        }
    }

    protected zzj(Context context, Looper looper, int i, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzau(context), com.google.android.gms.common.zzc.zzoK(), i, zzfVar, (GoogleApiClient.ConnectionCallbacks) zzx.zzz(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzx.zzz(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzlVar, com.google.android.gms.common.zzc zzcVar, int i, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzpV = new Object();
        this.zzaly = new Object();
        this.zzalA = new zzf();
        this.zzalC = new ArrayList<>();
        this.zzalE = 1;
        this.zzalI = new AtomicInteger(0);
        this.mContext = (Context) zzx.zzb(context, "Context must not be null");
        this.zzagr = (Looper) zzx.zzb(looper, "Looper must not be null");
        this.zzalx = (zzl) zzx.zzb(zzlVar, "Supervisor must not be null");
        this.zzags = (com.google.android.gms.common.zzc) zzx.zzb(zzcVar, "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzalH = i;
        this.zzahz = (com.google.android.gms.common.internal.zzf) zzx.zzz(zzfVar);
        this.zzTI = zzfVar.getAccount();
        this.zzXf = zza(zzfVar.zzqt());
        this.zzalF = connectionCallbacks;
        this.zzalG = onConnectionFailedListener;
    }

    private Set<Scope> zza(Set<Scope> set) {
        Set<Scope> setZzb = zzb(set);
        if (setZzb == null) {
            return setZzb;
        }
        Iterator<Scope> it = setZzb.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setZzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzpV) {
            if (this.zzalE != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(int i, T t) {
        zzx.zzac((i == 3) == (t != null));
        synchronized (this.zzpV) {
            this.zzalE = i;
            this.zzalB = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzqF();
                    break;
                case 2:
                    zzqE();
                    break;
                case 3:
                    zza(t);
                    break;
            }
        }
    }

    private void zzqE() {
        if (this.zzalD != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzgu());
            this.zzalx.zzb(zzgu(), this.zzalD, zzqD());
            this.zzalI.incrementAndGet();
        }
        this.zzalD = new zze(this.zzalI.get());
        if (this.zzalx.zza(zzgu(), this.zzalD, zzqD())) {
            return;
        }
        Log.e("GmsClient", "unable to connect to service: " + zzgu());
        zzm(8, this.zzalI.get());
    }

    private void zzqF() {
        if (this.zzalD != null) {
            this.zzalx.zzb(zzgu(), this.zzalD, zzqD());
            this.zzalD = null;
        }
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        this.zzalI.incrementAndGet();
        synchronized (this.zzalC) {
            int size = this.zzalC.size();
            for (int i = 0; i < size; i++) {
                this.zzalC.get(i).zzqO();
            }
            this.zzalC.clear();
        }
        synchronized (this.zzaly) {
            this.zzalz = null;
        }
        zzb(1, null);
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int i;
        T t;
        synchronized (this.zzpV) {
            i = this.zzalE;
            t = this.zzalB;
        }
        writer.append((CharSequence) prefix).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (t == null) {
            writer.println("null");
        } else {
            writer.append((CharSequence) zzgv()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzalu > 0) {
            writer.append((CharSequence) prefix).append("lastConnectedTime=").println(this.zzalu + " " + simpleDateFormat.format(new Date(this.zzalu)));
        }
        if (this.zzalt > 0) {
            writer.append((CharSequence) prefix).append("lastSuspendedCause=");
            switch (this.zzals) {
                case 1:
                    writer.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    writer.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    writer.append((CharSequence) String.valueOf(this.zzals));
                    break;
            }
            writer.append(" lastSuspendedTime=").println(this.zzalt + " " + simpleDateFormat.format(new Date(this.zzalt)));
        }
        if (this.zzalw > 0) {
            writer.append((CharSequence) prefix).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzalv));
            writer.append(" lastFailedTime=").println(this.zzalw + " " + simpleDateFormat.format(new Date(this.zzalw)));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzagr;
    }

    @Override // com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzalE == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpV) {
            z = this.zzalE == 2;
        }
        return z;
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult result) {
        this.zzalv = result.getErrorCode();
        this.zzalw = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int cause) {
        this.zzals = cause;
        this.zzalt = System.currentTimeMillis();
    }

    @Nullable
    protected abstract T zzW(IBinder iBinder);

    @BinderThread
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.zzalu = System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void zza(@NonNull GoogleApiClient.zza zzaVar) {
        this.zzalA = (GoogleApiClient.zza) zzx.zzb(zzaVar, "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    @WorkerThread
    public void zza(zzp zzpVar, Set<Scope> set) {
        try {
            GetServiceRequest getServiceRequestZzj = new GetServiceRequest(this.zzalH).zzcG(this.mContext.getPackageName()).zzj(zzml());
            if (set != null) {
                getServiceRequestZzj.zzd(set);
            }
            if (zzmE()) {
                getServiceRequestZzj.zzc(zzqq()).zzb(zzpVar);
            } else if (zzqK()) {
                getServiceRequestZzj.zzc(this.zzTI);
            }
            synchronized (this.zzaly) {
                try {
                    if (this.zzalz != null) {
                        this.zzalz.zza(new zzd(this, this.zzalI.get()), getServiceRequestZzj);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbS(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    @NonNull
    protected Set<Scope> zzb(@NonNull Set<Scope> set) {
        return set;
    }

    public void zzbS(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzalI.get(), i));
    }

    void zzc(int i, T t) {
    }

    @NonNull
    protected abstract String zzgu();

    @NonNull
    protected abstract String zzgv();

    protected void zzm(int i, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzh(i)));
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public boolean zzmE() {
        return false;
    }

    protected Bundle zzml() {
        return new Bundle();
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public boolean zznb() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public Intent zznc() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    @Nullable
    public IBinder zzoT() {
        IBinder iBinderAsBinder;
        synchronized (this.zzaly) {
            iBinderAsBinder = this.zzalz == null ? null : this.zzalz.asBinder();
        }
        return iBinderAsBinder;
    }

    public Bundle zzoi() {
        return null;
    }

    @Nullable
    protected final String zzqD() {
        return this.zzahz.zzqw();
    }

    public void zzqG() {
        int iIsGooglePlayServicesAvailable = this.zzags.isGooglePlayServicesAvailable(this.mContext);
        if (iIsGooglePlayServicesAvailable == 0) {
            zza(new zzf());
            return;
        }
        zzb(1, null);
        this.zzalA = new zzf();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzalI.get(), iIsGooglePlayServicesAvailable));
    }

    protected final com.google.android.gms.common.internal.zzf zzqH() {
        return this.zzahz;
    }

    protected final void zzqI() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzqJ() throws DeadObjectException {
        T t;
        synchronized (this.zzpV) {
            if (this.zzalE == 4) {
                throw new DeadObjectException();
            }
            zzqI();
            zzx.zza(this.zzalB != null, "Client is connected but service is null");
            t = this.zzalB;
        }
        return t;
    }

    public boolean zzqK() {
        return false;
    }

    public final Account zzqq() {
        return this.zzTI != null ? this.zzTI : new Account("<<default account>>", "com.google");
    }
}
