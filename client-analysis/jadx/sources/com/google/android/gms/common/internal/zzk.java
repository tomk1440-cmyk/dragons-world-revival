package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Handler.Callback {
    private final Handler mHandler;
    private final zza zzalQ;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalR = new ArrayList<>();
    final ArrayList<GoogleApiClient.ConnectionCallbacks> zzalS = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzalT = new ArrayList<>();
    private volatile boolean zzalU = false;
    private final AtomicInteger zzalV = new AtomicInteger(0);
    private boolean zzalW = false;
    private final Object zzpV = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzoi();
    }

    public zzk(Looper looper, zza zzaVar) {
        this.zzalQ = zzaVar;
        this.mHandler = new Handler(looper, this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (msg.what != 1) {
            Log.wtf("GmsClientEvents", "Don't know how to handle message: " + msg.what, new Exception());
            return false;
        }
        GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) msg.obj;
        synchronized (this.zzpV) {
            if (this.zzalU && this.zzalQ.isConnected() && this.zzalR.contains(connectionCallbacks)) {
                connectionCallbacks.onConnected(this.zzalQ.zzoi());
            }
        }
        return true;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks listener) {
        boolean zContains;
        zzx.zzz(listener);
        synchronized (this.zzpV) {
            zContains = this.zzalR.contains(listener);
        }
        return zContains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener listener) {
        boolean zContains;
        zzx.zzz(listener);
        synchronized (this.zzpV) {
            zContains = this.zzalT.contains(listener);
        }
        return zContains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        zzx.zzz(listener);
        synchronized (this.zzpV) {
            if (this.zzalR.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.zzalR.add(listener);
            }
        }
        if (this.zzalQ.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        zzx.zzz(listener);
        synchronized (this.zzpV) {
            if (this.zzalT.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.zzalT.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks listener) {
        zzx.zzz(listener);
        synchronized (this.zzpV) {
            if (!this.zzalR.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
            } else if (this.zzalW) {
                this.zzalS.add(listener);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener listener) {
        zzx.zzz(listener);
        synchronized (this.zzpV) {
            if (!this.zzalT.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }

    public void zzbT(int i) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpV) {
            this.zzalW = true;
            ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(this.zzalR);
            int i2 = this.zzalV.get();
            for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                if (!this.zzalU || this.zzalV.get() != i2) {
                    break;
                } else if (this.zzalR.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzalS.clear();
            this.zzalW = false;
        }
    }

    public void zzk(Bundle bundle) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzpV) {
            zzx.zzab(!this.zzalW);
            this.mHandler.removeMessages(1);
            this.zzalW = true;
            zzx.zzab(this.zzalS.size() == 0);
            ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList = new ArrayList(this.zzalR);
            int i = this.zzalV.get();
            for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : arrayList) {
                if (!this.zzalU || !this.zzalQ.isConnected() || this.zzalV.get() != i) {
                    break;
                } else if (!this.zzalS.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzalS.clear();
            this.zzalW = false;
        }
    }

    public void zzk(ConnectionResult connectionResult) {
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionFailure must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpV) {
            ArrayList<GoogleApiClient.OnConnectionFailedListener> arrayList = new ArrayList(this.zzalT);
            int i = this.zzalV.get();
            for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : arrayList) {
                if (!this.zzalU || this.zzalV.get() != i) {
                    return;
                }
                if (this.zzalT.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public void zzqQ() {
        this.zzalU = false;
        this.zzalV.incrementAndGet();
    }

    public void zzqR() {
        this.zzalU = true;
    }
}
