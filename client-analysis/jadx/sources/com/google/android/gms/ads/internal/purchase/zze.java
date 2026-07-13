package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.prime31.util.IabHelperImpl;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zze extends zzge.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzFC;
    zzh zzFD;
    private zzk zzFF;
    private Context zzFK;
    private zzgc zzFL;
    private zzf zzFM;
    private zzj zzFN;
    private String zzFO = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzFD = zzh.zzy(this.mActivity.getApplicationContext());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[Catch: RemoteException -> 0x003f, all -> 0x004d, Merged into TryCatch #1 {all -> 0x004d, RemoteException -> 0x003f, blocks: (B:5:0x0006, B:7:0x0011, B:9:0x0016, B:12:0x0021, B:15:0x0037, B:18:0x0040), top: B:23:0x0006 }, TRY_ENTER, TRY_LEAVE] */
    @Override // com.google.android.gms.internal.zzge
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            boolean z = false;
            try {
                int iZzd = zzr.zzbM().zzd(data);
                if (resultCode == -1) {
                    zzr.zzbM();
                    if (iZzd != 0) {
                        this.zzFD.zza(this.zzFM);
                    } else if (this.zzFF.zza(this.zzFO, resultCode, data)) {
                        z = true;
                    }
                } else {
                    this.zzFD.zza(this.zzFM);
                }
                this.zzFL.recordPlayBillingResolution(iZzd);
                this.mActivity.finish();
                zza(this.zzFL.getProductId(), z, resultCode, data);
            } catch (RemoteException e) {
                zzin.zzaK("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzFO = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzge
    public void onCreate() {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcelZzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzFN = gInAppPurchaseManagerInfoParcelZzc.zzFy;
        this.zzFF = gInAppPurchaseManagerInfoParcelZzc.zzrI;
        this.zzFL = gInAppPurchaseManagerInfoParcelZzc.zzFw;
        this.zzFC = new zzb(this.mActivity.getApplicationContext());
        this.zzFK = gInAppPurchaseManagerInfoParcelZzc.zzFx;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhv());
        } else {
            this.mActivity.setRequestedOrientation(zzr.zzbE().zzhw());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.mActivity.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzge
    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzFC.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.zzFC.zzN(service);
        try {
            this.zzFO = this.zzFF.zzfZ();
            Bundle bundleZzb = this.zzFC.zzb(this.mActivity.getPackageName(), this.zzFL.getProductId(), this.zzFO);
            PendingIntent pendingIntent = (PendingIntent) bundleZzb.getParcelable(IabHelperImpl.RESPONSE_BUY_INTENT);
            if (pendingIntent == null) {
                int iZzd = zzr.zzbM().zzd(bundleZzb);
                this.zzFL.recordPlayBillingResolution(iZzd);
                zza(this.zzFL.getProductId(), false, iZzd, null);
                this.mActivity.finish();
            } else {
                this.zzFM = new zzf(this.zzFL.getProductId(), this.zzFO);
                this.zzFD.zzb(this.zzFM);
                Integer num = 0;
                Integer num2 = 0;
                Integer num3 = 0;
                this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            zzin.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzFN != null) {
            this.zzFN.zza(str, z, i, intent, this.zzFM);
        }
    }
}
