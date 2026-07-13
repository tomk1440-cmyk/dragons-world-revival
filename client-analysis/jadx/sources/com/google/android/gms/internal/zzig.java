package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzig {
    private boolean zzJu;
    private final LinkedList<zza> zzLf;
    private final String zzLg;
    private final String zzLh;
    private long zzLi;
    private long zzLj;
    private long zzLk;
    private long zzLl;
    private long zzLm;
    private long zzLn;
    private final Object zzpV;
    private final zzih zzqV;

    @zzhb
    private static final class zza {
        private long zzLo = -1;
        private long zzLp = -1;

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.zzLo);
            bundle.putLong("tclose", this.zzLp);
            return bundle;
        }

        public long zzgV() {
            return this.zzLp;
        }

        public void zzgW() {
            this.zzLp = SystemClock.elapsedRealtime();
        }

        public void zzgX() {
            this.zzLo = SystemClock.elapsedRealtime();
        }
    }

    public zzig(zzih zzihVar, String str, String str2) {
        this.zzpV = new Object();
        this.zzLi = -1L;
        this.zzLj = -1L;
        this.zzJu = false;
        this.zzLk = -1L;
        this.zzLl = 0L;
        this.zzLm = -1L;
        this.zzLn = -1L;
        this.zzqV = zzihVar;
        this.zzLg = str;
        this.zzLh = str2;
        this.zzLf = new LinkedList<>();
    }

    public zzig(String str, String str2) {
        this(com.google.android.gms.ads.internal.zzr.zzbF(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzpV) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzLg);
            bundle.putString("slotid", this.zzLh);
            bundle.putBoolean("ismediation", this.zzJu);
            bundle.putLong("treq", this.zzLm);
            bundle.putLong("tresponse", this.zzLn);
            bundle.putLong("timp", this.zzLj);
            bundle.putLong("tload", this.zzLk);
            bundle.putLong("pcc", this.zzLl);
            bundle.putLong("tfetch", this.zzLi);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zza> it = this.zzLf.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzA(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzLn != -1) {
                this.zzJu = z;
                this.zzqV.zza(this);
            }
        }
    }

    public void zzgS() {
        synchronized (this.zzpV) {
            if (this.zzLn != -1 && this.zzLj == -1) {
                this.zzLj = SystemClock.elapsedRealtime();
                this.zzqV.zza(this);
            }
            this.zzqV.zzha().zzgS();
        }
    }

    public void zzgT() {
        synchronized (this.zzpV) {
            if (this.zzLn != -1) {
                zza zzaVar = new zza();
                zzaVar.zzgX();
                this.zzLf.add(zzaVar);
                this.zzLl++;
                this.zzqV.zzha().zzgT();
                this.zzqV.zza(this);
            }
        }
    }

    public void zzgU() {
        synchronized (this.zzpV) {
            if (this.zzLn != -1 && !this.zzLf.isEmpty()) {
                zza last = this.zzLf.getLast();
                if (last.zzgV() == -1) {
                    last.zzgW();
                    this.zzqV.zza(this);
                }
            }
        }
    }

    public void zzk(AdRequestParcel adRequestParcel) {
        synchronized (this.zzpV) {
            this.zzLm = SystemClock.elapsedRealtime();
            this.zzqV.zzha().zzb(adRequestParcel, this.zzLm);
        }
    }

    public void zzl(long j) {
        synchronized (this.zzpV) {
            this.zzLn = j;
            if (this.zzLn != -1) {
                this.zzqV.zza(this);
            }
        }
    }

    public void zzm(long j) {
        synchronized (this.zzpV) {
            if (this.zzLn != -1) {
                this.zzLi = j;
                this.zzqV.zza(this);
            }
        }
    }

    public void zzz(boolean z) {
        synchronized (this.zzpV) {
            if (this.zzLn != -1) {
                this.zzLk = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzLj = this.zzLk;
                    this.zzqV.zza(this);
                }
            }
        }
    }
}
