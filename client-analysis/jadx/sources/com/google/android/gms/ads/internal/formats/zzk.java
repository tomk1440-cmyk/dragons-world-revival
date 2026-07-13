package com.google.android.gms.ads.internal.formats;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjk;
import com.google.android.gms.internal.zzjp;
import io.fabric.sdk.android.services.settings.SettingsJsonConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzk extends zzcj.zza implements View.OnClickListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private FrameLayout zzoQ;
    private final FrameLayout zzyD;
    private zzb zzyF;
    int zzyH;
    int zzyI;
    private zzh zzyf;
    private final Object zzpV = new Object();
    private Map<String, WeakReference<View>> zzyE = new HashMap();
    boolean zzyG = false;

    public zzk(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.zzyD = frameLayout;
        this.zzoQ = frameLayout2;
        zzjk.zza((View) this.zzyD, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzjk.zza((View) this.zzyD, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzyD.setOnTouchListener(this);
    }

    @Override // com.google.android.gms.internal.zzcj
    public void destroy() {
        this.zzoQ.removeAllViews();
        this.zzoQ = null;
        this.zzyE = null;
        this.zzyF = null;
        this.zzyf = null;
    }

    int getMeasuredHeight() {
        return this.zzyD.getMeasuredHeight();
    }

    int getMeasuredWidth() {
        return this.zzyD.getMeasuredWidth();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        synchronized (this.zzpV) {
            try {
                if (this.zzyf == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, WeakReference<View>> entry : this.zzyE.entrySet()) {
                    View view2 = entry.getValue().get();
                    Point pointZzj = zzj(view2);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put(SettingsJsonConstants.ICON_WIDTH_KEY, zzq(view2.getWidth()));
                        jSONObject2.put(SettingsJsonConstants.ICON_HEIGHT_KEY, zzq(view2.getHeight()));
                        jSONObject2.put("x", zzq(pointZzj.x));
                        jSONObject2.put("y", zzq(pointZzj.y));
                        jSONObject.put(entry.getKey(), jSONObject2);
                    } catch (JSONException e) {
                        zzin.zzaK("Unable to get view rectangle for view " + entry.getKey());
                    }
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("x", zzq(this.zzyH));
                    jSONObject3.put("y", zzq(this.zzyI));
                } catch (JSONException e2) {
                    zzin.zzaK("Unable to get click location");
                }
                JSONObject jSONObject4 = new JSONObject();
                try {
                    jSONObject4.put(SettingsJsonConstants.ICON_WIDTH_KEY, zzq(getMeasuredWidth()));
                    jSONObject4.put(SettingsJsonConstants.ICON_HEIGHT_KEY, zzq(getMeasuredHeight()));
                } catch (JSONException e3) {
                    zzin.zzaK("Unable to get native ad view bounding box");
                }
                if (this.zzyF == null || !this.zzyF.zzdI().equals(view)) {
                    this.zzyf.zza(view, this.zzyE, jSONObject, jSONObject3, jSONObject4);
                } else {
                    this.zzyf.zza("1007", jSONObject, jSONObject3, jSONObject4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        synchronized (this.zzpV) {
            if (this.zzyG) {
                int measuredWidth = getMeasuredWidth();
                int measuredHeight = getMeasuredHeight();
                if (measuredWidth != 0 && measuredHeight != 0) {
                    this.zzoQ.setLayoutParams(new FrameLayout.LayoutParams(measuredWidth, measuredHeight));
                    this.zzyG = false;
                }
            }
            if (this.zzyf != null) {
                this.zzyf.zzh(this.zzyD);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public void onScrollChanged() {
        synchronized (this.zzpV) {
            if (this.zzyf != null) {
                this.zzyf.zzh(this.zzyD);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        synchronized (this.zzpV) {
            if (this.zzyf != null) {
                Point pointZzc = zzc(motionEvent);
                this.zzyH = pointZzc.x;
                this.zzyI = pointZzc.y;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.setLocation(pointZzc.x, pointZzc.y);
                this.zzyf.zzb(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.zzcj
    public com.google.android.gms.dynamic.zzd zzK(String str) {
        com.google.android.gms.dynamic.zzd zzdVarZzC;
        synchronized (this.zzpV) {
            WeakReference<View> weakReference = this.zzyE.get(str);
            zzdVarZzC = com.google.android.gms.dynamic.zze.zzC(weakReference == null ? null : weakReference.get());
        }
        return zzdVarZzC;
    }

    @Override // com.google.android.gms.internal.zzcj
    public void zza(com.google.android.gms.dynamic.zzd zzdVar) {
        synchronized (this.zzpV) {
            this.zzyG = true;
            zzi(null);
            Object objZzp = com.google.android.gms.dynamic.zze.zzp(zzdVar);
            if (!(objZzp instanceof zzi)) {
                zzin.zzaK("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            final zzi zziVar = (zzi) objZzp;
            if ((this.zzyf instanceof zzg) && ((zzg) this.zzyf).zzdP()) {
                ((zzg) this.zzyf).zzc((zzh) zziVar);
            } else {
                this.zzyf = zziVar;
                if (this.zzyf instanceof zzg) {
                    ((zzg) this.zzyf).zzc((zzh) null);
                }
            }
            this.zzoQ.removeAllViews();
            this.zzyF = zzd(zziVar);
            if (this.zzyF != null) {
                this.zzyE.put("1007", new WeakReference<>(this.zzyF.zzdI()));
                this.zzoQ.addView(this.zzyF);
            }
            zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.formats.zzk.1
                @Override // java.lang.Runnable
                public void run() {
                    zzjp zzjpVarZzdR = zziVar.zzdR();
                    if (zzjpVarZzdR != null) {
                        zzk.this.zzoQ.addView(zzjpVarZzdR.getView());
                    }
                }
            });
            zziVar.zzg(this.zzyD);
            zzi(this.zzyD);
        }
    }

    @Override // com.google.android.gms.internal.zzcj
    public void zza(String str, com.google.android.gms.dynamic.zzd zzdVar) {
        View view = (View) com.google.android.gms.dynamic.zze.zzp(zzdVar);
        synchronized (this.zzpV) {
            try {
                if (view == null) {
                    this.zzyE.remove(str);
                } else {
                    this.zzyE.put(str, new WeakReference<>(view));
                    view.setOnTouchListener(this);
                    view.setOnClickListener(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    Point zzc(MotionEvent motionEvent) {
        int[] iArr = new int[2];
        this.zzyD.getLocationOnScreen(iArr);
        return new Point((int) (motionEvent.getRawX() - iArr[0]), (int) (motionEvent.getRawY() - iArr[1]));
    }

    zzb zzd(zzi zziVar) {
        return zziVar.zza(this);
    }

    void zzi(View view) {
        if (this.zzyf != null) {
            zzh zzhVarZzdQ = this.zzyf instanceof zzg ? ((zzg) this.zzyf).zzdQ() : this.zzyf;
            if (zzhVarZzdQ != null) {
                zzhVarZzdQ.zzi(view);
            }
        }
    }

    Point zzj(View view) {
        if (this.zzyF == null || !this.zzyF.zzdI().equals(view)) {
            Point point = new Point();
            view.getGlobalVisibleRect(new Rect(), point);
            return point;
        }
        Point point2 = new Point();
        this.zzyD.getGlobalVisibleRect(new Rect(), point2);
        Point point3 = new Point();
        view.getGlobalVisibleRect(new Rect(), point3);
        return new Point(point3.x - point2.x, point3.y - point2.y);
    }

    int zzq(int i) {
        return zzn.zzcS().zzc(this.zzyf.getContext(), i);
    }
}
