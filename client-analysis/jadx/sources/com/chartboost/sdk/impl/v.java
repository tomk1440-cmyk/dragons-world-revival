package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBOrientation;

/* JADX INFO: loaded from: classes.dex */
public class v extends AbsoluteLayout {
    private Matrix a;
    private Matrix b;
    private float[] c;
    private View d;
    private RelativeLayout e;

    public v(Context context) {
        super(context);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new float[2];
        this.e = new RelativeLayout(context);
        addView(this.e, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        this.d = this.e;
    }

    public void a(View view) {
        a(view, new RelativeLayout.LayoutParams(-2, -2));
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (this.e != null) {
            this.e.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("cannot call addViewToContainer() on CBRotatableContainer that was set up with a default view");
    }

    public v(Context context, View view) {
        super(context);
        this.a = new Matrix();
        this.b = new Matrix();
        this.c = new float[2];
        addView(view, new AbsoluteLayout.LayoutParams(-1, -1, 0, 0));
        this.d = view;
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        CBOrientation.Difference forcedOrientationDifference = Chartboost.sharedChartboost().getForcedOrientationDifference();
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = forcedOrientationDifference.isOdd() ? h : w;
        if (!forcedOrientationDifference.isOdd()) {
            w = h;
        }
        layoutParams.height = w;
        this.d.setLayoutParams(layoutParams);
        this.d.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        this.d.layout(0, 0, layoutParams.width, layoutParams.height);
    }

    @Override // android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (Chartboost.sharedChartboost().getForcedOrientationDifference().isOdd()) {
            super.onMeasure(heightMeasureSpec, widthMeasureSpec);
            setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        CBOrientation.Difference forcedOrientationDifference = Chartboost.sharedChartboost().getForcedOrientationDifference();
        int asInt = forcedOrientationDifference.getAsInt();
        if (forcedOrientationDifference == CBOrientation.Difference.ANGLE_0) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipRect(0.0f, 0.0f, getWidth(), getHeight(), Region.Op.REPLACE);
        try {
            ViewGroup viewGroup = (ViewGroup) getParent();
            try {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if ((viewGroup2 instanceof ScrollView) || (viewGroup2 instanceof HorizontalScrollView)) {
                    viewGroup = viewGroup2;
                }
            } catch (Exception e) {
            }
            int left = getLeft() - viewGroup.getScrollX();
            int top = getTop() - viewGroup.getScrollY();
            canvas.clipRect(0 - left, 0 - top, viewGroup.getWidth() - left, viewGroup.getHeight() - top, Region.Op.INTERSECT);
        } catch (Exception e2) {
        }
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.rotate(asInt);
        if (forcedOrientationDifference.isOdd()) {
            canvas.translate((-getHeight()) / 2.0f, (-getWidth()) / 2.0f);
        } else {
            canvas.translate((-getWidth()) / 2.0f, (-getHeight()) / 2.0f);
        }
        this.a = canvas.getMatrix();
        this.a.invert(this.b);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (Chartboost.sharedChartboost().getForcedOrientationDifference() == CBOrientation.Difference.ANGLE_0) {
            return super.dispatchTouchEvent(event);
        }
        float[] fArr = this.c;
        fArr[0] = event.getRawX();
        fArr[1] = event.getRawY();
        this.b.mapPoints(fArr);
        event.setLocation(fArr[0], fArr[1]);
        return super.dispatchTouchEvent(event);
    }

    public View a() {
        return this.d;
    }
}
