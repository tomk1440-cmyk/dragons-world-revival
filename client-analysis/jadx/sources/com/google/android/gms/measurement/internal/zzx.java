package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.os.Process;
import android.support.annotation.BinderThread;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class zzx extends zzm.zza {
    private final zzw zzaTV;
    private final boolean zzaYw;

    public zzx(zzw zzwVar) {
        com.google.android.gms.common.internal.zzx.zzz(zzwVar);
        this.zzaTV = zzwVar;
        this.zzaYw = false;
    }

    public zzx(zzw zzwVar, boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(zzwVar);
        this.zzaTV = zzwVar;
        this.zzaYw = z;
    }

    @BinderThread
    private void zzfm(String str) throws SecurityException {
        if (TextUtils.isEmpty(str)) {
            this.zzaTV.zzAo().zzCE().zzfg("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        try {
            zzfn(str);
        } catch (SecurityException e) {
            this.zzaTV.zzAo().zzCE().zzj("Measurement Service called with invalid calling package", str);
            throw e;
        }
    }

    private void zzfn(String str) throws SecurityException {
        int iMyUid = this.zzaYw ? Process.myUid() : Binder.getCallingUid();
        if (com.google.android.gms.common.zze.zzb(this.zzaTV.getContext(), iMyUid, str)) {
            return;
        }
        if (!com.google.android.gms.common.zze.zzf(this.zzaTV.getContext(), iMyUid) || this.zzaTV.zzCZ()) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    @BinderThread
    public List<UserAttributeParcel> zza(final AppMetadata appMetadata, boolean z) {
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        zzfm(appMetadata.packageName);
        try {
            List<zzai> list = (List) this.zzaTV.zzCn().zzd(new Callable<List<zzai>>() { // from class: com.google.android.gms.measurement.internal.zzx.6
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzDh, reason: merged with bridge method [inline-methods] */
                public List<zzai> call() throws Exception {
                    return zzx.this.zzaTV.zzCj().zzeX(appMetadata.zzaVt);
                }
            }).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzai zzaiVar : list) {
                if (z || !zzaj.zzfv(zzaiVar.mName)) {
                    arrayList.add(new UserAttributeParcel(zzaiVar));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zzaTV.zzAo().zzCE().zzj("Failed to get user attributes", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    @BinderThread
    public void zza(final AppMetadata appMetadata) {
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        zzfm(appMetadata.packageName);
        this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzx.7
            @Override // java.lang.Runnable
            public void run() {
                zzx.this.zzfl(appMetadata.zzaVx);
                zzx.this.zzaTV.zzd(appMetadata);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    @BinderThread
    public void zza(final EventParcel eventParcel, final AppMetadata appMetadata) {
        com.google.android.gms.common.internal.zzx.zzz(eventParcel);
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        zzfm(appMetadata.packageName);
        this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzx.2
            @Override // java.lang.Runnable
            public void run() {
                zzx.this.zzfl(appMetadata.zzaVx);
                zzx.this.zzaTV.zzb(eventParcel, appMetadata);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    @BinderThread
    public void zza(final EventParcel eventParcel, final String str, final String str2) {
        com.google.android.gms.common.internal.zzx.zzz(eventParcel);
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzfm(str);
        this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzx.3
            @Override // java.lang.Runnable
            public void run() {
                zzx.this.zzfl(str2);
                zzx.this.zzaTV.zza(eventParcel, str);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    @BinderThread
    public void zza(final UserAttributeParcel userAttributeParcel, final AppMetadata appMetadata) {
        com.google.android.gms.common.internal.zzx.zzz(userAttributeParcel);
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        zzfm(appMetadata.packageName);
        if (userAttributeParcel.getValue() == null) {
            this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzx.4
                @Override // java.lang.Runnable
                public void run() {
                    zzx.this.zzfl(appMetadata.zzaVx);
                    zzx.this.zzaTV.zzc(userAttributeParcel, appMetadata);
                }
            });
        } else {
            this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzx.5
                @Override // java.lang.Runnable
                public void run() {
                    zzx.this.zzfl(appMetadata.zzaVx);
                    zzx.this.zzaTV.zzb(userAttributeParcel, appMetadata);
                }
            });
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzm
    @BinderThread
    public void zzb(final AppMetadata appMetadata) {
        com.google.android.gms.common.internal.zzx.zzz(appMetadata);
        zzfm(appMetadata.packageName);
        this.zzaTV.zzCn().zzg(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzx.1
            @Override // java.lang.Runnable
            public void run() {
                zzx.this.zzfl(appMetadata.zzaVx);
                zzx.this.zzaTV.zzc(appMetadata);
            }
        });
    }

    @WorkerThread
    void zzfl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(":", 2);
        if (strArrSplit.length == 2) {
            try {
                long jLongValue = Long.valueOf(strArrSplit[0]).longValue();
                if (jLongValue > 0) {
                    this.zzaTV.zzCo().zzaXi.zzf(strArrSplit[1], jLongValue);
                } else {
                    this.zzaTV.zzAo().zzCF().zzj("Combining sample with a non-positive weight", Long.valueOf(jLongValue));
                }
            } catch (NumberFormatException e) {
                this.zzaTV.zzAo().zzCF().zzj("Combining sample with a non-number weight", strArrSplit[0]);
            }
        }
    }
}
