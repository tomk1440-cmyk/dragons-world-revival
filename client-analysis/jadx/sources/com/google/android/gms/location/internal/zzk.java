package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzk {
    private final Context mContext;
    private final zzp<zzi> zzaOt;
    private ContentProviderClient zzaOG = null;
    private boolean zzaOH = false;
    private Map<LocationListener, zzc> zzaxd = new HashMap();
    private Map<LocationCallback, zza> zzaOI = new HashMap();

    private static class zza extends com.google.android.gms.location.zzc.zza {
        private Handler zzaOJ;

        zza(final LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzx.zza(looper != null, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaOJ = new Handler(looper) { // from class: com.google.android.gms.location.internal.zzk.zza.1
                @Override // android.os.Handler
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 0:
                            locationCallback.onLocationResult((LocationResult) msg.obj);
                            break;
                        case 1:
                            locationCallback.onLocationAvailability((LocationAvailability) msg.obj);
                            break;
                    }
                }
            };
        }

        private void zzb(int i, Object obj) {
            if (this.zzaOJ == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.obj = obj;
            this.zzaOJ.sendMessage(messageObtain);
        }

        @Override // com.google.android.gms.location.zzc
        public void onLocationAvailability(LocationAvailability state) {
            zzb(1, state);
        }

        @Override // com.google.android.gms.location.zzc
        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public void release() {
            this.zzaOJ = null;
        }
    }

    private static class zzb extends Handler {
        private final LocationListener zzaOL;

        public zzb(LocationListener locationListener) {
            this.zzaOL = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.zzaOL = locationListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzaOL.onLocationChanged(new Location((Location) msg.obj));
                    break;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    break;
            }
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza {
        private Handler zzaOJ;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzx.zza(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaOJ = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        @Override // com.google.android.gms.location.zzd
        public void onLocationChanged(Location location) {
            if (this.zzaOJ == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = location;
            this.zzaOJ.sendMessage(messageObtain);
        }

        public void release() {
            this.zzaOJ = null;
        }
    }

    public zzk(Context context, zzp<zzi> zzpVar) {
        this.mContext = context;
        this.zzaOt = zzpVar;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza zzaVar;
        synchronized (this.zzaOI) {
            zzaVar = this.zzaOI.get(locationCallback);
            if (zzaVar == null) {
                zzaVar = new zza(locationCallback, looper);
            }
            this.zzaOI.put(locationCallback, zzaVar);
        }
        return zzaVar;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc zzcVar;
        synchronized (this.zzaxd) {
            zzcVar = this.zzaxd.get(locationListener);
            if (zzcVar == null) {
                zzcVar = new zzc(locationListener, looper);
            }
            this.zzaxd.put(locationListener, zzcVar);
        }
        return zzcVar;
    }

    public Location getLastLocation() {
        this.zzaOt.zzqI();
        try {
            return ((zzi) this.zzaOt.zzqJ()).zzei(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.zzaxd) {
                for (zzc zzcVar : this.zzaxd.values()) {
                    if (zzcVar != null) {
                        ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(zzcVar, (zzg) null));
                    }
                }
                this.zzaxd.clear();
            }
            synchronized (this.zzaOI) {
                for (zza zzaVar : this.zzaOI.values()) {
                    if (zzaVar != null) {
                        ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(zzaVar, (zzg) null));
                    }
                }
                this.zzaOI.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zzb(pendingIntent, zzgVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        zzx.zzb(locationCallback, "Invalid null callback");
        synchronized (this.zzaOI) {
            zza zzaVarRemove = this.zzaOI.remove(locationCallback);
            if (zzaVarRemove != null) {
                zzaVarRemove.release();
                ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(zzaVarRemove, zzgVar));
            }
        }
    }

    public void zza(LocationListener locationListener, zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        zzx.zzb(locationListener, "Invalid null listener");
        synchronized (this.zzaxd) {
            zzc zzcVarRemove = this.zzaxd.remove(locationListener);
            if (this.zzaOG != null && this.zzaxd.isEmpty()) {
                this.zzaOG.release();
                this.zzaOG = null;
            }
            if (zzcVarRemove != null) {
                zzcVarRemove.release();
                ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(zzcVarRemove, zzgVar));
            }
        }
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), pendingIntent, zzgVar));
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), zza(locationListener, looper), zzgVar));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zza(LocationRequestUpdateData.zza(locationRequestInternal, zza(locationCallback, looper), zzgVar));
    }

    public void zza(zzg zzgVar) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zza(zzgVar);
    }

    public void zzam(boolean z) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zzam(z);
        this.zzaOH = z;
    }

    public void zzc(Location location) throws RemoteException {
        this.zzaOt.zzqI();
        ((zzi) this.zzaOt.zzqJ()).zzc(location);
    }

    public LocationAvailability zzyO() {
        this.zzaOt.zzqI();
        try {
            return ((zzi) this.zzaOt.zzqJ()).zzej(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzyP() {
        if (this.zzaOH) {
            try {
                zzam(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
