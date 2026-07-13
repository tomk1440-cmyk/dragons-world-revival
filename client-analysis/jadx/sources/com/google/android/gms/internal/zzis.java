package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
@zzhb
@TargetApi(8)
public class zzis {

    @TargetApi(9)
    public static class zza extends zzis {
        public zza() {
            super();
        }

        @Override // com.google.android.gms.internal.zzis
        public boolean zza(DownloadManager.Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        @Override // com.google.android.gms.internal.zzis
        public int zzhv() {
            return 6;
        }

        @Override // com.google.android.gms.internal.zzis
        public int zzhw() {
            return 7;
        }
    }

    @TargetApi(11)
    public static class zzb extends zza {
        @Override // com.google.android.gms.internal.zzis.zza, com.google.android.gms.internal.zzis
        public boolean zza(DownloadManager.Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        @Override // com.google.android.gms.internal.zzis
        public boolean zza(final Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            if (((File) zzjb.zzb(new Callable<File>() { // from class: com.google.android.gms.internal.zzis.zzb.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zzhz, reason: merged with bridge method [inline-methods] */
                public File call() {
                    return context.getCacheDir();
                }
            })) != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0L);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webSettings.setAllowContentAccess(false);
            return true;
        }

        @Override // com.google.android.gms.internal.zzis
        public boolean zza(Window window) {
            window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            return true;
        }

        @Override // com.google.android.gms.internal.zzis
        public zzjq zzb(zzjp zzjpVar, boolean z) {
            return new zzjw(zzjpVar, z);
        }

        @Override // com.google.android.gms.internal.zzis
        public Set<String> zzf(Uri uri) {
            return uri.getQueryParameterNames();
        }

        @Override // com.google.android.gms.internal.zzis
        public WebChromeClient zzk(zzjp zzjpVar) {
            return new zzjv(zzjpVar);
        }

        @Override // com.google.android.gms.internal.zzis
        public boolean zzm(View view) {
            view.setLayerType(0, null);
            return true;
        }

        @Override // com.google.android.gms.internal.zzis
        public boolean zzn(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    @TargetApi(14)
    public static class zzc extends zzb {
        @Override // com.google.android.gms.internal.zzis
        public String zza(SslError sslError) {
            return sslError.getUrl();
        }

        @Override // com.google.android.gms.internal.zzis.zzb, com.google.android.gms.internal.zzis
        public WebChromeClient zzk(zzjp zzjpVar) {
            return new zzjx(zzjpVar);
        }
    }

    @TargetApi(17)
    public static class zzd extends zzf {
        @Override // com.google.android.gms.internal.zzis
        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        @Override // com.google.android.gms.internal.zzis
        public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
                RenderScript renderScriptCreate = RenderScript.create(context);
                ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
                Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
                Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
                scriptIntrinsicBlurCreate.setRadius(f);
                scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
                scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
                allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
                return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        @Override // com.google.android.gms.internal.zzis.zzf, com.google.android.gms.internal.zzis.zzb, com.google.android.gms.internal.zzis
        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    @TargetApi(18)
    public static class zze extends zzd {
        @Override // com.google.android.gms.internal.zzis
        public boolean isAttachedToWindow(View view) {
            return super.isAttachedToWindow(view) || view.getWindowId() != null;
        }

        @Override // com.google.android.gms.internal.zzis
        public int zzhx() {
            return 14;
        }
    }

    @TargetApi(16)
    public static class zzf extends zzc {
        @Override // com.google.android.gms.internal.zzis
        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @Override // com.google.android.gms.internal.zzis
        public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        @Override // com.google.android.gms.internal.zzis.zzb, com.google.android.gms.internal.zzis
        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }

        @Override // com.google.android.gms.internal.zzis
        public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
                return;
            }
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    @TargetApi(19)
    public static class zzg extends zze {
        @Override // com.google.android.gms.internal.zzis.zze, com.google.android.gms.internal.zzis
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        @Override // com.google.android.gms.internal.zzis
        public ViewGroup.LayoutParams zzhy() {
            return new ViewGroup.LayoutParams(-1, -1);
        }
    }

    private zzis() {
    }

    public static zzis zzP(int i) {
        if (i >= 19) {
            return new zzg();
        }
        if (i >= 18) {
            return new zze();
        }
        if (i >= 17) {
            return new zzd();
        }
        if (i >= 16) {
            return new zzf();
        }
        if (i >= 14) {
            return new zzc();
        }
        if (i >= 11) {
            return new zzb();
        }
        return i >= 9 ? new zza() : new zzis();
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return "";
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(DownloadManager.Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public zzjq zzb(zzjp zzjpVar, boolean z) {
        return new zzjq(zzjpVar, z);
    }

    public void zzb(Activity activity, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window == null || window.getDecorView() == null || window.getDecorView().getViewTreeObserver() == null) {
            return;
        }
        zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
    }

    public Set<String> zzf(Uri uri) {
        String encodedQuery;
        if (!uri.isOpaque() && (encodedQuery = uri.getEncodedQuery()) != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int iIndexOf = encodedQuery.indexOf(38, i);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, iIndexOf2)));
                i = iIndexOf + 1;
            } while (i < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return Collections.emptySet();
    }

    public int zzhv() {
        return 0;
    }

    public int zzhw() {
        return 1;
    }

    public int zzhx() {
        return 5;
    }

    public ViewGroup.LayoutParams zzhy() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public boolean zzi(zzjp zzjpVar) {
        if (zzjpVar == null) {
            return false;
        }
        zzjpVar.onPause();
        return true;
    }

    public boolean zzj(zzjp zzjpVar) {
        if (zzjpVar == null) {
            return false;
        }
        zzjpVar.onResume();
        return true;
    }

    public WebChromeClient zzk(zzjp zzjpVar) {
        return null;
    }

    public boolean zzm(View view) {
        return false;
    }

    public boolean zzn(View view) {
        return false;
    }
}
