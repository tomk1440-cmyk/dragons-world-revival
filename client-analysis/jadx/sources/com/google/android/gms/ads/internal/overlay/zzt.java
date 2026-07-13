package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zziv;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzt {
    private final Context mContext;
    private final String zzEY;
    private final VersionInfoParcel zzEZ;

    @Nullable
    private final zzbz zzFa;

    @Nullable
    private final zzcb zzFb;
    private final long[] zzFd;
    private final String[] zzFe;

    @Nullable
    private zzbz zzFf;

    @Nullable
    private zzbz zzFg;

    @Nullable
    private zzbz zzFh;

    @Nullable
    private zzbz zzFi;
    private boolean zzFj;
    private zzi zzFk;
    private boolean zzFl;
    private boolean zzFm;
    private final zziv zzFc = new zziv.zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzhA();
    private long zzFn = -1;

    public zzt(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzcb zzcbVar, @Nullable zzbz zzbzVar) {
        this.mContext = context;
        this.zzEZ = versionInfoParcel;
        this.zzEY = str;
        this.zzFb = zzcbVar;
        this.zzFa = zzbzVar;
        String str2 = zzbt.zzvV.get();
        if (str2 == null) {
            this.zzFe = new String[0];
            this.zzFd = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        this.zzFe = new String[strArrSplit.length];
        this.zzFd = new long[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                this.zzFd[i] = Long.parseLong(strArrSplit[i]);
            } catch (NumberFormatException e) {
                zzin.zzd("Unable to parse frame hash target time number.", e);
                this.zzFd[i] = -1;
            }
        }
    }

    private void zzc(zzi zziVar) {
        long jLongValue = zzbt.zzvW.get().longValue();
        long currentPosition = zziVar.getCurrentPosition();
        for (int i = 0; i < this.zzFe.length; i++) {
            if (this.zzFe[i] == null && jLongValue > Math.abs(currentPosition - this.zzFd[i])) {
                this.zzFe[i] = zza((TextureView) zziVar);
                return;
            }
        }
    }

    private void zzfN() {
        if (this.zzFh != null && this.zzFi == null) {
            zzbx.zza(this.zzFb, this.zzFh, "vff");
            zzbx.zza(this.zzFb, this.zzFa, "vtt");
            this.zzFi = zzbx.zzb(this.zzFb);
        }
        long jNanoTime = com.google.android.gms.ads.internal.zzr.zzbG().nanoTime();
        if (this.zzFj && this.zzFm && this.zzFn != -1) {
            this.zzFc.zza(TimeUnit.SECONDS.toNanos(1L) / (jNanoTime - this.zzFn));
        }
        this.zzFm = this.zzFj;
        this.zzFn = jNanoTime;
    }

    public void onStop() {
        if (!zzbt.zzvU.get().booleanValue() || this.zzFl) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.MEDIA_TYPE, "native-player-metrics");
        bundle.putString(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.zzEY);
        bundle.putString("player", this.zzFk.zzeZ());
        for (zziv.zza zzaVar : this.zzFc.getBuckets()) {
            bundle.putString("fps_c_" + zzaVar.name, Integer.toString(zzaVar.count));
            bundle.putString("fps_p_" + zzaVar.name, Double.toString(zzaVar.zzMu));
        }
        for (int i = 0; i < this.zzFd.length; i++) {
            String str = this.zzFe[i];
            if (str != null) {
                bundle.putString("fh_" + Long.valueOf(this.zzFd[i]), str);
            }
        }
        com.google.android.gms.ads.internal.zzr.zzbC().zza(this.mContext, this.zzEZ.afmaVersion, "gmob-apps", bundle, true);
        this.zzFl = true;
    }

    String zza(TextureView textureView) {
        long j;
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j2 = 0;
        long j3 = 63;
        int i = 0;
        while (i < 8) {
            int i2 = 0;
            long j4 = j2;
            while (true) {
                j = j3;
                int i3 = i2;
                if (i3 < 8) {
                    int pixel = bitmap.getPixel(i3, i);
                    j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1L : 0L) << ((int) j);
                    i2 = i3 + 1;
                    j3 = j - 1;
                }
            }
            i++;
            j3 = j;
            j2 = j4;
        }
        return String.format("%016X", Long.valueOf(j2));
    }

    public void zza(zzi zziVar) {
        zzbx.zza(this.zzFb, this.zzFa, "vpc");
        this.zzFf = zzbx.zzb(this.zzFb);
        this.zzFk = zziVar;
    }

    public void zzb(zzi zziVar) {
        zzfN();
        zzc(zziVar);
    }

    public void zzfO() {
        this.zzFj = true;
        if (this.zzFg == null || this.zzFh != null) {
            return;
        }
        zzbx.zza(this.zzFb, this.zzFg, "vfp");
        this.zzFh = zzbx.zzb(this.zzFb);
    }

    public void zzfP() {
        this.zzFj = false;
    }

    public void zzfz() {
        if (this.zzFf == null || this.zzFg != null) {
            return;
        }
        zzbx.zza(this.zzFb, this.zzFf, "vfr");
        this.zzFg = zzbx.zzb(this.zzFb);
    }
}
