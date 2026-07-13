package com.chartboost.sdk.impl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.CBOrientation;

/* JADX INFO: loaded from: classes.dex */
public class u extends RelativeLayout {
    private View a;
    private q b;
    private OrientationEventListener c;
    private CBOrientation.Difference d;

    public interface a {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Context context, a aVar) {
        super(context);
        this.d = null;
        this.a = (View) aVar;
        this.b = new q(context);
        addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
        Chartboost chartboostSharedChartboost = Chartboost.sharedChartboost();
        if (chartboostSharedChartboost.getOrientation() != null && chartboostSharedChartboost.getOrientation() != CBOrientation.UNSPECIFIED) {
            this.d = Chartboost.sharedChartboost().getForcedOrientationDifference();
            this.c = new OrientationEventListener(context, 1) { // from class: com.chartboost.sdk.impl.u.1
                @Override // android.view.OrientationEventListener
                public void onOrientationChanged(int orientation) {
                    CBOrientation.Difference forcedOrientationDifference = Chartboost.sharedChartboost().getForcedOrientationDifference();
                    if (u.this.d != forcedOrientationDifference) {
                        u.this.d = forcedOrientationDifference;
                        ((a) u.this.a).a();
                        u.this.invalidate();
                    }
                }
            };
            this.c.enable();
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.chartboost.sdk.impl.u.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    public void a() {
        if (this.c != null) {
            this.c.disable();
            this.c = null;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }

    public q b() {
        return this.b;
    }

    public View c() {
        return this.a;
    }
}
