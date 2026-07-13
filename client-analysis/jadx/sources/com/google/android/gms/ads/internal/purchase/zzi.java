package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.prime31.util.IabHelperImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzi {
    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.zza(intent, gInAppPurchaseManagerInfoParcel);
        zzr.zzbC().zzb(context, intent);
    }

    public String zzaq(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("developerPayload");
        } catch (JSONException e) {
            zzin.zzaK("Fail to parse purchase data");
            return null;
        }
    }

    public String zzar(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("purchaseToken");
        } catch (JSONException e) {
            zzin.zzaK("Fail to parse purchase data");
            return null;
        }
    }

    public int zzd(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get(IabHelperImpl.RESPONSE_CODE);
        if (obj == null) {
            zzin.zzaK("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        zzin.zzaK("Unexpected type for intent response code. " + obj.getClass().getName());
        return 5;
    }

    public int zzd(Bundle bundle) {
        Object obj = bundle.get(IabHelperImpl.RESPONSE_CODE);
        if (obj == null) {
            zzin.zzaK("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return (int) ((Long) obj).longValue();
        }
        zzin.zzaK("Unexpected type for intent response code. " + obj.getClass().getName());
        return 5;
    }

    public String zze(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra(IabHelperImpl.RESPONSE_INAPP_PURCHASE_DATA);
    }

    public String zzf(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra(IabHelperImpl.RESPONSE_INAPP_SIGNATURE);
    }

    public void zzz(final Context context) {
        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.google.android.gms.ads.internal.purchase.zzi.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                zzb zzbVar = new zzb(context.getApplicationContext(), false);
                zzbVar.zzN(service);
                zzr.zzbF().zzC(zzbVar.zzb(3, context.getPackageName(), IabHelperImpl.ITEM_TYPE_INAPP) == 0);
                context.unbindService(this);
                zzbVar.destroy();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, serviceConnection, 1);
    }
}
