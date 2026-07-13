package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzin;
import com.prime31.util.IabHelperImpl;

/* JADX INFO: loaded from: classes.dex */
@zzhb
public class zzb {
    private final Context mContext;
    private final boolean zzFA;
    Object zzFz;

    public zzb(Context context) {
        this(context, true);
    }

    public zzb(Context context, boolean z) {
        this.mContext = context;
        this.zzFA = z;
    }

    public void destroy() {
        this.zzFz = null;
    }

    public void zzN(IBinder iBinder) {
        try {
            this.zzFz = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", IBinder.class).invoke(null, iBinder);
        } catch (Exception e) {
            if (this.zzFA) {
                zzin.zzaK("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public int zzb(int i, String str, String str2) {
        try {
            Class<?> clsLoadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) clsLoadClass.getDeclaredMethod("isBillingSupported", Integer.TYPE, String.class, String.class).invoke(clsLoadClass.cast(this.zzFz), Integer.valueOf(i), str, str2)).intValue();
        } catch (Exception e) {
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzb(String str, String str2, String str3) {
        try {
            Class<?> clsLoadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) clsLoadClass.getDeclaredMethod("getBuyIntent", Integer.TYPE, String.class, String.class, String.class, String.class).invoke(clsLoadClass.cast(this.zzFz), 3, str, str2, IabHelperImpl.ITEM_TYPE_INAPP, str3);
        } catch (Exception e) {
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public int zzh(String str, String str2) {
        try {
            Class<?> clsLoadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) clsLoadClass.getDeclaredMethod("consumePurchase", Integer.TYPE, String.class, String.class).invoke(clsLoadClass.cast(this.zzFz), 3, str, str2)).intValue();
        } catch (Exception e) {
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzi(String str, String str2) {
        try {
            Class<?> clsLoadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) clsLoadClass.getDeclaredMethod("getPurchases", Integer.TYPE, String.class, String.class, String.class).invoke(clsLoadClass.cast(this.zzFz), 3, str, IabHelperImpl.ITEM_TYPE_INAPP, str2);
        } catch (Exception e) {
            if (this.zzFA) {
                zzin.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
