package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.zzpz;

/* JADX INFO: loaded from: classes.dex */
class zzs {
    final boolean zzaWY;
    final int zzaWZ;
    long zzaXa;
    float zzaXb;
    long zzaXc;
    float zzaXd;
    long zzaXe;
    float zzaXf;
    final boolean zzaXg;

    /* JADX WARN: Code duplicated, block: B:36:0x0093  */
    public zzs(zzpz.zzd zzdVar) {
        boolean z;
        com.google.android.gms.common.internal.zzx.zzz(zzdVar);
        if (zzdVar.zzaZF == null || zzdVar.zzaZF.intValue() == 0) {
            z = false;
        } else if (zzdVar.zzaZF.intValue() != 4) {
            if (zzdVar.zzaZH == null) {
                z = false;
            } else {
                z = true;
            }
        } else if (zzdVar.zzaZI == null || zzdVar.zzaZJ == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.zzaWZ = zzdVar.zzaZF.intValue();
            this.zzaWY = zzdVar.zzaZG != null && zzdVar.zzaZG.booleanValue();
            if (zzdVar.zzaZF.intValue() == 4) {
                if (this.zzaWY) {
                    this.zzaXd = Float.parseFloat(zzdVar.zzaZI);
                    this.zzaXf = Float.parseFloat(zzdVar.zzaZJ);
                } else {
                    this.zzaXc = Long.parseLong(zzdVar.zzaZI);
                    this.zzaXe = Long.parseLong(zzdVar.zzaZJ);
                }
            } else if (this.zzaWY) {
                this.zzaXb = Float.parseFloat(zzdVar.zzaZH);
            } else {
                this.zzaXa = Long.parseLong(zzdVar.zzaZH);
            }
        } else {
            this.zzaWZ = 0;
            this.zzaWY = false;
        }
        this.zzaXg = z;
    }

    public Boolean zzac(long j) {
        if (this.zzaXg && !this.zzaWY) {
            switch (this.zzaWZ) {
                case 1:
                    return Boolean.valueOf(j < this.zzaXa);
                case 2:
                    return Boolean.valueOf(j > this.zzaXa);
                case 3:
                    return Boolean.valueOf(j == this.zzaXa);
                case 4:
                    return Boolean.valueOf(j >= this.zzaXc && j <= this.zzaXe);
                default:
                    return null;
            }
        }
        return null;
    }

    public Boolean zzi(float f) {
        if (this.zzaXg && this.zzaWY) {
            switch (this.zzaWZ) {
                case 1:
                    return Boolean.valueOf(f < this.zzaXb);
                case 2:
                    return Boolean.valueOf(f > this.zzaXb);
                case 3:
                    return Boolean.valueOf(f == this.zzaXb || Math.abs(f - this.zzaXb) < 2.0f * Math.max(Math.ulp(f), Math.ulp(this.zzaXb)));
                case 4:
                    return Boolean.valueOf(f >= this.zzaXd && f <= this.zzaXf);
                default:
                    return null;
            }
        }
        return null;
    }
}
