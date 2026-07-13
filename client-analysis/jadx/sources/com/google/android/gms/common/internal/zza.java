package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class zza extends zzp.zza {
    private Context mContext;
    private Account zzTI;
    int zzakz;

    public static Account zza(zzp zzpVar) {
        Account account = null;
        if (zzpVar != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = zzpVar.getAccount();
            } catch (RemoteException e) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return account;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof zza) {
            return this.zzTI.equals(((zza) o).zzTI);
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.zzp
    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.zzakz) {
            return this.zzTI;
        }
        if (!com.google.android.gms.common.zze.zzf(this.mContext, callingUid)) {
            throw new SecurityException("Caller is not GooglePlayServices");
        }
        this.zzakz = callingUid;
        return this.zzTI;
    }
}
