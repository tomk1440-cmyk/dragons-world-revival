package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class zzai extends zzd {
    private SharedPreferences zzTh;
    private long zzTi;
    private long zzTj;
    private final zza zzTk;

    public final class zza {
        private final String mName;
        private final long zzTl;

        private zza(String str, long j) {
            com.google.android.gms.common.internal.zzx.zzcM(str);
            com.google.android.gms.common.internal.zzx.zzac(j > 0);
            this.mName = str;
            this.zzTl = j;
        }

        private void zzlL() {
            long jCurrentTimeMillis = zzai.this.zzjl().currentTimeMillis();
            SharedPreferences.Editor editorEdit = zzai.this.zzTh.edit();
            editorEdit.remove(zzlQ());
            editorEdit.remove(zzlR());
            editorEdit.putLong(zzlP(), jCurrentTimeMillis);
            editorEdit.commit();
        }

        private long zzlM() {
            long jZzlO = zzlO();
            if (jZzlO == 0) {
                return 0L;
            }
            return Math.abs(jZzlO - zzai.this.zzjl().currentTimeMillis());
        }

        private long zzlO() {
            return zzai.this.zzTh.getLong(zzlP(), 0L);
        }

        private String zzlP() {
            return this.mName + ":start";
        }

        private String zzlQ() {
            return this.mName + ":count";
        }

        public void zzbq(String str) {
            if (zzlO() == 0) {
                zzlL();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = zzai.this.zzTh.getLong(zzlQ(), 0L);
                if (j <= 0) {
                    SharedPreferences.Editor editorEdit = zzai.this.zzTh.edit();
                    editorEdit.putString(zzlR(), str);
                    editorEdit.putLong(zzlQ(), 1L);
                    editorEdit.apply();
                    return;
                }
                boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1);
                SharedPreferences.Editor editorEdit2 = zzai.this.zzTh.edit();
                if (z) {
                    editorEdit2.putString(zzlR(), str);
                }
                editorEdit2.putLong(zzlQ(), j + 1);
                editorEdit2.apply();
            }
        }

        public Pair<String, Long> zzlN() {
            long jZzlM = zzlM();
            if (jZzlM < this.zzTl) {
                return null;
            }
            if (jZzlM > this.zzTl * 2) {
                zzlL();
                return null;
            }
            String string = zzai.this.zzTh.getString(zzlR(), null);
            long j = zzai.this.zzTh.getLong(zzlQ(), 0L);
            zzlL();
            if (string == null || j <= 0) {
                return null;
            }
            return new Pair<>(string, Long.valueOf(j));
        }

        protected String zzlR() {
            return this.mName + ":value";
        }
    }

    protected zzai(zzf zzfVar) {
        super(zzfVar);
        this.zzTj = -1L;
        this.zzTk = new zza("monitoring", zzjn().zzkX());
    }

    public void zzbp(String str) {
        zzjk();
        zzjv();
        SharedPreferences.Editor editorEdit = this.zzTh.edit();
        if (TextUtils.isEmpty(str)) {
            editorEdit.remove("installation_campaign");
        } else {
            editorEdit.putString("installation_campaign", str);
        }
        if (editorEdit.commit()) {
            return;
        }
        zzbg("Failed to commit campaign data");
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zziJ() {
        this.zzTh = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzlF() {
        zzjk();
        zzjv();
        if (this.zzTi == 0) {
            long j = this.zzTh.getLong("first_run", 0L);
            if (j != 0) {
                this.zzTi = j;
            } else {
                long jCurrentTimeMillis = zzjl().currentTimeMillis();
                SharedPreferences.Editor editorEdit = this.zzTh.edit();
                editorEdit.putLong("first_run", jCurrentTimeMillis);
                if (!editorEdit.commit()) {
                    zzbg("Failed to commit first run time");
                }
                this.zzTi = jCurrentTimeMillis;
            }
        }
        return this.zzTi;
    }

    public zzaj zzlG() {
        return new zzaj(zzjl(), zzlF());
    }

    public long zzlH() {
        zzjk();
        zzjv();
        if (this.zzTj == -1) {
            this.zzTj = this.zzTh.getLong("last_dispatch", 0L);
        }
        return this.zzTj;
    }

    public void zzlI() {
        zzjk();
        zzjv();
        long jCurrentTimeMillis = zzjl().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zzTh.edit();
        editorEdit.putLong("last_dispatch", jCurrentTimeMillis);
        editorEdit.apply();
        this.zzTj = jCurrentTimeMillis;
    }

    public String zzlJ() {
        zzjk();
        zzjv();
        String string = this.zzTh.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public zza zzlK() {
        return this.zzTk;
    }
}
