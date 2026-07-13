package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzim;
import com.google.android.gms.internal.zzin;
import com.google.android.gms.internal.zzir;
import com.prime31.util.IabHelperImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzc extends zzim implements ServiceConnection {
    private Context mContext;
    private zzgh zzAK;
    private boolean zzFB;
    private zzb zzFC;
    private zzh zzFD;
    private List<zzf> zzFE;
    private zzk zzFF;
    private final Object zzpV;

    public zzc(Context context, zzgh zzghVar, zzk zzkVar) {
        this(context, zzghVar, zzkVar, new zzb(context), zzh.zzy(context.getApplicationContext()));
    }

    zzc(Context context, zzgh zzghVar, zzk zzkVar, zzb zzbVar, zzh zzhVar) {
        this.zzpV = new Object();
        this.zzFB = false;
        this.zzFE = null;
        this.mContext = context;
        this.zzAK = zzghVar;
        this.zzFF = zzkVar;
        this.zzFC = zzbVar;
        this.zzFD = zzhVar;
        this.zzFE = this.zzFD.zzg(10L);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzin.v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzFB);
    }

    private boolean zzf(long j) {
        long jElapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (jElapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpV.wait(jElapsedRealtime);
        } catch (InterruptedException e) {
            zzin.zzaK("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.zzpV) {
            this.zzFC.zzN(service);
            zzfW();
            this.zzFB = true;
            this.zzpV.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        zzin.zzaJ("In-app billing service disconnected.");
        this.zzFC.destroy();
    }

    @Override // com.google.android.gms.internal.zzim
    public void onStop() {
        synchronized (this.zzpV) {
            com.google.android.gms.common.stats.zzb.zzrP().zza(this.mContext, this);
            this.zzFC.destroy();
        }
    }

    protected void zza(final zzf zzfVar, String str, String str2) {
        final Intent intent = new Intent();
        zzr.zzbM();
        intent.putExtra(IabHelperImpl.RESPONSE_CODE, 0);
        zzr.zzbM();
        intent.putExtra(IabHelperImpl.RESPONSE_INAPP_PURCHASE_DATA, str);
        zzr.zzbM();
        intent.putExtra(IabHelperImpl.RESPONSE_INAPP_SIGNATURE, str2);
        zzir.zzMc.post(new Runnable() { // from class: com.google.android.gms.ads.internal.purchase.zzc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zzc.this.zzFF.zza(zzfVar.zzFQ, -1, intent)) {
                        zzc.this.zzAK.zza(new zzg(zzc.this.mContext, zzfVar.zzFR, true, -1, intent, zzfVar));
                    } else {
                        zzc.this.zzAK.zza(new zzg(zzc.this.mContext, zzfVar.zzFR, false, -1, intent, zzfVar));
                    }
                } catch (RemoteException e) {
                    zzin.zzaK("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.zzim
    public void zzbr() {
        synchronized (this.zzpV) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.zzrP().zza(this.mContext, intent, this, 1);
            zze(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzrP().zza(this.mContext, this);
            this.zzFC.destroy();
        }
    }

    protected void zzfW() {
        if (this.zzFE.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        for (zzf zzfVar : this.zzFE) {
            map.put(zzfVar.zzFR, zzfVar);
        }
        String str = null;
        while (true) {
            Bundle bundleZzi = this.zzFC.zzi(this.mContext.getPackageName(), str);
            if (bundleZzi == null || zzr.zzbM().zzd(bundleZzi) != 0) {
                break;
            }
            ArrayList<String> stringArrayList = bundleZzi.getStringArrayList(IabHelperImpl.RESPONSE_INAPP_ITEM_LIST);
            ArrayList<String> stringArrayList2 = bundleZzi.getStringArrayList(IabHelperImpl.RESPONSE_INAPP_PURCHASE_DATA_LIST);
            ArrayList<String> stringArrayList3 = bundleZzi.getStringArrayList(IabHelperImpl.RESPONSE_INAPP_SIGNATURE_LIST);
            String string = bundleZzi.getString(IabHelperImpl.INAPP_CONTINUATION_TOKEN);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= stringArrayList.size()) {
                    break;
                }
                if (map.containsKey(stringArrayList.get(i2))) {
                    String str2 = stringArrayList.get(i2);
                    String str3 = stringArrayList2.get(i2);
                    String str4 = stringArrayList3.get(i2);
                    zzf zzfVar2 = (zzf) map.get(str2);
                    if (zzfVar2.zzFQ.equals(zzr.zzbM().zzaq(str3))) {
                        zza(zzfVar2, str3, str4);
                        map.remove(str2);
                    }
                }
                i = i2 + 1;
            }
            if (string == null || map.isEmpty()) {
                break;
            } else {
                str = string;
            }
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            this.zzFD.zza((zzf) map.get((String) it.next()));
        }
    }
}
