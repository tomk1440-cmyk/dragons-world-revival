package com.chartboost.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public final class CBImpressionActivity extends Activity {
    public static final String PARAM_FULLSCREEN = "paramFullscreen";
    protected Chartboost a;

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        if (getIntent().getBooleanExtra(PARAM_FULLSCREEN, false)) {
            getWindow().addFlags(1024);
        }
        getWindow().setWindowAnimations(0);
        setContentView(new RelativeLayout(this));
        this.a = Chartboost.sharedChartboost();
        this.a.a(this);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.a.a((Activity) this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.a.b(this);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.a.c(this);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (!this.a.b()) {
            super.onBackPressed();
        }
    }
}
