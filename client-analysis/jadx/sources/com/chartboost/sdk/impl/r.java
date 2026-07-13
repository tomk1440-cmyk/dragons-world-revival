package com.chartboost.sdk.impl;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* JADX INFO: loaded from: classes.dex */
public class r extends Animation {
    private final float a;
    private final float b;
    private final float c;
    private final float d;
    private boolean e;
    private Camera f;

    public r(float f, float f2, float f3, float f4, boolean z) {
        this.e = true;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = z;
    }

    @Override // android.view.animation.Animation
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.f = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float f = this.a + ((this.b - this.a) * interpolatedTime);
        Camera camera = this.f;
        Matrix matrix = t.getMatrix();
        camera.save();
        if (this.e) {
            camera.rotateY(f);
        } else {
            camera.rotateX(f);
        }
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-this.c, -this.d);
        matrix.postTranslate(this.c, this.d);
    }
}
