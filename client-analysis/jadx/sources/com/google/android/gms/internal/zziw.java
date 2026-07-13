package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zziw {
    private static zzl zzMy;
    private static final Object zzqy = new Object();
    public static final zza<Void> zzMz = new zza() { // from class: com.google.android.gms.internal.zziw.1
        @Override // com.google.android.gms.internal.zziw.zza
        /* JADX INFO: renamed from: zzhB, reason: merged with bridge method [inline-methods] */
        public Void zzgp() {
            return null;
        }

        @Override // com.google.android.gms.internal.zziw.zza
        /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
        public Void zzh(InputStream inputStream) {
            return null;
        }
    };

    public interface zza<T> {
        T zzgp();

        T zzh(InputStream inputStream);
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzMD;
        private final zzm.zzb<T> zzaG;

        public zzb(String str, final zza<T> zzaVar, final zzm.zzb<T> zzbVar) {
            super(0, str, new zzm.zza() { // from class: com.google.android.gms.internal.zziw.zzb.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.android.gms.internal.zzm.zza
                public void zze(zzr zzrVar) {
                    zzbVar.zzb(zzaVar.zzgp());
                }
            });
            this.zzMD = zzaVar;
            this.zzaG = zzbVar;
        }

        @Override // com.google.android.gms.internal.zzk
        protected zzm<InputStream> zza(zzi zziVar) {
            return zzm.zza(new ByteArrayInputStream(zziVar.data), zzx.zzb(zziVar));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzk
        /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
        public void zza(InputStream inputStream) {
            this.zzaG.zzb(this.zzMD.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzjd<T> implements zzm.zzb<T> {
        private zzc() {
        }

        @Override // com.google.android.gms.internal.zzm.zzb
        public void zzb(T t) {
            super.zzg(t);
        }
    }

    public zziw(Context context) {
        zzMy = zzS(context);
    }

    private static zzl zzS(Context context) {
        zzl zzlVar;
        synchronized (zzqy) {
            if (zzMy == null) {
                zzMy = zzac.zza(context.getApplicationContext());
            }
            zzlVar = zzMy;
        }
        return zzlVar;
    }

    public <T> zzjg<T> zza(String str, zza<T> zzaVar) {
        zzc zzcVar = new zzc();
        zzMy.zze(new zzb(str, zzaVar, zzcVar));
        return zzcVar;
    }

    public zzjg<String> zzb(final String str, final Map<String, String> map) {
        final zzc zzcVar = new zzc();
        zzMy.zze(new zzab(str, zzcVar, new zzm.zza() { // from class: com.google.android.gms.internal.zziw.2
            @Override // com.google.android.gms.internal.zzm.zza
            public void zze(zzr zzrVar) {
                zzin.zzaK("Failed to load URL: " + str + "\n" + zzrVar.toString());
                zzcVar.zzb((Object) null);
            }
        }) { // from class: com.google.android.gms.internal.zziw.3
            @Override // com.google.android.gms.internal.zzk
            public Map<String, String> getHeaders() throws com.google.android.gms.internal.zza {
                return map == null ? super.getHeaders() : map;
            }
        });
        return zzcVar;
    }
}
