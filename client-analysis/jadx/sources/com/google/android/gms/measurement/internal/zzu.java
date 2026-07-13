package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzsm;
import com.google.android.gms.internal.zzsn;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzu extends zzz {
    private final Map<String, Map<String, String>> zzaXF;
    private final Map<String, Map<String, Boolean>> zzaXG;
    private final Map<String, zzqa.zzb> zzaXH;

    zzu(zzw zzwVar) {
        super(zzwVar);
        this.zzaXF = new ArrayMap();
        this.zzaXG = new ArrayMap();
        this.zzaXH = new ArrayMap();
    }

    private Map<String, String> zza(zzqa.zzb zzbVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzbVar != null && zzbVar.zzaZV != null) {
            for (zzqa.zzc zzcVar : zzbVar.zzaZV) {
                if (zzcVar != null) {
                    arrayMap.put(zzcVar.key, zzcVar.value);
                }
            }
        }
        return arrayMap;
    }

    private Map<String, Boolean> zzb(zzqa.zzb zzbVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzbVar != null && zzbVar.zzaZW != null) {
            for (zzqa.zza zzaVar : zzbVar.zzaZW) {
                if (zzaVar != null) {
                    arrayMap.put(zzaVar.name, zzaVar.zzaZS);
                }
            }
        }
        return arrayMap;
    }

    @WorkerThread
    private zzqa.zzb zzf(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzqa.zzb();
        }
        zzsm zzsmVarZzD = zzsm.zzD(bArr);
        zzqa.zzb zzbVar = new zzqa.zzb();
        try {
            zzbVar.mergeFrom(zzsmVarZzD);
            zzAo().zzCK().zze("Parsed config. version, gmp_app_id", zzbVar.zzaZT, zzbVar.zzaVt);
            return zzbVar;
        } catch (IOException e) {
            zzAo().zzCF().zze("Unable to merge remote config", str, e);
            return null;
        }
    }

    @WorkerThread
    private void zzfj(String str) throws Throwable {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        if (this.zzaXH.containsKey(str)) {
            return;
        }
        byte[] bArrZzfa = zzCj().zzfa(str);
        if (bArrZzfa == null) {
            this.zzaXF.put(str, null);
            this.zzaXG.put(str, null);
            this.zzaXH.put(str, null);
        } else {
            zzqa.zzb zzbVarZzf = zzf(str, bArrZzfa);
            this.zzaXF.put(str, zza(zzbVarZzf));
            this.zzaXG.put(str, zzb(zzbVarZzf));
            this.zzaXH.put(str, zzbVarZzf);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzp zzAo() {
        return super.zzAo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzCd() {
        super.zzCd();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzc zzCe() {
        return super.zzCe();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzab zzCf() {
        return super.zzCf();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzn zzCg() {
        return super.zzCg();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzg zzCh() {
        return super.zzCh();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzac zzCi() {
        return super.zzCi();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zze zzCj() {
        return super.zzCj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzaj zzCk() {
        return super.zzCk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzu zzCl() {
        return super.zzCl();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzad zzCm() {
        return super.zzCm();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzv zzCn() {
        return super.zzCn();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzt zzCo() {
        return super.zzCo();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzd zzCp() {
        return super.zzCp();
    }

    @WorkerThread
    String zzO(String str, String str2) {
        zzjk();
        zzfj(str);
        Map<String, String> map = this.zzaXF.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @WorkerThread
    boolean zzP(String str, String str2) throws Throwable {
        Boolean bool;
        zzjk();
        zzfj(str);
        Map<String, Boolean> map = this.zzaXG.get(str);
        if (map != null && (bool = map.get(str2)) != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @WorkerThread
    protected boolean zze(String str, byte[] bArr) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzqa.zzb zzbVarZzf = zzf(str, bArr);
        if (zzbVarZzf == null) {
            return false;
        }
        this.zzaXG.put(str, zzb(zzbVarZzf));
        this.zzaXH.put(str, zzbVarZzf);
        this.zzaXF.put(str, zza(zzbVarZzf));
        zzCe().zza(str, zzbVarZzf.zzaZX);
        try {
            zzbVarZzf.zzaZX = null;
            byte[] bArr2 = new byte[zzbVarZzf.getSerializedSize()];
            zzbVarZzf.writeTo(zzsn.zzE(bArr2));
            bArr = bArr2;
        } catch (IOException e) {
            zzAo().zzCF().zzj("Unable to serialize reduced-size config.  Storing full config instead.", e);
        }
        zzCj().zzd(str, bArr);
        return true;
    }

    @WorkerThread
    protected zzqa.zzb zzfk(String str) {
        zzjv();
        zzjk();
        com.google.android.gms.common.internal.zzx.zzcM(str);
        zzfj(str);
        return this.zzaXH.get(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzz
    protected void zziJ() {
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjj() {
        super.zzjj();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ void zzjk() {
        super.zzjk();
    }

    @Override // com.google.android.gms.measurement.internal.zzy
    public /* bridge */ /* synthetic */ zzmq zzjl() {
        return super.zzjl();
    }
}
