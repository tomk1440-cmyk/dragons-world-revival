package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzgo implements Runnable {
    private final Handler zzGj;
    private final long zzGk;
    private long zzGl;
    private zzjq.zza zzGm;
    protected boolean zzGn;
    protected boolean zzGo;
    private final int zzoG;
    private final int zzoH;
    protected final zzjp zzpD;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzGp;
        private Bitmap zzGq;

        public zza(WebView webView) {
            this.zzGp = webView;
        }

        @Override // android.os.AsyncTask
        protected synchronized void onPreExecute() {
            this.zzGq = Bitmap.createBitmap(zzgo.this.zzoG, zzgo.this.zzoH, Bitmap.Config.ARGB_8888);
            this.zzGp.setVisibility(0);
            this.zzGp.measure(View.MeasureSpec.makeMeasureSpec(zzgo.this.zzoG, 0), View.MeasureSpec.makeMeasureSpec(zzgo.this.zzoH, 0));
            this.zzGp.layout(0, 0, zzgo.this.zzoG, zzgo.this.zzoH);
            this.zzGp.draw(new Canvas(this.zzGq));
            this.zzGp.invalidate();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean zValueOf;
            int width = this.zzGq.getWidth();
            int height = this.zzGq.getHeight();
            if (width == 0 || height == 0) {
                zValueOf = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzGq.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                zValueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return zValueOf;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            zzgo.zzc(zzgo.this);
            if (bool.booleanValue() || zzgo.this.zzgg() || zzgo.this.zzGl <= 0) {
                zzgo.this.zzGo = bool.booleanValue();
                zzgo.this.zzGm.zza(zzgo.this.zzpD, true);
            } else if (zzgo.this.zzGl > 0) {
                if (zzin.zzQ(2)) {
                    zzin.zzaI("Ad not detected, scheduling another run.");
                }
                zzgo.this.zzGj.postDelayed(zzgo.this, zzgo.this.zzGk);
            }
        }
    }

    public zzgo(zzjq.zza zzaVar, zzjp zzjpVar, int i, int i2) {
        this(zzaVar, zzjpVar, i, i2, 200L, 50L);
    }

    public zzgo(zzjq.zza zzaVar, zzjp zzjpVar, int i, int i2, long j, long j2) {
        this.zzGk = j;
        this.zzGl = j2;
        this.zzGj = new Handler(Looper.getMainLooper());
        this.zzpD = zzjpVar;
        this.zzGm = zzaVar;
        this.zzGn = false;
        this.zzGo = false;
        this.zzoH = i2;
        this.zzoG = i;
    }

    static /* synthetic */ long zzc(zzgo zzgoVar) {
        long j = zzgoVar.zzGl - 1;
        zzgoVar.zzGl = j;
        return j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.zzpD == null || zzgg()) {
            this.zzGm.zza(this.zzpD, true);
        } else {
            new zza(this.zzpD.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzjy(this, this.zzpD, adResponseParcel.zzIa));
    }

    public void zza(AdResponseParcel adResponseParcel, zzjy zzjyVar) {
        this.zzpD.setWebViewClient(zzjyVar);
        this.zzpD.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzEF) ? null : com.google.android.gms.ads.internal.zzr.zzbC().zzaC(adResponseParcel.zzEF), adResponseParcel.body, "text/html", "UTF-8", null);
    }

    public void zzge() {
        this.zzGj.postDelayed(this, this.zzGk);
    }

    public synchronized void zzgf() {
        this.zzGn = true;
    }

    public synchronized boolean zzgg() {
        return this.zzGn;
    }

    public boolean zzgh() {
        return this.zzGo;
    }
}
