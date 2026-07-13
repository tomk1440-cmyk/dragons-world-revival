package com.google.android.gms.common.data;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzajw;
    private ArrayList<Integer> zzajx;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
        this.zzajw = false;
    }

    private void zzqh() {
        synchronized (this) {
            if (!this.zzajw) {
                int count = this.zzahi.getCount();
                this.zzajx = new ArrayList<>();
                if (count > 0) {
                    this.zzajx.add(0);
                    String strZzqg = zzqg();
                    String strZzd = this.zzahi.zzd(strZzqg, 0, this.zzahi.zzbH(0));
                    int i = 1;
                    while (i < count) {
                        int iZzbH = this.zzahi.zzbH(i);
                        String strZzd2 = this.zzahi.zzd(strZzqg, i, iZzbH);
                        if (strZzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + strZzqg + ", at row: " + i + ", for window: " + iZzbH);
                        }
                        if (strZzd2.equals(strZzd)) {
                            strZzd2 = strZzd;
                        } else {
                            this.zzajx.add(Integer.valueOf(i));
                        }
                        i++;
                        strZzd = strZzd2;
                    }
                }
                this.zzajw = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final T get(int position) {
        zzqh();
        return zzk(zzbK(position), zzbL(position));
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public int getCount() {
        zzqh();
        return this.zzajx.size();
    }

    int zzbK(int i) {
        if (i < 0 || i >= this.zzajx.size()) {
            throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
        }
        return this.zzajx.get(i).intValue();
    }

    protected int zzbL(int i) {
        if (i < 0 || i == this.zzajx.size()) {
            return 0;
        }
        int count = i == this.zzajx.size() + (-1) ? this.zzahi.getCount() - this.zzajx.get(i).intValue() : this.zzajx.get(i + 1).intValue() - this.zzajx.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int iZzbK = zzbK(i);
        int iZzbH = this.zzahi.zzbH(iZzbK);
        String strZzqi = zzqi();
        if (strZzqi == null || this.zzahi.zzd(strZzqi, iZzbK, iZzbH) != null) {
            return count;
        }
        return 0;
    }

    protected abstract T zzk(int i, int i2);

    protected abstract String zzqg();

    protected String zzqi() {
        return null;
    }
}
