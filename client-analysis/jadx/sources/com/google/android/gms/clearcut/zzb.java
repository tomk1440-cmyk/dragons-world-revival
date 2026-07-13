package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzlw;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzb {
    private final Context mContext;
    private final String zzTJ;
    private final int zzaeR;
    private String zzaeS;
    private int zzaeT;
    private String zzaeU;
    private String zzaeV;
    private final boolean zzaeW;
    private int zzaeX;
    private final com.google.android.gms.clearcut.zzc zzaeY;
    private final com.google.android.gms.clearcut.zza zzaeZ;
    private zzc zzafa;
    private final zzmq zzqW;
    public static final Api.zzc<zzlw> zzUI = new Api.zzc<>();
    public static final Api.zza<zzlw, Api.ApiOptions.NoOptions> zzUJ = new Api.zza<zzlw, Api.ApiOptions.NoOptions>() { // from class: com.google.android.gms.clearcut.zzb.1
        @Override // com.google.android.gms.common.api.Api.zza
        /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
        public zzlw zza(Context context, Looper looper, zzf zzfVar, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzlw(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener);
        }
    };
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", zzUJ, zzUI);
    public static final com.google.android.gms.clearcut.zzc zzaeQ = new zzlv();

    public class zza {
        private String zzaeS;
        private int zzaeT;
        private String zzaeU;
        private String zzaeV;
        private int zzaeX;
        private final InterfaceC0048zzb zzafb;
        private InterfaceC0048zzb zzafc;
        private ArrayList<Integer> zzafd;
        private final zzsz.zzd zzafe;
        private boolean zzaff;

        private zza(zzb zzbVar, byte[] bArr) {
            this(bArr, (InterfaceC0048zzb) null);
        }

        private zza(byte[] bArr, InterfaceC0048zzb interfaceC0048zzb) {
            this.zzaeT = zzb.this.zzaeT;
            this.zzaeS = zzb.this.zzaeS;
            this.zzaeU = zzb.this.zzaeU;
            this.zzaeV = zzb.this.zzaeV;
            this.zzaeX = zzb.this.zzaeX;
            this.zzafd = null;
            this.zzafe = new zzsz.zzd();
            this.zzaff = false;
            this.zzaeU = zzb.this.zzaeU;
            this.zzaeV = zzb.this.zzaeV;
            this.zzafe.zzbuR = zzb.this.zzqW.currentTimeMillis();
            this.zzafe.zzbuS = zzb.this.zzqW.elapsedRealtime();
            this.zzafe.zzbvi = zzb.this.zzaeZ.zzah(zzb.this.mContext);
            this.zzafe.zzbvd = zzb.this.zzafa.zzC(this.zzafe.zzbuR);
            if (bArr != null) {
                this.zzafe.zzbuY = bArr;
            }
            this.zzafb = interfaceC0048zzb;
        }

        public zza zzbq(int i) {
            this.zzafe.zzbuU = i;
            return this;
        }

        public zza zzbr(int i) {
            this.zzafe.zzob = i;
            return this;
        }

        public PendingResult<Status> zzd(GoogleApiClient googleApiClient) {
            if (this.zzaff) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.zzaff = true;
            return zzb.this.zzaeY.zza(googleApiClient, zzoE());
        }

        public LogEventParcelable zzoE() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.zzTJ, zzb.this.zzaeR, this.zzaeT, this.zzaeS, this.zzaeU, this.zzaeV, zzb.this.zzaeW, this.zzaeX), this.zzafe, this.zzafb, this.zzafc, zzb.zzb(this.zzafd));
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.clearcut.zzb$zzb, reason: collision with other inner class name */
    public interface InterfaceC0048zzb {
        byte[] zzoF();
    }

    public static class zzc {
        public long zzC(long j) {
            return TimeZone.getDefault().getOffset(j) / 1000;
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, com.google.android.gms.clearcut.zzc zzcVar, zzmq zzmqVar, zzc zzcVar2, com.google.android.gms.clearcut.zza zzaVar) {
        this.zzaeT = -1;
        this.zzaeX = 0;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext == null ? context : applicationContext;
        this.zzTJ = context.getPackageName();
        this.zzaeR = zzai(context);
        this.zzaeT = i;
        this.zzaeS = str;
        this.zzaeU = str2;
        this.zzaeV = str3;
        this.zzaeW = z;
        this.zzaeY = zzcVar;
        this.zzqW = zzmqVar;
        this.zzafa = zzcVar2 == null ? new zzc() : zzcVar2;
        this.zzaeZ = zzaVar;
        this.zzaeX = 0;
        if (this.zzaeW) {
            zzx.zzb(this.zzaeU == null, "can't be anonymous with an upload account");
        }
    }

    @Deprecated
    public zzb(Context context, String str, String str2, String str3) {
        this(context, -1, str, str2, str3, false, zzaeQ, zzmt.zzsc(), null, com.google.android.gms.clearcut.zza.zzaeP);
    }

    private int zzai(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator<Integer> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            i = i2 + 1;
            iArr[i2] = it.next().intValue();
        }
    }

    public boolean zza(GoogleApiClient googleApiClient, long j, TimeUnit timeUnit) {
        return this.zzaeY.zza(googleApiClient, j, timeUnit);
    }

    public zza zzi(byte[] bArr) {
        return new zza(bArr);
    }
}
