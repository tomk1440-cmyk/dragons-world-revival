package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;

/* JADX INFO: loaded from: classes.dex */
public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private zzge zzOw;

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (this.zzOw != null) {
                this.zzOw.onActivityResult(requestCode, resultCode, data);
            }
        } catch (RemoteException e) {
            zzin.zzd("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzOw = zzgj.createInAppPurchaseManager(this);
        if (this.zzOw == null) {
            zzin.zzaK("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.zzOw.onCreate();
        } catch (RemoteException e) {
            zzin.zzd("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.zzOw != null) {
                this.zzOw.onDestroy();
            }
        } catch (RemoteException e) {
            zzin.zzd("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
