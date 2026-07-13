package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

/* JADX INFO: loaded from: classes.dex */
public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzbea;
    private int zzbeb;
    private int zzbec;
    private OnPlusOneClickListener zzbed;

    protected class DefaultOnPlusOneClickListener implements View.OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzbee;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.zzbee = proxy;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.zzbea.getTag();
            if (this.zzbee != null) {
                this.zzbee.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        @Override // com.google.android.gms.plus.PlusOneButton.OnPlusOneClickListener
        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if (!(context instanceof Activity) || intent == null) {
                return;
            }
            ((Activity) context).startActivityForResult(intent, PlusOneButton.this.zzbec);
        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.zzbeb = getAnnotation(context, attrs);
        this.zzbec = -1;
        zzar(getContext());
        if (isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String strZza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(strZza)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(strZza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String strZza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(strZza)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(strZza)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(strZza) ? 2 : 3;
    }

    private void zzar(Context context) {
        if (this.zzbea != null) {
            removeView(this.zzbea);
        }
        this.zzbea = zzg.zza(context, this.mSize, this.zzbeb, this.zzF, this.zzbec);
        setOnPlusOneClickListener(this.zzbed);
        addView(this.zzbea);
    }

    public void initialize(String url, int activityRequestCode) {
        zzx.zza(getContext() instanceof Activity, "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = url;
        this.zzbec = activityRequestCode;
        zzar(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.zzF = url;
        this.zzbec = 0;
        zzar(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.zzbea.layout(0, 0, right - left, bottom - top);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.zzbea;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzbea.performClick();
    }

    public void setAnnotation(int annotation) {
        this.zzbeb = annotation;
        zzar(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzbea.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.zzbed = listener;
        this.zzbea.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        zzar(getContext());
    }
}
